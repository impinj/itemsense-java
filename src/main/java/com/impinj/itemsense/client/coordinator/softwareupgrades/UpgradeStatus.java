package com.impinj.itemsense.client.coordinator.softwareupgrades;

import java.util.List;
import lombok.Data;

@Data
public class UpgradeStatus {

  private String id;
  private VersionIdentifier version;
  private UpgradeState status;
  private UpgradeRequestTarget target;
  private UpgradeStatusDetails details;
  private long elapsedTimeSeconds;
  private String lastUpdatedTime;

  @Data
  static public class UpgradeStatusDetails {

    private List<DeviceStatus> readers;
  }
}
