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
(True, "Jared", "CALGARY SOMEWHEREELSE", "JARED@uc.ca", "fakepassword1", False, "2019-12-20 00:00:00"),
(True, "Mike", "Calgarylowercased", "mikek@ucalgary.ca", "fakepassword2", True, "2021-10-20 00:00:00"),
(True, "Nic", "calgary4thspelling", "nickl@ucalgary.ca", "fakepassword3", False, NULL),
(False, "", "", "nonregistereduser@ucalgary.ca", "", False, NULL );
    
CREATE TABLE CARD(
	CardID int not null auto_increment,
    UserID int,
    CardNumber varchar(16),
    PRIMARY KEY(CardID), 
    FOREIGN KEY(UserID) REFERENCES USER(UserID));


INSERT INTO CARD(UserID, CardNumber) VALUES
(1, "1000200030004000"),
(1,"1000300020004000"),
(3, "2000400080009000"),
(2, "4321123489891122");


    
CREATE TABLE SEATS(
	ShowingID int,
    rownum char,
    colnum int,
    reserved BOOL,
    FOREIGN KEY (ShowingID) REFERENCES SHOWING(ShowingID),
    PRIMARY KEY(ShowingID, rownum, colnum));

    
CREATE TABLE TRANSACTION(
	TransactionID int NOT NULL AUTO_INCREMENT,
    UserID int,
    Cost float,
    PurchaseDate DATETIME, 
    CardID int,
    PRIMARY KEY(TransactionID),
    FOREIGN KEY(UserID) REFERENCES USER(UserID),
    FOREIGN KEY(CardID) REFERENCES CARD(CardID)
    );
INSERT INTO TRANSACTION(UserID, Cost, PurchaseDate, CardID)
VALUES
(1, 59,  "2021-12-01 00:00:00", 1),
(2,  43, "2021-12-04 00:00:00", 4),
(3, 21, "2021-05-03 00:00:00", 3);

CREATE TABLE TICKETS(
	TicketID int NOT NULL AUTO_INCREMENT,
    ShowingID int, 
    rownum char,
	colnum int,
    TransactionID int,
    PRIMARY KEY(TicketID),
    FOREIGN KEY(ShowingID) REFERENCES SHOWING(ShowingID),
    Foreign Key(TransactionID) REFERENCES TRANSACTION(TransactionID));
    
INSERT INTO TICKETS(ShowingID, rownum, colnum, TransactionID)
VALUES
(1, 'A', 3, 1), 
(1, 'A', 4, 1),
(1, 'A', 2, 1),
(1, 'C', 6, 1),
(2, 'F', 10, 1),
(2, 'B', 4, 2),
(3, 'A', 3, 2),
(4, 'C', 5, 2),
(5, 'F', 7,2),
(6, 'D', 5, 2),
(5, 'D', 3, 3),
(6, 'E', 3, 3),
(7, 'C', 8, 3);


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

    
    
INSERT INTO Seats(ShowingID, rownum, colnum, reserved)
VALUES
(1, 'A',1, False),
(1, 'A',2, False),
(1, 'A',3, False),
(1, 'A',4, False),
(1, 'A',5, False),
(1, 'B',1, False),
(1, 'B',2, False),
(1, 'B',3, False),
(1, 'B',4, False),
(1, 'B',5, False),
(1, 'C',1, False),
(1, 'C',2, False),
(1, 'C',3, False),
(1, 'C',4, False),
(1, 'C',5, False),
(1, 'D',1, False),
(1, 'D',2, False),
(1, 'D',3, False),
(1, 'D',4, False),
(1, 'D',5, False),
(1, 'E',1, False),
(1, 'E',2, False),
(1, 'E',3, False),
(1, 'E',4, False),
(1, 'E',5, False),
(2, 'A',1, False),
(2, 'A',2, False),
(2, 'A',3, False),
(2, 'A',4, False),
(2, 'A',5, False),
(2, 'B',1, False),
(2, 'B',2, False),
(2, 'B',3, False),
(2, 'B',4, False),
(2, 'B',5, False),
(2, 'C',1, False),
(2, 'C',2, False),
(2, 'C',3, False),
(2, 'C',4, False),
(2, 'C',5, False),
(2, 'D',1, False),
(2, 'D',2, False),
(2, 'D',3, False),
(2, 'D',4, False),
(2, 'D',5, False),
(2, 'E',1, False),
(2, 'E',2, False),
(2, 'E',3, False),
(2, 'E',4, False),
(2, 'E',5, False),
(3, 'A',1, False),
(3, 'A',2, False),
(3, 'A',3, False),
(3, 'A',4, False),
(3, 'A',5, False),
(3, 'B',1, False),
(3, 'B',2, False),
(3, 'B',3, False),
(3, 'B',4, False),
(3, 'B',5, False),
(3, 'C',1, False),
(3, 'C',2, False),
(3, 'C',3, False),
(3, 'C',4, False),
(3, 'C',5, False),
(3, 'D',1, False),
(3, 'D',2, False),
(3, 'D',3, False),
(3, 'D',4, False),
(3, 'D',5, False),
(3, 'E',1, False),
(3, 'E',2, False),
(3, 'E',3, False),
(3, 'E',4, False),
(3, 'E',5, False),
(4, 'A',1, False),
(4, 'A',2, False),
(4, 'A',3, False),
(4, 'A',4, False),
(4, 'A',5, False),
(4, 'B',1, False),
(4, 'B',2, False),
(4, 'B',3, False),
(4, 'B',4, False),
(4, 'B',5, False),
(4, 'C',1, False),
(4, 'C',2, False),
(4, 'C',3, False),
(4, 'C',4, False),
(4, 'C',5, False),
(4, 'D',1, False),
(4, 'D',2, False),
(4, 'D',3, False),
(4, 'D',4, False),
(4, 'D',5, False),
(4, 'E',1, False),
(4, 'E',2, False),
(4, 'E',3, False),
(4, 'E',4, False),
(4, 'E',5, False);
    
	
    

    
    
    
    

