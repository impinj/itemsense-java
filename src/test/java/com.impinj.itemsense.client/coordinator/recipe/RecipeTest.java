package com.impinj.itemsense.client.coordinator.recipe;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import org.junit.Assert;
import org.junit.Test;

import java.time.Duration;


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
}
