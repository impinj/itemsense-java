package com.impinj.itemsense.client.coordinator.recipe;

/**
 * Created by jcombopi on 1/25/16.
 */

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Recipe {
    private String name;
    private RecipeType type;
    private String readerConfigurationName;
    private Map<String, String> readerConfigurations;
    private boolean presencePipelineEnabled;
    private boolean locationReportingEnabled;
    private ZoneModel zoneModel;
    private Integer minimumMovementInMeters;
    private Integer locationUpdateIntervalInSeconds;
    private Integer computeWindowSizeInCycles;
    private Integer computeWindowTimeInSeconds;
    private LocationAggregationModel locationAggregationModel;
}

