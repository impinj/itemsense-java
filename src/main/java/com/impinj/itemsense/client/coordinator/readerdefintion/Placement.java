package com.impinj.itemsense.client.coordinator.readerdefintion;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Placement {

  private int x;
  private int y;
  private int z;
  private int yaw;
  private int pitch;
  private int roll;
  private String floor;
}
