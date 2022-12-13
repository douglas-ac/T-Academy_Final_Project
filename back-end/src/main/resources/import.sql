-- USERS' INSERTS
INSERT INTO `user`(`bairro`,`cep`,`complemento`,`localidade`,`logradouro`,`uf`,`birth_date`,`descrimination_column`,`email`,`fone`,`password`,`username`,`nacional_number`,`name`) VALUES ('Centro','40000-000',NULL,'Vitoria da Conquista','Rua do Centro','BA','05-03-1999','CPF','mario@gmail.com','77988589023','$2a$12$Ml0FV/yHsQ6xqTfOJbW/9eW8f/UDybZRy4hph1ZE5gMT2rADXvyPW','mariozin','12345678912','Mario Bezerra');
INSERT INTO `user`(`bairro`,`cep`,`complemento`,`localidade`,`logradouro`,`uf`,`birth_date`,`descrimination_column`,`email`,`fone`,`password`,`username`,`nacional_number`,`name`) VALUES ('Lapa','41000-000','AP 1, BL 1','Salvador','Rua da Lapa','BA','22-07-1992','CPF','douglas@gmail.com','71987654321','$2a$12$Ml0FV/yHsQ6xqTfOJbW/9eW8f/UDybZRy4hph1ZE5gMT2rADXvyPW','douglas','98765432198','Douglas Almeida');
INSERT INTO `user`(`bairro`,`cep`,`complemento`,`localidade`,`logradouro`,`uf`,`birth_date`,`descrimination_column`,`email`,`fone`,`password`,`username`,`nacional_number`,`name`) VALUES ('Barra', '41000-000', '', 'Salvador', 'Orla', 'BA', '22-07-1992', 'CPF', 'maria@gmail.com', '71987654321', '$2a$12$Ml0FV/yHsQ6xqTfOJbW/9eW8f/UDybZRy4hph1ZE5gMT2rADXvyPW', 'maria', '98765432198', 'Maria da Silva');

-- CARS' INSERTS
INSERT INTO `product_model` (`product_type`,`description`,`name`,`price`, `year`,`model`,`quilometragem`,`automaker`,`category`,`part_condition`, `color`) VALUES (1,'Prata, 4 portas, ano 2010','Celta', 10000, 2010, '2010/2011', 200000, 'CHEVROLET', 'popular', NULL, 'Prata');
INSERT INTO `product_model` (`product_type`,`description`,`name`,`price`, `year`,`model`,`quilometragem`,`automaker`,`category`,`part_condition`, `color`) VALUES (1,'Vermelho, 4 portas, ano 2010, AC','Celta',12000, 2010,'2010/2011', 150000, 'CHEVROLET', 'popular', NULL,'Vermelho');
INSERT INTO `product_model` (`product_type`,`description`,`name`,`price`, `year`,`model`,`quilometragem`,`automaker`,`category`,`part_condition`, `color`) VALUES (1,'4 portas, ano 2008','Uno',8500, 2008, 'Mile', 180000, 'FIAT', 'popular', NULL, 'Branco');
INSERT INTO `product_model` (`product_type`, `description`, `name`, `price`, `year`, `automaker`, `model`, `category`, `color`, `quilometragem`) VALUES (1, "Ar condicionado e vidro elétrico", "Palio", 35000, 2012, 'FIAT', "Palio", "popular", "prata", 200645.3);
INSERT INTO `product_model` (`product_type`, `description`, `name`, `price`, `year`, `automaker`, `model`, `category`, `color`, `quilometragem`) VALUES (1, "Vidro elétrico", "Crossfox", 45000, 2022, 'VOLKSWAGEN', "Crossfox", "SUV", "Preto", 0);
INSERT INTO `product_model` (`product_type`, `description`, `name`, `price`, `year`, `automaker`, `model`, `category`, `color`, `quilometragem`) VALUES (1, "Ar condicionado, motor 1.6", "Argo", 76000, 2016, 'FIAT', "Argo", "popular", "Branco", 12300);
INSERT INTO `product_model` (`product_type`, `description`, `name`, `price`, `year`, `automaker`, `model`, `category`, `color`, `quilometragem`) VALUES (1, "Carro 0km, vidro elétrico, ar condicionado, teto solar, câmbio automático", "Rav4", 180000, 2018, 'OUTROS', "Rav4", "SUV", "bege", 0);
INSERT INTO `product_model` (`product_type`, `description`, `name`, `price`, `year`, `automaker`, `model`, `category`, `color`, `quilometragem`) VALUES (1, "Central multimídia, motor 2.0", "Charger", 120000, 2014, 'OUTROS', "Charger GT", "luxo", "Preto", 204201.5);
INSERT INTO `product_model` (`product_type`, `description`, `name`, `price`, `year`, `automaker`, `model`, `category`, `color`, `quilometragem`) VALUES (1, "Central multimídia", "Celta", 36500, 2006, 'CHEVROLET', "Celta", "popular", "Cinza", 120036.5);
INSERT INTO `product_model` (`product_type`, `description`, `name`, `price`, `year`, `automaker`, `model`, `category`, `color`, `quilometragem`) VALUES (1, "Seminovo, motor 1.6", "Gol", 62000, 2013, 'VOLKSWAGEN', "Gol", "popular", "Verde", 5072.3);

-- AUTOPARTS' INSERTS
INSERT INTO `product_model` (`product_type`,`description`,`name`,`price`, `year`,`model`,`quilometragem`,`automaker`,`category`,`part_condition`, `brand`, `vehicle_type`) VALUES (2,'c3 2010-2015','Amortecedor',450, 2022, NULL, NULL, 'CHEVROLET', 'amortecedor', 'NOVO', 'nakata', 'suv');
INSERT INTO `product_model` (`product_type`, `name`, `description`, `price`, `year`, `automaker`, `category`, `part_condition`, `brand`, `vehicle_type`) VALUES (2, "cilindro auxiliar", "cilindro auxiliar embreagem chevrolet s10", 305.9, 2015, 'BMW', "embreagem", 'USADO', "wisa", "carro");
INSERT INTO `product_model` (`product_type`, `name`, `description`, `price`, `year`, `automaker`, `category`, `part_condition`, `brand`, `vehicle_type`) VALUES (2, "correia dentada", "kit correia dentada renault duster", 229.9, 2016, 'FORD', "correia", 'NOVO', "freemax", "caminhao");
INSERT INTO `product_model` (`product_type`, `name`, `description`, `price`, `year`, `automaker`, `category`, `part_condition`, `brand`, `vehicle_type`) VALUES (2, "amortecedor", "Amortecedor fiat uno dianteiro Nakata",	 279.9, 2010, 'HONDA', "amortecedor", 'NOVO', "nakata", "carro");
INSERT INTO `product_model` (`product_type`, `name`, `description`, `price`, `year`, `automaker`, `category`, `part_condition`, `brand`, `vehicle_type`) VALUES (2, "amortecedor", "Amortecedor ford fiesta dianteiro", 310.9, 2016, 'FIAT', "amortecedor", 'USADO', "sabo", "carro");
INSERT INTO `product_model` (`product_type`, `name`, `description`, `price`, `year`, `automaker`, `category`, `part_condition`, `brand`, `vehicle_type`) VALUES (2, "filtro ar condicionado", "filtro ar condicionado chevrolet celta", 29.9, 2017, 'CHEVROLET', "climatização", 'NOVO', "ymax", "carro");

-- ADS' INSERTS
INSERT INTO `announcement`(`bairro`,`cep`,`complemento`, `localidade`,`logradouro`,`uf`,`amount`,`date`, `status`, `access_count`,`product_id`,`user_id`) VALUES ('Centro','40000-000',NULL,'Salvador','Praça Castro Alves','BA',1,'2022-01-01 00:00:00', 'AVAILABLE', 0, 1, 1);
INSERT INTO `announcement`(`bairro`,`cep`,`complemento`, `localidade`,`logradouro`,`uf`,`amount`,`date`, `status`, `access_count`,`product_id`,`user_id`) VALUES ('Centro','40000-000',NULL,'Salvador','Praça Castro Alves','BA',1,'2022-01-01 00:00:00', 'AVAILABLE', 0, 2, 1);
INSERT INTO `announcement`(`bairro`,`cep`,`complemento`, `localidade`,`logradouro`,`uf`,`amount`,`date`, `status`, `access_count`,`product_id`,`user_id`) VALUES ('Centro','40000-000',NULL,'Feira de Santana','Praça Castro Alves','BA',1,'2022-01-01 00:00:00', 'AVAILABLE', 0, 3, 1);
INSERT INTO `announcement`(`bairro`,`cep`,`complemento`, `localidade`,`logradouro`,`uf`,`amount`,`date`, `status`, `access_count`,`product_id`,`user_id`) VALUES ('Centro','40000-000',NULL,'Salvador','Praça Castro Alves','BA',1,'2022-01-01 00:00:00', 'AVAILABLE', 0, 7, 3);
INSERT INTO `announcement`(`bairro`,`cep`,`complemento`, `localidade`,`logradouro`,`uf`,`amount`,`date`, `status`, `access_count`,`product_id`,`user_id`) VALUES ('Centro','40000-000',NULL,'Aracaju','Praça Castro Alves','SE',1,'2022-01-01 00:00:00', 'AVAILABLE', 0, 8, 3);
INSERT INTO `announcement`(`bairro`,`cep`,`complemento`, `localidade`,`logradouro`,`uf`,`amount`,`date`, `status`, `access_count`,`product_id`,`user_id`) VALUES ('Lapa','42222-222',NULL,'Rio de Janeiro','Copacabana','RJ',1,'2022-05-20 00:00:00', 'AVAILABLE', 0, 4, 2);
INSERT INTO `announcement`(`bairro`,`cep`,`complemento`, `localidade`,`logradouro`,`uf`,`amount`,`date`, `status`, `access_count`,`product_id`,`user_id`) VALUES ('Lapa','42222-222',NULL,'Rio de Janeiro','Copacabana','RJ',1,'2022-05-20 00:00:00', 'AVAILABLE', 0, 5, 2);
INSERT INTO `announcement`(`bairro`,`cep`,`complemento`, `localidade`,`logradouro`,`uf`,`amount`,`date`, `status`, `access_count`,`product_id`,`user_id`) VALUES ('Lapa','42222-222',NULL,'Vitória','Copacabana','ES',1,'2022-05-20 00:00:00', 'AVAILABLE', 0, 6, 2);
INSERT INTO `announcement`(`bairro`,`cep`,`complemento`, `localidade`,`logradouro`,`uf`,`amount`,`date`, `status`, `access_count`,`product_id`,`user_id`) VALUES ('Lapa','42222-222',NULL,'Natal','Copacabana','RN',1,'2022-05-20 00:00:00', 'AVAILABLE', 0, 9, 3);
INSERT INTO `announcement`(`bairro`,`cep`,`complemento`, `localidade`,`logradouro`,`uf`,`amount`,`date`, `status`, `access_count`,`product_id`,`user_id`) VALUES ('Lapa','42222-222',NULL,'Porto Alegre','Copacabana','RS',1,'2022-05-20 00:00:00', 'AVAILABLE', 0, 10, 3);
INSERT INTO `announcement`(`bairro`,`cep`,`complemento`, `localidade`,`logradouro`,`uf`,`amount`,`date`, `status`, `access_count`,`product_id`,`user_id`) VALUES ('Matriz','41000-000',NULL,'Vitoria da Conquista','Praça da Matriz','BA',3,'2022-07-29 00:00:00', 'AVAILABLE', 0, 11, 1);
INSERT INTO `announcement`(`bairro`,`cep`,`complemento`, `localidade`,`logradouro`,`uf`,`amount`,`date`, `status`, `access_count`,`product_id`,`user_id`) VALUES ('Matriz','41000-000',NULL,'Blumenau','Praça da Matriz','SC',5,'2022-07-29 00:00:00', 'AVAILABLE', 0, 12, 2);
INSERT INTO `announcement`(`bairro`,`cep`,`complemento`, `localidade`,`logradouro`,`uf`,`amount`,`date`, `status`, `access_count`,`product_id`,`user_id`) VALUES ('Matriz','41000-000',NULL,'Fortaleza','Praça da Matriz','CE',1,'2022-07-29 00:00:00', 'AVAILABLE', 0, 13, 3);
INSERT INTO `announcement`(`bairro`,`cep`,`complemento`, `localidade`,`logradouro`,`uf`,`amount`,`date`, `status`, `access_count`,`product_id`,`user_id`) VALUES ('Matriz','41000-000',NULL,'Vitoria da Conquista','Praça da Matriz','BA',2,'2022-07-29 00:00:00', 'AVAILABLE', 0, 14, 1);
INSERT INTO `announcement`(`bairro`,`cep`,`complemento`, `localidade`,`logradouro`,`uf`,`amount`,`date`, `status`, `access_count`,`product_id`,`user_id`) VALUES ('Matriz','41000-000',NULL,'São Paulo','Praça da Matriz','SP',7,'2022-07-29 00:00:00', 'AVAILABLE', 0, 15, 2);
INSERT INTO `announcement`(`bairro`,`cep`,`complemento`, `localidade`,`logradouro`,`uf`,`amount`,`date`, `status`, `access_count`,`product_id`,`user_id`) VALUES ('Matriz','41000-000',NULL,'Santo André','Praça da Matriz','SP',4,'2022-07-29 00:00:00', 'AVAILABLE', 0, 16, 3);

insert into role(authority)values('ROLE_USER');
insert into role(authority)values('ROLE_ADMIN');
-- -- ORDERS' INSERTS
-- insert into `orders` (`discount`, `sub_total`, `user_id`) values (10, 450, 2);

-- INSERTS IN HELPER TABLE, ORDER-PRODUTCT
-- insert into `order_to_product` values (1, 4);

-- COMMENTS' INSERTS
INSERT INTO `comment` (`message`, `time`, `announcement_id`, `user_id`) VALUES ('Olá Mário tudo bem? Gostaría de saber se esse carro possui ar condicionado?', NOW(), 2, 2);

-- COMMENTS ANSWER' INSERTS
INSERT INTO `comment_answer` (`message`, `time_created`, `comment_id`, `user_id`) VALUES ('Opa! Fala Douglas tudo certo! Tem ar condicionado, aquecedor, ventilador... Tem de tudo :)', NOW(), 1, 1);
INSERT INTO `comment_answer` (`message`, `time_created`, `comment_id`, `user_id`) VALUES ('Massa, show de bola!', NOW(), 1, 2);
