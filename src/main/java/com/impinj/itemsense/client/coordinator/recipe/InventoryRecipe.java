/*
 * IMPINJ CONFIDENTIAL AND PROPRIETARY
 *
 * This source code is the sole property of Impinj, Inc. Reproduction or
 * utilization of this source code in whole or in part is forbidden without
 * the prior written consent of Impinj, Inc.
 *
 * (c) Copyright Impinj, Inc. 2016. All rights reserved.
 */

package com.impinj.itemsense.client.coordinator.recipe;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class InventoryRecipe extends Recipe {
    private LocationAggregationModel locationAggregationModel = LocationAggregationModel.BY_TIME;
    private Integer computeWindow = 20;
    private Integer reportingInterval = 5;

    public InventoryRecipe() {
        this.setType(RecipeType.INVENTORY);
    }
}
