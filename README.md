# itemsense-java
> itemsense-java is an API wrapper library for Impinj's ItemSense.

## Install
itemsense-java is available as a dependency on Maven Central [here.](http://mvnrepository.com/artifact/com.impinj/itemsense-client)

```
<dependency>
	<groupId>com.impinj</groupId>
	<artifactId>itemsense-client</artifactId>
	<version>5.0.1</version>
</dependency>
```

## Basic Usage
Once this dependency is included in your project, you can instantiate the two base controllers for coordination and data endpoints.

Check out this sample of a class that instantiates both controllers:

```java

import com.impinj.itemsense.client.coordinator.CoordinatorApiController;
import com.impinj.itemsense.client.data.DataApiController;
import org.glassfish.jersey.client.authentication.HttpAuthenticationFeature;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import java.net.URI;

public class ItemSenseConfiguration {
    String username = ...;
    String password = ...;
    String url = "http://.../itemsense/";

    public ItemSenseConfiguration() {
    }

    public ItemSenseConfiguration(String username, String password, String url) {
        this.username = username;
        this.password = password;
        this.url = url;
    }

    public String getUserName() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getBaseUrl() {
        return url;
    }
}

public class ItemSenseApiFactory {

    private ItemSenseApiFactory() {
    }

    // Create a controller for the coordinator endpoints
    public static CoordinatorApiController getCoordinatorApiController(ItemSenseConfiguration itemSenseConfiguration) {

        Client client = ClientBuilder.newClient().register(HttpAuthenticationFeature.basic(itemSenseConfiguration.getUserName(), itemSenseConfiguration.getPassword()));
        CoordinatorApiController coordinatorApiController = new CoordinatorApiController( client, URI.create(itemSenseConfiguration.getBaseUrl()));
        return coordinatorApiController;
    }

    // Creates a controller for the data endpoints
    public static DataApiController getDataApiController(ItemSenseConfiguration itemSenseConfiguration) {

        Client client = ClientBuilder.newClient().register(HttpAuthenticationFeature.basic(itemSenseConfiguration.getUserName(), itemSenseConfiguration.getPassword()));
        DataApiController dataApiController = new DataApiController( client, URI.create(itemSenseConfiguration.getBaseUrl()));
        return dataApiController;
    }

}
```

### Table of Contents
1. <a href="#itemsenseConfig">ItemSense Configuration</a>
1. <a href="#authentication">Authentication</a>
1. <a href="#users">Users</a>
1. <a href= "#configuration">Global Configuration </a>
1. <a href= "#softwareVersions">Software Versions </a>
1. <a href= "#softwareUpgrades">Software Upgrades </a>
1. <a href="#zoneMaps">Zone Maps </a>
1. <a href= "#currentZoneMap">Current Zone Map </a>
1. <a href= "#readerDefinitions" >Reader Definitions </a>
1. <a href ="#readerConfigurations">Reader Configurations </a>
1. <a href ="#readerHealth">Reader Health </a>
1. <a href ="#recipes">Recipes </a>
1. <a href= "#jobs" >Jobs </a>
1. <a href= "#items">Items </a>




### ItemSense Configuration
<div id="itemsenseConfig" />
<table>
<thead>
<tr>
<td>
<b>Property</b>
</td>
<td>
<b>Description</b>
</td>
</tr>
</thead>
<tbody>
<tr>
  <td>
  baseUrl
  </td>
  <td>
  The base URL for your itemsense instance. e.g. http://office.impinj.com/itemsense
  </td>
</tr>
<tr>
  <td>
  username
  </td>
  <td>
  The username for your itemsense credentials. This will be used to encode your requests with a basic auth header. This is optional if you are instead providing an authToken.
  </td>
</tr>
<tr>
  <td>
  password
</td>
  <td>
  The password for your itemsense credentials. This will be used to encode your requests with a basic auth header. This is optional if you are instead providing an authToken.
  </td>
</tr>
</tbody>

</table>


### Authentication
<div id="authentication" />

For more information about authentication, visit http://developer.impinj.com/itemsense/docs/api/#authentication

```java
public Token getToken() 

public Token getToken(String username)

public List<ListTokenResponse> listTokens(String username)

public User validateToken(Token token)

public void revokeToken(Token token) 

public void revokeTokens(String username)

```

### Users

<div id="users" />

For information about users, visit http://developer.impinj.com/itemsense/docs/api/#users

```java

coordinator.getUserController().getUser(username) // returns a user object based on username

coordinator.getUserController().getUsers() // returns all of the users for an itemsense instance

coordinator.getUserController().createUser(user) // creates a user

coordinator.getUserController().updateUser(user) // updates a user

coordinator.getUserController().deleteUser(user) // deletes a user

```


### Global Configuration 

<div id="configuration" />

#### SNMP Configuration
```java
public SnmpConfiguration getSnmpConfiguration()

public void deleteSnmpConfiguration()

public SnmpConfiguration updateSnmpConfiguration(SnmpConfiguration snmpConfiguration)
```


### Software Versions

<div id="softwareVersions" />

```java
public List<VersionInfoView> getVersions(ImageType imageType)

public VersionInfoView getVersion(ImageType imageType, String softwareVersionId)
```

### Software Upgrades

<div id="softwareUpgrades "/>

```Java
public List<UpgradeRequestView> getUpgradeRequests()

public UpgradeStatus getUpgradeStatus(String upgradeInstanceId)

public StartUpgradeResponse startUpgrade(UpgradeRequest upgradeRequest)

public void stopUpgrade(String upgradeInstanceId)
```


### Facilities

<div id="facilities" />

For information about facilities, visit http://developer.impinj.com/itemsense/docs/api/#facilities

```java
coordinator.getFacilityController().getFacility(facilityName) // returns a facility object based on the name

coordinator.getFacilityController().getFacilities() // returns all of the facilities for an itemsense instance

coordinator.getFacilityController().createFacility(facility) // creates a facility

coordinator.getFacilityController().updateFacility(facility) // updates a faciity

coordinator.getFacilityController().deleteFacility(facilityName) // deletes a faciity
```


### Zone Maps

<div id="zoneMaps" />

For information about zone maps, visit http://developer.impinj.com/itemsense/docs/api/#zone-maps

```java
coordinator.getZoneMapController().getZoneMap(zoneMapName) // returns a zone map object based on the name

coordinator.getZoneMapController().getZoneMaps() // returns all of the zone maps for an itemsense instance

coordinator.getZoneMapController().createZoneMap(zoneMap) // creates a zone map

coordinator.getZoneMapController().updateZoneMap(zoneMap) // updates a zone map

coordinator.getZoneMapController().deleteZoneMap(zoneMapName) // deletes a zone map
```

### Current Zone Map

<div id="currentZoneMap" />

```java

coordinator.getCurrentZoneMapController().getCurrentZoneMap(facilityName) // returns the current zonemap for a specific facility

coordinator.getCurrentZoneMapController().setCurrentZoneMap(zoneMapName) // updates/sets the current zone map

coordinator.getCurrentZoneMapController().clearCurrentZoneMap(facilityName) // clears the current zone map value
```

### Reader Definitions

<div id="readerDefintions" />

For information about reader definitions, visit http://developer.impinj.com/itemsense/docs/api/#reader-definitions

```java
coordinator.getReaderDefinitionController().getReaderDefinition(readerDefinitionName) // returns a reader definition object based on the name

itemsense.getReaderDefinitionController().getReaderDefinitions() // returns all of the reader definitions for an itemsense instance

itemsense.getReaderDefinitionController().createReaderDefinition(readerDefinition) // creates a reader definition

itemsense.getReaderDefinitionController().updaterReaderDefinition(readerDefinition) // updates a reader definition

itemsense.getReaderDefinitionController().deleteReaderDefinition(readerDefinitionName) // deletes a reader definition based on the name

itemsense.getReaderDefinitionController().configureFeature(readerDefinitionName, featureRequest) // initiate a feature configuration for a reader

itemsense.getReaderDefinitionController().getFeatureStatus(readerDefinitionName, feature) // returns the current status of the given feature for the reader

itemsense.getReaderDefinitionController().getActiveFeatureRequests(readerDefinitionName) // returns the current state of active feature configuration requests
```

### Reader Configurations

<div id="readerConfigurations" />

For information about reader configurations, visit http://developer.impinj.com/itemsense/docs/api/#reader-configurations

```java
coordinator.getReaderConfigurationController().getReaderConfiguration(readerConfigurationName) // returns a reader configuration object based on the name

coordinator.getReaderConfigurationController().getReaderConfigurations() // returns all of the reader configurations for an itemsense instance

coordinator.getReaderConfigurationController().createReaderConfiguration(readerConfiguration) // creates a reader configuration

coordinator.getReaderConfigurationController().updateReaderConfiguration(readerConfiguration) // updates a reader configuration

coordinator.getReaderConfigurationController().deleteReaderConfiguration(readerConfigurationName) // deletes a reader configuration based on the name
```

### Reader Health

<div id="readerHealth" />

public ReaderStatus getReaderStatus(String readerName)

### Recipes

<div id="recipes" />

For information about recipes, visit http://developer.impinj.com/itemsense/docs/api/#recipes

```java
coordinator.getRecipeController().getRecipe(recipeName) // returns a recipe object based on the name

coordinator.getRecipeController().getRecipes() // returns all of the recipes for an itemsense instance

coordinator.getRecipeController().createRecipe(recipe) // creates a recipe

coordinator.getRecipeController().updateRecipe(recipe) // updates a recipe

coordinator.getRecipeController().deleteRecipe(recipeName) // deletes a recipe based on the name
```


### Jobs

<div id="jobs" />

For information about jobs, visit http://developer.impinj.com/itemsense/docs/api/#jobs

```java
coordinator.getJobController().getJob(jobId) // returns a job object based on the id

coordinator.getJobController().getJobs() // returns all of the jobs for an itemsense instance

coordinator.getJobController().startJob(job) // starts a job

coordinator.getJobController().stopJob(jobId) // stops a job based on the id

```


### Items

<div id="items" />

For information about items, visit http://developer.impinj.com/itemsense/docs/api/#items

```java
data.getItemController.get(queryParams) // Retrieves items from ItemSense. Takes in a map of query Params, but also has multiple overloads

data.getItemHistoryController.getHistory(queryParams) // Retrieves item history records from ItemSense. Takes in a map of query Params, but also has multiple overloads

data.getItemThresholdTransitionController.getThresholdTransition(queryParams) //Retrieve item threshold transition records from ItemSense.  Takes in a map of query Params, but also has multiple overloads
```


## Compatibility Matrix

|ItemSense server version|itemsense-client version|Serialization libraries
|------------------------|------------------------|-----------------------|
|2017r1|5.0.0|Jackson 2.8.2|
|2016r6|4.0.0|Jackson 2.8.2|
|2016r4|2.2|Jackson 2.5.1|
|2016r3 and previous|2.1.4 and previous|Jackson 2.5.1|
