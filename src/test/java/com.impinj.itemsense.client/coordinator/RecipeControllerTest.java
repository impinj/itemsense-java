package com.impinj.itemsense.client.coordinator;

/**
 * Created by jcombopi on 1/29/16.
 */

import com.github.tomakehurst.wiremock.junit.WireMockClassRule;
import com.google.gson.Gson;
import com.impinj.itemsense.client.coordinator.recipe.*;
import org.glassfish.jersey.client.authentication.HttpAuthenticationFeature;
import org.junit.*;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

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
    public void getRecipesTest() {
        Recipe testRecipe = new Recipe();
        testRecipe.setName("Test_Reader_Configuration");
        testRecipe.setZoneModel(ZoneModel.GEOGRAPHIC);
        testRecipe.setLocationAggregationModel(LocationAggregationModel.BY_CYCLES);

        ArrayList<Recipe> testDefinitions = new ArrayList<>();

        testDefinitions.add(0, testRecipe);
        testDefinitions.add(1, testRecipe);

        stubFor(get(urlEqualTo("/configuration/v1/recipes/show")).willReturn(aResponse()
                .withStatus(200)
                .withHeader("Content-Type", "application/json")
                .withBody(gson.toJson(testDefinitions))));

        List<Recipe> recipes = recipeController.getRecipes();

        Assert.assertEquals(recipes.size(), 2);
        Assert.assertThat(recipes, instanceOf(ArrayList.class));
        Assert.assertThat(recipes.get(0), instanceOf(Recipe.class));
        Assert.assertEquals(recipes.get(0),testRecipe);

        Assert.assertThat(recipes.get(1), instanceOf(Recipe.class));
        Assert.assertEquals(recipes.get(1),testRecipe);
    }

    @Test
    public void getRecipeTest() {
        Recipe testRecipe = new Recipe();
        testRecipe.setName("Test_Reader_Configuration");
        testRecipe.setZoneModel(ZoneModel.GEOGRAPHIC);
        testRecipe.setLocationAggregationModel(LocationAggregationModel.BY_CYCLES);

        stubFor(get(urlEqualTo("/configuration/v1/recipes/show/Test_Recipe")).willReturn(aResponse()
                .withStatus(200)
                .withHeader("Content-Type", "application/json")
                .withBody(gson.toJson(testRecipe))));

        Response response = recipeController.getRecipeAsResponse("Test_Recipe");
        Assert.assertEquals(200, response.getStatus());

        Recipe recipeResult =  recipeController.getRecipe("Test_Recipe");
        Assert.assertEquals(recipeResult, testRecipe);
        Assert.assertThat(recipeResult, instanceOf(Recipe.class));

        // Test with an unknown recipe type
        String recipeResponse = "{\"name\":\"NEW_RECIPE\",\"type\":\"RANDOM STRING\",\"readerConfigurationName\":\"SPEEDWAY_CONFIG\",\"tagHeartbeatMinutes\":5,\"readerConfigurations\":{},\"presencePipelineEnabled\":false,\"locationReportingEnabled\":true,\"zoneModel\":\"ILLEGAL ZONE MODEL\",\"minimumMovementInMeters\":null,\"locationUpdateIntervalInSeconds\":null,\"historyWindowSizeInCycles\":null,\"computeWindowSizeInCycles\":null,\"computeWindowTimeInSeconds\":null,\"locationAggregationModel\":\"ILLEGAL LOCATION AGGREGATION MODEL\",\"agentComputeWindow\":null,\"agentUpdateInterval\":null,\"combineInventoryReads\":null,\"tagAgeInterval\":null}";
        stubFor(get(urlEqualTo("/configuration/v1/recipes/show/NEW_RECIPE")).willReturn(aResponse()
            .withStatus(200)
            .withHeader("Content-Type", "application/json")
            .withBody(recipeResponse)));

        Recipe recipe = recipeController.getRecipe("NEW_RECIPE");
        Assert.assertNull(recipe.getType());
        Assert.assertNull(recipe.getZoneModel());
    }

    @Test
    public void createRecipeTest() throws Exception {
        String recipeStr = "{\"name\":\"New_Recipe\",\"type\":\"LLRP\",\"readerConfigurationName\":\"Test_Reader_Configuration\",\"presencePipelineEnabled\":false,\"locationReportingEnabled\":false,\"zoneModel\":\"GATEWAY\"}";

        Recipe testRecipe = new Recipe();
        testRecipe.setName("New_Recipe");
        testRecipe.setType(RecipeType.LLRP);
        testRecipe.setReaderConfigurationName("Test_Reader_Configuration");
        testRecipe.setZoneModel(ZoneModel.GATEWAY);

        stubFor(post(urlEqualTo("/configuration/v1/recipes/create"))
            .willReturn(aResponse()
                .withStatus(200)
                .withHeader("Content-Type", "application/json")
                .withBody(recipeStr)));

        Recipe recipeResult = recipeController.createRecipe(testRecipe);
        Assert.assertEquals(testRecipe, recipeResult);
        Assert.assertThat(recipeResult, instanceOf(Recipe.class));

        // Now we should not be able to create the same recipe again
        stubFor(post(urlEqualTo("/configuration/v1/recipes/create"))
            .willReturn(aResponse()
                .withStatus(403)));

        Response response = recipeController.createRecipeAsResponse(testRecipe);
        Assert.assertEquals(403, response.getStatus());

        recipeResult = recipeController.createRecipe(testRecipe);
        Assert.assertEquals(recipeResult, null);
    }

    @Test
    public void updateRecipeTest() throws Exception {
        String recipeStr = "{\"name\":\"Old_Recipe\",\"readerConfigurationName\":\"Test_Reader_Configuration\",\"presencePipelineEnabled\":false,\"locationReportingEnabled\":false,\"zoneModel\":\"GEOGRAPHIC\"}\n";

        Recipe testRecipe = new Recipe();
        testRecipe.setName("Old_Recipe");
        testRecipe.setReaderConfigurationName("Test_Reader_Configuration");
        testRecipe.setZoneModel(ZoneModel.GEOGRAPHIC);

        stubFor(put(urlEqualTo("/configuration/v1/recipes/createOrReplace"))
            .willReturn(aResponse()
                .withStatus(200)
                .withHeader("Content-Type", "application/json")
                .withBody(recipeStr)));

        Response response = recipeController.updateRecipeAsResponse(testRecipe);
        Assert.assertEquals(200, response.getStatus());
        response.close();

        Recipe recipeResult = recipeController.updateRecipe(testRecipe);

        Assert.assertThat(recipeResult, instanceOf(Recipe.class));
        Assert.assertEquals(testRecipe, recipeResult);


        // Repeat the test with unknown enums
        recipeStr = "{\"name\":\"Old_Recipe\",\"type\":\"illegal value\", \"readerConfigurationName\":\"Test_Reader_Configuration\",\"presencePipelineEnabled\":false,\"locationReportingEnabled\":false,\"zoneModel\":\"illegal zone model\"}\n";

        testRecipe.setZoneModel(null);
        testRecipe.setType(null);

        stubFor(put(urlEqualTo("/configuration/v1/recipes/createOrReplace"))
            .willReturn(aResponse()
                .withStatus(200)
                .withHeader("Content-Type", "application/json")
                .withBody(recipeStr)));

        response = recipeController.updateRecipeAsResponse(testRecipe);
        Assert.assertEquals(200, response.getStatus());
        response.close();

        recipeResult = recipeController.updateRecipe(testRecipe);

        Assert.assertThat(recipeResult, instanceOf(Recipe.class));
        Assert.assertEquals(testRecipe, recipeResult);

    }

    @Test
    public void deleteRecipeTest() throws Exception {
        Recipe testRecipe = new Recipe();
        testRecipe.setName("Old_Recipe");
        testRecipe.setReaderConfigurationName("Test_Reader_Configuration");
        testRecipe.setZoneModel(ZoneModel.GEOGRAPHIC);

        stubFor(delete(urlEqualTo("/configuration/v1/recipes/destroy/Old_Recipe"))
            .willReturn(aResponse()
                .withStatus(204)));

        Response response = recipeController.deleteRecipe("Old_Recipe");
        Assert.assertEquals(204, response.getStatus());

        stubFor(delete(urlEqualTo("/configuration/v1/recipes/destroy/Recipe_that_does_not_exist"))
            .willReturn(aResponse()
                .withStatus(404)));

        response = recipeController.deleteRecipe("Recipe_that_does_not_exist");
        Assert.assertEquals(404, response.getStatus());

    }
}