

INSERT INTO banco (idBanco,nombre) VALUES (1,'Banamex');
INSERT INTO banco (idBanco,nombre) VALUES (2,'Intercam');
INSERT INTO banco (idBanco,nombre) VALUES (3,'BBVBancomer');


INSERT INTO cliente (idCliente,nombre,apaterno,amaterno,edad,idBanco) VALUES (1,'Miguel','Angel','Garcia',32,1);
INSERT INTO cliente (idCliente,nombre,apaterno,amaterno,edad,idBanco) VALUES (2,'Luis','Hernandez','Garcia',32,2);
INSERT INTO cliente (idCliente,nombre,apaterno,amaterno,edad,idBanco) VALUES (3,'Alfonso','Morales','Torres',28,1);
INSERT INTO cliente (idCliente,nombre,apaterno,amaterno,edad,idBanco) VALUES (4,'Juan','Hernandez','Garcia',32,1);
INSERT INTO cliente (idCliente,nombre,apaterno,amaterno,edad,idBanco) VALUES (5,'Carla','Hernandez','Garcia',32,2);
INSERT INTO cliente (idCliente,nombre,apaterno,amaterno,edad,idBanco) VALUES (6,'Nathalia','Sevilla','Torres',28,1);


INSERT INTO tipocuenta (idTipoCuenta,nombre) VALUES (1,'PERFILES');
INSERT INTO tipocuenta (idTipoCuenta,nombre) VALUES (2,'CHEQUES');
INSERT INTO tipocuenta (idTipoCuenta,nombre) VALUES (3,'INTERCAM ENLACE');
INSERT INTO tipocuenta (idTipoCuenta,nombre) VALUES (4,'PERFILES');
INSERT INTO tipocuenta (idTipoCuenta,nombre) VALUES (5,'PAGOMATICO');
INSERT INTO tipocuenta (idTipoCuenta,nombre) VALUES (6,'NOMINA');
INSERT INTO tipocuenta (idTipoCuenta,nombre) VALUES (7,'AHORRO');
INSERT INTO tipocuenta (idTipoCuenta,nombre) VALUES (8,'INVERSION');
INSERT INTO tipocuenta (idTipoCuenta,nombre) VALUES (9,'PERFILES 2');
INSERT INTO tipocuenta (idTipoCuenta,nombre) VALUES (10,'PERFILES 3');


INSERT INTO cuenta (idCuenta,numeroCuenta,idTipoCuenta,idCliente) VALUES (1,90324532,1,1);
INSERT INTO cuenta (idCuenta,numeroCuenta,idTipoCuenta,idCliente) VALUES (2,47582110,3,1);
INSERT INTO cuenta (idCuenta,numeroCuenta,idTipoCuenta,idCliente) VALUES (3,90254141,2,1);
INSERT INTO cuenta (idCuenta,numeroCuenta,idTipoCuenta,idCliente) VALUES (4,32324532,2,5);
INSERT INTO cuenta (idCuenta,numeroCuenta,idTipoCuenta,idCliente) VALUES (5,53582110,1,5);
INSERT INTO cuenta (idCuenta,numeroCuenta,idTipoCuenta,idCliente) VALUES (6,45254141,2,5);
INSERT INTO cuenta (idCuenta,numeroCuenta,idTipoCuenta,idCliente) VALUES (7,22324532,5,5);
INSERT INTO cuenta (idCuenta,numeroCuenta,idTipoCuenta,idCliente) VALUES (8,23582110,4,5);
INSERT INTO cuenta (idCuenta,numeroCuenta,idTipoCuenta,idCliente) VALUES (9,25254141,3,5);



