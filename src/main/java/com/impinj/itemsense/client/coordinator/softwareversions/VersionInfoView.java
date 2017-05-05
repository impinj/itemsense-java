package com.impinj.itemsense.client.coordinator.softwareversions;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VersionInfoView {

  VersionInfo versionInfo;
  String description;
  LocalDateTime created;
  LocalDateTime updated;
  String updateComment;
  int recordVersionNumber;
}
