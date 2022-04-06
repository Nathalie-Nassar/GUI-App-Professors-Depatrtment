use university; 

CREATE TABLE DEPARTMENT( 
dno INT NOT NULL,
dname VARCHAR(20) NOT NULL,
dlocation VARCHAR(20) NOT NULL,
PRIMARY KEY (dno), UNIQUE (dno));
CREATE TABLE PROFESSOR (
pno INT NOT NULL,
pname VARCHAR(20) NOT NULL,
pjob VARCHAR(25) NOT NULL,
pmgr INT,
phiredate DATE NOT NULL,
psalary INT NOT NULL,
pbonus INT NULL,
pdno INT NOT NULL,
PRIMARY KEY (pno), UNIQUE (pno),
FOREIGN KEY (pmgr) REFERENCES PROFESSOR (pno)
ON DELETE SET NULL
ON UPDATE CASCADE,
FOREIGN KEY (pdno) REFERENCES DEPARTMENT (dno)
ON DELETE CASCADE
ON UPDATE CASCADE);


INSERT INTO DEPARTMENT VALUES (10, 'Computer Science', 'Bliss Hall'),
(20, 'Business', 'West Hall'),
(30, 'English', 'Fisk Hall'),
(40, 'Mathematics', 'Bliss Hall');

INSERT INTO PROFESSOR VALUES
(7839, "King", 'Dean', NULL, '2003-11-17', 6500, 0, 10),
(7566, 'Jones', 'Chair', 7839, '2003-04-02', 3375, 0, 20),
(7698, 'Blake', 'Chair', 7839, '2003-05-01', 3250, 0, 30),
(7782, 'Clark', 'Chair', 7839, '2003-06-09', 2850, 0, 10),
(7499, 'Allen', 'Full Professor', 7698, '2003-02-20', 2000, 500, 30),
(7521, 'Ward', 'Full Professor', 7698, '2003-02-22', 1650, 800, 30),
(7654, 'Martin', 'Full Professor', 7698, '2003-09-28', 1650, 1400, 30),
(7844, 'Turner', 'Full Professor', 7698, '2003-09-8', 1900, 0, 30),
(7900, 'James', 'Assistant Professor', 7698, '2003-12-03', 1350, 0, 30),
(7788, 'Scott', 'Associate Professor', 7566, '2002-06-27', 3500, 0, 20),
(7902, 'Ford', 'Associate Professor', 7566, '2003-12-03', 3500, 0, 20),
(7369, 'Smith', 'Assistant Professor', 7902, '2002-12-17', 1200, 0, 20),
(7876, 'Adams', 'Assistant Professor', 7788, '2002-07-31', 1500, 0, 20),
(7934, 'Miller', 'Assistant Professor', 7782, '2002-01-23', 1700, 0, 10);

