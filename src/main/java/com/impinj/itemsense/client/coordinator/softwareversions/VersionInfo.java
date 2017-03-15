package com.impinj.itemsense.client.coordinator.softwareversions;

import com.impinj.itemsense.client.coordinator.softwareupgrades.VersionIdentifier;
import lombok.Data;

@Data
public class VersionInfo {

  private VersionIdentifier versionIdentifier;
  private String imageName;
  private String checksum;
}
