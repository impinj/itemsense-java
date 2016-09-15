package com.impinj.itemsense.client.coordinator.readerconfiguration;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)

public class Filter {
    private int memoryBank;
    private int pointer;
    private String tagMask;
}
