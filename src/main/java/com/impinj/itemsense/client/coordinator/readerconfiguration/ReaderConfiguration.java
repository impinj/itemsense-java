package com.impinj.itemsense.client.coordinator.readerconfiguration;

/**
 * Created by jcombopi on 1/25/16.
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReaderConfiguration {
    private String name;
    private Operation operation;
    private ReaderMode readerMode;
    private SearchMode searchMode;
    private int session;
    private int tagPopulationEstimate;
    private int antennaDwellTimeInMs;
    private boolean tagNak;
    private boolean polarization;
    private int[] antennas;
    private Filter filter;
    private ChannelConfig channelConfig;
    private ReportConfig reportConfig;

}


