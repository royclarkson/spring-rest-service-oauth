insert into user(id, name, login, password) values (1,'Roy','roy','spring');
insert into user(id, name, login, password) values (2,'Craig','craig','spring');
insert into user(id, name, login, password) values (3,'Greg','greg','spring');

insert into role(id, name, user_id) values (1,'ROLE_ADMIN',1);
insert into role(id, name, user_id) values (2,'ROLE_USER',1);
insert into role(id, name, user_id) values (3,'ROLE_USER',2);
insert into role(id, name, user_id) values (4,'ROLE_USER',3);
