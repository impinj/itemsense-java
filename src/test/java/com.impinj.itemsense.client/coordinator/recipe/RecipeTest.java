package com.impinj.itemsense.client.coordinator.recipe;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.Assert;
import org.junit.Test;


public class RecipeTest {

  @Test
  public void testRecipeDeserialization() throws Exception {
    ObjectMapper mapper = new ObjectMapper();

    Recipe recipe = new Recipe();
    recipe.setName("RECIPE");
    recipe.setType(RecipeType.LLRP);
    recipe.setZoneModel(ZoneModel.GATEWAY);
    recipe.setLocationAggregationModel(LocationAggregationModel.BY_TIME);

    String string = mapper.writeValueAsString(recipe);

    Recipe recipeDeserialized = mapper.readValue(string, Recipe.class);
    Assert.assertEquals("RECIPE", recipeDeserialized.getName());
    Assert.assertEquals(RecipeType.LLRP, recipeDeserialized.getType());
    Assert.assertEquals(ZoneModel.GATEWAY, recipeDeserialized.getZoneModel());
    Assert.assertEquals(LocationAggregationModel.BY_TIME, recipeDeserialized.getLocationAggregationModel());
  }
}
