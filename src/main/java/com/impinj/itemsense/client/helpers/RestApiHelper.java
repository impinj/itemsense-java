package com.impinj.itemsense.client.helpers;


import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Map;

/**
 * Created by jcombopi on 1/25/16.
 */
public class RestApiHelper<T> {
    private Class<T> type;

    public RestApiHelper(Class<T> type) {
        this.type = type;
    }

    public Response post(T request, String path, WebTarget target) {
        return target.path(path)
                .request(MediaType.APPLICATION_JSON_TYPE)
                .post(Entity.json(request));
    }

    public Response put(T request, String path, WebTarget target) {
        return target.path(path)
                .request(MediaType.APPLICATION_JSON_TYPE)
                .put(Entity.json(request));

    }

    public Response delete(String id, String path, WebTarget target) {
        return target.path(path + "/" + id)
                .request(MediaType.APPLICATION_JSON_TYPE).delete();

    }

    public Response get(String path, WebTarget target) {
        return target.path(path).request(MediaType.APPLICATION_JSON)
                .get();
    }

    public Response get(String id, String path, WebTarget target) {
        return target.path(path + "/" + id).request(MediaType.APPLICATION_JSON)
                .get();
    }

    public Response get(Map<String, Object> queryParams, String path, WebTarget target) {

        target = target.path(path);
        if (queryParams != null) {
            for (Map.Entry<String, Object> queryParam : queryParams.entrySet()) {
                target = target.queryParam(queryParam.getKey(), queryParam.getValue());
            }
        }
        return target.request(MediaType.APPLICATION_JSON_TYPE)
                .get();
    }

}


