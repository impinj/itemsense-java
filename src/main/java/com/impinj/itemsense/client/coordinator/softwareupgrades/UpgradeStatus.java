package com.impinj.itemsense.client.coordinator.softwareupgrades;

import java.util.List;

public class UpgradeStatus {

  private String id;
  private VersionIdentifier version;
  private UpgradeState status;
  private UpgradeRequestTarget target;
  private UpgradeStatusDetails details;
  private long elapsedTimeSeconds;
  private String lastUpdatedTime;

  public UpgradeStatus() {}

  public String getId() {return this.id;}

  public VersionIdentifier getVersion() {return this.version;}

  public UpgradeState getStatus() {return this.status;}

  public UpgradeRequestTarget getTarget() {return this.target;}

  public UpgradeStatusDetails getDetails() {return this.details;}

  public long getElapsedTimeSeconds() {return this.elapsedTimeSeconds;}

  public String getLastUpdatedTime() {return this.lastUpdatedTime;}

  public void setId(String id) {this.id = id; }

  public void setVersion(VersionIdentifier version) {this.version = version; }

  public void setStatus(UpgradeState status) {this.status = status; }

  public void setTarget(UpgradeRequestTarget target) {this.target = target; }

  public void setDetails(UpgradeStatusDetails details) {this.details = details; }

  public void setElapsedTimeSeconds(long elapsedTimeSeconds) {this.elapsedTimeSeconds = elapsedTimeSeconds; }

  public void setLastUpdatedTime(String lastUpdatedTime) {this.lastUpdatedTime = lastUpdatedTime; }

  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (!(o instanceof UpgradeStatus)) {
      return false;
    }
    final UpgradeStatus other = (UpgradeStatus) o;
    final Object this$id = this.getId();
    final Object other$id = other.getId();
    if (this$id == null ? other$id != null : !this$id.equals(other$id)) {
      return false;
    }
    final Object this$version = this.getVersion();
    final Object other$version = other.getVersion();
    if (this$version == null ? other$version != null : !this$version.equals(other$version)) {
      return false;
    }
    final Object this$status = this.getStatus();
    final Object other$status = other.getStatus();
    if (this$status == null ? other$status != null : !this$status.equals(other$status)) {
      return false;
    }
    final Object this$target = this.getTarget();
    final Object other$target = other.getTarget();
    if (this$target == null ? other$target != null : !this$target.equals(other$target)) {
      return false;
    }
    final Object this$details = this.getDetails();
    final Object other$details = other.getDetails();
    if (this$details == null ? other$details != null : !this$details.equals(other$details)) {
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
    final Object $id = this.getId();
    result = result * PRIME + ($id == null ? 43 : $id.hashCode());
    final Object $version = this.getVersion();
    result = result * PRIME + ($version == null ? 43 : $version.hashCode());
    final Object $status = this.getStatus();
    result = result * PRIME + ($status == null ? 43 : $status.hashCode());
    final Object $target = this.getTarget();
    result = result * PRIME + ($target == null ? 43 : $target.hashCode());
    final Object $details = this.getDetails();
    result = result * PRIME + ($details == null ? 43 : $details.hashCode());
    final long $elapsedTimeSeconds = this.getElapsedTimeSeconds();
    result = result * PRIME + (int) ($elapsedTimeSeconds >>> 32 ^ $elapsedTimeSeconds);
    final Object $lastUpdatedTime = this.getLastUpdatedTime();
    result = result * PRIME + ($lastUpdatedTime == null ? 43 : $lastUpdatedTime.hashCode());
    return result;
  }

  public String toString() {
    return "com.impinj.itemsense.client.coordinator.softwareupgrades.UpgradeStatus(id=" + this
        .getId() + ", version=" + this.getVersion() + ", status=" + this.getStatus() + ", target="
        + this.getTarget() + ", details=" + this.getDetails() + ", elapsedTimeSeconds=" + this
        .getElapsedTimeSeconds() + ", lastUpdatedTime=" + this.getLastUpdatedTime() + ")";
  }

  static public class UpgradeStatusDetails {

    private List<DeviceStatus> readers;

    public UpgradeStatusDetails() {}

    public List<DeviceStatus> getReaders() {return this.readers;}

    public void setReaders(List<DeviceStatus> readers) {this.readers = readers; }

    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (!(o instanceof UpgradeStatusDetails)) {
        return false;
      }
      final UpgradeStatusDetails other = (UpgradeStatusDetails) o;
      final Object this$readers = this.getReaders();
      final Object other$readers = other.getReaders();
      return this$readers == null ? other$readers == null : this$readers.equals(other$readers);
    }

    public int hashCode() {
      final int PRIME = 59;
      int result = 1;
      final Object $readers = this.getReaders();
      result = result * PRIME + ($readers == null ? 43 : $readers.hashCode());
      return result;
    }

    public String toString() {
      return
          "com.impinj.itemsense.client.coordinator.softwareupgrades.UpgradeStatus.UpgradeStatusDetails(readers="
              + this.getReaders() + ")";
    }
  }
}
