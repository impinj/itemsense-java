package com.impinj.itemsense.client.coordinator.zonemap;


public class Zone {

  private String name;
  private String floor;
  private Point[] points;

  @java.beans.ConstructorProperties({"name", "floor", "points"})
  public Zone(String name, String floor, Point[] points) {
    this.name = name;
    this.floor = floor;
    this.points = points;
  }

  public Zone() {}

  public static ZoneBuilder builder() {return new ZoneBuilder();}

  public String getName() {return this.name;}

  public String getFloor() {return this.floor;}

  public Point[] getPoints() {return this.points;}

  public void setName(String name) {this.name = name; }

  public void setFloor(String floor) {this.floor = floor; }

  public void setPoints(Point[] points) {this.points = points; }

  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (!(o instanceof Zone)) {
      return false;
    }
    final Zone other = (Zone) o;
    final Object this$name = this.getName();
    final Object other$name = other.getName();
    if (this$name == null ? other$name != null : !this$name.equals(other$name)) {
      return false;
    }
    final Object this$floor = this.getFloor();
    final Object other$floor = other.getFloor();
    if (this$floor == null ? other$floor != null : !this$floor.equals(other$floor)) {
      return false;
    }
    return java.util.Arrays.deepEquals(this.getPoints(), other.getPoints());
  }

  public int hashCode() {
    final int PRIME = 59;
    int result = 1;
    final Object $name = this.getName();
    result = result * PRIME + ($name == null ? 43 : $name.hashCode());
    final Object $floor = this.getFloor();
    result = result * PRIME + ($floor == null ? 43 : $floor.hashCode());
    result = result * PRIME + java.util.Arrays.deepHashCode(this.getPoints());
    return result;
  }

  public String toString() {
    return "com.impinj.itemsense.client.coordinator.zonemap.Zone(name=" + this.getName()
        + ", floor=" + this.getFloor() + ", points=" + java.util.Arrays
        .deepToString(this.getPoints()) + ")";
  }

  public static class ZoneBuilder {

    private String name;
    private String floor;
    private Point[] points;

    ZoneBuilder() {}

    public Zone.ZoneBuilder name(String name) {
      this.name = name;
      return this;
    }

    public Zone.ZoneBuilder floor(String floor) {
      this.floor = floor;
      return this;
    }

    public Zone.ZoneBuilder points(Point[] points) {
      this.points = points;
      return this;
    }

    public Zone build() {
      return new Zone(name, floor, points);
    }

    public String toString() {
      return "com.impinj.itemsense.client.coordinator.zonemap.Zone.ZoneBuilder(name=" + this.name
          + ", floor=" + this.floor + ", points=" + java.util.Arrays.deepToString(this.points)
          + ")";
    }
  }
}

