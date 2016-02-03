package com.impinj.itemsense.client.coordinator.recipe;

import com.google.gson.Gson;
import com.impinj.itemsense.client.helpers.RestApiHelper;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.Collection;


/**
 * Created by jcombopi on 1/25/16.
 */
public class RecipeController {

    private Gson gson;
    private WebTarget target;
    private RestApiHelper<Recipe> restApiHelper;

    public RecipeController(final Gson gson, WebTarget target) {
        this.gson = gson;
        this.target = target;
        this.restApiHelper = new RestApiHelper<Recipe>(Recipe.class);
    }

    public Recipe createRecipe(Recipe recipe) {
        return this.restApiHelper.post(recipe, "/configuration/v1/recipes/create", target, gson);
    }

    public Recipe updateRecipe(Recipe recipe) {
        return this.restApiHelper.put(recipe, "/configuration/v1/recipes/create", target, gson);
    }

    public Response deleteRecipe(String recipeName) {
        return this.restApiHelper.delete(recipeName, "/configuration/v1/recipes/destroy", target);
    }

    public Recipe getRecipe(String recipeName) {
        return this.restApiHelper.get(recipeName, "/configuration/v1/recipes/show", target);
    }

    public ArrayList<Recipe> getRecipes() {
        return this.restApiHelper.getMultiple(null, "/configuration/v1/recipes/show", target, gson);
    }
}
