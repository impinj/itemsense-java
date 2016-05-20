package com.impinj.itemsense.client.data.itemhistory;

import com.impinj.itemsense.client.data.EpcFormat;
import com.impinj.itemsense.client.data.PresenceConfidence;
import com.impinj.itemsense.client.helpers.RestApiHelper;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 * Created by jcombopi on 1/26/16.
 */
public class ItemHistoryController {

    private WebTarget target;
    private RestApiHelper<ItemHistoryResponse> restApiHelper;

    public ItemHistoryController(WebTarget target) {
        this.target = target;
        this.restApiHelper = new RestApiHelper<ItemHistoryResponse>(ItemHistoryResponse.class);
    }

    public Response getItemHistoryAsResponse(HashMap<String, Object> queryParams){
        return this.restApiHelper.get(queryParams, "/data/v1/items/show/history", target);
    }

    public ItemHistoryResponse getItemHistory(HashMap<String, Object> queryParams){
        return getItemHistoryAsResponse(queryParams).readEntity(ItemHistoryResponse.class);
    }

    public ItemHistoryResponse getItemHistory(EpcFormat epcFormat, String epcPrefix, String fromZone, String toZone, String fromFacility, String toFacility, PresenceConfidence presenceConfidence, String facility,
                                              Integer pageSize, String pageMarker) {
        HashMap<String, Object> queryParams = new HashMap<>();
        if (epcPrefix != null && !epcPrefix.isEmpty()) {
            queryParams.put("epcPrefix", epcPrefix);
        }
        if (fromZone != null && !fromZone.isEmpty()) {
            queryParams.put("fromZone", fromZone);
        }
        if (toZone != null && !toZone.isEmpty()) {
            queryParams.put("toZone", toZone);
        }
        if (fromFacility != null && !fromFacility.isEmpty()) {
            queryParams.put("fromFacility", fromFacility);
        }
        if (toFacility != null && !toFacility.isEmpty()) {
            queryParams.put("toFacility", toFacility);
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

        return this.getItemHistory(queryParams);

    }

    public ItemHistoryResponse getItemHistory() {
        return this.getItemHistory(null);
    }

    public ArrayList<ItemHistory> getAllItemHistory(EpcFormat epcFormat, String epcPrefix, String fromZone, String toZone, String fromFacility, String toFacility, PresenceConfidence presenceConfidence, String facility,
                                                     String pageMarker) {
        ItemHistoryResponse response;
        String nextPageMarker = "";
        int pageSize = 1000;
        ArrayList<ItemHistory> items = new ArrayList<>();

        do {

            response = this.getItemHistory(epcFormat, epcPrefix, fromZone, toZone, fromFacility, toFacility, presenceConfidence, facility, pageSize, nextPageMarker);
            if (response.getHistory() != null) {
                Collections.addAll(items, response.getHistory());
            }
            nextPageMarker = response.getNextPageMarker();

        } while (nextPageMarker != null && !nextPageMarker.isEmpty());

        return items;
    }

    public ArrayList<ItemHistory> getAllItemHistory(EpcFormat epcFormat) {
        return getAllItemHistory(epcFormat, null, null, null, null, null, null, null, null);
    }

    public ArrayList<ItemHistory> getAllItemHistory() {
        return getAllItemHistory(null, null, null, null, null, null, null, null, null);
    }

}
