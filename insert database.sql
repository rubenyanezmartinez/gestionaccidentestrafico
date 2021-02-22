use `accidentes`;

INSERT INTO `tipofactor` (`id`,`nombre`) VALUES (1,'Estado Carretera');
INSERT INTO `tipofactor` (`id`,`nombre`) VALUES (2,'Meteorologia');
INSERT INTO `tipofactor` (`id`,`nombre`) VALUES (3,'Luminosidad');

INSERT INTO `factor` (`id`,`valor`,`tipoFactor_id`) VALUES (1,'Mojada',1);
INSERT INTO `factor` (`id`,`valor`,`tipoFactor_id`) VALUES (2,'Oscuridad',3);
INSERT INTO `factor` (`id`,`valor`,`tipoFactor_id`) VALUES (3,'Lluvia',2);
INSERT INTO `factor` (`id`,`valor`,`tipoFactor_id`) VALUES (4,'Seca',1);
INSERT INTO `factor` (`id`,`valor`,`tipoFactor_id`) VALUES (5,'Despejado',2);
INSERT INTO `factor` (`id`,`valor`,`tipoFactor_id`) VALUES (6,'Luz natural',3);

INSERT INTO `servicioemergencia` (`id`,`localidad`,`tipo`) VALUES (1,'Ourense','POLICIA');
INSERT INTO `servicioemergencia` (`id`,`localidad`,`tipo`) VALUES (2,'Lugo','POLICIA');
INSERT INTO `servicioemergencia` (`id`,`localidad`,`tipo`) VALUES (3,'Vigo','AMBULANCIA');
INSERT INTO `servicioemergencia` (`id`,`localidad`,`tipo`) VALUES (4,'Santiago','BOMBEROS');
INSERT INTO `servicioemergencia` (`id`,`localidad`,`tipo`) VALUES (5,'Ourense','OTRO');

INSERT INTO `conductor` (`dni`,`edad`,`genero`,`nombre`) VALUES ('11111111T',32,'MASCULINO','Manuel');
INSERT INTO `conductor` (`dni`,`edad`,`genero`,`nombre`) VALUES ('22222222A',45,'FEMENINO','Ana');

INSERT INTO `vehiculo` (`matricula`,`anho_matriculacion`,`tipo`,`conductor_dni`) VALUES ('1111AAA',2009,'Turismo','11111111T');
INSERT INTO `vehiculo` (`matricula`,`anho_matriculacion`,`tipo`,`conductor_dni`) VALUES ('5555EEE',2019,'Turismo','22222222A');
INSERT INTO `vehiculo` (`matricula`,`anho_matriculacion`,`tipo`,`conductor_dni`) VALUES ('OU3333A',2001,'Motocicleta','11111111T');

INSERT INTO `carretera` (`id`,`kilometro`,`nombre`) VALUES (1,125,'A-3');
INSERT INTO `carretera` (`id`,`kilometro`,`nombre`) VALUES (2,3,'OU-543');

INSERT INTO `accidente` (`id`,`fecha`,`gravedad`,`maniobra`,`carretera_id`,`conductor_dni`) VALUES (1,'2021-01-17 23:00:00.000000','LEVE','OTRO',1,'11111111T');
INSERT INTO `accidente` (`id`,`fecha`,`gravedad`,`maniobra`,`carretera_id`,`conductor_dni`) VALUES (2,'2020-12-31 23:00:00.000000','LEVE','OTRO',2,'22222222A');

INSERT INTO `accidenteyfactor` (`id`,`accidente_id`,`factor_id`) VALUES (1,1,1);
INSERT INTO `accidenteyfactor` (`id`,`accidente_id`,`factor_id`) VALUES (2,1,2);
INSERT INTO `accidenteyfactor` (`id`,`accidente_id`,`factor_id`) VALUES (3,1,3);
INSERT INTO `accidenteyfactor` (`id`,`accidente_id`,`factor_id`) VALUES (4,2,4);
INSERT INTO `accidenteyfactor` (`id`,`accidente_id`,`factor_id`) VALUES (5,2,5);
INSERT INTO `accidenteyfactor` (`id`,`accidente_id`,`factor_id`) VALUES (6,2,6);

INSERT INTO `accidenteyservicioemergencia` (`id`,`accidente_id`,`servicioEmergencia_id`) VALUES (1,1,1);
INSERT INTO `accidenteyservicioemergencia` (`id`,`accidente_id`,`servicioEmergencia_id`) VALUES (2,1,2);
INSERT INTO `accidenteyservicioemergencia` (`id`,`accidente_id`,`servicioEmergencia_id`) VALUES (3,2,3);
INSERT INTO `accidenteyservicioemergencia` (`id`,`accidente_id`,`servicioEmergencia_id`) VALUES (4,2,4);
INSERT INTO `accidenteyservicioemergencia` (`id`,`accidente_id`,`servicioEmergencia_id`) VALUES (5,2,4);