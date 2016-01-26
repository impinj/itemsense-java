package com.impinj.itemsense.client.data.itemhistory;

import com.google.gson.Gson;
import com.impinj.itemsense.client.helpers.RestApiHelper;
import com.impinj.itemsense.client.data.EpcFormat;
import com.impinj.itemsense.client.data.PresenceConfidence;

import javax.ws.rs.client.WebTarget;
import java.util.*;

/**
 * Created by jcombopi on 1/26/16.
 */
public class ItemHistoryController {

    private Gson gson;
    private WebTarget target;
    private RestApiHelper<ItemHistoryResponse> restApiHelper;

    public ItemHistoryController(final Gson gson, WebTarget target) {
        this.gson = gson;
        this.target = target;
        this.restApiHelper = new RestApiHelper<ItemHistoryResponse>(ItemHistoryResponse.class);
    }

    public ItemHistoryResponse getItemHistory(EpcFormat epcFormat, String epcPrefix, String fromZone, String toZone, String fromFacility, String toFacility, PresenceConfidence presenceConfidence, String facility,
                                              Integer pageSize, String pageMarker){
        HashMap<String, Object> queryParams =  new HashMap<>();
        if(epcPrefix != null && !epcPrefix.isEmpty()){
            queryParams.put("epcPrefix", epcPrefix);
        }
        if(fromZone != null && !fromZone.isEmpty()){
            queryParams.put("fromZone", fromZone);
        }
        if(toZone != null && !toZone.isEmpty()){
            queryParams.put("toZone", toZone);
        }
        if(fromFacility != null && !fromFacility.isEmpty()){
            queryParams.put("fromFacility", fromFacility);
        }
        if(toFacility != null && !toFacility.isEmpty()){
            queryParams.put("toFacility", toFacility);
        }
        if(presenceConfidence != null){
            queryParams.put("presenceConfidence", presenceConfidence.toString());
        }
        if(epcFormat != null){
            queryParams.put("epcFormat", epcFormat.toString());
        }
        if(facility != null && !facility.isEmpty()){
            queryParams.put("facility", facility);
        }

        if(pageMarker != null && !pageMarker.isEmpty()){
            queryParams.put("pageMarker", pageMarker);
        }
        if(pageSize != null ){
            queryParams.put("pageSize", pageSize);
        }

        return this.restApiHelper.get(queryParams,"/data/items/show/history", target, gson);

    }
    public ItemHistoryResponse getItemHistory(){
        return this.getItemHistory(null, null, null, null, null, null, null, null, null, null);
    }

    public Collection<ItemHistory> getAllItemHistory(EpcFormat epcFormat, String epcPrefix, String fromZone, String toZone, String fromFacility, String toFacility,  PresenceConfidence presenceConfidence, String facility,
                                        String pageMarker){
        ItemHistoryResponse response;
        String nextPageMarker = "";
        int pageSize = 1000;
        Collection<ItemHistory> items= new ArrayList<>();

        do{

            response = this.getItemHistory(epcFormat, epcPrefix, fromZone, toZone, fromFacility, toFacility, presenceConfidence, facility, pageSize, nextPageMarker);
            if(response.getHistory()!=null){
                Collections.addAll(items, response.getHistory());
            }
            nextPageMarker = response.getNextPageMarker();

        }while(nextPageMarker != null && !nextPageMarker.isEmpty());

        return items;
    }
    public Collection<ItemHistory> getAllItemHistory(EpcFormat epcFormat){
        return getAllItemHistory(epcFormat,  null, null, null,  null, null, null, null, null);
    }
    public Collection<ItemHistory> getAllItemHistory(){
        return getAllItemHistory(null, null, null, null, null, null, null, null, null);
    }

}
