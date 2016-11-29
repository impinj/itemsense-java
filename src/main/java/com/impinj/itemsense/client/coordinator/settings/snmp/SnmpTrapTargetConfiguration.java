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

import java.time.Duration;

import lombok.Data;

@Data
public class SnmpTrapTargetConfiguration {
    public enum MessageType { TRAP, INFORM }
    private String host;
    private Integer port = 162;
    private Duration timeout;
    private Integer retries = 2;
    private MessageType messageType = MessageType.TRAP;
}
