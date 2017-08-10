package com.impinj.itemsense.client.coordinator.authentication;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.time.ZonedDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ListTokenResponse {

  Token authenticationToken;

  ZonedDateTime issued;

  ZonedDateTime lastUsed;

  boolean valid;

  String username;

  /**
   * This is the incorrect capitalization of the property but it was in use, so this is here to
   * preserve backwards compatibility.
   */
  @JsonIgnore
  @Deprecated
  public String getUserName() {
    return username;
  }

  /**
   * This is the incorrect capitalization of the property but it was in use, so this is here to
   * preserve backwards compatibility.
   */
  @JsonIgnore
  @Deprecated
  public void setUserName(String userName) {
    this.username = userName;
  }
}

