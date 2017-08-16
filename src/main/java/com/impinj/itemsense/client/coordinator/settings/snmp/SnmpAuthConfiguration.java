package com.impinj.itemsense.client.coordinator.settings.snmp;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME,
    include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "type", visible = true)
@JsonSubTypes({
    @JsonSubTypes.Type(value = SnmpCommunityAuthConfiguration.class, name = "V2_COMMUNITY"),
    @JsonSubTypes.Type(value = SnmpUserPrivAuthConfiguration.class, name = "V3_USER_PRIV")
})
public abstract class SnmpAuthConfiguration {

  private AuthType type;

  @java.beans.ConstructorProperties({"type"})
  public SnmpAuthConfiguration(AuthType type) {
    this.type = type;
  }

  public SnmpAuthConfiguration() {}

  public AuthType getType() {return this.type;}

  public void setType(AuthType type) {this.type = type; }

  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (!(o instanceof SnmpAuthConfiguration)) {
      return false;
    }
    final SnmpAuthConfiguration other = (SnmpAuthConfiguration) o;
    final Object this$type = this.getType();
    final Object other$type = other.getType();
    return this$type == null ? other$type == null : this$type.equals(other$type);
  }

  public int hashCode() {
    final int PRIME = 59;
    int result = 1;
    final Object $type = this.getType();
    result = result * PRIME + ($type == null ? 43 : $type.hashCode());
    return result;
  }

  public String toString() {
    return "com.impinj.itemsense.client.coordinator.settings.snmp.SnmpAuthConfiguration(type="
        + this.getType() + ")";
  }

  public enum AuthType {V2_COMMUNITY, V3_USER_PRIV}
}
