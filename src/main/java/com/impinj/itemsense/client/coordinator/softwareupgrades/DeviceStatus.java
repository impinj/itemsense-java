/**
 * IMPINJ CONFIDENTIAL AND PROPRIETARY
 *
 * This source code is the sole property of Impinj, Inc. Reproduction or
 * utilization of this source code in whole or in part is forbidden without
 * the prior written consent of Impinj, Inc.
 *
 * (c) Copyright Impinj, Inc. 2016. All rights reserved.
 */
package com.impinj.itemsense.client.coordinator.softwareupgrades;

import lombok.Data;

@Data
public class DeviceStatus {
    private String name; // readerName
    private VersionIdentifier previousVersion;
    private UpgradeState status;
    private long elapsedTimeSeconds;
    private String lastUpdatedTime;
}
