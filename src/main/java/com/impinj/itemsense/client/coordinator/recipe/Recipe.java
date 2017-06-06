package com.impinj.itemsense.client.coordinator.recipe;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import java.time.Duration;
import java.util.LinkedHashMap;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME,
    include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "type", visible = true)
@JsonSubTypes({
    @JsonSubTypes.Type(value = InventoryRecipe.class, name = "INVENTORY"),
    @JsonSubTypes.Type(value = LocationRecipe.class, name = "LOCATION"),
    @JsonSubTypes.Type(value = ThresholdRecipe.class, name = "THRESHOLD")
})
public abstract class Recipe {

  private String name;
  private RecipeType type;
  private String readerConfigurationName;

  /**
   * @deprecated - use {@link #tagHeartbeatDuration} instead
   */
  @Deprecated
  private Integer tagHeartbeatMinutes;
  private Duration tagHeartbeatDuration;
  private Duration tagExpiryDuration;
  private Map<String, String> readerConfigurations = new LinkedHashMap<>();
}

