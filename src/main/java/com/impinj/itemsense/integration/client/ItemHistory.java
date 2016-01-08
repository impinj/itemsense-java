/**
 * IMPINJ CONFIDENTIAL AND PROPRIETARY
 *
 * This source code is the sole property of Impinj, Inc. Reproduction or utilization of this source
 * code in whole or in part is forbidden without the prior written consent of Impinj, Inc.
 *
 * (c) Copyright Impinj, Inc. 2015. All rights reserved.
 */
package com.impinj.itemsense.integration.client;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.OffsetDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Represents an item history events (for example movement from one zone to another)
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemHistory {

  // Static members
  /**
   * Format for observation time - for example: 2015-04-28T23:29:54-0700
   */
  private static final DateTimeFormatter
      DATE_TIME_FORMAT =
      DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssXX");

  // Fields
  @JsonProperty
  String epc;

  @JsonProperty
  String tagId;

  @JsonProperty
  String fromZone;

  @JsonProperty
  String toZone;

  @JsonProperty
  ZonedDateTime observationTime;

  public static ItemHistory fromMap(Map map) {
    ItemHistory itemHistory = new ItemHistory();
    itemHistory.setEpc(getStringValueFromMap(map, "epc"));
    itemHistory.setTagId(getStringValueFromMap(map, "tagId"));
    itemHistory.setFromZone(getStringValueFromMap(map, "fromZone"));
    itemHistory.setToZone(getStringValueFromMap(map, "toZone"));
    String observationTime = getStringValueFromMap(map, "observationTime");
    try {
      itemHistory
          .setObservationTime(
              ZonedDateTime.parse(observationTime, DATE_TIME_FORMAT));
    } catch (DateTimeParseException e) {
      throw new RuntimeException("Malformed observationTime: " + observationTime, e);
    }
    return itemHistory;
  }

  /**
   * Gets a string value form the map.  Throws runtime exceptions if the key is missing or the value
   * is not a string.
   */
  private static String getStringValueFromMap(Map map, String key) {
    if (!map.containsKey(key)) {
      throw new RuntimeException("Malformed data set: \"" + key + "\" key is missing");
    }
    Object value = map.get(key);
    if (!(value instanceof String)) {
      throw new RuntimeException("Malformed data set: \"" + key + "\"is not a string");
    }
    return (String) value;
  }
}
