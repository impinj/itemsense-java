/**
 * IMPINJ CONFIDENTIAL AND PROPRIETARY
 *
 * This source code is the sole property of Impinj, Inc. Reproduction or utilization of this source
 * code in whole or in part is forbidden without the prior written consent of Impinj, Inc.
 *
 * (c) Copyright Impinj, Inc. 2015. All rights reserved.
 */

// This class is built on top of generated code. See the comments in Localhost_ItemsenseCoordinator
// for
// instructions if you need to re-generate that code.
package com.impinj.itemsense.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.Map;
import java.util.stream.Collectors;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status.Family;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import lombok.extern.log4j.Log4j;


@Log4j
public class ControlApiLib {

  private final Gson gson;
  private final WebTarget target;

  /**
   * Constructor
   *
   * @param uri the base URI for the items service
   */
  public ControlApiLib(final Gson gson, final Client client, final URI uri) {
    this.gson = gson;
    target = client.target(uri);
  }

  /**
   * Use the control service to discover and terminate all running jobs
   *
   * @throws IOException
   */
  public void stopAllJobs() throws IOException {
    showJobs().stream().filter(job -> job.getStatus() == JobStatus.RUNNING).map(JobsResponse::getId)
        .forEach(jobId -> {
          try {
            stopJobById(jobId);
          } catch (final Exception e) {
            log.error("Unable to stop the job " + jobId, e);
          }
        });
  }

  public boolean anyJobIsRunning() throws IOException {
    return showJobs().stream().anyMatch(job -> job.getStatus() == JobStatus.RUNNING);
  }

  /**
   * Use the Control service to terminate a job given it's Id
   */
  public void stopJobById(final String jobId) throws Exception {
    log.debug("Attempting to destroy this job :" + jobId);
    final String response = target.path("control/jobs/stop/" + jobId)
        .request(MediaType.APPLICATION_JSON_TYPE).post(Entity.text(""), String.class);
    log.debug("/control/jobs/stop response: " + response);
  }

  /**
   * Use the Control service to add a reader definition
   */
  public void addReaderDefinition(final String readerId, final String readerType) throws Exception {
    addReaderDefinition(readerId, readerType, null, null, null, null, null, null);
  }

  /**
   * Use the Control service to add a reader definition
   */
  // TODO: Create POJOs for reader definition data
  // TODO: Replace these parameters with a reader definition object, using a builder pattern
  public void addReaderDefinition(final String readerId, final String readerType, final Double x,
      final Double y, final Double z, final Double pitch, final Double roll, final Double yaw)
          throws URISyntaxException, IOException {
    // Create our JSON from a template file.
    Map<String, Object> readerDefData;
    try (BufferedReader reader = new BufferedReader(new InputStreamReader(
        getClass().getResource("/Control/createReaderDefinitions.json").openStream()))) {
      readerDefData = gson.fromJson(reader, new TypeToken<Map<String, Object>>() {}.getType());
    }

    readerDefData.put("name", readerId);
    readerDefData.put("address", readerId);
    readerDefData.put("type", readerType);
    if (x != null) {
      ((Map<String, Object>) readerDefData.get("placement")).put("x", x);
    }
    if (y != null) {
      ((Map<String, Object>) readerDefData.get("placement")).put("y", y);
    }
    if (z != null) {
      ((Map<String, Object>) readerDefData.get("placement")).put("z", z);
    }
    if (pitch != null) {
      ((Map<String, Object>) readerDefData.get("placement")).put("pitch", pitch);
    }
    if (roll != null) {
      ((Map<String, Object>) readerDefData.get("placement")).put("roll", x);
    }
    if (yaw != null) {
      ((Map<String, Object>) readerDefData.get("placement")).put("yaw", x);
    }
    final String createReaderDefJsonString = gson.toJson(readerDefData);
    log.debug("JSON being used to create reader definition: " + createReaderDefJsonString);
    final String returnValue = target.path("configuration/readerDefinitions/createOrReplace")
        .request(MediaType.APPLICATION_JSON_TYPE)
        .put(Entity.entity(createReaderDefJsonString, MediaType.APPLICATION_JSON_TYPE),
            String.class);
    log.debug("ReaderDefinitions.create() return: " + returnValue);
  }

  /**
   * Destroys a single reader definition, if found.
   *
   * @param readerId The reader to remove.
   * @throws Exception Something bad happened.
   */
  public void destroyReaderDefinition(final String readerId) throws Exception {
    log.debug("About to destroy reader definition: " + readerId);
    final String response = target.path("configuration/readerDefinitions/destroy/" + readerId)
        .request(MediaType.APPLICATION_JSON_TYPE).delete(String.class);
    log.debug("Destroy reader definition response: " + response);
  }

  /**
   * Returns a single reader address, if found.
   *
   * @param readerId The reader ID to look for.
   * @return The reader.
   * @throws Exception Something bad.
   */
  public String showReaderDefinition(final String readerId) throws Exception {
    log.debug("About to show reader definition: " + readerId);
    final String returnValue = target.path("configuration/readerDefinitions/show/" + readerId)
        .request(MediaType.APPLICATION_JSON_TYPE).get(String.class);
    log.debug("readerDefinitions.show() return: " + returnValue);
    return gson.fromJson(returnValue, Map.class).get("address").toString();
  }

  /**
   * Returns all the reader addresses.
   *
   * @return The reader addresses as a Collection.
   * @throws Exception Something bad.
   */
  public Collection<String> showAllReaderDefinitions() throws Exception {
    log.debug("About to show all reader definitions.");
    final String response = target.path("configuration/readerDefinitions/show")
        .request(MediaType.APPLICATION_JSON_TYPE).get(String.class);
    log.debug("readerDefinitions.show() return: " + response);
    final Collection<Map<?, ?>> readerDefinitions =
        gson.fromJson(response, new TypeToken<Collection<Map<?, ?>>>() {}.getType());
    return readerDefinitions.stream().map(map -> map.get("name").toString())
        .collect(Collectors.toList());
  }

  /**
   * Use the Control service to add a reader configuration
   *
   * @param readerConfiguration Reader configuration
   * @return Response data
   */
  public String addConfiguration(final Object readerConfiguration) throws JsonProcessingException {
    final String createConfigurationJsonString = gson.toJson(readerConfiguration);
    log.debug("JSON being used to create reader configuration: " + createConfigurationJsonString);

    final String returnValue = target.path("configuration/readerConfigurations/createOrReplace")
        .request(MediaType.APPLICATION_JSON_TYPE)
        .put(Entity.entity(createConfigurationJsonString, MediaType.APPLICATION_JSON_TYPE),
            String.class);
    log.debug("readerConfigurations().create() return: " + returnValue);
    return returnValue;
  }

  /**
   * Destroys a single reader configuration, if found.
   *
   * @param configName The reader configuration to remove.
   * @throws Exception Something bad happened.
   */
  public void destroyConfiguration(final String configName) throws Exception {
    log.debug("About to destroy reader configuration: " + configName);
    final String response = target.path("configuration/readerConfigurations/destroy/" + configName)
        .request(MediaType.APPLICATION_JSON_TYPE).delete(String.class);
    log.debug("Destroy reader configuration response: " + response);
  }

  /**
   * Use the Control service to add a recipe
   *
   * @param name Name of the recipe
   * @param readerConfigurationName Name of the reader configuration
   */
  public void addRecipe(final String name, final String readerConfigurationName) throws Exception {
    addRecipe(name, readerConfigurationName, null);
  }

  /**
   * Use the Control service to add a recipe
   *
   * @param name Name of the recipe
   * @param readerConfigurationName Name of the reader configuration
   * @param presencePipelineEnabled If set to true, enables absence detection
   */
  // TODO: Move the functionality for building a recipe from a template into a separate class
  public void addRecipe(final String name, final String readerConfigurationName,
      final Boolean presencePipelineEnabled) throws Exception {
    // Create our JSON from a template file.
    Map<String, Object> recipeConfigData;
    try (BufferedReader reader = new BufferedReader(
        new InputStreamReader(getClass().getResource("/Control/createRecipe.json").openStream()))) {
      recipeConfigData = gson.fromJson(reader, new TypeToken<Map<String, Object>>() {}.getType());
    }

    recipeConfigData.put("name", name);
    recipeConfigData.put("readerConfigurationName", readerConfigurationName);
    if (presencePipelineEnabled != null) {
      recipeConfigData.put("presencePipelineEnabled", presencePipelineEnabled);
    }
    final String createRecipeJsonString = gson.toJson(recipeConfigData);
    log.debug("JSON being used to create recipe: " + createRecipeJsonString);

    final String returnValue = target.path("configuration/recipes/createOrReplace")
        .request(MediaType.APPLICATION_JSON_TYPE)
        .put(Entity.entity(createRecipeJsonString, MediaType.APPLICATION_JSON_TYPE), String.class);
    log.debug("recipes().create() return: " + returnValue);
  }

  public void destroyRecipe(final String recipeName) {
    log.debug("About to destroy recipe: " + recipeName);
    final String response = target.path("configuration/recipes/destroy/" + recipeName)
        .request(MediaType.APPLICATION_JSON_TYPE).delete(String.class);
    log.debug("Destroy recipe response: " + response);
  }

  public String showRecipe(final String recipeName) throws Exception {
    log.debug("About to show recipe: " + recipeName);
    final String returnValue = target.path("configuration/recipes/show/" + recipeName)
        .request(MediaType.APPLICATION_JSON_TYPE).get(String.class);
    log.debug("recipes.show() return: " + returnValue);
    return gson.fromJson(returnValue, Map.class).get("name").toString();
  }

  public Collection<String> showAllRecipes() throws Exception {
    log.debug("About to show all recipes.");
    final String returnValue = target.path("configuration/recipes/show")
        .request(MediaType.APPLICATION_JSON_TYPE).get(String.class);
    log.debug("recipes.show() return: " + returnValue);
    final Collection<Map<String, Object>> resultSet =
        gson.fromJson(returnValue, new TypeToken<Collection<Map<String, Object>>>() {}.getType());

    return resultSet.stream().map(map -> map.get("name").toString()).collect(Collectors.toList());
  }

  public JobsResponse startJob(final Job job) throws ItemSenseClientException {
    final String createJobJsonString = gson.toJson(job);
    log.debug("JSON being used to create jobs: " + createJobJsonString);

    final Response response =
        target.path("control/jobs/start").request(MediaType.APPLICATION_JSON_TYPE)
            .post(Entity.entity(createJobJsonString, MediaType.APPLICATION_JSON_TYPE));
    if (response.getStatusInfo().getFamily() != Family.SUCCESSFUL) {
      throw new ItemSenseClientException(
          "Failed to start the job with status code " + response.getStatusInfo() + " and response "
              + response.readEntity(FailureResponse.class));
    }
    final String returnValue = response.readEntity(String.class);
    log.debug("jobs().create() return: " + returnValue);

    return gson.fromJson(returnValue, JobsResponse.class);
  }

  @Deprecated
  public JobsResponse startJob(final String recipeName, final long durationSeconds,
      final boolean playbackLoggingEnabled) throws Exception {
    return startJob(new Job("1.0.0", recipeName, durationSeconds, playbackLoggingEnabled));
  }

  /**
   * Queries the Control service for all jobs
   */
  public Collection<JobsResponse> showJobs() throws IOException {
    final String response =
        target.path("control/jobs/show").request(MediaType.APPLICATION_JSON_TYPE).get(String.class);
    log.debug("/jobs/show response: " + response);
    return gson.fromJson(response, new TypeToken<Collection<JobsResponse>>() {}.getType());
  }

  public JobsResponse showJobId(final String jobId) throws IOException {
    log.debug("About to show job");
    final String response = target.path("control/jobs/show/" + jobId)
        .request(MediaType.APPLICATION_JSON_TYPE).get(String.class);
    log.debug("/jobs/show/{jobId} response: " + response);
    return gson.fromJson(response, JobsResponse.class);
  }

  /**
   * Use the passed in array in conjunction with a JSON template to construct a complete zoneMap for
   * the ItemSense Coordinator's createZoneMap API.
   */
  // TODO: Create POJOs representing Zone Map
  // TODO: Move the functionality for building a zone map from a template into a separate class
  public String createZoneMap(final String fileName) throws Exception {
    // Create our JSON from a template file.
    Map<String, Object> zoneData;
    try (BufferedReader reader = new BufferedReader(
        new InputStreamReader(getClass().getResource("/Control/" + fileName).openStream()))) {
      zoneData = gson.fromJson(reader, new TypeToken<Map<String, Object>>() {}.getType());
    }

    // No markup to do on this file...
    final String zoneDataString = gson.toJson(zoneData);
    log.debug("JSON used to create zones: " + zoneDataString);

    // Use the wadl2java created code to make the call
    final String response =
        target.path("configuration/zoneMaps/create").request(MediaType.APPLICATION_JSON_TYPE)
            .post(Entity.entity(zoneDataString, MediaType.APPLICATION_JSON_TYPE), String.class);
    log.debug("Response from createZoneMap: " + response);
    return response;
  }

  /**
   * Adds a zone map based on fields.
   */
  public void addZoneMap(final String name, final String version)
      throws URISyntaxException, IOException {
    Map<String, Object> zoneMap;
    try (BufferedReader reader = new BufferedReader(new InputStreamReader(
        getClass().getResource("/Control/createZoneMap.json").openStream()))) {
      zoneMap = gson.fromJson(reader, new TypeToken<Map<String, Object>>() {}.getType());
    }
    zoneMap.put("name", name);
    zoneMap.put("version", version);
    final String zoneMapString = gson.toJson(zoneMap);
    log.debug("JSON being used to create reader definition: " + zoneMapString);
    final String returnValue = target.path("configuration/zoneMaps/createOrReplace")
        .request(MediaType.APPLICATION_JSON_TYPE)
        .put(Entity.entity(zoneMapString, MediaType.APPLICATION_JSON_TYPE), String.class);
    log.debug("Zone Map creation returned: " + returnValue);
  }

  /**
   * Select a zone map to apply to ItemSense
   *
   * @param zoneMapName the name of the zone map to apply
   */
  public String selectZoneMap(final String zoneMapName) {
    final String response = target.path("control/currentZoneMap/select/" + zoneMapName)
        .request(MediaType.APPLICATION_JSON_TYPE).post(Entity.text(""), String.class);
    log.debug("Response from selectZoneMapName: " + response);
    return response;
  }

  /**
   * Show the value of a zone map.
   */
  public String showZoneMap(final String zoneMapName) throws IOException {
    final String returnValue = target.path("configuration/zoneMaps/show/" + zoneMapName)
        .request(MediaType.APPLICATION_JSON_TYPE).get(String.class);
    log.debug("Zone Map Show returned: " + returnValue);
    return gson.fromJson(returnValue, Map.class).get("name").toString();
  }

  public Collection<String> showAllZoneMaps() throws Exception {
    log.debug("About to show all zone maps.");
    final String returnValue = target.path("configuration/zoneMaps/show")
        .request(MediaType.APPLICATION_JSON_TYPE).get(String.class);
    log.debug("zoneMaps.show() return: " + returnValue);
    final Collection<Map<?, ?>> resultSet =
        gson.fromJson(returnValue, new TypeToken<Collection<Map<?, ?>>>() {}.getType());
    return resultSet.stream().map(map -> map.get("name").toString()).collect(Collectors.toList());
  }

  /**
   * Show the status of the current zone map
   */
  public String showCurrentZoneMap() {
    log.debug("About to show current zone map");
    final String response = target.path("control/currentZoneMap/show")
        .request(MediaType.APPLICATION_JSON_TYPE).get(String.class);
    log.debug("Show current zone map response: " + response);
    return response;
  }

  /**
   * Destroy a zone map
   *
   * @param zoneMapName Name of the zone map to destroy
   */
  public void destroyZoneMap(final String zoneMapName) {
    log.debug("About to destroy zone map");
    final String response = target.path("configuration/zoneMaps/destroy/" + zoneMapName)
        .request(MediaType.APPLICATION_JSON_TYPE).delete(String.class);
    log.debug("Destroy zone map response: " + response);
  }

  /**
   *
   * @param filter
   * @return
   * @throws ItemSenseClientException
   */
  public QueueConfiguration configureZoneTransitionMessageQueue(
      final ZoneTransitionQueueFilter filter) throws ItemSenseClientException {

    final String filterString = gson.toJson(filter);
    log.debug(String.format("About to configure zoneTransition message queue: %s", filterString));

    final Response response = target.path("data/messageQueues/zoneTransition/configure")
        .request(MediaType.APPLICATION_JSON_TYPE)
        .post(Entity.entity(filterString, MediaType.APPLICATION_JSON_TYPE));

    if (response.getStatusInfo().getFamily() != Family.SUCCESSFUL) {
      throw new ItemSenseClientException(
          "Failed configure the zoneTransition message queue with status code "
              + response.getStatusInfo() + " and response "
              + response.readEntity(FailureResponse.class));
    }

    final String returnValue = response.readEntity(String.class);
    log.debug("zoneTransition configure return: " + returnValue);

    return gson.fromJson(returnValue, QueueConfiguration.class);
  }


}
