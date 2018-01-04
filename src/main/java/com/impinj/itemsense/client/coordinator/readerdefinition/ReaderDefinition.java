package com.impinj.itemsense.client.coordinator.readerdefinition;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.Map;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
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

  @java.beans.ConstructorProperties({"name", "address", "agentIdentifier", "serialNumber",
      "facility", "readerZone", "antennaZones", "placement", "type", "groups", "features"})
  public ReaderDefinition(
      String name,
      String address,
      String agentIdentifier,
      String serialNumber,
      String facility,
      String readerZone,
      Map<Integer, String> antennaZones,
      Placement placement,
      ReaderType type, Set<String> groups, Map<ReaderFeature, ReaderFeatureStatus> features) {
    this.name = name;
    this.address = address;
    this.agentIdentifier = agentIdentifier;
    this.serialNumber = serialNumber;
    this.facility = facility;
    this.readerZone = readerZone;
    this.antennaZones = antennaZones;
    this.placement = placement;
    this.type = type;
    this.groups = groups;
    this.features = features;
  }

  public ReaderDefinition() {}

  public static ReaderDefinitionBuilder builder() {return new ReaderDefinitionBuilder();}

  public String getName() {return this.name;}

  public String getAddress() {return this.address;}

  public String getAgentIdentifier() {return this.agentIdentifier;}

  public String getSerialNumber() {return this.serialNumber;}

  public String getFacility() {return this.facility;}

  public String getReaderZone() {return this.readerZone;}

  public Map<Integer, String> getAntennaZones() {return this.antennaZones;}

  public Placement getPlacement() {return this.placement;}

  public ReaderType getType() {return this.type;}

  public Set<String> getGroups() {return this.groups;}

  public Map<ReaderFeature, ReaderFeatureStatus> getFeatures() {return this.features;}

  public void setName(String name) {this.name = name; }

  public void setAddress(String address) {this.address = address; }

  public void setAgentIdentifier(String agentIdentifier) {this.agentIdentifier = agentIdentifier; }

  public void setSerialNumber(String serialNumber) {this.serialNumber = serialNumber; }

  public void setFacility(String facility) {this.facility = facility; }

  public void setReaderZone(String readerZone) {this.readerZone = readerZone; }

  public void setAntennaZones(Map<Integer, String> antennaZones) {this.antennaZones = antennaZones; }

  public void setPlacement(Placement placement) {this.placement = placement; }

  public void setType(ReaderType type) {this.type = type; }

  public void setGroups(Set<String> groups) {this.groups = groups; }

  public void setFeatures(Map<ReaderFeature, ReaderFeatureStatus> features) {this.features = features; }

  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (!(o instanceof ReaderDefinition)) {
      return false;
    }
    final ReaderDefinition other = (ReaderDefinition) o;
    final Object this$name = this.getName();
    final Object other$name = other.getName();
    if (this$name == null ? other$name != null : !this$name.equals(other$name)) {
      return false;
    }
    final Object this$address = this.getAddress();
    final Object other$address = other.getAddress();
    if (this$address == null ? other$address != null : !this$address.equals(other$address)) {
      return false;
    }
    final Object this$agentIdentifier = this.getAgentIdentifier();
    final Object other$agentIdentifier = other.getAgentIdentifier();
    if (this$agentIdentifier == null ? other$agentIdentifier != null : !this$agentIdentifier.equals(
        other$agentIdentifier)) {
      return false;
    }
    final Object this$serialNumber = this.getSerialNumber();
    final Object other$serialNumber = other.getSerialNumber();
    if (this$serialNumber == null ? other$serialNumber != null : !this$serialNumber.equals(
        other$serialNumber)) {
      return false;
    }
    final Object this$facility = this.getFacility();
    final Object other$facility = other.getFacility();
    if (this$facility == null ? other$facility != null : !this$facility.equals(other$facility)) {
      return false;
    }
    final Object this$readerZone = this.getReaderZone();
    final Object other$readerZone = other.getReaderZone();
    if (this$readerZone == null ? other$readerZone != null : !this$readerZone.equals(
        other$readerZone)) {
      return false;
    }
    final Object this$antennaZones = this.getAntennaZones();
    final Object other$antennaZones = other.getAntennaZones();
    if (this$antennaZones == null ? other$antennaZones != null : !this$antennaZones.equals(
        other$antennaZones)) {
      return false;
    }
    final Object this$placement = this.getPlacement();
    final Object other$placement = other.getPlacement();
    if (this$placement == null ? other$placement != null
                               : !this$placement.equals(other$placement)) {
      return false;
    }
    final Object this$type = this.getType();
    final Object other$type = other.getType();
    if (this$type == null ? other$type != null : !this$type.equals(other$type)) {
      return false;
    }
    final Object this$groups = this.getGroups();
    final Object other$groups = other.getGroups();
    if (this$groups == null ? other$groups != null : !this$groups.equals(other$groups)) {
      return false;
    }
    final Object this$features = this.getFeatures();
    final Object other$features = other.getFeatures();
    return this$features == null ? other$features == null : this$features.equals(other$features);
  }

  public int hashCode() {
    final int PRIME = 59;
    int result = 1;
    final Object $name = this.getName();
    result = result * PRIME + ($name == null ? 43 : $name.hashCode());
    final Object $address = this.getAddress();
    result = result * PRIME + ($address == null ? 43 : $address.hashCode());
    final Object $agentIdentifier = this.getAgentIdentifier();
    result = result * PRIME + ($agentIdentifier == null ? 43 : $agentIdentifier.hashCode());
    final Object $serialNumber = this.getSerialNumber();
    result = result * PRIME + ($serialNumber == null ? 43 : $serialNumber.hashCode());
    final Object $facility = this.getFacility();
    result = result * PRIME + ($facility == null ? 43 : $facility.hashCode());
    final Object $readerZone = this.getReaderZone();
    result = result * PRIME + ($readerZone == null ? 43 : $readerZone.hashCode());
    final Object $antennaZones = this.getAntennaZones();
    result = result * PRIME + ($antennaZones == null ? 43 : $antennaZones.hashCode());
    final Object $placement = this.getPlacement();
    result = result * PRIME + ($placement == null ? 43 : $placement.hashCode());
    final Object $type = this.getType();
    result = result * PRIME + ($type == null ? 43 : $type.hashCode());
    final Object $groups = this.getGroups();
    result = result * PRIME + ($groups == null ? 43 : $groups.hashCode());
    final Object $features = this.getFeatures();
    result = result * PRIME + ($features == null ? 43 : $features.hashCode());
    return result;
  }

  public String toString() {
    return "com.impinj.itemsense.client.coordinator.readerdefinition.ReaderDefinition(name=" + this
        .getName() + ", address=" + this.getAddress() + ", agentIdentifier=" + this
        .getAgentIdentifier() + ", serialNumber=" + this.getSerialNumber() + ", facility=" + this
        .getFacility() + ", readerZone=" + this.getReaderZone() + ", antennaZones=" + this
        .getAntennaZones() + ", placement=" + this.getPlacement() + ", type=" + this.getType()
        + ", groups=" + this.getGroups() + ", features=" + this.getFeatures() + ")";
  }

  public static class ReaderDefinitionBuilder {

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

    ReaderDefinitionBuilder() {}

    public ReaderDefinition.ReaderDefinitionBuilder name(String name) {
      this.name = name;
      return this;
    }

    public ReaderDefinition.ReaderDefinitionBuilder address(String address) {
      this.address = address;
      return this;
    }

    public ReaderDefinition.ReaderDefinitionBuilder agentIdentifier(String agentIdentifier) {
      this.agentIdentifier = agentIdentifier;
      return this;
    }

    public ReaderDefinition.ReaderDefinitionBuilder serialNumber(String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
    }

    public ReaderDefinition.ReaderDefinitionBuilder facility(String facility) {
      this.facility = facility;
      return this;
    }

    public ReaderDefinition.ReaderDefinitionBuilder readerZone(String readerZone) {
      this.readerZone = readerZone;
      return this;
    }

    public ReaderDefinition.ReaderDefinitionBuilder antennaZones(Map<Integer, String> antennaZones) {
      this.antennaZones = antennaZones;
      return this;
    }

    public ReaderDefinition.ReaderDefinitionBuilder placement(Placement placement) {
      this.placement = placement;
      return this;
    }

    public ReaderDefinition.ReaderDefinitionBuilder type(ReaderType type) {
      this.type = type;
      return this;
    }

    public ReaderDefinition.ReaderDefinitionBuilder groups(Set<String> groups) {
      this.groups = groups;
      return this;
    }

    public ReaderDefinition.ReaderDefinitionBuilder features(Map<ReaderFeature, ReaderFeatureStatus> features) {
      this.features = features;
      return this;
    }

    public ReaderDefinition build() {
      return new ReaderDefinition(
          name,
          address,
          agentIdentifier,
          serialNumber,
          facility,
          readerZone,
          antennaZones,
          placement,
          type,
          groups,
          features);
    }

    public String toString() {
      return
          "com.impinj.itemsense.client.coordinator.readerdefinition.ReaderDefinition.ReaderDefinitionBuilder(name="
              + this.name + ", address=" + this.address + ", agentIdentifier="
              + this.agentIdentifier
              + ", serialNumber=" + this.serialNumber + ", facility=" + this.facility
              + ", readerZone=" + this.readerZone + ", antennaZones=" + this.antennaZones
              + ", placement=" + this.placement + ", type=" + this.type + ", groups=" + this.groups
              + ", features=" + this.features + ")";
    }
  }
}

