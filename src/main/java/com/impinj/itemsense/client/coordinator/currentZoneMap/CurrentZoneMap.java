package com.impinj.itemsense.client.coordinator.currentZoneMap;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CurrentZoneMap {

  private String name;
  private String status;

  @java.beans.ConstructorProperties({"name", "status"})
  public CurrentZoneMap(String name, String status) {
    this.name = name;
    this.status = status;
  }

  public CurrentZoneMap() {}

  public static CurrentZoneMapBuilder builder() {return new CurrentZoneMapBuilder();}

  public String getName() {return this.name;}

  public String getStatus() {return this.status;}

  public void setName(String name) {this.name = name; }

  public void setStatus(String status) {this.status = status; }

  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (!(o instanceof CurrentZoneMap)) {
      return false;
    }
    final CurrentZoneMap other = (CurrentZoneMap) o;
    final Object this$name = this.getName();
    final Object other$name = other.getName();
    if (this$name == null ? other$name != null : !this$name.equals(other$name)) {
      return false;
    }
    final Object this$status = this.getStatus();
    final Object other$status = other.getStatus();
    return this$status == null ? other$status == null : this$status.equals(other$status);
  }

  public int hashCode() {
    final int PRIME = 59;
    int result = 1;
    final Object $name = this.getName();
    result = result * PRIME + ($name == null ? 43 : $name.hashCode());
    final Object $status = this.getStatus();
    result = result * PRIME + ($status == null ? 43 : $status.hashCode());
    return result;
  }

  public String toString() {
    return "com.impinj.itemsense.client.coordinator.currentZoneMap.CurrentZoneMap(name=" + this
        .getName() + ", status=" + this.getStatus() + ")";
  }

  public static class CurrentZoneMapBuilder {

    private String name;
    private String status;

    CurrentZoneMapBuilder() {}

    public CurrentZoneMap.CurrentZoneMapBuilder name(String name) {
      this.name = name;
      return this;
    }

    public CurrentZoneMap.CurrentZoneMapBuilder status(String status) {
      this.status = status;
      return this;
    }

    public CurrentZoneMap build() {
      return new CurrentZoneMap(name, status);
    }

    public String toString() {
      return
          "com.impinj.itemsense.client.coordinator.currentZoneMap.CurrentZoneMap.CurrentZoneMapBuilder(name="
              + this.name + ", status=" + this.status + ")";
    }
  }
}
