package com.impinj.itemsense.client.coordinator.readerconfiguration;

import com.google.gson.Gson;
import com.impinj.itemsense.client.helpers.RestApiHelper;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

/**
 * Created by jcombopi on 1/25/16.
 */
public class ReaderConfigurationController {
    private Gson gson;
    private WebTarget target;
    private RestApiHelper<ReaderConfiguration> restApiHelper;

    public ReaderConfigurationController(final Gson gson, WebTarget target) {
        this.gson = gson;
        this.target = target;
        this.restApiHelper = new RestApiHelper<ReaderConfiguration>(ReaderConfiguration.class);
    }

    public ReaderConfiguration createReaderConfiguration(ReaderConfiguration readerConfiguration) {
        return this.restApiHelper.post(readerConfiguration, "/configuration/readerConfigurations/create", target, gson);
    }

    public ReaderConfiguration updateReaderConfiguration(ReaderConfiguration readerConfiguration) {
        return this.restApiHelper.put(readerConfiguration, "/configuration/readerConfigurations/create", target, gson);
    }

    public Response deleteReaderConfiguration(String readerConfigurationName) {
        return this.restApiHelper.delete(readerConfigurationName, "/configuration/readerConfigurations/destroy", target);
    }

    public ReaderConfiguration getReaderConfiguration(String readerConfigurationName) {
        return this.restApiHelper.get(readerConfigurationName, "/configuration/readerConfigurations/show", target);
    }

    public ReaderConfiguration[] getReaderConfigurations() {
        return this.restApiHelper.getMultiple(null, "/configuration/readerConfigurations/show", target, gson);
    }

}
