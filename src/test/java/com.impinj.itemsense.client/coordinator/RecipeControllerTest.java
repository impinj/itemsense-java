package com.impinj.itemsense.client.coordinator;

/**
 * Created by jcombopi on 1/29/16.
 */

import com.github.tomakehurst.wiremock.junit.WireMockClassRule;
import com.google.gson.Gson;
import com.impinj.itemsense.client.coordinator.recipe.LocationAggregationModel;
import com.impinj.itemsense.client.coordinator.recipe.Recipe;
import com.impinj.itemsense.client.coordinator.recipe.RecipeController;
import com.impinj.itemsense.client.coordinator.recipe.ZoneModel;
import org.glassfish.jersey.client.authentication.HttpAuthenticationFeature;
import org.junit.*;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import java.net.URI;
import java.util.ArrayList;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.hamcrest.CoreMatchers.instanceOf;



/**
 * Created by jcombopi on 1/27/16.
 */
public class RecipeControllerTest {

    private CoordinatorApiController coordinatorApiController;
    private RecipeController recipeController;
    private Gson gson;

    @ClassRule
    public static WireMockClassRule wireMockRule = new WireMockClassRule(8089);

    @Rule
    public WireMockClassRule instanceRule = wireMockRule;


    @Before
    public void setUp() throws Exception {

        Client client = ClientBuilder.newClient().register(HttpAuthenticationFeature.basic("testUser", "testPassword"));

        //http://localhost:8089 is where wiremock is running
        coordinatorApiController = new CoordinatorApiController(client, URI.create("http://localhost:8089"));
        recipeController = coordinatorApiController.getRecipeController();
        gson = new Gson();

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void GetRecipesTest(){
        Recipe testRecipe = new Recipe("Test_Recipe", "Test_Reader_Configuration", null, true, true, ZoneModel.GEOGRAPHIC, null, null, null ,null, null, LocationAggregationModel.BY_CYCLES);
        ArrayList<Recipe> testDefinitions = new ArrayList<>();
        testDefinitions.add(testRecipe);

        stubFor(get(urlEqualTo("/configuration/v1/recipes/show")).willReturn(aResponse()
                .withStatus(200)
                .withHeader("Content-Type", "application/json")
                .withBody(gson.toJson(testDefinitions))));

        ArrayList<Recipe> recipes = recipeController.getRecipes();

        Assert.assertEquals(recipes.size(), 1);
        Assert.assertThat(recipes, instanceOf(ArrayList.class));
        Assert.assertThat(recipes.get(0), instanceOf(Recipe.class));
        Assert.assertEquals(recipes.get(0),testRecipe);
    }

    @Test
    public void GetRecipeTest(){
        Recipe testRecipe = new Recipe("Test_Recipe", "Test_Reader_Configuration", null, true, true, ZoneModel.GEOGRAPHIC, null, null, null ,null, null, LocationAggregationModel.BY_CYCLES);
        stubFor(get(urlEqualTo("/configuration/v1/recipes/show/Test_Recipe")).willReturn(aResponse()
                .withStatus(200)
                .withHeader("Content-Type", "application/json")
                .withBody(gson.toJson(testRecipe))));

        Recipe recipeResult =  recipeController.getRecipe("Test_Recipe");
        Assert.assertEquals(recipeResult, testRecipe);
        Assert.assertThat(recipeResult, instanceOf(Recipe.class));

    }





}