package com.impinj.itemsense.client.coordinator.softwareupgrades;

import java.util.Set;

public class UpgradeRequestTarget {

  TargetType type;
  Set<String> values;

  @java.beans.ConstructorProperties({"type", "values"})
  public UpgradeRequestTarget(TargetType type, Set<String> values) {
    this.type = type;
    this.values = values;
  }

  public static UpgradeRequestTargetBuilder builder() {return new UpgradeRequestTargetBuilder();}

  public TargetType getType() {return this.type;}

  public Set<String> getValues() {return this.values;}

  public void setType(TargetType type) {this.type = type; }

  public void setValues(Set<String> values) {this.values = values; }

  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (!(o instanceof UpgradeRequestTarget)) {
      return false;
    }
    final UpgradeRequestTarget other = (UpgradeRequestTarget) o;
    final Object this$type = this.getType();
    final Object other$type = other.getType();
    if (this$type == null ? other$type != null : !this$type.equals(other$type)) {
      return false;
    }
    final Object this$values = this.getValues();
    final Object other$values = other.getValues();
    return this$values == null ? other$values == null : this$values.equals(other$values);
  }

  public int hashCode() {
    final int PRIME = 59;
    int result = 1;
    final Object $type = this.getType();
    result = result * PRIME + ($type == null ? 43 : $type.hashCode());
    final Object $values = this.getValues();
    result = result * PRIME + ($values == null ? 43 : $values.hashCode());
    return result;
  }

  public String toString() {
    return "com.impinj.itemsense.client.coordinator.softwareupgrades.UpgradeRequestTarget(type="
        + this.getType() + ", values=" + this.getValues() + ")";
  }

  public static class UpgradeRequestTargetBuilder {

    private TargetType type;
    private Set<String> values;

    UpgradeRequestTargetBuilder() {}

    public UpgradeRequestTarget.UpgradeRequestTargetBuilder type(TargetType type) {
      this.type = type;
      return this;
    }

    public UpgradeRequestTarget.UpgradeRequestTargetBuilder values(Set<String> values) {
      this.values = values;
      return this;
    }

    public UpgradeRequestTarget build() {
      return new UpgradeRequestTarget(type, values);
    }

    public String toString() {
      return
          "com.impinj.itemsense.client.coordinator.softwareupgrades.UpgradeRequestTarget.UpgradeRequestTargetBuilder(type="
              + this.type + ", values=" + this.values + ")";
    }
  }
}
