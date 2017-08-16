package com.impinj.itemsense.client.coordinator.job;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.time.ZonedDateTime;


@JsonIgnoreProperties(ignoreUnknown = true)
public class JobResponseError {

  private ZonedDateTime time;
  private String message;

  @java.beans.ConstructorProperties({"time", "message"})
  public JobResponseError(ZonedDateTime time, String message) {
    this.time = time;
    this.message = message;
  }

  public JobResponseError() {}

  public ZonedDateTime getTime() {return this.time;}

  public String getMessage() {return this.message;}

  public void setTime(ZonedDateTime time) {this.time = time; }

  public void setMessage(String message) {this.message = message; }

  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (!(o instanceof JobResponseError)) {
      return false;
    }
    final JobResponseError other = (JobResponseError) o;
    final Object this$time = this.getTime();
    final Object other$time = other.getTime();
    if (this$time == null ? other$time != null : !this$time.equals(other$time)) {
      return false;
    }
    final Object this$message = this.getMessage();
    final Object other$message = other.getMessage();
    return this$message == null ? other$message == null : this$message.equals(other$message);
  }

  public int hashCode() {
    final int PRIME = 59;
    int result = 1;
    final Object $time = this.getTime();
    result = result * PRIME + ($time == null ? 43 : $time.hashCode());
    final Object $message = this.getMessage();
    result = result * PRIME + ($message == null ? 43 : $message.hashCode());
    return result;
  }

  public String toString() {
    return "com.impinj.itemsense.client.coordinator.job.JobResponseError(time=" + this.getTime()
        + ", message=" + this.getMessage() + ")";
  }
}
