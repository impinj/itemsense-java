package com.impinj.itemsense.client.coordinator.readerconfiguration;

public abstract class ReaderBasicConfigDetails extends ReaderConfigurationDetails {
  private SearchMode searchMode;
  private ReaderMode readerMode;
  private Integer session;
  private Double transmitPowerInDbm;
  private Filter filter;
  private Integer tagPopulationEstimate;
  private Boolean polarization;
  private ChannelConfig channelConfig;

  @java.beans.ConstructorProperties({"searchMode", "readerMode", "session", "transmitPowerInDbm",
      "filter", "tagPopulationEstimate", "polarization", "channelConfig"})
  public ReaderBasicConfigDetails(
      SearchMode searchMode,
      ReaderMode readerMode,
      Integer session,
      Double transmitPowerInDbm,
      Filter filter,
      Integer tagPopulationEstimate,
      Boolean polarization,
      ChannelConfig channelConfig) {
    this.searchMode = searchMode;
    this.readerMode = readerMode;
    this.session = session;
    this.transmitPowerInDbm = transmitPowerInDbm;
    this.filter = filter;
    this.tagPopulationEstimate = tagPopulationEstimate;
    this.polarization = polarization;
    this.channelConfig = channelConfig;
  }

  public ReaderBasicConfigDetails() {}

  public SearchMode getSearchMode() {return this.searchMode;}

  public ReaderMode getReaderMode() {return this.readerMode;}

  public Integer getSession() {return this.session;}

  public Double getTransmitPowerInDbm() {return this.transmitPowerInDbm;}

  public Filter getFilter() {return this.filter;}

  public Integer getTagPopulationEstimate() {return this.tagPopulationEstimate;}

  public Boolean getPolarization() {return this.polarization;}

  public ChannelConfig getChannelConfig() {return this.channelConfig;}

  public void setSearchMode(SearchMode searchMode) {this.searchMode = searchMode; }

  public void setReaderMode(ReaderMode readerMode) {this.readerMode = readerMode; }

  public void setSession(Integer session) {this.session = session; }

  public void setTransmitPowerInDbm(Double transmitPowerInDbm) {this.transmitPowerInDbm = transmitPowerInDbm; }

  public void setFilter(Filter filter) {this.filter = filter; }

  public void setTagPopulationEstimate(Integer tagPopulationEstimate) {this.tagPopulationEstimate = tagPopulationEstimate; }

  public void setPolarization(Boolean polarization) {this.polarization = polarization; }

  public void setChannelConfig(ChannelConfig channelConfig) {this.channelConfig = channelConfig; }

  public String toString() {
    return
        "com.impinj.itemsense.client.coordinator.readerconfiguration.ReaderBasicConfigDetails(searchMode="
            + this.getSearchMode() + ", readerMode=" + this.getReaderMode() + ", session=" + this
            .getSession() + ", transmitPowerInDbm=" + this.getTransmitPowerInDbm() + ", filter="
            + this.getFilter() + ", tagPopulationEstimate=" + this.getTagPopulationEstimate()
            + ", polarization=" + this.getPolarization() + ", channelConfig=" + this
            .getChannelConfig() + ")";
  }

  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (!(o instanceof ReaderBasicConfigDetails)) {
      return false;
    }
    final ReaderBasicConfigDetails other = (ReaderBasicConfigDetails) o;
    if (!super.equals(o)) {
      return false;
    }
    final Object this$searchMode = this.getSearchMode();
    final Object other$searchMode = other.getSearchMode();
    if (this$searchMode == null ? other$searchMode != null : !this$searchMode.equals(
        other$searchMode)) {
      return false;
    }
    final Object this$readerMode = this.getReaderMode();
    final Object other$readerMode = other.getReaderMode();
    if (this$readerMode == null ? other$readerMode != null : !this$readerMode.equals(
        other$readerMode)) {
      return false;
    }
    final Object this$session = this.getSession();
    final Object other$session = other.getSession();
    if (this$session == null ? other$session != null : !this$session.equals(other$session)) {
      return false;
    }
    final Object this$transmitPowerInDbm = this.getTransmitPowerInDbm();
    final Object other$transmitPowerInDbm = other.getTransmitPowerInDbm();
    if (this$transmitPowerInDbm == null ? other$transmitPowerInDbm != null
                                        : !this$transmitPowerInDbm
                                            .equals(other$transmitPowerInDbm)) {
      return false;
    }
    final Object this$filter = this.getFilter();
    final Object other$filter = other.getFilter();
    if (this$filter == null ? other$filter != null : !this$filter.equals(other$filter)) {
      return false;
    }
    final Object this$tagPopulationEstimate = this.getTagPopulationEstimate();
    final Object other$tagPopulationEstimate = other.getTagPopulationEstimate();
    if (this$tagPopulationEstimate == null ? other$tagPopulationEstimate != null
                                           : !this$tagPopulationEstimate.equals(
                                               other$tagPopulationEstimate)) {
      return false;
    }
    final Object this$polarization = this.getPolarization();
    final Object other$polarization = other.getPolarization();
    if (this$polarization == null ? other$polarization != null : !this$polarization.equals(
        other$polarization)) {
      return false;
    }
    final Object this$channelConfig = this.getChannelConfig();
    final Object other$channelConfig = other.getChannelConfig();
    return this$channelConfig == null ? other$channelConfig == null : this$channelConfig.equals(
        other$channelConfig);
  }

  public int hashCode() {
    final int PRIME = 59;
    int result = 1;
    result = result * PRIME + super.hashCode();
    final Object $searchMode = this.getSearchMode();
    result = result * PRIME + ($searchMode == null ? 43 : $searchMode.hashCode());
    final Object $readerMode = this.getReaderMode();
    result = result * PRIME + ($readerMode == null ? 43 : $readerMode.hashCode());
    final Object $session = this.getSession();
    result = result * PRIME + ($session == null ? 43 : $session.hashCode());
    final Object $transmitPowerInDbm = this.getTransmitPowerInDbm();
    result = result * PRIME + ($transmitPowerInDbm == null ? 43 : $transmitPowerInDbm.hashCode());
    final Object $filter = this.getFilter();
    result = result * PRIME + ($filter == null ? 43 : $filter.hashCode());
    final Object $tagPopulationEstimate = this.getTagPopulationEstimate();
    result =
        result * PRIME + ($tagPopulationEstimate == null ? 43 : $tagPopulationEstimate.hashCode());
    final Object $polarization = this.getPolarization();
    result = result * PRIME + ($polarization == null ? 43 : $polarization.hashCode());
    final Object $channelConfig = this.getChannelConfig();
    result = result * PRIME + ($channelConfig == null ? 43 : $channelConfig.hashCode());
    return result;
  }

}
