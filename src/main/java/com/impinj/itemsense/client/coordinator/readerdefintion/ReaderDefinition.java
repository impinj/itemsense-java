package com.impinj.itemsense.client.coordinator.readerdefintion;



import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReaderDefinition {
    private String name;
    private String address;
    private String facility;
    private String readerZone;
    private Map<Integer, String> antennaZones;
    private Placement placement;
    private ReaderType type;

}

