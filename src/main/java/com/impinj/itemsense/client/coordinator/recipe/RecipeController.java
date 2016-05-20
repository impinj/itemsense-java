package com.impinj.itemsense.client.coordinator.recipe;

import com.impinj.itemsense.client.helpers.RestApiHelper;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * Created by jcombopi on 1/25/16.
 */
public class RecipeController {

    private WebTarget target;
    private RestApiHelper<Recipe> restApiHelper;

    public RecipeController(WebTarget target) {
        this.target = target;
        this.restApiHelper = new RestApiHelper<Recipe>(Recipe.class);
    }

    public Recipe createRecipe(Recipe recipe) {
        return this.createRecipeAsResponse(recipe).readEntity(Recipe.class);
    }

    public Recipe updateRecipe(Recipe recipe) {
        return this.updateRecipeAsResponse(recipe).readEntity(Recipe.class);
    }

    public Response deleteRecipe(String recipeName) {
        return this.restApiHelper.delete(recipeName, "/configuration/v1/recipes/destroy", target);
    }

    public Recipe getRecipe(String recipeName) {
       return this.getRecipeAsResponse(recipeName).readEntity(Recipe.class);
    }

    public List<Recipe> getRecipes() {
        Recipe[] recipes =  this.getRecipesAsResponse().readEntity(Recipe[].class);
        return new ArrayList<Recipe>(Arrays.asList(recipes));
    }

    public Response createRecipeAsResponse(Recipe recipe) {
        return this.restApiHelper.post(recipe, "/configuration/v1/recipes/create", target);
    }

    public Response updateRecipeAsResponse(Recipe recipe) {
        return this.restApiHelper.put(recipe, "/configuration/v1/recipes/create", target);
    }

    public Response getRecipeAsResponse(String recipeName) {
        return this.restApiHelper.get(recipeName, "/configuration/v1/recipes/show", target);
    }

    public Response getRecipesAsResponse() {
        return this.restApiHelper.get( "/configuration/v1/recipes/show", target);
    }
}
