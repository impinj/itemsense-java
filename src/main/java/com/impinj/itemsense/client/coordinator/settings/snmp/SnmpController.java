/*
 * IMPINJ CONFIDENTIAL AND PROPRIETARY
 *
 * This source code is the sole property of Impinj, Inc. Reproduction or
 * utilization of this source code in whole or in part is forbidden without
 * the prior written consent of Impinj, Inc.
 *
 * (c) Copyright Impinj, Inc. 2016. All rights reserved.
 */

package com.impinj.itemsense.client.coordinator.settings.snmp;

import com.impinj.itemsense.client.helpers.RestApiHelper;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

public class SnmpController {
    private static final String BASE_PATH = "/configuration/v1/settings/SNMP";
    private WebTarget target;
    private RestApiHelper<SnmpConfiguration> restApiHelper;

    public SnmpController(WebTarget target) {
        this.target = target;
        this.restApiHelper = new RestApiHelper<SnmpConfiguration>();
    }

    public Response updateSnmpConfigurationAsResponse(SnmpConfiguration snmpConfiguration) {
        return this.restApiHelper.put(snmpConfiguration, target, BASE_PATH);
    }

    public Response getSnmpConfigurationAsResponse() {
        return this.restApiHelper.get(target, BASE_PATH);
    }

    public Response deleteSnmpConfigurationAsResponse() {
        return this.restApiHelper.delete(target, BASE_PATH);
    }

    public SnmpConfiguration getSnmpConfiguration() {
        return this.getSnmpConfigurationAsResponse()
                .readEntity(SnmpConfiguration.class);
    }

    public void deleteSnmpConfiguration() {
        this.deleteSnmpConfigurationAsResponse();
    }

    public SnmpConfiguration updateSnmpConfiguration(SnmpConfiguration snmpConfiguration) {
        return this.updateSnmpConfigurationAsResponse(snmpConfiguration)
                .readEntity(SnmpConfiguration.class);
    }
}
