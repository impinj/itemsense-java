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

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import lombok.Data;

@Data
@JsonTypeInfo(use=JsonTypeInfo.Id.NAME,
        include=JsonTypeInfo.As.EXISTING_PROPERTY, property="type", visible = true)
@JsonSubTypes({
        @JsonSubTypes.Type(value=SnmpCommunityAuthConfiguration.class, name="V2_COMMUNITY"),
        @JsonSubTypes.Type(value=SnmpUserPrivAuthConfiguration.class, name="V3_USER_PRIV")
})
public class SnmpAuthConfiguration {
    public enum AuthType { V2_COMMUNITY, V3_USER_PRIV }
    private AuthType type;
}
