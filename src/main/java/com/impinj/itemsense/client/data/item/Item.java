package com.impinj.itemsense.client.data.item;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.impinj.itemsense.client.data.PresenceConfidence;
import com.impinj.itemsense.client.helpers.ZonedDateTimeDeserializer;
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

    @JsonDeserialize(using = ZonedDateTimeDeserializer.class)
    private ZonedDateTime lastModifiedTime;

}
