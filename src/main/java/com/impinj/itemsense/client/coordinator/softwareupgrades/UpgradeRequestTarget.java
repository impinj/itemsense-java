package com.impinj.itemsense.client.coordinator.softwareupgrades;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Set;

@Data
@AllArgsConstructor
public class UpgradeRequestTarget {
  TargetType type;
  Set<String> values;
}
