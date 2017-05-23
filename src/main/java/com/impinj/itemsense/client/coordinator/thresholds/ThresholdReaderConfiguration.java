package com.impinj.itemsense.client.coordinator.thresholds;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ThresholdReaderConfiguration {

  private Integer antennaConfigurationId;
}
