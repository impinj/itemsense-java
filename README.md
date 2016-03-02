# itemsense-java
> itemsense-java is an API wrapper library for Impinj's ItemSense. This wrapper will be kept up to date with the latest ItemSense features.

## Install
itemsense-java is available as a dependency on Maven Central [here.](http://mvnrepository.com/artifact/com.impinj/itemsense-client)

```
<dependency>
	<groupId>com.impinj</groupId>
	<artifactId>itemsense-client</artifactId>
	<version>2.0.1</version>
</dependency>
```

## Basic Usage
Once this dependency is included in your project, you can instantiate the two base controllers for coordination and data endpoints.

Check out this sample of a class that instantiates both controllers:

```java
// Factory Created in order to facilitate multiple ItemSense API  endpoints
public class ItemSenseApiFactory {


    private ItemSenseApiFactory(){

    }

    //Creates a controller for the data endpoints of ItemSense
    public static DataApiController getDataApiController(ItemSenseConfiguration itemSenseConfiguration){

        Client client = ClientBuilder.newClient().register(HttpAuthenticationFeature.basic(itemSenseConfiguration.getUserName(), itemSenseConfiguration.getPassword()));
        DataApiController dataApiController = new DataApiController( client, URI.create(itemSenseConfiguration.getBaseUrl()));
        return dataApiController;
    }

    ///Creates a controller for the data endpoints
    public static CoordinatorApiController getCoordinatorApiController(ItemSenseConfiguration itemSenseConfiguration){

        Client client = ClientBuilder.newClient().register(HttpAuthenticationFeature.basic(itemSenseConfiguration.getUserName(), itemSenseConfiguration.getPassword()));
        CoordinatorApiController coordinatorApiController = new CoordinatorApiController( client, URI.create(itemSenseConfiguration.getBaseUrl()));
        return coordinatorApiController;
    }
}
```

### Table of Contents
1. <a href="#itemsenseConfig">ItemSense Configuration</a>
2. <a href="#users">Users</a>
3. <a href="#zoneMaps">Zone Maps </a>
4. <a href= "#currentZoneMap"> Current Zone Map </a>
5. <a href= "#readerDefinitions" >Reader Definitions </a>
6. <a href ="#readerConfigurations"> Reader Configurations </a>
7. <a href= "#jobs" >Jobs </a>
8. <a href= "#items">Items </a>



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



### Users

<div id="users" />

For information about users, visit http://developer.impinj.com/itemsense/docs/api/#users

```java

coordinator.getUserController().getUser((username) // returns a user object based on username

coordinator.getUserController().getUsers() // returns all of the users for an itemsense instance

coordinator.getUserController().createUser(user) // creates a user

coordinator.getUserController().updateUser(user) //updates a user

coordinator.getUserController().deleteUser(user) //deletes a user

```
### Facilities

<div id="facilities" />

For information about facilities, visit http://developer.impinj.com/itemsense/docs/api/#facilities

```java
coordinator.getFacilityController().getFacility(facilityName) // returns a facility object based on the name

coordinator.getFacilityController().getFacilities() // returns all of the facilities for an itemsense instance

coordinator.getFacilityController().create(facility) // creates a facility

coordinator.getFacilityController().createOrReplace(facility) //updates a faciity

coordinator.getFacilityController().destroy(facilityName) //deletes a faciity
```


### Zone Maps

<div id="zoneMaps" />

For information about zone maps, visit http://developer.impinj.com/itemsense/docs/api/#zone-maps

```java
coordinator.getZoneMapController().getZoneMap(zoneMapName) // returns a zone map object based on the name

coordinator.getZoneMapController().getZoneMaps() // returns all of the zone maps for an itemsense instance

coordinator.getZoneMapController().createZoneMap(zoneMap) // creates a zone map

coordinator.getZoneMapController().updateZoneMap(zoneMap) //updates a zone map

coordinator.getZoneMapController().deleteZoneMap(zoneMapName) //deletes a zone map
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

For information about zone maps, visit http://developer.impinj.com/itemsense/docs/api/#reader-definitions

```java
coordinator.getReaderDefinitionController().getReaderDefinition(readerDefinitionName) // returns a reader definition object based on the name

itemsense.getReaderDefinitionController().getReaderDefinitions() // returns all of the reader definitions for an itemsense instance

itemsense.getReaderDefinitionController().createReaderDefinition(readerDefinition) // creates a reader definition

itemsense.getReaderDefinitionController().updaterReaderDefinition(readerDefinition) //updates a reader definition

itemsense.getReaderDefinitionController().deleteReaderDefinition(readerDefinitionName) //deletes a reader definition based on the name
```

### Reader Configurations

<div id="readerConfigurations" />

For information about zone maps, visit http://developer.impinj.com/itemsense/docs/api/#reader-configurations

```java
coordinator.getReaderConfigurationController().getReaderConfiguration(readerConfigurationName) // returns a reader configuration object based on the name

coordinator.getReaderConfigurationController().getReaderConfigurations() // returns all of the reader configurations for an itemsense instance

coordinator.getReaderConfigurationController().createReaderConfiguration(readerConfiguration) // creates a reader configuration

coordinator.getReaderConfigurationController().updateReaderConfiguration(readerConfiguration) //updates a reader configuration

coordinator.getReaderConfigurationController().deleteReaderConfiguration(readerConfigurationName) //deletes a reader configuration based on the name
```


### Jobs

<div id="jobs" />

For information about jobs, visit http://developer.impinj.com/itemsense/docs/api/#jobs

```java
coordinator.getJobController().getJob(jobId) // returns a job object based on the id

coordinator.getJobController().getJobs() // returns all of the jobs for an itemsense instance

coordinator.getJobController().startJob(job) // starts a job

coordinator.getJobController().stopJob(jobId) //stops a job based on the id

```

### Items

<div id="items" />

For information about items, visit http://developer.impinj.com/itemsense/docs/api/#items

```java
data.getItemController.get(queryParams) // Retrieves items from ItemSense. Takes in a map of query Params, but also has multiple overloads

data.getItemHistoryController.getHistory(queryParams) // Retrieves item history records from ItemSense. Takes in a map of query Params, but also has multiple overloads
```


