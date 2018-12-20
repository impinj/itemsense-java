package com.impinj.itemsense.client.coordinator.recipe;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.io.IOException;
import java.time.Duration;
import org.junit.Assert;
import org.junit.Test;


public class RecipeTest {

  @Test
  public void testRecipeDeserialization() throws Exception {
    ObjectMapper mapper = new ObjectMapper();
    mapper.registerModule(new JavaTimeModule());
    mapper.configure(SerializationFeature.WRITE_DURATIONS_AS_TIMESTAMPS, false);
    mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
    mapper.configure(DeserializationFeature.READ_UNKNOWN_ENUM_VALUES_AS_NULL, true);
    Duration tagExpiry = Duration.ofSeconds(10);

    LocationRecipe recipe = new LocationRecipe();
    recipe.setName("RECIPE");

    recipe.setType(RecipeType.LOCATION);
    recipe.setTagExpiryDuration(tagExpiry);

    String string = mapper.writeValueAsString(recipe);

    Recipe recipeDeserialized = mapper.readValue(string, Recipe.class);
    Assert.assertEquals("RECIPE", recipeDeserialized.getName());
    Assert.assertEquals(RecipeType.LOCATION, recipeDeserialized.getType());
    Assert.assertEquals(tagExpiry, recipeDeserialized.getTagExpiryDuration());
  }

  @Test
  public void test2016R6Compatability2017R1() throws IOException {
    ObjectMapper mapper = new ObjectMapper();
    mapper.registerModule(new JavaTimeModule());
    mapper.configure(SerializationFeature.WRITE_DURATIONS_AS_TIMESTAMPS, false);
    mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
    mapper.configure(DeserializationFeature.READ_UNKNOWN_ENUM_VALUES_AS_NULL, true);

    String string = "{\"name\":\"RECIPE\",\"type\":\"LOCATION\",\"tagExpiryDuration\":\"PT10S\",\"readerConfigurations\":{},\"minimumMovementInMeters\":1.0,\"computeWindow\":10,\"reportingInterval\":5}";

    Recipe recipeDeserialized = mapper.readValue(string, Recipe.class);
    Assert.assertEquals("RECIPE", recipeDeserialized.getName());
    Assert.assertEquals(RecipeType.LOCATION, recipeDeserialized.getType());
    Assert.assertEquals(Duration.ofSeconds(10), recipeDeserialized.getTagExpiryDuration());
  }

  @Test
  public void testHeartbeatMinutesSerialization() throws Exception {
    ObjectMapper mapper = new ObjectMapper();
    mapper.registerModule(new JavaTimeModule());
    mapper.configure(SerializationFeature.WRITE_DURATIONS_AS_TIMESTAMPS, false);
    mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
    mapper.configure(DeserializationFeature.READ_UNKNOWN_ENUM_VALUES_AS_NULL, true);
    Duration tagExpiry = Duration.ofSeconds(10);

    LocationRecipe recipe = new LocationRecipe();
    recipe.setName("RECIPE");

    recipe.setType(RecipeType.LOCATION);
    recipe.setTagExpiryDuration(tagExpiry);
    recipe.setTagHeartbeatMinutes(3);

    String string = mapper.writeValueAsString(recipe);

    Recipe recipeDeserialized = mapper.readValue(string, Recipe.class);
    Assert.assertEquals("RECIPE", recipeDeserialized.getName());
    Assert.assertEquals(RecipeType.LOCATION, recipeDeserialized.getType());
    Assert.assertEquals(tagExpiry, recipeDeserialized.getTagExpiryDuration());
    Assert.assertEquals(
        recipe.getTagHeartbeatMinutes(),
        recipeDeserialized.getTagHeartbeatMinutes());
    Assert.assertNull(recipeDeserialized.getTagHeartbeatDuration());
  }

  @Test
  public void testHeartbeatDurationSerialization() throws Exception {
    ObjectMapper mapper = new ObjectMapper();
    mapper.registerModule(new JavaTimeModule());
    mapper.configure(SerializationFeature.WRITE_DURATIONS_AS_TIMESTAMPS, false);
    mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
    mapper.configure(DeserializationFeature.READ_UNKNOWN_ENUM_VALUES_AS_NULL, true);
    Duration tagExpiry = Duration.ofSeconds(10);

    LocationRecipe recipe = new LocationRecipe();
    recipe.setName("RECIPE");

    recipe.setType(RecipeType.LOCATION);
    recipe.setTagExpiryDuration(tagExpiry);
    recipe.setTagHeartbeatDuration(Duration.ofSeconds(30));

    String string = mapper.writeValueAsString(recipe);

    Recipe recipeDeserialized = mapper.readValue(string, Recipe.class);
    Assert.assertEquals("RECIPE", recipeDeserialized.getName());
    Assert.assertEquals(RecipeType.LOCATION, recipeDeserialized.getType());
    Assert.assertEquals(tagExpiry, recipeDeserialized.getTagExpiryDuration());
    Assert.assertEquals(
        recipe.getTagHeartbeatDuration(),
        recipeDeserialized.getTagHeartbeatDuration());
    Assert.assertNull(recipeDeserialized.getTagHeartbeatMinutes());
  }
}
