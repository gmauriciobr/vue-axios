use lojadb;

CREATE TABLE oferta (
  id INT NOT NULL auto_increment primary key,
  valor double,
  data_entrega date,
  comentario varchar(250),
  id_pedido int
);

alter table oferta add constraint fk_oeferta_pedido foreign key (id_pedido)
references pedido(id);
