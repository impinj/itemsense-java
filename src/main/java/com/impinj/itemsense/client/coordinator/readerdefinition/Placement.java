package com.impinj.itemsense.client.coordinator.readerdefinition;


public class Placement {

  private int x;
  private int y;
  private int z;
  private int yaw;
  private int pitch;
  private int roll;
  private String floor;

  @java.beans.ConstructorProperties({"x", "y", "z", "yaw", "pitch", "roll", "floor"})
  public Placement(int x, int y, int z, int yaw, int pitch, int roll, String floor) {
    this.x = x;
    this.y = y;
    this.z = z;
    this.yaw = yaw;
    this.pitch = pitch;
    this.roll = roll;
    this.floor = floor;
  }

  public Placement() {}

  public static PlacementBuilder builder() {return new PlacementBuilder();}

  public int getX() {return this.x;}

  public int getY() {return this.y;}

  public int getZ() {return this.z;}

  public int getYaw() {return this.yaw;}

  public int getPitch() {return this.pitch;}

  public int getRoll() {return this.roll;}

  public String getFloor() {return this.floor;}

  public void setX(int x) {this.x = x; }

  public void setY(int y) {this.y = y; }

  public void setZ(int z) {this.z = z; }

  public void setYaw(int yaw) {this.yaw = yaw; }

  public void setPitch(int pitch) {this.pitch = pitch; }

  public void setRoll(int roll) {this.roll = roll; }

  public void setFloor(String floor) {this.floor = floor; }

  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (!(o instanceof Placement)) {
      return false;
    }
    final Placement other = (Placement) o;
    if (this.getX() != other.getX()) {
      return false;
    }
    if (this.getY() != other.getY()) {
      return false;
    }
    if (this.getZ() != other.getZ()) {
      return false;
    }
    if (this.getYaw() != other.getYaw()) {
      return false;
    }
    if (this.getPitch() != other.getPitch()) {
      return false;
    }
    if (this.getRoll() != other.getRoll()) {
      return false;
    }
    final Object this$floor = this.getFloor();
    final Object other$floor = other.getFloor();
    return this$floor == null ? other$floor == null : this$floor.equals(other$floor);
  }

  public int hashCode() {
    final int PRIME = 59;
    int result = 1;
    result = result * PRIME + this.getX();
    result = result * PRIME + this.getY();
    result = result * PRIME + this.getZ();
    result = result * PRIME + this.getYaw();
    result = result * PRIME + this.getPitch();
    result = result * PRIME + this.getRoll();
    final Object $floor = this.getFloor();
    result = result * PRIME + ($floor == null ? 43 : $floor.hashCode());
    return result;
  }

  public String toString() {
    return "com.impinj.itemsense.client.coordinator.readerdefinition.Placement(x=" + this.getX()
        + ", y=" + this.getY() + ", z=" + this.getZ() + ", yaw=" + this.getYaw() + ", pitch=" + this
        .getPitch() + ", roll=" + this.getRoll() + ", floor=" + this.getFloor() + ")";
  }

  public static class PlacementBuilder {

    private int x;
    private int y;
    private int z;
    private int yaw;
    private int pitch;
    private int roll;
    private String floor;

    PlacementBuilder() {}

    public Placement.PlacementBuilder x(int x) {
      this.x = x;
      return this;
    }

    public Placement.PlacementBuilder y(int y) {
      this.y = y;
      return this;
    }

    public Placement.PlacementBuilder z(int z) {
      this.z = z;
      return this;
    }

    public Placement.PlacementBuilder yaw(int yaw) {
      this.yaw = yaw;
      return this;
    }

    public Placement.PlacementBuilder pitch(int pitch) {
      this.pitch = pitch;
      return this;
    }

    public Placement.PlacementBuilder roll(int roll) {
      this.roll = roll;
      return this;
    }

    public Placement.PlacementBuilder floor(String floor) {
      this.floor = floor;
      return this;
    }

    public Placement build() {
      return new Placement(x, y, z, yaw, pitch, roll, floor);
    }

    public String toString() {
      return "com.impinj.itemsense.client.coordinator.readerdefinition.Placement.PlacementBuilder(x="
          + this.x + ", y=" + this.y + ", z=" + this.z + ", yaw=" + this.yaw + ", pitch="
          + this.pitch
          + ", roll=" + this.roll + ", floor=" + this.floor + ")";
    }
  }
}
