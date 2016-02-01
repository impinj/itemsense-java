package com.impinj.itemsense.client.coordinator.readerdefintion;

/**
 * Created by jcombopi on 1/25/16.
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReaderDefinition {
    private String name;
    private String address;
    private String facility;
    private String readerZone;
    private Map<Integer, String> antennaZones;
    private Placement placement;
    private ReaderType type;

}

