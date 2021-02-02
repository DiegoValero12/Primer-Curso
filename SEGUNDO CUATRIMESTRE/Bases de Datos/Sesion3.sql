-- select cod, nombre from articulo a
-- where pvp between 400  and 500

-- select cod, nombre from articulo a
-- where pvp in ('415', '129','1259', '3995')

-- select codp, nombre from provincia 
-- where nombre not in ('Huelva', 'Sevilla', 'Asturias', 'Barcelona')

-- select codp from provincia
-- where nombre like '%_licante%'

-- select cod, nombre, pvp from articulo
-- where marca like 'S%'

-- select * from usuario
-- where email like '%eps%'

-- select a.cod, a.nombre, resolucion from articulo a, tv 
-- where a.cod=tv.cod and pantalla not between 22 and 42

-- select a.cod, a.nombre, resolucion from articulo a, tv 
-- where a.cod=tv.cod and panel like '%LED%' and a.pvp<'1000'

-- select email from usuario
-- where codpos not in ('02012', '02018', '02032')

select distinct pt.pack, a.nombre from articulo a, ptienea pt
where a.cod=pt.pack and pt.articulo is not null