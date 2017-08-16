package com.impinj.itemsense.client.coordinator.zonemap;

public class Point {

  private double x;
  private double y;
  private double z;

  @java.beans.ConstructorProperties({"x", "y", "z"})
  public Point(double x, double y, double z) {
    this.x = x;
    this.y = y;
    this.z = z;
  }

  public Point() {}

  public static PointBuilder builder() {return new PointBuilder();}

  public double getX() {return this.x;}

  public double getY() {return this.y;}

  public double getZ() {return this.z;}

  public void setX(double x) {this.x = x; }

  public void setY(double y) {this.y = y; }

  public void setZ(double z) {this.z = z; }

  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (!(o instanceof Point)) {
      return false;
    }
    final Point other = (Point) o;
    if (Double.compare(this.getX(), other.getX()) != 0) {
      return false;
    }
    if (Double.compare(this.getY(), other.getY()) != 0) {
      return false;
    }
    return Double.compare(this.getZ(), other.getZ()) == 0;
  }

  public int hashCode() {
    final int PRIME = 59;
    int result = 1;
    final long $x = Double.doubleToLongBits(this.getX());
    result = result * PRIME + (int) ($x >>> 32 ^ $x);
    final long $y = Double.doubleToLongBits(this.getY());
    result = result * PRIME + (int) ($y >>> 32 ^ $y);
    final long $z = Double.doubleToLongBits(this.getZ());
    result = result * PRIME + (int) ($z >>> 32 ^ $z);
    return result;
  }

  public String toString() {
    return "com.impinj.itemsense.client.coordinator.zonemap.Point(x=" + this.getX() + ", y=" + this
        .getY() + ", z=" + this.getZ() + ")";
  }

  public static class PointBuilder {

    private double x;
    private double y;
    private double z;

    PointBuilder() {}

    public Point.PointBuilder x(double x) {
      this.x = x;
      return this;
    }

    public Point.PointBuilder y(double y) {
      this.y = y;
      return this;
    }

    public Point.PointBuilder z(double z) {
      this.z = z;
      return this;
    }

    public Point build() {
      return new Point(x, y, z);
    }

    public String toString() {
      return "com.impinj.itemsense.client.coordinator.zonemap.Point.PointBuilder(x=" + this.x
          + ", y="
          + this.y + ", z=" + this.z + ")";
    }
  }
}
