package com.impinj.itemsense.client.coordinator.zonemap;

import com.google.gson.Gson;
import com.impinj.itemsense.client.helpers.RestApiHelper;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
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
        return this.restApiHelper.post(zoneMap, "/configuration/zoneMaps/create", target, gson);
    }

    public ZoneMap updateZoneMap(ZoneMap zoneMap) {
        return this.restApiHelper.put(zoneMap, "/configuration/zoneMaps/create", target, gson);
    }

    public Response deleteZoneMap(String zoneMapName) {
        return this.restApiHelper.delete(zoneMapName, "/configuration/zoneMaps/destroy", target);
    }

    public ZoneMap getZoneMap(String zoneMapName) {
        return this.restApiHelper.get(zoneMapName, "/configuration/zoneMaps/show", target);
    }

    public Collection<ZoneMap> getZoneMaps() {
        return this.restApiHelper.getMultiple(null, "/configuration/zoneMaps/show", target, gson);
    }


}
