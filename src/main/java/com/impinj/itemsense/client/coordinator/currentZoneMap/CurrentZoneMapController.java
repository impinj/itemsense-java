package com.impinj.itemsense.client.coordinator.currentZoneMap;

import com.impinj.itemsense.client.helpers.RestApiHelper;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

/**
 * Created by jcombopi on 1/26/16.
 */
public class CurrentZoneMapController {

    private WebTarget target;
    private RestApiHelper<CurrentZoneMap> restApiHelper;


    public CurrentZoneMapController(WebTarget target) {
        this.target = target;
        this.restApiHelper = new RestApiHelper<CurrentZoneMap>(CurrentZoneMap.class);
    }

    public Response setCurrentZoneMapAsResponse(String zoneMapName){
        return this.restApiHelper.post(null, "/configuration/v1/currentZoneMap/select/" + zoneMapName, target);
    }

    public CurrentZoneMap setCurrentZoneMap(String zoneMapName) {
        return setCurrentZoneMapAsResponse(zoneMapName).readEntity(CurrentZoneMap.class);
    }

    public Response clearCurrentZoneMap() {
        return this.restApiHelper.delete("", "/configuration/v1/currentZoneMap/clear", target);
    }

    public Response clearCurrentZoneMap(String facility) {
        return this.restApiHelper.delete(facility, "/configuration/v1/currentZoneMap/clear", target);
    }

    public Response getCurrentZoneMapAsResponse(String facility){
        if(facility != null && !facility.isEmpty()){
            return this.restApiHelper.get(facility, "/configuration/v1/currentZoneMap/show", target);
        }
        else{
            return this.restApiHelper.get( "/configuration/v1/currentZoneMap/show", target);
        }
    }

    public CurrentZoneMap getCurrentZoneMap(String facility) {
       return getCurrentZoneMapAsResponse(facility).readEntity(CurrentZoneMap.class);
    }

    public CurrentZoneMap getCurrentZoneMap() {
        return getCurrentZoneMapAsResponse(null).readEntity(CurrentZoneMap.class);
    }
}
