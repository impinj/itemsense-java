/*
 * IMPINJ CONFIDENTIAL AND PROPRIETARY
 *
 * This source code is the sole property of Impinj, Inc. Reproduction or
 * utilization of this source code in whole or in part is forbidden without
 * the prior written consent of Impinj, Inc.
 *
 * (c) Copyright Impinj, Inc. 2016. All rights reserved.
 */

package com.impinj.itemsense.client.coordinator.readerconfiguration;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
public class LocationReaderConfigDetails extends ReaderConfigurationDetails {
    private ReaderMode readerMode;
    private Integer session;
    private Filter filter;
}
