package com.impinj.itemsense.client.coordinator.readerhealth;

import java.time.ZonedDateTime;
import java.util.List;

public class ReaderStatus {

  private String readerName;

  private ReaderState state;

  private ZonedDateTime lastCheckin;

  private ZonedDateTime lastReboot;

  private ReaderVersion version;

  private ConnectionStatus connectionStatus;

  private ThroughputStatus throughputStatus;

  private ClockSyncStatus clockSyncStatus;

  private HardwareStatus hardwareStatus;

  private SoftwareStatus softwareStatus;

  @java.beans.ConstructorProperties({"readerName", "state", "lastCheckin", "lastReboot", "version",
      "connectionStatus", "throughputStatus", "clockSyncStatus", "hardwareStatus",
      "softwareStatus"})
  public ReaderStatus(
      String readerName,
      ReaderState state,
      ZonedDateTime lastCheckin,
      ZonedDateTime lastReboot,
      ReaderVersion version,
      ConnectionStatus connectionStatus,
      ThroughputStatus throughputStatus,
      ClockSyncStatus clockSyncStatus,
      HardwareStatus hardwareStatus, SoftwareStatus softwareStatus) {
    this.readerName = readerName;
    this.state = state;
    this.lastCheckin = lastCheckin;
    this.lastReboot = lastReboot;
    this.version = version;
    this.connectionStatus = connectionStatus;
    this.throughputStatus = throughputStatus;
    this.clockSyncStatus = clockSyncStatus;
    this.hardwareStatus = hardwareStatus;
    this.softwareStatus = softwareStatus;
  }

  public ReaderStatus() {}

  public static ReaderStatusBuilder builder() {return new ReaderStatusBuilder();}

  public String getReaderName() {return this.readerName;}

  public ReaderState getState() {return this.state;}

  public ZonedDateTime getLastCheckin() {return this.lastCheckin;}

  public ZonedDateTime getLastReboot() {return this.lastReboot;}

  public ReaderVersion getVersion() {return this.version;}

  public ConnectionStatus getConnectionStatus() {return this.connectionStatus;}

  public ThroughputStatus getThroughputStatus() {return this.throughputStatus;}

  public ClockSyncStatus getClockSyncStatus() {return this.clockSyncStatus;}

  public HardwareStatus getHardwareStatus() {return this.hardwareStatus;}

  public SoftwareStatus getSoftwareStatus() {return this.softwareStatus;}

  public void setReaderName(String readerName) {this.readerName = readerName; }

  public void setState(ReaderState state) {this.state = state; }

  public void setLastCheckin(ZonedDateTime lastCheckin) {this.lastCheckin = lastCheckin; }

  public void setLastReboot(ZonedDateTime lastReboot) {this.lastReboot = lastReboot; }

  public void setVersion(ReaderVersion version) {this.version = version; }

  public void setConnectionStatus(ConnectionStatus connectionStatus) {this.connectionStatus = connectionStatus; }

  public void setThroughputStatus(ThroughputStatus throughputStatus) {this.throughputStatus = throughputStatus; }

  public void setClockSyncStatus(ClockSyncStatus clockSyncStatus) {this.clockSyncStatus = clockSyncStatus; }

  public void setHardwareStatus(HardwareStatus hardwareStatus) {this.hardwareStatus = hardwareStatus; }

  public void setSoftwareStatus(SoftwareStatus softwareStatus) {this.softwareStatus = softwareStatus; }

  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (!(o instanceof ReaderStatus)) {
      return false;
    }
    final ReaderStatus other = (ReaderStatus) o;
    final Object this$readerName = this.getReaderName();
    final Object other$readerName = other.getReaderName();
    if (this$readerName == null ? other$readerName != null : !this$readerName.equals(
        other$readerName)) {
      return false;
    }
    final Object this$state = this.getState();
    final Object other$state = other.getState();
    if (this$state == null ? other$state != null : !this$state.equals(other$state)) {
      return false;
    }
    final Object this$lastCheckin = this.getLastCheckin();
    final Object other$lastCheckin = other.getLastCheckin();
    if (this$lastCheckin == null ? other$lastCheckin != null : !this$lastCheckin.equals(
        other$lastCheckin)) {
      return false;
    }
    final Object this$lastReboot = this.getLastReboot();
    final Object other$lastReboot = other.getLastReboot();
    if (this$lastReboot == null ? other$lastReboot != null : !this$lastReboot.equals(
        other$lastReboot)) {
      return false;
    }
    final Object this$version = this.getVersion();
    final Object other$version = other.getVersion();
    if (this$version == null ? other$version != null : !this$version.equals(other$version)) {
      return false;
    }
    final Object this$connectionStatus = this.getConnectionStatus();
    final Object other$connectionStatus = other.getConnectionStatus();
    if (this$connectionStatus == null ? other$connectionStatus != null
                                      : !this$connectionStatus.equals(other$connectionStatus)) {
      return false;
    }
    final Object this$throughputStatus = this.getThroughputStatus();
    final Object other$throughputStatus = other.getThroughputStatus();
    if (this$throughputStatus == null ? other$throughputStatus != null
                                      : !this$throughputStatus.equals(other$throughputStatus)) {
      return false;
    }
    final Object this$clockSyncStatus = this.getClockSyncStatus();
    final Object other$clockSyncStatus = other.getClockSyncStatus();
    if (this$clockSyncStatus == null ? other$clockSyncStatus != null : !this$clockSyncStatus.equals(
        other$clockSyncStatus)) {
      return false;
    }
    final Object this$hardwareStatus = this.getHardwareStatus();
    final Object other$hardwareStatus = other.getHardwareStatus();
    if (this$hardwareStatus == null ? other$hardwareStatus != null : !this$hardwareStatus.equals(
        other$hardwareStatus)) {
      return false;
    }
    final Object this$softwareStatus = this.getSoftwareStatus();
    final Object other$softwareStatus = other.getSoftwareStatus();
    return this$softwareStatus == null ? other$softwareStatus == null : this$softwareStatus.equals(
        other$softwareStatus);
  }

  public int hashCode() {
    final int PRIME = 59;
    int result = 1;
    final Object $readerName = this.getReaderName();
    result = result * PRIME + ($readerName == null ? 43 : $readerName.hashCode());
    final Object $state = this.getState();
    result = result * PRIME + ($state == null ? 43 : $state.hashCode());
    final Object $lastCheckin = this.getLastCheckin();
    result = result * PRIME + ($lastCheckin == null ? 43 : $lastCheckin.hashCode());
    final Object $lastReboot = this.getLastReboot();
    result = result * PRIME + ($lastReboot == null ? 43 : $lastReboot.hashCode());
    final Object $version = this.getVersion();
    result = result * PRIME + ($version == null ? 43 : $version.hashCode());
    final Object $connectionStatus = this.getConnectionStatus();
    result = result * PRIME + ($connectionStatus == null ? 43 : $connectionStatus.hashCode());
    final Object $throughputStatus = this.getThroughputStatus();
    result = result * PRIME + ($throughputStatus == null ? 43 : $throughputStatus.hashCode());
    final Object $clockSyncStatus = this.getClockSyncStatus();
    result = result * PRIME + ($clockSyncStatus == null ? 43 : $clockSyncStatus.hashCode());
    final Object $hardwareStatus = this.getHardwareStatus();
    result = result * PRIME + ($hardwareStatus == null ? 43 : $hardwareStatus.hashCode());
    final Object $softwareStatus = this.getSoftwareStatus();
    result = result * PRIME + ($softwareStatus == null ? 43 : $softwareStatus.hashCode());
    return result;
  }

  public String toString() {
    return "com.impinj.itemsense.client.coordinator.readerhealth.ReaderStatus(readerName=" + this
        .getReaderName() + ", state=" + this.getState() + ", lastCheckin=" + this.getLastCheckin()
        + ", lastReboot=" + this.getLastReboot() + ", version=" + this.getVersion()
        + ", connectionStatus=" + this.getConnectionStatus() + ", throughputStatus=" + this
        .getThroughputStatus() + ", clockSyncStatus=" + this.getClockSyncStatus()
        + ", hardwareStatus=" + this.getHardwareStatus() + ", softwareStatus=" + this
        .getSoftwareStatus() + ")";
  }

  public static class GenericStatus {

    private StatusLevel status;
    private String code;

    @java.beans.ConstructorProperties({"status", "code"})
    public GenericStatus(StatusLevel status, String code) {
      this.status = status;
      this.code = code;
    }

    public GenericStatus() {}

    public StatusLevel getStatus() {return this.status;}

    public String getCode() {return this.code;}

    public void setStatus(StatusLevel status) {this.status = status; }

    public void setCode(String code) {this.code = code; }

    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (!(o instanceof GenericStatus)) {
        return false;
      }
      final GenericStatus other = (GenericStatus) o;
      final Object this$status = this.getStatus();
      final Object other$status = other.getStatus();
      if (this$status == null ? other$status != null : !this$status.equals(other$status)) {
        return false;
      }
      final Object this$code = this.getCode();
      final Object other$code = other.getCode();
      return this$code == null ? other$code == null : this$code.equals(other$code);
    }

    public int hashCode() {
      final int PRIME = 59;
      int result = 1;
      final Object $status = this.getStatus();
      result = result * PRIME + ($status == null ? 43 : $status.hashCode());
      final Object $code = this.getCode();
      result = result * PRIME + ($code == null ? 43 : $code.hashCode());
      return result;
    }

    public String toString() {
      return
          "com.impinj.itemsense.client.coordinator.readerhealth.ReaderStatus.GenericStatus(status="
              + this.getStatus() + ", code=" + this.getCode() + ")";
    }
  }

  public static class ConnectionStatus extends GenericStatus {

    public ConnectionStatus(StatusLevel status, String code) {
      super(status, code);
    }

    public ConnectionStatus() {}

    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (!(o instanceof ConnectionStatus)) {
        return false;
      }
      final ConnectionStatus other = (ConnectionStatus) o;
      return super.equals(o);
    }

    public int hashCode() {
      final int PRIME = 59;
      int result = 1;
      result = result * PRIME + super.hashCode();
      return result;
    }

    public String toString() {
      return
          "com.impinj.itemsense.client.coordinator.readerhealth.ReaderStatus.ConnectionStatus(super="
              + super.toString() + ")";
    }
  }

  public static class ThroughputStatus extends GenericStatus {

    public ThroughputStatus(StatusLevel status, String code) {
      super(status, code);
    }

    public ThroughputStatus() {}

    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (!(o instanceof ThroughputStatus)) {
        return false;
      }
      final ThroughputStatus other = (ThroughputStatus) o;
      return super.equals(o);
    }

    public int hashCode() {
      final int PRIME = 59;
      int result = 1;
      result = result * PRIME + super.hashCode();
      return result;
    }

    public String toString() {
      return
          "com.impinj.itemsense.client.coordinator.readerhealth.ReaderStatus.ThroughputStatus(super="
              + super.toString() + ")";
    }
  }

  public static class ClockSyncStatus extends GenericStatus {

    private Integer skewMilliseconds;

    public ClockSyncStatus(StatusLevel status, String code, Integer skewMilliseconds) {
      super(status, code);
      this.skewMilliseconds = skewMilliseconds;
    }

    public ClockSyncStatus() {}

    public Integer getSkewMilliseconds() {return this.skewMilliseconds;}

    public void setSkewMilliseconds(Integer skewMilliseconds) {this.skewMilliseconds = skewMilliseconds; }

    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (!(o instanceof ClockSyncStatus)) {
        return false;
      }
      final ClockSyncStatus other = (ClockSyncStatus) o;
      if (!super.equals(o)) {
        return false;
      }
      final Object this$skewMilliseconds = this.getSkewMilliseconds();
      final Object other$skewMilliseconds = other.getSkewMilliseconds();
      return this$skewMilliseconds == null ? other$skewMilliseconds == null
                                           : this$skewMilliseconds.equals(other$skewMilliseconds);
    }

    public int hashCode() {
      final int PRIME = 59;
      int result = 1;
      result = result * PRIME + super.hashCode();
      final Object $skewMilliseconds = this.getSkewMilliseconds();
      result = result * PRIME + ($skewMilliseconds == null ? 43 : $skewMilliseconds.hashCode());
      return result;
    }

    public String toString() {
      return
          "com.impinj.itemsense.client.coordinator.readerhealth.ReaderStatus.ClockSyncStatus(super="
              + super.toString() + ", skewMilliseconds=" + this.getSkewMilliseconds() + ")";
    }
  }

  public static class HardwareStatus extends GenericStatus {

    private List<DeviceStatus> devices;

    public HardwareStatus(StatusLevel status, String code, List<DeviceStatus> deviceStatuses) {
      super(status, code);
      this.devices = deviceStatuses;
    }

    public HardwareStatus() {}

    public List<DeviceStatus> getDevices() {return this.devices;}

    public void setDevices(List<DeviceStatus> devices) {this.devices = devices; }

    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (!(o instanceof HardwareStatus)) {
        return false;
      }
      final HardwareStatus other = (HardwareStatus) o;
      if (!super.equals(o)) {
        return false;
      }
      final Object this$devices = this.getDevices();
      final Object other$devices = other.getDevices();
      return this$devices == null ? other$devices == null : this$devices.equals(other$devices);
    }

    public int hashCode() {
      final int PRIME = 59;
      int result = 1;
      result = result * PRIME + super.hashCode();
      final Object $devices = this.getDevices();
      result = result * PRIME + ($devices == null ? 43 : $devices.hashCode());
      return result;
    }

    public String toString() {
      return
          "com.impinj.itemsense.client.coordinator.readerhealth.ReaderStatus.HardwareStatus(super="
              + super.toString() + ", devices=" + this.getDevices() + ")";
    }

    public static class DeviceStatus {

      private String device;
      private String code;

      @java.beans.ConstructorProperties({"device", "code"})
      public DeviceStatus(String device, String code) {
        this.device = device;
        this.code = code;
      }

      public DeviceStatus() {}

      public String getDevice() {return this.device;}

      public String getCode() {return this.code;}

      public void setDevice(String device) {this.device = device; }

      public void setCode(String code) {this.code = code; }

      public boolean equals(Object o) {
        if (o == this) {
          return true;
        }
        if (!(o instanceof DeviceStatus)) {
          return false;
        }
        final DeviceStatus other = (DeviceStatus) o;
        final Object this$device = this.getDevice();
        final Object other$device = other.getDevice();
        if (this$device == null ? other$device != null : !this$device.equals(other$device)) {
          return false;
        }
        final Object this$code = this.getCode();
        final Object other$code = other.getCode();
        return this$code == null ? other$code == null : this$code.equals(other$code);
      }

      public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $device = this.getDevice();
        result = result * PRIME + ($device == null ? 43 : $device.hashCode());
        final Object $code = this.getCode();
        result = result * PRIME + ($code == null ? 43 : $code.hashCode());
        return result;
      }

      public String toString() {
        return
            "com.impinj.itemsense.client.coordinator.readerhealth.ReaderStatus.HardwareStatus.DeviceStatus(device="
                + this.getDevice() + ", code=" + this.getCode() + ")";
      }
    }
  }

  public static class SoftwareStatus extends GenericStatus {

    public SoftwareStatus(StatusLevel status, String code) {
      super(status, code);
    }

    public SoftwareStatus() {}

    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (!(o instanceof SoftwareStatus)) {
        return false;
      }
      final SoftwareStatus other = (SoftwareStatus) o;
      return super.equals(o);
    }

    public int hashCode() {
      final int PRIME = 59;
      int result = 1;
      result = result * PRIME + super.hashCode();
      return result;
    }

    public String toString() {
      return
          "com.impinj.itemsense.client.coordinator.readerhealth.ReaderStatus.SoftwareStatus(super="
              + super.toString() + ")";
    }
  }

  public static class ReaderStatusBuilder {

    private String readerName;
    private ReaderState state;
    private ZonedDateTime lastCheckin;
    private ZonedDateTime lastReboot;
    private ReaderVersion version;
    private ConnectionStatus connectionStatus;
    private ThroughputStatus throughputStatus;
    private ClockSyncStatus clockSyncStatus;
    private HardwareStatus hardwareStatus;
    private SoftwareStatus softwareStatus;

    ReaderStatusBuilder() {}

    public ReaderStatus.ReaderStatusBuilder readerName(String readerName) {
      this.readerName = readerName;
      return this;
    }

    public ReaderStatus.ReaderStatusBuilder state(ReaderState state) {
      this.state = state;
      return this;
    }

    public ReaderStatus.ReaderStatusBuilder lastCheckin(ZonedDateTime lastCheckin) {
      this.lastCheckin = lastCheckin;
      return this;
    }

    public ReaderStatus.ReaderStatusBuilder lastReboot(ZonedDateTime lastReboot) {
      this.lastReboot = lastReboot;
      return this;
    }

    public ReaderStatus.ReaderStatusBuilder version(ReaderVersion version) {
      this.version = version;
      return this;
    }

    public ReaderStatus.ReaderStatusBuilder connectionStatus(ConnectionStatus connectionStatus) {
      this.connectionStatus = connectionStatus;
      return this;
    }

    public ReaderStatus.ReaderStatusBuilder throughputStatus(ThroughputStatus throughputStatus) {
      this.throughputStatus = throughputStatus;
      return this;
    }

    public ReaderStatus.ReaderStatusBuilder clockSyncStatus(ClockSyncStatus clockSyncStatus) {
      this.clockSyncStatus = clockSyncStatus;
      return this;
    }

    public ReaderStatus.ReaderStatusBuilder hardwareStatus(HardwareStatus hardwareStatus) {
      this.hardwareStatus = hardwareStatus;
      return this;
    }

    public ReaderStatus.ReaderStatusBuilder softwareStatus(SoftwareStatus softwareStatus) {
      this.softwareStatus = softwareStatus;
      return this;
    }

    public ReaderStatus build() {
      return new ReaderStatus(
          readerName,
          state,
          lastCheckin,
          lastReboot,
          version,
          connectionStatus,
          throughputStatus,
          clockSyncStatus,
          hardwareStatus,
          softwareStatus);
    }

    public String toString() {
      return
          "com.impinj.itemsense.client.coordinator.readerhealth.ReaderStatus.ReaderStatusBuilder(readerName="
              + this.readerName + ", state=" + this.state + ", lastCheckin=" + this.lastCheckin
              + ", lastReboot=" + this.lastReboot + ", version=" + this.version
              + ", connectionStatus=" + this.connectionStatus + ", throughputStatus="
              + this.throughputStatus + ", clockSyncStatus=" + this.clockSyncStatus
              + ", hardwareStatus=" + this.hardwareStatus + ", softwareStatus="
              + this.softwareStatus
              + ")";
    }
  }
}
