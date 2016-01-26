/*
 * IMPINJ CONFIDENTIAL AND PROPRIETARY
 *
 * This source code is the sole property of Impinj, Inc. Reproduction or
 * utilization of this source code in whole or in part is forbidden without
 * the prior written consent of Impinj, Inc.
 *
 * (c) Copyright Impinj, Inc. 2015. All rights reserved.
 */

package com.impinj.itemsense.client.data;

import java.util.Optional;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ZoneTransitionQueueFilter {
  private Optional<String> fromZone = Optional.empty();
  private Optional<String> toZone = Optional.empty();
  private Optional<String> epc = Optional.empty();
}
