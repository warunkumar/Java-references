DROP table IF EXISTS userdata;
CREATE TABLE userdata AS SELECT * from CSVREAD('classpath:userdata.csv');