package com.impinj.itemsense.client.coordinator.thresholds;

public class ThresholdAntennaConfigurationAntenna {

  private Integer antennaId;

  @java.beans.ConstructorProperties({"antennaId"})
  public ThresholdAntennaConfigurationAntenna(Integer antennaId) {
    this.antennaId = antennaId;
  }

  public ThresholdAntennaConfigurationAntenna() {}

  public static ThresholdAntennaConfigurationAntennaBuilder builder() {return new ThresholdAntennaConfigurationAntennaBuilder();}

  public Integer getAntennaId() {return this.antennaId;}

  public void setAntennaId(Integer antennaId) {this.antennaId = antennaId; }

  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (!(o instanceof ThresholdAntennaConfigurationAntenna)) {
      return false;
    }
    final ThresholdAntennaConfigurationAntenna other = (ThresholdAntennaConfigurationAntenna) o;
    final Object this$antennaId = this.getAntennaId();
    final Object other$antennaId = other.getAntennaId();
    return this$antennaId == null ? other$antennaId == null
                                  : this$antennaId.equals(other$antennaId);
  }

  public int hashCode() {
    final int PRIME = 59;
    int result = 1;
    final Object $antennaId = this.getAntennaId();
    result = result * PRIME + ($antennaId == null ? 43 : $antennaId.hashCode());
    return result;
  }

  public String toString() {
    return
        "com.impinj.itemsense.client.coordinator.thresholds.ThresholdAntennaConfigurationAntenna(antennaId="
            + this.getAntennaId() + ")";
  }

  public static class ThresholdAntennaConfigurationAntennaBuilder {

    private Integer antennaId;

    ThresholdAntennaConfigurationAntennaBuilder() {}

    public ThresholdAntennaConfigurationAntenna.ThresholdAntennaConfigurationAntennaBuilder antennaId(
        Integer antennaId) {
      this.antennaId = antennaId;
      return this;
    }

    public ThresholdAntennaConfigurationAntenna build() {
      return new ThresholdAntennaConfigurationAntenna(antennaId);
    }

    public String toString() {
      return
          "com.impinj.itemsense.client.coordinator.thresholds.ThresholdAntennaConfigurationAntenna.ThresholdAntennaConfigurationAntennaBuilder(antennaId="
              + this.antennaId + ")";
    }
  }
}
