package com.impinj.itemsense.client.coordinator.job;

/**
 * Created by nkershaw on 7/11/16.
 */
public enum JobStopReason {
  JOB_COMPLETED,
  JOB_FAILED,
  USER_REQUESTED_GRACEFUL,
  USER_REQUESTED_ABRUPT
}
