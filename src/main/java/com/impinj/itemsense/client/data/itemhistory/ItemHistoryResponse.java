package com.impinj.itemsense.client.data.itemhistory;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ItemHistoryResponse {
    private ItemHistory[] history;
    private String nextPageMarker;
    private boolean moreHistoryAvailable;
}

