package com.impinj.itemsense.client.coordinator.softwareupgrades;

import lombok.Data;

@Data
public class VersionIdentifier {
    private String version;
    private ImageType imageType;
}
