package com.impinj.itemsense.client.coordinator.softwareupgrades;

import lombok.Data;

@Data
public class UpgradeRequest {
    UpgradeRequestTarget target;
    VersionIdentifier versionIdentifier;
    UpgradePolicy policy;
}
