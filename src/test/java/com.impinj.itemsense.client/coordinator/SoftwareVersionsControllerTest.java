package com.impinj.itemsense.client.coordinator;

import com.google.gson.Gson;

import com.github.tomakehurst.wiremock.junit.WireMockClassRule;
import com.impinj.itemsense.client.TestUtils;
import com.impinj.itemsense.client.coordinator.softwareupgrades.ImageType;
import com.impinj.itemsense.client.coordinator.softwareupgrades.VersionIdentifier;
import com.impinj.itemsense.client.coordinator.softwareversions.SoftwareVersionsController;
import com.impinj.itemsense.client.coordinator.softwareversions.VersionInfo;
import com.impinj.itemsense.client.coordinator.softwareversions.VersionInfoView;

import org.junit.Assert;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

import javax.ws.rs.client.Client;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;

public class SoftwareVersionsControllerTest {
    private SoftwareVersionsController softwareVersionsController;
    private Gson gson = TestUtils.getGson();

    @ClassRule
    public static WireMockClassRule wireMockRule = new WireMockClassRule(TestUtils.MOCK_PORT);
    @Rule
    public WireMockClassRule instanceRule = wireMockRule;

    private static final VersionInfoView CAP_VERSION;
    static {
        VersionInfoView capVersion = new VersionInfoView();

        VersionInfo versionInfo = new VersionInfo();

        VersionIdentifier versionIdentifier = new VersionIdentifier();
        versionIdentifier.setVersion("test_version");
        versionIdentifier.setImageType(ImageType.CAP_ITEMSENSE);

        versionInfo.setVersionIdentifier(versionIdentifier);
        versionInfo.setImageName("test_image_name");
        versionInfo.setChecksum("irrelevant_test_checksum");

        capVersion.setVersionInfo(versionInfo);
        capVersion.setDescription("test_description");
        capVersion.setCreated(LocalDateTime.now());
        capVersion.setUpdated(LocalDateTime.now());
        capVersion.setUpdateComment("i_updated_the_thing");
        capVersion.setRecordVersionNumber(1);

        CAP_VERSION = capVersion;
    }

    @Before
    public void setUp() {
        Client client = TestUtils.getClient();

        softwareVersionsController =
                new CoordinatorApiController(client, TestUtils.MOCK_URI)
                        .getSoftwareVersionsController();
    }

    @Test
    public void getCapVersions() {
        stubFor(get(urlEqualTo("/configuration/v1/softwareVersions/list/CAP_ITEMSENSE")).willReturn(
                aResponse().withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody(gson.toJson(Collections.singletonList(CAP_VERSION)))
        ));

        List<VersionInfoView> versions = softwareVersionsController.getVersions(ImageType.CAP_ITEMSENSE);

        Assert.assertThat(versions, hasSize(1));
        Assert.assertThat(versions, contains(CAP_VERSION));
    }

    @Test
    public void getCapVersionsNoneExist() {
        stubFor(get(urlEqualTo("/configuration/v1/softwareVersions/list/CAP_ITEMSENSE")).willReturn(
            aResponse().withStatus(200)
                    .withHeader("Content-Type", "application/json")
                    .withBody(gson.toJson(Collections.emptyList()))
        ));

        List<VersionInfoView> versions = softwareVersionsController.getVersions(ImageType.CAP_ITEMSENSE);

        Assert.assertThat(versions, is(empty()));
    }

    @Test
    public void getCapVersion() {
        stubFor(get(urlEqualTo("/configuration/v1/softwareVersions/show/CAP_ITEMSENSE/test_version"))
                        .willReturn(aResponse().withStatus(200)
                                            .withHeader("Content-Type", "application/json")
                                            .withBody(gson.toJson(CAP_VERSION))
                        )
        );

        VersionInfoView actualResponse =
                softwareVersionsController.getVersion(ImageType.CAP_ITEMSENSE, "test_version");
        Assert.assertEquals(CAP_VERSION, actualResponse);
    }

    @Test
    public void getNonExistentCapVersion() {
        stubFor(get(urlEqualTo("/configuration/v1/softwareVersions/show/CAP_ITEMSENSE/not_test_version"))
                        .willReturn(aResponse().withStatus(404))
        );

        VersionInfoView actualResponse = softwareVersionsController.getVersion(ImageType.CAP_ITEMSENSE, "not_test_version");
        Assert.assertNull(actualResponse);
    }
}
