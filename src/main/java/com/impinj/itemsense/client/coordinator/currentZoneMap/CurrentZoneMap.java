package com.impinj.itemsense.client.coordinator.currentZoneMap;

/**
 * Created by jcombopi on 1/25/16.
 */

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class CurrentZoneMap {
    private String name;
    private String status;
}
