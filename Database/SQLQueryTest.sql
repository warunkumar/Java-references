
<<<<<<<<<<<<<<<<<<<<<<<<< MySQL  >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

Use Warun
DROP TABLE customer;

CREATE TABLE customer(
customer_id int,
customer_name nvarchar(50),
city nvarchar(50),
PRIMARY KEY(customer_id)
)

insert into customer(customer_id,customer_name,city)
values
(1,'warun','motihari');

select * from Warun.dbo.customer;
select * from customer;

CREATE TABLE Persons (
    ID int NOT NULL,
    LastName varchar(255) NOT NULL,
    FirstName varchar(255),
    Age int,
    PRIMARY KEY (ID)
);
INSERT INTO Persons(ID,LastName,FirstName,Age)
values
(1,'kumar','warun',20);

select * from Persons

--========================================================================
USE Warun;

DROP TABLE Persons;

ALTER TABLE Persons
DROP Constraint PK_Person;

CREATE TABLE Persons (
    ID int NOT NULL,
    LastName varchar(255) NOT NULL,
    FirstName varchar(255),
    Age int,
    Constraint PK_Person Primary key(ID)
);
INSERT INTO Persons(ID,LastName,FirstName,Age)values(1,'Hansen','Ola',0);
INSERT INTO Persons(ID,LastName,FirstName,Age)values(2,'Svendson','Tove',23);
INSERT INTO Persons(ID,LastName,FirstName,Age)values(3,'Pettersen','Kari',20);

ALTER TABLE Persons ADD isDelete int DEFAULT 0 NOT NULL

ALTER TABLE Persons ADD isDelete int  NOT NULL DEFAULT (0) 

select * from warun.dbo.Persons

USE Warun
select * from Persons


CREATE TABLE Orders (
    OrderID int NOT NULL,
    OrderNumber int NOT NULL,
    PersonID int,
    Constraint PK_Orders PRIMARY KEY (OrderID),
    CONSTRAINT FK_PersonOrder FOREIGN KEY (PersonID)
    REFERENCES warun.dbo.Persons(ID)
);

INSERT INTO Orders(OrderID,OrderNumber,PersonID)VALUES(1,100,3);
INSERT INTO Orders(OrderID,OrderNumber,PersonID)VALUES(2,300,3);
INSERT INTO Orders(OrderID,OrderNumber,PersonID)VALUES(3,200,2);
INSERT INTO Orders(OrderID,OrderNumber,PersonID)VALUES(4,400,1);

SELECT * FROM Orders

DROP TABLE Orders
---========================================================================

CREATE TABLE Customers
(
CustomerID int NOT NULL,
CustomerName varchar(50),
ContactName varchar(50),
Country varchar(50)
);

DELETE Customers

DROP TABLE Customers

ALTER TABLE Customers
ADD CONSTRAINT cust_PK PRIMARY KEY (CustomerID);

SELECT * FROM Customers;

INSERT INTO Customers(CustomerID,CustomerName,ContactName,Country)VALUES(1,'a','111','india');
INSERT INTO Customers(CustomerID,CustomerName,ContactName,Country)VALUES(2,'b','222','india');
INSERT INTO Customers(CustomerID,CustomerName,ContactName,Country)VALUES(3,'c','333','pak');

CREATE TABLE Orders
(
OrderID int,
OrderDate date,
CustomerID int,
CONSTRAINT order_PK PRIMARY KEY (OrderID),
CONSTRAINT custorder_FK FOREIGN KEY (CustomerID) REFERENCES customers(CustomerID)
);

SELECT * FROM Orders;

INSERT INTO Orders(OrderID,OrderDate,CustomerID)VALUES(100,'1996-09-18',1);
INSERT INTO Orders(OrderID,OrderDate,CustomerID)VALUES(101,'1996-09-19',1);
INSERT INTO Orders(OrderID,OrderDate,CustomerID)VALUES(102,'1996-09-20',2);
INSERT INTO Orders(OrderID,OrderDate,CustomerID)VALUES(103,'1996-09-21',3);
