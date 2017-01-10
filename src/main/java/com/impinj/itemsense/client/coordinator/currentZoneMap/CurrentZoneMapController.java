package com.impinj.itemsense.client.coordinator.currentZoneMap;

import com.impinj.itemsense.client.helpers.RestApiHelper;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

public class CurrentZoneMapController {

    private static final String BASE_PATH = "/configuration/v1/currentZoneMap";
    private WebTarget target;
    private RestApiHelper<CurrentZoneMap> restApiHelper;


    public CurrentZoneMapController(WebTarget target) {
        this.target = target;
        this.restApiHelper = new RestApiHelper<CurrentZoneMap>();
    }

    public Response setCurrentZoneMapAsResponse(String zoneMapName){
        return this.restApiHelper.post(target, BASE_PATH, "select", zoneMapName);
    }

    public CurrentZoneMap setCurrentZoneMap(String zoneMapName) {
        return setCurrentZoneMapAsResponse(zoneMapName).readEntity(CurrentZoneMap.class);
    }

    public Response clearCurrentZoneMap() {
        return this.restApiHelper.delete(target, BASE_PATH, "clear");
    }

    public Response clearCurrentZoneMap(String facility) {
        return this.restApiHelper.delete(target, BASE_PATH, "clear", facility);
    }

    public Response getCurrentZoneMapAsResponse(String facility){
        if(facility != null && !facility.isEmpty()){
            return this.restApiHelper.get(target, BASE_PATH, "show", facility);
        }
        else{
            return this.restApiHelper.get(target, BASE_PATH, "show");
        }
    }

    public CurrentZoneMap getCurrentZoneMap(String facility) {
       return getCurrentZoneMapAsResponse(facility).readEntity(CurrentZoneMap.class);
    }

    public CurrentZoneMap getCurrentZoneMap() {
        return getCurrentZoneMapAsResponse(null).readEntity(CurrentZoneMap.class);
    }
}
