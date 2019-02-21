# itemsense-java
> itemsense-java is an API wrapper library for Impinj's ItemSense.

## Install
itemsense-java is available as a dependency on Maven Central [here.](http://mvnrepository.com/artifact/com.impinj/itemsense-client)

```
<dependency>
	<groupId>com.impinj</groupId>
	<artifactId>itemsense-client</artifactId>
	<version>5.1.0</version>
</dependency>
```

## Dependencies

To use the client library, you need to create an HTTP client, which is an implementation of `javax.ws.rs.client.Client`, as well as include a JSON Jackson de/serialization provider in the classpath:

> Note: do not use the jersey-media-json-jackson as the Jackson de/serialization library. It has known issues with de/serializing collection classes (of which there are many in the ItemSense API).

```
<dependency>
  <groupId>org.glassfish.jersey.core</groupId>
  <artifactId>jersey-client</artifactId>
  <version>2.27</version>
</dependency>

<dependency>
  <groupId>org.glassfish.jersey.media</groupId>
  <artifactId>jersey-media-json-jackson</artifactId>
  <version>2.27</version>
</dependency>

<dependency>
  <groupId>com.fasterxml.jackson.jaxrs</groupId>
  <artifactId>jackson-jaxrs-base</artifactId>
  <version>2.9.7</version>
</dependency>
```

The following sample creates a Jersey client, and makes a call to both the configuration API and the data API. You can extend this sample to fulfill the needs of your application.

The ITEMSENSE BASE URL is the protocol and name (or IP address) of your ItemSense server, with the `itemsense` prefix. For example: `http://itemsense.mycompany.com/itemsense`

```java
package com.mycompany;

import com.impinj.itemsense.client.coordinator.CoordinatorApiController;
import com.impinj.itemsense.client.coordinator.facility.Facility;
import com.impinj.itemsense.client.data.DataApiController;
import com.impinj.itemsense.client.data.item.Item;

import org.glassfish.jersey.client.authentication.HttpAuthenticationFeature;
import org.glassfish.jersey.filter.LoggingFilter;
import org.glassfish.jersey.jackson.JacksonFeature;
import com.impinj.itemsense.client.data.itemhistory.ItemHistory;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

import java.net.URI;

import java.util.List;
import java.util.logging.Logger;

public class App
{
    public static void main( String[] args ) {

      final String url = "<ENTER YOUR ITEMSENSE BASE URL HERE>";
      final String username = "<ENTER YOUR ITEMSENSE USERNAME HERE>";
      final String password = "<ENTER YOUR ITEMSENSE PASSWORD HERE>";

      final Logger logger = Logger.getLogger(App.class.getName());

      final LoggingFilter filter = new LoggingFilter();

      logger.info("Running at: " + url + " with user: " + username );

      Client client = ClientBuilder.newClient()
          .register(JacksonFeature.class)
          .register(filter)
          .register(HttpAuthenticationFeature.basic(username, password));

      CoordinatorApiController configApi = new CoordinatorApiController(client, URI.create(url));

      List<Facility> facilities = configApi.getFacilityController().getAllFacilities();

      if (facilities == null) {
        logger.severe("Facilities is null - aborting");
        return;
      }

      for (Facility facility : facilities) {
        logger.info(facility.toString());
      }
      
      DataApiController dataApi = new DataApiController(client, URI.create(url));

      List<Item> items = dataApi.getItemController().getAllItems();

      if (items == null) {
        logger.severe("Items is null - aborting");
        return;
      }

      for (Item item: items) {
        logger.info(item.toString());
      }

    }
}
```



### Table of Contents
1. <a href= "#authentication">Authentication</a>
1. <a href= "#users">Users</a>
1. <a href= "#configuration">Global Configuration </a>
1. <a href= "#softwareVersions">Software Versions </a>
1. <a href= "#zoneMaps">Zone Maps </a>
1. <a href= "#currentZoneMap">Current Zone Map </a>
1. <a href= "#readerDefinitions" >Reader Definitions </a>
1. <a href= "#readerConfigurations">Reader Configurations </a>
1. <a href= "#readerHealth">Reader Health </a>
1. <a href= "#recipes">Recipes </a>
1. <a href= "#jobs" >Jobs </a>
1. <a href= "#items">Items </a>


### Authentication
<div id="authentication" />

For more information about authentication, visit https://platform.impinj.com/site/developer/itemsense/apidocs/#TOC15

Methods of `CoordinatorApiController.getAuthorizationController`: 

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

For information about users, visit https://platform.impinj.com/site/developer/itemsense/apidocs/#TOC6

Methods of `CoordinatorApiController.getUserController`: 


```java

public User getUserController().getUser(username) // returns a user object based on username

public List<User> getUserController().getUsers() // returns all of the users for an itemsense instance

public User getUserController().createUser(user) // creates a user

pubic User getUserController().updateUser(user) // updates a user 

public void getUserController().deleteUser(user) // deletes a user

```


### Global Configuration 

<div id="configuration" />

#### SNMP Configuration

Methods of `CoordinatorApiController.getSnmpController`: 

```java
public SnmpConfiguration getSnmpConfiguration()

public void deleteSnmpConfiguration()

public SnmpConfiguration updateSnmpConfiguration(SnmpConfiguration snmpConfiguration)
```


### Software Versions

<div id="softwareVersions" />

Methods of `CoordinatorApiController.getSoftwareVersionsController`: 


```java
public List<VersionInfoView> getVersions(ImageType imageType)

public VersionInfoView getVersion(ImageType imageType, String softwareVersionId)
```

### Software Upgrades

<div id="softwareUpgrades "/>

Methods of `CoordinatorApiController.getSoftwareUpgradesController`: 


```Java
public List<UpgradeRequestView> getUpgradeRequests()

public UpgradeStatus getUpgradeStatus(String upgradeInstanceId)

public StartUpgradeResponse startUpgrade(UpgradeRequest upgradeRequest)

public void stopUpgrade(String upgradeInstanceId)
```


### Facilities

<div id="facilities" />

For information about facilities, visit https://platform.impinj.com/site/developer/itemsense/apidocs/#TOC23

Methods of `CoordinatorApiController.getFacilitiesController`: 


```java
public Facility getFacilityController().getFacility(facilityName) // returns a facility object based on the name

public List<Facility> getFacilityController().getFacilities() // returns all of the facilities for an itemsense instance

public Facility getFacilityController().createFacility(facility) // creates a facility

public Facility getFacilityController().updateFacility(facility) // updates a faciity

public void getFacilityController().deleteFacility(facilityName) // deletes a faciity
```


### Zone Maps

<div id="zoneMaps" />

For information about zone maps, visit https://platform.impinj.com/site/developer/itemsense/apidocs/#TOC29

Methods of `CoordinatorApiController.getZoneMapController`: 


```java
public ZoneMap getZoneMapController().getZoneMap(zoneMapName) // returns a zone map object based on the name

public List<ZoneMap> getZoneMapController().getZoneMaps() // returns all of the zone maps for an itemsense instance

public ZoneMap getZoneMapController().createZoneMap(zoneMap) // creates a zone map

public Zone Map getZoneMapController().updateZoneMap(zoneMap) // updates a zone map

public void getZoneMapController().deleteZoneMap(zoneMapName) // deletes a zone map
```

### Current Zone Map

<div id="currentZoneMap" />

Methods of `CoordinatorApiController.getCurrentZoneMapController`: 


```java
public ZoneMap getCurrentZoneMapController().getCurrentZoneMap(facilityName) // returns the current zonemap for a specific facility

public ZoneMap getCurrentZoneMapController().setCurrentZoneMap(zoneMapName) // updates/sets the current zone map

public void getCurrentZoneMapController().clearCurrentZoneMap(facilityName) // clears the current zone map value
```

### Reader Definitions

<div id="readerDefinitions" />

For information about reader definitions, visit https://platform.impinj.com/site/developer/itemsense/apidocs/#TOC39

Methods of `CoordinatorApiController.getReaderDefinitionController`: 


```java
public ReaderDefinition getReaderDefinitionController().getReaderDefinition(readerDefinitionName) // returns a reader definition object based on the name

public List<ReaderDefinition> getReaderDefinitionController().getReaderDefinitions() // returns all of the reader definitions for an itemsense instance

public ReaderDefinition getReaderDefinitionController().createReaderDefinition(readerDefinition) // creates a reader definition

public ReaderDefinition getReaderDefinitionController().updaterReaderDefinition(readerDefinition) // updates a reader definition

public void getReaderDefinitionController().deleteReaderDefinition(readerDefinitionName) // deletes a reader definition based on the name

public ReaderFeatureStatus getReaderDefinitionController().configureFeature(readerDefinitionName, featureRequest) // initiate a feature configuration for a reader

public ReaderFeatureStatus getReaderDefinitionController().getFeatureStatus(readerDefinitionName, feature) // returns the current status of the given feature for the reader

public Map<ReaderFeature, ReaderFeatureStatus> getReaderDefinitionController().getActiveFeatureRequests(readerDefinitionName) // returns the current state of active feature configuration requests
```

### Reader Configurations

<div id="readerConfigurations" />

For information about reader configurations, visit https://platform.impinj.com/site/developer/itemsense/apidocs/#TOC51

Methods of `CoordinatorApiController.getReaderConfigurationController`: 


```java
public ReaderConfiguration getReaderConfigurationController().getReaderConfiguration(readerConfigurationName) // returns a reader configuration object based on the name

public List<ReaderConfiguration> getReaderConfigurationController().getReaderConfigurations() // returns all of the reader configurations for an itemsense instance

public ReaderConfiguration getReaderConfigurationController().createReaderConfiguration(readerConfiguration) // creates a reader configuration

public ReaderConfiguration getReaderConfigurationController().updateReaderConfiguration(readerConfiguration) // updates a reader configuration

public void getReaderConfigurationController().deleteReaderConfiguration(readerConfigurationName) // deletes a reader configuration based on the name
```

### Reader Health

<div id="readerHealth" />

Methods of `CoordinatorApiController.getHealthController`: 


```java
public ReaderStatus getReaderStatus(String readerName)
```

### Recipes

<div id="recipes" />

For information about recipes, visit https://platform.impinj.com/site/developer/itemsense/apidocs/#TOC70

Methods of `CoordinatorApiController.getRecipeController`: 


```java
public Recipe getRecipeController().getRecipe(recipeName) // returns a recipe object based on the name

public List<Recipe> getRecipeController().getRecipes() // returns all of the recipes for an itemsense instance

public Recipe getRecipeController().createRecipe(recipe) // creates a recipe

public Recipe getRecipeController().updateRecipe(recipe) // updates a recipe

public void getRecipeController().deleteRecipe(recipeName) // deletes a recipe based on the name
```


### Jobs

<div id="jobs" />

For information about jobs, visit https://platform.impinj.com/site/developer/itemsense/apidocs/#TOC76

Methods of `CoordinatorApiController.getJobController`: 


```java
public Job getJobController().getJob(jobId) // returns a job object based on the id

public List<Job> getJobController().getJobs() // returns all of the jobs for an itemsense instance

public Job getJobController().startJob(job) // starts a job

public Job getJobController().stopJob(jobId) // stops a job based on the id

```


### Items

<div id="items" />

For information about items, visit https://platform.impinj.com/site/developer/itemsense/apidocs/#TOC81

Methods of `DataApiController.getDataController`: 


```java
public List<Item> getItemController.get(queryParams) // Retrieves items from ItemSense. Takes in a map of query Params, but also has multiple overloads

public List<ItemHistory> getItemHistoryController.getHistory(queryParams) // Retrieves item history records from ItemSense. Takes in a map of query Params, but also has multiple overloads

public List<ThresholdTransition> getItemThresholdTransitionController.getThresholdTransition(queryParams) //Retrieve item threshold transition records from ItemSense.  Takes in a map of query Params, but also has multiple overloads
```


## Compatibility Matrix

|ItemSense server version|itemsense-client version|Serialization libraries
|------------------------|------------------------|-----------------------|
|2018r2|5.1.0|Jackson 2.9.7|
|2018r1|5.0.0|Jackson 2.8.2|
|2017r1|5.0.0|Jackson 2.8.2|
|2016r6|4.0.0|Jackson 2.8.2|
|2016r4|2.2|Jackson 2.5.1|
|2016r3 and previous|2.1.4 and previous|Jackson 2.5.1|
