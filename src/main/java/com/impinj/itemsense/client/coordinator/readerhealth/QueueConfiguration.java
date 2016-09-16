package com.impinj.itemsense.client.coordinator.readerhealth;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QueueConfiguration {
    private String serverUrl;
    private String queue;
}
