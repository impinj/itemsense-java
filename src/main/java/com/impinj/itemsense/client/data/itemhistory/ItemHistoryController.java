package com.impinj.itemsense.client.data.itemhistory;

import com.google.gson.Gson;
import com.impinj.itemsense.client.RestApiHelper;
import com.impinj.itemsense.client.data.EpcFormat;
import com.impinj.itemsense.client.data.PresenceConfidence;
import com.impinj.itemsense.client.data.item.Item;

import javax.ws.rs.client.WebTarget;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

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

    public ItemHistoryResponse getItemHistory(EpcFormat epcFormat, String epcPrefix, String fromZone, String toZone, PresenceConfidence presenceConfidence, String facility,
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

        return this.restApiHelper.get(queryParams,"/data/items/show", target, gson);

    }
    public ItemHistoryResponse getItemHistory(){
        return this.getItemHistory(null, null, null, null, null, null, null, null);
    }

    public Collection<Item> getAllItemHistory(EpcFormat epcFormat, String epcPrefix, String fromZone, String toZone, PresenceConfidence presenceConfidence, String facility,
                                        String pageMarker){
        ItemHistoryResponse response;
        int pageSize = 1000;
        Collection<Item> items= new ArrayList<Item>();

        do{
            response = this.getItemHistory(epcPrefix, fromZone, toZone, presenceConfidence, epcFormat, facility, pageSize, response.getNextPageMarker());
            if(response.getItemHistory()!=null){
                items.addAll(response.getItemHistory());
            }
        }while(response.getNextPageMarker() != null && !response.getNextPageMarker().isEmpty());

        return items;
    }
    public Collection<Item> getAllItemHistory(EpcFormat epcFormat){
        return getAllItemHistory(epcFormat, null, null, null,null, null, null);
    }
    public Collection<Item> getAllItemHistory(){
        return getAllItemHistory(null, null, null, null, null, null, null);
    }

}
