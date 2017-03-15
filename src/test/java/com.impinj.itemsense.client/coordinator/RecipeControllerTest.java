package com.impinj.itemsense.client.coordinator;


import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.delete;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.post;
import static com.github.tomakehurst.wiremock.client.WireMock.put;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static org.hamcrest.CoreMatchers.instanceOf;

import com.github.tomakehurst.wiremock.junit.WireMockClassRule;
import com.google.gson.Gson;
import com.impinj.itemsense.client.TestUtils;
import com.impinj.itemsense.client.coordinator.recipe.InventoryRecipe;
import com.impinj.itemsense.client.coordinator.recipe.LocationRecipe;
import com.impinj.itemsense.client.coordinator.recipe.Recipe;
import com.impinj.itemsense.client.coordinator.recipe.RecipeController;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.client.Client;
import javax.ws.rs.core.Response;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;


public class RecipeControllerTest {

  @ClassRule
  public static WireMockClassRule wireMockRule = new WireMockClassRule(TestUtils.MOCK_PORT);
  @Rule
  public WireMockClassRule instanceRule = wireMockRule;
  private CoordinatorApiController coordinatorApiController;
  private RecipeController recipeController;
  private Gson gson;

  @Before
  public void setUp() throws Exception {
    Client client = TestUtils.getClient();

    coordinatorApiController = new CoordinatorApiController(client, TestUtils.MOCK_URI);
    recipeController = coordinatorApiController.getRecipeController();
    gson = TestUtils.getGson();
  }

  @After
  public void tearDown() throws Exception {

  }

  @Test
  public void getRecipesTest() {
    LocationRecipe testRecipe = new LocationRecipe();
    testRecipe.setName("Test_Reader_Configuration");
    testRecipe.setComputeWindow(15);
    testRecipe.setReportingInterval(5);
    testRecipe.setTagExpiryDuration(Duration.ofSeconds(10));

    ArrayList<Recipe> testDefinitions = new ArrayList<>();

    testDefinitions.add(0, testRecipe);
    testDefinitions.add(1, testRecipe);

    stubFor(get(urlEqualTo("/configuration/v1/recipes/show")).willReturn(aResponse()
                                                                             .withStatus(200)
                                                                             .withHeader(
                                                                                 "Content-Type",
                                                                                 "application/json")
                                                                             .withBody(gson.toJson(
                                                                                 testDefinitions))));

    List<Recipe> recipes = recipeController.getRecipes();

    Assert.assertEquals(recipes.size(), 2);
    Assert.assertThat(recipes, instanceOf(ArrayList.class));
    Assert.assertThat(recipes.get(0), instanceOf(LocationRecipe.class));
    Assert.assertEquals(recipes.get(0), testRecipe);

    Assert.assertThat(recipes.get(1), instanceOf(LocationRecipe.class));
    Assert.assertEquals(recipes.get(1), testRecipe);
  }

  @Test
  public void getRecipeTest() {
    LocationRecipe testRecipe = new LocationRecipe();
    testRecipe.setName("Test_Recipe");
    testRecipe.setReportingInterval(10);
    testRecipe.setComputeWindow(30);
    testRecipe.setTagExpiryDuration(Duration.ofSeconds(10));

    stubFor(get(urlEqualTo("/configuration/v1/recipes/show/Test_Recipe")).willReturn(aResponse()
                                                                                         .withStatus(
                                                                                             200)
                                                                                         .withHeader(
                                                                                             "Content-Type",
                                                                                             "application/json")
                                                                                         .withBody(
                                                                                             gson.toJson(
                                                                                                 testRecipe))));

    Response response = recipeController.getRecipeAsResponse("Test_Recipe");
    Assert.assertEquals(200, response.getStatus());

    Recipe recipeResult = recipeController.getRecipe("Test_Recipe");
    Assert.assertEquals(recipeResult, testRecipe);
    Assert.assertThat(recipeResult, instanceOf(LocationRecipe.class));
  }

  @Test
  public void createRecipeTest() throws Exception {
    String recipeStr = "{\"name\":\"New_Recipe\",\"type\":\"INVENTORY\",\"readerConfigurationName\":\"Test_Reader_Configuration\"}";

    InventoryRecipe testRecipe = new InventoryRecipe();
    testRecipe.setName("New_Recipe");
    testRecipe.setReaderConfigurationName("Test_Reader_Configuration");

    stubFor(post(urlEqualTo("/configuration/v1/recipes/create"))
                .willReturn(aResponse()
                                .withStatus(200)
                                .withHeader("Content-Type", "application/json")
                                .withBody(recipeStr)));

    Recipe recipeResult = recipeController.createRecipe(testRecipe);
    Assert.assertEquals(testRecipe, recipeResult);
    Assert.assertThat(recipeResult, instanceOf(InventoryRecipe.class));

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
    String recipeStr = "{\"name\":\"Old_Recipe\",\"type\":\"INVENTORY\",\"readerConfigurationName\":\"Test_Reader_Configuration\"}\n";

    InventoryRecipe testRecipe = new InventoryRecipe();
    testRecipe.setName("Old_Recipe");
    testRecipe.setReaderConfigurationName("Test_Reader_Configuration");

    stubFor(put(urlEqualTo("/configuration/v1/recipes/createOrReplace"))
                .willReturn(aResponse()
                                .withStatus(200)
                                .withHeader("Content-Type", "application/json")
                                .withBody(recipeStr)));

    Response response = recipeController.updateRecipeAsResponse(testRecipe);
    Assert.assertEquals(200, response.getStatus());
    response.close();

    Recipe recipeResult = recipeController.updateRecipe(testRecipe);

    Assert.assertThat(recipeResult, instanceOf(InventoryRecipe.class));
    Assert.assertEquals(testRecipe, recipeResult);
  }

  @Test
  public void deleteRecipeTest() throws Exception {
    LocationRecipe testRecipe = new LocationRecipe();
    testRecipe.setName("Old_Recipe");
    testRecipe.setReaderConfigurationName("Test_Reader_Configuration");

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