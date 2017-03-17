package com.impinj.itemsense.client.coordinator.readerconfiguration;

import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class InventoryReaderConfigDetails extends ReaderBasicConfigDetails {

  private Boolean polarization;
  private List<Integer> antennas;
  private ChannelConfig channelConfig;
}
