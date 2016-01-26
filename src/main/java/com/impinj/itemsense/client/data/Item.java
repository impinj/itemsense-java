/*******************************************************************************
 * IMPINJ CONFIDENTIAL AND PROPRIETARY
 *
 * This source code is the sole property of Impinj, Inc. Reproduction or utilization of this source
 * code in whole or in part is forbidden without the prior written consent of Impinj, Inc.
 *
 * (c) Copyright Impinj, Inc. 2015. All rights reserved.
 ******************************************************************************/

package com.impinj.itemsense.client.data;

import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Item {
  private String lastModifiedTime;
  private String epc;
  private Confidence presenceConfidence;
  private Double xLocation;
  private Double yLocation;
  private Double zLocation;
  private String zone;
  private String tagId;

  public static Item fromMap(final Map map) {
    final Item item = new Item();
    item.setLastModifiedTime((String) map.get("lastModifiedTime"));
    item.setEpc((String) map.get("epc"));
    item.setPresenceConfidence(Confidence.valueOf((String) map.get("presenceConfidence")));
    item.setXLocation((Double) map.get("xLocation"));
    item.setYLocation((Double) map.get("yLocation"));
    item.setZLocation((Double) map.get("zLocation"));
    item.setZone((String) map.get("zone"));
    item.setTagId((String) map.get("tagId"));

    return item;
  }

  public String getEpc() {
    if (null == epc) {
      return null;
    }
    final String[] tokens = epc.split(".");
    if (tokens.length < 2) {
      // it looks like epc can be either raw URI or just the hex string depending on where it came
      // from.
      return epc;
    }
    return tokens[1];
  }

}
