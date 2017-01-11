package com.impinj.itemsense.client.coordinator.readerdefintion;


import com.impinj.itemsense.client.helpers.RestApiHelper;

import java.util.List;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

public class ReaderDefinitionController {
    private static final String BASE_PATH = "/configuration/v1/readerDefinitions";
    private WebTarget target;

    public ReaderDefinitionController(WebTarget target) {
        this.target = target;
    }

    public Response createReaderDefinitionAsResponse(ReaderDefinition readerDefinition) {
        return RestApiHelper.post(readerDefinition, target, BASE_PATH, "create");
    }

    public Response updateReaderDefinitionAsResponse(ReaderDefinition readerDefinition) {
        return RestApiHelper.put(readerDefinition, target, BASE_PATH, "createOrReplace");
    }

    public Response getReaderDefinitionAsResponse(String readerDefinitionName) {
        return RestApiHelper.get(target, BASE_PATH, "show", readerDefinitionName);
    }

    public Response getReaderDefinitionsAsResponse() {
        return RestApiHelper.get(target, BASE_PATH, "show");
    }

    public Response deleteReaderDefinition(String readerDefinitionName) {
        return RestApiHelper.delete(target, BASE_PATH, "destroy", readerDefinitionName);
    }

    public ReaderDefinition createReaderDefinition(ReaderDefinition readerDefinition) {
        return this.createReaderDefinitionAsResponse(readerDefinition).readEntity(ReaderDefinition.class);
    }

    public ReaderDefinition updateReaderDefinition(ReaderDefinition readerDefinition) {
        return this.updateReaderDefinitionAsResponse(readerDefinition).readEntity(ReaderDefinition.class);
    }

    public ReaderDefinition getReaderDefinition(String readerDefinitionName) {
        return this.getReaderDefinitionAsResponse(readerDefinitionName).readEntity(ReaderDefinition.class);
    }

    public List<ReaderDefinition> getReaderDefinitions() {
        return this.getReaderDefinitionsAsResponse()
            .readEntity(new GenericType<List<ReaderDefinition>>() {});
    }
}
