package com.impinj.itemsense.client.coordinator.softwareupgrades;

import com.impinj.itemsense.client.coordinator.readerdefintion.ReaderType;

import java.util.Set;

import lombok.Data;

@Data
public class UpgradePolicy {

    private double ratioMaxOutstanding;
    private double ratioMaxFailures;
    private int staggerDelaySeconds;
    private UpgradeFailureAction failureAction;
    private Set<ReaderType> allowedReaderTypes;
}
