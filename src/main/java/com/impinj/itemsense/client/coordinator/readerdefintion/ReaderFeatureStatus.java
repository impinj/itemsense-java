package com.impinj.itemsense.client.coordinator.readerdefintion;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.time.ZonedDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReaderFeatureStatus {

  private FeatureStatus status;
  private ZonedDateTime statusLastUpdated;

  private FeatureRequestStatus requestStatus;
  private ZonedDateTime requestStatusLastUpdated;
  private FeatureStatus requestTargetStatus;
  private String message;
}
