package com.impinj.itemsense.client.coordinator.thresholds;

import com.impinj.itemsense.client.coordinator.readerdefintion.ReaderType;
import java.util.List;

public class ThresholdAntennaConfiguration {

  private Integer id;
  private String name;
  private ThresholdSide side;
  private ReaderType readerType;
  private ThresholdReaderArrangement readerArrangement;
  private List<ThresholdAntennaConfigurationAntenna> in;
  private List<ThresholdAntennaConfigurationAntenna> out;
  private List<ThresholdAntennaConfigurationAntenna> ignored;

  @java.beans.ConstructorProperties({"id", "name", "side", "readerType", "readerArrangement", "in",
      "out", "ignored"})
  public ThresholdAntennaConfiguration(
      Integer id,
      String name,
      ThresholdSide side,
      ReaderType readerType,
      ThresholdReaderArrangement readerArrangement,
      List<ThresholdAntennaConfigurationAntenna> in,
      List<ThresholdAntennaConfigurationAntenna> out,
      List<ThresholdAntennaConfigurationAntenna> ignored) {
    this.id = id;
    this.name = name;
    this.side = side;
    this.readerType = readerType;
    this.readerArrangement = readerArrangement;
    this.in = in;
    this.out = out;
    this.ignored = ignored;
  }

  public ThresholdAntennaConfiguration() {}

  public static ThresholdAntennaConfigurationBuilder builder() {return new ThresholdAntennaConfigurationBuilder();}

  public Integer getId() {return this.id;}

  public String getName() {return this.name;}

  public ThresholdSide getSide() {return this.side;}

  public ReaderType getReaderType() {return this.readerType;}

  public ThresholdReaderArrangement getReaderArrangement() {return this.readerArrangement;}

  public List<ThresholdAntennaConfigurationAntenna> getIn() {return this.in;}

  public List<ThresholdAntennaConfigurationAntenna> getOut() {return this.out;}

  public List<ThresholdAntennaConfigurationAntenna> getIgnored() {return this.ignored;}

  public void setId(Integer id) {this.id = id; }

  public void setName(String name) {this.name = name; }

  public void setSide(ThresholdSide side) {this.side = side; }

  public void setReaderType(ReaderType readerType) {this.readerType = readerType; }

  public void setReaderArrangement(ThresholdReaderArrangement readerArrangement) {this.readerArrangement = readerArrangement; }

  public void setIn(List<ThresholdAntennaConfigurationAntenna> in) {this.in = in; }

  public void setOut(List<ThresholdAntennaConfigurationAntenna> out) {this.out = out; }

  public void setIgnored(List<ThresholdAntennaConfigurationAntenna> ignored) {this.ignored = ignored; }

  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (!(o instanceof ThresholdAntennaConfiguration)) {
      return false;
    }
    final ThresholdAntennaConfiguration other = (ThresholdAntennaConfiguration) o;
    final Object this$id = this.getId();
    final Object other$id = other.getId();
    if (this$id == null ? other$id != null : !this$id.equals(other$id)) {
      return false;
    }
    final Object this$name = this.getName();
    final Object other$name = other.getName();
    if (this$name == null ? other$name != null : !this$name.equals(other$name)) {
      return false;
    }
    final Object this$side = this.getSide();
    final Object other$side = other.getSide();
    if (this$side == null ? other$side != null : !this$side.equals(other$side)) {
      return false;
    }
    final Object this$readerType = this.getReaderType();
    final Object other$readerType = other.getReaderType();
    if (this$readerType == null ? other$readerType != null : !this$readerType.equals(
        other$readerType)) {
      return false;
    }
    final Object this$readerArrangement = this.getReaderArrangement();
    final Object other$readerArrangement = other.getReaderArrangement();
    if (this$readerArrangement == null ? other$readerArrangement != null
                                       : !this$readerArrangement.equals(other$readerArrangement)) {
      return false;
    }
    final Object this$in = this.getIn();
    final Object other$in = other.getIn();
    if (this$in == null ? other$in != null : !this$in.equals(other$in)) {
      return false;
    }
    final Object this$out = this.getOut();
    final Object other$out = other.getOut();
    if (this$out == null ? other$out != null : !this$out.equals(other$out)) {
      return false;
    }
    final Object this$ignored = this.getIgnored();
    final Object other$ignored = other.getIgnored();
    return this$ignored == null ? other$ignored == null : this$ignored.equals(other$ignored);
  }

  public int hashCode() {
    final int PRIME = 59;
    int result = 1;
    final Object $id = this.getId();
    result = result * PRIME + ($id == null ? 43 : $id.hashCode());
    final Object $name = this.getName();
    result = result * PRIME + ($name == null ? 43 : $name.hashCode());
    final Object $side = this.getSide();
    result = result * PRIME + ($side == null ? 43 : $side.hashCode());
    final Object $readerType = this.getReaderType();
    result = result * PRIME + ($readerType == null ? 43 : $readerType.hashCode());
    final Object $readerArrangement = this.getReaderArrangement();
    result = result * PRIME + ($readerArrangement == null ? 43 : $readerArrangement.hashCode());
    final Object $in = this.getIn();
    result = result * PRIME + ($in == null ? 43 : $in.hashCode());
    final Object $out = this.getOut();
    result = result * PRIME + ($out == null ? 43 : $out.hashCode());
    final Object $ignored = this.getIgnored();
    result = result * PRIME + ($ignored == null ? 43 : $ignored.hashCode());
    return result;
  }

  public String toString() {
    return "com.impinj.itemsense.client.coordinator.thresholds.ThresholdAntennaConfiguration(id="
        + this.getId() + ", name=" + this.getName() + ", side=" + this.getSide() + ", readerType="
        + this.getReaderType() + ", readerArrangement=" + this.getReaderArrangement() + ", in="
        + this.getIn() + ", out=" + this.getOut() + ", ignored=" + this.getIgnored() + ")";
  }

  public static class ThresholdAntennaConfigurationBuilder {

    private Integer id;
    private String name;
    private ThresholdSide side;
    private ReaderType readerType;
    private ThresholdReaderArrangement readerArrangement;
    private List<ThresholdAntennaConfigurationAntenna> in;
    private List<ThresholdAntennaConfigurationAntenna> out;
    private List<ThresholdAntennaConfigurationAntenna> ignored;

    ThresholdAntennaConfigurationBuilder() {}

    public ThresholdAntennaConfiguration.ThresholdAntennaConfigurationBuilder id(Integer id) {
      this.id = id;
      return this;
    }

    public ThresholdAntennaConfiguration.ThresholdAntennaConfigurationBuilder name(String name) {
      this.name = name;
      return this;
    }

    public ThresholdAntennaConfiguration.ThresholdAntennaConfigurationBuilder side(ThresholdSide side) {
      this.side = side;
      return this;
    }

    public ThresholdAntennaConfiguration.ThresholdAntennaConfigurationBuilder readerType(ReaderType readerType) {
      this.readerType = readerType;
      return this;
    }

    public ThresholdAntennaConfiguration.ThresholdAntennaConfigurationBuilder readerArrangement(
        ThresholdReaderArrangement readerArrangement) {
      this.readerArrangement = readerArrangement;
      return this;
    }

    public ThresholdAntennaConfiguration.ThresholdAntennaConfigurationBuilder in(List<ThresholdAntennaConfigurationAntenna> in) {
      this.in = in;
      return this;
    }

    public ThresholdAntennaConfiguration.ThresholdAntennaConfigurationBuilder out(List<ThresholdAntennaConfigurationAntenna> out) {
      this.out = out;
      return this;
    }

    public ThresholdAntennaConfiguration.ThresholdAntennaConfigurationBuilder ignored(List<ThresholdAntennaConfigurationAntenna> ignored) {
      this.ignored = ignored;
      return this;
    }

    public ThresholdAntennaConfiguration build() {
      return new ThresholdAntennaConfiguration(
          id,
          name,
          side,
          readerType,
          readerArrangement,
          in,
          out,
          ignored);
    }

    public String toString() {
      return
          "com.impinj.itemsense.client.coordinator.thresholds.ThresholdAntennaConfiguration.ThresholdAntennaConfigurationBuilder(id="
              + this.id + ", name=" + this.name + ", side=" + this.side + ", readerType="
              + this.readerType + ", readerArrangement=" + this.readerArrangement + ", in="
              + this.in
              + ", out=" + this.out + ", ignored=" + this.ignored + ")";
    }
  }
}
