package com.impinj.itemsense.client.coordinator.zonemap;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ZoneMap {

  private String name;
  private String facility;
  private Zone[] zones;

  @java.beans.ConstructorProperties({"name", "facility", "zones"})
  public ZoneMap(String name, String facility, Zone[] zones) {
    this.name = name;
    this.facility = facility;
    this.zones = zones;
  }

  public ZoneMap() {}

  public static ZoneMapBuilder builder() {return new ZoneMapBuilder();}

  public String getName() {return this.name;}

  public String getFacility() {return this.facility;}

  public Zone[] getZones() {return this.zones;}

  public void setName(String name) {this.name = name; }

  public void setFacility(String facility) {this.facility = facility; }

  public void setZones(Zone[] zones) {this.zones = zones; }

  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (!(o instanceof ZoneMap)) {
      return false;
    }
    final ZoneMap other = (ZoneMap) o;
    final Object this$name = this.getName();
    final Object other$name = other.getName();
    if (this$name == null ? other$name != null : !this$name.equals(other$name)) {
      return false;
    }
    final Object this$facility = this.getFacility();
    final Object other$facility = other.getFacility();
    if (this$facility == null ? other$facility != null : !this$facility.equals(other$facility)) {
      return false;
    }
    return java.util.Arrays.deepEquals(this.getZones(), other.getZones());
  }

  public int hashCode() {
    final int PRIME = 59;
    int result = 1;
    final Object $name = this.getName();
    result = result * PRIME + ($name == null ? 43 : $name.hashCode());
    final Object $facility = this.getFacility();
    result = result * PRIME + ($facility == null ? 43 : $facility.hashCode());
    result = result * PRIME + java.util.Arrays.deepHashCode(this.getZones());
    return result;
  }

  public String toString() {
    return "com.impinj.itemsense.client.coordinator.zonemap.ZoneMap(name=" + this.getName()
        + ", facility=" + this.getFacility() + ", zones=" + java.util.Arrays
        .deepToString(this.getZones()) + ")";
  }

  public static class ZoneMapBuilder {

    private String name;
    private String facility;
    private Zone[] zones;

    ZoneMapBuilder() {}

    public ZoneMap.ZoneMapBuilder name(String name) {
      this.name = name;
      return this;
    }

    public ZoneMap.ZoneMapBuilder facility(String facility) {
      this.facility = facility;
      return this;
    }

    public ZoneMap.ZoneMapBuilder zones(Zone[] zones) {
      this.zones = zones;
      return this;
    }

    public ZoneMap build() {
      return new ZoneMap(name, facility, zones);
    }

    public String toString() {
      return "com.impinj.itemsense.client.coordinator.zonemap.ZoneMap.ZoneMapBuilder(name="
          + this.name + ", facility=" + this.facility + ", zones=" + java.util.Arrays.deepToString(
          this.zones) + ")";
    }
  }
}
