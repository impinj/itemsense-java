package com.impinj.itemsense.client.coordinator.zonemap;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Zone {

  private String name;
  private String floor;
  private Point[] points;

}

