package com.impinj.itemsense.client.coordinator.settings.snmp;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class SnmpUserPrivAuthConfiguration extends SnmpAuthConfiguration {

  private String engineId = "ITEMSENSE";
  private String userName;
  private String authenticationKey;
  private String privacyKey;

  @Builder
  public SnmpUserPrivAuthConfiguration(String engineId, String userName, String authenticationKey,
                                       String privacyKey) {

    super(AuthType.V3_USER_PRIV);

    this.engineId = engineId;
    this.userName = userName;
    this.authenticationKey = authenticationKey;
    this.privacyKey = privacyKey;
  }
}
