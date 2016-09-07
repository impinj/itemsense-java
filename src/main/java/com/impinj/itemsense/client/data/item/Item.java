package com.impinj.itemsense.client.data.item;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.impinj.itemsense.client.data.PresenceConfidence;

import java.time.ZonedDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Item {

    private String epc;
    private String tagId;

    //Since these are single lettered, variables Jackson is getting confused by the getter/setters created by lombok such as 'getXLocation'
    // Jackson is then trying to render these as xlocaton, ylocation, etc. Therefore the json property annotation is required for these fields.

    @JsonProperty("xLocation")
    private double xLocation;
    @JsonProperty("yLocation")
    private double yLocation;
    @JsonProperty("zLocation")
    private double zLocation;
    private String zone;
    private String floor;
    private String facility;
    private PresenceConfidence presenceConfidence;

    private ZonedDateTime lastModifiedTime;
}
