package com.impinj.itemsense.client.coordinator.readerhealth;

import com.impinj.itemsense.client.helpers.RestApiHelper;

import java.util.List;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

public class HealthController {
    private WebTarget target;

    private static final String BASE_PATH = "health/v1";

    public HealthController(WebTarget target) {
        this.target = target;
    }

    public Response getAllReaderStatusesAsResponse() {
        return RestApiHelper.get(target, BASE_PATH, "readers");
    }
    public List<ReaderStatus> getAllReaderStatuses() {
        return getAllReaderStatusesAsResponse()
                .readEntity(new GenericType<List<ReaderStatus>>() {});
    }

    public Response getReaderStatusAsResponse(String readerName) {
        return RestApiHelper.get(target, BASE_PATH, "readers", readerName);
    }

    public ReaderStatus getReaderStatus(String readerName) {
        return getReaderStatusAsResponse(readerName).readEntity(ReaderStatus.class);
    }

    public Response queryHealthEventsAsResponse(HealthEventQuery query) {
        return RestApiHelper.post(query, target, "events");
    }
}
