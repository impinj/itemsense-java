package com.impinj.itemsense.client.coordinator;

import com.google.common.collect.ImmutableList;
import com.google.gson.Gson;

import com.github.tomakehurst.wiremock.junit.WireMockClassRule;
import com.impinj.itemsense.client.TestUtils;
import com.impinj.itemsense.client.coordinator.readerhealth.HealthController;
import com.impinj.itemsense.client.coordinator.readerhealth.ReaderState;
import com.impinj.itemsense.client.coordinator.readerhealth.ReaderStatus;
import com.impinj.itemsense.client.coordinator.readerhealth.ReaderStatus.ConnectionStatus;
import com.impinj.itemsense.client.coordinator.readerhealth.ReaderStatus.HardwareStatus;
import com.impinj.itemsense.client.coordinator.readerhealth.ReaderStatus.ThroughputStatus;
import com.impinj.itemsense.client.coordinator.readerhealth.ReaderVersion;
import com.impinj.itemsense.client.coordinator.readerhealth.StatusLevel;

import org.junit.Assert;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;

public class HealthControllerTest {

    private HealthController healthController;
    private Gson gson = TestUtils.getGson();

    private static final List<ReaderStatus> TEST_READER_STATUSES = ImmutableList.of(
            ReaderStatus.builder()
                    .readerId("testReader1")
                    .state(ReaderState.IDLE)
                    .lastCheckin(ZonedDateTime.now(ZoneId.of("UTC")).minusMinutes(1))
                    .lastReboot(null)
                    .version(new ReaderVersion("appVersion1", "fwVersion1"))
                    .connectionStatus(new ConnectionStatus(StatusLevel.HEALTHY, "statusCode"))
                    .throughputStatus(new ThroughputStatus(StatusLevel.HEALTHY, "statusCode"))
                    .clockSyncStatus(null)
                    .hardwareStatus(new HardwareStatus(StatusLevel.WARNING, "warning", null))
                    .softwareStatus(null)
                    .build(),

            ReaderStatus.builder()
                    .readerId("testReader2")
                    .state(ReaderState.RUNNING_JOB)
                    .lastCheckin(ZonedDateTime.now(ZoneId.of("UTC")).minusMinutes(2))
                    .lastReboot(ZonedDateTime.now(ZoneId.of("UTC")).minusDays(1))
                    .version(new ReaderVersion("appVersion1", "fwVersion1"))
                    .connectionStatus(new ConnectionStatus(StatusLevel.HEALTHY, "statusCode"))
                    .throughputStatus(new ThroughputStatus(StatusLevel.HEALTHY, "statusCode"))
                    .clockSyncStatus(null)
                    .hardwareStatus(new HardwareStatus(StatusLevel.WARNING, "warning", null))
                    .softwareStatus(null)
                    .build()
    );

    @ClassRule
    public static WireMockClassRule wireMockRule = new WireMockClassRule(TestUtils.MOCK_PORT);
    @Rule
    public WireMockClassRule instanceRule = wireMockRule;

    @Before
    public void setUp() {
        healthController =
                new CoordinatorApiController(TestUtils.getClient(), TestUtils.MOCK_URI)
                        .getHealthController();
    }

    @Test
    public void getAllReaderStatuses() {
        stubFor(get(urlEqualTo("/health/v1/readers")).willReturn(
                aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody(gson.toJson(TEST_READER_STATUSES))
        ));

        List<ReaderStatus> readerStatuses = healthController.getAllReaderStatuses();
        Assert.assertEquals(TEST_READER_STATUSES, readerStatuses);
    }

    @Test
    public void getOneReaderStatus() {
        stubFor(get(urlEqualTo("/health/v1/readers/testReader1")).willReturn(
                aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody(gson.toJson(TEST_READER_STATUSES.get(0)))
        ));

        ReaderStatus readerStatus = healthController.getReaderStatus("testReader1");
        Assert.assertEquals(TEST_READER_STATUSES.get(0), readerStatus);
    }

    @Test
    public void getNonExistentReaderStatus() {
        stubFor(get(urlEqualTo("/health/v1/readers/notATestReader")).willReturn(
                aResponse()
                        .withStatus(404)
        ));

        ReaderStatus readerStatus = healthController.getReaderStatus("notATestReader");
        Assert.assertNull(readerStatus);
    }
}
