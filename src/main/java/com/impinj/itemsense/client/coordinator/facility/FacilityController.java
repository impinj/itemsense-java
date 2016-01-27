package com.impinj.itemsense.client.coordinator.facility;

import com.google.gson.Gson;
import com.impinj.itemsense.client.helpers.RestApiHelper;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

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

    public Facility getFacilities(String facilityName) {
        return this.restApiHelper.get(facilityName, "configuration/facilities/show", target);
    }

    public Facility create(Facility facility) {
        return this.restApiHelper.post(facility, "configuration/facilities/create", target, gson);
    }

    public Facility createOrReplace(Facility facility) {
        return this.restApiHelper.put(facility, "configuration/facilities/createOrReplace", target, gson);
    }

    public Response destroy(String facilityName) {
        return this.restApiHelper.delete(facilityName, "configuration/facilities/destroy", target);
    }
}
