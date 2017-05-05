package com.impinj.itemsense.client.coordinator.softwareupgrades;

import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class UpgradeRequestTarget {

  TargetType type;
  Set<String> values;
}
