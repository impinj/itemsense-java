package com.impinj.itemsense.client.coordinator.readerconfiguration;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ReportConfig {

  private boolean tidIncluded;
  private boolean peakRssiIncluded;
  private boolean phraseAngleIncluded;
  private boolean dopplerFrequencyIncluded;
  private boolean channelIncluded;

  @java.beans.ConstructorProperties({"tidIncluded", "peakRssiIncluded", "phraseAngleIncluded",
      "dopplerFrequencyIncluded", "channelIncluded"})
  public ReportConfig(
      boolean tidIncluded,
      boolean peakRssiIncluded,
      boolean phraseAngleIncluded,
      boolean dopplerFrequencyIncluded, boolean channelIncluded) {
    this.tidIncluded = tidIncluded;
    this.peakRssiIncluded = peakRssiIncluded;
    this.phraseAngleIncluded = phraseAngleIncluded;
    this.dopplerFrequencyIncluded = dopplerFrequencyIncluded;
    this.channelIncluded = channelIncluded;
  }

  public ReportConfig() {}

  public boolean isTidIncluded() {return this.tidIncluded;}

  public boolean isPeakRssiIncluded() {return this.peakRssiIncluded;}

  public boolean isPhraseAngleIncluded() {return this.phraseAngleIncluded;}

  public boolean isDopplerFrequencyIncluded() {return this.dopplerFrequencyIncluded;}

  public boolean isChannelIncluded() {return this.channelIncluded;}

  public void setTidIncluded(boolean tidIncluded) {this.tidIncluded = tidIncluded; }

  public void setPeakRssiIncluded(boolean peakRssiIncluded) {this.peakRssiIncluded = peakRssiIncluded; }

  public void setPhraseAngleIncluded(boolean phraseAngleIncluded) {this.phraseAngleIncluded = phraseAngleIncluded; }

  public void setDopplerFrequencyIncluded(boolean dopplerFrequencyIncluded) {this.dopplerFrequencyIncluded = dopplerFrequencyIncluded; }

  public void setChannelIncluded(boolean channelIncluded) {this.channelIncluded = channelIncluded; }

  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (!(o instanceof ReportConfig)) {
      return false;
    }
    final ReportConfig other = (ReportConfig) o;
    if (this.isTidIncluded() != other.isTidIncluded()) {
      return false;
    }
    if (this.isPeakRssiIncluded() != other.isPeakRssiIncluded()) {
      return false;
    }
    if (this.isPhraseAngleIncluded() != other.isPhraseAngleIncluded()) {
      return false;
    }
    if (this.isDopplerFrequencyIncluded() != other.isDopplerFrequencyIncluded()) {
      return false;
    }
    return this.isChannelIncluded() == other.isChannelIncluded();
  }

  public int hashCode() {
    final int PRIME = 59;
    int result = 1;
    result = result * PRIME + (this.isTidIncluded() ? 79 : 97);
    result = result * PRIME + (this.isPeakRssiIncluded() ? 79 : 97);
    result = result * PRIME + (this.isPhraseAngleIncluded() ? 79 : 97);
    result = result * PRIME + (this.isDopplerFrequencyIncluded() ? 79 : 97);
    result = result * PRIME + (this.isChannelIncluded() ? 79 : 97);
    return result;
  }

  public String toString() {
    return "com.impinj.itemsense.client.coordinator.readerconfiguration.ReportConfig(tidIncluded="
        + this.isTidIncluded() + ", peakRssiIncluded=" + this.isPeakRssiIncluded()
        + ", phraseAngleIncluded=" + this.isPhraseAngleIncluded() + ", dopplerFrequencyIncluded="
        + this.isDopplerFrequencyIncluded() + ", channelIncluded=" + this.isChannelIncluded() + ")";
  }
}
