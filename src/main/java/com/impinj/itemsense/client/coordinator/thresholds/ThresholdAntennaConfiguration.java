package com.impinj.itemsense.client.coordinator.thresholds;

import com.impinj.itemsense.client.coordinator.readerdefintion.ReaderType;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ThresholdAntennaConfiguration {

  private Integer id;
  private String name;
  private ThresholdSide side;
  private ReaderType readerType;
  private ThresholdReaderArrangement readerArrangement;
  private List<ThresholdAntennaConfigurationAntenna> in;
  private List<ThresholdAntennaConfigurationAntenna> out;
  private List<ThresholdAntennaConfigurationAntenna> ignored;
}
