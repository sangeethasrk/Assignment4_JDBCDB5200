/****** Script for SelectTopNRows command from SSMS  ******/
Create TABLE Users
(
	[EmployeeID] Varchar(50)Not Null,
	[EmployeeName] Varchar(50) Not Null,
	[Password] Varchar(50) Not Null,
	[City] Varchar(100)Not Null,
	[BloodGroup] Varchar(10)Not Null,
	[Email]  Varchar(100)Not Null,
	[PhoneNumber]  Varchar(50)Not Null,
	CONSTRAINT pk_EmpID PRIMARY KEY([EmployeeID])
);

Create TABLE Requests
(
	[RequestID] INT IDENTITY(1,1),
	[EmployeeID] Varchar(50) Not Null,
	[BloodGroupRequested] Varchar(10) Not Null,
	[Location] Varchar(50) Not Null,
	CONSTRAINT pk_RID PRIMARY KEY([RequestID]),
	CONSTRAINT fk_EmpID FOREIGN KEY([EmployeeID])REFERENCES Users([EmployeeID]) 
	On Update Cascade
	On Delete Cascade
);

Create Table Donors
( 
[EmployeeID] Varchar(50)Not Null,
[LastDonatedDate] date Not Null,
[DonateCount] Int not null,
CONSTRAINT fkdonor_EmpID FOREIGN KEY([EmployeeID])REFERENCES Users([EmployeeID])
On Update Cascade
On Delete Cascade
);

Insert into Users values ('PI589', 'Sangeetha','Abc-1234','Bangalore','B+ve', 'sangeetha.svrmkrshnn@gmail.com', '+1-617-870-1912');
Insert into Users values ('PI590', 'Shivani','Abc-1235','Boston','A+ve', 'shivani.srk@gmail.com', '+1-617-870-1912');
Insert into Users values ('PI591', 'Alex','Abc-1236','New York','A-ve', 'aleximacrev@gmail.com', '+1-617-870-1912');
Insert into Users values ('PI592', 'Bob','Abc-1237','Bangalore','B+ve', 'sangeetha.srk@outlook.com', '+1-617-870-1912');
Insert into Users values ('PI593', 'Marcella','Abc-1238','Bangalore','O+ve', 'abc@cdf.com', '+1-617-870-1912');
Insert into Users values ('PI594', 'Nicki','Abc-1239','Bangalore','O-ve', 'sangeetha.svrmkrshnn@gmail.com', '+1-617-870-1912');
Insert into Users values ('PI595', 'Karen','Abc-1240','Bangalore','AB+ve', 'sangeetha.svrmkrshnn@gmail.com', '+1-617-870-1912');
Insert into Users values ('PI596', 'Ravi','Abc-1241','Bangalore','AB-ve', 'sangeetha.svrmkrshnn@gmail.com', '+1-617-870-1912');

Insert into Requests values ('PI589', 'B+ve', 'Bangalore');

Insert into Donors values ('PI589', GETUTCDATE(), 4);

Select * from Users;
Select * from Requests;
Select * from Donors;

