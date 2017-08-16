package com.impinj.itemsense.client.coordinator.thresholds;

public class ThresholdReaderConfiguration {

  private Integer antennaConfigurationId;

  @java.beans.ConstructorProperties({"antennaConfigurationId"})
  public ThresholdReaderConfiguration(Integer antennaConfigurationId) {
    this.antennaConfigurationId = antennaConfigurationId;
  }

  public ThresholdReaderConfiguration() {}

  public static ThresholdReaderConfigurationBuilder builder() {return new ThresholdReaderConfigurationBuilder();}

  public Integer getAntennaConfigurationId() {return this.antennaConfigurationId;}

  public void setAntennaConfigurationId(Integer antennaConfigurationId) {this.antennaConfigurationId = antennaConfigurationId; }

  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (!(o instanceof ThresholdReaderConfiguration)) {
      return false;
    }
    final ThresholdReaderConfiguration other = (ThresholdReaderConfiguration) o;
    final Object this$antennaConfigurationId = this.getAntennaConfigurationId();
    final Object other$antennaConfigurationId = other.getAntennaConfigurationId();
    return this$antennaConfigurationId == null ? other$antennaConfigurationId == null
                                               : this$antennaConfigurationId.equals(
                                                   other$antennaConfigurationId);
  }

  public int hashCode() {
    final int PRIME = 59;
    int result = 1;
    final Object $antennaConfigurationId = this.getAntennaConfigurationId();
    result = result * PRIME + ($antennaConfigurationId == null ? 43 : $antennaConfigurationId
        .hashCode());
    return result;
  }

  public String toString() {
    return
        "com.impinj.itemsense.client.coordinator.thresholds.ThresholdReaderConfiguration(antennaConfigurationId="
            + this.getAntennaConfigurationId() + ")";
  }

  public static class ThresholdReaderConfigurationBuilder {

    private Integer antennaConfigurationId;

    ThresholdReaderConfigurationBuilder() {}

    public ThresholdReaderConfiguration.ThresholdReaderConfigurationBuilder antennaConfigurationId(
        Integer antennaConfigurationId) {
      this.antennaConfigurationId = antennaConfigurationId;
      return this;
    }

    public ThresholdReaderConfiguration build() {
      return new ThresholdReaderConfiguration(antennaConfigurationId);
    }

    public String toString() {
      return
          "com.impinj.itemsense.client.coordinator.thresholds.ThresholdReaderConfiguration.ThresholdReaderConfigurationBuilder(antennaConfigurationId="
              + this.antennaConfigurationId + ")";
    }
  }
}
