package com.impinj.itemsense.client.coordinator.readerconfiguration;

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
public class ChannelConfig {
    private int channelIndex;
    private int[] txFrequenciesInMhz;

}
