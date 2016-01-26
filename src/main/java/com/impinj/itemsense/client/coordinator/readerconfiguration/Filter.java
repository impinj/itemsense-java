package com.impinj.itemsense.client.coordinator.readerconfiguration;

/**
 * Created by jcombopi on 1/25/16.
 */
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Filter {
    private int memoryBank;
    private int pointer;
    private String tagMask;
}
