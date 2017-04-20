package com.impinj.itemsense.client.data.itemdoortransition;

import com.impinj.itemsense.client.data.EpcFormat;
import com.impinj.itemsense.client.helpers.RestApiHelper;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.apache.commons.lang3.StringUtils;


public class ItemDoorTransitionController {

  private WebTarget target;

  public ItemDoorTransitionController(WebTarget target) {
    this.target = target;
  }

  public Response getItemDoorTransitionsAsResponse(Map<String, Object> queryParams) {
    return RestApiHelper.get(queryParams, target, "/data/v1/items/show/transitions");
  }

  public ItemDoorTransitionResponse getItemDoorTransitions(Map<String, Object> queryParams) {
    return this.getItemDoorTransitionsAsResponse(queryParams)
        .readEntity(ItemDoorTransitionResponse.class);
  }

  public ItemDoorTransitionResponse getItemDoorTransitions(
      String epcPrefix,
      String jobId,
      Integer doorId,
      String doorName,
      String destination,
      String facility,
      String fromTime,
      String toTime,
      EpcFormat epcFormat,
      String pageMarker,
      Integer pageSize,
      String alwaysIncludePageMarker
  ) {
    if (doorId != null && StringUtils.isNotEmpty(doorName)) {
      throw new IllegalArgumentException("Only one of door ID or door name may be used");
    }

    HashMap<String, Object> queryParams = new HashMap<>();
    if (epcFormat != null) {
      queryParams.put("epcFormat", epcFormat.toString());
    }
    if (StringUtils.isNotEmpty(epcPrefix)) {
      queryParams.put("epcPrefix", epcPrefix);
    }
    if (StringUtils.isNotEmpty(jobId)) {
      queryParams.put("jobId", jobId);
    }
    if (doorId != null) {
      queryParams.put("doorId", doorId);
    }
    if (StringUtils.isNotEmpty(doorName)) {
      queryParams.put("doorName", doorName);
    }
    if (StringUtils.isNotEmpty(destination)) {
      queryParams.put("destination", destination);
    }
    if (StringUtils.isNotEmpty(facility)) {
      queryParams.put("facility", facility);
    }
    if (StringUtils.isNotEmpty(fromTime)) {
      queryParams.put("fromTime", fromTime);
    }
    if (StringUtils.isNotEmpty(toTime)) {
      queryParams.put("toTime", toTime);
    }
    if (StringUtils.isNotEmpty(pageMarker)) {
      queryParams.put("pageMarker", pageMarker);
    }
    if (pageSize != null) {
      queryParams.put("pageSize", pageSize);
    }
    if (StringUtils.isNotEmpty(alwaysIncludePageMarker)) {
      queryParams.put("alwaysIncludePageMarker", alwaysIncludePageMarker);
    }

    return this.getItemDoorTransitions(queryParams);
  }

  public ArrayList<ItemDoorTransition> getAllItemDoorTransitions(
      String epcPrefix,
      String jobId,
      Integer doorId,
      String doorName,
      String destination,
      String facility,
      String fromTime,
      String toTime,
      EpcFormat epcFormat
  ) {
    ItemDoorTransitionResponse response;
    String nextPageMarker = "";
    int pageSize = 1000;
    ArrayList<ItemDoorTransition> items = new ArrayList<>();

    do {
      response = this.getItemDoorTransitions(
          epcPrefix,
          jobId,
          doorId,
          doorName,
          destination,
          facility,
          fromTime,
          toTime,
          epcFormat,
          nextPageMarker,
          pageSize,
          null);
      if (response.getTransitions() != null) {
        Collections.addAll(items, response.getTransitions());
      }
      nextPageMarker = response.getNextPageMarker();

    } while (StringUtils.isNotEmpty(nextPageMarker));

    return items;
  }

  public ArrayList<ItemDoorTransition> getAllItemDoorTransitions(EpcFormat epcFormat) {
    return getAllItemDoorTransitions(null, null, null, null, null, null, null, null, epcFormat);
  }

  public ArrayList<ItemDoorTransition> getAllItemDoorTransitions() {
    return getAllItemDoorTransitions(null, null, null, null, null, null, null, null, null);
  }
}
