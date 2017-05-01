package com.impinj.itemsense.client.coordinator.settings.snmp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class SnmpConfiguration {

  private SnmpAuthConfiguration authConfig;
  private SnmpTrapTargetConfiguration trapTargetConfig;
}
