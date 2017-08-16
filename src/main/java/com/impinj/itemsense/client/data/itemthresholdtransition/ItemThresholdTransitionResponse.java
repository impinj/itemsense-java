package com.impinj.itemsense.client.data.itemthresholdtransition;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ItemThresholdTransitionResponse {

  private ItemThresholdTransition[] transitions;
  private String nextPageMarker;
  private boolean moreHistoryAvailable;

  @java.beans.ConstructorProperties({"transitions", "nextPageMarker", "moreHistoryAvailable"})
  public ItemThresholdTransitionResponse(
      ItemThresholdTransition[] transitions,
      String nextPageMarker, boolean moreHistoryAvailable) {
    this.transitions = transitions;
    this.nextPageMarker = nextPageMarker;
    this.moreHistoryAvailable = moreHistoryAvailable;
  }

  public ItemThresholdTransitionResponse() {}

  public ItemThresholdTransition[] getTransitions() {return this.transitions;}

  public String getNextPageMarker() {return this.nextPageMarker;}

  public boolean isMoreHistoryAvailable() {return this.moreHistoryAvailable;}

  public void setTransitions(ItemThresholdTransition[] transitions) {this.transitions = transitions; }

  public void setNextPageMarker(String nextPageMarker) {this.nextPageMarker = nextPageMarker; }

  public void setMoreHistoryAvailable(boolean moreHistoryAvailable) {this.moreHistoryAvailable = moreHistoryAvailable; }

  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (!(o instanceof ItemThresholdTransitionResponse)) {
      return false;
    }
    final ItemThresholdTransitionResponse other = (ItemThresholdTransitionResponse) o;
    if (!java.util.Arrays.deepEquals(this.getTransitions(), other.getTransitions())) {
      return false;
    }
    final Object this$nextPageMarker = this.getNextPageMarker();
    final Object other$nextPageMarker = other.getNextPageMarker();
    if (this$nextPageMarker == null ? other$nextPageMarker != null : !this$nextPageMarker.equals(
        other$nextPageMarker)) {
      return false;
    }
    return this.isMoreHistoryAvailable() == other.isMoreHistoryAvailable();
  }

  public int hashCode() {
    final int PRIME = 59;
    int result = 1;
    result = result * PRIME + java.util.Arrays.deepHashCode(this.getTransitions());
    final Object $nextPageMarker = this.getNextPageMarker();
    result = result * PRIME + ($nextPageMarker == null ? 43 : $nextPageMarker.hashCode());
    result = result * PRIME + (this.isMoreHistoryAvailable() ? 79 : 97);
    return result;
  }

  public String toString() {
    return
        "com.impinj.itemsense.client.data.itemthresholdtransition.ItemThresholdTransitionResponse(transitions="
            + java.util.Arrays.deepToString(this.getTransitions()) + ", nextPageMarker=" + this
            .getNextPageMarker() + ", moreHistoryAvailable=" + this.isMoreHistoryAvailable() + ")";
  }
}
