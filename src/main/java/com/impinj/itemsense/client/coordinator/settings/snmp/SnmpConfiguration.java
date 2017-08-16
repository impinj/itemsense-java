package com.impinj.itemsense.client.coordinator.settings.snmp;

public class SnmpConfiguration {

  private SnmpAuthConfiguration authConfig;
  private SnmpTrapTargetConfiguration trapTargetConfig;

  @java.beans.ConstructorProperties({"authConfig", "trapTargetConfig"})
  public SnmpConfiguration(
      SnmpAuthConfiguration authConfig,
      SnmpTrapTargetConfiguration trapTargetConfig) {
    this.authConfig = authConfig;
    this.trapTargetConfig = trapTargetConfig;
  }

  public SnmpConfiguration() {}

  public static SnmpConfigurationBuilder builder() {return new SnmpConfigurationBuilder();}

  public SnmpAuthConfiguration getAuthConfig() {return this.authConfig;}

  public SnmpTrapTargetConfiguration getTrapTargetConfig() {return this.trapTargetConfig;}

  public void setAuthConfig(SnmpAuthConfiguration authConfig) {this.authConfig = authConfig; }

  public void setTrapTargetConfig(SnmpTrapTargetConfiguration trapTargetConfig) {this.trapTargetConfig = trapTargetConfig; }

  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (!(o instanceof SnmpConfiguration)) {
      return false;
    }
    final SnmpConfiguration other = (SnmpConfiguration) o;
    final Object this$authConfig = this.getAuthConfig();
    final Object other$authConfig = other.getAuthConfig();
    if (this$authConfig == null ? other$authConfig != null : !this$authConfig.equals(
        other$authConfig)) {
      return false;
    }
    final Object this$trapTargetConfig = this.getTrapTargetConfig();
    final Object other$trapTargetConfig = other.getTrapTargetConfig();
    return this$trapTargetConfig == null ? other$trapTargetConfig == null
                                         : this$trapTargetConfig.equals(other$trapTargetConfig);
  }

  public int hashCode() {
    final int PRIME = 59;
    int result = 1;
    final Object $authConfig = this.getAuthConfig();
    result = result * PRIME + ($authConfig == null ? 43 : $authConfig.hashCode());
    final Object $trapTargetConfig = this.getTrapTargetConfig();
    result = result * PRIME + ($trapTargetConfig == null ? 43 : $trapTargetConfig.hashCode());
    return result;
  }

  public String toString() {
    return "com.impinj.itemsense.client.coordinator.settings.snmp.SnmpConfiguration(authConfig="
        + this.getAuthConfig() + ", trapTargetConfig=" + this.getTrapTargetConfig() + ")";
  }

  public static class SnmpConfigurationBuilder {

    private SnmpAuthConfiguration authConfig;
    private SnmpTrapTargetConfiguration trapTargetConfig;

    SnmpConfigurationBuilder() {}

    public SnmpConfiguration.SnmpConfigurationBuilder authConfig(SnmpAuthConfiguration authConfig) {
      this.authConfig = authConfig;
      return this;
    }

    public SnmpConfiguration.SnmpConfigurationBuilder trapTargetConfig(SnmpTrapTargetConfiguration trapTargetConfig) {
      this.trapTargetConfig = trapTargetConfig;
      return this;
    }

    public SnmpConfiguration build() {
      return new SnmpConfiguration(authConfig, trapTargetConfig);
    }

    public String toString() {
      return
          "com.impinj.itemsense.client.coordinator.settings.snmp.SnmpConfiguration.SnmpConfigurationBuilder(authConfig="
              + this.authConfig + ", trapTargetConfig=" + this.trapTargetConfig + ")";
    }
  }
}
