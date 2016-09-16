package com.impinj.itemsense.client.coordinator.readerhealth;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Map;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
public class ReaderStatus {

    private String readerId;

    private ReaderState state;

    private ZonedDateTime lastCheckin;

    private ZonedDateTime lastReboot;

    private Map<String, String> version;

    private ConnectionStatus connectionStatus;

    private ThroughputStatus throughputStatus;

    private ClockSyncStatus clockSyncStatus;

    private HardwareStatus hardwareStatus;

    private SoftwareStatus softwareStatus;

    public static class GenericStatus {
        private StatusLevel status;
        private String code;
    }

    public static class ConnectionStatus extends GenericStatus {
    }

    public static class ThroughputStatus extends GenericStatus {
    }

    public static class ClockSyncStatus extends GenericStatus {
        private Integer skewMilliseconds;
    }

    public static class HardwareStatus extends GenericStatus {
        private List<DeviceStatus> devices;
    }

    // this does not extend GenericStatus, since it doesn't have its own status, just a code
    // (because it's a sub-object of HardwareStatus)
    public static class DeviceStatus {
        private String device;
        private String code;
    }

    public static class SoftwareStatus extends GenericStatus {
    }
}
