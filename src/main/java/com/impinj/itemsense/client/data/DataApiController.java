package com.impinj.itemsense.client.data;

import com.impinj.itemsense.client.data.item.ItemController;
import com.impinj.itemsense.client.data.itemhistory.ItemHistoryController;
import com.impinj.itemsense.client.helpers.ObjectMapperContextResolver;

import java.net.URI;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;

import lombok.Data;



@Data
public class DataApiController {
    private final ObjectMapperContextResolver OBJECT_MAPPER_CONTEXT_RESOLVER
            = new ObjectMapperContextResolver();

    private ItemController itemController;
    private ItemHistoryController itemHistoryController;
    private WebTarget target;

    public DataApiController( final Client client, final URI uri) {
        this.target = client.register(OBJECT_MAPPER_CONTEXT_RESOLVER).target(uri);

        this.itemController = new ItemController(target);
        this.itemHistoryController = new ItemHistoryController( target);
    }
}
