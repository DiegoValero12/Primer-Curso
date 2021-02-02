-- Dificultad A

-- T09.004- Número de cámaras que tienen sensor CMOS
-- SELECT COUNT(*) FROM camara
-- WHERE sensor LIKE'%CMOS%';

-- T09.016- Cantidad de artículos con stock 0
-- SELECT COUNT(*) FROM stock
-- WHERE disponible=0;


-- Dificultad B

-- T09.001- ¿Cuántos artículos de cada marca hay?
-- SELECT marca, COUNT(*) FROM articulo
-- GROUP BY marca;

-- T09.012- Ha habido un error en Tiendaonline y se han colado varios artículos sin stock, con cero unidades disponibles, en la cesta. Averigua el código de esos artículos y las veces que aparece cada uno en cesta.
-- SELECT s.articulo, COUNT(*) FROM stock s, cesta c
-- WHERE disponible=0 AND c.articulo=s.articulo
-- GROUP BY s.articulo;

-- T09.017- Cantidad de artículos que no son ni memoria, ni tv, ni objetivo, ni cámara ni pack.
-- SELECT COUNT(*) FROM articulo
-- WHERE
-- cod NOT IN(SELECT cod FROM memoria) AND
-- cod NOT IN(SELECT cod FROM tv) AND
-- cod NOT IN(SELECT cod FROM objetivo) AND
-- cod NOT IN(SELECT cod FROM camara) AND
-- cod NOT IN(SELECT cod FROM pack);


-- T09.021- Cantidad de líneas por cada pedido.
-- SELECT numPedido, COUNT(*) 
-- FROM linped
-- GROUP BY numPedido;

-- T09.022- Cantidad de líneas por cada pedido, eliminando aquellas filas con cantidades de artículo pedidas menores a 3.
-- SELECT numPedido, COUNT(*) 
-- FROM linped
-- WHERE cantidad>=3
-- GROUP BY numPedido;

-- T09.023- Para los pedidos anteriores a septiembre de 2010, cantidad de líneas por cada pedido.
-- SELECT l.numPedido, COUNT(*)
-- FROM linped l, pedido p
-- WHERE l.numPedido=p.numPedido AND p.fecha<'2010/09/01'
-- GROUP BY l.numPedido

-- T09.024- Por cada artículo pedido, cantidad total de unidades pedidas.
-- SELECT articulo, SUM(cantidad)
-- FROM linped
-- GROUP BY articulo;

-- T09.025- Por cada artículo pedido, cantidad total de unidades pedidas y promedio de importe unitario.
-- SELECT articulo, SUM(cantidad), AVG(importe)
-- FROM linped
-- GROUP BY articulo;

-- T09.026- Para las cámaras pedidas, código de artículo, cantidad total de unidades pedidas y promedio de importe unitario.
-- SELECT c.cod, SUM(cantidad), AVG(importe)
-- FROM camara c, linped l
-- WHERE c.cod=l.articulo
-- GROUP BY c.cod;

-- T09.027- Para las cámaras pedidas, código, nombre, marca del artículo, y cantidad total de unidades pedidas y promedio de importe unitario.
-- SELECT c.cod, a.nombre, a.marca, SUM(cantidad), AVG(importe)
-- FROM articulo a, camara c, linped l
-- WHERE a.cod=c.cod AND l.articulo=c.cod
-- GROUP BY c.cod, a.nombre, a.marca;

-- T09.028- Para todo usuario cuyo primer apellido sea Martínez, comprobar si hay algún otro usuario con los mismos apellidos y nombre.
-- SELECT apellidos, nombre, COUNT(*)
-- FROM usuario
-- WHERE apellidos LIKE ('Martinez%')
-- GROUP BY apellidos, nombre;

-- T09.029- Por cada mes y año, cantidad de pedidos realizados.
-- SELECT MONTH(fecha), YEAR(fecha), COUNT(*)
-- FROM pedido p
-- GROUP BY MONTH(fecha), YEAR(fecha);

-- T09.030- Para los artículos 'A0233' y 'A1085', código de artículo y cantidad de pedidos distintos en los que ha sido solicitado.
-- SELECT articulo, COUNT(DISTINCT numPedido)
-- FROM linped
-- WHERE articulo IN ('A0233', 'A1085')
-- GROUP BY articulo;

-- T09.031- ¿Cuántas veces se ha pedido cada artículo? Deben mostrarse todos los artículos, incluso los que no se han pedido nunca. La salida contendrá el código y nombre del artículo, junto con las veces que ha sido incluido en un pedido (solo si ha sido incluido, no se trata de la "cantidad").
-- SELECT cod, nombre, COUNT(*)
-- FROM articulo a
-- LEFT JOIN linped l ON (a.cod=l.articulo)
-- GROUP BY cod, nombre;

-- T09.032- Por cada usuario, email y total de precio de venta al público acumulado en sus cestas actuales.
-- SELECT usuario, SUM(pvp)
-- FROM articulo a, cesta c
-- WHERE a.cod=c.articulo
-- GROUP BY usuario;

-- T09.033- Por cada usuario, email y total de precio de venta al público acumulado en sus cestas actuales, eliminando previamente los artículos sin PVP, y ordenando de mayor a menor por ese total.

-- Dificultad C

-- T09B.002- ¿Cuáles son las marcas (en la tabla ARTICULO) que tienen menos de 150 artículos?
-- SELECT marca, COUNT(*)
-- FROM articulo
-- GROUP BY marca
-- HAVING COUNT(*)<150;

-- T09B.003- ¿Cuáles son las marcas (en la tabla ARTICULO) que tienen menos de 150 artículos (eliminar las marcas que sean null)?
-- SELECT marca, COUNT(*)
-- FROM articulo 
-- WHERE marca IS NOT NULL
-- GROUP BY marca
-- HAVING COUNT(*)<15;

-- T09B.005- Dni, nombre, apellidos y email de los usuarios que han realizado más de un pedido.
-- SELECT dni, nombre, apellidos, email
-- FROM usuario u, pedido p
-- WHERE u.email=p.usuario
-- GROUP BY dni, nombre, apellidos, email
-- HAVING COUNT(numPedido)>1;

-- T09B.006- Pedidos (número de pedido y usuario) de importe mayor a 4000 euros.
-- SELECT p.numPedido, usuario
-- FROM pedido p, linped l
-- WHERE p.numPedido=l.numPedido
-- GROUP BY numPedido, usuario
-- HAVING SUM(importe)>4000;

-- T09B.007- Pedidos (número de pedido y usuario) con más de 10 artículos, mostrando esta cantidad.

-- SELECT fecha, COUNT(distinct l.numPedido)
-- FROM linped l, pedido p
-- WHERE l.numPedido=p.numPedido AND p.numPedido NOT IN (SELECT numPedido FROM linped WHERE importe<=1000)
-- GROUP BY fecha;

-- T09B.008- Pedidos (número de pedido y usuario) que contengan más de cuatro artículos distintos.
-- SELECT p.numPedido, usuario, COUNT(DISTINCT articulo)
-- FROM pedido p, linped l
-- WHERE l.numPedido=p.numPedido
-- GROUP BY p.numPedido, usuario
-- HAVING COUNT(DISTINCT articulo)>4;

-- T09B.009- ¿Hay dos provincias que se llamen igual (con nombre repetido)?
-- SELECT nombre, COUNT(*)
-- FROM provincia
-- GROUP BY nombre
-- HAVING COUNT(*)>1;

-- T09B.010- ¿Hay algún pueblo con nombre repetido?

-- T09B.011- Obtener el código y nombre de las provincias que tengan más de 100 pueblos.
-- SELECT codp, nombre, COUNT(pueblo)
-- FROM provincia p, localidad l
-- WHERE l.provincia=p.codp
-- GROUP BY codp, nombre
-- HAVING COUNT(pueblo)>100;

-- T09B.013- Clientes que hayan adquirido (pedido) más de 2 tv
-- SELECT usuario, SUM(cantidad)
-- FROM pedido p, linped l, tv
-- WHERE l.articulo=tv.cod and p.numPedido=l.numPedido
-- GROUP BY usuario
-- HAVING SUM(cantidad)>2;

-- T09B.015- Código y nombre de las provincias que tienen más de 50 usuarios (provincia del usuario, no de la dirección de envío).
-- SELECT codp, p.nombre, COUNT(email)
-- FROM provincia p, usuario u
-- WHERE p.codp=u.provincia
-- GROUP BY codp, nombre
-- HAVING COUNT(email)>50;

-- T09B.018- Número de artículos pedidos por provincia (provincia del usuario no de la dirección de envío). Mostrar el código de la provincia, su nombre y la cantidad de veces que se ha pedido el artículo; si la provincia no tiene asociada esta cantidad, mostrar "0" en esa columna.
-- SELECT p.codp, p.nombre, IFNULL(SUM(cantidad),0)
-- FROM provincia p
-- 	LEFT JOIN usuario u ON p.codp=u.provincia
-- 	LEFT JOIN pedido pe ON u.email=pe.usuario
-- 	LEFT JOIN linped l ON pe.numPedido=l.numPedido
-- GROUP BY p.codp, p.nombre;

-- T09B.019- Código y nombre de los artículos que han sido solicitados en todos los pedidos del usuario acm@colegas.com.
-- select cod,nombre
-- from articulo a
-- where cod in
--    (select articulo
--     from pedido p,linped l
--     where usuario='acm@colegas.com' and p.numpedido=l.numpedido
--     group by articulo
--     having count(distinct p.numpedido) = 
--              (select count(*) from pedido where usuario='acm@colegas.com')
--    );


-- T09B.020- ¿Cuáles son las marcas que tienen menos de 150 artículos?
-- SELECT marca, COUNT(cod)
-- FROM articulo a
-- WHERE marca IS NOT null
-- GROUP BY marca
-- HAVING COUNT(cod)<150;