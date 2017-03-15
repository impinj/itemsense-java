package com.impinj.itemsense.client.coordinator.recipe;

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
}
