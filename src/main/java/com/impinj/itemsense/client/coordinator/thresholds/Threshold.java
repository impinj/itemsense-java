package com.impinj.itemsense.client.coordinator.thresholds;

import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Threshold {

  private Integer id;
  private String name;
  private String facility;
  private ThresholdReaderArrangement readerArrangement;
  private Map<String, ThresholdReaderConfiguration> readers;
}