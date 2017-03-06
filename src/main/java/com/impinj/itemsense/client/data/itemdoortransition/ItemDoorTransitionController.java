package com.impinj.itemsense.client.data.itemdoortransition;

import com.impinj.itemsense.client.data.EpcFormat;
import com.impinj.itemsense.client.helpers.RestApiHelper;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;


public class ItemDoorTransitionController {

    private WebTarget target;

    public ItemDoorTransitionController(WebTarget target) {
        this.target = target;
    }

    public Response getItemDoorTransitionsAsResponse(Map<String, Object> queryParams) {
        return RestApiHelper.get(queryParams, target, "/data/v1/items/show/transitions");
    }

    public ItemDoorTransitionResponse getItemDoorTransitions(Map<String, Object> queryParams) {
        return this.getItemDoorTransitionsAsResponse(queryParams).readEntity(ItemDoorTransitionResponse.class);
    }

    public ItemDoorTransitionResponse getItemDoorTransitions(
        EpcFormat epcFormat,
        String epcPrefix,
        String destination,
        String fromTime,
        String toTime,
        Integer pageSize,
        String pageMarker,
        String alwaysIncludePageMarker
    ) {
        HashMap<String, Object> queryParams = new HashMap<>();
        if (epcFormat != null) {
            queryParams.put("epcFormat", epcFormat.toString());
        }
        if (epcPrefix != null && !epcPrefix.isEmpty()) {
            queryParams.put("epcPrefix", epcPrefix);
        }
        if (destination != null && !destination.isEmpty()) {
            queryParams.put("destination", destination);
        }
        if (fromTime != null && !fromTime.isEmpty()) {
            queryParams.put("fromTime", fromTime);
        }
        if (toTime != null && !toTime.isEmpty()) {
            queryParams.put("toTime", toTime);
        }
        if (pageMarker != null && !pageMarker.isEmpty()) {
            queryParams.put("pageMarker", pageMarker);
        }
        if (pageSize != null) {
            queryParams.put("pageSize", pageSize);
        }
        if (alwaysIncludePageMarker != null && !alwaysIncludePageMarker.isEmpty()) {
            queryParams.put("alwaysIncludePageMarker", alwaysIncludePageMarker);
        }

        return this.getItemDoorTransitions(queryParams);
    }

    public ArrayList<ItemDoorTransition> getAllItemDoorTransitions(EpcFormat epcFormat,
                                                    String epcPrefix,
                                                    String destination,
                                                    String fromTime,
                                                    String toTime) {
        ItemDoorTransitionResponse response;
        String nextPageMarker = "";
        int pageSize = 1000;
        ArrayList<ItemDoorTransition> items = new ArrayList<>();

        do {
            response = this.getItemDoorTransitions(epcFormat, epcPrefix, destination, fromTime, toTime, pageSize, nextPageMarker, null);
            if (response.getTransitions() != null) {
                Collections.addAll(items, response.getTransitions());
            }
            nextPageMarker = response.getNextPageMarker();

        } while (nextPageMarker != null && !nextPageMarker.isEmpty());

        return items;
    }

    public ArrayList<ItemDoorTransition> getAllItemDoorTransitions(EpcFormat epcFormat) {
        return getAllItemDoorTransitions(epcFormat, null, null, null, null);
    }

    public ArrayList<ItemDoorTransition> getAllItemDoorTransitions() {
        return getAllItemDoorTransitions(null, null, null, null, null);
    }
}
