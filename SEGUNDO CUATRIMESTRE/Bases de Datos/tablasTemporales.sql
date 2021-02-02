-- Dificultad A

-- T12.001- Días que han pasado entre el primer y último pedido.
-- SELECT DATEDIFF(
-- 		(SELECT MAX(fecha) from pedido),
-- 		(SELECT MIN(fecha) FROM pedido)
-- 	) dias;
	
-- T12.002- Calcula y muestra la cantidad de televisores, cámaras y objetivos almacenados en la base de datos.
-- SELECT
-- 	(SELECT COUNT(*) FROM tv) AS televisores,
-- 	(SELECT COUNT(*) FROM camara) AS camaras,
-- 	(SELECT COUNT(*) FROM objetivo) AS objetivos;

-- T12.003- Calcula y muestra los porcentajes, sobre el total de artículos almacenados en la base de datos, de televisores, cámaras y objetivos.
-- SELECT
-- 	((SELECT count(*) FROM tv)/(SELECT COUNT(*) FROM articulo)*100) AS p_tv,
-- 	((SELECT COUNT(*) FROM camara)/(SELECT COUNT(*) FROM articulo)*100) AS p_camara,
-- 	((SELECT COUNT(*) FROM objetivo)/(SELECT COUNT(*) FROM articulo)*100) AS p_objetivo;


-- Dificultad B

-- T12.007- Provincias y cantidad de pedidos servidos en ellas, para aquellas provincias con un promedio de importe total de sus pedidos por encima de 2500 €.
-- SELECT provincia, COUNT(*)
-- FROM usuario u, 
-- 		(SELECT usuario, p.numPedido, SUM(importe*cantidad) total
-- 		FROM pedido p, linped l
-- 		WHERE l.numPedido=p.numPedido
-- 		GROUP BY usuario, p.numPedido) pd
-- WHERE u.email=pd.usuario
-- GROUP BY provincia
-- HAVING AVG(total)>2500;

-- T12.008- Nombre de las localidades de los usuarios que han hecho 2 pedidos o más. Elimina duplicados.
-- SELECT distinct l.pueblo
-- FROM localidad l, usuario u
-- WHERE l.codm=u.pueblo AND u.provincia=l.provincia AND 
-- email IN (SELECT usuario
-- 				FROM pedido p
-- 				GROUP BY usuario
-- 				HAVING COUNT(*)>=2
-- 			);

-- T12.004- Email, nombre y apellidos de los usuarios de la provincia 03, y si tienen un pedido cuyo importe total sea mayor que 10000€, mostrar también el número de pedido y ese importe; ordena la salida descendentemente por el valor del pedido.
-- SELECT u.email, u.nombre, u.apellidos, pedidos.numPedido, pedidos.valor
-- FROM usuario u LEFT JOIN 
-- 		(SELECT u.email, p.numPedido, SUM(importe*cantidad) valor
-- 		FROM usuario u, pedido p, linped l
-- 		WHERE u.email=p.usuario AND p.numPedido=l.numPedido
-- 		GROUP BY u.email, p.numPedido
-- 		HAVING SUM(importe*cantidad)>10000) AS pedidos
-- 		ON u.email=pedidos.email
-- WHERE u.provincia='03'
-- ORDER BY valor DESC;

-- Comienza resolviendo número de pedido, usuario e importe total de los pedidos valorados en más de 10000€ y utiliza el resultado como tabla temporal.
-- SELECT u.email, p.numPedido, SUM(importe*cantidad)
-- FROM usuario u, pedido p, linped l
-- WHERE u.email=p.usuario AND p.numPedido=l.numPedido
-- GROUP BY u.email, p.numPedido
-- HAVING SUM(importe*cantidad)>10000;

-- T12.005- De los usuarios que tengan algún pedido sin líneas de pedido y artículos pendientes de solicitud en alguna cesta, mostrar su email, nombre, apellidos, número del pedido sin líneas, y valor total de su cesta. 
-- SELECT email, nombre, apellidos, temp.numPedido, temp.valor
-- FROM usuario u, (SELECT p.numPedido, SUM(pvp) valor, p.usuario
-- 		FROM pedido p, cesta c, articulo a, usuario u
-- 		WHERE p.usuario=u.email and p.numPedido NOT IN (SELECT numPedido FROM linped) AND c.usuario=u.email AND c.articulo=a.cod
-- 		GROUP BY u.email, p.numPedido, p.usuario) AS temp
-- WHERE u.email=temp.usuario;

-- Comienza resolviendo pedidos sin líneas y valor de la cesta por usuario y utiliza los resultados como tablas temporales.
-- SELECT p.numPedido, SUM(pvp) valor
-- FROM pedido p, cesta c, articulo a, usuario u
-- WHERE p.usuario=u.email and p.numPedido NOT IN (SELECT numPedido FROM linped) AND c.usuario=u.email AND c.articulo=a.cod
-- GROUP BY u.email, p.numPedido;

-- T12.006- Para aquellos usuarios que tengan más de un pedido en 2010, obtener una tabla donde cada columna se corresponda con un mes
-- del año y muestre la cantidad de pedidos realizada por ese usuario en ese mes.
-- Cada fila empieza por el email, nombre y apellidos del usuario.
-- SELECT email, nombre, apellidos,
-- 		(SELECT COUNT(*) FROM pedido p WHERE YEAR(fecha)=2010 AND MONTH(fecha)=1 AND usuario=email) enero,	
-- 		(SELECT COUNT(*) FROM pedido p WHERE YEAR(fecha)=2010 AND MONTH(fecha)=2 AND usuario=email) febrero,
-- 		(SELECT COUNT(*) FROM pedido p WHERE YEAR(fecha)=2010 AND MONTH(fecha)=3 AND usuario=email) marzo,  
-- 		(SELECT COUNT(*) FROM pedido p WHERE YEAR(fecha)=2010 AND MONTH(fecha)=4 AND usuario=email) abril,
-- 		(SELECT COUNT(*) FROM pedido p WHERE YEAR(fecha)=2010 AND MONTH(fecha)=5 AND usuario=email) mayo,
-- 		(SELECT COUNT(*) FROM pedido p WHERE YEAR(fecha)=2010 AND MONTH(fecha)=6 AND usuario=email) junio,
-- 		(SELECT COUNT(*) FROM pedido p WHERE YEAR(fecha)=2010 AND MONTH(fecha)=7 AND usuario=email) julio,
-- 		(SELECT COUNT(*) FROM pedido p WHERE YEAR(fecha)=2010 AND MONTH(fecha)=8 AND usuario=email) agosto,
-- 		(SELECT COUNT(*) FROM pedido p WHERE YEAR(fecha)=2010 AND MONTH(fecha)=9 AND usuario=email) septiembre,
-- 		(SELECT COUNT(*) FROM pedido p WHERE YEAR(fecha)=2010 AND MONTH(fecha)=10 AND usuario=email) octubre,
-- 		(SELECT COUNT(*) FROM pedido p WHERE YEAR(fecha)=2010 AND MONTH(fecha)=11 AND usuario=email) noviembre,
-- 		(SELECT COUNT(*) FROM pedido p WHERE YEAR(fecha)=2010 AND MONTH(fecha)=12 AND usuario=email) diciembre
-- FROM usuario u
-- WHERE email IN (SELECT usuario FROM pedido p GROUP BY usuario HAVING COUNT(numPedido)>1);
		
		
