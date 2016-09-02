package com.impinj.itemsense.client.coordinator.readerconfiguration;



import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReaderConfiguration {
    private String name;
    private Operation operation;
    private ReaderConfigurationDetails configuration = new ReaderConfigurationDetails();

    @JsonIgnore
    public ReaderConfiguration(
        String name,
        Operation operation,
        ReaderMode readerMode,
        SearchMode searchMode,
        int session,
        int tagPopulationEstimate,
        boolean polarization,
        int[] antennas,
        Filter filter,
        ChannelConfig channelConfig,
        ReportConfig reportConfig) {
        this.name = name;
        this.operation = operation;
        this.configuration = new ReaderConfigurationDetails();
        this.setReaderMode(readerMode);
        this.setSearchMode(searchMode);
        this.setSession(session);
        this.setTagPopulationEstimate(tagPopulationEstimate);
        this.setPolarization(polarization);
        this.setAntennas(antennas);
        this.setFilter(filter);
        this.setChannelConfig(channelConfig);
        this.setReportConfig(reportConfig);
    }

    @JsonIgnore
    public ReaderMode getReaderMode() {
        return configuration.getReaderMode();
    }

    @JsonIgnore
    public SearchMode getSearchMode() {
        return configuration.getSearchMode();
    }

    @JsonIgnore
    public int getSession() {
        return configuration.getSession();
    }

    @JsonIgnore
    public int getTagPopulationEstimate() {
        return configuration.getTagPopulationEstimate();
    }

    @JsonIgnore
    public boolean isPolarization() {
        return configuration.isPolarization();
    }

    @JsonIgnore
    public int[] getAntennas() {
        return configuration.getAntennas();
    }

    @JsonIgnore
    public Filter getFilter() {
        return configuration.getFilter();
    }

    @JsonIgnore
    public ChannelConfig getChannelConfig() {
        return configuration.getChannelConfig();
    }

    @JsonIgnore
    public ReportConfig getReportConfig() {
        return configuration.getReportConfig();
    }

    @JsonIgnore
    public void setReaderMode(ReaderMode readerMode) {
        configuration.setReaderMode(readerMode);
    }

    @JsonIgnore
    public void setSearchMode(SearchMode searchMode) {
        configuration.setSearchMode(searchMode);
    }

    @JsonIgnore
    public void setSession(int session) {
        configuration.setSession(session);
    }

    @JsonIgnore
    public void setTagPopulationEstimate(int tagPopulationEstimate) {
        configuration.setTagPopulationEstimate(tagPopulationEstimate);
    }

    @JsonIgnore
    public void setPolarization(boolean polarization) {
        configuration.setPolarization(polarization);
    }

    @JsonIgnore
    public void setAntennas(int[] antennas) {
        configuration.setAntennas(antennas);
    }

    @JsonIgnore
    public void setFilter(Filter filter) {
        configuration.setFilter(filter);
    }

    @JsonIgnore
    public void setChannelConfig(ChannelConfig channelConfig) {
        configuration.setChannelConfig(channelConfig);
    }

    @JsonIgnore
    public void setReportConfig(ReportConfig reportConfig) {
        configuration.setReportConfig(reportConfig);
    }
}


