use lojadb;

CREATE TABLE authorities (
  username varchar(50) not null primary key,
  authority varchar(50),
  constraint fk_authorities_user foreign key(username) references users(username)
);

create unique index ix_auth_username on authorities (username, authority);
