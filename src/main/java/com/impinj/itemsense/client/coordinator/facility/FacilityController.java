package com.impinj.itemsense.client.coordinator.facility;

import com.impinj.itemsense.client.helpers.RestApiHelper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;


public class FacilityController {
    private RestApiHelper<Facility> restApiHelper;
    private WebTarget target;

    public FacilityController(WebTarget target) {
        this.target = target;
        this.restApiHelper = new RestApiHelper<Facility>(Facility.class);
    }

    public Response getFacilityAsResponse(String facilityName) {
        return this.restApiHelper.get(facilityName, "/configuration/v1/facilities/show", target);
    }

    public Response getAllFacilitiesAsResponse() {
        return this.restApiHelper.get("/configuration/v1/facilities/show", target);
    }

    public Response createFacilityAsResponse(Facility facility) {
        return this.restApiHelper.post(facility, "/configuration/v1/facilities/create", target);
    }

    public Response updateFacilityAsResponse(Facility facility) {
        return this.restApiHelper.put(facility, "/configuration/v1/facilities/createOrReplace", target);
    }

    public Response deleteFacility(String facilityName) {
        return this.restApiHelper.delete(facilityName, "/configuration/v1/facilities/destroy", target);
    }

    public List<Facility> getAllFacilities() {
        Facility[] facilities = getAllFacilitiesAsResponse().readEntity(Facility[].class);
        return new ArrayList<Facility>(Arrays.asList(facilities));
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
