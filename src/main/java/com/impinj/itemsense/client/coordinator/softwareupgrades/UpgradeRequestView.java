package com.impinj.itemsense.client.coordinator.softwareupgrades;

import java.time.ZonedDateTime;
import lombok.Data;

@Data
public class UpgradeRequestView {

  private String id;
  private UpgradeRequest upgradeRequest;
  private ZonedDateTime created;
  private ZonedDateTime updated;
  private int numDevices;
  private boolean cancelled;
  private int numFailures;
}
