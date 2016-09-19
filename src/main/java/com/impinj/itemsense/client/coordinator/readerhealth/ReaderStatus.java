package com.impinj.itemsense.client.coordinator.readerhealth;

import java.time.ZonedDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class ReaderStatus {

    private String readerId;

    private ReaderState state;

    private ZonedDateTime lastCheckin;

    private ZonedDateTime lastReboot;

    private ReaderVersion version;

    private ConnectionStatus connectionStatus;

    private ThroughputStatus throughputStatus;

    private ClockSyncStatus clockSyncStatus;

    private HardwareStatus hardwareStatus;

    private SoftwareStatus softwareStatus;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class GenericStatus {
        private StatusLevel status;
        private String code;
    }

    @Data
    @EqualsAndHashCode(callSuper = true)
    @ToString(callSuper = true)
    @NoArgsConstructor
    public static class ConnectionStatus extends GenericStatus {
        public ConnectionStatus(StatusLevel status, String code) {
            super(status, code);
        }
    }

    @Data
    @EqualsAndHashCode(callSuper = true)
    @ToString(callSuper = true)
    @NoArgsConstructor
    public static class ThroughputStatus extends GenericStatus {
        public ThroughputStatus(StatusLevel status, String code) {
            super(status, code);
        }
    }

    @Data
    @EqualsAndHashCode(callSuper = true)
    @ToString(callSuper = true)
    @NoArgsConstructor
    public static class ClockSyncStatus extends GenericStatus {
        private Integer skewMilliseconds;

        public ClockSyncStatus(StatusLevel status, String code, Integer skewMilliseconds) {
            super(status, code);
            this.skewMilliseconds = skewMilliseconds;
        }
    }

    @Data
    @EqualsAndHashCode(callSuper = true)
    @ToString(callSuper = true)
    @NoArgsConstructor
    public static class HardwareStatus extends GenericStatus {
        private List<DeviceStatus> devices;

        public HardwareStatus(StatusLevel status, String code, List<DeviceStatus> deviceStatuses) {
            super(status, code);
            this.devices = deviceStatuses;
        }

        @Data
        @AllArgsConstructor
        @NoArgsConstructor
        public static class DeviceStatus {
            private String device;
            private String code;
        }
    }

    @Data
    @EqualsAndHashCode(callSuper = true)
    @ToString(callSuper = true)
    @NoArgsConstructor
    public static class SoftwareStatus extends GenericStatus {
        public SoftwareStatus(StatusLevel status, String code) {
            super(status, code);
        }
    }
}
