package com.impinj.itemsense.client.coordinator.softwareversions;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class VersionInfoView {
    VersionInfo versionInfo;
    String description;
    Timestamp created;
    Timestamp updated;
    String updateComment;
    int recordVersionNumber;
}
