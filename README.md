# Nearby shops  
A web application providing its users with informations on the closest shops near them using their current location as the center of the scan. The app user has the capability to choose  shops he likes and those he doesn't.

The user is required to give permission to get his location for the app to work, if he doesn't the search will take ***null island with the latitude:0 and longitude:0*** as the center of the search.

During the first access the user needs to register in order to be able to access apps services.

## Project Deployement: 
- mysql-connector in order to connect to the mysql database, this api can be added to the project manually or by adding the dependency to your maven pom.xml for example : 
```
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <version>5.1.6</version>
</dependency>
```
You need to create a database and create the required tables using the provided sql files, then you need to update the connection with the database information in the 'Database.java' class: 
```java
 Class.forName("com.mysql.jdbc.Driver");  
            Connection con=(Connection) DriverManager.getConnection(  
            "jdbc:mysql://ip:port/databasename","username","password");   
```
- this app uses google place api in order to recover the closest locations, thus it requires adding the google api or the dependency in the maven pom.xml : 
```
<dependency>
        <groupId>se.walkercrou</groupId>
        <artifactId>google-places-api-java</artifactId>
        <version>2.1.2</version>
    </dependency>
```
Furthermore, the api requires an api-key in order to connect to google services and recover the requested data. The key needs to be placed in the 'Client.java' class : 
```java
GooglePlaces client = new GooglePlaces("api-key-here");
```
For starters this app uses the user's location as the center of the scan, the scan area is set to 8000m.
```java
client.getNearbyPlaces(latitude, longitude, 8000,40,Param.name("type").value("shopping_mall"),Param.name("rankedby").value("distance"));
```
- The web application offers the possibility to view the location of a shop in google maps. However, same as with the googlePlace api, for this option to work an api key is required to be added in the map.html file.
```javascript
    src="https://maps.googleapis.com/maps/api/js?key=your_key_here&libraries=places&callback=initMap">
```




