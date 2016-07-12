package com.impinj.itemsense.client.coordinator.job;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by nkershaw on 7/12/16.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class TagReadStats {
  private long uniqueTags;
  private long tagReads;
  private long droppedTags;
}
