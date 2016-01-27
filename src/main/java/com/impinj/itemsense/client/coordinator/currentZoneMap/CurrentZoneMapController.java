package com.impinj.itemsense.client.coordinator.currentZoneMap;

import com.google.gson.Gson;
import com.impinj.itemsense.client.helpers.RestApiHelper;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

/**
 * Created by jcombopi on 1/26/16.
 */
public class CurrentZoneMapController {
    private Gson gson;
    private WebTarget target;
    private RestApiHelper<CurrentZoneMap> restApiHelper;


    public CurrentZoneMapController(final Gson gson, WebTarget target) {
        this.gson = gson;
        this.target = target;
        this.restApiHelper = new RestApiHelper<CurrentZoneMap>(CurrentZoneMap.class);
    }

    public CurrentZoneMap setCurrentZoneMap(String zoneMapName) {
        return this.restApiHelper.post(null, "/configuration/currentZoneMap/select/" + zoneMapName, target, gson);
    }

    public Response clearCurrentZoneMap() {
        return this.restApiHelper.delete("", "/configuration/currentZoneMap/clear", target);
    }

    public Response clearCurrentZoneMap(String facility) {
        return this.restApiHelper.delete(facility, "/configuration/currentZoneMap/clear", target);
    }

    public CurrentZoneMap getCurrentZoneMap(String facility) {
        return this.restApiHelper.get(facility, "/configuration/currentZoneMap/show", target);
    }

    public CurrentZoneMap[] getCurrentZoneMaps() {
        return this.restApiHelper.getMultiple(null, "/configuration/currentZoneMap/show", target, gson);
    }
}
