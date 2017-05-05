package com.impinj.itemsense.client.coordinator.settings.snmp;

import java.time.Duration;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SnmpTrapTargetConfiguration {

  private String host;
  private Integer port = 162;
  private Duration timeout;
  private Integer retries = 2;
  private MessageType messageType = MessageType.TRAP;

  public enum MessageType {TRAP, INFORM}
}
