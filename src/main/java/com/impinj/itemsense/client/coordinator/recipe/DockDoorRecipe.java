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
public class DockDoorRecipe extends Recipe {

  private LinkedHashSet<Integer> doorIds;
  private String profile;

  public DockDoorRecipe() {
    this.setType(RecipeType.DOCK_DOOR);
  }

  @Builder
  public DockDoorRecipe(
      String name,
      String readerConfigurationName,
      Integer tagHeartbeatMinutes,
      Duration tagHeartbeatDuration,
      Duration tagExpiryDuration,
      Map<String, String> readerConfigurations,
      LinkedHashSet<Integer> doorIds,
      String profile
  ) {
    super(
        name,
        RecipeType.DOCK_DOOR,
        readerConfigurationName,
        tagHeartbeatMinutes,
        tagHeartbeatDuration,
        tagExpiryDuration,
        readerConfigurations);

    this.doorIds = doorIds;
    this.profile = profile;
  }
}
