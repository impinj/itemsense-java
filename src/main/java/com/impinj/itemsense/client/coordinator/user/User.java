package com.impinj.itemsense.client.coordinator.user;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class User {

  private String name;
  private String password;
  private String[] roles;

  @java.beans.ConstructorProperties({"name", "password", "roles"})
  public User(String name, String password, String[] roles) {
    this.name = name;
    this.password = password;
    this.roles = roles;
  }

  public User() {}

  public static UserBuilder builder() {return new UserBuilder();}

  public String getName() {return this.name;}

  public String getPassword() {return this.password;}

  public String[] getRoles() {return this.roles;}

  public void setName(String name) {this.name = name; }

  public void setPassword(String password) {this.password = password; }

  public void setRoles(String[] roles) {this.roles = roles; }

  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (!(o instanceof User)) {
      return false;
    }
    final User other = (User) o;
    final Object this$name = this.getName();
    final Object other$name = other.getName();
    if (this$name == null ? other$name != null : !this$name.equals(other$name)) {
      return false;
    }
    final Object this$password = this.getPassword();
    final Object other$password = other.getPassword();
    if (this$password == null ? other$password != null : !this$password.equals(other$password)) {
      return false;
    }
    return java.util.Arrays.deepEquals(this.getRoles(), other.getRoles());
  }

  public int hashCode() {
    final int PRIME = 59;
    int result = 1;
    final Object $name = this.getName();
    result = result * PRIME + ($name == null ? 43 : $name.hashCode());
    final Object $password = this.getPassword();
    result = result * PRIME + ($password == null ? 43 : $password.hashCode());
    result = result * PRIME + java.util.Arrays.deepHashCode(this.getRoles());
    return result;
  }

  public String toString() {
    return "com.impinj.itemsense.client.coordinator.user.User(name=" + this.getName()
        + ", password=" + this.getPassword() + ", roles=" + java.util.Arrays
        .deepToString(this.getRoles()) + ")";
  }

  public static class UserBuilder {

    private String name;
    private String password;
    private String[] roles;

    UserBuilder() {}

    public User.UserBuilder name(String name) {
      this.name = name;
      return this;
    }

    public User.UserBuilder password(String password) {
      this.password = password;
      return this;
    }

    public User.UserBuilder roles(String[] roles) {
      this.roles = roles;
      return this;
    }

    public User build() {
      return new User(name, password, roles);
    }

    public String toString() {
      return "com.impinj.itemsense.client.coordinator.user.User.UserBuilder(name=" + this.name
          + ", password=" + this.password + ", roles=" + java.util.Arrays.deepToString(this.roles)
          + ")";
    }
  }
}
