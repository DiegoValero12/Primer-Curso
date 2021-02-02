-- SELECT numpedido, usuario, apellidos, usuario.nombre, localidad.pueblo, p.nombre
-- FROM pedido
-- JOIN usuario ON usuario=email
-- JOIN localidad ON usuario.pueblo=codm AND usuario.provincia=localidad.provincia
-- JOIN provincia p ON usuario.provincia=p.codp

-- SELECT nombre, pueblo
-- FROM provincia p
-- JOIN localidad l ON p.codp=l.provincia
-- WHERE nombre IN ('Huesca', 'Zaragoza', 'Teruel') AND pueblo LIKE 'B%' ORDER BY nombre, pueblo

-- SELECT apellidos, nombre, p.numPedido
-- FROM usuario u
-- LEFT JOIN pedido p ON p.usuario=u.email

-- SELECT a.cod, nombre, resolucion, sensor
-- FROM articulo a
-- LEFT JOIN camara c ON a.cod=c.cod

-- SELECT a.cod, nombre, pvp, o.*
-- FROM articulo a
-- LEFT JOIN objetivo o ON o.cod=a.cod

-- SELECT c.*, a.nombre, a.pvp
-- FROM cesta c
-- JOIN articulo a ON a.cod=c.articulo
-- WHERE YEAR(c.fecha)=2010