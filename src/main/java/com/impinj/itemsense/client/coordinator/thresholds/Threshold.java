package com.impinj.itemsense.client.coordinator.thresholds;

import java.util.Map;

public class Threshold {

  private Integer id;
  private String name;
  private String facility;
  private ThresholdReaderArrangement readerArrangement;
  private Map<String, ThresholdReaderConfiguration> readers;

  @java.beans.ConstructorProperties({"id", "name", "facility", "readerArrangement", "readers"})
  public Threshold(
      Integer id,
      String name,
      String facility,
      ThresholdReaderArrangement readerArrangement,
      Map<String, ThresholdReaderConfiguration> readers) {
    this.id = id;
    this.name = name;
    this.facility = facility;
    this.readerArrangement = readerArrangement;
    this.readers = readers;
  }

  public Threshold() {}

  public static ThresholdBuilder builder() {return new ThresholdBuilder();}

  public Integer getId() {return this.id;}

  public String getName() {return this.name;}

  public String getFacility() {return this.facility;}

  public ThresholdReaderArrangement getReaderArrangement() {return this.readerArrangement;}

  public Map<String, ThresholdReaderConfiguration> getReaders() {return this.readers;}

  public void setId(Integer id) {this.id = id; }

  public void setName(String name) {this.name = name; }

  public void setFacility(String facility) {this.facility = facility; }

  public void setReaderArrangement(ThresholdReaderArrangement readerArrangement) {this.readerArrangement = readerArrangement; }

  public void setReaders(Map<String, ThresholdReaderConfiguration> readers) {this.readers = readers; }

  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (!(o instanceof Threshold)) {
      return false;
    }
    final Threshold other = (Threshold) o;
    final Object this$id = this.getId();
    final Object other$id = other.getId();
    if (this$id == null ? other$id != null : !this$id.equals(other$id)) {
      return false;
    }
    final Object this$name = this.getName();
    final Object other$name = other.getName();
    if (this$name == null ? other$name != null : !this$name.equals(other$name)) {
      return false;
    }
    final Object this$facility = this.getFacility();
    final Object other$facility = other.getFacility();
    if (this$facility == null ? other$facility != null : !this$facility.equals(other$facility)) {
      return false;
    }
    final Object this$readerArrangement = this.getReaderArrangement();
    final Object other$readerArrangement = other.getReaderArrangement();
    if (this$readerArrangement == null ? other$readerArrangement != null
                                       : !this$readerArrangement.equals(other$readerArrangement)) {
      return false;
    }
    final Object this$readers = this.getReaders();
    final Object other$readers = other.getReaders();
    return this$readers == null ? other$readers == null : this$readers.equals(other$readers);
  }

  public int hashCode() {
    final int PRIME = 59;
    int result = 1;
    final Object $id = this.getId();
    result = result * PRIME + ($id == null ? 43 : $id.hashCode());
    final Object $name = this.getName();
    result = result * PRIME + ($name == null ? 43 : $name.hashCode());
    final Object $facility = this.getFacility();
    result = result * PRIME + ($facility == null ? 43 : $facility.hashCode());
    final Object $readerArrangement = this.getReaderArrangement();
    result = result * PRIME + ($readerArrangement == null ? 43 : $readerArrangement.hashCode());
    final Object $readers = this.getReaders();
    result = result * PRIME + ($readers == null ? 43 : $readers.hashCode());
    return result;
  }

  public String toString() {
    return "com.impinj.itemsense.client.coordinator.thresholds.Threshold(id=" + this.getId()
        + ", name=" + this.getName() + ", facility=" + this.getFacility() + ", readerArrangement="
        + this.getReaderArrangement() + ", readers=" + this.getReaders() + ")";
  }

  public static class ThresholdBuilder {

    private Integer id;
    private String name;
    private String facility;
    private ThresholdReaderArrangement readerArrangement;
    private Map<String, ThresholdReaderConfiguration> readers;

    ThresholdBuilder() {}

    public Threshold.ThresholdBuilder id(Integer id) {
      this.id = id;
      return this;
    }

    public Threshold.ThresholdBuilder name(String name) {
      this.name = name;
      return this;
    }

    public Threshold.ThresholdBuilder facility(String facility) {
      this.facility = facility;
      return this;
    }

    public Threshold.ThresholdBuilder readerArrangement(ThresholdReaderArrangement readerArrangement) {
      this.readerArrangement = readerArrangement;
      return this;
    }

    public Threshold.ThresholdBuilder readers(Map<String, ThresholdReaderConfiguration> readers) {
      this.readers = readers;
      return this;
    }

    public Threshold build() {
      return new Threshold(id, name, facility, readerArrangement, readers);
    }

    public String toString() {
      return "com.impinj.itemsense.client.coordinator.thresholds.Threshold.ThresholdBuilder(id="
          + this.id + ", name=" + this.name + ", facility=" + this.facility + ", readerArrangement="
          + this.readerArrangement + ", readers=" + this.readers + ")";
    }
  }
}