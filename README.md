SpatialSearch
=============

SpatialSearch is a RESTful API that allows the user to query geographic entities by latitude and longitude, and extract data. 

Building
--------

SpatialSearch is built with `Maven <http://maven.apache.org/>`. The build produces a WAR file suitable for deployment on any JEE 5 compliant Web Container (i.e. Jetty, Tomcat, etc.). 

To perform a full build, including integration tests (see dependencies below before doing this):

#. mvn clean install

To run the unit tests (in-memory):

#. mvn test


Dependencies
------------

* `PostGIS <http://postgis.refractions.net/>`, the spatial extension to PostgreSQL, is necessary to run the API in production. The Unit tests included with this project use the H2 `GeoDB <https://github.com/jdeolive/geodb>` in-memory database, allowing for rapid development without the need for a database server. 

* Data. The API exposes the State, County and Census Block geographic layers from the 2010 Census Bureau. These can be obtained from the `TIGER <http://www.census.gov/geo/www/tiger/tgrshp2010/tgrshp2010.html>` download page and need to be imported into PostGIS in order to be able to publish the API. SpatialSearch uses the default schema of the tables, grouped into a census schema within a database called gisdb by default. All these parameters can be changed

* SpatialSearch uses `Hibernate Spatial <http://www.hibernatespatial.org/>` for the geospatial functionality. This library supports the same type of functionality on other Spatial DBMS systems such as Oracle Spatial, Microsoft SQL Server, etc. For more information please visit its website.

Usage
-----

This first version of the API exposes a "point in polygon" functionality, as follows (example running locally from embedded Jetty Servlet Container)

http://localhost:8081/spatialsearch/census/<geography>?latitude=<latitude>&longitude=<longitude>&format=<format>

where

<geography> is the type of layer being queried. Currently it can take the following values: state2010, county2010, block2010

<longitude> is the Longitude of the position to query on. Expresses in decimal degrees, WGS84 projection is assumed (EPSG code 4326)

<latitude> is the Latitude of the position to query on. Expresses in decimal degrees, WGS84 projection is assumed (EPSG code 4326)

<format> is the output format. Currently it can take the following values: xml, json and jsonp. This parameter is optional, if not specified the response will be enconded as XML

