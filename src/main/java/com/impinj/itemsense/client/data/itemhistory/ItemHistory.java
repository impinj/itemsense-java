package com.impinj.itemsense.client.data.itemhistory;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;

/**
 * Created by jcombopi on 1/26/16.
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemHistory {
    private String epc;
    private String tagId;
    private String fromZone;
    private String toZone;
    private ZonedDateTime observationTime;

}