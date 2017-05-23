package com.impinj.itemsense.client.coordinator.recipe;

import java.time.Duration;
import java.util.LinkedHashSet;
import java.util.Map;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ThresholdRecipe extends Recipe {

  private LinkedHashSet<Integer> thresholdIds;
  private String profile;

  public ThresholdRecipe() {
    this.setType(RecipeType.THRESHOLD);
  }

  @Builder
  public ThresholdRecipe(
      String name,
      String readerConfigurationName,
      Integer tagHeartbeatMinutes,
      Duration tagHeartbeatDuration,
      Duration tagExpiryDuration,
      Map<String, String> readerConfigurations,
      LinkedHashSet<Integer> thresholdIds,
      String profile
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
  }
}
