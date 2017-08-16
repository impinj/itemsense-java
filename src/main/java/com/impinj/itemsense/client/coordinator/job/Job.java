package com.impinj.itemsense.client.coordinator.job;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Job {

  private String name;
  private String recipeName;
  private String facility;
  private String startDelay;
  private int durationSeconds;
  private boolean reportToDatabaseEnabled;
  private boolean reportToHistoryEnabled;
  private boolean reportToMessageQueueEnabled;
  private boolean reportToFileEnabled;
  private Set<String> readerGroups;

  @java.beans.ConstructorProperties({"name", "recipeName", "facility", "startDelay",
      "durationSeconds", "reportToDatabaseEnabled", "reportToHistoryEnabled",
      "reportToMessageQueueEnabled", "reportToFileEnabled", "readerGroups"})
  public Job(
      String name,
      String recipeName,
      String facility,
      String startDelay,
      int durationSeconds,
      boolean reportToDatabaseEnabled,
      boolean reportToHistoryEnabled,
      boolean reportToMessageQueueEnabled, boolean reportToFileEnabled, Set<String> readerGroups) {
    this.name = name;
    this.recipeName = recipeName;
    this.facility = facility;
    this.startDelay = startDelay;
    this.durationSeconds = durationSeconds;
    this.reportToDatabaseEnabled = reportToDatabaseEnabled;
    this.reportToHistoryEnabled = reportToHistoryEnabled;
    this.reportToMessageQueueEnabled = reportToMessageQueueEnabled;
    this.reportToFileEnabled = reportToFileEnabled;
    this.readerGroups = readerGroups;
  }

  public Job() {}

  public static JobBuilder builder() {return new JobBuilder();}

  public String getName() {return this.name;}

  public String getRecipeName() {return this.recipeName;}

  public String getFacility() {return this.facility;}

  public String getStartDelay() {return this.startDelay;}

  public int getDurationSeconds() {return this.durationSeconds;}

  public boolean isReportToDatabaseEnabled() {return this.reportToDatabaseEnabled;}

  public boolean isReportToHistoryEnabled() {return this.reportToHistoryEnabled;}

  public boolean isReportToMessageQueueEnabled() {return this.reportToMessageQueueEnabled;}

  public boolean isReportToFileEnabled() {return this.reportToFileEnabled;}

  public Set<String> getReaderGroups() {return this.readerGroups;}

  public void setName(String name) {this.name = name; }

  public void setRecipeName(String recipeName) {this.recipeName = recipeName; }

  public void setFacility(String facility) {this.facility = facility; }

  public void setStartDelay(String startDelay) {this.startDelay = startDelay; }

  public void setDurationSeconds(int durationSeconds) {this.durationSeconds = durationSeconds; }

  public void setReportToDatabaseEnabled(boolean reportToDatabaseEnabled) {this.reportToDatabaseEnabled = reportToDatabaseEnabled; }

  public void setReportToHistoryEnabled(boolean reportToHistoryEnabled) {this.reportToHistoryEnabled = reportToHistoryEnabled; }

  public void setReportToMessageQueueEnabled(boolean reportToMessageQueueEnabled) {this.reportToMessageQueueEnabled = reportToMessageQueueEnabled; }

  public void setReportToFileEnabled(boolean reportToFileEnabled) {this.reportToFileEnabled = reportToFileEnabled; }

  public void setReaderGroups(Set<String> readerGroups) {this.readerGroups = readerGroups; }

  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (!(o instanceof Job)) {
      return false;
    }
    final Job other = (Job) o;
    final Object this$name = this.getName();
    final Object other$name = other.getName();
    if (this$name == null ? other$name != null : !this$name.equals(other$name)) {
      return false;
    }
    final Object this$recipeName = this.getRecipeName();
    final Object other$recipeName = other.getRecipeName();
    if (this$recipeName == null ? other$recipeName != null : !this$recipeName.equals(
        other$recipeName)) {
      return false;
    }
    final Object this$facility = this.getFacility();
    final Object other$facility = other.getFacility();
    if (this$facility == null ? other$facility != null : !this$facility.equals(other$facility)) {
      return false;
    }
    final Object this$startDelay = this.getStartDelay();
    final Object other$startDelay = other.getStartDelay();
    if (this$startDelay == null ? other$startDelay != null : !this$startDelay.equals(
        other$startDelay)) {
      return false;
    }
    if (this.getDurationSeconds() != other.getDurationSeconds()) {
      return false;
    }
    if (this.isReportToDatabaseEnabled() != other.isReportToDatabaseEnabled()) {
      return false;
    }
    if (this.isReportToHistoryEnabled() != other.isReportToHistoryEnabled()) {
      return false;
    }
    if (this.isReportToMessageQueueEnabled() != other.isReportToMessageQueueEnabled()) {
      return false;
    }
    if (this.isReportToFileEnabled() != other.isReportToFileEnabled()) {
      return false;
    }
    final Object this$readerGroups = this.getReaderGroups();
    final Object other$readerGroups = other.getReaderGroups();
    return this$readerGroups == null ? other$readerGroups == null : this$readerGroups.equals(
        other$readerGroups);
  }

  public int hashCode() {
    final int PRIME = 59;
    int result = 1;
    final Object $name = this.getName();
    result = result * PRIME + ($name == null ? 43 : $name.hashCode());
    final Object $recipeName = this.getRecipeName();
    result = result * PRIME + ($recipeName == null ? 43 : $recipeName.hashCode());
    final Object $facility = this.getFacility();
    result = result * PRIME + ($facility == null ? 43 : $facility.hashCode());
    final Object $startDelay = this.getStartDelay();
    result = result * PRIME + ($startDelay == null ? 43 : $startDelay.hashCode());
    result = result * PRIME + this.getDurationSeconds();
    result = result * PRIME + (this.isReportToDatabaseEnabled() ? 79 : 97);
    result = result * PRIME + (this.isReportToHistoryEnabled() ? 79 : 97);
    result = result * PRIME + (this.isReportToMessageQueueEnabled() ? 79 : 97);
    result = result * PRIME + (this.isReportToFileEnabled() ? 79 : 97);
    final Object $readerGroups = this.getReaderGroups();
    result = result * PRIME + ($readerGroups == null ? 43 : $readerGroups.hashCode());
    return result;
  }

  public String toString() {
    return "com.impinj.itemsense.client.coordinator.job.Job(name=" + this.getName()
        + ", recipeName=" + this.getRecipeName() + ", facility=" + this.getFacility()
        + ", startDelay=" + this.getStartDelay() + ", durationSeconds=" + this.getDurationSeconds()
        + ", reportToDatabaseEnabled=" + this.isReportToDatabaseEnabled()
        + ", reportToHistoryEnabled=" + this.isReportToHistoryEnabled()
        + ", reportToMessageQueueEnabled=" + this.isReportToMessageQueueEnabled()
        + ", reportToFileEnabled=" + this.isReportToFileEnabled() + ", readerGroups=" + this
        .getReaderGroups() + ")";
  }

  public static class JobBuilder {

    private String name;
    private String recipeName;
    private String facility;
    private String startDelay;
    private int durationSeconds;
    private boolean reportToDatabaseEnabled;
    private boolean reportToHistoryEnabled;
    private boolean reportToMessageQueueEnabled;
    private boolean reportToFileEnabled;
    private Set<String> readerGroups;

    JobBuilder() {}

    public Job.JobBuilder name(String name) {
      this.name = name;
      return this;
    }

    public Job.JobBuilder recipeName(String recipeName) {
      this.recipeName = recipeName;
      return this;
    }

    public Job.JobBuilder facility(String facility) {
      this.facility = facility;
      return this;
    }

    public Job.JobBuilder startDelay(String startDelay) {
      this.startDelay = startDelay;
      return this;
    }

    public Job.JobBuilder durationSeconds(int durationSeconds) {
      this.durationSeconds = durationSeconds;
      return this;
    }

    public Job.JobBuilder reportToDatabaseEnabled(boolean reportToDatabaseEnabled) {
      this.reportToDatabaseEnabled = reportToDatabaseEnabled;
      return this;
    }

    public Job.JobBuilder reportToHistoryEnabled(boolean reportToHistoryEnabled) {
      this.reportToHistoryEnabled = reportToHistoryEnabled;
      return this;
    }

    public Job.JobBuilder reportToMessageQueueEnabled(boolean reportToMessageQueueEnabled) {
      this.reportToMessageQueueEnabled = reportToMessageQueueEnabled;
      return this;
    }

    public Job.JobBuilder reportToFileEnabled(boolean reportToFileEnabled) {
      this.reportToFileEnabled = reportToFileEnabled;
      return this;
    }

    public Job.JobBuilder readerGroups(Set<String> readerGroups) {
      this.readerGroups = readerGroups;
      return this;
    }

    public Job build() {
      return new Job(
          name,
          recipeName,
          facility,
          startDelay,
          durationSeconds,
          reportToDatabaseEnabled,
          reportToHistoryEnabled,
          reportToMessageQueueEnabled,
          reportToFileEnabled,
          readerGroups);
    }

    public String toString() {
      return "com.impinj.itemsense.client.coordinator.job.Job.JobBuilder(name=" + this.name
          + ", recipeName=" + this.recipeName + ", facility=" + this.facility + ", startDelay="
          + this.startDelay + ", durationSeconds=" + this.durationSeconds
          + ", reportToDatabaseEnabled=" + this.reportToDatabaseEnabled
          + ", reportToHistoryEnabled="
          + this.reportToHistoryEnabled + ", reportToMessageQueueEnabled="
          + this.reportToMessageQueueEnabled + ", reportToFileEnabled=" + this.reportToFileEnabled
          + ", readerGroups=" + this.readerGroups + ")";
    }
  }
}

