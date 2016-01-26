package com.impinj.itemsense.client.coordinator;

import com.google.gson.Gson;
import com.impinj.itemsense.client.coordinator.authentication.AuthenticationController;
import com.impinj.itemsense.client.coordinator.facility.FacilityController;
import com.impinj.itemsense.client.coordinator.job.JobController;
import com.impinj.itemsense.client.coordinator.readerconfiguration.ReaderConfigurationController;
import com.impinj.itemsense.client.coordinator.readerdefintion.ReaderDefinitionController;
import com.impinj.itemsense.client.coordinator.recipe.RecipeController;
import com.impinj.itemsense.client.coordinator.recipe.ZoneModel;
import com.impinj.itemsense.client.coordinator.user.UserController;
import com.impinj.itemsense.client.coordinator.zonemap.ZoneMapController;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;
import java.net.URI;

/**
 * Created by jcombopi on 1/25/16.
 */
public class CoordinatorApiController {
    private AuthenticationController authenticationController;
    private FacilityController facilityController;
    private JobController jobController;
    private ReaderConfigurationController readerConfigurationController;
    private ReaderDefinitionController readerDefinitionController;
    private RecipeController recipeController;
    private UserController userController;
    private ZoneMapController zoneMapController;

    private WebTarget target;
    private Gson gson;

    public CoordinatorApiController(final Gson gson, final Client client, final URI uri ){
        this.gson = gson;
        this.target = client.target(uri);
    }
}
