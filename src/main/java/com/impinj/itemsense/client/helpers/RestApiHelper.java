package com.impinj.itemsense.client.helpers;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class RestApiHelper<T> {
    private Class<T> type;
    private static Logger logger = LoggerFactory.getLogger(RestApiHelper.class);

    public RestApiHelper(Class<T> type) {
        this.type = type;
    }

    public Response post(T entity, WebTarget target, String... pathFragments) {
        return target.path(joinPathFragments(pathFragments))
                .request(MediaType.APPLICATION_JSON_TYPE)
                .post(Entity.json(entity));
    }

    public Response post(WebTarget target, String... pathFragments) {
        return target
            .path(joinPathFragments(pathFragments))
            .request(MediaType.APPLICATION_JSON_TYPE)
            .header(HttpHeaders.CONTENT_LENGTH, 0)
            .post(null);
    }

    public Response put(T entity, WebTarget target, String... pathFragments) {
        return target.path(joinPathFragments(pathFragments))
                .request(MediaType.APPLICATION_JSON_TYPE)
                .put(Entity.json(entity));
    }

    public Response put(WebTarget target, String... pathFragments) {
        return target.path(joinPathFragments(pathFragments))
            .request(MediaType.APPLICATION_JSON_TYPE)
            .put(Entity.json(""));
    }

    public Response delete(WebTarget target, String... pathFragments) {
        return target.path(joinPathFragments(pathFragments))
                .request(MediaType.APPLICATION_JSON_TYPE).delete();

    }

    public Response get(WebTarget target, String... pathFragments) {
        return target.path(joinPathFragments(pathFragments))
                .request(MediaType.APPLICATION_JSON)
                .get();
    }

    public Response get(Map<String, Object> queryParams, WebTarget target, String... pathFragments) {
        target = target.path(joinPathFragments(pathFragments));
        if (queryParams != null) {
            for (Map.Entry<String, Object> queryParam : queryParams.entrySet()) {
                target = target.queryParam(queryParam.getKey(), queryParam.getValue());
            }
        }
        return target.request(MediaType.APPLICATION_JSON_TYPE)
                .get();
    }

    private static String joinPathFragments(String... pathFragments) {
        return Stream.of(pathFragments).collect(Collectors.joining("/"));
    }
}


