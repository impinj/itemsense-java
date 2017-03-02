package com.impinj.itemsense.client.data.itemdoortransition;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.time.ZonedDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ItemDoorTransition {

  private String epc;
  private int doorId;
  private String destination;
  private double confidence;
  private ZonedDateTime creationTime;
}
