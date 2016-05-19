package com.impinj.itemsense.client.coordinator.zonemap;

import com.impinj.itemsense.client.helpers.RestApiHelper;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.Arrays;


/**
 * Created by jcombopi on 1/25/16.
 */
public class ZoneMapController {

    private WebTarget target;
    private RestApiHelper<ZoneMap> restApiHelper;

    public ZoneMapController( WebTarget target) {
        this.target = target;
        this.restApiHelper = new RestApiHelper<ZoneMap>(ZoneMap.class);
    }

    public ZoneMap createZoneMap(ZoneMap zoneMap) {
       return this.createZoneMapAsResponse(zoneMap).readEntity(ZoneMap.class);
    }

    public ZoneMap updateZoneMap(ZoneMap zoneMap) {
        return this.updateZoneMapAsResponse(zoneMap).readEntity(ZoneMap.class);
    }

    public Response deleteZoneMap(String zoneMapName) {
        return this.restApiHelper.delete(zoneMapName, "/configuration/v1/zoneMaps/destroy", target);
    }

    public ZoneMap getZoneMap(String zoneMapName) {
        return this.getZoneMapAsResponse(zoneMapName).readEntity(ZoneMap.class);
    }

    public ArrayList<ZoneMap> getZoneMaps() {
        ZoneMap[] zoneMaps = this.getZoneMapsAsResponse().readEntity(ZoneMap[].class);
        return new ArrayList<ZoneMap>(Arrays.asList(zoneMaps));
    }

    public Response createZoneMapAsResponse(ZoneMap zoneMap) {
        return this.restApiHelper.post(zoneMap, "/configuration/v1/zoneMaps/create", target);
    }

    public Response updateZoneMapAsResponse(ZoneMap zoneMap) {
        return this.restApiHelper.put(zoneMap, "/configuration/v1/zoneMaps/create", target);
    }

    public Response getZoneMapAsResponse(String zoneMapName) {
        return this.restApiHelper.get(zoneMapName, "/configuration/v1/zoneMaps/show", target);
    }

    public Response getZoneMapsAsResponse() {
        return this.restApiHelper.get("/configuration/v1/zoneMaps/show", target);
    }


}
