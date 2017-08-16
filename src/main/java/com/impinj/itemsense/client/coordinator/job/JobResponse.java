package com.impinj.itemsense.client.coordinator.job;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.impinj.itemsense.client.coordinator.facility.Facility;
import java.time.ZonedDateTime;


@JsonIgnoreProperties(ignoreUnknown = true)
public class JobResponse {

  private String id;
  private String status;
  private String[] readerNames;
  private String[] failedReaderNames;

  private ZonedDateTime creationTime;
  private ZonedDateTime lastActivityTime;
  private ZonedDateTime lastHeartbeatTime;

  private String activeDuration;
  private boolean errorOccurred;
  private JobResponseError[] errors;
  private int maxErrors;
  private String stopReason;
  private Facility[] facilities;
  private Job job;
  private int startAttempts;

  @java.beans.ConstructorProperties({"id", "status", "readerNames", "failedReaderNames",
      "creationTime", "lastActivityTime", "lastHeartbeatTime", "activeDuration", "errorOccurred",
      "errors", "maxErrors", "stopReason", "facilities", "job", "startAttempts"})
  public JobResponse(
      String id,
      String status,
      String[] readerNames,
      String[] failedReaderNames,
      ZonedDateTime creationTime,
      ZonedDateTime lastActivityTime,
      ZonedDateTime lastHeartbeatTime,
      String activeDuration,
      boolean errorOccurred,
      JobResponseError[] errors,
      int maxErrors,
      String stopReason, Facility[] facilities, Job job, int startAttempts) {
    this.id = id;
    this.status = status;
    this.readerNames = readerNames;
    this.failedReaderNames = failedReaderNames;
    this.creationTime = creationTime;
    this.lastActivityTime = lastActivityTime;
    this.lastHeartbeatTime = lastHeartbeatTime;
    this.activeDuration = activeDuration;
    this.errorOccurred = errorOccurred;
    this.errors = errors;
    this.maxErrors = maxErrors;
    this.stopReason = stopReason;
    this.facilities = facilities;
    this.job = job;
    this.startAttempts = startAttempts;
  }

  public JobResponse() {}
  //TODO:INSTANCE META DATA;

  @JsonIgnore
  public JobStatus getJobStatusAsEnum() {
    try {
      return JobStatus.valueOf(status);
    } catch (java.lang.IllegalArgumentException e) {
      return JobStatus.UNKNOWN;
    }
  }

  @JsonIgnore
  public JobStopReason getJobStopReasonAsEnum() {
    try {
      return JobStopReason.valueOf(status);
    } catch (java.lang.IllegalArgumentException e) {
      return JobStopReason.UNKNOWN;
    }
  }

  public String getId() {return this.id;}

  public String getStatus() {return this.status;}

  public String[] getReaderNames() {return this.readerNames;}

  public String[] getFailedReaderNames() {return this.failedReaderNames;}

  public ZonedDateTime getCreationTime() {return this.creationTime;}

  public ZonedDateTime getLastActivityTime() {return this.lastActivityTime;}

  public ZonedDateTime getLastHeartbeatTime() {return this.lastHeartbeatTime;}

  public String getActiveDuration() {return this.activeDuration;}

  public boolean isErrorOccurred() {return this.errorOccurred;}

  public JobResponseError[] getErrors() {return this.errors;}

  public int getMaxErrors() {return this.maxErrors;}

  public String getStopReason() {return this.stopReason;}

  public Facility[] getFacilities() {return this.facilities;}

  public Job getJob() {return this.job;}

  public int getStartAttempts() {return this.startAttempts;}

  public void setId(String id) {this.id = id; }

  public void setStatus(String status) {this.status = status; }

  public void setReaderNames(String[] readerNames) {this.readerNames = readerNames; }

  public void setFailedReaderNames(String[] failedReaderNames) {this.failedReaderNames = failedReaderNames; }

  public void setCreationTime(ZonedDateTime creationTime) {this.creationTime = creationTime; }

  public void setLastActivityTime(ZonedDateTime lastActivityTime) {this.lastActivityTime = lastActivityTime; }

  public void setLastHeartbeatTime(ZonedDateTime lastHeartbeatTime) {this.lastHeartbeatTime = lastHeartbeatTime; }

  public void setActiveDuration(String activeDuration) {this.activeDuration = activeDuration; }

  public void setErrorOccurred(boolean errorOccurred) {this.errorOccurred = errorOccurred; }

  public void setErrors(JobResponseError[] errors) {this.errors = errors; }

  public void setMaxErrors(int maxErrors) {this.maxErrors = maxErrors; }

  public void setStopReason(String stopReason) {this.stopReason = stopReason; }

  public void setFacilities(Facility[] facilities) {this.facilities = facilities; }

  public void setJob(Job job) {this.job = job; }

  public void setStartAttempts(int startAttempts) {this.startAttempts = startAttempts; }

  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (!(o instanceof JobResponse)) {
      return false;
    }
    final JobResponse other = (JobResponse) o;
    final Object this$id = this.getId();
    final Object other$id = other.getId();
    if (this$id == null ? other$id != null : !this$id.equals(other$id)) {
      return false;
    }
    final Object this$status = this.getStatus();
    final Object other$status = other.getStatus();
    if (this$status == null ? other$status != null : !this$status.equals(other$status)) {
      return false;
    }
    if (!java.util.Arrays.deepEquals(this.getReaderNames(), other.getReaderNames())) {
      return false;
    }
    if (!java.util.Arrays.deepEquals(this.getFailedReaderNames(), other.getFailedReaderNames())) {
      return false;
    }
    final Object this$creationTime = this.getCreationTime();
    final Object other$creationTime = other.getCreationTime();
    if (this$creationTime == null ? other$creationTime != null : !this$creationTime.equals(
        other$creationTime)) {
      return false;
    }
    final Object this$lastActivityTime = this.getLastActivityTime();
    final Object other$lastActivityTime = other.getLastActivityTime();
    if (this$lastActivityTime == null ? other$lastActivityTime != null
                                      : !this$lastActivityTime.equals(other$lastActivityTime)) {
      return false;
    }
    final Object this$lastHeartbeatTime = this.getLastHeartbeatTime();
    final Object other$lastHeartbeatTime = other.getLastHeartbeatTime();
    if (this$lastHeartbeatTime == null ? other$lastHeartbeatTime != null
                                       : !this$lastHeartbeatTime.equals(other$lastHeartbeatTime)) {
      return false;
    }
    final Object this$activeDuration = this.getActiveDuration();
    final Object other$activeDuration = other.getActiveDuration();
    if (this$activeDuration == null ? other$activeDuration != null : !this$activeDuration.equals(
        other$activeDuration)) {
      return false;
    }
    if (this.isErrorOccurred() != other.isErrorOccurred()) {
      return false;
    }
    if (!java.util.Arrays.deepEquals(this.getErrors(), other.getErrors())) {
      return false;
    }
    if (this.getMaxErrors() != other.getMaxErrors()) {
      return false;
    }
    final Object this$stopReason = this.getStopReason();
    final Object other$stopReason = other.getStopReason();
    if (this$stopReason == null ? other$stopReason != null : !this$stopReason.equals(
        other$stopReason)) {
      return false;
    }
    if (!java.util.Arrays.deepEquals(this.getFacilities(), other.getFacilities())) {
      return false;
    }
    final Object this$job = this.getJob();
    final Object other$job = other.getJob();
    if (this$job == null ? other$job != null : !this$job.equals(other$job)) {
      return false;
    }
    return this.getStartAttempts() == other.getStartAttempts();
  }

  public int hashCode() {
    final int PRIME = 59;
    int result = 1;
    final Object $id = this.getId();
    result = result * PRIME + ($id == null ? 43 : $id.hashCode());
    final Object $status = this.getStatus();
    result = result * PRIME + ($status == null ? 43 : $status.hashCode());
    result = result * PRIME + java.util.Arrays.deepHashCode(this.getReaderNames());
    result = result * PRIME + java.util.Arrays.deepHashCode(this.getFailedReaderNames());
    final Object $creationTime = this.getCreationTime();
    result = result * PRIME + ($creationTime == null ? 43 : $creationTime.hashCode());
    final Object $lastActivityTime = this.getLastActivityTime();
    result = result * PRIME + ($lastActivityTime == null ? 43 : $lastActivityTime.hashCode());
    final Object $lastHeartbeatTime = this.getLastHeartbeatTime();
    result = result * PRIME + ($lastHeartbeatTime == null ? 43 : $lastHeartbeatTime.hashCode());
    final Object $activeDuration = this.getActiveDuration();
    result = result * PRIME + ($activeDuration == null ? 43 : $activeDuration.hashCode());
    result = result * PRIME + (this.isErrorOccurred() ? 79 : 97);
    result = result * PRIME + java.util.Arrays.deepHashCode(this.getErrors());
    result = result * PRIME + this.getMaxErrors();
    final Object $stopReason = this.getStopReason();
    result = result * PRIME + ($stopReason == null ? 43 : $stopReason.hashCode());
    result = result * PRIME + java.util.Arrays.deepHashCode(this.getFacilities());
    final Object $job = this.getJob();
    result = result * PRIME + ($job == null ? 43 : $job.hashCode());
    result = result * PRIME + this.getStartAttempts();
    return result;
  }

  public String toString() {
    return "com.impinj.itemsense.client.coordinator.job.JobResponse(id=" + this.getId()
        + ", status=" + this.getStatus() + ", readerNames=" + java.util.Arrays
        .deepToString(this.getReaderNames()) + ", failedReaderNames=" + java.util.Arrays
        .deepToString(this.getFailedReaderNames()) + ", creationTime=" + this.getCreationTime()
        + ", lastActivityTime=" + this.getLastActivityTime() + ", lastHeartbeatTime=" + this
        .getLastHeartbeatTime() + ", activeDuration=" + this.getActiveDuration()
        + ", errorOccurred=" + this.isErrorOccurred() + ", errors=" + java.util.Arrays.deepToString(
        this.getErrors()) + ", maxErrors=" + this.getMaxErrors() + ", stopReason=" + this
        .getStopReason() + ", facilities=" + java.util.Arrays.deepToString(this.getFacilities())
        + ", job=" + this.getJob() + ", startAttempts=" + this.getStartAttempts() + ")";
  }
}
