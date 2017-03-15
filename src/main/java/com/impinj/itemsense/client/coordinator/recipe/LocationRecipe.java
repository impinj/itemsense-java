package com.impinj.itemsense.client.coordinator.recipe;

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
}
