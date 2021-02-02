-- T06.001- Crea una tabla de nombre "xx" con 2 columnas, col1 de tipo integer, y col2 de tipo char(3), con col1 como clave primaria.

-- CREATE TABLE xx (
-- col1 INT,
-- col2 CHAR(3),
-- PRIMARY KEY (col1)
-- ) ENGINE=INNODB;

-- T06.002- Consulta la tabla
-- SELECT * FROM xx;

-- T06.003- Inserta en la tabla la fila (1,’AA’)
-- INSERT INTO xx VALUES(1, 'AA');

-- T06.004- inserta en la tabla la fila ('BB',2)
-- INSERT INTO xx (col2,col1) VALUES ('BB', 2);

-- T06.005- Inserta en la tabla la fila (2,'BB')
-- INSERT INTO xx VALUES (2, 'BB');

-- T06.006- Consulta la tabla XX
-- SELECT * FROM xx;

-- T06.008- Borra la tabla XX
-- DROP TABLE xx;

-- T06.009- Crea una tabla YY con 3 columnas
-- CREATE TABLE YY (
-- col1 INT,
-- col2 CHAR(2),
-- col3 VARCHAR(10),
-- PRIMARY KEY (col1,col2)
-- ) ENGINE=INNODB;

-- T06.010- Inserta los siguientes datos y consulta la tabla para ver los datos almacenados
INSERT INTO YY VALUES (1,'AA','primera');
INSERT INTO YY VALUES (2,'AA','segunda');
INSERT INTO YY VALUES (2,'BB','tercera');
INSERT INTO YY VALUES (1,'AA','cuarta');
INSERT INTO YY VALUES (NULL,NULL,'quinta');
INSERT INTO YY VALUES (NULL,'CC','sexta');
INSERT INTO YY VALUES (3,NULL,'séptima');
INSERT INTO YY VALUES (0,'','octava'); --0, cadena vacía, 'octava' 
INSERT INTO YY VALUES (3,'AA',NULL);
