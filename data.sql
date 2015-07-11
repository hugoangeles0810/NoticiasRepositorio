-- Roles 
insert into rol (nombre) values ('USER');
insert into rol (nombre) values ('EDITOR');
insert into rol (nombre) values ('ADMIN');

-- Usuarios Administrador
insert into usuario (nombre, correo, apellidos, clave, foto, rol_id) values ('Hugo', 'hugoangeles0810@gmail.com', 'Angeles Chavez', 'c403b7f3fc9e411fc1825f86e32e777c497d1b8b', 'default', 3);
insert into usuario (nombre, correo, apellidos, clave, foto, rol_id) values ('Carlos', 'calbert0512012017@gmail.com', 'Adrianzen Adanaque', 'd05238b27c80b1ef28d311d0d08929ba9b1e948e', 'default', 3);
insert into usuario (nombre, correo, apellidos, clave, foto, rol_id) values ('Roberto', 'robertocorrea20@gmail.com', 'Correa Mantilla', '29b502e872f1e57b361040ebfa1a7963c7da92de', 'default', 3);

-- Categorias iniciales
insert into categoria (nombre, enlace) values ('Mundo', 'mundo');
insert into categoria (nombre, enlace) values ('Política', 'politica');
insert into categoria (nombre, enlace) values ('Deportes', 'deportes');
insert into categoria (nombre, enlace) values ('Tecnología', 'tecnologia');
insert into categoria (nombre, enlace) values ('Otros', 'otros');