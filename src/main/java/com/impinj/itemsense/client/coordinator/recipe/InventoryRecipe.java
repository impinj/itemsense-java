package com.impinj.itemsense.client.coordinator.recipe;

import java.time.Duration;
import java.util.Map;

public class InventoryRecipe extends Recipe {

  private LocationAggregationModel locationAggregationModel = LocationAggregationModel.BY_TIME;
  private Integer computeWindow = 20;
  private Integer reportingInterval = 5;

  public InventoryRecipe() {
    this.setType(RecipeType.INVENTORY);
  }

  public InventoryRecipe(
      String name,
      String readerConfigurationName,
      Integer tagHeartbeatMinutes,
      Duration tagHeartbeatDuration,
      Duration tagExpiryDuration,
      Map<String, String> readerConfigurations,
      LocationAggregationModel locationAggregationModel,
      Integer computeWindow,
      Integer reportingInterval
  ) {
    super(
        name,
        RecipeType.INVENTORY,
        readerConfigurationName,
        tagHeartbeatMinutes,
        tagHeartbeatDuration,
        tagExpiryDuration,
        readerConfigurations);

    this.locationAggregationModel = locationAggregationModel;
    this.computeWindow = computeWindow;
    this.reportingInterval = reportingInterval;

  }

  public static InventoryRecipeBuilder builder() {return new InventoryRecipeBuilder();}

  public LocationAggregationModel getLocationAggregationModel() {return this.locationAggregationModel;}

  public Integer getComputeWindow() {return this.computeWindow;}

  public Integer getReportingInterval() {return this.reportingInterval;}

  public void setLocationAggregationModel(LocationAggregationModel locationAggregationModel) {this.locationAggregationModel = locationAggregationModel; }

  public void setComputeWindow(Integer computeWindow) {this.computeWindow = computeWindow; }

  public void setReportingInterval(Integer reportingInterval) {this.reportingInterval = reportingInterval; }

  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (!(o instanceof InventoryRecipe)) {
      return false;
    }
    final InventoryRecipe other = (InventoryRecipe) o;
    if (!super.equals(o)) {
      return false;
    }
    final Object this$locationAggregationModel = this.getLocationAggregationModel();
    final Object other$locationAggregationModel = other.getLocationAggregationModel();
    if (this$locationAggregationModel == null ? other$locationAggregationModel != null
                                              : !this$locationAggregationModel.equals(
                                                  other$locationAggregationModel)) {
      return false;
    }
    final Object this$computeWindow = this.getComputeWindow();
    final Object other$computeWindow = other.getComputeWindow();
    if (this$computeWindow == null ? other$computeWindow != null : !this$computeWindow.equals(
        other$computeWindow)) {
      return false;
    }
    final Object this$reportingInterval = this.getReportingInterval();
    final Object other$reportingInterval = other.getReportingInterval();
    return this$reportingInterval == null ? other$reportingInterval == null
                                          : this$reportingInterval.equals(other$reportingInterval);
  }

  public int hashCode() {
    final int PRIME = 59;
    int result = 1;
    result = result * PRIME + super.hashCode();
    final Object $locationAggregationModel = this.getLocationAggregationModel();
    result = result * PRIME + ($locationAggregationModel == null ? 43 : $locationAggregationModel
        .hashCode());
    final Object $computeWindow = this.getComputeWindow();
    result = result * PRIME + ($computeWindow == null ? 43 : $computeWindow.hashCode());
    final Object $reportingInterval = this.getReportingInterval();
    result = result * PRIME + ($reportingInterval == null ? 43 : $reportingInterval.hashCode());
    return result;
  }

  public String toString() {
    return "com.impinj.itemsense.client.coordinator.recipe.InventoryRecipe(super=" + super
        .toString() + ", locationAggregationModel=" + this.getLocationAggregationModel()
        + ", computeWindow=" + this.getComputeWindow() + ", reportingInterval=" + this
        .getReportingInterval() + ")";
  }

  public static class InventoryRecipeBuilder {

    private String name;
    private String readerConfigurationName;
    private Integer tagHeartbeatMinutes;
    private Duration tagHeartbeatDuration;
    private Duration tagExpiryDuration;
    private Map<String, String> readerConfigurations;
    private LocationAggregationModel locationAggregationModel;
    private Integer computeWindow;
    private Integer reportingInterval;

    InventoryRecipeBuilder() {}

    public InventoryRecipe.InventoryRecipeBuilder name(String name) {
      this.name = name;
      return this;
    }

    public InventoryRecipe.InventoryRecipeBuilder readerConfigurationName(String readerConfigurationName) {
      this.readerConfigurationName = readerConfigurationName;
      return this;
    }

    public InventoryRecipe.InventoryRecipeBuilder tagHeartbeatMinutes(Integer tagHeartbeatMinutes) {
      this.tagHeartbeatMinutes = tagHeartbeatMinutes;
      return this;
    }

    public InventoryRecipe.InventoryRecipeBuilder tagHeartbeatDuration(Duration tagHeartbeatDuration) {
      this.tagHeartbeatDuration = tagHeartbeatDuration;
      return this;
    }

    public InventoryRecipe.InventoryRecipeBuilder tagExpiryDuration(Duration tagExpiryDuration) {
      this.tagExpiryDuration = tagExpiryDuration;
      return this;
    }

    public InventoryRecipe.InventoryRecipeBuilder readerConfigurations(Map<String, String> readerConfigurations) {
      this.readerConfigurations = readerConfigurations;
      return this;
    }

    public InventoryRecipe.InventoryRecipeBuilder locationAggregationModel(LocationAggregationModel locationAggregationModel) {
      this.locationAggregationModel = locationAggregationModel;
      return this;
    }

    public InventoryRecipe.InventoryRecipeBuilder computeWindow(Integer computeWindow) {
      this.computeWindow = computeWindow;
      return this;
    }

    public InventoryRecipe.InventoryRecipeBuilder reportingInterval(Integer reportingInterval) {
      this.reportingInterval = reportingInterval;
      return this;
    }

    public InventoryRecipe build() {
      return new InventoryRecipe(
          name,
          readerConfigurationName,
          tagHeartbeatMinutes,
          tagHeartbeatDuration,
          tagExpiryDuration,
          readerConfigurations,
          locationAggregationModel,
          computeWindow,
          reportingInterval);
    }

    public String toString() {
      return
          "com.impinj.itemsense.client.coordinator.recipe.InventoryRecipe.InventoryRecipeBuilder(name="
              + this.name + ", readerConfigurationName=" + this.readerConfigurationName
              + ", tagHeartbeatMinutes=" + this.tagHeartbeatMinutes + ", tagHeartbeatDuration="
              + this.tagHeartbeatDuration + ", tagExpiryDuration=" + this.tagExpiryDuration
              + ", readerConfigurations=" + this.readerConfigurations
              + ", locationAggregationModel="
              + this.locationAggregationModel + ", computeWindow=" + this.computeWindow
              + ", reportingInterval=" + this.reportingInterval + ")";
    }
  }
}
