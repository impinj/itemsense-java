package com.impinj.itemsense.client.data.item;

import com.impinj.itemsense.client.data.EpcFormat;
import com.impinj.itemsense.client.data.PresenceConfidence;
import com.impinj.itemsense.client.helpers.RestApiHelper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;


public class ItemController {
    private static final String BASE_PATH = "/data/v1/items";
    private WebTarget target;

    public ItemController(WebTarget target) {
        this.target = target;
    }

    public Response getItemsAsResponse(Map<String, Object> queryParams) {
        return RestApiHelper.get(queryParams, target, BASE_PATH, "show");
    }

    public ItemResponse getItems(Map<String, Object> queryParams) {
        return getItemsAsResponse(queryParams).readEntity(ItemResponse.class);
    }

    public ItemResponse getItems(EpcFormat epcFormat,
                                 String epcPrefix,
                                 String zoneNames,
                                 PresenceConfidence presenceConfidence,
                                 String facility,
                                 Integer pageSize,
                                 String pageMarker,
                                 String fromTime,
                                 String toTime) {
        Map<String, Object> queryParams = new HashMap<>();
        if (epcPrefix != null && !epcPrefix.isEmpty()) {
            queryParams.put("epcPrefix", epcPrefix);
        }
        if (zoneNames != null && !zoneNames.isEmpty()) {
            queryParams.put("zoneNames", zoneNames);
        }
        if (presenceConfidence != null) {
            queryParams.put("presenceConfidence", presenceConfidence.toString());
        }
        if (epcFormat != null) {
            queryParams.put("epcFormat", epcFormat.toString());
        }
        if (facility != null && !facility.isEmpty()) {
            queryParams.put("facility", facility);
        }
        if (pageMarker != null && !pageMarker.isEmpty()) {
            queryParams.put("pageMarker", pageMarker);
        }
        if (pageSize != null) {
            queryParams.put("pageSize", pageSize);
        }
        if (fromTime != null) {
            queryParams.put("fromTime", fromTime);
        }
        if (toTime != null) {
            queryParams.put("toTime", toTime);
        }

        return this.getItems(queryParams);
    }

    public ItemResponse getItems(EpcFormat epcFormat,
                                 String epcPrefix,
                                 String zoneNames,
                                 PresenceConfidence presenceConfidence,
                                 String facility,
                                 Integer pageSize,
                                 String pageMarker) {
        return getItems(epcFormat, epcPrefix, zoneNames, presenceConfidence, facility, pageSize, pageMarker, null, null);
    }

    public ItemResponse getItems() {
        return this.getItems(null);
    }


    public ArrayList<Item> getAllItems(EpcFormat epcFormat,
                                       String epcPrefix,
                                       String zoneNames,
                                       PresenceConfidence presenceConfidence,
                                       String facility,
                                       String fromTime,
                                       String toTime) {
        ItemResponse response;
        String nextPageMarker = null;
        int pageSize = 1000;
        ArrayList<Item> items = new ArrayList<Item>();

        do {
            response = this.getItems(epcFormat, epcPrefix, zoneNames, presenceConfidence, facility, pageSize, nextPageMarker, fromTime, toTime);
            if (response.getItems() != null) {
                Collections.addAll(items, response.getItems());
            }
            nextPageMarker = response.getNextPageMarker();
        } while (nextPageMarker != null && !nextPageMarker.isEmpty());

        return items;
    }

    // This is deprecated because pageMarker is not used.
    // Will be removed in a future release, and its functionality moved into the method
    // without this parameter
    @Deprecated
    public ArrayList<Item> getAllItems(EpcFormat epcFormat,
                                       String epcPrefix,
                                       String zoneNames,
                                       PresenceConfidence presenceConfidence,
                                       String facility,
                                       String pageMarker) {
        return getAllItems(epcFormat, epcPrefix, zoneNames, presenceConfidence, facility, null, null);
    }

    public ArrayList<Item> getAllItems(EpcFormat epcFormat,
                                       String epcPrefix,
                                       String zoneNames,
                                       PresenceConfidence presenceConfidence,
                                       String facility) {
        return getAllItems(epcFormat, epcPrefix, zoneNames, presenceConfidence, facility, null, null);
    }

    public ArrayList<Item> getAllItems(EpcFormat epcFormat) {
        HashMap<String, Object> queryParams = new HashMap<>();
        if (epcFormat != null) {
            queryParams.put("epcFormat", epcFormat.toString());
        }
        return getAllItems(epcFormat, null, null, null, null, null, null);
    }

    public ArrayList<Item> getAllItems() {
        return getAllItems(null, null, null, null, null, null, null);
    }


}
