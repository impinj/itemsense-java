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
public class InventoryRecipe extends Recipe {

  private LocationAggregationModel locationAggregationModel = LocationAggregationModel.BY_TIME;
  private Integer computeWindow = 20;
  private Integer reportingInterval = 5;

  public InventoryRecipe() {
    this.setType(RecipeType.INVENTORY);
  }

  @Builder
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
}
