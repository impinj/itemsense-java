package com.impinj.itemsense.client;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import com.fatboyindustrial.gsonjavatime.Converters;

public abstract class TestUtils {
    private static final Gson GSON = Converters.registerAll(new GsonBuilder()).create();

    public static Gson getGson() {
        return GSON;
    }
}
