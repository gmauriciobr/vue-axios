use lojadb;

insert into users values ('admin', '$2a$10$LZkMso5MlFZEQBymmi1qhuZSial6YA78mXjf4z9tcfaddH09W5zNy', 1);

insert into authorities values ('admin', 'ROLE_ADMIN');

commit;