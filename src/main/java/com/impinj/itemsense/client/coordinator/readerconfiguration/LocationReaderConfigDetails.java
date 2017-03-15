package com.impinj.itemsense.client.coordinator.readerconfiguration;

import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class LocationReaderConfigDetails extends ReaderBasicConfigDetails {

  private List<Integer> disabledAntennas;
}
