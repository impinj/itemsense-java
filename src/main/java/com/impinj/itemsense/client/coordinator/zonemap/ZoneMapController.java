package com.impinj.itemsense.client.coordinator.zonemap;

import com.google.gson.Gson;
import com.impinj.itemsense.client.helpers.RestApiHelper;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by jcombopi on 1/25/16.
 */
public class ZoneMapController {

    private Gson gson;
    private WebTarget target;
    private RestApiHelper<ZoneMap> restApiHelper;

    public ZoneMapController(final Gson gson, WebTarget target) {
        this.gson = gson;
        this.target = target;
        this.restApiHelper = new RestApiHelper<ZoneMap>(ZoneMap.class);
    }

    public ZoneMap createZoneMap(ZoneMap zoneMap) {
        return this.restApiHelper.post(zoneMap, "/configuration/v1/zoneMaps/create", target, gson);
    }

    public ZoneMap updateZoneMap(ZoneMap zoneMap) {
        return this.restApiHelper.put(zoneMap, "/configuration/v1/zoneMaps/create", target, gson);
    }

    public Response deleteZoneMap(String zoneMapName) {
        return this.restApiHelper.delete(zoneMapName, "/configuration/v1/zoneMaps/destroy", target);
    }

    public ZoneMap getZoneMap(String zoneMapName) {
        return this.restApiHelper.get(zoneMapName, "/configuration/v1/zoneMaps/show", target);
    }

    public ArrayList<ZoneMap> getZoneMaps() {
        return this.restApiHelper.getMultiple(null, "/configuration/v1/zoneMaps/show", target, gson);
    }


}
