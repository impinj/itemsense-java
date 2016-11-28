/*
 * IMPINJ CONFIDENTIAL AND PROPRIETARY
 *
 * This source code is the sole property of Impinj, Inc. Reproduction or
 * utilization of this source code in whole or in part is forbidden without
 * the prior written consent of Impinj, Inc.
 *
 * (c) Copyright Impinj, Inc. 2016. All rights reserved.
 */

package com.impinj.itemsense.client.coordinator.settings.snmp;

import lombok.Data;

@Data
public class SnmpConfiguration {
    private SnmpAuthConfiguration authConfig;
    private SnmpTrapTargetConfiguration trapTargetConfig;
}
