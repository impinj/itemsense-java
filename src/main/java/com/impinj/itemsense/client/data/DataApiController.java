package com.impinj.itemsense.client.data;

import com.impinj.itemsense.client.data.item.ItemController;
import com.impinj.itemsense.client.data.itemhistory.ItemHistoryController;
import lombok.Data;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;
import java.net.URI;

/**
 * Created by jcombopi on 1/26/16.
 */

@Data
public class DataApiController {

    private ItemController itemController;
    private ItemHistoryController itemHistoryController;
    private WebTarget target;

    public DataApiController( final Client client, final URI uri) {
        this.target = client.target(uri);
        this.itemController = new ItemController(target);
        this.itemHistoryController = new ItemHistoryController( target);
    }
}
