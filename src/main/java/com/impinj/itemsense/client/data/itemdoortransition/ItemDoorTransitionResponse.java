package com.impinj.itemsense.client.data.itemdoortransition;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ItemDoorTransitionResponse {

  private ItemDoorTransition[] transitions;
  private String nextPageMarker;
  private boolean moreHistoryAvailable;
}
