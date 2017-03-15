package com.impinj.itemsense.client.coordinator.recipe;

import java.util.LinkedHashSet;

public class DockDoorRecipe extends Recipe {

  private LinkedHashSet<Integer> doorIds;
  private Boolean reportInTransitions;
  private Boolean reportOutTransitions;
  private Integer reportingInterval;
  private Double outRatio;
  private Double inRatio;
  private Integer minOutCount;
  private Integer minInCount;
  private Integer evalWindow;
  private Integer extendedTimeStep;
  private Long timeStepMillis;
  private int lookbackWindow;
  private Integer rssiLookBackStep;
  private Double minOutRssi;
  private Double minInRssi;
  private Double maxLeftRightInRatio;
  private Double maxLeftRightOutRatio;

  public DockDoorRecipe() {
    this.setType(RecipeType.DOCK_DOOR);
  }
}
