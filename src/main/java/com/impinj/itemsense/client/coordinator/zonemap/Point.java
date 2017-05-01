package com.impinj.itemsense.client.coordinator.zonemap;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Point {

  private double x;
  private double y;
  private double z;
}
