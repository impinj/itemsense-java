package com.impinj.itemsense.client.coordinator.softwareversions;

import com.impinj.itemsense.client.coordinator.softwareupgrades.VersionIdentifier;

public class VersionInfo {

  private VersionIdentifier versionIdentifier;
  private String imageName;
  private String checksum;

  @java.beans.ConstructorProperties({"versionIdentifier", "imageName", "checksum"})
  public VersionInfo(VersionIdentifier versionIdentifier, String imageName, String checksum) {
    this.versionIdentifier = versionIdentifier;
    this.imageName = imageName;
    this.checksum = checksum;
  }

  public VersionInfo() {}

  public static VersionInfoBuilder builder() {return new VersionInfoBuilder();}

  public VersionIdentifier getVersionIdentifier() {return this.versionIdentifier;}

  public String getImageName() {return this.imageName;}

  public String getChecksum() {return this.checksum;}

  public void setVersionIdentifier(VersionIdentifier versionIdentifier) {this.versionIdentifier = versionIdentifier; }

  public void setImageName(String imageName) {this.imageName = imageName; }

  public void setChecksum(String checksum) {this.checksum = checksum; }

  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (!(o instanceof VersionInfo)) {
      return false;
    }
    final VersionInfo other = (VersionInfo) o;
    final Object this$versionIdentifier = this.getVersionIdentifier();
    final Object other$versionIdentifier = other.getVersionIdentifier();
    if (this$versionIdentifier == null ? other$versionIdentifier != null
                                       : !this$versionIdentifier.equals(other$versionIdentifier)) {
      return false;
    }
    final Object this$imageName = this.getImageName();
    final Object other$imageName = other.getImageName();
    if (this$imageName == null ? other$imageName != null
                               : !this$imageName.equals(other$imageName)) {
      return false;
    }
    final Object this$checksum = this.getChecksum();
    final Object other$checksum = other.getChecksum();
    return this$checksum == null ? other$checksum == null : this$checksum.equals(other$checksum);
  }

  public int hashCode() {
    final int PRIME = 59;
    int result = 1;
    final Object $versionIdentifier = this.getVersionIdentifier();
    result = result * PRIME + ($versionIdentifier == null ? 43 : $versionIdentifier.hashCode());
    final Object $imageName = this.getImageName();
    result = result * PRIME + ($imageName == null ? 43 : $imageName.hashCode());
    final Object $checksum = this.getChecksum();
    result = result * PRIME + ($checksum == null ? 43 : $checksum.hashCode());
    return result;
  }

  public String toString() {
    return "com.impinj.itemsense.client.coordinator.softwareversions.VersionInfo(versionIdentifier="
        + this.getVersionIdentifier() + ", imageName=" + this.getImageName() + ", checksum=" + this
        .getChecksum() + ")";
  }

  public static class VersionInfoBuilder {

    private VersionIdentifier versionIdentifier;
    private String imageName;
    private String checksum;

    VersionInfoBuilder() {}

    public VersionInfo.VersionInfoBuilder versionIdentifier(VersionIdentifier versionIdentifier) {
      this.versionIdentifier = versionIdentifier;
      return this;
    }

    public VersionInfo.VersionInfoBuilder imageName(String imageName) {
      this.imageName = imageName;
      return this;
    }

    public VersionInfo.VersionInfoBuilder checksum(String checksum) {
      this.checksum = checksum;
      return this;
    }

    public VersionInfo build() {
      return new VersionInfo(versionIdentifier, imageName, checksum);
    }

    public String toString() {
      return
          "com.impinj.itemsense.client.coordinator.softwareversions.VersionInfo.VersionInfoBuilder(versionIdentifier="
              + this.versionIdentifier + ", imageName=" + this.imageName + ", checksum="
              + this.checksum + ")";
    }
  }
}
