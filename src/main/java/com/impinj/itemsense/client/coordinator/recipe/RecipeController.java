package com.impinj.itemsense.client.coordinator.recipe;

import com.impinj.itemsense.client.helpers.RestApiHelper;

import java.util.List;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;



public class RecipeController {

    private WebTarget target;
    private RestApiHelper<Recipe> restApiHelper;

    public RecipeController(WebTarget target) {
        this.target = target;
        this.restApiHelper = new RestApiHelper<Recipe>(Recipe.class);
    }

    public Response getRecipeAsResponse(String recipeName) {
        return this.restApiHelper.get(recipeName, "/configuration/v1/recipes/show", target);
    }

    public Response getRecipesAsResponse() {
        return this.restApiHelper.get( "/configuration/v1/recipes/show", target);
    }

    public Response createRecipeAsResponse(Recipe recipe) {
        return this.restApiHelper.post(recipe, "/configuration/v1/recipes/create", target);
    }

    public Response updateRecipeAsResponse(Recipe recipe) {
        return this.restApiHelper.put(recipe, "/configuration/v1/recipes/createOrReplace", target);
    }

    public Response deleteRecipe(String recipeName) {
        return this.restApiHelper.delete(recipeName, "/configuration/v1/recipes/destroy", target);
    }

    public Recipe getRecipe(String recipeName) {
        return restApiHelper.readObjectFromString(this.getRecipeAsResponse(recipeName).readEntity(String.class));
    }

    public List<Recipe> getRecipes() {
        return this.restApiHelper.readObjectsFromString(this.getRecipesAsResponse().readEntity(String.class));
    }

    public Recipe createRecipe(Recipe recipe) {
        return this.restApiHelper.readObjectFromString(this.createRecipeAsResponse(recipe).readEntity(String.class));
    }

    public Recipe updateRecipe(Recipe recipe) {
        return this.restApiHelper.readObjectFromString(this.updateRecipeAsResponse(recipe).readEntity(String.class));
    }
}
