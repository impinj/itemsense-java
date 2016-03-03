package com.impinj.itemsense.client.coordinator.user;

/**
 * Created by jcombopi on 1/25/16.
 */

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {
    private String name;
    private String password;
    private String[] roles;
}
