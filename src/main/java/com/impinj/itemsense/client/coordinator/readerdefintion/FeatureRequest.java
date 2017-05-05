package com.impinj.itemsense.client.coordinator.readerdefintion;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@Builder
public class FeatureRequest {

  private ReaderFeature feature;
  private FeatureRequestAction action;
}