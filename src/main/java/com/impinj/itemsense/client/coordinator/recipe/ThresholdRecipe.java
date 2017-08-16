package com.impinj.itemsense.client.coordinator.recipe;

import java.time.Duration;
import java.util.LinkedHashSet;
import java.util.Map;

public class ThresholdRecipe extends Recipe {

  private LinkedHashSet<Integer> thresholdIds;
  private String profile;
  private boolean iterationDataLogEnabled;

  public ThresholdRecipe() {
    this.setType(RecipeType.THRESHOLD);
  }

  public ThresholdRecipe(
      String name,
      String readerConfigurationName,
      Integer tagHeartbeatMinutes,
      Duration tagHeartbeatDuration,
      Duration tagExpiryDuration,
      Map<String, String> readerConfigurations,
      LinkedHashSet<Integer> thresholdIds,
      String profile,
      boolean iterationDataLogEnabled
  ) {
    super(
        name,
        RecipeType.THRESHOLD,
        readerConfigurationName,
        tagHeartbeatMinutes,
        tagHeartbeatDuration,
        tagExpiryDuration,
        readerConfigurations);

    this.thresholdIds = thresholdIds;
    this.profile = profile;
    this.iterationDataLogEnabled = iterationDataLogEnabled;
  }

  public static ThresholdRecipeBuilder builder() {return new ThresholdRecipeBuilder();}

  public LinkedHashSet<Integer> getThresholdIds() {return this.thresholdIds;}

  public String getProfile() {return this.profile;}

  public boolean isIterationDataLogEnabled() {return this.iterationDataLogEnabled;}

  public void setThresholdIds(LinkedHashSet<Integer> thresholdIds) {this.thresholdIds = thresholdIds; }

  public void setProfile(String profile) {this.profile = profile; }

  public void setIterationDataLogEnabled(boolean iterationDataLogEnabled) {this.iterationDataLogEnabled = iterationDataLogEnabled; }

  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (!(o instanceof ThresholdRecipe)) {
      return false;
    }
    final ThresholdRecipe other = (ThresholdRecipe) o;
    if (!super.equals(o)) {
      return false;
    }
    final Object this$thresholdIds = this.getThresholdIds();
    final Object other$thresholdIds = other.getThresholdIds();
    if (this$thresholdIds == null ? other$thresholdIds != null : !this$thresholdIds.equals(
        other$thresholdIds)) {
      return false;
    }
    final Object this$profile = this.getProfile();
    final Object other$profile = other.getProfile();
    if (this$profile == null ? other$profile != null : !this$profile.equals(other$profile)) {
      return false;
    }
    return this.isIterationDataLogEnabled() == other.isIterationDataLogEnabled();
  }

  public int hashCode() {
    final int PRIME = 59;
    int result = 1;
    result = result * PRIME + super.hashCode();
    final Object $thresholdIds = this.getThresholdIds();
    result = result * PRIME + ($thresholdIds == null ? 43 : $thresholdIds.hashCode());
    final Object $profile = this.getProfile();
    result = result * PRIME + ($profile == null ? 43 : $profile.hashCode());
    result = result * PRIME + (this.isIterationDataLogEnabled() ? 79 : 97);
    return result;
  }

  public String toString() {
    return "com.impinj.itemsense.client.coordinator.recipe.ThresholdRecipe(super=" + super
        .toString() + ", thresholdIds=" + this.getThresholdIds() + ", profile=" + this.getProfile()
        + ", iterationDataLogEnabled=" + this.isIterationDataLogEnabled() + ")";
  }

  public static class ThresholdRecipeBuilder {

    private String name;
    private String readerConfigurationName;
    private Integer tagHeartbeatMinutes;
    private Duration tagHeartbeatDuration;
    private Duration tagExpiryDuration;
    private Map<String, String> readerConfigurations;
    private LinkedHashSet<Integer> thresholdIds;
    private String profile;
    private boolean iterationDataLogEnabled;

    ThresholdRecipeBuilder() {}

    public ThresholdRecipe.ThresholdRecipeBuilder name(String name) {
      this.name = name;
      return this;
    }

    public ThresholdRecipe.ThresholdRecipeBuilder readerConfigurationName(String readerConfigurationName) {
      this.readerConfigurationName = readerConfigurationName;
      return this;
    }

    public ThresholdRecipe.ThresholdRecipeBuilder tagHeartbeatMinutes(Integer tagHeartbeatMinutes) {
      this.tagHeartbeatMinutes = tagHeartbeatMinutes;
      return this;
    }

    public ThresholdRecipe.ThresholdRecipeBuilder tagHeartbeatDuration(Duration tagHeartbeatDuration) {
      this.tagHeartbeatDuration = tagHeartbeatDuration;
      return this;
    }

    public ThresholdRecipe.ThresholdRecipeBuilder tagExpiryDuration(Duration tagExpiryDuration) {
      this.tagExpiryDuration = tagExpiryDuration;
      return this;
    }

    public ThresholdRecipe.ThresholdRecipeBuilder readerConfigurations(Map<String, String> readerConfigurations) {
      this.readerConfigurations = readerConfigurations;
      return this;
    }

    public ThresholdRecipe.ThresholdRecipeBuilder thresholdIds(LinkedHashSet<Integer> thresholdIds) {
      this.thresholdIds = thresholdIds;
      return this;
    }

    public ThresholdRecipe.ThresholdRecipeBuilder profile(String profile) {
      this.profile = profile;
      return this;
    }

    public ThresholdRecipe.ThresholdRecipeBuilder iterationDataLogEnabled(boolean iterationDataLogEnabled) {
      this.iterationDataLogEnabled = iterationDataLogEnabled;
      return this;
    }

    public ThresholdRecipe build() {
      return new ThresholdRecipe(
          name,
          readerConfigurationName,
          tagHeartbeatMinutes,
          tagHeartbeatDuration,
          tagExpiryDuration,
          readerConfigurations,
          thresholdIds,
          profile,
          iterationDataLogEnabled);
    }

    public String toString() {
      return
          "com.impinj.itemsense.client.coordinator.recipe.ThresholdRecipe.ThresholdRecipeBuilder(name="
              + this.name + ", readerConfigurationName=" + this.readerConfigurationName
              + ", tagHeartbeatMinutes=" + this.tagHeartbeatMinutes + ", tagHeartbeatDuration="
              + this.tagHeartbeatDuration + ", tagExpiryDuration=" + this.tagExpiryDuration
              + ", readerConfigurations=" + this.readerConfigurations + ", thresholdIds="
              + this.thresholdIds + ", profile=" + this.profile + ", iterationDataLogEnabled="
              + this.iterationDataLogEnabled + ")";
    }
  }
}
