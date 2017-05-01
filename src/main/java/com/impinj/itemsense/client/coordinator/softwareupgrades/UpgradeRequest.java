package com.impinj.itemsense.client.coordinator.softwareupgrades;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpgradeRequest {

  UpgradeRequestTarget target;
  VersionIdentifier versionIdentifier;
  UpgradePolicy policy;
}
