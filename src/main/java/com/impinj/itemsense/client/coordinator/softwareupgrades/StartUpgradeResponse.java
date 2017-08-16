package com.impinj.itemsense.client.coordinator.softwareupgrades;

public class StartUpgradeResponse {

  String upgradeInstanceId;

  public StartUpgradeResponse() {}

  public String getUpgradeInstanceId() {return this.upgradeInstanceId;}

  public void setUpgradeInstanceId(String upgradeInstanceId) {this.upgradeInstanceId = upgradeInstanceId; }

  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (!(o instanceof StartUpgradeResponse)) {
      return false;
    }
    final StartUpgradeResponse other = (StartUpgradeResponse) o;
    final Object this$upgradeInstanceId = this.getUpgradeInstanceId();
    final Object other$upgradeInstanceId = other.getUpgradeInstanceId();
    return this$upgradeInstanceId == null ? other$upgradeInstanceId == null
                                          : this$upgradeInstanceId.equals(other$upgradeInstanceId);
  }

  public int hashCode() {
    final int PRIME = 59;
    int result = 1;
    final Object $upgradeInstanceId = this.getUpgradeInstanceId();
    result = result * PRIME + ($upgradeInstanceId == null ? 43 : $upgradeInstanceId.hashCode());
    return result;
  }

  public String toString() {
    return
        "com.impinj.itemsense.client.coordinator.softwareupgrades.StartUpgradeResponse(upgradeInstanceId="
            + this.getUpgradeInstanceId() + ")";
  }
}
