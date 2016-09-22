package com.impinj.itemsense.client.coordinator.readerhealth;

public enum ReaderState {
    AWAITING_AGENT,
    IDLE,
    RUNNING_JOB,
    UPDATING_FIRMWARE,
    NOT_RESPONDING,
    ERROR
}
