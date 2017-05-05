package com.impinj.itemsense.client.coordinator.softwareupgrades;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VersionIdentifier {

  private String version;
  private ImageType imageType;
}
