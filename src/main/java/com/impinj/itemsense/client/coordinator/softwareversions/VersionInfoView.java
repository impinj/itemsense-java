package com.impinj.itemsense.client.coordinator.softwareversions;

import java.time.LocalDateTime;

public class VersionInfoView {

  VersionInfo versionInfo;
  String description;
  LocalDateTime created;
  LocalDateTime updated;
  String updateComment;
  int recordVersionNumber;

  @java.beans.ConstructorProperties({"versionInfo", "description", "created", "updated",
      "updateComment", "recordVersionNumber"})
  public VersionInfoView(
      VersionInfo versionInfo,
      String description,
      LocalDateTime created,
      LocalDateTime updated, String updateComment, int recordVersionNumber) {
    this.versionInfo = versionInfo;
    this.description = description;
    this.created = created;
    this.updated = updated;
    this.updateComment = updateComment;
    this.recordVersionNumber = recordVersionNumber;
  }

  public VersionInfoView() {}

  public static VersionInfoViewBuilder builder() {return new VersionInfoViewBuilder();}

  public VersionInfo getVersionInfo() {return this.versionInfo;}

  public String getDescription() {return this.description;}

  public LocalDateTime getCreated() {return this.created;}

  public LocalDateTime getUpdated() {return this.updated;}

  public String getUpdateComment() {return this.updateComment;}

  public int getRecordVersionNumber() {return this.recordVersionNumber;}

  public void setVersionInfo(VersionInfo versionInfo) {this.versionInfo = versionInfo; }

  public void setDescription(String description) {this.description = description; }

  public void setCreated(LocalDateTime created) {this.created = created; }

  public void setUpdated(LocalDateTime updated) {this.updated = updated; }

  public void setUpdateComment(String updateComment) {this.updateComment = updateComment; }

  public void setRecordVersionNumber(int recordVersionNumber) {this.recordVersionNumber = recordVersionNumber; }

  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (!(o instanceof VersionInfoView)) {
      return false;
    }
    final VersionInfoView other = (VersionInfoView) o;
    final Object this$versionInfo = this.getVersionInfo();
    final Object other$versionInfo = other.getVersionInfo();
    if (this$versionInfo == null ? other$versionInfo != null : !this$versionInfo.equals(
        other$versionInfo)) {
      return false;
    }
    final Object this$description = this.getDescription();
    final Object other$description = other.getDescription();
    if (this$description == null ? other$description != null : !this$description.equals(
        other$description)) {
      return false;
    }
    final Object this$created = this.getCreated();
    final Object other$created = other.getCreated();
    if (this$created == null ? other$created != null : !this$created.equals(other$created)) {
      return false;
    }
    final Object this$updated = this.getUpdated();
    final Object other$updated = other.getUpdated();
    if (this$updated == null ? other$updated != null : !this$updated.equals(other$updated)) {
      return false;
    }
    final Object this$updateComment = this.getUpdateComment();
    final Object other$updateComment = other.getUpdateComment();
    if (this$updateComment == null ? other$updateComment != null : !this$updateComment.equals(
        other$updateComment)) {
      return false;
    }
    return this.getRecordVersionNumber() == other.getRecordVersionNumber();
  }

  public int hashCode() {
    final int PRIME = 59;
    int result = 1;
    final Object $versionInfo = this.getVersionInfo();
    result = result * PRIME + ($versionInfo == null ? 43 : $versionInfo.hashCode());
    final Object $description = this.getDescription();
    result = result * PRIME + ($description == null ? 43 : $description.hashCode());
    final Object $created = this.getCreated();
    result = result * PRIME + ($created == null ? 43 : $created.hashCode());
    final Object $updated = this.getUpdated();
    result = result * PRIME + ($updated == null ? 43 : $updated.hashCode());
    final Object $updateComment = this.getUpdateComment();
    result = result * PRIME + ($updateComment == null ? 43 : $updateComment.hashCode());
    result = result * PRIME + this.getRecordVersionNumber();
    return result;
  }

  public String toString() {
    return "com.impinj.itemsense.client.coordinator.softwareversions.VersionInfoView(versionInfo="
        + this.getVersionInfo() + ", description=" + this.getDescription() + ", created=" + this
        .getCreated() + ", updated=" + this.getUpdated() + ", updateComment=" + this
        .getUpdateComment() + ", recordVersionNumber=" + this.getRecordVersionNumber() + ")";
  }

  public static class VersionInfoViewBuilder {

    private VersionInfo versionInfo;
    private String description;
    private LocalDateTime created;
    private LocalDateTime updated;
    private String updateComment;
    private int recordVersionNumber;

    VersionInfoViewBuilder() {}

    public VersionInfoView.VersionInfoViewBuilder versionInfo(VersionInfo versionInfo) {
      this.versionInfo = versionInfo;
      return this;
    }

    public VersionInfoView.VersionInfoViewBuilder description(String description) {
      this.description = description;
      return this;
    }

    public VersionInfoView.VersionInfoViewBuilder created(LocalDateTime created) {
      this.created = created;
      return this;
    }

    public VersionInfoView.VersionInfoViewBuilder updated(LocalDateTime updated) {
      this.updated = updated;
      return this;
    }

    public VersionInfoView.VersionInfoViewBuilder updateComment(String updateComment) {
      this.updateComment = updateComment;
      return this;
    }

    public VersionInfoView.VersionInfoViewBuilder recordVersionNumber(int recordVersionNumber) {
      this.recordVersionNumber = recordVersionNumber;
      return this;
    }

    public VersionInfoView build() {
      return new VersionInfoView(
          versionInfo,
          description,
          created,
          updated,
          updateComment,
          recordVersionNumber);
    }

    public String toString() {
      return
          "com.impinj.itemsense.client.coordinator.softwareversions.VersionInfoView.VersionInfoViewBuilder(versionInfo="
              + this.versionInfo + ", description=" + this.description + ", created=" + this.created
              + ", updated=" + this.updated + ", updateComment=" + this.updateComment
              + ", recordVersionNumber=" + this.recordVersionNumber + ")";
    }
  }
}
