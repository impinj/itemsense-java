package com.impinj.itemsense.client.coordinator.recipe;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.Assert;
import org.junit.Test;


public class RecipeTest {

  @Test
  public void testRecipeDeserialization() throws Exception {
    ObjectMapper mapper = new ObjectMapper();

    LocationRecipe recipe = new LocationRecipe();
    recipe.setName("RECIPE");
    recipe.setType(RecipeType.LOCATION);

    String string = mapper.writeValueAsString(recipe);

    Recipe recipeDeserialized = mapper.readValue(string, Recipe.class);
    Assert.assertEquals("RECIPE", recipeDeserialized.getName());
    Assert.assertEquals(RecipeType.LOCATION, recipeDeserialized.getType());
  }
}
