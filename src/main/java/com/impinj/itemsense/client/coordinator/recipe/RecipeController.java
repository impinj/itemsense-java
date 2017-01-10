package com.impinj.itemsense.client.coordinator.recipe;

import com.impinj.itemsense.client.helpers.RestApiHelper;

import java.util.List;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;



public class RecipeController {

    private static final String BASE_PATH = "/configuration/v1/recipes";
    private WebTarget target;
    private RestApiHelper<Recipe> restApiHelper;

    public RecipeController(WebTarget target) {
        this.target = target;
        this.restApiHelper = new RestApiHelper<Recipe>();
    }

    public Response getRecipeAsResponse(String recipeName) {
        return this.restApiHelper.get(target, BASE_PATH, "show", recipeName);
    }

    public Response getRecipesAsResponse() {
        return this.restApiHelper.get(target, BASE_PATH, "show");
    }

    public Response createRecipeAsResponse(Recipe recipe) {
        return this.restApiHelper.post(recipe, target, BASE_PATH, "create");
    }

    public Response updateRecipeAsResponse(Recipe recipe) {
        return this.restApiHelper.put(recipe, target, BASE_PATH, "createOrReplace");
    }

    public Response deleteRecipe(String recipeName) {
        return this.restApiHelper.delete(target, BASE_PATH, "destroy", recipeName);
    }

    public Recipe getRecipe(String recipeName) {
        return this.getRecipeAsResponse(recipeName).readEntity(Recipe.class);
    }

    public List<Recipe> getRecipes() {
        return this.getRecipesAsResponse().readEntity(new GenericType<List<Recipe>>() {});
    }

    public Recipe createRecipe(Recipe recipe) {
        return this.createRecipeAsResponse(recipe).readEntity(Recipe.class);
    }

    public Recipe updateRecipe(Recipe recipe) {
        return this.updateRecipeAsResponse(recipe).readEntity(Recipe.class);
    }
}
