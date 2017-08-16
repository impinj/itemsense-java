package com.impinj.itemsense.client.data.itemthresholdtransition;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.time.ZonedDateTime;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ItemThresholdTransition {

  private String epc;
  private int thresholdId;
  private String destination;
  private double confidence;
  private ZonedDateTime creationTime;

  @java.beans.ConstructorProperties({"epc", "thresholdId", "destination", "confidence",
      "creationTime"})
  public ItemThresholdTransition(
      String epc,
      int thresholdId,
      String destination,
      double confidence,
      ZonedDateTime creationTime) {
    this.epc = epc;
    this.thresholdId = thresholdId;
    this.destination = destination;
    this.confidence = confidence;
    this.creationTime = creationTime;
  }

  public ItemThresholdTransition() {}

  public String getEpc() {return this.epc;}

  public int getThresholdId() {return this.thresholdId;}

  public String getDestination() {return this.destination;}

  public double getConfidence() {return this.confidence;}

  public ZonedDateTime getCreationTime() {return this.creationTime;}

  public void setEpc(String epc) {this.epc = epc; }

  public void setThresholdId(int thresholdId) {this.thresholdId = thresholdId; }

  public void setDestination(String destination) {this.destination = destination; }

  public void setConfidence(double confidence) {this.confidence = confidence; }

  public void setCreationTime(ZonedDateTime creationTime) {this.creationTime = creationTime; }

  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (!(o instanceof ItemThresholdTransition)) {
      return false;
    }
    final ItemThresholdTransition other = (ItemThresholdTransition) o;
    final Object this$epc = this.getEpc();
    final Object other$epc = other.getEpc();
    if (this$epc == null ? other$epc != null : !this$epc.equals(other$epc)) {
      return false;
    }
    if (this.getThresholdId() != other.getThresholdId()) {
      return false;
    }
    final Object this$destination = this.getDestination();
    final Object other$destination = other.getDestination();
    if (this$destination == null ? other$destination != null : !this$destination.equals(
        other$destination)) {
      return false;
    }
    if (Double.compare(this.getConfidence(), other.getConfidence()) != 0) {
      return false;
    }
    final Object this$creationTime = this.getCreationTime();
    final Object other$creationTime = other.getCreationTime();
    return this$creationTime == null ? other$creationTime == null : this$creationTime.equals(
        other$creationTime);
  }

  public int hashCode() {
    final int PRIME = 59;
    int result = 1;
    final Object $epc = this.getEpc();
    result = result * PRIME + ($epc == null ? 43 : $epc.hashCode());
    result = result * PRIME + this.getThresholdId();
    final Object $destination = this.getDestination();
    result = result * PRIME + ($destination == null ? 43 : $destination.hashCode());
    final long $confidence = Double.doubleToLongBits(this.getConfidence());
    result = result * PRIME + (int) ($confidence >>> 32 ^ $confidence);
    final Object $creationTime = this.getCreationTime();
    result = result * PRIME + ($creationTime == null ? 43 : $creationTime.hashCode());
    return result;
  }

  public String toString() {
    return "com.impinj.itemsense.client.data.itemthresholdtransition.ItemThresholdTransition(epc="
        + this.getEpc() + ", thresholdId=" + this.getThresholdId() + ", destination=" + this
        .getDestination() + ", confidence=" + this.getConfidence() + ", creationTime=" + this
        .getCreationTime() + ")";
  }
}
