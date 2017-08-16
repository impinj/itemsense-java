package com.impinj.itemsense.client.coordinator.readerhealth;

import java.time.ZonedDateTime;
import java.util.Map;

public class HealthEvent {

  private ZonedDateTime eventTime;

  private String readerId;

  private HealthEventType type;

  private String code;

  private Map<String, String> args;

  @java.beans.ConstructorProperties({"eventTime", "readerId", "type", "code", "args"})
  public HealthEvent(
      ZonedDateTime eventTime,
      String readerId,
      HealthEventType type,
      String code,
      Map<String, String> args) {
    this.eventTime = eventTime;
    this.readerId = readerId;
    this.type = type;
    this.code = code;
    this.args = args;
  }

  public HealthEvent() {}

  public static HealthEventBuilder builder() {return new HealthEventBuilder();}

  public ZonedDateTime getEventTime() {return this.eventTime;}

  public String getReaderId() {return this.readerId;}

  public HealthEventType getType() {return this.type;}

  public String getCode() {return this.code;}

  public Map<String, String> getArgs() {return this.args;}

  public void setEventTime(ZonedDateTime eventTime) {this.eventTime = eventTime; }

  public void setReaderId(String readerId) {this.readerId = readerId; }

  public void setType(HealthEventType type) {this.type = type; }

  public void setCode(String code) {this.code = code; }

  public void setArgs(Map<String, String> args) {this.args = args; }

  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (!(o instanceof HealthEvent)) {
      return false;
    }
    final HealthEvent other = (HealthEvent) o;
    final Object this$eventTime = this.getEventTime();
    final Object other$eventTime = other.getEventTime();
    if (this$eventTime == null ? other$eventTime != null
                               : !this$eventTime.equals(other$eventTime)) {
      return false;
    }
    final Object this$readerId = this.getReaderId();
    final Object other$readerId = other.getReaderId();
    if (this$readerId == null ? other$readerId != null : !this$readerId.equals(other$readerId)) {
      return false;
    }
    final Object this$type = this.getType();
    final Object other$type = other.getType();
    if (this$type == null ? other$type != null : !this$type.equals(other$type)) {
      return false;
    }
    final Object this$code = this.getCode();
    final Object other$code = other.getCode();
    if (this$code == null ? other$code != null : !this$code.equals(other$code)) {
      return false;
    }
    final Object this$args = this.getArgs();
    final Object other$args = other.getArgs();
    return this$args == null ? other$args == null : this$args.equals(other$args);
  }

  public int hashCode() {
    final int PRIME = 59;
    int result = 1;
    final Object $eventTime = this.getEventTime();
    result = result * PRIME + ($eventTime == null ? 43 : $eventTime.hashCode());
    final Object $readerId = this.getReaderId();
    result = result * PRIME + ($readerId == null ? 43 : $readerId.hashCode());
    final Object $type = this.getType();
    result = result * PRIME + ($type == null ? 43 : $type.hashCode());
    final Object $code = this.getCode();
    result = result * PRIME + ($code == null ? 43 : $code.hashCode());
    final Object $args = this.getArgs();
    result = result * PRIME + ($args == null ? 43 : $args.hashCode());
    return result;
  }

  public String toString() {
    return "com.impinj.itemsense.client.coordinator.readerhealth.HealthEvent(eventTime=" + this
        .getEventTime() + ", readerId=" + this.getReaderId() + ", type=" + this.getType()
        + ", code=" + this.getCode() + ", args=" + this.getArgs() + ")";
  }

  public static class HealthEventBuilder {

    private ZonedDateTime eventTime;
    private String readerId;
    private HealthEventType type;
    private String code;
    private Map<String, String> args;

    HealthEventBuilder() {}

    public HealthEvent.HealthEventBuilder eventTime(ZonedDateTime eventTime) {
      this.eventTime = eventTime;
      return this;
    }

    public HealthEvent.HealthEventBuilder readerId(String readerId) {
      this.readerId = readerId;
      return this;
    }

    public HealthEvent.HealthEventBuilder type(HealthEventType type) {
      this.type = type;
      return this;
    }

    public HealthEvent.HealthEventBuilder code(String code) {
      this.code = code;
      return this;
    }

    public HealthEvent.HealthEventBuilder args(Map<String, String> args) {
      this.args = args;
      return this;
    }

    public HealthEvent build() {
      return new HealthEvent(eventTime, readerId, type, code, args);
    }

    public String toString() {
      return
          "com.impinj.itemsense.client.coordinator.readerhealth.HealthEvent.HealthEventBuilder(eventTime="
              + this.eventTime + ", readerId=" + this.readerId + ", type=" + this.type + ", code="
              + this.code + ", args=" + this.args + ")";
    }
  }
}
