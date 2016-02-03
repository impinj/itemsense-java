package com.impinj.itemsense.client.coordinator;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.impinj.itemsense.client.coordinator.authentication.AuthenticationController;
import com.impinj.itemsense.client.coordinator.currentZoneMap.CurrentZoneMapController;
import com.impinj.itemsense.client.coordinator.facility.FacilityController;
import com.impinj.itemsense.client.coordinator.job.JobController;
import com.impinj.itemsense.client.coordinator.readerconfiguration.ReaderConfigurationController;
import com.impinj.itemsense.client.coordinator.readerdefintion.ReaderDefinitionController;
import com.impinj.itemsense.client.coordinator.recipe.RecipeController;
import com.impinj.itemsense.client.coordinator.user.UserController;
import com.impinj.itemsense.client.coordinator.zonemap.ZoneMapController;
import com.impinj.itemsense.client.helpers.ZonedDateTimeSerialization;
import lombok.Data;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;
import java.net.URI;
import java.time.ZonedDateTime;

/**
 * Created by jcombopi on 1/25/16.
 */
@Data
public class CoordinatorApiController {
    private AuthenticationController authenticationController;
    private CurrentZoneMapController currentZoneMapController;
    private FacilityController facilityController;
    private JobController jobController;
    private ReaderConfigurationController readerConfigurationController;
    private ReaderDefinitionController readerDefinitionController;
    private RecipeController recipeController;
    private UserController userController;
    private ZoneMapController zoneMapController;

    private WebTarget target;
    private Gson gson;

    public CoordinatorApiController(final Client client, final URI uri) {
        this(new GsonBuilder().registerTypeAdapter(ZonedDateTime.class, new ZonedDateTimeSerialization()).create(), client, uri);
    }
    public CoordinatorApiController(final Gson gson, final Client client, final URI uri){
        this.target = client.target(uri);
        this.gson = gson;
        this.currentZoneMapController = new CurrentZoneMapController(gson, target);
        this.facilityController = new FacilityController(gson, target);
        this.jobController = new JobController(gson, target);
        this.readerConfigurationController = new ReaderConfigurationController(gson, target);
        this.readerDefinitionController = new ReaderDefinitionController(gson, target);
        this.recipeController = new RecipeController(gson, target);
        this.userController = new UserController(gson, target);
        this.zoneMapController = new ZoneMapController(gson, target);
    }
}
