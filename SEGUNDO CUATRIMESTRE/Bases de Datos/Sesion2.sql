-- DIFICULTAD 1

-- SELECT cod, nombre, 'tiene el precio de', pvp FROM articulo
-- WHERE pvp<100

-- DIFICULTAD A

-- SELECT dni, email, nombre, apellidos FROM usuario u
-- WHERE provincia = '33'

-- SELECT p.* FROM provincia p, usuario u
-- WHERE u.provincia = p.codp

-- SELECT distinct p.* FROM provincia p, usuario u
-- WHERE u.provincia = p.codp
-- ORDER BY p.nombre

-- SELECT email, 'No tiene telefono' FROM usuario u, provincia p
-- WHERE u.provincia = p.codp AND p.nombre = 'murcia' AND (u.telefono IS NULL)

-- SELECT * FROM articulo a
-- WHERE marca IS null

-- SELECT a.cod, a.nombre, a.pvp FROM pack p, articulo a
-- WHERE p.cod = a.cod

-- SELECT a.cod, nombre, marca FROM articulo a, pack p, ptienea pt
-- WHERE p.cod = pt.pack AND pt.articulo = a.cod

-- SELECT cod, nombre, marca, pvp, importe FROM articulo a, linped l
-- WHERE l.articulo = a.cod AND numPedido = 1

-- SELECT cod, sensor, pantalla FROM camara
-- WHERE pantalla IS NOT NULL
-- ORDER BY cod desc

-- DIFICULTAD B

-- SELECT a.cod, a.nombre, a.marca, a.pvp, l.importe FROM linped l, tv, articulo a
-- WHERE tv.cod = l.articulo AND numPedido = 1 AND tv.cod = a.cod

-- SELECT p.fecha, p.usuario, a.cod, a.nombre, a.marca, a.pvp, l.importe FROM linped l, tv, articulo a, pedido p
-- WHERE tv.cod = l.articulo AND tv.cod = a.cod AND l.numPedido = p.numPedido AND l.numPedido = 1

-- DIFICULTAD C

SELECT a1.cod, a1.nombre, a1.pvp, a2.cod, a2.nombre, a2.pvp FROM articulo a1, ptienea p, articulo a2
WHERE p.articulo = a2.cod AND p.pack = a1.cod