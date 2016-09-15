/**
 * IMPINJ CONFIDENTIAL AND PROPRIETARY
 * <p>
 * This source code is the sole property of Impinj, Inc. Reproduction or utilization of this source
 * code in whole or in part is forbidden without the prior written consent of Impinj, Inc.
 * <p>
 * (c) Copyright Impinj, Inc. 2015. All rights reserved.
 */
package com.impinj.itemsense.client.coordinator.job;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Job {
    private String recipeName;
    private String facility;
    private String startDelay;
    private int durationSeconds;
    private boolean playbackLoggingEnabled;
    private boolean presenceLoggingEnabled;
    private boolean reportToDatabaseEnabled;
    private boolean reportToMessageQueueEnabled;
    private boolean reportToFileEnabled;
}

