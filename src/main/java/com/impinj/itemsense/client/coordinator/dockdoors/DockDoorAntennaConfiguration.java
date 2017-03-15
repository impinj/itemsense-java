package com.impinj.itemsense.client.coordinator.dockdoors;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DockDoorAntennaConfiguration {

  private Integer id;
  private String name;
  private DockDoorSide side;
  private List<DockDoorAntennaConfigurationAntenna> in;
  private List<DockDoorAntennaConfigurationAntenna> out;
}
