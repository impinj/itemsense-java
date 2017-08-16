package com.impinj.itemsense.client.coordinator.readerconfiguration;

import com.fasterxml.jackson.annotation.JsonTypeId;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

public class ReaderConfiguration {

  private String name;

  @JsonTypeId
  private Operation operation;
  @JsonTypeInfo(use = JsonTypeInfo.Id.NAME,
      include = JsonTypeInfo.As.EXTERNAL_PROPERTY, property = "operation", visible = true)
  private ReaderConfigurationDetails configuration;

  //For some reason using @AllArgsConstructor screws up Jackson deserialization
  public ReaderConfiguration(
      String name,
      Operation operation,
      ReaderConfigurationDetails readerConfigurationDetails) {
    this.name = name;
    this.operation = operation;
    this.configuration = readerConfigurationDetails;
  }

  public ReaderConfiguration() {}

  public static ReaderConfigurationBuilder builder() {return new ReaderConfigurationBuilder();}

  public String getName() {return this.name;}

  public Operation getOperation() {return this.operation;}

  public ReaderConfigurationDetails getConfiguration() {return this.configuration;}

  public void setName(String name) {this.name = name; }

  public void setOperation(Operation operation) {this.operation = operation; }

  public void setConfiguration(ReaderConfigurationDetails configuration) {this.configuration = configuration; }

  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (!(o instanceof ReaderConfiguration)) {
      return false;
    }
    final ReaderConfiguration other = (ReaderConfiguration) o;
    final Object this$name = this.getName();
    final Object other$name = other.getName();
    if (this$name == null ? other$name != null : !this$name.equals(other$name)) {
      return false;
    }
    final Object this$operation = this.getOperation();
    final Object other$operation = other.getOperation();
    if (this$operation == null ? other$operation != null
                               : !this$operation.equals(other$operation)) {
      return false;
    }
    final Object this$configuration = this.getConfiguration();
    final Object other$configuration = other.getConfiguration();
    return this$configuration == null ? other$configuration == null : this$configuration.equals(
        other$configuration);
  }

  public int hashCode() {
    final int PRIME = 59;
    int result = 1;
    final Object $name = this.getName();
    result = result * PRIME + ($name == null ? 43 : $name.hashCode());
    final Object $operation = this.getOperation();
    result = result * PRIME + ($operation == null ? 43 : $operation.hashCode());
    final Object $configuration = this.getConfiguration();
    result = result * PRIME + ($configuration == null ? 43 : $configuration.hashCode());
    return result;
  }

  public String toString() {
    return "com.impinj.itemsense.client.coordinator.readerconfiguration.ReaderConfiguration(name="
        + this.getName() + ", operation=" + this.getOperation() + ", configuration=" + this
        .getConfiguration() + ")";
  }

  public static class ReaderConfigurationBuilder {

    private String name;
    private Operation operation;
    private ReaderConfigurationDetails configuration;

    ReaderConfigurationBuilder() {}

    public ReaderConfiguration.ReaderConfigurationBuilder name(String name) {
      this.name = name;
      return this;
    }

    public ReaderConfiguration.ReaderConfigurationBuilder operation(Operation operation) {
      this.operation = operation;
      return this;
    }

    public ReaderConfiguration.ReaderConfigurationBuilder configuration(ReaderConfigurationDetails configuration) {
      this.configuration = configuration;
      return this;
    }

    public ReaderConfiguration build() {
      return new ReaderConfiguration(name, operation, configuration);
    }

    public String toString() {
      return
          "com.impinj.itemsense.client.coordinator.readerconfiguration.ReaderConfiguration.ReaderConfigurationBuilder(name="
              + this.name + ", operation=" + this.operation + ", configuration="
              + this.configuration
              + ")";
    }
  }
}


