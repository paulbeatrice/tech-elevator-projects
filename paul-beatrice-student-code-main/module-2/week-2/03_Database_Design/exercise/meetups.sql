--CREATE MEMBERS TABLE
CREATE TABLE Members (
	MemberNumber SERIAL PRIMARY KEY,
	LastName VARCHAR(50) NOT NULL,
	FirstName VARCHAR(50) NOT NULL,
	EmailAddress VARCHAR(100) NOT NULL UNIQUE,
	PhoneNumber VARCHAR(15),
	DateOfBirth DATE NOT NULL,
	ReminderEmailFlag BOOLEAN NOT NULL
);

--CREATE GROUPS TABLE
CREATE TABLE Events (
	GroupNumber SERIAL PRIMARY KEY,
	GroupName VARCHAR(100) NOT NULL UNIQUE
);

--CREATE EVENTS TABLE
CREATE TABLE Events (
	EventNumber SERIAL PRIMARY KEY,
	EventName VARCHAR(100) NOT NULL,
	Description TEXT,
	StartDateTime TIMESTAMP NOT NULL,
	Duration INT CHECK (Duration >= 30),
	GroupNumber INT,
	FOREIGN KEY (GroupNumber) REFERENCES Groups(GroupNumber)
);

--CREATE MEMBERS_GROUP JUNCTION TABLE
CREATE TABLE Members_Groups (
	MemberNumber INT,
	GroupNumber INT,
	PRIMARY KEY (MemberNumber, GroupNumber),
	FOREIGN KEY (MemberNumber) REFERENCES Members(MemberNumber),
	FOREIGN KEY (GroupNumber) REFERENCES Groups(GroupNumber)
);

--CREATE MEMBERS_EVENTS JUNCTION TABLE
CREATE TABLE Members_Events (
	MemberNumber INT,
	EventNumber INT,
	PRIMARY KEY (MemberNumber, EventNumber),
	FOREIGN KEY (MemberNumber) REFERENCES Members(MemberNumber),
	FOREIGN KEY (EventNumber) REFERENCES Events(EventNumber)
);

--INSERT MEMBERS
INSERT INTO Members(LastName, FirstName, EmailAddress, PhoneNumber, DateOfBirth, ReminderEmailFlag)
VALUES
	('Beatrice', 'Paul', 'paul.beatrice@gmail.com', '8594443313', '1997-10-31', FALSE),
	('Smith', 'John', 'john.smith@gmail.com', '8594443314', '1997-03-22', TRUE),
	('Frederick', 'William', 'william.frederick@yahoo.com', '8594443315', FALSE),
	('Mayo', 'Anthony', 'anthony.mayo2@yahoo.com', '8594443316', TRUE),
	('Davis', 'Mike', 'mdavis3@gmail.com', '8594443317', TRUE),
	('Sullivan', 'Mike', 'sullivan.mike@gmail.com', '8594443318', TRUE),
	('Dejesus', 'Jeffrey', 'jdejesus@yahoo.com', '8594443319', TRUE),
	('Kraus', 'Kayla', 'kkraus@yahoo.com', '8594443320', TRUE);
	
--INSERT GROUPS
INSERT INTO Groups (GroupName)
VALUES 
('Book Club'),
('Tech Club'),
('Camping Adventures');

--INSERT EVENTS
INSERT INTO Events (EventName, Description, StartDateTime, Duration, GroupNumber)
VALUES
	('Monthly Book Discussion', 'Discussing our latest read.', '2024-10-23', 120, 1),
	('Hackathon', 'A full-day hacking tournament, with prizes.', '2024-05-05', 360, 2),
	('Annual Camp Trip', 'Exploring the near by scenic trails of Red River Gorge.', '2024-03-18', 4320, 3),
	('Twitch Streamer Bootcamp', 'Learn the tricks of the trade of Twitch Streaming.', '2025-07-03', 2);
	
--ASSIGN MEMBERS INTO GROUPS
INSERT INTO Members_Groups (MemberNumber, GroupNumber)
VALUES
	(1, 1), (2, 1),
	(3, 2), (4, 2),
	(5, 3), (6, 3),
	(7, 1), (8, 2);
	
--ASSIGN MEMBERS TO EVENTS
INSERT INTO Members_Events (MemberNumber, EventNumber)
VALUES
	(1, 1), (2, 1),
	(3, 2), (4, 2),
	(5, 3), (6,3),
	(7, 4), (8, 4);