package com.impinj.itemsense.client.coordinator.softwareupgrades;

import java.time.ZonedDateTime;

public class UpgradeRequestView {

  private String id;
  private UpgradeRequest upgradeRequest;
  private ZonedDateTime created;
  private ZonedDateTime updated;
  private int numDevices;
  private boolean cancelled;
  private int numFailures;

  public UpgradeRequestView() {}

  public String getId() {return this.id;}

  public UpgradeRequest getUpgradeRequest() {return this.upgradeRequest;}

  public ZonedDateTime getCreated() {return this.created;}

  public ZonedDateTime getUpdated() {return this.updated;}

  public int getNumDevices() {return this.numDevices;}

  public boolean isCancelled() {return this.cancelled;}

  public int getNumFailures() {return this.numFailures;}

  public void setId(String id) {this.id = id; }

  public void setUpgradeRequest(UpgradeRequest upgradeRequest) {this.upgradeRequest = upgradeRequest; }

  public void setCreated(ZonedDateTime created) {this.created = created; }

  public void setUpdated(ZonedDateTime updated) {this.updated = updated; }

  public void setNumDevices(int numDevices) {this.numDevices = numDevices; }

  public void setCancelled(boolean cancelled) {this.cancelled = cancelled; }

  public void setNumFailures(int numFailures) {this.numFailures = numFailures; }

  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (!(o instanceof UpgradeRequestView)) {
      return false;
    }
    final UpgradeRequestView other = (UpgradeRequestView) o;
    final Object this$id = this.getId();
    final Object other$id = other.getId();
    if (this$id == null ? other$id != null : !this$id.equals(other$id)) {
      return false;
    }
    final Object this$upgradeRequest = this.getUpgradeRequest();
    final Object other$upgradeRequest = other.getUpgradeRequest();
    if (this$upgradeRequest == null ? other$upgradeRequest != null : !this$upgradeRequest.equals(
        other$upgradeRequest)) {
      return false;
    }
    final Object this$created = this.getCreated();
    final Object other$created = other.getCreated();
    if (this$created == null ? other$created != null : !this$created.equals(other$created)) {
      return false;
    }
    final Object this$updated = this.getUpdated();
    final Object other$updated = other.getUpdated();
    if (this$updated == null ? other$updated != null : !this$updated.equals(other$updated)) {
      return false;
    }
    if (this.getNumDevices() != other.getNumDevices()) {
      return false;
    }
    if (this.isCancelled() != other.isCancelled()) {
      return false;
    }
    return this.getNumFailures() == other.getNumFailures();
  }

  public int hashCode() {
    final int PRIME = 59;
    int result = 1;
    final Object $id = this.getId();
    result = result * PRIME + ($id == null ? 43 : $id.hashCode());
    final Object $upgradeRequest = this.getUpgradeRequest();
    result = result * PRIME + ($upgradeRequest == null ? 43 : $upgradeRequest.hashCode());
    final Object $created = this.getCreated();
    result = result * PRIME + ($created == null ? 43 : $created.hashCode());
    final Object $updated = this.getUpdated();
    result = result * PRIME + ($updated == null ? 43 : $updated.hashCode());
    result = result * PRIME + this.getNumDevices();
    result = result * PRIME + (this.isCancelled() ? 79 : 97);
    result = result * PRIME + this.getNumFailures();
    return result;
  }

  public String toString() {
    return "com.impinj.itemsense.client.coordinator.softwareupgrades.UpgradeRequestView(id=" + this
        .getId() + ", upgradeRequest=" + this.getUpgradeRequest() + ", created=" + this.getCreated()
        + ", updated=" + this.getUpdated() + ", numDevices=" + this.getNumDevices() + ", cancelled="
        + this.isCancelled() + ", numFailures=" + this.getNumFailures() + ")";
  }
}
