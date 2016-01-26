package com.impinj.itemsense.client.coordinator.zonemap;

import com.google.gson.Gson;

import javax.ws.rs.client.Client;
import java.net.URI;

/**
 * Created by jcombopi on 1/25/16.
 */
public class ZoneMapController {

   public ZoneMapController(final Gson gson, final Client client, final URI uri ){

   }
    /**
     *
     * @param zoneMap
     * @return
     */
    public ZoneMap createZoneMap(ZoneMap zoneMap){

    }
    public ZoneMap updateZoneMap(ZoneMap zoneMap){

    }
    public void deleteZoneMap(String zoneMapName){

    }
    public ZoneMap getZoneMap(String zoneMapName){

    }
    public ZoneMap[] getZoneMaps(){

    }
    public CurrentZoneMap setCurrentZoneMap(String name){

    }
    public void clearCurrentZoneMap(String name){

    }
    public void clearCurrentZoneMap(String name, String facility){

    }
    public CurrentZoneMap getCurrentZoneMap(String facility){

    }
    public CurrentZoneMap[] getCurrentZoneMaps(){

    }
}
