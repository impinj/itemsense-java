package com.impinj.itemsense.client.helpers;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.tomakehurst.wiremock.common.Json;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;


/**
 * Created by jcombopi on 1/25/16.
 */
public class RestApiHelper<T> {
    private Class<T> type;

    public RestApiHelper(Class<T> type) {
        this.type = type;
    }

    public T post(T request, String path, WebTarget target, Gson gson) {
        String requestString = gson.toJson(request);

        return target.path(path)
                .request(MediaType.APPLICATION_JSON_TYPE)
                .post(Entity.entity(requestString, MediaType.APPLICATION_JSON_TYPE), this.type);
    }

    public T put(T request, String path, WebTarget target, Gson gson) {
        String requestString = gson.toJson(request);
        return target.path(path)
                .request(MediaType.APPLICATION_JSON_TYPE)
                .put(Entity.entity(requestString, MediaType.APPLICATION_JSON_TYPE), this.type);

    }

    public Response delete(String id, String path, WebTarget target) {
        return target.path(path + "/" + id)
                .request(MediaType.APPLICATION_JSON_TYPE).delete();

    }

    public T get(String path, WebTarget target) {
        return target.path(path).request(MediaType.APPLICATION_JSON)
                .get(this.type);
    }

    public T get(String id, String path, WebTarget target) {
        return target.path(path + "/" + id).request(MediaType.APPLICATION_JSON)
                .get(this.type);
    }

    public T get(Map<String, Object> queryParams, String path, WebTarget target, Gson gson) {

        target = target.path(path);
        if (queryParams != null) {
            for (Map.Entry<String, Object> queryParam : queryParams.entrySet()) {
                target = target.queryParam(queryParam.getKey(), queryParam.getValue());
            }
        }
        return target.request(MediaType.APPLICATION_JSON_TYPE)
                .get(this.type);
    }


    public ArrayList<T> getMultiple(Map<String, Object> queryParams, String path, WebTarget target, Gson gson) {
        ArrayList<T> responseArray = new ArrayList<T>();
        target = target.path(path);
        if (queryParams != null) {
            for (Map.Entry<String, Object> queryParam : queryParams.entrySet()) {
                target = target.queryParam(queryParam.getKey(), queryParam.getValue());
            }
        }

        String response = target.request(MediaType.APPLICATION_JSON_TYPE)
                .get(String.class);

        List<Map> tmpList = gson.fromJson(response, new ArrayList<Map>().getClass());

        ArrayList<T> collection = tmpList.stream().map(obj -> gson.fromJson(gson.toJson(obj), this.type)).collect(Collectors.toCollection(ArrayList<T>::new));

        return collection;


    }


}


