package com.impinj.itemsense.client.coordinator.settings.snmp;

import lombok.Data;

@Data
public class SnmpConfiguration {

  private SnmpAuthConfiguration authConfig;
  private SnmpTrapTargetConfiguration trapTargetConfig;
}
