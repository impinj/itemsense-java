/**
 * IMPINJ CONFIDENTIAL AND PROPRIETARY
 *
 * This source code is the sole property of Impinj, Inc. Reproduction or utilization of this source
 * code in whole or in part is forbidden without the prior written consent of Impinj, Inc.
 *
 * (c) Copyright Impinj, Inc. 2015. All rights reserved.
 */
package com.impinj.itemsense.integration.client;

import lombok.Data;

/**
 * Represents a response from the jobs endpoint
 *
 * @author Daniel Burton
 */
@Data
public class FailureResponse {
  String status;
  String message;
}
