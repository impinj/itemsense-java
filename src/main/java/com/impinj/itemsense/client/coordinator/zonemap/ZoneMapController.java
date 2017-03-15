package com.impinj.itemsense.client.coordinator.zonemap;

import com.impinj.itemsense.client.helpers.RestApiHelper;
import java.util.List;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;


public class ZoneMapController {

  private static final String BASE_PATH = "/configuration/v1/zoneMaps";
  private WebTarget target;

  public ZoneMapController(WebTarget target) {
    this.target = target;
  }

  public Response createZoneMapAsResponse(ZoneMap zoneMap) {
    return RestApiHelper.post(zoneMap, target, BASE_PATH, "create");
  }

  public Response updateZoneMapAsResponse(ZoneMap zoneMap) {
    return RestApiHelper.put(zoneMap, target, BASE_PATH, "create");
  }

  public Response getZoneMapAsResponse(String zoneMapName) {
    return RestApiHelper.get(target, BASE_PATH, "show", zoneMapName);
  }

  public Response getZoneMapsAsResponse() {
    return RestApiHelper.get(target, BASE_PATH, "show");
  }

  public Response deleteZoneMap(String zoneMapName) {
    return RestApiHelper.delete(target, BASE_PATH, "destroy", zoneMapName);
  }

  public ZoneMap createZoneMap(ZoneMap zoneMap) {
    return this.createZoneMapAsResponse(zoneMap).readEntity(ZoneMap.class);
  }

  public ZoneMap updateZoneMap(ZoneMap zoneMap) {
    return this.updateZoneMapAsResponse(zoneMap).readEntity(ZoneMap.class);
  }

  public ZoneMap getZoneMap(String zoneMapName) {
    return this.getZoneMapAsResponse(zoneMapName).readEntity(ZoneMap.class);
  }

  public List<ZoneMap> getZoneMaps() {
    return getZoneMapsAsResponse().readEntity(new GenericType<List<ZoneMap>>() {});
  }
}
