package com.impinj.itemsense.client.coordinator.readerconfiguration;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ChannelConfig {

  private int channelIndex;
  private double[] txFrequenciesInMhz;

  @java.beans.ConstructorProperties({"channelIndex", "txFrequenciesInMhz"})
  public ChannelConfig(int channelIndex, double[] txFrequenciesInMhz) {
    this.channelIndex = channelIndex;
    this.txFrequenciesInMhz = txFrequenciesInMhz;
  }

  public ChannelConfig() {}

  public int getChannelIndex() {return this.channelIndex;}

  public double[] getTxFrequenciesInMhz() {return this.txFrequenciesInMhz;}

  public void setChannelIndex(int channelIndex) {this.channelIndex = channelIndex; }

  public void setTxFrequenciesInMhz(double[] txFrequenciesInMhz) {this.txFrequenciesInMhz = txFrequenciesInMhz; }

  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (!(o instanceof ChannelConfig)) {
      return false;
    }
    final ChannelConfig other = (ChannelConfig) o;
    if (this.getChannelIndex() != other.getChannelIndex()) {
      return false;
    }
    return java.util.Arrays.equals(this.getTxFrequenciesInMhz(), other.getTxFrequenciesInMhz());
  }

  public int hashCode() {
    final int PRIME = 59;
    int result = 1;
    result = result * PRIME + this.getChannelIndex();
    result = result * PRIME + java.util.Arrays.hashCode(this.getTxFrequenciesInMhz());
    return result;
  }

  public String toString() {
    return "com.impinj.itemsense.client.coordinator.readerconfiguration.ChannelConfig(channelIndex="
        + this.getChannelIndex() + ", txFrequenciesInMhz=" + java.util.Arrays
        .toString(this.getTxFrequenciesInMhz()) + ")";
  }
}
