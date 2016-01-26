package com.impinj.itemsense.client.data.itemhistory;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by jcombopi on 1/26/16.
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemHistoryResponse {
    private ItemHistory[] history;
    private String nextPageMarker;
}

