package com.impinj.itemsense.client.coordinator.readerdefintion;

/**
 * Created by jcombopi on 1/25/16.
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Placement {
    private int x;
    private int y;
    private int z;
    private int yaw;
    private int pitch;
    private int roll;
    private String floor;

}
