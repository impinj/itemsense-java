package com.impinj.itemsense.client.helpers;

import java.io.InputStream;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class RestApiHelper {

  public static Response post(Object entity, WebTarget target, String... pathFragments) {
    return target.path(joinPathFragments(pathFragments))
        .request(MediaType.APPLICATION_JSON_TYPE)
        .post(Entity.json(entity));
  }

  public static Response post(WebTarget target, String... pathFragments) {
    return target
        .path(joinPathFragments(pathFragments))
        .request(MediaType.APPLICATION_JSON_TYPE)
        .header(HttpHeaders.CONTENT_LENGTH, 0)
        .post(null);
  }

  public static Response put(Object entity, WebTarget target, String... pathFragments) {
    return target.path(joinPathFragments(pathFragments))
        .request(MediaType.APPLICATION_JSON_TYPE)
        .put(Entity.json(entity));
  }

  public static Response put(WebTarget target, String... pathFragments) {
    return target.path(joinPathFragments(pathFragments))
        .request(MediaType.APPLICATION_JSON_TYPE)
        .put(Entity.json(""));
  }

  public static Response delete(WebTarget target, String... pathFragments) {
    return target.path(joinPathFragments(pathFragments))
        .request(MediaType.APPLICATION_JSON_TYPE).delete();

  }

  public static Response get(WebTarget target, String... pathFragments) {
    return target.path(joinPathFragments(pathFragments))
        .request(MediaType.APPLICATION_JSON)
        .get();
  }

  public static Response get(
      Map<String, Object> queryParams,
      WebTarget target,
      String... pathFragments) {
    target = target.path(joinPathFragments(pathFragments));
    if (queryParams != null) {
      for (Map.Entry<String, Object> queryParam : queryParams.entrySet()) {
        target = target.queryParam(queryParam.getKey(), queryParam.getValue());
      }
    }
    return target.request(MediaType.APPLICATION_JSON_TYPE)
        .get();
  }

  /**
   * @throws NotFoundException if the request results in a 404.  This is different from the other
   * helper methods in this class, due to needing to retrieve the InputStream at the request level.
   */
  public static InputStream getOctetStream(WebTarget target, String... pathSegments)
      throws NotFoundException {
    return target.path(joinPathFragments(pathSegments))
        .request(MediaType.APPLICATION_OCTET_STREAM_TYPE)
        .get(InputStream.class);
  }

  private static String joinPathFragments(String... pathFragments) {
    return Stream.of(pathFragments).collect(Collectors.joining("/"));
  }
}


