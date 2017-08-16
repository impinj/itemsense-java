package com.impinj.itemsense.client.coordinator.recipe;

import java.time.Duration;
import java.util.Map;

public class LocationRecipe extends Recipe {

  private Double minimumMovementInMeters = 1.0;
  private Integer computeWindow = 10;
  private Integer reportingInterval = 5;

  public LocationRecipe() {
    this.setType(RecipeType.LOCATION);
  }

  public LocationRecipe(
      String name,
      String readerConfigurationName,
      Integer tagHeartbeatMinutes,
      Duration tagHeartbeatDuration,
      Duration tagExpiryDuration,
      Map<String, String> readerConfigurations,
      Double minimumMovementInMeters,
      Integer computeWindow,
      Integer reportingInterval
  ) {
    super(
        name,
        RecipeType.LOCATION,
        readerConfigurationName,
        tagHeartbeatMinutes,
        tagHeartbeatDuration,
        tagExpiryDuration,
        readerConfigurations);

    this.minimumMovementInMeters = minimumMovementInMeters;
    this.computeWindow = computeWindow;
    this.reportingInterval = reportingInterval;

  }

  public static LocationRecipeBuilder builder() {return new LocationRecipeBuilder();}

  public Double getMinimumMovementInMeters() {return this.minimumMovementInMeters;}

  public Integer getComputeWindow() {return this.computeWindow;}

  public Integer getReportingInterval() {return this.reportingInterval;}

  public void setMinimumMovementInMeters(Double minimumMovementInMeters) {this.minimumMovementInMeters = minimumMovementInMeters; }

  public void setComputeWindow(Integer computeWindow) {this.computeWindow = computeWindow; }

  public void setReportingInterval(Integer reportingInterval) {this.reportingInterval = reportingInterval; }

  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (!(o instanceof LocationRecipe)) {
      return false;
    }
    final LocationRecipe other = (LocationRecipe) o;
    if (!super.equals(o)) {
      return false;
    }
    final Object this$minimumMovementInMeters = this.getMinimumMovementInMeters();
    final Object other$minimumMovementInMeters = other.getMinimumMovementInMeters();
    if (this$minimumMovementInMeters == null ? other$minimumMovementInMeters != null
                                             : !this$minimumMovementInMeters.equals(
                                                 other$minimumMovementInMeters)) {
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
    final Object $minimumMovementInMeters = this.getMinimumMovementInMeters();
    result = result * PRIME + ($minimumMovementInMeters == null ? 43 : $minimumMovementInMeters
        .hashCode());
    final Object $computeWindow = this.getComputeWindow();
    result = result * PRIME + ($computeWindow == null ? 43 : $computeWindow.hashCode());
    final Object $reportingInterval = this.getReportingInterval();
    result = result * PRIME + ($reportingInterval == null ? 43 : $reportingInterval.hashCode());
    return result;
  }

  public String toString() {
    return "com.impinj.itemsense.client.coordinator.recipe.LocationRecipe(super=" + super.toString()
        + ", minimumMovementInMeters=" + this.getMinimumMovementInMeters() + ", computeWindow="
        + this.getComputeWindow() + ", reportingInterval=" + this.getReportingInterval() + ")";
  }

  public static class LocationRecipeBuilder {

    private String name;
    private String readerConfigurationName;
    private Integer tagHeartbeatMinutes;
    private Duration tagHeartbeatDuration;
    private Duration tagExpiryDuration;
    private Map<String, String> readerConfigurations;
    private Double minimumMovementInMeters;
    private Integer computeWindow;
    private Integer reportingInterval;

    LocationRecipeBuilder() {}

    public LocationRecipe.LocationRecipeBuilder name(String name) {
      this.name = name;
      return this;
    }

    public LocationRecipe.LocationRecipeBuilder readerConfigurationName(String readerConfigurationName) {
      this.readerConfigurationName = readerConfigurationName;
      return this;
    }

    public LocationRecipe.LocationRecipeBuilder tagHeartbeatMinutes(Integer tagHeartbeatMinutes) {
      this.tagHeartbeatMinutes = tagHeartbeatMinutes;
      return this;
    }

    public LocationRecipe.LocationRecipeBuilder tagHeartbeatDuration(Duration tagHeartbeatDuration) {
      this.tagHeartbeatDuration = tagHeartbeatDuration;
      return this;
    }

    public LocationRecipe.LocationRecipeBuilder tagExpiryDuration(Duration tagExpiryDuration) {
      this.tagExpiryDuration = tagExpiryDuration;
      return this;
    }

    public LocationRecipe.LocationRecipeBuilder readerConfigurations(Map<String, String> readerConfigurations) {
      this.readerConfigurations = readerConfigurations;
      return this;
    }

    public LocationRecipe.LocationRecipeBuilder minimumMovementInMeters(Double minimumMovementInMeters) {
      this.minimumMovementInMeters = minimumMovementInMeters;
      return this;
    }

    public LocationRecipe.LocationRecipeBuilder computeWindow(Integer computeWindow) {
      this.computeWindow = computeWindow;
      return this;
    }

    public LocationRecipe.LocationRecipeBuilder reportingInterval(Integer reportingInterval) {
      this.reportingInterval = reportingInterval;
      return this;
    }

    public LocationRecipe build() {
      return new LocationRecipe(
          name,
          readerConfigurationName,
          tagHeartbeatMinutes,
          tagHeartbeatDuration,
          tagExpiryDuration,
          readerConfigurations,
          minimumMovementInMeters,
          computeWindow,
          reportingInterval);
    }

    public String toString() {
      return
          "com.impinj.itemsense.client.coordinator.recipe.LocationRecipe.LocationRecipeBuilder(name="
              + this.name + ", readerConfigurationName=" + this.readerConfigurationName
              + ", tagHeartbeatMinutes=" + this.tagHeartbeatMinutes + ", tagHeartbeatDuration="
              + this.tagHeartbeatDuration + ", tagExpiryDuration=" + this.tagExpiryDuration
              + ", readerConfigurations=" + this.readerConfigurations + ", minimumMovementInMeters="
              + this.minimumMovementInMeters + ", computeWindow=" + this.computeWindow
              + ", reportingInterval=" + this.reportingInterval + ")";
    }
  }
}
