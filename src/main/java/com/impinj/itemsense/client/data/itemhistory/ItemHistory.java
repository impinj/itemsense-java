package com.impinj.itemsense.client.data.itemhistory;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.time.ZonedDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ItemHistory {

  private String epc;
  private String tagId;
  private String jobId;
  private String fromZone;
  private String toZone;
  private String fromFLoor;
  private String toFloor;
  private String fromFacility;
  private String toFacility;
  private double fromX;
  private double fromY;
  private double toX;
  private double toY;

  private ZonedDateTime observationTime;
}