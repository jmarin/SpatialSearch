drop schema CENSUS if exists;

create schema CENSUS;

drop schema BBMAP if exists;

create schema BBMAP;

drop table CENSUS.STATE2010 if exists;

CREATE TABLE CENSUS.STATE2010 (id int PRIMARY KEY,name10 varchar(50), geoid10 varchar(2),stusps10 varchar(2),geom blob);
CALL CreateSpatialIndex('CENSUS','STATE2010','GEOM','4326');

