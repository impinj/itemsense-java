package com.impinj.itemsense.client.coordinator.authentication;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.ZonedDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ListTokenResponse {

    Token authenticationToken;

    ZonedDateTime issued;

    ZonedDateTime lastUsed;

    boolean valid;

    String userName;

}

