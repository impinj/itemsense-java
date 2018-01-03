package com.impinj.itemsense.client.coordinator.softwareupgrades;

import com.impinj.itemsense.client.coordinator.readerdefinition.ReaderType;
import java.util.Set;

public class UpgradePolicy {

  private Integer maxParallelReaders;
  private Set<ReaderType> allowedReaderTypes;

  @java.beans.ConstructorProperties({"maxParallelReaders", "allowedReaderTypes"})
  public UpgradePolicy(Integer maxParallelReaders, Set<ReaderType> allowedReaderTypes) {
    this.maxParallelReaders = maxParallelReaders;
    this.allowedReaderTypes = allowedReaderTypes;
  }

  public UpgradePolicy() {}

  public static UpgradePolicyBuilder builder() {return new UpgradePolicyBuilder();}

  public Integer getMaxParallelReaders() {return this.maxParallelReaders;}

  public Set<ReaderType> getAllowedReaderTypes() {return this.allowedReaderTypes;}

  public void setMaxParallelReaders(Integer maxParallelReaders) {this.maxParallelReaders = maxParallelReaders; }

  public void setAllowedReaderTypes(Set<ReaderType> allowedReaderTypes) {this.allowedReaderTypes = allowedReaderTypes; }

  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (!(o instanceof UpgradePolicy)) {
      return false;
    }
    final UpgradePolicy other = (UpgradePolicy) o;
    final Object this$maxParallelReaders = this.getMaxParallelReaders();
    final Object other$maxParallelReaders = other.getMaxParallelReaders();
    if (this$maxParallelReaders == null ? other$maxParallelReaders != null
                                        : !this$maxParallelReaders
                                            .equals(other$maxParallelReaders)) {
      return false;
    }
    final Object this$allowedReaderTypes = this.getAllowedReaderTypes();
    final Object other$allowedReaderTypes = other.getAllowedReaderTypes();
    return this$allowedReaderTypes == null ? other$allowedReaderTypes == null
                                           : this$allowedReaderTypes
               .equals(other$allowedReaderTypes);
  }

  public int hashCode() {
    final int PRIME = 59;
    int result = 1;
    final Object $maxParallelReaders = this.getMaxParallelReaders();
    result = result * PRIME + ($maxParallelReaders == null ? 43 : $maxParallelReaders.hashCode());
    final Object $allowedReaderTypes = this.getAllowedReaderTypes();
    result = result * PRIME + ($allowedReaderTypes == null ? 43 : $allowedReaderTypes.hashCode());
    return result;
  }

  public String toString() {
    return
        "com.impinj.itemsense.client.coordinator.softwareupgrades.UpgradePolicy(maxParallelReaders="
            + this.getMaxParallelReaders() + ", allowedReaderTypes=" + this.getAllowedReaderTypes()
            + ")";
  }

  public static class UpgradePolicyBuilder {

    private Integer maxParallelReaders;
    private Set<ReaderType> allowedReaderTypes;

    UpgradePolicyBuilder() {}

    public UpgradePolicy.UpgradePolicyBuilder maxParallelReaders(Integer maxParallelReaders) {
      this.maxParallelReaders = maxParallelReaders;
      return this;
    }

    public UpgradePolicy.UpgradePolicyBuilder allowedReaderTypes(Set<ReaderType> allowedReaderTypes) {
      this.allowedReaderTypes = allowedReaderTypes;
      return this;
    }

    public UpgradePolicy build() {
      return new UpgradePolicy(maxParallelReaders, allowedReaderTypes);
    }

    public String toString() {
      return
          "com.impinj.itemsense.client.coordinator.softwareupgrades.UpgradePolicy.UpgradePolicyBuilder(maxParallelReaders="
              + this.maxParallelReaders + ", allowedReaderTypes=" + this.allowedReaderTypes + ")";
    }
  }
}
