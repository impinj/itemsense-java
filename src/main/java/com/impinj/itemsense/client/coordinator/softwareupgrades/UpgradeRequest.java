package com.impinj.itemsense.client.coordinator.softwareupgrades;

import java.util.Set;

import lombok.Data;

@Data
public class UpgradeRequest {
    private DeviceClassHierarchy readerGroupingType;
    private Set<String> groupingUnitIds;
    VersionIdentifier target;
    UpgradePolicy policy;

}
