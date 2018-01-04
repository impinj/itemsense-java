package com.impinj.itemsense.client.coordinator;

import com.impinj.itemsense.client.coordinator.authentication.AuthenticationController;
import com.impinj.itemsense.client.coordinator.currentZoneMap.CurrentZoneMapController;
import com.impinj.itemsense.client.coordinator.facility.FacilityController;
import com.impinj.itemsense.client.coordinator.job.JobController;
import com.impinj.itemsense.client.coordinator.readerconfiguration.ReaderConfigurationController;
import com.impinj.itemsense.client.coordinator.readerdefinition.ReaderDefinitionController;
import com.impinj.itemsense.client.coordinator.readerhealth.HealthController;
import com.impinj.itemsense.client.coordinator.recipe.RecipeController;
import com.impinj.itemsense.client.coordinator.settings.snmp.SnmpController;
import com.impinj.itemsense.client.coordinator.softwareimages.SoftwareImagesController;
import com.impinj.itemsense.client.coordinator.softwareupgrades.SoftwareUpgradesController;
import com.impinj.itemsense.client.coordinator.softwareversions.SoftwareVersionsController;
import com.impinj.itemsense.client.coordinator.thresholds.ThresholdController;
import com.impinj.itemsense.client.coordinator.user.UserController;
import com.impinj.itemsense.client.coordinator.zonemap.ZoneMapController;
import com.impinj.itemsense.client.helpers.ObjectMapperContextResolver;
import java.net.URI;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;

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

  public ObjectMapperContextResolver getOBJECT_MAPPER_CONTEXT_RESOLVER() {return this.OBJECT_MAPPER_CONTEXT_RESOLVER;}

  public AuthenticationController getAuthenticationController() {return this.authenticationController;}

  public CurrentZoneMapController getCurrentZoneMapController() {return this.currentZoneMapController;}

  public ThresholdController getThresholdController() {return this.thresholdController;}

  public FacilityController getFacilityController() {return this.facilityController;}

  public JobController getJobController() {return this.jobController;}

  public ReaderConfigurationController getReaderConfigurationController() {return this.readerConfigurationController;}

  public ReaderDefinitionController getReaderDefinitionController() {return this.readerDefinitionController;}

  public RecipeController getRecipeController() {return this.recipeController;}

  public UserController getUserController() {return this.userController;}

  public ZoneMapController getZoneMapController() {return this.zoneMapController;}

  public SnmpController getSnmpController() {return this.snmpController;}

  public SoftwareUpgradesController getSoftwareUpgradesController() {return this.softwareUpgradesController;}

  public SoftwareVersionsController getSoftwareVersionsController() {return this.softwareVersionsController;}

  public SoftwareImagesController getSoftwareImagesController() {return this.softwareImagesController;}

  public HealthController getHealthController() {return this.healthController;}

  public WebTarget getTarget() {return this.target;}

  public void setAuthenticationController(AuthenticationController authenticationController) {this.authenticationController = authenticationController; }

  public void setCurrentZoneMapController(CurrentZoneMapController currentZoneMapController) {this.currentZoneMapController = currentZoneMapController; }

  public void setThresholdController(ThresholdController thresholdController) {this.thresholdController = thresholdController; }

  public void setFacilityController(FacilityController facilityController) {this.facilityController = facilityController; }

  public void setJobController(JobController jobController) {this.jobController = jobController; }

  public void setReaderConfigurationController(ReaderConfigurationController readerConfigurationController) {this.readerConfigurationController = readerConfigurationController; }

  public void setReaderDefinitionController(ReaderDefinitionController readerDefinitionController) {this.readerDefinitionController = readerDefinitionController; }

  public void setRecipeController(RecipeController recipeController) {this.recipeController = recipeController; }

  public void setUserController(UserController userController) {this.userController = userController; }

  public void setZoneMapController(ZoneMapController zoneMapController) {this.zoneMapController = zoneMapController; }

  public void setSnmpController(SnmpController snmpController) {this.snmpController = snmpController; }

  public void setSoftwareUpgradesController(SoftwareUpgradesController softwareUpgradesController) {this.softwareUpgradesController = softwareUpgradesController; }

  public void setSoftwareVersionsController(SoftwareVersionsController softwareVersionsController) {this.softwareVersionsController = softwareVersionsController; }

  public void setSoftwareImagesController(SoftwareImagesController softwareImagesController) {this.softwareImagesController = softwareImagesController; }

  public void setHealthController(HealthController healthController) {this.healthController = healthController; }

  public void setTarget(WebTarget target) {this.target = target; }

  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (!(o instanceof CoordinatorApiController)) {
      return false;
    }
    final CoordinatorApiController other = (CoordinatorApiController) o;
    final Object this$OBJECT_MAPPER_CONTEXT_RESOLVER = this.getOBJECT_MAPPER_CONTEXT_RESOLVER();
    final Object other$OBJECT_MAPPER_CONTEXT_RESOLVER = other.getOBJECT_MAPPER_CONTEXT_RESOLVER();
    if (this$OBJECT_MAPPER_CONTEXT_RESOLVER == null ? other$OBJECT_MAPPER_CONTEXT_RESOLVER != null
                                                    : !this$OBJECT_MAPPER_CONTEXT_RESOLVER.equals(
                                                        other$OBJECT_MAPPER_CONTEXT_RESOLVER)) {
      return false;
    }
    final Object this$authenticationController = this.getAuthenticationController();
    final Object other$authenticationController = other.getAuthenticationController();
    if (this$authenticationController == null ? other$authenticationController != null
                                              : !this$authenticationController.equals(
                                                  other$authenticationController)) {
      return false;
    }
    final Object this$currentZoneMapController = this.getCurrentZoneMapController();
    final Object other$currentZoneMapController = other.getCurrentZoneMapController();
    if (this$currentZoneMapController == null ? other$currentZoneMapController != null
                                              : !this$currentZoneMapController.equals(
                                                  other$currentZoneMapController)) {
      return false;
    }
    final Object this$thresholdController = this.getThresholdController();
    final Object other$thresholdController = other.getThresholdController();
    if (this$thresholdController == null ? other$thresholdController != null
                                         : !this$thresholdController.equals(
                                             other$thresholdController)) {
      return false;
    }
    final Object this$facilityController = this.getFacilityController();
    final Object other$facilityController = other.getFacilityController();
    if (this$facilityController == null ? other$facilityController != null
                                        : !this$facilityController
                                            .equals(other$facilityController)) {
      return false;
    }
    final Object this$jobController = this.getJobController();
    final Object other$jobController = other.getJobController();
    if (this$jobController == null ? other$jobController != null : !this$jobController.equals(
        other$jobController)) {
      return false;
    }
    final Object this$readerConfigurationController = this.getReaderConfigurationController();
    final Object other$readerConfigurationController = other.getReaderConfigurationController();
    if (this$readerConfigurationController == null ? other$readerConfigurationController != null
                                                   : !this$readerConfigurationController.equals(
                                                       other$readerConfigurationController)) {
      return false;
    }
    final Object this$readerDefinitionController = this.getReaderDefinitionController();
    final Object other$readerDefinitionController = other.getReaderDefinitionController();
    if (this$readerDefinitionController == null ? other$readerDefinitionController != null
                                                : !this$readerDefinitionController.equals(
                                                    other$readerDefinitionController)) {
      return false;
    }
    final Object this$recipeController = this.getRecipeController();
    final Object other$recipeController = other.getRecipeController();
    if (this$recipeController == null ? other$recipeController != null
                                      : !this$recipeController.equals(other$recipeController)) {
      return false;
    }
    final Object this$userController = this.getUserController();
    final Object other$userController = other.getUserController();
    if (this$userController == null ? other$userController != null : !this$userController.equals(
        other$userController)) {
      return false;
    }
    final Object this$zoneMapController = this.getZoneMapController();
    final Object other$zoneMapController = other.getZoneMapController();
    if (this$zoneMapController == null ? other$zoneMapController != null
                                       : !this$zoneMapController.equals(other$zoneMapController)) {
      return false;
    }
    final Object this$snmpController = this.getSnmpController();
    final Object other$snmpController = other.getSnmpController();
    if (this$snmpController == null ? other$snmpController != null : !this$snmpController.equals(
        other$snmpController)) {
      return false;
    }
    final Object this$softwareUpgradesController = this.getSoftwareUpgradesController();
    final Object other$softwareUpgradesController = other.getSoftwareUpgradesController();
    if (this$softwareUpgradesController == null ? other$softwareUpgradesController != null
                                                : !this$softwareUpgradesController.equals(
                                                    other$softwareUpgradesController)) {
      return false;
    }
    final Object this$softwareVersionsController = this.getSoftwareVersionsController();
    final Object other$softwareVersionsController = other.getSoftwareVersionsController();
    if (this$softwareVersionsController == null ? other$softwareVersionsController != null
                                                : !this$softwareVersionsController.equals(
                                                    other$softwareVersionsController)) {
      return false;
    }
    final Object this$softwareImagesController = this.getSoftwareImagesController();
    final Object other$softwareImagesController = other.getSoftwareImagesController();
    if (this$softwareImagesController == null ? other$softwareImagesController != null
                                              : !this$softwareImagesController.equals(
                                                  other$softwareImagesController)) {
      return false;
    }
    final Object this$healthController = this.getHealthController();
    final Object other$healthController = other.getHealthController();
    if (this$healthController == null ? other$healthController != null
                                      : !this$healthController.equals(other$healthController)) {
      return false;
    }
    final Object this$target = this.getTarget();
    final Object other$target = other.getTarget();
    return this$target == null ? other$target == null : this$target.equals(other$target);
  }

  public int hashCode() {
    final int PRIME = 59;
    int result = 1;
    final Object $OBJECT_MAPPER_CONTEXT_RESOLVER = this.getOBJECT_MAPPER_CONTEXT_RESOLVER();
    result = result * PRIME + ($OBJECT_MAPPER_CONTEXT_RESOLVER == null ? 43
                                                                       : $OBJECT_MAPPER_CONTEXT_RESOLVER
                                   .hashCode());
    final Object $authenticationController = this.getAuthenticationController();
    result = result * PRIME + ($authenticationController == null ? 43 : $authenticationController
        .hashCode());
    final Object $currentZoneMapController = this.getCurrentZoneMapController();
    result = result * PRIME + ($currentZoneMapController == null ? 43 : $currentZoneMapController
        .hashCode());
    final Object $thresholdController = this.getThresholdController();
    result = result * PRIME + ($thresholdController == null ? 43 : $thresholdController.hashCode());
    final Object $facilityController = this.getFacilityController();
    result = result * PRIME + ($facilityController == null ? 43 : $facilityController.hashCode());
    final Object $jobController = this.getJobController();
    result = result * PRIME + ($jobController == null ? 43 : $jobController.hashCode());
    final Object $readerConfigurationController = this.getReaderConfigurationController();
    result = result * PRIME + ($readerConfigurationController == null ? 43
                                                                      : $readerConfigurationController
                                   .hashCode());
    final Object $readerDefinitionController = this.getReaderDefinitionController();
    result = result * PRIME + ($readerDefinitionController == null ? 43
                                                                   : $readerDefinitionController
                                   .hashCode());
    final Object $recipeController = this.getRecipeController();
    result = result * PRIME + ($recipeController == null ? 43 : $recipeController.hashCode());
    final Object $userController = this.getUserController();
    result = result * PRIME + ($userController == null ? 43 : $userController.hashCode());
    final Object $zoneMapController = this.getZoneMapController();
    result = result * PRIME + ($zoneMapController == null ? 43 : $zoneMapController.hashCode());
    final Object $snmpController = this.getSnmpController();
    result = result * PRIME + ($snmpController == null ? 43 : $snmpController.hashCode());
    final Object $softwareUpgradesController = this.getSoftwareUpgradesController();
    result = result * PRIME + ($softwareUpgradesController == null ? 43
                                                                   : $softwareUpgradesController
                                   .hashCode());
    final Object $softwareVersionsController = this.getSoftwareVersionsController();
    result = result * PRIME + ($softwareVersionsController == null ? 43
                                                                   : $softwareVersionsController
                                   .hashCode());
    final Object $softwareImagesController = this.getSoftwareImagesController();
    result = result * PRIME + ($softwareImagesController == null ? 43 : $softwareImagesController
        .hashCode());
    final Object $healthController = this.getHealthController();
    result = result * PRIME + ($healthController == null ? 43 : $healthController.hashCode());
    final Object $target = this.getTarget();
    result = result * PRIME + ($target == null ? 43 : $target.hashCode());
    return result;
  }

  public String toString() {
    return
        "com.impinj.itemsense.client.coordinator.CoordinatorApiController(OBJECT_MAPPER_CONTEXT_RESOLVER="
            + this.getOBJECT_MAPPER_CONTEXT_RESOLVER() + ", authenticationController=" + this
            .getAuthenticationController() + ", currentZoneMapController=" + this
            .getCurrentZoneMapController() + ", thresholdController=" + this
            .getThresholdController() + ", facilityController=" + this.getFacilityController()
            + ", jobController=" + this.getJobController() + ", readerConfigurationController="
            + this.getReaderConfigurationController() + ", readerDefinitionController=" + this
            .getReaderDefinitionController() + ", recipeController=" + this.getRecipeController()
            + ", userController=" + this.getUserController() + ", zoneMapController=" + this
            .getZoneMapController() + ", snmpController=" + this.getSnmpController()
            + ", softwareUpgradesController=" + this.getSoftwareUpgradesController()
            + ", softwareVersionsController=" + this.getSoftwareVersionsController()
            + ", softwareImagesController=" + this.getSoftwareImagesController()
            + ", healthController=" + this.getHealthController() + ", target=" + this.getTarget()
            + ")";
  }
}
