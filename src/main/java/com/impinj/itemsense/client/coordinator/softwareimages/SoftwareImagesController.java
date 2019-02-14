package com.impinj.itemsense.client.coordinator.softwareimages;

import com.impinj.itemsense.client.coordinator.softwareupgrades.ImageType;
import com.impinj.itemsense.client.helpers.RestApiHelper;
import java.io.InputStream;
import javax.ws.rs.client.WebTarget;

public class SoftwareImagesController {

  private static final String BASE_PATH = "configuration/v1/images";
  private WebTarget target;

  public SoftwareImagesController(WebTarget target) {
    this.target = target;
  }

  public InputStream downloadSoftwareImage(ImageType imageType, String imageName) {
    return RestApiHelper.getOctetStream(target, BASE_PATH, imageType.name(), imageName);
  }
}
