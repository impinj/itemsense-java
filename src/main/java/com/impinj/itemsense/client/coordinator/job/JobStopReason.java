package com.impinj.itemsense.client.coordinator.job;


public enum JobStopReason {
  JOB_COMPLETED,
  JOB_FAILED,
  USER_REQUESTED_GRACEFUL,
  USER_REQUESTED_ABRUPT,
  UNKNOWN
}
