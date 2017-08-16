package com.impinj.itemsense.client.coordinator.authentication;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties(ignoreUnknown = true)
public class Token {

  private String token;

  @java.beans.ConstructorProperties({"token"})
  public Token(String token) {
    this.token = token;
  }

  public Token() {}

  public String getToken() {return this.token;}

  public void setToken(String token) {this.token = token; }

  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (!(o instanceof Token)) {
      return false;
    }
    final Token other = (Token) o;
    final Object this$token = this.getToken();
    final Object other$token = other.getToken();
    return this$token == null ? other$token == null : this$token.equals(other$token);
  }

  public int hashCode() {
    final int PRIME = 59;
    int result = 1;
    final Object $token = this.getToken();
    result = result * PRIME + ($token == null ? 43 : $token.hashCode());
    return result;
  }

  public String toString() {
    return "com.impinj.itemsense.client.coordinator.authentication.Token(token=" + this.getToken()
        + ")";
  }
}
