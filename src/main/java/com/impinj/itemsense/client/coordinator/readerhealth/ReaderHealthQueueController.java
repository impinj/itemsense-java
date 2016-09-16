package com.impinj.itemsense.client.coordinator.readerhealth;

import com.impinj.itemsense.client.helpers.RestApiHelper;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

public class ReaderHealthQueueController {
    private WebTarget target;
    private RestApiHelper<HealthEventQueueFilter> restApiHelper;

    private static final String BASE_PATH = "health/v1/events/queues";

    public ReaderHealthQueueController(WebTarget target) {
        this.target = target;
        restApiHelper = new RestApiHelper<>(HealthEventQueueFilter.class);
    }

    public Response configureEventQueueAsResponse(HealthEventQueueFilter filter) {
        return restApiHelper.put(filter, target);
    }

    public QueueConfiguration configureEventQueue(HealthEventQueueFilter filter) {
        return configureEventQueueAsResponse(filter).readEntity(QueueConfiguration.class);
    }
}
