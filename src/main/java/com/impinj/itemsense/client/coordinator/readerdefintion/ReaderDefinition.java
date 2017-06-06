package com.impinj.itemsense.client.coordinator.readerdefintion;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.Map;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@Builder
public class ReaderDefinition {

  private String name;
  private String address;
  private String agentIdentifier;
  private String serialNumber;
  private String facility;
  private String readerZone;
  private Map<Integer, String> antennaZones;
  private Placement placement;
  private ReaderType type;
  private Set<String> groups;
  private Map<ReaderFeature, ReaderFeatureStatus> features;

  @Deprecated
  public ReaderDefinition(String name,
      String address,
      String facility,
      String readerZone,
      Map<Integer, String> antennaZones,
      Placement placement,
      ReaderType type) {

    this.name = name;
    this.address = address;
    this.facility = facility;
    this.readerZone = readerZone;
    this.antennaZones = antennaZones;
    this.placement = placement;
    this.type = type;
    this.groups = null;
    this.features = null;
  }
}

