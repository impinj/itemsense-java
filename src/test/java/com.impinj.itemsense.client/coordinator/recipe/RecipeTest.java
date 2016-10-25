package com.impinj.itemsense.client.coordinator.recipe;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.time.Duration;
import org.junit.Assert;
import org.junit.Test;


public class RecipeTest {

  @Test
  public void testRecipeDeserialization() throws Exception {
    ObjectMapper mapper = new ObjectMapper();
    Duration tagExpiry = Duration.ofSeconds(10);

    Recipe recipe = new Recipe();
    recipe.setName("RECIPE");
    recipe.setType(RecipeType.LLRP);
    recipe.setZoneModel(ZoneModel.GATEWAY);
    recipe.setLocationAggregationModel(LocationAggregationModel.BY_TIME);
    recipe.setTagExpiryDuration(tagExpiry);

    String string = mapper.writeValueAsString(recipe);

    Recipe recipeDeserialized = mapper.readValue(string, Recipe.class);
    Assert.assertEquals("RECIPE", recipeDeserialized.getName());
    Assert.assertEquals(RecipeType.LLRP, recipeDeserialized.getType());
    Assert.assertEquals(ZoneModel.GATEWAY, recipeDeserialized.getZoneModel());
    Assert.assertEquals(LocationAggregationModel.BY_TIME, recipeDeserialized.getLocationAggregationModel());
    Assert.assertEquals(tagExpiry, recipeDeserialized.getTagExpiryDuration());
  }
}
