use lojadb;

CREATE TABLE pedido (
  id INT NOT NULL auto_increment,
  status_pedido varchar(1),
  nome varchar(250),
  valor double,
  data_entrega date,
  url_produto varchar(500),
  url_imagem varchar(500),
  descricao varchar(250),
  username varchar(50),
  PRIMARY KEY (id)
);

alter table pedido add constraint fk_pedido_user foreign key (username)
references users(username);
