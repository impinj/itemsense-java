package com.impinj.itemsense.client.coordinator.readerconfiguration;

public class ThresholdReaderConfigDetails extends ReaderBasicConfigDetails {

  private ThresholdReaderConfigDetails(
      SearchMode searchMode,
      ReaderMode readerMode,
      Integer session,
      Double transmitPowerInDbm,
      Filter filter,
      Integer tagPopulationEstimate,
      Boolean polarization,
      ChannelConfig channelConfig) {

    super(searchMode, readerMode, session, transmitPowerInDbm,
          filter, tagPopulationEstimate, polarization, channelConfig);
  }

  public ThresholdReaderConfigDetails() {}

  public static ThresholdReaderConfigDetailsBuilder builder() {return new ThresholdReaderConfigDetailsBuilder();}

  public static class ThresholdReaderConfigDetailsBuilder {

    private SearchMode searchMode;
    private ReaderMode readerMode;
    private Integer session;
    private Double transmitPowerInDbm;
    private Filter filter;
    private Integer tagPopulationEstimate;
    private Boolean polarization;
    private ChannelConfig channelConfig;

    ThresholdReaderConfigDetailsBuilder() {}

    public ThresholdReaderConfigDetails.ThresholdReaderConfigDetailsBuilder searchMode(SearchMode searchMode) {
      this.searchMode = searchMode;
      return this;
    }

    public ThresholdReaderConfigDetails.ThresholdReaderConfigDetailsBuilder readerMode(ReaderMode readerMode) {
      this.readerMode = readerMode;
      return this;
    }

    public ThresholdReaderConfigDetails.ThresholdReaderConfigDetailsBuilder session(Integer session) {
      this.session = session;
      return this;
    }

    public ThresholdReaderConfigDetails.ThresholdReaderConfigDetailsBuilder transmitPowerInDbm(
        Double transmitPowerInDbm) {
      this.transmitPowerInDbm = transmitPowerInDbm;
      return this;
    }

    public ThresholdReaderConfigDetails.ThresholdReaderConfigDetailsBuilder filter(Filter filter) {
      this.filter = filter;
      return this;
    }

    public ThresholdReaderConfigDetails.ThresholdReaderConfigDetailsBuilder tagPopulationEstimate(
        Integer tagPopulationEstimate) {
      this.tagPopulationEstimate = tagPopulationEstimate;
      return this;
    }

    public ThresholdReaderConfigDetails.ThresholdReaderConfigDetailsBuilder polarization(Boolean polarization) {
      this.polarization = polarization;
      return this;
    }

    public ThresholdReaderConfigDetails.ThresholdReaderConfigDetailsBuilder channelConfig(
        ChannelConfig channelConfig) {
      this.channelConfig = channelConfig;
      return this;
    }

    public ThresholdReaderConfigDetails build() {
      return new ThresholdReaderConfigDetails(
          searchMode,
          readerMode,
          session,
          transmitPowerInDbm,
          filter,
          tagPopulationEstimate,
          polarization,
          channelConfig);
    }

    public String toString() {
      return
          "com.impinj.itemsense.client.coordinator.readerconfiguration.ThresholdReaderConfigDetails.ThresholdReaderConfigDetailsBuilder(searchMode="
              + this.searchMode + ", readerMode=" + this.readerMode + ", session=" + this.session
              + ", transmitPowerInDbm=" + this.transmitPowerInDbm + ", filter=" + this.filter
              + ", tagPopulationEstimate=" + this.tagPopulationEstimate + ", polarization="
              + this.polarization + ", channelConfig=" + this.channelConfig + ")";
    }
  }
}
