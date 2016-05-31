package com.impinj.itemsense.client.coordinator;

import com.impinj.itemsense.client.coordinator.authentication.AuthenticationController;
import com.impinj.itemsense.client.coordinator.currentZoneMap.CurrentZoneMapController;
import com.impinj.itemsense.client.coordinator.facility.FacilityController;
import com.impinj.itemsense.client.coordinator.job.JobController;
import com.impinj.itemsense.client.coordinator.readerconfiguration.ReaderConfigurationController;
import com.impinj.itemsense.client.coordinator.readerdefintion.ReaderDefinitionController;
import com.impinj.itemsense.client.coordinator.recipe.RecipeController;
import com.impinj.itemsense.client.coordinator.user.UserController;
import com.impinj.itemsense.client.coordinator.zonemap.ZoneMapController;
import lombok.Data;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;
import java.net.URI;

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

    public CoordinatorApiController(final Client client, final URI uri) {
        this.target = client.target(uri);
        this.currentZoneMapController = new CurrentZoneMapController(target);
        this.facilityController = new FacilityController(target);
        this.jobController = new JobController(target);
        this.readerConfigurationController = new ReaderConfigurationController(target);
        this.readerDefinitionController = new ReaderDefinitionController(target);
        this.recipeController = new RecipeController(target);
        this.userController = new UserController(target);
        this.zoneMapController = new ZoneMapController(target);
        this.authenticationController = new AuthenticationController(target);
    }
}
