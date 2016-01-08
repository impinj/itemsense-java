/*
 * IMPINJ CONFIDENTIAL AND PROPRIETARY
 *
 * This source code is the sole property of Impinj, Inc. Reproduction or
 * utilization of this source code in whole or in part is forbidden without
 * the prior written consent of Impinj, Inc.
 *
 * (c) Copyright Impinj, Inc. 2015. All rights reserved.
 */

package com.impinj.itemsense.integration.client;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeoutException;
import java.util.function.Consumer;

public class EventConsumer<T> extends DefaultConsumer {
  protected final String queueName;
  protected final ObjectMapper objectMapper;
  protected final Consumer<T> itemProcessor;
  protected final Connection connection;
  protected final JavaType itemType;

  private EventConsumer(String queueName, Class<T> cls, ObjectMapper objectMapper,
                        Consumer<T> itemProcessor, Channel channel, Connection connection) {
    super(channel);
    this.queueName = queueName;
    this.objectMapper = objectMapper;
    this.itemProcessor = itemProcessor;
    this.connection = connection;
    this.itemType = objectMapper.getTypeFactory().constructType(cls);
  }

  public static <S> EventConsumer<S> run(QueueConfiguration queueConfiguration, int numWorkers,
                                         Class<S> cls, ObjectMapper objectMapper,
                                         Consumer<S> processItem, String restUser,
                                         String restPassword) throws Exception {
    ConnectionFactory connectionFactory = new ConnectionFactory();
    connectionFactory.setUri(queueConfiguration.getServerUrl());
    connectionFactory.setAutomaticRecoveryEnabled(true);
    connectionFactory.setUsername(restUser);
    connectionFactory.setPassword(restPassword);

    ExecutorService workers = Executors
        .newFixedThreadPool(numWorkers, new ThreadFactoryBuilder().setDaemon(true).build());
    Connection connection = connectionFactory.newConnection(workers);

    Channel channel = connection.createChannel();
    channel.basicQos(
        10); // limit how much each thread grabs, which makes multi-threading more efficient

    EventConsumer<S> consumer =
        new EventConsumer<>(queueConfiguration.getQueue(), cls, objectMapper, processItem, channel,
                            connection);
    channel.basicConsume(queueConfiguration.getQueue(), true, "tag", consumer);
    return consumer;
  }

  @Override
  public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties,
                             byte[] body) throws IOException {
    T item;
    try {
      // http://stackoverflow.com/questions/11664894/jackson-deserialize-using-generic-class
      item = objectMapper.readValue(body, itemType);
    } catch (Exception ex) {
      System.out.println(
          String.format("Unexpected item on queue %s: %s (%s)", queueName, ex, new String(body)));
      ex.printStackTrace();
      return;
    }

    try {
      itemProcessor.accept(item);
    } catch (Exception ex) {
      System.out.println(String.format("Exception on queue %s: %s", queueName, ex));
      ex.printStackTrace();
    }
  }

  public void stop() {
    try {
      getChannel().close();
    } catch (IOException | TimeoutException ex) {
      throw new RuntimeException(String.format("Error closing channel: %s", ex), ex);
    }

    try {
      connection.close();
    } catch (IOException ex) {
      throw new RuntimeException(String.format("Error closing connection: %s", ex), ex);
    }
  }
}
