package com.impinj.itemsense.client.data.itemhistory;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.time.ZonedDateTime;


@JsonIgnoreProperties(ignoreUnknown = true)
public class ItemHistory {

  private String epc;
  private String tagId;
  private String jobId;
  private String fromZone;
  private String toZone;
  private String fromFloor;
  private String toFloor;
  private String fromFacility;
  private String toFacility;
  private double fromX;
  private double fromY;
  private double toX;
  private double toY;

  private ZonedDateTime observationTime;

  @java.beans.ConstructorProperties({"epc", "tagId", "jobId", "fromZone", "toZone", "fromFloor",
      "toFloor", "fromFacility", "toFacility", "fromX", "fromY", "toX", "toY", "observationTime"})
  public ItemHistory(
      String epc,
      String tagId,
      String jobId,
      String fromZone,
      String toZone,
      String fromFloor,
      String toFloor,
      String fromFacility,
      String toFacility,
      double fromX,
      double fromY, double toX, double toY, ZonedDateTime observationTime) {
    this.epc = epc;
    this.tagId = tagId;
    this.jobId = jobId;
    this.fromZone = fromZone;
    this.toZone = toZone;
    this.fromFloor = fromFloor;
    this.toFloor = toFloor;
    this.fromFacility = fromFacility;
    this.toFacility = toFacility;
    this.fromX = fromX;
    this.fromY = fromY;
    this.toX = toX;
    this.toY = toY;
    this.observationTime = observationTime;
  }

  public ItemHistory() {}

  public String getEpc() {return this.epc;}

  public String getTagId() {return this.tagId;}

  public String getJobId() {return this.jobId;}

  public String getFromZone() {return this.fromZone;}

  public String getToZone() {return this.toZone;}

  public String getFromFloor() {return this.fromFloor;}

  public String getToFloor() {return this.toFloor;}

  public String getFromFacility() {return this.fromFacility;}

  public String getToFacility() {return this.toFacility;}

  public double getFromX() {return this.fromX;}

  public double getFromY() {return this.fromY;}

  public double getToX() {return this.toX;}

  public double getToY() {return this.toY;}

  public ZonedDateTime getObservationTime() {return this.observationTime;}

  public void setEpc(String epc) {this.epc = epc; }

  public void setTagId(String tagId) {this.tagId = tagId; }

  public void setJobId(String jobId) {this.jobId = jobId; }

  public void setFromZone(String fromZone) {this.fromZone = fromZone; }

  public void setToZone(String toZone) {this.toZone = toZone; }

  public void setFromFloor(String fromFloor) {this.fromFloor = fromFloor; }

  public void setToFloor(String toFloor) {this.toFloor = toFloor; }

  public void setFromFacility(String fromFacility) {this.fromFacility = fromFacility; }

  public void setToFacility(String toFacility) {this.toFacility = toFacility; }

  public void setFromX(double fromX) {this.fromX = fromX; }

  public void setFromY(double fromY) {this.fromY = fromY; }

  public void setToX(double toX) {this.toX = toX; }

  public void setToY(double toY) {this.toY = toY; }

  public void setObservationTime(ZonedDateTime observationTime) {this.observationTime = observationTime; }

  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (!(o instanceof ItemHistory)) {
      return false;
    }
    final ItemHistory other = (ItemHistory) o;
    final Object this$epc = this.getEpc();
    final Object other$epc = other.getEpc();
    if (this$epc == null ? other$epc != null : !this$epc.equals(other$epc)) {
      return false;
    }
    final Object this$tagId = this.getTagId();
    final Object other$tagId = other.getTagId();
    if (this$tagId == null ? other$tagId != null : !this$tagId.equals(other$tagId)) {
      return false;
    }
    final Object this$jobId = this.getJobId();
    final Object other$jobId = other.getJobId();
    if (this$jobId == null ? other$jobId != null : !this$jobId.equals(other$jobId)) {
      return false;
    }
    final Object this$fromZone = this.getFromZone();
    final Object other$fromZone = other.getFromZone();
    if (this$fromZone == null ? other$fromZone != null : !this$fromZone.equals(other$fromZone)) {
      return false;
    }
    final Object this$toZone = this.getToZone();
    final Object other$toZone = other.getToZone();
    if (this$toZone == null ? other$toZone != null : !this$toZone.equals(other$toZone)) {
      return false;
    }
    final Object this$fromFloor = this.getFromFloor();
    final Object other$fromFloor = other.getFromFloor();
    if (this$fromFloor == null ? other$fromFloor != null
                               : !this$fromFloor.equals(other$fromFloor)) {
      return false;
    }
    final Object this$toFloor = this.getToFloor();
    final Object other$toFloor = other.getToFloor();
    if (this$toFloor == null ? other$toFloor != null : !this$toFloor.equals(other$toFloor)) {
      return false;
    }
    final Object this$fromFacility = this.getFromFacility();
    final Object other$fromFacility = other.getFromFacility();
    if (this$fromFacility == null ? other$fromFacility != null : !this$fromFacility.equals(
        other$fromFacility)) {
      return false;
    }
    final Object this$toFacility = this.getToFacility();
    final Object other$toFacility = other.getToFacility();
    if (this$toFacility == null ? other$toFacility != null : !this$toFacility.equals(
        other$toFacility)) {
      return false;
    }
    if (Double.compare(this.getFromX(), other.getFromX()) != 0) {
      return false;
    }
    if (Double.compare(this.getFromY(), other.getFromY()) != 0) {
      return false;
    }
    if (Double.compare(this.getToX(), other.getToX()) != 0) {
      return false;
    }
    if (Double.compare(this.getToY(), other.getToY()) != 0) {
      return false;
    }
    final Object this$observationTime = this.getObservationTime();
    final Object other$observationTime = other.getObservationTime();
    return this$observationTime == null ? other$observationTime == null
                                        : this$observationTime.equals(
                                            other$observationTime);
  }

  public int hashCode() {
    final int PRIME = 59;
    int result = 1;
    final Object $epc = this.getEpc();
    result = result * PRIME + ($epc == null ? 43 : $epc.hashCode());
    final Object $tagId = this.getTagId();
    result = result * PRIME + ($tagId == null ? 43 : $tagId.hashCode());
    final Object $jobId = this.getJobId();
    result = result * PRIME + ($jobId == null ? 43 : $jobId.hashCode());
    final Object $fromZone = this.getFromZone();
    result = result * PRIME + ($fromZone == null ? 43 : $fromZone.hashCode());
    final Object $toZone = this.getToZone();
    result = result * PRIME + ($toZone == null ? 43 : $toZone.hashCode());
    final Object $fromFloor = this.getFromFloor();
    result = result * PRIME + ($fromFloor == null ? 43 : $fromFloor.hashCode());
    final Object $toFloor = this.getToFloor();
    result = result * PRIME + ($toFloor == null ? 43 : $toFloor.hashCode());
    final Object $fromFacility = this.getFromFacility();
    result = result * PRIME + ($fromFacility == null ? 43 : $fromFacility.hashCode());
    final Object $toFacility = this.getToFacility();
    result = result * PRIME + ($toFacility == null ? 43 : $toFacility.hashCode());
    final long $fromX = Double.doubleToLongBits(this.getFromX());
    result = result * PRIME + (int) ($fromX >>> 32 ^ $fromX);
    final long $fromY = Double.doubleToLongBits(this.getFromY());
    result = result * PRIME + (int) ($fromY >>> 32 ^ $fromY);
    final long $toX = Double.doubleToLongBits(this.getToX());
    result = result * PRIME + (int) ($toX >>> 32 ^ $toX);
    final long $toY = Double.doubleToLongBits(this.getToY());
    result = result * PRIME + (int) ($toY >>> 32 ^ $toY);
    final Object $observationTime = this.getObservationTime();
    result = result * PRIME + ($observationTime == null ? 43 : $observationTime.hashCode());
    return result;
  }

  public String toString() {
    return "com.impinj.itemsense.client.data.itemhistory.ItemHistory(epc=" + this.getEpc()
        + ", tagId=" + this.getTagId() + ", jobId=" + this.getJobId() + ", fromZone=" + this
        .getFromZone() + ", toZone=" + this.getToZone() + ", fromFloor=" + this.getFromFloor()
        + ", toFloor=" + this.getToFloor() + ", fromFacility=" + this.getFromFacility()
        + ", toFacility=" + this.getToFacility() + ", fromX=" + this.getFromX() + ", fromY=" + this
        .getFromY() + ", toX=" + this.getToX() + ", toY=" + this.getToY() + ", observationTime="
        + this.getObservationTime() + ")";
  }
}