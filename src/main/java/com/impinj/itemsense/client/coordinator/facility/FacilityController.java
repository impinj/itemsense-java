package com.impinj.itemsense.client.coordinator.facility;

import com.google.gson.Gson;
import com.impinj.itemsense.client.helpers.RestApiHelper;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import java.util.ArrayList;

/**
 * Created by jcombopi on 1/25/16.
 */
public class FacilityController {
    private RestApiHelper<Facility> restApiHelper;
    private Gson gson;
    private WebTarget target;

    public FacilityController(final Gson gson, WebTarget target) {
        this.gson = gson;
        this.target = target;
        this.restApiHelper = new RestApiHelper<Facility>(Facility.class);
    }

    public Facility getFacility(String facilityName) {
        return this.restApiHelper.get(facilityName, "/configuration/v1/facilities/show", target);
    }
    public ArrayList<Facility> getAllFacilities(){
        return this.restApiHelper.getMultiple(null, "/configuration/v1/facilities/show", target, gson);
    }

    public Facility createFacility(Facility facility) {
        return this.restApiHelper.post(facility, "/configuration/v1/facilities/create", target, gson);
    }

    public Facility updateFacility(Facility facility) {
        return this.restApiHelper.put(facility, "/configuration/v1/facilities/createOrReplace", target, gson);
    }

    public Response deleteFacility(String facilityName) {
        return this.restApiHelper.delete(facilityName, "/configuration/v1/facilities/destroy", target);
    }
}
