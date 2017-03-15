package com.impinj.itemsense.client.coordinator.job;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Job {

  private String recipeName;
  private String facility;
  private String startDelay;
  private int durationSeconds;
  private boolean reportToDatabaseEnabled;
  private boolean reportToMessageQueueEnabled;
  private boolean reportToFileEnabled;
  private Set<String> readerGroups;
}

