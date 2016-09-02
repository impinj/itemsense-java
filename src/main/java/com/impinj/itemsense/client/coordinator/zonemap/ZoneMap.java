package com.impinj.itemsense.client.coordinator.zonemap;



import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ZoneMap {
    private String name;
    private String facility;
    private Zone[] zones;
}
