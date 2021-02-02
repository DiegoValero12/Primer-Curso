-- Dificultad A

-- T13.001- Crea una vista (VusuAli) de la delegación de Alicante que permite ver los usuarios de la provincia de Alicante (de código '03').
-- CREATE VIEW VusuAli AS SELECT * FROM tiendaonline.usuario WHERE provincia='03'

-- T13.002- Con la vista anterior, lista a todos los usuarios de la provincia de Alicante ordenados por apellidos y nombre.
-- SELECT *
-- FROM VusuAli
-- ORDER BY apellidos, NOmbre;

-- T13.003- Con la vista anterior, lista a todos los usuarios de la provincia de Alicante que se llamen Carolina o Iloveny, ordenados por apellidos y nombre.
-- SELECT *
-- FROM VusuAli
-- WHERE nombre IN ('Carolina','Iloveny')
-- ORDER BY apellidos, nombre;

-- T13.004- Usando la vista anterior elimina a los usuarios de la provincia de Alicante que se llamen Carolina o Iloveny.
-- ¿Qué ha pasado? ¿Por qué?
-- DELETE FROM VusuAli WHERE nombre IN ('Carolina', 'Iloveny')

-- T13.005- Intenta insertar mediante VusuAli (email,dni,apellidos,nombre,provincia,pueblo) 
-- ('rff20@gmial.es','11222333R','FERNANDEZ FERNANDEZ','ROSA','03','1225')
-- ¿Qué ha pasado? ¿Por qué?
-- INSERT INTO VusuAli (email, dni, apellidos, nombre, provincia, pueblo)
-- VALUES ('rff20@gmial.es','11222333R','FERNANDEZ FERNANDEZ','ROSA','03','1225')

-- T13.006- Crea una vista que nos informe del total del importe a pagar por cada pedido en TIENDAONLINE y su fecha. Comprueba que nos da los datos correctos.
-- CREATE OR REPLACE VIEW total AS (SELECT p.numPedido, SUM(importe*cantidad) importe, date(p.fecha) fecha
--  								FROM tiendaonline.pedido p, tiendaonline.linped l
--  								WHERE p.numPedido=l.numPedido
 -- 								GROUP BY p.numPedido, p.fecha);
 
-- select p.numpedido,sum(importe*cantidad) total,date(fecha)
-- from tiendaonline.pedido p, tiendaonline.linped l where p.numpedido=l.numpedido
-- group by p.numpedido,fecha;

-- SELECT * FROM total;

-- T13.007- Usando las vistas previas, lista todos los email, nombre y apellidos de usuario de Alicante, y si tienen pedidos también el total pagado por el usuario.
-- SELECT email, nombre, apellidos, pp.pagado
-- FROM VusuAli v LEFT JOIN
-- 							(SELECT p.usuario, SUM(importe) pagado
-- 							FROM tiendaonline.pedido p JOIN total t ON t.numPedido=p.numPedido
-- 							GROUP BY usuario) pp
-- on pp.usuario=v.email;

-- T13.008- Crea otra vista que nos informe del total del importe a pagar por cada pedido hecho por usuarios de Alicante y su fecha (solo fecha).
-- CREATE or replace VIEW Tinforme AS (SELECT p.numPedido, SUM(importe*cantidad) total, fecha, usuario
-- 								FROM tiendaonline.pedido p, tiendaonline.linped l, tiendaonline.usuario u
-- 								WHERE p.numPedido=l.numPedido AND u.email=p.usuario AND u.provincia='03'
-- 								GROUP BY p.numPedido, fecha, usuario);

-- T13.009- Usando la nueva vista previa, modifica tu solución anterior y lista todos los email, nombre y apellidos de usuario, y si tienen pedidos también el total pagado por el usuario.
-- SELECT email, nombre, apellidos, total
-- FROM VusuAli LEFT JOIN Tinforme ON(email=usuario)  

-- T13.010- Crea en tu base de datos una tabla con la misma estructura que ""TIENDAONLINE.USUARIO"". Tu tabla se llamará ""usuAlm"".
-- CREATE TABLE nombretabla LIKE otratabla crea una nueva tabla (nombretabla) con las columnas de otratabla. Lo único que no se crea en nombretabla son las claves ajenas. 
-- Crea una vista ""VusuAlm"" que permita gestionar (altas, bajas, modificaciones y consultas) a los usuarios de Almería (código '04') y de ninguna otra.


-- T13.011- Intenta insertar mediante VusuAlm (email,dni,apellidos,nombre,provincia,pueblo) 
-- ('rgg2@gmial.es','11222333R','GOMEZ GOMEZ','ROSA','04','1002')
-- ¿Qué ha pasado? ¿Por qué?

-- T13.012- Utilizando VusuAlm elimina todas las posibles filas de usuarios que tengas e inserta en tu tabla USUARIO a estos 2 usuarios (email,dni,apellidos,nombre,provincia,pueblo):
-- ('rff20@gmial.es','11222333R','FERNANDEZ FERNANDEZ','ROSA','04','0530')
-- ('jmm119@gmial.es','22333444T','MARTINEZ MARTINEZ','JULIA','04','1002')
-- T13.013- Intenta insertar mediante VusuAlm (email,dni,apellidos,nombre,provincia,pueblo) 
-- ('rff20@gmial.es','11222333R','FERNANDEZ FERNANDEZ','ROSA','03','1225')
-- ¿Qué ha pasado? ¿Por qué?

-- T13.014- Vas a montar la delegación de Almería. En TIENDAONLINE no hay ningún usuario de esa provincia. La tabla usuarios ya la tienes aunque sin clave ajena a localidad.
-- ALTER TABLE usuario ADD FOREIGN KEY (pueblo, provincia) REFERENCES tiendaonline.localidad (codm,provincia);
-- La orden anterior añade dicha clave ajena. Fíjate que hace referencia la tabla LOCALIDAD en TIENDAONLINE. Eso quiere decir que no necesitas esta tabla en tu base de datos, la vas a manejar mediante vistas.
-- Debes decidir qué tablas necesitas en tu base de datos y cuáles solo vas a utilizar como referencia desde TIENDAONLINE —y no necesitas recrearlas—. Las tablas que necesitas son todas aquellas que necesitas para añadir información de qué compran tus usuarios.
-- Ya tienes 2 usuarios, monta algunos pedidos y cestas para alguno de ellos.
-- T13.015- Tienes a tus usuarios de Almería y acceso al resto de usuarios de TIENDAONLINE. Lista el email de todos los usuarios, los de Almería y todos los demás, apellidos, nombre, y nombres de la localidad y provincia en la que viven.

-- T13.016- Sobre tu base de datos, redefine TApedidos y muestra todos los email, nombre y apellidos de usuario —en tu caso de Almería— y si tienen pedidos también el total pagado por el usuario.