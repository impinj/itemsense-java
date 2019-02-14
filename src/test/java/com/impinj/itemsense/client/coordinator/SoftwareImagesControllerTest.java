package com.impinj.itemsense.client.coordinator;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;

import com.github.tomakehurst.wiremock.junit.WireMockClassRule;
import com.impinj.itemsense.client.TestUtils;
import com.impinj.itemsense.client.coordinator.softwareimages.SoftwareImagesController;
import com.impinj.itemsense.client.coordinator.softwareupgrades.ImageType;
import java.io.InputStream;
import javax.ws.rs.NotFoundException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;

public class SoftwareImagesControllerTest {

  private static final byte[] TEST_BYTE_ARRAY = {'a', 'b', 'c', '1', '5', '0', 'g'};
  @ClassRule
  public static WireMockClassRule wireMockRule = new WireMockClassRule(TestUtils.MOCK_PORT);
  @Rule
  public WireMockClassRule instanceRule = wireMockRule;
  private SoftwareImagesController softwareImagesController;

  @Before
  public void setUp() {
    softwareImagesController =
        new CoordinatorApiController(TestUtils.getClient(), TestUtils.MOCK_URI)
            .getSoftwareImagesController();
  }

  @Test
  public void getSoftwareImage() throws Exception {
    stubFor(get(urlEqualTo("/configuration/v1/images/CAP_ITEMSENSE/testImageName")).willReturn(
        aResponse()
            .withStatus(200)
            .withHeader("Content-Type", "application/octet-stream")
            .withBody(TEST_BYTE_ARRAY)
    ));

    byte[] testResponseArray = new byte[TEST_BYTE_ARRAY.length];
    try (InputStream testImageStream = softwareImagesController.downloadSoftwareImage(
        ImageType.CAP_ITEMSENSE, "testImageName"
    )) {
      // Deliberately naive usage of the inputstream, to verify at the lowest level

      for (int i = 0; true; i++) {
        int nextByte = testImageStream.read();
        if (nextByte < 0) {
          break;
        }
        testResponseArray[i] = (byte) nextByte;
      }
    }

    Assert.assertArrayEquals(TEST_BYTE_ARRAY, testResponseArray);
  }

  @Test(expected = NotFoundException.class)
  public void getNonexistentSoftwareImage() throws Exception {
    stubFor(get(urlEqualTo("/configuration/v1/images/CAP_ITEMSENSE/notTestImageName"))
                .willReturn(aResponse().withStatus(404))
    );

    softwareImagesController.downloadSoftwareImage(ImageType.CAP_ITEMSENSE, "notTestImageName");
  }
}
