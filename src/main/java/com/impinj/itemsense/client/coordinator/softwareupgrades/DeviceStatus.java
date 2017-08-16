package com.impinj.itemsense.client.coordinator.softwareupgrades;

public class DeviceStatus {

  private String name; // readerName
  private VersionIdentifier previousVersion;
  private UpgradeState status;
  private long elapsedTimeSeconds;
  private String lastUpdatedTime;

  public DeviceStatus() {}

  public String getName() {return this.name;}

  public VersionIdentifier getPreviousVersion() {return this.previousVersion;}

  public UpgradeState getStatus() {return this.status;}

  public long getElapsedTimeSeconds() {return this.elapsedTimeSeconds;}

  public String getLastUpdatedTime() {return this.lastUpdatedTime;}

  public void setName(String name) {this.name = name; }

  public void setPreviousVersion(VersionIdentifier previousVersion) {this.previousVersion = previousVersion; }

  public void setStatus(UpgradeState status) {this.status = status; }

  public void setElapsedTimeSeconds(long elapsedTimeSeconds) {this.elapsedTimeSeconds = elapsedTimeSeconds; }

  public void setLastUpdatedTime(String lastUpdatedTime) {this.lastUpdatedTime = lastUpdatedTime; }

  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (!(o instanceof DeviceStatus)) {
      return false;
    }
    final DeviceStatus other = (DeviceStatus) o;
    final Object this$name = this.getName();
    final Object other$name = other.getName();
    if (this$name == null ? other$name != null : !this$name.equals(other$name)) {
      return false;
    }
    final Object this$previousVersion = this.getPreviousVersion();
    final Object other$previousVersion = other.getPreviousVersion();
    if (this$previousVersion == null ? other$previousVersion != null : !this$previousVersion.equals(
        other$previousVersion)) {
      return false;
    }
    final Object this$status = this.getStatus();
    final Object other$status = other.getStatus();
    if (this$status == null ? other$status != null : !this$status.equals(other$status)) {
      return false;
    }
    if (this.getElapsedTimeSeconds() != other.getElapsedTimeSeconds()) {
      return false;
    }
    final Object this$lastUpdatedTime = this.getLastUpdatedTime();
    final Object other$lastUpdatedTime = other.getLastUpdatedTime();
    return this$lastUpdatedTime == null ? other$lastUpdatedTime == null
                                        : this$lastUpdatedTime.equals(
                                            other$lastUpdatedTime);
  }

  public int hashCode() {
    final int PRIME = 59;
    int result = 1;
    final Object $name = this.getName();
    result = result * PRIME + ($name == null ? 43 : $name.hashCode());
    final Object $previousVersion = this.getPreviousVersion();
    result = result * PRIME + ($previousVersion == null ? 43 : $previousVersion.hashCode());
    final Object $status = this.getStatus();
    result = result * PRIME + ($status == null ? 43 : $status.hashCode());
    final long $elapsedTimeSeconds = this.getElapsedTimeSeconds();
    result = result * PRIME + (int) ($elapsedTimeSeconds >>> 32 ^ $elapsedTimeSeconds);
    final Object $lastUpdatedTime = this.getLastUpdatedTime();
    result = result * PRIME + ($lastUpdatedTime == null ? 43 : $lastUpdatedTime.hashCode());
    return result;
  }

  public String toString() {
    return "com.impinj.itemsense.client.coordinator.softwareupgrades.DeviceStatus(name=" + this
        .getName() + ", previousVersion=" + this.getPreviousVersion() + ", status=" + this
        .getStatus() + ", elapsedTimeSeconds=" + this.getElapsedTimeSeconds() + ", lastUpdatedTime="
        + this.getLastUpdatedTime() + ")";
  }
}
