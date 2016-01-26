package com.impinj.itemsense.client.data.item;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by jcombopi on 1/26/16.
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemResponse {
    private Item[] items;
    private String nextPageMarker;
}

