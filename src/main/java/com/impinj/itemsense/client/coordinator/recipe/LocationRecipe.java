package com.impinj.itemsense.client.coordinator.recipe;

import java.time.Duration;
import java.util.Map;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class LocationRecipe extends Recipe {

  private Double minimumMovementInMeters = 1.0;
  private Integer computeWindow = 10;
  private Integer reportingInterval = 5;

  public LocationRecipe() {
    this.setType(RecipeType.LOCATION);
  }

  @Builder
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
}
