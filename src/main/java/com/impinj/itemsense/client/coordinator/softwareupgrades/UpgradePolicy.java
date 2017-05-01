package com.impinj.itemsense.client.coordinator.softwareupgrades;

import com.impinj.itemsense.client.coordinator.readerdefintion.ReaderType;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpgradePolicy {

  private Integer maxParallelReaders;
  private Set<ReaderType> allowedReaderTypes;
}
