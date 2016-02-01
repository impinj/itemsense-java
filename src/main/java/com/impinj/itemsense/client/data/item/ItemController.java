package com.impinj.itemsense.client.data.item;

import com.google.gson.Gson;
import com.impinj.itemsense.client.helpers.RestApiHelper;
import com.impinj.itemsense.client.data.EpcFormat;
import com.impinj.itemsense.client.data.PresenceConfidence;


import javax.ws.rs.client.WebTarget;
import java.util.*;

/**
 * Created by jcombopi on 1/26/16.
 */
public class ItemController {
    private Gson gson;
    private WebTarget target;
    private RestApiHelper<ItemResponse> restApiHelper;

    public ItemController(final Gson gson, WebTarget target) {
        this.gson = gson;
        this.target = target;
        this.restApiHelper = new RestApiHelper<ItemResponse>(ItemResponse.class);
    }

    public ItemResponse getItems(EpcFormat epcFormat, String epcPrefix, String zoneNames, PresenceConfidence presenceConfidence, String facility,
                                 Integer pageSize, String pageMarker) {
        HashMap<String, Object> queryParams = new HashMap<>();
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

        return this.restApiHelper.get(queryParams, "/data/v1/items/show", target, gson);

    }

    public ItemResponse getItems() {
        return this.getItems(null, null, null, null, null, null, null);
    }

    public ArrayList<Item> getAllItems(EpcFormat epcFormat, String epcPrefix, String zoneNames, PresenceConfidence presenceConfidence, String facility,
                                        String pageMarker) {
        ItemResponse response;
        String nextPageMarker = null    ;
        int pageSize = 1000;
        ArrayList<Item> items = new ArrayList<Item>();

        do {
            response = this.getItems(epcFormat, epcPrefix, zoneNames, presenceConfidence, facility, pageSize, nextPageMarker);
            if (response.getItems() != null) {
                Collections.addAll(items, response.getItems());
            }
            nextPageMarker = response.getNextPageMarker();
        } while (nextPageMarker != null && !nextPageMarker.isEmpty());

        return items;
    }

    public ArrayList<Item> getAllItems(EpcFormat epcFormat) {
        return getAllItems(epcFormat, null, null, null, null, null);
    }

    public ArrayList<Item> getAllItems() {
        return getAllItems(null, null, null, null, null, null);
    }


}
