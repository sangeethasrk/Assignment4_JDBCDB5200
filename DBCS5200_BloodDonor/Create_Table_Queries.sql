CREATE DATABASE DBCS5200_BLOOD_DONOR;
USE DBCS5200_BLOOD_DONOR;

CREATE TABLE Users
( uid int PRIMARY KEY IDENTITY(1,1) not null,
  name varchar(25) not null,
  age int not null,
  bloodgroup varchar(3) not null,
  address varchar(255) not null,
  phone varchar(20) not null,
  email varchar(25) not null,
  type smallint not null);


CREATE TABLE Email
 ( eid int PRIMARY KEY IDENTITY(1,1) not null,
  body varchar(255) null,
  subject varchar(50) null,
  notifier int not null,
  foreign key (notifier) references Users (uid)
  on delete cascade
  on update cascade);


CREATE TABLE Notifier 
( notifierid int PRIMARY KEY not null,
  emailid int not null,
  foreign key (notifierid) references Users (uid),
  foreign key (emailid) references Email (eid));

CREATE TABLE Login
( userid int PRIMARY KEY not null,
  username int not null,
  password varchar(10) not null,
  foreign key (userid) references Users (uid),
  foreign key (username) references Email (eid)
  on delete cascade);

CREATE TABLE Donor
( did int PRIMARY KEY not null,
  bloodgroup varchar(3) not null,
  lastdonated date not null,
  donorpoints int not null,
  foreign key (did) references Users (uid)
  on delete cascade
  on update cascade);

CREATE TABLE DonationHistory
( donorid int PRIMARY KEY not null,
  bloodrequestid int not null,
  foreign key (donorid) references Users (uid)
  on delete no action
  on update cascade);

CREATE TABLE BloodDrive
( drive_id int PRIMARY KEY IDENTITY(1,1) not null,
  user_id int not null,
  drivedate date not null,
  drivetype varchar(25) not null,
  timeslot time not null,
  driveactive bit not null,
  no_of_participants int not null,
  foreign key (user_id) references Users (uid)
  on delete cascade
  on update cascade);


CREATE TABLE AppointmentScheduler
( driveid int PRIMARY KEY not null,
  donorid int not null,
  activedrive bit not null,
  foreign key (driveid) references BloodDrive (drive_id),
  foreign key (donorid) references Users (uid));


CREATE TABLE BloodRequirementRequest
( requestid int PRIMARY KEY IDENTITY(1,1) not null,
  bloodgroup varchar(3) not null,
  userid int not null,
  platelets bit not null,
  doubleredcells bit not null,
  blood bit not null,
  foreign key (userid) references Users (uid)
  on delete cascade
  on update cascade);


CREATE TABLE DriveDonorLookup
( user_id int PRIMARY KEY not null,
  drive_id int not null,
  foreign key (user_id) references Users (uid)
  on delete cascade
  on update cascade,
  foreign key (drive_id) references BloodDrive (drive_id)
  on delete no action
  on update no action);