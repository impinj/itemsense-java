package com.impinj.itemsense.client.coordinator;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;

import com.github.tomakehurst.wiremock.junit.WireMockClassRule;
import com.google.gson.Gson;
import com.impinj.itemsense.client.TestUtils;
import com.impinj.itemsense.client.coordinator.softwareupgrades.ImageType;
import com.impinj.itemsense.client.coordinator.softwareupgrades.VersionIdentifier;
import com.impinj.itemsense.client.coordinator.softwareversions.SoftwareVersionsController;
import com.impinj.itemsense.client.coordinator.softwareversions.VersionInfo;
import com.impinj.itemsense.client.coordinator.softwareversions.VersionInfoView;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import javax.ws.rs.client.Client;
import org.junit.Assert;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;

public class SoftwareVersionsControllerTest {

  private static final VersionInfoView CAP_VERSION;
  @ClassRule
  public static WireMockClassRule wireMockRule = new WireMockClassRule(TestUtils.MOCK_PORT);

  static {
    VersionIdentifier versionIdentifier = VersionIdentifier
        .builder()
        .version("test_version")
        .imageType(ImageType.CAP_ITEMSENSE)
        .build();

    VersionInfo versionInfo = VersionInfo
        .builder()
        .versionIdentifier(versionIdentifier)
        .imageName("test_image_name")
        .checksum("irrelevant_test_checksum")
        .build();

    CAP_VERSION = VersionInfoView.builder()
        .versionInfo(versionInfo)
        .description("test_description")
        .created(LocalDateTime.now())
        .updated(LocalDateTime.now())
        .updateComment("i_updated_the_thing")
        .recordVersionNumber(1)
        .build();;
  }

  @Rule
  public WireMockClassRule instanceRule = wireMockRule;
  private SoftwareVersionsController softwareVersionsController;
  private Gson gson = TestUtils.getGson();

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

    List<VersionInfoView> versions = softwareVersionsController
        .getVersions(ImageType.CAP_ITEMSENSE);

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

    List<VersionInfoView> versions = softwareVersionsController
        .getVersions(ImageType.CAP_ITEMSENSE);

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

    VersionInfoView actualResponse = softwareVersionsController.getVersion(
        ImageType.CAP_ITEMSENSE,
        "not_test_version");
    Assert.assertNull(actualResponse);
  }
}
