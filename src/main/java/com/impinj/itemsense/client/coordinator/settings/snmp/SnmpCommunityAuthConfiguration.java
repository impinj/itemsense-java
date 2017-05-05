package com.impinj.itemsense.client.coordinator.settings.snmp;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class SnmpCommunityAuthConfiguration extends SnmpAuthConfiguration {

  private String communityName;

  @Builder
  public SnmpCommunityAuthConfiguration(String communityName) {
    super(AuthType.V2_COMMUNITY);

    this.communityName = communityName;
  }
}
