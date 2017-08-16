package com.impinj.itemsense.client.data.itemhistory;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties(ignoreUnknown = true)
public class ItemHistoryResponse {

  private ItemHistory[] history;
  private String nextPageMarker;
  private boolean moreHistoryAvailable;

  @java.beans.ConstructorProperties({"history", "nextPageMarker", "moreHistoryAvailable"})
  public ItemHistoryResponse(
      ItemHistory[] history,
      String nextPageMarker,
      boolean moreHistoryAvailable) {
    this.history = history;
    this.nextPageMarker = nextPageMarker;
    this.moreHistoryAvailable = moreHistoryAvailable;
  }

  public ItemHistoryResponse() {}

  public ItemHistory[] getHistory() {return this.history;}

  public String getNextPageMarker() {return this.nextPageMarker;}

  public boolean isMoreHistoryAvailable() {return this.moreHistoryAvailable;}

  public void setHistory(ItemHistory[] history) {this.history = history; }

  public void setNextPageMarker(String nextPageMarker) {this.nextPageMarker = nextPageMarker; }

  public void setMoreHistoryAvailable(boolean moreHistoryAvailable) {this.moreHistoryAvailable = moreHistoryAvailable; }

  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (!(o instanceof ItemHistoryResponse)) {
      return false;
    }
    final ItemHistoryResponse other = (ItemHistoryResponse) o;
    if (!java.util.Arrays.deepEquals(this.getHistory(), other.getHistory())) {
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
    result = result * PRIME + java.util.Arrays.deepHashCode(this.getHistory());
    final Object $nextPageMarker = this.getNextPageMarker();
    result = result * PRIME + ($nextPageMarker == null ? 43 : $nextPageMarker.hashCode());
    result = result * PRIME + (this.isMoreHistoryAvailable() ? 79 : 97);
    return result;
  }

  public String toString() {
    return "com.impinj.itemsense.client.data.itemhistory.ItemHistoryResponse(history="
        + java.util.Arrays.deepToString(this.getHistory()) + ", nextPageMarker=" + this
        .getNextPageMarker() + ", moreHistoryAvailable=" + this.isMoreHistoryAvailable() + ")";
  }
}

