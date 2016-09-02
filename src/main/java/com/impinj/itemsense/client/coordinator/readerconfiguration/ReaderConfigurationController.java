package com.impinj.itemsense.client.coordinator.readerconfiguration;

import com.impinj.itemsense.client.helpers.RestApiHelper;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class ReaderConfigurationController {
    private WebTarget target;
    private RestApiHelper<ReaderConfiguration> restApiHelper;

    public ReaderConfigurationController(WebTarget target) {
        this.target = target;
        this.restApiHelper = new RestApiHelper<ReaderConfiguration>(ReaderConfiguration.class);
    }

    public Response createReaderConfigurationAsResponse(ReaderConfiguration readerConfiguration) {
        return this.restApiHelper.post(readerConfiguration, "/configuration/v1/readerConfigurations/create", target);
    }

    public Response updateReaderConfigurationAsResponse(ReaderConfiguration readerConfiguration) {
        return this.restApiHelper.put(readerConfiguration, "/configuration/v1/readerConfigurations/createOrReplace", target);
    }

    public Response getReaderConfigurationAsResponse(String readerConfigurationName) {
        return this.restApiHelper.get(readerConfigurationName, "/configuration/v1/readerConfigurations/show", target);
    }

    public Response getReaderConfigurationsAsResponse() {
        return this.restApiHelper.get("/configuration/v1/readerConfigurations/show", target);
    }

    public Response deleteReaderConfiguration(String readerConfigurationName) {
        return this.restApiHelper.delete(readerConfigurationName, "/configuration/v1/readerConfigurations/destroy", target);
    }

    public ReaderConfiguration getReaderConfiguration(String readerConfigurationName) {
        return restApiHelper.readObjectFromString(this.getReaderConfigurationAsResponse(readerConfigurationName).readEntity(String.class));
    }

    public List<ReaderConfiguration> getReaderConfigurations() {
        return this.restApiHelper.readObjectsFromString(this.getReaderConfigurationsAsResponse().readEntity(String.class));
    }

    public ReaderConfiguration createReaderConfiguration(ReaderConfiguration readerConfiguration) {
        return this.restApiHelper.readObjectFromString(this.createReaderConfigurationAsResponse(readerConfiguration).readEntity(String.class));
    }

    public ReaderConfiguration updateReaderConfiguration(ReaderConfiguration readerConfiguration) {
        return this.restApiHelper.readObjectFromString(this.updateReaderConfigurationAsResponse(readerConfiguration).readEntity(String.class));
    }

}
