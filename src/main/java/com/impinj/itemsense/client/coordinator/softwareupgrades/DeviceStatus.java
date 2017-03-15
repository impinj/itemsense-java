package com.impinj.itemsense.client.coordinator.softwareupgrades;

import lombok.Data;

@Data
public class DeviceStatus {

  private String name; // readerName
  private VersionIdentifier previousVersion;
  private UpgradeState status;
  private long elapsedTimeSeconds;
  private String lastUpdatedTime;
}
