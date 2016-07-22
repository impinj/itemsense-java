/**
 * IMPINJ CONFIDENTIAL AND PROPRIETARY
 * <p>
 * This source code is the sole property of Impinj, Inc. Reproduction or utilization of this source
 * code in whole or in part is forbidden without the prior written consent of Impinj, Inc.
 * <p>
 * (c) Copyright Impinj, Inc. 2015. All rights reserved.
 */
package com.impinj.itemsense.client.coordinator.job;

/**
 * Represents the current status of a job
 *
 * @author Daniel Burton
 */
public enum JobStatus {
    WAITING,
    INITIALIZING,
    STARTING,
    RUNNING,
    STOPPING,
    STOPPED,
    UNKNOWN,
    @Deprecated FAILED,
    @Deprecated COMPLETE,
    @Deprecated REGISTERED,
    @Deprecated PUBLISHING_STATE,
    @Deprecated RUNNING_WITH_ERRORS,
    @Deprecated STOPPED_STOPPING,
    @Deprecated COMPLETE_STOPPING,
    @Deprecated COMPLETE_WITH_ERRORS,
}
