drop schema CENSUS if exists;

create schema CENSUS;

drop table CENSUS.STATE2010 if exists;

CREATE TABLE CENSUS.STATE2010 (id int PRIMARY KEY,geoid10 varchar(2), name10 varchar(50),stusps10 varchar(2),geom blob);
CALL CreateSpatialIndex('CENSUS','STATE2010','GEOM','4326');

drop table CENSUS.COUNTY2010 if exists;

CREATE TABLE CENSUS.COUNTY2010(ID int PRIMARY KEY, statefp10 varchar(2), countyfp10 varchar(3), geoid10 varchar(5), namelsad10 varchar(100), geom blob);
CALL CreateSpatialIndex('CENSUS','COUNTY2010','GEOM',4326);

drop table CENSUS.TRACT2010 if exists;

CREATE TABLE CENSUS.TRACT2010(ID int PRIMARY KEY, statefp10 varchar(2), geoid10 varchar(11), name10 varchar(7), geom blob);
CALL CreateSpatialIndex('CENSUS','TRACT2010','GEOM',4326);

drop table CENSUS.BLOCK2010 if exists;

CREATE TABLE CENSUS.BLOCK2010 (ID int PRIMARY KEY,statefp10 varchar(2),countyfp10 VARCHAR(3),geoid10 varchar(15), geom blob);
CALL CreateSpatialIndex('CENSUS','BLOCK2010','GEOM','4326');
