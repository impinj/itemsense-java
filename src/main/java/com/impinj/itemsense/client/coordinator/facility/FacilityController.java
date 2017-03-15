package com.impinj.itemsense.client.coordinator.facility;

import com.impinj.itemsense.client.helpers.RestApiHelper;
import java.util.List;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;


public class FacilityController {

  private static final String BASE_PATH = "/configuration/v1/facilities";
  private WebTarget target;

  public FacilityController(WebTarget target) {
    this.target = target;
  }

  public Response getFacilityAsResponse(String facilityName) {
    return RestApiHelper.get(target, BASE_PATH, "show", facilityName);
  }

  public Response getAllFacilitiesAsResponse() {
    return RestApiHelper.get(target, BASE_PATH, "show");
  }

  public Response createFacilityAsResponse(Facility facility) {
    return RestApiHelper.post(facility, target, BASE_PATH, "create");
  }

  public Response updateFacilityAsResponse(Facility facility) {
    return RestApiHelper.put(facility, target, BASE_PATH, "createOrReplace");
  }

  public Response deleteFacility(String facilityName) {
    return RestApiHelper.delete(target, BASE_PATH, "destroy", facilityName);
  }

  public List<Facility> getAllFacilities() {
    return getAllFacilitiesAsResponse().readEntity(new GenericType<List<Facility>>() {});
  }

  public Facility getFacility(String facilityName) {
    return this.getFacilityAsResponse(facilityName).readEntity(Facility.class);
  }

  public Facility createFacility(Facility facility) {
    return this.createFacilityAsResponse(facility).readEntity(Facility.class);
  }

  public Facility updateFacility(Facility facility) {
    return this.updateFacilityAsResponse(facility).readEntity(Facility.class);
  }

}
