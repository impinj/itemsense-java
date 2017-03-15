package com.impinj.itemsense.client.coordinator.recipe;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public enum RecipeType {
  DOCK_DOOR,
  INVENTORY,
  LOCATION
}
