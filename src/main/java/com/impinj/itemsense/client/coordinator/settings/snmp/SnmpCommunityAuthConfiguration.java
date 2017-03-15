package com.impinj.itemsense.client.coordinator.settings.snmp;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class SnmpCommunityAuthConfiguration extends SnmpAuthConfiguration {

  private String communityName;

  public SnmpCommunityAuthConfiguration() {
    setType(AuthType.V2_COMMUNITY);
  }
}
