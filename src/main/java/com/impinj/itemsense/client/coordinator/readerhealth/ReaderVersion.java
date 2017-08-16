package com.impinj.itemsense.client.coordinator.readerhealth;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

public class ReaderVersion {

  @JsonProperty("App")
  @SerializedName("App")
  private String app;

  @JsonProperty("Firmware")
  @SerializedName("Firmware")
  private String firmware;

  @java.beans.ConstructorProperties({"app", "firmware"})
  public ReaderVersion(String app, String firmware) {
    this.app = app;
    this.firmware = firmware;
  }

  public String getApp() {return this.app;}

  public String getFirmware() {return this.firmware;}

  public void setApp(String app) {this.app = app; }

  public void setFirmware(String firmware) {this.firmware = firmware; }

  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (!(o instanceof ReaderVersion)) {
      return false;
    }
    final ReaderVersion other = (ReaderVersion) o;
    final Object this$app = this.getApp();
    final Object other$app = other.getApp();
    if (this$app == null ? other$app != null : !this$app.equals(other$app)) {
      return false;
    }
    final Object this$firmware = this.getFirmware();
    final Object other$firmware = other.getFirmware();
    return this$firmware == null ? other$firmware == null : this$firmware.equals(other$firmware);
  }

  public int hashCode() {
    final int PRIME = 59;
    int result = 1;
    final Object $app = this.getApp();
    result = result * PRIME + ($app == null ? 43 : $app.hashCode());
    final Object $firmware = this.getFirmware();
    result = result * PRIME + ($firmware == null ? 43 : $firmware.hashCode());
    return result;
  }

  public String toString() {
    return "com.impinj.itemsense.client.coordinator.readerhealth.ReaderVersion(app=" + this.getApp()
        + ", firmware=" + this.getFirmware() + ")";
  }
}
