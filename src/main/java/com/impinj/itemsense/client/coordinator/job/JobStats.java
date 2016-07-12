package com.impinj.itemsense.client.coordinator.job;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javafx.util.Pair;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

/**
 * Created by nkershaw on 7/12/16.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class JobStats {
  private String jobId;

  private TagReadStats total;
  private Map<String, TagReadStats> readerTagReads;

  private Map<Pair<String, String>, Integer> readerPairEpcs;

  private Histogram epcHistogram;
  private Histogram intervalHistogram;
}