package com.impinj.itemsense.client.coordinator.settings.snmp;

import java.time.Duration;

public class SnmpTrapTargetConfiguration {

  private String host;
  private Integer port = 162;
  private Duration timeout;
  private Integer retries = 2;
  private MessageType messageType = MessageType.TRAP;

  @java.beans.ConstructorProperties({"host", "port", "timeout", "retries", "messageType"})
  public SnmpTrapTargetConfiguration(
      String host,
      Integer port,
      Duration timeout,
      Integer retries,
      MessageType messageType) {
    this.host = host;
    this.port = port;
    this.timeout = timeout;
    this.retries = retries;
    this.messageType = messageType;
  }

  public SnmpTrapTargetConfiguration() {}

  public static SnmpTrapTargetConfigurationBuilder builder() {return new SnmpTrapTargetConfigurationBuilder();}

  public String getHost() {return this.host;}

  public Integer getPort() {return this.port;}

  public Duration getTimeout() {return this.timeout;}

  public Integer getRetries() {return this.retries;}

  public MessageType getMessageType() {return this.messageType;}

  public void setHost(String host) {this.host = host; }

  public void setPort(Integer port) {this.port = port; }

  public void setTimeout(Duration timeout) {this.timeout = timeout; }

  public void setRetries(Integer retries) {this.retries = retries; }

  public void setMessageType(MessageType messageType) {this.messageType = messageType; }

  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (!(o instanceof SnmpTrapTargetConfiguration)) {
      return false;
    }
    final SnmpTrapTargetConfiguration other = (SnmpTrapTargetConfiguration) o;
    final Object this$host = this.getHost();
    final Object other$host = other.getHost();
    if (this$host == null ? other$host != null : !this$host.equals(other$host)) {
      return false;
    }
    final Object this$port = this.getPort();
    final Object other$port = other.getPort();
    if (this$port == null ? other$port != null : !this$port.equals(other$port)) {
      return false;
    }
    final Object this$timeout = this.getTimeout();
    final Object other$timeout = other.getTimeout();
    if (this$timeout == null ? other$timeout != null : !this$timeout.equals(other$timeout)) {
      return false;
    }
    final Object this$retries = this.getRetries();
    final Object other$retries = other.getRetries();
    if (this$retries == null ? other$retries != null : !this$retries.equals(other$retries)) {
      return false;
    }
    final Object this$messageType = this.getMessageType();
    final Object other$messageType = other.getMessageType();
    return this$messageType == null ? other$messageType == null : this$messageType.equals(
        other$messageType);
  }

  public int hashCode() {
    final int PRIME = 59;
    int result = 1;
    final Object $host = this.getHost();
    result = result * PRIME + ($host == null ? 43 : $host.hashCode());
    final Object $port = this.getPort();
    result = result * PRIME + ($port == null ? 43 : $port.hashCode());
    final Object $timeout = this.getTimeout();
    result = result * PRIME + ($timeout == null ? 43 : $timeout.hashCode());
    final Object $retries = this.getRetries();
    result = result * PRIME + ($retries == null ? 43 : $retries.hashCode());
    final Object $messageType = this.getMessageType();
    result = result * PRIME + ($messageType == null ? 43 : $messageType.hashCode());
    return result;
  }

  public String toString() {
    return "com.impinj.itemsense.client.coordinator.settings.snmp.SnmpTrapTargetConfiguration(host="
        + this.getHost() + ", port=" + this.getPort() + ", timeout=" + this.getTimeout()
        + ", retries=" + this.getRetries() + ", messageType=" + this.getMessageType() + ")";
  }

  public enum MessageType {TRAP, INFORM}

  public static class SnmpTrapTargetConfigurationBuilder {

    private String host;
    private Integer port;
    private Duration timeout;
    private Integer retries;
    private MessageType messageType;

    SnmpTrapTargetConfigurationBuilder() {}

    public SnmpTrapTargetConfiguration.SnmpTrapTargetConfigurationBuilder host(String host) {
      this.host = host;
      return this;
    }

    public SnmpTrapTargetConfiguration.SnmpTrapTargetConfigurationBuilder port(Integer port) {
      this.port = port;
      return this;
    }

    public SnmpTrapTargetConfiguration.SnmpTrapTargetConfigurationBuilder timeout(Duration timeout) {
      this.timeout = timeout;
      return this;
    }

    public SnmpTrapTargetConfiguration.SnmpTrapTargetConfigurationBuilder retries(Integer retries) {
      this.retries = retries;
      return this;
    }

    public SnmpTrapTargetConfiguration.SnmpTrapTargetConfigurationBuilder messageType(MessageType messageType) {
      this.messageType = messageType;
      return this;
    }

    public SnmpTrapTargetConfiguration build() {
      return new SnmpTrapTargetConfiguration(host, port, timeout, retries, messageType);
    }

    public String toString() {
      return
          "com.impinj.itemsense.client.coordinator.settings.snmp.SnmpTrapTargetConfiguration.SnmpTrapTargetConfigurationBuilder(host="
              + this.host + ", port=" + this.port + ", timeout=" + this.timeout + ", retries="
              + this.retries + ", messageType=" + this.messageType + ")";
    }
  }
}
