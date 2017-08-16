package com.impinj.itemsense.client.coordinator.softwareupgrades;

public class UpgradeRequest {

  UpgradeRequestTarget target;
  VersionIdentifier versionIdentifier;
  UpgradePolicy policy;

  @java.beans.ConstructorProperties({"target", "versionIdentifier", "policy"})
  public UpgradeRequest(
      UpgradeRequestTarget target,
      VersionIdentifier versionIdentifier,
      UpgradePolicy policy) {
    this.target = target;
    this.versionIdentifier = versionIdentifier;
    this.policy = policy;
  }

  public UpgradeRequest() {}

  public static UpgradeRequestBuilder builder() {return new UpgradeRequestBuilder();}

  public UpgradeRequestTarget getTarget() {return this.target;}

  public VersionIdentifier getVersionIdentifier() {return this.versionIdentifier;}

  public UpgradePolicy getPolicy() {return this.policy;}

  public void setTarget(UpgradeRequestTarget target) {this.target = target; }

  public void setVersionIdentifier(VersionIdentifier versionIdentifier) {this.versionIdentifier = versionIdentifier; }

  public void setPolicy(UpgradePolicy policy) {this.policy = policy; }

  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (!(o instanceof UpgradeRequest)) {
      return false;
    }
    final UpgradeRequest other = (UpgradeRequest) o;
    final Object this$target = this.getTarget();
    final Object other$target = other.getTarget();
    if (this$target == null ? other$target != null : !this$target.equals(other$target)) {
      return false;
    }
    final Object this$versionIdentifier = this.getVersionIdentifier();
    final Object other$versionIdentifier = other.getVersionIdentifier();
    if (this$versionIdentifier == null ? other$versionIdentifier != null
                                       : !this$versionIdentifier.equals(other$versionIdentifier)) {
      return false;
    }
    final Object this$policy = this.getPolicy();
    final Object other$policy = other.getPolicy();
    return this$policy == null ? other$policy == null : this$policy.equals(other$policy);
  }

  public int hashCode() {
    final int PRIME = 59;
    int result = 1;
    final Object $target = this.getTarget();
    result = result * PRIME + ($target == null ? 43 : $target.hashCode());
    final Object $versionIdentifier = this.getVersionIdentifier();
    result = result * PRIME + ($versionIdentifier == null ? 43 : $versionIdentifier.hashCode());
    final Object $policy = this.getPolicy();
    result = result * PRIME + ($policy == null ? 43 : $policy.hashCode());
    return result;
  }

  public String toString() {
    return "com.impinj.itemsense.client.coordinator.softwareupgrades.UpgradeRequest(target=" + this
        .getTarget() + ", versionIdentifier=" + this.getVersionIdentifier() + ", policy=" + this
        .getPolicy() + ")";
  }

  public static class UpgradeRequestBuilder {

    private UpgradeRequestTarget target;
    private VersionIdentifier versionIdentifier;
    private UpgradePolicy policy;

    UpgradeRequestBuilder() {}

    public UpgradeRequest.UpgradeRequestBuilder target(UpgradeRequestTarget target) {
      this.target = target;
      return this;
    }

    public UpgradeRequest.UpgradeRequestBuilder versionIdentifier(VersionIdentifier versionIdentifier) {
      this.versionIdentifier = versionIdentifier;
      return this;
    }

    public UpgradeRequest.UpgradeRequestBuilder policy(UpgradePolicy policy) {
      this.policy = policy;
      return this;
    }

    public UpgradeRequest build() {
      return new UpgradeRequest(target, versionIdentifier, policy);
    }

    public String toString() {
      return
          "com.impinj.itemsense.client.coordinator.softwareupgrades.UpgradeRequest.UpgradeRequestBuilder(target="
              + this.target + ", versionIdentifier=" + this.versionIdentifier + ", policy="
              + this.policy + ")";
    }
  }
}
