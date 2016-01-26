package com.impinj.itemsense.client.coordinator.readerdefintion;


import com.google.gson.Gson;
import com.impinj.itemsense.client.helpers.RestApiHelper;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;


/**
 * Created by jcombopi on 1/25/16.
 */
public class ReaderDefinitionController {
    private Gson gson;
    private WebTarget target;
    private RestApiHelper<ReaderDefinition> restApiHelper;

    public ReaderDefinitionController(final Gson gson,  WebTarget target ){
        this.gson = gson;
        this.target = target;
        this.restApiHelper = new RestApiHelper<ReaderDefinition>(ReaderDefinition.class);
    }
    public ReaderDefinition createReaderDefinition(ReaderDefinition readerDefinition){
        return this.restApiHelper.post( readerDefinition, "/configuration/readerDefinitions/create",target, gson);
    }
    public ReaderDefinition updateReaderDefinition(ReaderDefinition readerDefinition){
        return this.restApiHelper.put( readerDefinition, "/configuration/readerDefinitions/create",target, gson);
    }
    public Response deleteReaderDefinition(String readerDefinitionName){
        return this.restApiHelper.delete(readerDefinitionName, "/configuration/readerDefinitions/destroy",target);
    }
    public ReaderDefinition getReaderDefinition(String readerDefinitionName){
        return this.restApiHelper.get(readerDefinitionName, "/configuration/readerDefinitions/show", target);
    }
    public ReaderDefinition[] getReaderDefinitions(){
        return this.restApiHelper.getMultiple(null, "/configuration/readerDefinitions/show", target, gson);
    }

}
