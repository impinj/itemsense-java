package com.impinj.itemsense.client.coordinator.settings.snmp;

public class SnmpUserPrivAuthConfiguration extends SnmpAuthConfiguration {

  private String engineId = "ITEMSENSE";
  private String userName;
  private String authenticationKey;
  private String privacyKey;

  public SnmpUserPrivAuthConfiguration(String engineId, String userName, String authenticationKey,
                                       String privacyKey) {

    super(AuthType.V3_USER_PRIV);

    this.engineId = engineId;
    this.userName = userName;
    this.authenticationKey = authenticationKey;
    this.privacyKey = privacyKey;
  }

  public SnmpUserPrivAuthConfiguration() {}

  public static SnmpUserPrivAuthConfigurationBuilder builder() {return new SnmpUserPrivAuthConfigurationBuilder();}

  public String getEngineId() {return this.engineId;}

  public String getUserName() {return this.userName;}

  public String getAuthenticationKey() {return this.authenticationKey;}

  public String getPrivacyKey() {return this.privacyKey;}

  public void setEngineId(String engineId) {this.engineId = engineId; }

  public void setUserName(String userName) {this.userName = userName; }

  public void setAuthenticationKey(String authenticationKey) {this.authenticationKey = authenticationKey; }

  public void setPrivacyKey(String privacyKey) {this.privacyKey = privacyKey; }

  public String toString() {
    return
        "com.impinj.itemsense.client.coordinator.settings.snmp.SnmpUserPrivAuthConfiguration(engineId="
            + this.getEngineId() + ", userName=" + this.getUserName() + ", authenticationKey="
            + this.getAuthenticationKey() + ", privacyKey=" + this.getPrivacyKey() + ")";
  }

  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (!(o instanceof SnmpUserPrivAuthConfiguration)) {
      return false;
    }
    final SnmpUserPrivAuthConfiguration other = (SnmpUserPrivAuthConfiguration) o;
    if (!super.equals(o)) {
      return false;
    }
    final Object this$engineId = this.getEngineId();
    final Object other$engineId = other.getEngineId();
    if (this$engineId == null ? other$engineId != null : !this$engineId.equals(other$engineId)) {
      return false;
    }
    final Object this$userName = this.getUserName();
    final Object other$userName = other.getUserName();
    if (this$userName == null ? other$userName != null : !this$userName.equals(other$userName)) {
      return false;
    }
    final Object this$authenticationKey = this.getAuthenticationKey();
    final Object other$authenticationKey = other.getAuthenticationKey();
    if (this$authenticationKey == null ? other$authenticationKey != null
                                       : !this$authenticationKey.equals(other$authenticationKey)) {
      return false;
    }
    final Object this$privacyKey = this.getPrivacyKey();
    final Object other$privacyKey = other.getPrivacyKey();
    return this$privacyKey == null ? other$privacyKey == null : this$privacyKey.equals(
        other$privacyKey);
  }

  public int hashCode() {
    final int PRIME = 59;
    int result = 1;
    result = result * PRIME + super.hashCode();
    final Object $engineId = this.getEngineId();
    result = result * PRIME + ($engineId == null ? 43 : $engineId.hashCode());
    final Object $userName = this.getUserName();
    result = result * PRIME + ($userName == null ? 43 : $userName.hashCode());
    final Object $authenticationKey = this.getAuthenticationKey();
    result = result * PRIME + ($authenticationKey == null ? 43 : $authenticationKey.hashCode());
    final Object $privacyKey = this.getPrivacyKey();
    result = result * PRIME + ($privacyKey == null ? 43 : $privacyKey.hashCode());
    return result;
  }

  public static class SnmpUserPrivAuthConfigurationBuilder {

    private String engineId;
    private String userName;
    private String authenticationKey;
    private String privacyKey;

    SnmpUserPrivAuthConfigurationBuilder() {}

    public SnmpUserPrivAuthConfiguration.SnmpUserPrivAuthConfigurationBuilder engineId(String engineId) {
      this.engineId = engineId;
      return this;
    }

    public SnmpUserPrivAuthConfiguration.SnmpUserPrivAuthConfigurationBuilder userName(String userName) {
      this.userName = userName;
      return this;
    }

    public SnmpUserPrivAuthConfiguration.SnmpUserPrivAuthConfigurationBuilder authenticationKey(
        String authenticationKey) {
      this.authenticationKey = authenticationKey;
      return this;
    }

    public SnmpUserPrivAuthConfiguration.SnmpUserPrivAuthConfigurationBuilder privacyKey(String privacyKey) {
      this.privacyKey = privacyKey;
      return this;
    }

    public SnmpUserPrivAuthConfiguration build() {
      return new SnmpUserPrivAuthConfiguration(engineId, userName, authenticationKey, privacyKey);
    }

    public String toString() {
      return
          "com.impinj.itemsense.client.coordinator.settings.snmp.SnmpUserPrivAuthConfiguration.SnmpUserPrivAuthConfigurationBuilder(engineId="
              + this.engineId + ", userName=" + this.userName + ", authenticationKey="
              + this.authenticationKey + ", privacyKey=" + this.privacyKey + ")";
    }
  }
}
