package com.impinj.itemsense.client.coordinator.readerconfiguration;

import java.util.List;

public class LocationReaderConfigDetails extends ReaderConfigurationDetails {

  private ReaderMode readerMode;
  private List<Integer> disabledAntennas;
  private Integer session;
  private Double transmitPowerInDbm;
  private Filter filter;

  public LocationReaderConfigDetails(
      ReaderMode readerMode,
      List<Integer> disabledAntennas,
      Integer session,
      Double transmitPowerInDbm,
      Filter filter) {

    this.readerMode = readerMode;
    this.disabledAntennas = disabledAntennas;
    this.session = session;
    this.transmitPowerInDbm = transmitPowerInDbm;
    this.filter = filter;
  }

  public LocationReaderConfigDetails() {}

  public static LocationReaderConfigDetailsBuilder builder() {return new LocationReaderConfigDetailsBuilder();}

  public ReaderMode getReaderMode() {return this.readerMode;}

  public List<Integer> getDisabledAntennas() {return this.disabledAntennas;}

  public Integer getSession() {return this.session;}

  public Double getTransmitPowerInDbm() {return this.transmitPowerInDbm;}

  public Filter getFilter() {return this.filter;}

  public void setReaderMode(ReaderMode readerMode) {this.readerMode = readerMode; }

  public void setDisabledAntennas(List<Integer> disabledAntennas) {this.disabledAntennas = disabledAntennas; }

  public void setSession(Integer session) {this.session = session; }

  public void setTransmitPowerInDbm(Double transmitPowerInDbm) {this.transmitPowerInDbm = transmitPowerInDbm; }

  public void setFilter(Filter filter) {this.filter = filter; }

  public String toString() {
    return
        "com.impinj.itemsense.client.coordinator.readerconfiguration.LocationReaderConfigDetails(readerMode="
            + this.getReaderMode() + ", disabledAntennas=" + this.getDisabledAntennas()
            + ", session=" + this.getSession() + ", transmitPowerInDbm=" + this
            .getTransmitPowerInDbm() + ", filter=" + this.getFilter() + ")";
  }

  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (!(o instanceof LocationReaderConfigDetails)) {
      return false;
    }
    final LocationReaderConfigDetails other = (LocationReaderConfigDetails) o;
    if (!super.equals(o)) {
      return false;
    }
    final Object this$readerMode = this.getReaderMode();
    final Object other$readerMode = other.getReaderMode();
    if (this$readerMode == null ? other$readerMode != null : !this$readerMode.equals(
        other$readerMode)) {
      return false;
    }
    final Object this$disabledAntennas = this.getDisabledAntennas();
    final Object other$disabledAntennas = other.getDisabledAntennas();
    if (this$disabledAntennas == null ? other$disabledAntennas != null
                                      : !this$disabledAntennas.equals(other$disabledAntennas)) {
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
    return this$filter == null ? other$filter == null : this$filter.equals(other$filter);
  }

  public int hashCode() {
    final int PRIME = 59;
    int result = 1;
    result = result * PRIME + super.hashCode();
    final Object $readerMode = this.getReaderMode();
    result = result * PRIME + ($readerMode == null ? 43 : $readerMode.hashCode());
    final Object $disabledAntennas = this.getDisabledAntennas();
    result = result * PRIME + ($disabledAntennas == null ? 43 : $disabledAntennas.hashCode());
    final Object $session = this.getSession();
    result = result * PRIME + ($session == null ? 43 : $session.hashCode());
    final Object $transmitPowerInDbm = this.getTransmitPowerInDbm();
    result = result * PRIME + ($transmitPowerInDbm == null ? 43 : $transmitPowerInDbm.hashCode());
    final Object $filter = this.getFilter();
    result = result * PRIME + ($filter == null ? 43 : $filter.hashCode());
    return result;
  }

  public static class LocationReaderConfigDetailsBuilder {

    private ReaderMode readerMode;
    private List<Integer> disabledAntennas;
    private Integer session;
    private Double transmitPowerInDbm;
    private Filter filter;

    LocationReaderConfigDetailsBuilder() {}

    public LocationReaderConfigDetails.LocationReaderConfigDetailsBuilder readerMode(ReaderMode readerMode) {
      this.readerMode = readerMode;
      return this;
    }

    public LocationReaderConfigDetails.LocationReaderConfigDetailsBuilder disabledAntennas(List<Integer> disabledAntennas) {
      this.disabledAntennas = disabledAntennas;
      return this;
    }

    public LocationReaderConfigDetails.LocationReaderConfigDetailsBuilder session(Integer session) {
      this.session = session;
      return this;
    }

    public LocationReaderConfigDetails.LocationReaderConfigDetailsBuilder transmitPowerInDbm(Double transmitPowerInDbm) {
      this.transmitPowerInDbm = transmitPowerInDbm;
      return this;
    }

    public LocationReaderConfigDetails.LocationReaderConfigDetailsBuilder filter(Filter filter) {
      this.filter = filter;
      return this;
    }

    public LocationReaderConfigDetails build() {
      return new LocationReaderConfigDetails(
          readerMode,
          disabledAntennas,
          session,
          transmitPowerInDbm,
          filter);
    }

    public String toString() {
      return
          "com.impinj.itemsense.client.coordinator.readerconfiguration.LocationReaderConfigDetails.LocationReaderConfigDetailsBuilder(readerMode="
              + this.readerMode + ", disabledAntennas=" + this.disabledAntennas + ", session="
              + this.session + ", transmitPowerInDbm=" + this.transmitPowerInDbm + ", filter="
              + this.filter + ")";
    }
  }
}
