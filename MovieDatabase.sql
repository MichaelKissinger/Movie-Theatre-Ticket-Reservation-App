DROP DATABASE IF EXISTS MOVIESYSTEM;
CREATE DATABASE MOVIESYSTEM;
USE MOVIESYSTEM;

DROP TABLE IF EXISTS  MOVIE;
CREATE TABLE MOVIE(
	MovieID int NOT NULL AUTO_INCREMENT,
	Title varchar(50) NOT NULL,
    Synopsis varchar(50),
    PRIMARY KEY(MovieID)
);
INSERT INTO MOVIE(Title, Synopsis)
 VALUES
 ("Starwars", "A long time ago"),
 ("Spiderman", "No way home"),
 ("Silent Night", ""),
 ("James Bond", "007"),
 ("Step Brothers", "Brothers of step"),
 ("Ghostbusters", "spooky"),
 ("Fast and Furious", "Cars and guns");

DROP TABLE IF EXISTS  SHOWING;
CREATE TABLE SHOWING(
	ShowingID int NOT NULL AUTO_INCREMENT,
    MovieID int NOT NULL, 
    ShowTime DATETIME,
    TicketPrice float,
    TheatreID int,
    PRIMARY KEY(ShowingID),
    FOREIGN KEY ( MovieID ) REFERENCES MOVIE(MovieID));
    
INSERT INTO Showing(MovieID, ShowTime, TicketPrice, TheatreID)
VALUES
(1, "2021-12-20 20:05:00", 12.50, 1),
(2, "2021-12-22 20:05:00", 9.00, 1),
(3, "2021-12-21 20:05:00", 12.00, 1),
(4, "2021-12-24 20:05:00", 9.00, 1),
(5, "2021-12-25 20:05:00", 7.00, 1),
(6, "2021-12-26 20:05:00", 6.00, 1),
(7, "2021-12-28 20:05:00", 8.00, 1),
(1, "2021-12-3 20:05:00", 10.30, 1),
(1, "2021-12-6 20:05:00", 12.90, 1)
;
    
DROP TABLE IF EXISTS USER;
CREATE TABLE USER(
	UserID int NOT NULL AUTO_INCREMENT,
    IsRegistered BOOL,
    Name varchar(25),
    Address varchar(50),
    Email varchar(50),
    Password varchar(15),
    ActiveStatus BOOL,
    LastPaymentDate DATETIME,
    PRIMARY KEY(UserID));
    
Insert INTO USER(IsRegistered, Name, Address, Email, Password, ActiveStatus, LastPaymentDate)
Values
(True, "Kody", "CALGARY SOMEWHERE", "kodykou@ucalgary.ca", "fakepassword", True, "2020-12-20 00:00:00"),
(True, "Jared", "CALGARY SOMEWHEREELSE", "JARED@uc.ca", "fakepassword1", True, "2021-12-20 00:00:00"),
(True, "Mike", "Calgarylowercased", "mikek@ucalgary.ca", "fakepassword2", True, "2021-10-20 00:00:00"),
(True, "Nic", "calgary4thspelling", "nickl@ucalgary.ca", "fakepassword3", False, NULL),
(False, "", "", "nonregistereduser@ucalgary.ca", "", False, NULL);

UPDATE USER SET ActiveStatus = 
Case
when (current_timestamp <( SELECT DATE_ADD(LastPaymentDate, INTERVAL 1 YEAR))) THEN true 
Else false 
END;

CREATE TABLE CREDITCARD(
	CardID int not null auto_increment,
    UserID int,
    CardHolderName varchar(50),
    cardNumber varchar(16) not null,
    expiryMonth int, 
    expiryYear int,
    cvv int,
    Primary key (CardID),
    FOREIGN KEY (UserID) References User(UserID)
);
INSERT INTO CREDITCARD(UserID, CardHolderName, CardNumber, expiryMonth, expiryYear, cvv)
VALUES
(1, "YINGCHENG KOU", "1000200030004000", 08, 23, 999),
(2, "jared", "4321123489891122", 12, 21, 888),
(3, "Mike",  "2000400080009000", 10, 22, 222),
(4, "Nic", "1000300020004000", 09, 23, 986);




    
CREATE TABLE TRANSACTION(
	TransactionID int NOT NULL AUTO_INCREMENT,
    UserID int,
    Cost float,
    PurchaseDate DATETIME, 
    CardID int,
    ShowingID int,
    PRIMARY KEY(TransactionID),
    FOREIGN KEY(UserID) REFERENCES USER(UserID)
    );
INSERT INTO TRANSACTION(UserID, Cost, PurchaseDate, CardID, ShowingID)
VALUES
(1, 59,  "2021-12-01 00:00:00", 1, 1),
(2,  43, "2021-12-04 00:00:00", 4, 4),
(3, 21, "2021-05-03 00:00:00", 3, 8);

CREATE TABLE SEATS(
	ShowingID int,
    rownum char,
    colnum int,
    TransactionID int,
    FOREIGN KEY (ShowingID) REFERENCES SHOWING(ShowingID),
    FOREIGN KEY (TransactionID) REFERENCES TRANSACTION(TransactionID),
    PRIMARY KEY(ShowingID, rownum, colnum));


CREATE TABLE MovieCredits(
	CreditID int NOT NULL AUTO_INCREMENT,
    CreditCode varchar(20),
    ExpiryDate DATETIME, 
    Amount float,
	UserID int,
    PRIMARY KEY(CreditID),
    FOREIGN KEY(UserID) REFERENCES USER(UserID)
    );
INSERT INTO MovieCredits(CreditCode, ExpiryDate, Amount, UserID)
Values
("Refund", "2023-12-25 00:00:00", 12.00, 1),
("Promotional discount", "2021-12-25 00:00:00", 10.00, 2),
("Refund", "2020-12-25 00:00:00", 8.00, 2),
("Error compensation", "2024-12-25 00:00:00", 50.00, 1),
("Refund", "2023-12-25 00:00:00", 12.00, 3);

DROP TABLE IF EXISTS  MESSAGE;
CREATE TABLE MESSAGE(
	MessageID int NOT NULL AUTO_INCREMENT,
    UserID int ,
	Message varchar(200) ,
	SubjectLine varchar(50),
    SentDate DATETIME,
    ReadStatus boolean,
    PRIMARY KEY(messageID),
    FOREIGN KEY(UserID) REFERENCES USER(UserID)
);
INSERT INTO MESSAGE(userID, message, subjectLine, sentDate, readStatus)
 VALUES(1, "Check out SpiderMan Far From Home on the big screen! Coming to a theatre near you on December.17th, 2021! Tickets out now!", "Announcement", "2021-12-06 00:00:00", false),
 (2, "Check out SpiderMan Far From Home on the big screen! Coming to a theatre near you on December.17th, 2021! Tickets out now!", "Announcement", "2021-12-06 00:00:00", false),
 (3, "Check out SpiderMan Far From Home on the big screen! Coming to a theatre near you on December.17th, 2021! Tickets out now!", "Announcement", "2021-12-06 00:00:00", false),
 (4, "Check out SpiderMan Far From Home on the big screen! Coming to a theatre near you on December.17th, 2021! Tickets out now!", "Announcement", "2021-12-06 00:00:00", false);
    
INSERT INTO Seats(ShowingID, rownum, colnum, TransactionID)
VALUES(1, 'A',1, null),
(1, 'A',2, null),
(1, 'A',3, 1),
(1, 'A',4, 1),
(1, 'A',5, 1),
(1, 'B',1, null),
(1, 'B',2, null),
(1, 'B',3, null),
(1, 'B',4, null),
(1, 'B',5, null),
(1, 'C',1, null),
(1, 'C',2, null),
(1, 'C',3, null),
(1, 'C',4, null),
(1, 'C',5, null),
(1, 'D',1, null),
(1, 'D',2, null),
(1, 'D',3, null),
(1, 'D',4, null),
(1, 'D',5, null),
(1, 'E',1, null),
(1, 'E',2, null),
(1, 'E',3, null),
(1, 'E',4, null),
(1, 'E',5, null),
(2, 'A',1, null),
(2, 'A',2, null),
(2, 'A',3, null),
(2, 'A',4, null),
(2, 'A',5, null),
(2, 'B',1, null),
(2, 'B',2, null),
(2, 'B',3, null),
(2, 'B',4, null),
(2, 'B',5, null),
(2, 'C',1, null),
(2, 'C',2, null),
(2, 'C',3, null),
(2, 'C',4, null),
(2, 'C',5, null),
(2, 'D',1, null),
(2, 'D',2, null),
(2, 'D',3, null),
(2, 'D',4, null),
(2, 'D',5, null),
(2, 'E',1, null),
(2, 'E',2, null),
(2, 'E',3, null),
(2, 'E',4, null),
(2, 'E',5, null),
(3, 'A',1, null),
(3, 'A',2, null),
(3, 'A',3, null),
(3, 'A',4, null),
(3, 'A',5, null),
(3, 'B',1, null),
(3, 'B',2, null),
(3, 'B',3, null),
(3, 'B',4, null),
(3, 'B',5, null),
(3, 'C',1, null),
(3, 'C',2, null),
(3, 'C',3, null),
(3, 'C',4, null),
(3, 'C',5, null),
(3, 'D',1, null),
(3, 'D',2, null),
(3, 'D',3, null),
(3, 'D',4, null),
(3, 'D',5, null),
(3, 'E',1, null),
(3, 'E',2, null),
(3, 'E',3, null),
(3, 'E',4, null),
(3, 'E',5, null),
(4, 'A',1, null),
(4, 'A',2, null),
(4, 'A',3, null),
(4, 'A',4, null),
(4, 'A',5, null),
(4, 'B',1, null),
(4, 'B',2, null),
(4, 'B',3, null),
(4, 'B',4, null),
(4, 'B',5, null),
(4, 'C',1, 2),
(4, 'C',2, 2),
(4, 'C',3, null),
(4, 'C',4, null),
(4, 'C',5, null),
(4, 'D',1, null),
(4, 'D',2, null),
(4, 'D',3, 2),
(4, 'D',4, 2),
(4, 'D',5, null),
(4, 'E',1, null),
(4, 'E',2, null),
(4, 'E',3, null),
(4, 'E',4, null),
(4, 'E',5, null),
(5, 'A',1, null),
(5, 'A',2, null),
(5, 'A',3, null),
(5, 'A',4, null),
(5, 'A',5, null),
(5, 'B',1, null),
(5, 'B',2, null),
(5, 'B',3, null),
(5, 'B',4, null),
(5, 'B',5, null),
(5, 'C',1, null),
(5, 'C',2, null),
(5, 'C',3, null),
(5, 'C',4, null),
(5, 'C',5, null),
(5, 'D',1, null),
(5, 'D',2, null),
(5, 'D',3, null),
(5, 'D',4, null),
(5, 'D',5, null),
(5, 'E',1, null),
(5, 'E',2, null),
(5, 'E',3, null),
(5, 'E',4, null),
(5, 'E',5, null),
(6, 'A',1, null),
(6, 'A',2, null),
(6, 'A',3, null),
(6, 'A',4, null),
(6, 'A',5, null),
(6, 'B',1, null),
(6, 'B',2, null),
(6, 'B',3, null),
(6, 'B',4, null),
(6, 'B',5, null),
(6, 'C',1, null),
(6, 'C',2, null),
(6, 'C',3, null),
(6, 'C',4, null),
(6, 'C',5, null),
(6, 'D',1, null),
(6, 'D',2, null),
(6, 'D',3, null),
(6, 'D',4, null),
(6, 'D',5, null),
(6, 'E',1, null),
(6, 'E',2, null),
(6, 'E',3, null),
(6, 'E',4, null),
(6, 'E',5, null),
(7, 'A',1, null),
(7, 'A',2, null),
(7, 'A',3, null),
(7, 'A',4, null),
(7, 'A',5, null),
(7, 'B',1, null),
(7, 'B',2, null),
(7, 'B',3, null),
(7, 'B',4, null),
(7, 'B',5, null),
(7, 'C',1, null),
(7, 'C',2, null),
(7, 'C',3, null),
(7, 'C',4, null),
(7, 'C',5, null),
(7, 'D',1, null),
(7, 'D',2, null),
(7, 'D',3, null),
(7, 'D',4, null),
(7, 'D',5, null),
(7, 'E',1, null),
(7, 'E',2, null),
(7, 'E',3, null),
(7, 'E',4, null),
(7, 'E',5, null),
(8, 'A',1, null),
(8, 'A',2, null),
(8, 'A',3, null),
(8, 'A',4, null),
(8, 'A',5, null),
(8, 'B',1, null),
(8, 'B',2, null),
(8, 'B',3, null),
(8, 'B',4, null),
(8, 'B',5, null),
(8, 'C',1, null),
(8, 'C',2, null),
(8, 'C',3, null),
(8, 'C',4, null),
(8, 'C',5, null),
(8, 'D',1, null),
(8, 'D',2, 3),
(8, 'D',3, 3),
(8, 'D',4, 3),
(8, 'D',5, null),
(8, 'E',1, null),
(8, 'E',2, null),
(8, 'E',3, null),
(8, 'E',4, 3),
(8, 'E',5, 3),
(9, 'A',1, null),
(9, 'A',2, null),
(9, 'A',3, null),
(9, 'A',4, null),
(9, 'A',5, null),
(9, 'B',1, null),
(9, 'B',2, null),
(9, 'B',3, null),
(9, 'B',4, null),
(9, 'B',5, null),
(9, 'C',1, null),
(9, 'C',2, null),
(9, 'C',3, null),
(9, 'C',4, null),
(9, 'C',5, null),
(9, 'D',1, null),
(9, 'D',2, null),
(9, 'D',3, null),
(9, 'D',4, null),
(9, 'D',5, null),
(9, 'E',1, null),
(9, 'E',2, null),
(9, 'E',3, null),
(9, 'E',4, null),
(9, 'E',5, null);

    
    
    
    

