package com.impinj.itemsense.client.coordinator.readerhealth;

import java.time.ZonedDateTime;
import java.util.Set;

public class HealthEventQuery {

  private Set<String> readerNames;

  private Set<String> types;

  private Set<String> codes;

  private ZonedDateTime fromTime;

  private ZonedDateTime toTime;

  private Integer pageSize = 100;

  private String nextPageMarker;

  public HealthEventQuery() {}

  public Set<String> getReaderNames() {return this.readerNames;}

  public Set<String> getTypes() {return this.types;}

  public Set<String> getCodes() {return this.codes;}

  public ZonedDateTime getFromTime() {return this.fromTime;}

  public ZonedDateTime getToTime() {return this.toTime;}

  public Integer getPageSize() {return this.pageSize;}

  public String getNextPageMarker() {return this.nextPageMarker;}

  public void setReaderNames(Set<String> readerNames) {this.readerNames = readerNames; }

  public void setTypes(Set<String> types) {this.types = types; }

  public void setCodes(Set<String> codes) {this.codes = codes; }

  public void setFromTime(ZonedDateTime fromTime) {this.fromTime = fromTime; }

  public void setToTime(ZonedDateTime toTime) {this.toTime = toTime; }

  public void setPageSize(Integer pageSize) {this.pageSize = pageSize; }

  public void setNextPageMarker(String nextPageMarker) {this.nextPageMarker = nextPageMarker; }

  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (!(o instanceof HealthEventQuery)) {
      return false;
    }
    final HealthEventQuery other = (HealthEventQuery) o;
    final Object this$readerNames = this.getReaderNames();
    final Object other$readerNames = other.getReaderNames();
    if (this$readerNames == null ? other$readerNames != null : !this$readerNames.equals(
        other$readerNames)) {
      return false;
    }
    final Object this$types = this.getTypes();
    final Object other$types = other.getTypes();
    if (this$types == null ? other$types != null : !this$types.equals(other$types)) {
      return false;
    }
    final Object this$codes = this.getCodes();
    final Object other$codes = other.getCodes();
    if (this$codes == null ? other$codes != null : !this$codes.equals(other$codes)) {
      return false;
    }
    final Object this$fromTime = this.getFromTime();
    final Object other$fromTime = other.getFromTime();
    if (this$fromTime == null ? other$fromTime != null : !this$fromTime.equals(other$fromTime)) {
      return false;
    }
    final Object this$toTime = this.getToTime();
    final Object other$toTime = other.getToTime();
    if (this$toTime == null ? other$toTime != null : !this$toTime.equals(other$toTime)) {
      return false;
    }
    final Object this$pageSize = this.getPageSize();
    final Object other$pageSize = other.getPageSize();
    if (this$pageSize == null ? other$pageSize != null : !this$pageSize.equals(other$pageSize)) {
      return false;
    }
    final Object this$nextPageMarker = this.getNextPageMarker();
    final Object other$nextPageMarker = other.getNextPageMarker();
    return this$nextPageMarker == null ? other$nextPageMarker == null : this$nextPageMarker.equals(
        other$nextPageMarker);
  }

  public int hashCode() {
    final int PRIME = 59;
    int result = 1;
    final Object $readerNames = this.getReaderNames();
    result = result * PRIME + ($readerNames == null ? 43 : $readerNames.hashCode());
    final Object $types = this.getTypes();
    result = result * PRIME + ($types == null ? 43 : $types.hashCode());
    final Object $codes = this.getCodes();
    result = result * PRIME + ($codes == null ? 43 : $codes.hashCode());
    final Object $fromTime = this.getFromTime();
    result = result * PRIME + ($fromTime == null ? 43 : $fromTime.hashCode());
    final Object $toTime = this.getToTime();
    result = result * PRIME + ($toTime == null ? 43 : $toTime.hashCode());
    final Object $pageSize = this.getPageSize();
    result = result * PRIME + ($pageSize == null ? 43 : $pageSize.hashCode());
    final Object $nextPageMarker = this.getNextPageMarker();
    result = result * PRIME + ($nextPageMarker == null ? 43 : $nextPageMarker.hashCode());
    return result;
  }

  public String toString() {
    return "com.impinj.itemsense.client.coordinator.readerhealth.HealthEventQuery(readerNames="
        + this.getReaderNames() + ", types=" + this.getTypes() + ", codes=" + this.getCodes()
        + ", fromTime=" + this.getFromTime() + ", toTime=" + this.getToTime() + ", pageSize=" + this
        .getPageSize() + ", nextPageMarker=" + this.getNextPageMarker() + ")";
  }
}
