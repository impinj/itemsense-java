package com.impinj.itemsense.client.coordinator.readerdefinition;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FeatureRequest {

  private ReaderFeature feature;
  private FeatureRequestAction action;

  @java.beans.ConstructorProperties({"feature", "action"})
  public FeatureRequest(ReaderFeature feature, FeatureRequestAction action) {
    this.feature = feature;
    this.action = action;
  }

  public FeatureRequest() {}

  public static FeatureRequestBuilder builder() {return new FeatureRequestBuilder();}

  public ReaderFeature getFeature() {return this.feature;}

  public FeatureRequestAction getAction() {return this.action;}

  public void setFeature(ReaderFeature feature) {this.feature = feature; }

  public void setAction(FeatureRequestAction action) {this.action = action; }

  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (!(o instanceof FeatureRequest)) {
      return false;
    }
    final FeatureRequest other = (FeatureRequest) o;
    final Object this$feature = this.getFeature();
    final Object other$feature = other.getFeature();
    if (this$feature == null ? other$feature != null : !this$feature.equals(other$feature)) {
      return false;
    }
    final Object this$action = this.getAction();
    final Object other$action = other.getAction();
    return this$action == null ? other$action == null : this$action.equals(other$action);
  }

  public int hashCode() {
    final int PRIME = 59;
    int result = 1;
    final Object $feature = this.getFeature();
    result = result * PRIME + ($feature == null ? 43 : $feature.hashCode());
    final Object $action = this.getAction();
    result = result * PRIME + ($action == null ? 43 : $action.hashCode());
    return result;
  }

  public String toString() {
    return "com.impinj.itemsense.client.coordinator.readerdefinition.FeatureRequest(feature=" + this
        .getFeature() + ", action=" + this.getAction() + ")";
  }

  public static class FeatureRequestBuilder {

    private ReaderFeature feature;
    private FeatureRequestAction action;

    FeatureRequestBuilder() {}

    public FeatureRequest.FeatureRequestBuilder feature(ReaderFeature feature) {
      this.feature = feature;
      return this;
    }

    public FeatureRequest.FeatureRequestBuilder action(FeatureRequestAction action) {
      this.action = action;
      return this;
    }

    public FeatureRequest build() {
      return new FeatureRequest(feature, action);
    }

    public String toString() {
      return
          "com.impinj.itemsense.client.coordinator.readerdefinition.FeatureRequest.FeatureRequestBuilder(feature="
              + this.feature + ", action=" + this.action + ")";
    }
  }
}
