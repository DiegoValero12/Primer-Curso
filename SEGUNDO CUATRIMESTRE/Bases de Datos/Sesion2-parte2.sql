-- select * from pedido p 
-- where p.fecha<'2010-010-01'

-- select * from pedido p
-- where fecha>'2010-08-31'

-- select * from pedido p
-- where fecha>'2010-08-01' and fecha<'2010-11-01'

-- select * from pedido p
-- where fecha='2010-03-03' or fecha='2010-10-27'

-- select * from pedido p
-- where (fecha='2010-03-03' or fecha='2010-10-27') and usuario like '%cazurren%'

-- select now()

-- select distinct l.articulo from pedido p, linped l
-- where (p.numPedido=l.numPedido) and (p.fecha>='2010-01-01' and p.fecha<'2011-01-01')
-- order by l.articulo asc

-- select distinct l.articulo from pedido p, linped l
-- where (p.numPedido=l.numPedido) and (p.fecha>='2010-03-01' and p.fecha<'2010-04-01')
-- order by l.articulo asc