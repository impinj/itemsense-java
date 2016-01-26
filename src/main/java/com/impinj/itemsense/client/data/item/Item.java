package com.impinj.itemsense.client.data.item;

import com.impinj.itemsense.client.data.PresenceConfidence;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Item {
    private String epc;
    private String tagId;
    private int xLocation;
    private int yLocation;
    private int zLocation;
    private String zone;
    private String facility;
    private PresenceConfidence presenceConfidence;
    private ZonedDateTime lastModifiedTime;

}
