package com.impinj.itemsense.client.coordinator.recipe;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import java.time.Duration;
import java.util.LinkedHashMap;
import java.util.Map;

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

  @java.beans.ConstructorProperties({"name", "type", "readerConfigurationName",
      "tagHeartbeatMinutes", "tagHeartbeatDuration", "tagExpiryDuration", "readerConfigurations"})
  public Recipe(
      String name,
      RecipeType type,
      String readerConfigurationName,
      Integer tagHeartbeatMinutes,
      Duration tagHeartbeatDuration,
      Duration tagExpiryDuration,
      Map<String, String> readerConfigurations) {
    this.name = name;
    this.type = type;
    this.readerConfigurationName = readerConfigurationName;
    this.tagHeartbeatMinutes = tagHeartbeatMinutes;
    this.tagHeartbeatDuration = tagHeartbeatDuration;
    this.tagExpiryDuration = tagExpiryDuration;
    this.readerConfigurations = readerConfigurations;
  }

  public Recipe() {}

  public String getName() {return this.name;}

  public RecipeType getType() {return this.type;}

  public String getReaderConfigurationName() {return this.readerConfigurationName;}

  @Deprecated
  public Integer getTagHeartbeatMinutes() {return this.tagHeartbeatMinutes;}

  public Duration getTagHeartbeatDuration() {return this.tagHeartbeatDuration;}

  public Duration getTagExpiryDuration() {return this.tagExpiryDuration;}

  public Map<String, String> getReaderConfigurations() {return this.readerConfigurations;}

  public void setName(String name) {this.name = name; }

  public void setType(RecipeType type) {this.type = type; }

  public void setReaderConfigurationName(String readerConfigurationName) {this.readerConfigurationName = readerConfigurationName; }

  @Deprecated
  public void setTagHeartbeatMinutes(Integer tagHeartbeatMinutes) {this.tagHeartbeatMinutes = tagHeartbeatMinutes; }

  public void setTagHeartbeatDuration(Duration tagHeartbeatDuration) {this.tagHeartbeatDuration = tagHeartbeatDuration; }

  public void setTagExpiryDuration(Duration tagExpiryDuration) {this.tagExpiryDuration = tagExpiryDuration; }

  public void setReaderConfigurations(Map<String, String> readerConfigurations) {this.readerConfigurations = readerConfigurations; }

  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (!(o instanceof Recipe)) {
      return false;
    }
    final Recipe other = (Recipe) o;
    final Object this$name = this.getName();
    final Object other$name = other.getName();
    if (this$name == null ? other$name != null : !this$name.equals(other$name)) {
      return false;
    }
    final Object this$type = this.getType();
    final Object other$type = other.getType();
    if (this$type == null ? other$type != null : !this$type.equals(other$type)) {
      return false;
    }
    final Object this$readerConfigurationName = this.getReaderConfigurationName();
    final Object other$readerConfigurationName = other.getReaderConfigurationName();
    if (this$readerConfigurationName == null ? other$readerConfigurationName != null
                                             : !this$readerConfigurationName.equals(
                                                 other$readerConfigurationName)) {
      return false;
    }
    final Object this$tagHeartbeatMinutes = this.getTagHeartbeatMinutes();
    final Object other$tagHeartbeatMinutes = other.getTagHeartbeatMinutes();
    if (this$tagHeartbeatMinutes == null ? other$tagHeartbeatMinutes != null
                                         : !this$tagHeartbeatMinutes.equals(
                                             other$tagHeartbeatMinutes)) {
      return false;
    }
    final Object this$tagHeartbeatDuration = this.getTagHeartbeatDuration();
    final Object other$tagHeartbeatDuration = other.getTagHeartbeatDuration();
    if (this$tagHeartbeatDuration == null ? other$tagHeartbeatDuration != null
                                          : !this$tagHeartbeatDuration.equals(
                                              other$tagHeartbeatDuration)) {
      return false;
    }
    final Object this$tagExpiryDuration = this.getTagExpiryDuration();
    final Object other$tagExpiryDuration = other.getTagExpiryDuration();
    if (this$tagExpiryDuration == null ? other$tagExpiryDuration != null
                                       : !this$tagExpiryDuration.equals(other$tagExpiryDuration)) {
      return false;
    }
    final Object this$readerConfigurations = this.getReaderConfigurations();
    final Object other$readerConfigurations = other.getReaderConfigurations();
    return this$readerConfigurations == null ? other$readerConfigurations == null
                                             : this$readerConfigurations.equals(
                                                 other$readerConfigurations);
  }

  public int hashCode() {
    final int PRIME = 59;
    int result = 1;
    final Object $name = this.getName();
    result = result * PRIME + ($name == null ? 43 : $name.hashCode());
    final Object $type = this.getType();
    result = result * PRIME + ($type == null ? 43 : $type.hashCode());
    final Object $readerConfigurationName = this.getReaderConfigurationName();
    result = result * PRIME + ($readerConfigurationName == null ? 43 : $readerConfigurationName
        .hashCode());
    final Object $tagHeartbeatMinutes = this.getTagHeartbeatMinutes();
    result = result * PRIME + ($tagHeartbeatMinutes == null ? 43 : $tagHeartbeatMinutes.hashCode());
    final Object $tagHeartbeatDuration = this.getTagHeartbeatDuration();
    result =
        result * PRIME + ($tagHeartbeatDuration == null ? 43 : $tagHeartbeatDuration.hashCode());
    final Object $tagExpiryDuration = this.getTagExpiryDuration();
    result = result * PRIME + ($tagExpiryDuration == null ? 43 : $tagExpiryDuration.hashCode());
    final Object $readerConfigurations = this.getReaderConfigurations();
    result =
        result * PRIME + ($readerConfigurations == null ? 43 : $readerConfigurations.hashCode());
    return result;
  }

  public String toString() {
    return "com.impinj.itemsense.client.coordinator.recipe.Recipe(name=" + this.getName()
        + ", type=" + this.getType() + ", readerConfigurationName=" + this
        .getReaderConfigurationName() + ", tagHeartbeatMinutes=" + this.getTagHeartbeatMinutes()
        + ", tagHeartbeatDuration=" + this.getTagHeartbeatDuration() + ", tagExpiryDuration=" + this
        .getTagExpiryDuration() + ", readerConfigurations=" + this.getReaderConfigurations() + ")";
  }
}

