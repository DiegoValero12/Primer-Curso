-- INSERT INTO xx VALUES(1, 'AA')

-- SELECT * FROM xx

-- INSERT INTO xx VALUES (2, 'BB')

-- SELECT * FROM xx

-- DROP TABLE xx

-- CREATE TABLE yy(
-- col1 INT,
-- col2 CHAR(2),
-- col3 VARCHAR(10),
-- PRIMARY KEY (col1,col2))

-- INSERT INTO yy VALUES (1,'AA', 'primera')
-- INSERT INTO yy VALUES (2,'AA', 'segunda')
-- INSERT INTO yy VALUES (2, 'BB', 'tercera')
-- NO SE PUEDE: INSERT INTO yy VALUES (1, 'AA', 'cuarta')
-- No puede ser null
-- INSERT INTO yy VALUES (NULL, NULL, 'quinta')
-- INSERT INTO yy VALUES (0, '','octava')
-- INSERT INTO yy VALUES (3,'AA', NULL)
-- DROP TABLE yy

-- create table T1(a int,b int,c int, 
-- primary key(a)) engine=innodb; 
-- create table T2(a int,d int,e int, 
-- primary key(d),foreign key(a) references T1(a)) engine=innodb;

-- INSERT INTO T1 VALUES (1,10,100)
-- No puede ser null
-- INSERT INTO T1 VALUES (NULL, 20, NULL)
INSERT INTO T1 VALUES (2,20,NULL)