package com.impinj.itemsense.client.coordinator;

import com.impinj.itemsense.client.coordinator.authentication.AuthenticationController;
import com.impinj.itemsense.client.coordinator.currentZoneMap.CurrentZoneMapController;
import com.impinj.itemsense.client.coordinator.thresholds.ThresholdController;
import com.impinj.itemsense.client.coordinator.facility.FacilityController;
import com.impinj.itemsense.client.coordinator.job.JobController;
import com.impinj.itemsense.client.coordinator.readerconfiguration.ReaderConfigurationController;
import com.impinj.itemsense.client.coordinator.readerdefintion.ReaderDefinitionController;
import com.impinj.itemsense.client.coordinator.readerhealth.HealthController;
import com.impinj.itemsense.client.coordinator.recipe.RecipeController;
import com.impinj.itemsense.client.coordinator.settings.snmp.SnmpController;
import com.impinj.itemsense.client.coordinator.softwareimages.SoftwareImagesController;
import com.impinj.itemsense.client.coordinator.softwareupgrades.SoftwareUpgradesController;
import com.impinj.itemsense.client.coordinator.softwareversions.SoftwareVersionsController;
import com.impinj.itemsense.client.coordinator.user.UserController;
import com.impinj.itemsense.client.coordinator.zonemap.ZoneMapController;
import com.impinj.itemsense.client.helpers.ObjectMapperContextResolver;
import java.net.URI;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;
import lombok.Data;

@Data
public class CoordinatorApiController {

  private final ObjectMapperContextResolver OBJECT_MAPPER_CONTEXT_RESOLVER
      = new ObjectMapperContextResolver();

  private AuthenticationController authenticationController;
  private CurrentZoneMapController currentZoneMapController;
  private ThresholdController thresholdController;
  private FacilityController facilityController;
  private JobController jobController;
  private ReaderConfigurationController readerConfigurationController;
  private ReaderDefinitionController readerDefinitionController;
  private RecipeController recipeController;
  private UserController userController;
  private ZoneMapController zoneMapController;
  private SnmpController snmpController;
  private SoftwareUpgradesController softwareUpgradesController;
  private SoftwareVersionsController softwareVersionsController;
  private SoftwareImagesController softwareImagesController;
  private HealthController healthController;

  private WebTarget target;

  public CoordinatorApiController(final Client client, final URI uri) {
    this.target = client.register(OBJECT_MAPPER_CONTEXT_RESOLVER).target(uri);

    this.currentZoneMapController = new CurrentZoneMapController(target);
    this.thresholdController = new ThresholdController(target);
    this.facilityController = new FacilityController(target);
    this.jobController = new JobController(target);
    this.readerConfigurationController = new ReaderConfigurationController(target);
    this.readerDefinitionController = new ReaderDefinitionController(target, client);
    this.recipeController = new RecipeController(target);
    this.userController = new UserController(target);
    this.zoneMapController = new ZoneMapController(target);
    this.authenticationController = new AuthenticationController(target);
    this.snmpController = new SnmpController(target);
    this.softwareUpgradesController = new SoftwareUpgradesController(target);
    this.softwareVersionsController = new SoftwareVersionsController(target);
    this.softwareImagesController = new SoftwareImagesController(target);
    this.healthController = new HealthController(target);
  }
}
