package com.impinj.itemsense.client.coordinator.softwareupgrades;

public class VersionIdentifier {

  private String version;
  private ImageType imageType;

  @java.beans.ConstructorProperties({"version", "imageType"})
  public VersionIdentifier(String version, ImageType imageType) {
    this.version = version;
    this.imageType = imageType;
  }

  public VersionIdentifier() {}

  public static VersionIdentifierBuilder builder() {return new VersionIdentifierBuilder();}

  public String getVersion() {return this.version;}

  public ImageType getImageType() {return this.imageType;}

  public void setVersion(String version) {this.version = version; }

  public void setImageType(ImageType imageType) {this.imageType = imageType; }

  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (!(o instanceof VersionIdentifier)) {
      return false;
    }
    final VersionIdentifier other = (VersionIdentifier) o;
    final Object this$version = this.getVersion();
    final Object other$version = other.getVersion();
    if (this$version == null ? other$version != null : !this$version.equals(other$version)) {
      return false;
    }
    final Object this$imageType = this.getImageType();
    final Object other$imageType = other.getImageType();
    return this$imageType == null ? other$imageType == null
                                  : this$imageType.equals(other$imageType);
  }

  public int hashCode() {
    final int PRIME = 59;
    int result = 1;
    final Object $version = this.getVersion();
    result = result * PRIME + ($version == null ? 43 : $version.hashCode());
    final Object $imageType = this.getImageType();
    result = result * PRIME + ($imageType == null ? 43 : $imageType.hashCode());
    return result;
  }

  public String toString() {
    return "com.impinj.itemsense.client.coordinator.softwareupgrades.VersionIdentifier(version="
        + this.getVersion() + ", imageType=" + this.getImageType() + ")";
  }

  public static class VersionIdentifierBuilder {

    private String version;
    private ImageType imageType;

    VersionIdentifierBuilder() {}

    public VersionIdentifier.VersionIdentifierBuilder version(String version) {
      this.version = version;
      return this;
    }

    public VersionIdentifier.VersionIdentifierBuilder imageType(ImageType imageType) {
      this.imageType = imageType;
      return this;
    }

    public VersionIdentifier build() {
      return new VersionIdentifier(version, imageType);
    }

    public String toString() {
      return
          "com.impinj.itemsense.client.coordinator.softwareupgrades.VersionIdentifier.VersionIdentifierBuilder(version="
              + this.version + ", imageType=" + this.imageType + ")";
    }
  }
}
