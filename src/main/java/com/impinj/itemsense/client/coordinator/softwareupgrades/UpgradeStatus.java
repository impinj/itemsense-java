package com.impinj.itemsense.client.coordinator.softwareupgrades;

import java.util.List;

import lombok.Data;

@Data
public class UpgradeStatus {
    private String id;
    private VersionIdentifier target;
    private UpgradeState status;
    private TargetType readerGroupingType;
    private List<String> groupingUnitIds;
    private UpgradeStatusDetails details;
    private long elapsedTimeSeconds;
    private String lastUpdatedTime;

    @Data
    static public class UpgradeStatusDetails {
        private List<DeviceStatus> readers;
    }
}
