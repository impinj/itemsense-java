package com.impinj.itemsense.client.coordinator.facility;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Facility {

  private String name;

  @java.beans.ConstructorProperties({"name"})
  public Facility(String name) {
    this.name = name;
  }

  public Facility() {}

  public static FacilityBuilder builder() {return new FacilityBuilder();}

  public String getName() {return this.name;}

  public void setName(String name) {this.name = name; }

  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (!(o instanceof Facility)) {
      return false;
    }
    final Facility other = (Facility) o;
    final Object this$name = this.getName();
    final Object other$name = other.getName();
    return this$name == null ? other$name == null : this$name.equals(other$name);
  }

  public int hashCode() {
    final int PRIME = 59;
    int result = 1;
    final Object $name = this.getName();
    result = result * PRIME + ($name == null ? 43 : $name.hashCode());
    return result;
  }

  public String toString() {
    return "com.impinj.itemsense.client.coordinator.facility.Facility(name=" + this.getName() + ")";
  }

  public static class FacilityBuilder {

    private String name;

    FacilityBuilder() {}

    public Facility.FacilityBuilder name(String name) {
      this.name = name;
      return this;
    }

    public Facility build() {
      return new Facility(name);
    }

    public String toString() {
      return "com.impinj.itemsense.client.coordinator.facility.Facility.FacilityBuilder(name="
          + this.name + ")";
    }
  }
}
