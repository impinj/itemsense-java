package com.impinj.itemsense.client.coordinator.settings.snmp;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Data;

@Data
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME,
    include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "type", visible = true)
@JsonSubTypes({
    @JsonSubTypes.Type(value = SnmpCommunityAuthConfiguration.class, name = "V2_COMMUNITY"),
    @JsonSubTypes.Type(value = SnmpUserPrivAuthConfiguration.class, name = "V3_USER_PRIV")
})
public class SnmpAuthConfiguration {

  private AuthType type;

  public enum AuthType {V2_COMMUNITY, V3_USER_PRIV}
}
