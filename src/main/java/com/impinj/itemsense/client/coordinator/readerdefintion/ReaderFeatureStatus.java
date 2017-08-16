package com.impinj.itemsense.client.coordinator.readerdefintion;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.time.ZonedDateTime;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ReaderFeatureStatus {

  private FeatureStatus status;
  private ZonedDateTime statusLastUpdated;

  private FeatureRequestStatus requestStatus;
  private ZonedDateTime requestStatusLastUpdated;
  private FeatureStatus requestTargetStatus;
  private String message;

  @java.beans.ConstructorProperties({"status", "statusLastUpdated", "requestStatus",
      "requestStatusLastUpdated", "requestTargetStatus", "message"})
  public ReaderFeatureStatus(
      FeatureStatus status,
      ZonedDateTime statusLastUpdated,
      FeatureRequestStatus requestStatus,
      ZonedDateTime requestStatusLastUpdated,
      FeatureStatus requestTargetStatus, String message) {
    this.status = status;
    this.statusLastUpdated = statusLastUpdated;
    this.requestStatus = requestStatus;
    this.requestStatusLastUpdated = requestStatusLastUpdated;
    this.requestTargetStatus = requestTargetStatus;
    this.message = message;
  }

  public ReaderFeatureStatus() {}

  public static ReaderFeatureStatusBuilder builder() {return new ReaderFeatureStatusBuilder();}

  public FeatureStatus getStatus() {return this.status;}

  public ZonedDateTime getStatusLastUpdated() {return this.statusLastUpdated;}

  public FeatureRequestStatus getRequestStatus() {return this.requestStatus;}

  public ZonedDateTime getRequestStatusLastUpdated() {return this.requestStatusLastUpdated;}

  public FeatureStatus getRequestTargetStatus() {return this.requestTargetStatus;}

  public String getMessage() {return this.message;}

  public void setStatus(FeatureStatus status) {this.status = status; }

  public void setStatusLastUpdated(ZonedDateTime statusLastUpdated) {this.statusLastUpdated = statusLastUpdated; }

  public void setRequestStatus(FeatureRequestStatus requestStatus) {this.requestStatus = requestStatus; }

  public void setRequestStatusLastUpdated(ZonedDateTime requestStatusLastUpdated) {this.requestStatusLastUpdated = requestStatusLastUpdated; }

  public void setRequestTargetStatus(FeatureStatus requestTargetStatus) {this.requestTargetStatus = requestTargetStatus; }

  public void setMessage(String message) {this.message = message; }

  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (!(o instanceof ReaderFeatureStatus)) {
      return false;
    }
    final ReaderFeatureStatus other = (ReaderFeatureStatus) o;
    final Object this$status = this.getStatus();
    final Object other$status = other.getStatus();
    if (this$status == null ? other$status != null : !this$status.equals(other$status)) {
      return false;
    }
    final Object this$statusLastUpdated = this.getStatusLastUpdated();
    final Object other$statusLastUpdated = other.getStatusLastUpdated();
    if (this$statusLastUpdated == null ? other$statusLastUpdated != null
                                       : !this$statusLastUpdated.equals(other$statusLastUpdated)) {
      return false;
    }
    final Object this$requestStatus = this.getRequestStatus();
    final Object other$requestStatus = other.getRequestStatus();
    if (this$requestStatus == null ? other$requestStatus != null : !this$requestStatus.equals(
        other$requestStatus)) {
      return false;
    }
    final Object this$requestStatusLastUpdated = this.getRequestStatusLastUpdated();
    final Object other$requestStatusLastUpdated = other.getRequestStatusLastUpdated();
    if (this$requestStatusLastUpdated == null ? other$requestStatusLastUpdated != null
                                              : !this$requestStatusLastUpdated.equals(
                                                  other$requestStatusLastUpdated)) {
      return false;
    }
    final Object this$requestTargetStatus = this.getRequestTargetStatus();
    final Object other$requestTargetStatus = other.getRequestTargetStatus();
    if (this$requestTargetStatus == null ? other$requestTargetStatus != null
                                         : !this$requestTargetStatus.equals(
                                             other$requestTargetStatus)) {
      return false;
    }
    final Object this$message = this.getMessage();
    final Object other$message = other.getMessage();
    return this$message == null ? other$message == null : this$message.equals(other$message);
  }

  public int hashCode() {
    final int PRIME = 59;
    int result = 1;
    final Object $status = this.getStatus();
    result = result * PRIME + ($status == null ? 43 : $status.hashCode());
    final Object $statusLastUpdated = this.getStatusLastUpdated();
    result = result * PRIME + ($statusLastUpdated == null ? 43 : $statusLastUpdated.hashCode());
    final Object $requestStatus = this.getRequestStatus();
    result = result * PRIME + ($requestStatus == null ? 43 : $requestStatus.hashCode());
    final Object $requestStatusLastUpdated = this.getRequestStatusLastUpdated();
    result = result * PRIME + ($requestStatusLastUpdated == null ? 43 : $requestStatusLastUpdated
        .hashCode());
    final Object $requestTargetStatus = this.getRequestTargetStatus();
    result = result * PRIME + ($requestTargetStatus == null ? 43 : $requestTargetStatus.hashCode());
    final Object $message = this.getMessage();
    result = result * PRIME + ($message == null ? 43 : $message.hashCode());
    return result;
  }

  public String toString() {
    return "com.impinj.itemsense.client.coordinator.readerdefintion.ReaderFeatureStatus(status="
        + this.getStatus() + ", statusLastUpdated=" + this.getStatusLastUpdated()
        + ", requestStatus=" + this.getRequestStatus() + ", requestStatusLastUpdated=" + this
        .getRequestStatusLastUpdated() + ", requestTargetStatus=" + this.getRequestTargetStatus()
        + ", message=" + this.getMessage() + ")";
  }

  public static class ReaderFeatureStatusBuilder {

    private FeatureStatus status;
    private ZonedDateTime statusLastUpdated;
    private FeatureRequestStatus requestStatus;
    private ZonedDateTime requestStatusLastUpdated;
    private FeatureStatus requestTargetStatus;
    private String message;

    ReaderFeatureStatusBuilder() {}

    public ReaderFeatureStatus.ReaderFeatureStatusBuilder status(FeatureStatus status) {
      this.status = status;
      return this;
    }

    public ReaderFeatureStatus.ReaderFeatureStatusBuilder statusLastUpdated(ZonedDateTime statusLastUpdated) {
      this.statusLastUpdated = statusLastUpdated;
      return this;
    }

    public ReaderFeatureStatus.ReaderFeatureStatusBuilder requestStatus(FeatureRequestStatus requestStatus) {
      this.requestStatus = requestStatus;
      return this;
    }

    public ReaderFeatureStatus.ReaderFeatureStatusBuilder requestStatusLastUpdated(ZonedDateTime requestStatusLastUpdated) {
      this.requestStatusLastUpdated = requestStatusLastUpdated;
      return this;
    }

    public ReaderFeatureStatus.ReaderFeatureStatusBuilder requestTargetStatus(FeatureStatus requestTargetStatus) {
      this.requestTargetStatus = requestTargetStatus;
      return this;
    }

    public ReaderFeatureStatus.ReaderFeatureStatusBuilder message(String message) {
      this.message = message;
      return this;
    }

    public ReaderFeatureStatus build() {
      return new ReaderFeatureStatus(
          status,
          statusLastUpdated,
          requestStatus,
          requestStatusLastUpdated,
          requestTargetStatus,
          message);
    }

    public String toString() {
      return
          "com.impinj.itemsense.client.coordinator.readerdefintion.ReaderFeatureStatus.ReaderFeatureStatusBuilder(status="
              + this.status + ", statusLastUpdated=" + this.statusLastUpdated + ", requestStatus="
              + this.requestStatus + ", requestStatusLastUpdated=" + this.requestStatusLastUpdated
              + ", requestTargetStatus=" + this.requestTargetStatus + ", message=" + this.message
              + ")";
    }
  }
}
