package com.impinj.itemsense.client.coordinator;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.gson.Gson;

import com.github.tomakehurst.wiremock.junit.WireMockClassRule;
import com.impinj.itemsense.client.TestUtils;
import com.impinj.itemsense.client.coordinator.readerdefintion.ReaderType;
import com.impinj.itemsense.client.coordinator.softwareupgrades.TargetType;
import com.impinj.itemsense.client.coordinator.softwareupgrades.DeviceStatus;
import com.impinj.itemsense.client.coordinator.softwareupgrades.ImageType;
import com.impinj.itemsense.client.coordinator.softwareupgrades.SoftwareUpgradesController;
import com.impinj.itemsense.client.coordinator.softwareupgrades.StartUpgradeResponse;
import com.impinj.itemsense.client.coordinator.softwareupgrades.UpgradeFailureAction;
import com.impinj.itemsense.client.coordinator.softwareupgrades.UpgradePolicy;
import com.impinj.itemsense.client.coordinator.softwareupgrades.UpgradeRequest;
import com.impinj.itemsense.client.coordinator.softwareupgrades.UpgradeRequestTarget;
import com.impinj.itemsense.client.coordinator.softwareupgrades.UpgradeRequestView;
import com.impinj.itemsense.client.coordinator.softwareupgrades.UpgradeState;
import com.impinj.itemsense.client.coordinator.softwareupgrades.UpgradeStatus;
import com.impinj.itemsense.client.coordinator.softwareupgrades.VersionIdentifier;

import org.junit.Assert;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

import javax.ws.rs.client.Client;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.post;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;

public class SoftwareUpgradeControllerTest {
    private SoftwareUpgradesController softwareUpgradesController;
    private Gson gson = TestUtils.getGson();

    @ClassRule
    public static WireMockClassRule wireMockClassRule = new WireMockClassRule(TestUtils.MOCK_PORT);
    @Rule
    public WireMockClassRule instanceRule = wireMockClassRule;

    private static final UpgradeRequestView TEST_UPGRADE_REQUEST_VIEW;
    private static final UpgradeRequest TEST_UPGRADE_REQUEST;
    private static final UpgradeStatus TEST_UPGRADE_STATUS;
    private static final StartUpgradeResponse TEST_START_UPGRADE_RESPONSE;
    static {
        TEST_UPGRADE_REQUEST_VIEW = new UpgradeRequestView();

        TEST_UPGRADE_REQUEST_VIEW.setId("test_id");

        TEST_UPGRADE_REQUEST = new UpgradeRequest();
        ImmutableSet<String> groupingUnitIds = ImmutableSet.of("test_facility1");
        TEST_UPGRADE_REQUEST.setTarget(new UpgradeRequestTarget(TargetType.FACILITY, groupingUnitIds));

        VersionIdentifier versionIdentifier = new VersionIdentifier();

        versionIdentifier.setVersion("test_version");
        versionIdentifier.setImageType(ImageType.CAP_ITEMSENSE);
        TEST_UPGRADE_REQUEST.setVersionIdentifier(versionIdentifier);

        UpgradePolicy upgradePolicy = new UpgradePolicy();
        upgradePolicy.setBatchSize(10);
        upgradePolicy.setRatioMaxFailures(0.1);
        upgradePolicy.setStaggerDelaySeconds(1);
        upgradePolicy.setFailureAction(UpgradeFailureAction.Stop);
        upgradePolicy.setAllowedReaderTypes(ImmutableSet.of(ReaderType.XPORTAL));
        TEST_UPGRADE_REQUEST.setPolicy(upgradePolicy);

        TEST_UPGRADE_REQUEST_VIEW.setUpgradeRequest(TEST_UPGRADE_REQUEST);



        TEST_UPGRADE_STATUS = new UpgradeStatus();

        TEST_UPGRADE_STATUS.setId("test_id2");
        TEST_UPGRADE_STATUS.setVersion(versionIdentifier);
        TEST_UPGRADE_STATUS.setStatus(UpgradeState.IN_PROGRESS);
        TEST_UPGRADE_STATUS.setTarget(new UpgradeRequestTarget(TargetType.FACILITY, groupingUnitIds));

        UpgradeStatus.UpgradeStatusDetails upgradeStatusDetails = new UpgradeStatus.UpgradeStatusDetails();

        DeviceStatus deviceStatus = new DeviceStatus();
        deviceStatus.setName("test_readerId_1");

        VersionIdentifier previousVersion = new VersionIdentifier();

        previousVersion.setVersion("test_old_version");
        previousVersion.setImageType(ImageType.CAP_ITEMSENSE);
        deviceStatus.setPreviousVersion(previousVersion);

        deviceStatus.setStatus(UpgradeState.IN_PROGRESS);
        deviceStatus.setElapsedTimeSeconds(1);
        deviceStatus.setLastUpdatedTime("test_time_string");

        upgradeStatusDetails.setReaders(ImmutableList.of(deviceStatus));
        TEST_UPGRADE_STATUS.setDetails(upgradeStatusDetails);
        TEST_UPGRADE_STATUS.setElapsedTimeSeconds(1);
        TEST_UPGRADE_STATUS.setLastUpdatedTime("test_time_string_2");



        TEST_START_UPGRADE_RESPONSE = new StartUpgradeResponse();
        TEST_START_UPGRADE_RESPONSE.setUpgradeInstanceId("test_id3");
    }

    @Before
    public void setUp() {
        Client client = TestUtils.getClient();
        softwareUpgradesController =
                new CoordinatorApiController(client, TestUtils.MOCK_URI)
                        .getSoftwareUpgradesController();
    }

    @Test
    public void getAllUpgradeRequests() {
        stubFor(get(urlEqualTo("/control/v1/upgrades/show")).willReturn(
                aResponse().withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody(gson.toJson(Collections.singletonList(TEST_UPGRADE_REQUEST_VIEW)))
        ));

        List<UpgradeRequestView> upgradeRequests = softwareUpgradesController.getUpgradeRequests();
        Assert.assertThat(upgradeRequests, hasSize(1));
        Assert.assertThat(upgradeRequests, contains(TEST_UPGRADE_REQUEST_VIEW));
    }

    @Test
    public void getAllUpgradeRequestsNoneExist() {
        stubFor(get(urlEqualTo("/control/v1/upgrades/show")).willReturn(
                aResponse().withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody(gson.toJson(Collections.emptyList()))
        ));

        List<UpgradeRequestView> upgradeRequests = softwareUpgradesController.getUpgradeRequests();
        Assert.assertThat(upgradeRequests, is(empty()));
    }

    @Test
    public void getUpgradeRequest() {
        stubFor(get(urlEqualTo("/control/v1/upgrades/show/test_id2")).willReturn(
                aResponse().withStatus(200)
                .withHeader("Content-Type", "application/json")
                .withBody(gson.toJson(TEST_UPGRADE_STATUS))
        ));

        UpgradeStatus upgradeStatus = softwareUpgradesController.getUpgradeStatus("test_id2");
        Assert.assertEquals(TEST_UPGRADE_STATUS, upgradeStatus);
    }

    @Test
    public void getNonExistentUpgradeRequest() {
        stubFor(get(urlEqualTo("/control/v1/upgrades/show/not_test_id2")).willReturn(
                aResponse().withStatus(404)
        ));

        UpgradeStatus upgradeStatus = softwareUpgradesController.getUpgradeStatus("not_test_id2");
        Assert.assertNull(upgradeStatus);
    }

    @Test
    public void startUpgrade() {
        stubFor(post(urlEqualTo("/control/v1/upgrades/start")).willReturn(
                aResponse().withStatus(200)
                .withHeader("Content-Type", "application/json")
                .withBody(gson.toJson(TEST_START_UPGRADE_RESPONSE))
        ));
        StartUpgradeResponse startUpgradeResponse =
                softwareUpgradesController.startUpgrade(TEST_UPGRADE_REQUEST);

        Assert.assertEquals(TEST_START_UPGRADE_RESPONSE, startUpgradeResponse);
    }

    @Test
    public void stopUpgrade() {
        stubFor(post(urlEqualTo("/control/v1/upgrades/stop/test_id3")).willReturn(
                aResponse().withStatus(204)
        ));

        softwareUpgradesController.stopUpgrade("test_id3");
    }
}
