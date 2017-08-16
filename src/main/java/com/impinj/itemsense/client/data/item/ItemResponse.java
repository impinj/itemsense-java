package com.impinj.itemsense.client.data.item;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;


@JsonIgnoreProperties(ignoreUnknown = true)
public class ItemResponse {

  @JsonProperty("items")
  private Item[] items;

  @JsonProperty("nextPageMarker")
  private String nextPageMarker;

  @java.beans.ConstructorProperties({"items", "nextPageMarker"})
  public ItemResponse(Item[] items, String nextPageMarker) {
    this.items = items;
    this.nextPageMarker = nextPageMarker;
  }

  public ItemResponse() {}

  public Item[] getItems() {return this.items;}

  public String getNextPageMarker() {return this.nextPageMarker;}

  public void setItems(Item[] items) {this.items = items; }

  public void setNextPageMarker(String nextPageMarker) {this.nextPageMarker = nextPageMarker; }

  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (!(o instanceof ItemResponse)) {
      return false;
    }
    final ItemResponse other = (ItemResponse) o;
    if (!java.util.Arrays.deepEquals(this.getItems(), other.getItems())) {
      return false;
    }
    final Object this$nextPageMarker = this.getNextPageMarker();
    final Object other$nextPageMarker = other.getNextPageMarker();
    return this$nextPageMarker == null ? other$nextPageMarker == null : this$nextPageMarker.equals(
        other$nextPageMarker);
  }

  public int hashCode() {
    final int PRIME = 59;
    int result = 1;
    result = result * PRIME + java.util.Arrays.deepHashCode(this.getItems());
    final Object $nextPageMarker = this.getNextPageMarker();
    result = result * PRIME + ($nextPageMarker == null ? 43 : $nextPageMarker.hashCode());
    return result;
  }

  public String toString() {
    return "com.impinj.itemsense.client.data.item.ItemResponse(items=" + java.util.Arrays
        .deepToString(this.getItems()) + ", nextPageMarker=" + this.getNextPageMarker() + ")";
  }
}

