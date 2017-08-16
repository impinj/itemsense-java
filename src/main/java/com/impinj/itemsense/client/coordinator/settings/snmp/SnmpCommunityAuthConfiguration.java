package com.impinj.itemsense.client.coordinator.settings.snmp;

public class SnmpCommunityAuthConfiguration extends SnmpAuthConfiguration {

  private String communityName;

  public SnmpCommunityAuthConfiguration(String communityName) {
    super(AuthType.V2_COMMUNITY);

    this.communityName = communityName;
  }

  public SnmpCommunityAuthConfiguration() {}

  public static SnmpCommunityAuthConfigurationBuilder builder() {return new SnmpCommunityAuthConfigurationBuilder();}

  public String getCommunityName() {return this.communityName;}

  public void setCommunityName(String communityName) {this.communityName = communityName; }

  public String toString() {
    return
        "com.impinj.itemsense.client.coordinator.settings.snmp.SnmpCommunityAuthConfiguration(communityName="
            + this.getCommunityName() + ")";
  }

  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (!(o instanceof SnmpCommunityAuthConfiguration)) {
      return false;
    }
    final SnmpCommunityAuthConfiguration other = (SnmpCommunityAuthConfiguration) o;
    if (!super.equals(o)) {
      return false;
    }
    final Object this$communityName = this.getCommunityName();
    final Object other$communityName = other.getCommunityName();
    return this$communityName == null ? other$communityName == null : this$communityName.equals(
        other$communityName);
  }

  public int hashCode() {
    final int PRIME = 59;
    int result = 1;
    result = result * PRIME + super.hashCode();
    final Object $communityName = this.getCommunityName();
    result = result * PRIME + ($communityName == null ? 43 : $communityName.hashCode());
    return result;
  }

  public static class SnmpCommunityAuthConfigurationBuilder {

    private String communityName;

    SnmpCommunityAuthConfigurationBuilder() {}

    public SnmpCommunityAuthConfiguration.SnmpCommunityAuthConfigurationBuilder communityName(String communityName) {
      this.communityName = communityName;
      return this;
    }

    public SnmpCommunityAuthConfiguration build() {
      return new SnmpCommunityAuthConfiguration(communityName);
    }

    public String toString() {
      return
          "com.impinj.itemsense.client.coordinator.settings.snmp.SnmpCommunityAuthConfiguration.SnmpCommunityAuthConfigurationBuilder(communityName="
              + this.communityName + ")";
    }
  }
}
