package com.impinj.itemsense.client.coordinator.readerconfiguration;

public class DoNothingReaderConfigDetails extends ReaderConfigurationDetails {

  DoNothingReaderConfigDetails() {}

  public static DoNothingReaderConfigDetailsBuilder builder() {return new DoNothingReaderConfigDetailsBuilder();}

  public static class DoNothingReaderConfigDetailsBuilder {

    DoNothingReaderConfigDetailsBuilder() {}

    public DoNothingReaderConfigDetails build() {
      return new DoNothingReaderConfigDetails();
    }

    public String toString() {return "com.impinj.itemsense.client.coordinator.readerconfiguration.DoNothingReaderConfigDetails.DoNothingReaderConfigDetailsBuilder()";}
  }
}
