package com.impinj.itemsense.client.coordinator.softwareupgrades;

import com.impinj.itemsense.client.coordinator.readerdefintion.ReaderType;

import java.util.Set;

import lombok.Data;

@Data
public class UpgradePolicy {

    private Integer maxParallelReaders;
    private Set<ReaderType> allowedReaderTypes;
}
