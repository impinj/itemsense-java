package com.impinj.itemsense.client.coordinator.authentication;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.time.ZonedDateTime;


@JsonIgnoreProperties(ignoreUnknown = true)
public class ListTokenResponse {

  Token authenticationToken;

  ZonedDateTime issued;

  ZonedDateTime lastUsed;

  boolean valid;

  String username;

  @java.beans.ConstructorProperties({"authenticationToken", "issued", "lastUsed", "valid",
      "username"})
  public ListTokenResponse(
      Token authenticationToken,
      ZonedDateTime issued,
      ZonedDateTime lastUsed,
      boolean valid, String username) {
    this.authenticationToken = authenticationToken;
    this.issued = issued;
    this.lastUsed = lastUsed;
    this.valid = valid;
    this.username = username;
  }

  public ListTokenResponse() {}

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

  public Token getAuthenticationToken() {return this.authenticationToken;}

  public ZonedDateTime getIssued() {return this.issued;}

  public ZonedDateTime getLastUsed() {return this.lastUsed;}

  public boolean isValid() {return this.valid;}

  public void setAuthenticationToken(Token authenticationToken) {this.authenticationToken = authenticationToken; }

  public void setIssued(ZonedDateTime issued) {this.issued = issued; }

  public void setLastUsed(ZonedDateTime lastUsed) {this.lastUsed = lastUsed; }

  public void setValid(boolean valid) {this.valid = valid; }

  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (!(o instanceof ListTokenResponse)) {
      return false;
    }
    final ListTokenResponse other = (ListTokenResponse) o;
    final Object this$authenticationToken = this.getAuthenticationToken();
    final Object other$authenticationToken = other.getAuthenticationToken();
    if (this$authenticationToken == null ? other$authenticationToken != null
                                         : !this$authenticationToken.equals(
                                             other$authenticationToken)) {
      return false;
    }
    final Object this$issued = this.getIssued();
    final Object other$issued = other.getIssued();
    if (this$issued == null ? other$issued != null : !this$issued.equals(other$issued)) {
      return false;
    }
    final Object this$lastUsed = this.getLastUsed();
    final Object other$lastUsed = other.getLastUsed();
    if (this$lastUsed == null ? other$lastUsed != null : !this$lastUsed.equals(other$lastUsed)) {
      return false;
    }
    if (this.isValid() != other.isValid()) {
      return false;
    }
    final Object this$username = this.getUserName();
    final Object other$username = other.getUserName();
    return this$username == null ? other$username == null : this$username.equals(other$username);
  }

  public int hashCode() {
    final int PRIME = 59;
    int result = 1;
    final Object $authenticationToken = this.getAuthenticationToken();
    result = result * PRIME + ($authenticationToken == null ? 43 : $authenticationToken.hashCode());
    final Object $issued = this.getIssued();
    result = result * PRIME + ($issued == null ? 43 : $issued.hashCode());
    final Object $lastUsed = this.getLastUsed();
    result = result * PRIME + ($lastUsed == null ? 43 : $lastUsed.hashCode());
    result = result * PRIME + (this.isValid() ? 79 : 97);
    final Object $username = this.getUserName();
    result = result * PRIME + ($username == null ? 43 : $username.hashCode());
    return result;
  }

  public String toString() {
    return
        "com.impinj.itemsense.client.coordinator.authentication.ListTokenResponse(authenticationToken="
            + this.getAuthenticationToken() + ", issued=" + this.getIssued() + ", lastUsed=" + this
            .getLastUsed() + ", valid=" + this.isValid() + ", username=" + this.getUserName() + ")";
  }
}
