package com.impinj.itemsense.client.coordinator.softwareversions;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class VersionInfoView {

  VersionInfo versionInfo;
  String description;
  LocalDateTime created;
  LocalDateTime updated;
  String updateComment;
  int recordVersionNumber;
}
