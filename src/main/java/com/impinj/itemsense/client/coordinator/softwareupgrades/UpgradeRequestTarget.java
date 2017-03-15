package com.impinj.itemsense.client.coordinator.softwareupgrades;

import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UpgradeRequestTarget {

  TargetType type;
  Set<String> values;
}
