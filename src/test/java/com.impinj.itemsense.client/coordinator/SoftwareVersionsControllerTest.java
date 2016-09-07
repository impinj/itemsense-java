package com.impinj.itemsense.client.coordinator;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import com.fatboyindustrial.gsonjavatime.Converters;
import com.github.tomakehurst.wiremock.junit.WireMockClassRule;
import com.impinj.itemsense.client.TestUtils;
import com.impinj.itemsense.client.coordinator.softwareupgrades.ImageType;
import com.impinj.itemsense.client.coordinator.softwareupgrades.VersionIdentifier;
import com.impinj.itemsense.client.coordinator.softwareversions.SoftwareVersionsController;
import com.impinj.itemsense.client.coordinator.softwareversions.VersionInfo;
import com.impinj.itemsense.client.coordinator.softwareversions.VersionInfoView;

import org.glassfish.jersey.client.authentication.HttpAuthenticationFeature;
import org.hamcrest.core.IsCollectionContaining;
import org.junit.Assert;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;

public class SoftwareVersionsControllerTest {
    private SoftwareVersionsController softwareVersionsController;
    private Gson gson = TestUtils.getGson();

    @ClassRule
    public static WireMockClassRule wireMockRule = new WireMockClassRule(8089);
    @Rule
    public WireMockClassRule instanceRule = wireMockRule;

    private static final VersionInfoView CAP_VERSION;
    static {
        VersionInfoView capVersion = new VersionInfoView();

        VersionInfo versionInfo = new VersionInfo();

        VersionIdentifier versionIdentifier = new VersionIdentifier();
        versionIdentifier.setVersion("test_version");
        versionIdentifier.setImageType(ImageType.cap_itemsense);

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

        Client client = ClientBuilder.newClient()
                .register(HttpAuthenticationFeature.basic("testUser", "testPassword"));

        //http://localhost:8089 is where wiremock is running
        softwareVersionsController =
                new CoordinatorApiController(client, URI.create("http://localhost:8089"))
                        .getSoftwareVersionsController();
    }

    @Test
    public void GetCapVersions() {
        stubFor(get(urlEqualTo("/configuration/v1/softwareVersions/list/cap_itemsense")).willReturn(
                aResponse().withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody(gson.toJson(Collections.singletonList(CAP_VERSION)))
        ));

        List<VersionInfoView> versions = softwareVersionsController.getVersions(ImageType.cap_itemsense);

        Assert.assertThat(versions, IsCollectionContaining.hasItem(CAP_VERSION));
    }
}
