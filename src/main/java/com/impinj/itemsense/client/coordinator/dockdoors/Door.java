package com.impinj.itemsense.client.coordinator.dockdoors;

import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Door {

  private Integer id;
  private String name;
  private String facility;
  private DockDoorReaderArrangement readerArrangement;
  private Map<String, DoorReaderConfiguration> readers;
}