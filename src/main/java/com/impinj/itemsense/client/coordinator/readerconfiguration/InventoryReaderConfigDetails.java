package com.impinj.itemsense.client.coordinator.readerconfiguration;

import java.util.List;

public class InventoryReaderConfigDetails extends ReaderBasicConfigDetails {

  private List<Integer> antennas;

  public InventoryReaderConfigDetails(
      SearchMode searchMode,
      ReaderMode readerMode,
      Integer session,
      Double transmitPowerInDbm,
      Filter filter,
      Integer tagPopulationEstimate,
      Boolean polarization,
      List<Integer> antennas,
      ChannelConfig channelConfig) {

    super(searchMode, readerMode, session, transmitPowerInDbm,
          filter, tagPopulationEstimate, polarization, channelConfig);

    this.antennas = antennas;
  }

  public InventoryReaderConfigDetails() {}

  public static InventoryReaderConfigDetailsBuilder builder() {return new InventoryReaderConfigDetailsBuilder();}

  public List<Integer> getAntennas() {return this.antennas;}

  public void setAntennas(List<Integer> antennas) {this.antennas = antennas; }

  public String toString() {
    return
        "com.impinj.itemsense.client.coordinator.readerconfiguration.InventoryReaderConfigDetails(antennas="
            + this.getAntennas() + ")";
  }

  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (!(o instanceof InventoryReaderConfigDetails)) {
      return false;
    }
    final InventoryReaderConfigDetails other = (InventoryReaderConfigDetails) o;
    if (!super.equals(o)) {
      return false;
    }
    final Object this$antennas = this.getAntennas();
    final Object other$antennas = other.getAntennas();
    return this$antennas == null ? other$antennas == null : this$antennas.equals(other$antennas);
  }

  public int hashCode() {
    final int PRIME = 59;
    int result = 1;
    result = result * PRIME + super.hashCode();
    final Object $antennas = this.getAntennas();
    result = result * PRIME + ($antennas == null ? 43 : $antennas.hashCode());
    return result;
  }

  public static class InventoryReaderConfigDetailsBuilder {

    private SearchMode searchMode;
    private ReaderMode readerMode;
    private Integer session;
    private Double transmitPowerInDbm;
    private Filter filter;
    private Integer tagPopulationEstimate;
    private Boolean polarization;
    private List<Integer> antennas;
    private ChannelConfig channelConfig;

    InventoryReaderConfigDetailsBuilder() {}

    public InventoryReaderConfigDetails.InventoryReaderConfigDetailsBuilder searchMode(SearchMode searchMode) {
      this.searchMode = searchMode;
      return this;
    }

    public InventoryReaderConfigDetails.InventoryReaderConfigDetailsBuilder readerMode(ReaderMode readerMode) {
      this.readerMode = readerMode;
      return this;
    }

    public InventoryReaderConfigDetails.InventoryReaderConfigDetailsBuilder session(Integer session) {
      this.session = session;
      return this;
    }

    public InventoryReaderConfigDetails.InventoryReaderConfigDetailsBuilder transmitPowerInDbm(
        Double transmitPowerInDbm) {
      this.transmitPowerInDbm = transmitPowerInDbm;
      return this;
    }

    public InventoryReaderConfigDetails.InventoryReaderConfigDetailsBuilder filter(Filter filter) {
      this.filter = filter;
      return this;
    }

    public InventoryReaderConfigDetails.InventoryReaderConfigDetailsBuilder tagPopulationEstimate(
        Integer tagPopulationEstimate) {
      this.tagPopulationEstimate = tagPopulationEstimate;
      return this;
    }

    public InventoryReaderConfigDetails.InventoryReaderConfigDetailsBuilder polarization(Boolean polarization) {
      this.polarization = polarization;
      return this;
    }

    public InventoryReaderConfigDetails.InventoryReaderConfigDetailsBuilder antennas(List<Integer> antennas) {
      this.antennas = antennas;
      return this;
    }

    public InventoryReaderConfigDetails.InventoryReaderConfigDetailsBuilder channelConfig(
        ChannelConfig channelConfig) {
      this.channelConfig = channelConfig;
      return this;
    }

    public InventoryReaderConfigDetails build() {
      return new InventoryReaderConfigDetails(
          searchMode,
          readerMode,
          session,
          transmitPowerInDbm,
          filter,
          tagPopulationEstimate,
          polarization,
          antennas,
          channelConfig);
    }

    public String toString() {
      return
          "com.impinj.itemsense.client.coordinator.readerconfiguration.InventoryReaderConfigDetails.InventoryReaderConfigDetailsBuilder(searchMode="
              + this.searchMode + ", readerMode=" + this.readerMode + ", session=" + this.session
              + ", transmitPowerInDbm=" + this.transmitPowerInDbm + ", filter=" + this.filter
              + ", tagPopulationEstimate=" + this.tagPopulationEstimate + ", polarization="
              + this.polarization + ", antennas=" + this.antennas + ", channelConfig="
              + this.channelConfig + ")";
    }
  }
}
