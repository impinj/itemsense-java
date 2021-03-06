package com.impinj.itemsense.client.data.itemthresholdtransition;

import com.impinj.itemsense.client.data.EpcFormat;
import com.impinj.itemsense.client.helpers.RestApiHelper;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.apache.commons.lang3.StringUtils;


public class ItemThresholdTransitionController {

  private WebTarget target;

  public ItemThresholdTransitionController(WebTarget target) {
    this.target = target;
  }

  public Response getItemThresholdTransitionsAsResponse(Map<String, Object> queryParams) {
    return RestApiHelper.get(queryParams, target, "/data/v1/items/show/transitions");
  }

  public ItemThresholdTransitionResponse getItemThresholdTransitions(Map<String, Object> queryParams) {
    return this.getItemThresholdTransitionsAsResponse(queryParams)
        .readEntity(ItemThresholdTransitionResponse.class);
  }

  public ItemThresholdTransitionResponse getItemThresholdTransitions(
      String epcPrefix,
      String jobId,
      Integer thresholdId,
      String thresholdName,
      String destination,
      String facility,
      String fromTime,
      String toTime,
      EpcFormat epcFormat,
      String pageMarker,
      Integer pageSize,
      String alwaysIncludePageMarker
  ) {
    if (thresholdId != null && StringUtils.isNotEmpty(thresholdName)) {
      throw new IllegalArgumentException("Only one of threshold ID or threshold name may be used");
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
    if (thresholdId != null) {
      queryParams.put("thresholdId", thresholdId);
    }
    if (StringUtils.isNotEmpty(thresholdName)) {
      queryParams.put("thresholdName", thresholdName);
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

    return this.getItemThresholdTransitions(queryParams);
  }

  public ArrayList<ItemThresholdTransition> getAllItemThresholdTransitions(
      String epcPrefix,
      String jobId,
      Integer thresholdId,
      String thresholdName,
      String destination,
      String facility,
      String fromTime,
      String toTime,
      EpcFormat epcFormat
  ) {
    ItemThresholdTransitionResponse response;
    String nextPageMarker = "";
    int pageSize = 1000;
    ArrayList<ItemThresholdTransition> items = new ArrayList<>();

    do {
      response = this.getItemThresholdTransitions(
          epcPrefix,
          jobId,
          thresholdId,
          thresholdName,
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

  public ArrayList<ItemThresholdTransition> getAllItemThresholdTransitions(EpcFormat epcFormat) {
    return getAllItemThresholdTransitions(null, null, null, null, null, null, null, null, epcFormat);
  }

  public ArrayList<ItemThresholdTransition> getAllItemThresholdTransitions() {
    return getAllItemThresholdTransitions(null, null, null, null, null, null, null, null, null);
  }
}
