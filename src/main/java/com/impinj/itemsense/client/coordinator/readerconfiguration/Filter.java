package com.impinj.itemsense.client.coordinator.readerconfiguration;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)

public class Filter {

  private int memoryBank;
  private int pointer;
  private String tagMask;

  @java.beans.ConstructorProperties({"memoryBank", "pointer", "tagMask"})
  public Filter(int memoryBank, int pointer, String tagMask) {
    this.memoryBank = memoryBank;
    this.pointer = pointer;
    this.tagMask = tagMask;
  }

  public Filter() {}

  public int getMemoryBank() {return this.memoryBank;}

  public int getPointer() {return this.pointer;}

  public String getTagMask() {return this.tagMask;}

  public void setMemoryBank(int memoryBank) {this.memoryBank = memoryBank; }

  public void setPointer(int pointer) {this.pointer = pointer; }

  public void setTagMask(String tagMask) {this.tagMask = tagMask; }

  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (!(o instanceof Filter)) {
      return false;
    }
    final Filter other = (Filter) o;
    if (this.getMemoryBank() != other.getMemoryBank()) {
      return false;
    }
    if (this.getPointer() != other.getPointer()) {
      return false;
    }
    final Object this$tagMask = this.getTagMask();
    final Object other$tagMask = other.getTagMask();
    return this$tagMask == null ? other$tagMask == null : this$tagMask.equals(other$tagMask);
  }

  public int hashCode() {
    final int PRIME = 59;
    int result = 1;
    result = result * PRIME + this.getMemoryBank();
    result = result * PRIME + this.getPointer();
    final Object $tagMask = this.getTagMask();
    result = result * PRIME + ($tagMask == null ? 43 : $tagMask.hashCode());
    return result;
  }

  public String toString() {
    return "com.impinj.itemsense.client.coordinator.readerconfiguration.Filter(memoryBank=" + this
        .getMemoryBank() + ", pointer=" + this.getPointer() + ", tagMask=" + this.getTagMask()
        + ")";
  }
}
