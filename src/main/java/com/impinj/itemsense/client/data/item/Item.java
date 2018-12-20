package com.impinj.itemsense.client.data.item;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.impinj.itemsense.client.data.PresenceConfidence;
import java.time.ZonedDateTime;


@JsonIgnoreProperties(ignoreUnknown = true)
public class Item {

  private String epc;
  private String tagId;
  private String jobId;

  private double xLocation;
  private double yLocation;
  private double zLocation;
  private String zone;
  private String floor;
  private String facility;
  @Deprecated
  private PresenceConfidence presenceConfidence;

  private ZonedDateTime lastModifiedTime;

  @java.beans.ConstructorProperties({"epc", "tagId", "jobId", "xLocation", "yLocation", "zLocation",
      "zone", "floor", "facility", "presenceConfidence", "lastModifiedTime"})
  public Item(
      String epc,
      String tagId,
      String jobId,
      double xLocation,
      double yLocation,
      double zLocation,
      String zone,
      String floor,
      String facility,
      PresenceConfidence presenceConfidence, ZonedDateTime lastModifiedTime) {
    this.epc = epc;
    this.tagId = tagId;
    this.jobId = jobId;
    this.xLocation = xLocation;
    this.yLocation = yLocation;
    this.zLocation = zLocation;
    this.zone = zone;
    this.floor = floor;
    this.facility = facility;
    this.presenceConfidence = presenceConfidence;
    this.lastModifiedTime = lastModifiedTime;
  }

  public Item() {}

  public String getEpc() {return this.epc;}

  public String getTagId() {return this.tagId;}

  public String getJobId() {return this.jobId;}

  public double getXLocation() {return this.xLocation;}

  public double getYLocation() {return this.yLocation;}

  public double getZLocation() {return this.zLocation;}

  public String getZone() {return this.zone;}

  public String getFloor() {return this.floor;}

  public String getFacility() {return this.facility;}

  @Deprecated
  public PresenceConfidence getPresenceConfidence() {return this.presenceConfidence;}

  public ZonedDateTime getLastModifiedTime() {return this.lastModifiedTime;}

  public void setEpc(String epc) {this.epc = epc; }

  public void setTagId(String tagId) {this.tagId = tagId; }

  public void setJobId(String jobId) {this.jobId = jobId; }

  public void setXLocation(double xLocation) {this.xLocation = xLocation; }

  public void setYLocation(double yLocation) {this.yLocation = yLocation; }

  public void setZLocation(double zLocation) {this.zLocation = zLocation; }

  public void setZone(String zone) {this.zone = zone; }

  public void setFloor(String floor) {this.floor = floor; }

  public void setFacility(String facility) {this.facility = facility; }

  @Deprecated
  public void setPresenceConfidence(PresenceConfidence presenceConfidence) {this.presenceConfidence = presenceConfidence; }

  public void setLastModifiedTime(ZonedDateTime lastModifiedTime) {this.lastModifiedTime = lastModifiedTime; }

  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (!(o instanceof Item)) {
      return false;
    }
    final Item other = (Item) o;
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
    if (Double.compare(this.getXLocation(), other.getXLocation()) != 0) {
      return false;
    }
    if (Double.compare(this.getYLocation(), other.getYLocation()) != 0) {
      return false;
    }
    if (Double.compare(this.getZLocation(), other.getZLocation()) != 0) {
      return false;
    }
    final Object this$zone = this.getZone();
    final Object other$zone = other.getZone();
    if (this$zone == null ? other$zone != null : !this$zone.equals(other$zone)) {
      return false;
    }
    final Object this$floor = this.getFloor();
    final Object other$floor = other.getFloor();
    if (this$floor == null ? other$floor != null : !this$floor.equals(other$floor)) {
      return false;
    }
    final Object this$facility = this.getFacility();
    final Object other$facility = other.getFacility();
    if (this$facility == null ? other$facility != null : !this$facility.equals(other$facility)) {
      return false;
    }
    final Object this$presenceConfidence = this.getPresenceConfidence();
    final Object other$presenceConfidence = other.getPresenceConfidence();
    if (this$presenceConfidence == null ? other$presenceConfidence != null
                                        : !this$presenceConfidence
                                            .equals(other$presenceConfidence)) {
      return false;
    }
    final Object this$lastModifiedTime = this.getLastModifiedTime();
    final Object other$lastModifiedTime = other.getLastModifiedTime();
    return this$lastModifiedTime == null ? other$lastModifiedTime == null
                                         : this$lastModifiedTime.equals(other$lastModifiedTime);
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
    final long $xLocation = Double.doubleToLongBits(this.getXLocation());
    result = result * PRIME + (int) ($xLocation >>> 32 ^ $xLocation);
    final long $yLocation = Double.doubleToLongBits(this.getYLocation());
    result = result * PRIME + (int) ($yLocation >>> 32 ^ $yLocation);
    final long $zLocation = Double.doubleToLongBits(this.getZLocation());
    result = result * PRIME + (int) ($zLocation >>> 32 ^ $zLocation);
    final Object $zone = this.getZone();
    result = result * PRIME + ($zone == null ? 43 : $zone.hashCode());
    final Object $floor = this.getFloor();
    result = result * PRIME + ($floor == null ? 43 : $floor.hashCode());
    final Object $facility = this.getFacility();
    result = result * PRIME + ($facility == null ? 43 : $facility.hashCode());
    final Object $presenceConfidence = this.getPresenceConfidence();
    result = result * PRIME + ($presenceConfidence == null ? 43 : $presenceConfidence.hashCode());
    final Object $lastModifiedTime = this.getLastModifiedTime();
    result = result * PRIME + ($lastModifiedTime == null ? 43 : $lastModifiedTime.hashCode());
    return result;
  }

  public String toString() {
    return "com.impinj.itemsense.client.data.item.Item(epc=" + this.getEpc() + ", tagId=" + this
        .getTagId() + ", jobId=" + this.getJobId() + ", xLocation=" + this.getXLocation()
        + ", yLocation=" + this.getYLocation() + ", zLocation=" + this.getZLocation() + ", zone="
        + this.getZone() + ", floor=" + this.getFloor() + ", facility=" + this.getFacility()
        + ", presenceConfidence=" + this.getPresenceConfidence() + ", lastModifiedTime=" + this
        .getLastModifiedTime() + ")";
  }
}
