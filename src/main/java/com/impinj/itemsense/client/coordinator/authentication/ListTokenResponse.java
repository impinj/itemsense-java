package com.impinj.itemsense.client.coordinator.authentication;

/**
 * Created by jcombopi on 5/31/16.
 */
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.impinj.itemsense.client.helpers.ZonedDateTimeSerialization;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;


@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ListTokenResponse {

    Token authenticationToken;

    @JsonDeserialize(using = ZonedDateTimeSerialization.class)
    ZonedDateTime issued;

    @JsonDeserialize(using = ZonedDateTimeSerialization.class)
    ZonedDateTime lastUsed;

    boolean valid;

    String userName;

}

