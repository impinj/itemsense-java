/**
 * IMPINJ CONFIDENTIAL AND PROPRIETARY
 *
 * This source code is the sole property of Impinj, Inc. Reproduction or utilization of this source
 * code in whole or in part is forbidden without the prior written consent of Impinj, Inc.
 *
 * (c) Copyright Impinj, Inc. 2015. All rights reserved.
 */

package com.impinj.itemsense.integration.client;

import java.net.URI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;

import lombok.NonNull;
import lombok.extern.log4j.Log4j;


/**
 * Helpers for working with the Item Rest service. Works directly with wadl2java generated client
 * code.
 */
@Log4j
public class ItemApiLib {

  private final Gson gson;
  public static final int MAXIMUM_PAGE_SIZE = 1000;
  private final WebTarget target;

  /**
   * Constructor
   *
   * @param gson Gson instance
   * @param client Jersey client
   * @param uri the base URI for the items service
   */
  public ItemApiLib(final Gson gson, final Client client, final URI uri) {
    this.gson = gson;
    target = client.target(uri);
  }

  /**
   * Gets every item from the Query API.
   *
   * @return A collection of Item objects.
   */
  public Collection<Item> showAllItems(final String epcFormat) {
    // Iterate through all pages of results, building a list of items
    final Collection<Item> itemsList = new ArrayList<>();
    String pageMarker = null;
    do {
      final Map result =
          sendShowItemsRequest(null, null, null, epcFormat, pageMarker, MAXIMUM_PAGE_SIZE);
      getItemsFromResultSet(result, itemsList);
      pageMarker =
          result.containsKey("nextPageMarker") ? (String) result.get("nextPageMarker") : null;
    } while (pageMarker != null);

    return itemsList;
  }

  /**
   * Returns a list of items based on the specified query parameters
   *
   * @param epcPrefix A hexadecimal string representing an EPC prefix of an item. Only the items
   *        with EPCs that start with this prefix will be returned.
   * @param zoneNames A comma-separated list of zone IDs. Only items in these zones will be
   *        returned.
   * @param confidence A confidence level (HIGH / LOW) Only items with this confidence level will be
   *        returned.
   * @param pageMarker A string indicating which page of results to return. A new marker is returned
   *        after each query and can be used to fetch subsequent pages.When using a page marker, the
   *        other query parameters must be the same as those used in the previous query.
   * @param maximumPageSize The maximum number of records to return per query.
   * @return A collection of Item objects.
   */
  public Collection<Item> showItems(final String epcPrefix, final String zoneNames,
      final String confidence, final String epcFormat, final String pageMarker,
      @NonNull final Integer maximumPageSize) {
    final Map result = sendShowItemsRequest(epcPrefix, zoneNames, confidence, epcFormat, pageMarker,
        maximumPageSize);
    final Collection<Item> itemsList = new ArrayList<>();
    getItemsFromResultSet(result, itemsList);
    return itemsList;
  }

  private Map sendShowItemsRequest(final String epcPrefix, final String zoneNames,
      final String confidence, final String epcFormat, final String pageMarker,
      @NonNull final Integer maximumPageSize) {
    log.debug("Sending /items/show request, epcPrefix=" + epcPrefix + ", zoneNames=" + zoneNames
        + ", confidence=" + confidence + ", epcFormat=" + epcFormat + ", pageMarker=" + pageMarker
        + ", maximumPageSize=" + maximumPageSize);
    final String response = target.path("data/items/show").queryParam("epcPrefix", epcPrefix)
        .queryParam("zoneNames", zoneNames).queryParam("confidence", confidence)
        .queryParam("pageMarker", pageMarker).queryParam("epcFormat", epcFormat)
        .queryParam("maximumPageSize", maximumPageSize).request(MediaType.APPLICATION_JSON_TYPE)
        .get(String.class);
    log.trace("/items/show response: " + response);
    return gson.fromJson(response, Map.class);
  }

  /**
   * Returns item history based on the specified query parameters
   *
   * @param epcPrefix A hexadecimal string representing the EPC prefix of an item. Only items that
   *        start with this EPC prefix will be returned
   * @param fromZone A string zone identifier, such as "Men's Department". This parameter identifies
   *        the zone that the item moved out of.
   * @param toZone A string zone identifier, such as "Men's Department". This parameter identifies
   *        the zone that the item moved into.
   * @param fromTime Events which occurred on or after this time will be returned.
   * @param toTime Events which occurred before this time will be returned.
   * @param pageMarker A string indicating which page of results to return. A new marker is returned
   *        after each query and can be used to fetch subsequent pages. When using a page marker,
   *        the other query parameters must be the same as those used in the previous query.
   * @param maximumPageSize The maximum number of records to return per query.
   * @return A list of ItemHistory objects
   */
  public List<ItemHistory> showItemHistory(final String epcPrefix, final String fromZone,
      final String toZone, final String fromTime, final String toTime, final String pageMarker,
      @NonNull final Integer maximumPageSize) {
    log.debug(String.format(
        "Sending /items/show/history request, epcPrefix=%s, fromZone=%s, "
            + "toZone=%s, fromTime=%s, toTime=%s, pageMarker=%s, maximumPageSize=%s",
        epcPrefix, fromZone, toZone, fromTime, toTime, pageMarker, maximumPageSize));
    final String response = target.path("items/show/history").queryParam("epcPrefix", epcPrefix)
        .queryParam("fromZone", fromZone).queryParam("toZone", toZone)
        .queryParam("fromTime", fromTime).queryParam("toTime", toTime)
        .queryParam("maximumPageSize", maximumPageSize).request(MediaType.APPLICATION_JSON_TYPE)
        .get(String.class);

    log.trace("/items/show/history response: " + response);
    final Map result = gson.fromJson(response, Map.class);

    // TODO: Create a POJO to represent this data:
    if (!result.containsKey("history")) {
      throw new RuntimeException("Malformed result set: \"history\" key is missing");
    }
    final Object history = result.get("history");
    if (!(history instanceof List)) {
      throw new RuntimeException("Malformed result set: \"history\" is not a list");
    }
    final List<ItemHistory> itemHistoryList = new ArrayList<>();
    for (final Object itemHistory : (List) history) {
      if (!(itemHistory instanceof Map)) {
        throw new RuntimeException("Malformed result set: item is not a map");
      }
      itemHistoryList.add(ItemHistory.fromMap((Map) itemHistory));
    }
    return itemHistoryList;
  }


  /**
   * Extracts the items from the result set and builds a list of Item objects. This method expects
   * the result set to key called "items" with a list of maps (representing each individual item).
   *
   * @param result The result set from an API query
   * @param itemsList The list to add the items to
   */
  private void getItemsFromResultSet(final Map result, final Collection<Item> itemsList) {
    if (!result.containsKey("items")) {
      throw new RuntimeException("Malformed result set: \"items\" key is missing");
    }
    final Object items = result.get("items");
    if (!(items instanceof List)) {
      throw new RuntimeException("Malformed result set: \"items\" is not a list");
    }
    for (final Object item : (List) items) {
      if (!(item instanceof Map)) {
        throw new RuntimeException("Malformed result set: item is not a map");
      }
      itemsList.add(Item.fromMap((Map) item));
    }
  }
}
