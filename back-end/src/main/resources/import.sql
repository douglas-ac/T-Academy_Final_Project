INSERT INTO `user`(`bairro`,`cep`,`complemento`,`ddd`,`localidade`,`logradouro`,`uf`,`birth_date`,`descrimination_column`,`email`,`fone`,`password`,`username`,`nacional_number`,`name`) VALUES ('Centro','40000-000',NULL,'77','Vitoria da Conquista','Rua do Centro','BA','05-03-1999','CPF','mario@gmail.com','77988589023','123456','mariozin','12345678912','Mario Bezerra'), ('Lapa','41000-000','AP 1, BL 1','71','Salvador','Rua da Lapa','BA','22-07-1992','CPF','douglas@gmail.com','71987654321','123456','douglas','98765432198','Douglas Almeida'), ('Barra', '41000-000', '', '71', 'Salvador', 'Orla', 'BA', '22-07-1992', 'CPF', 'maria@gmail.com', '71987654321', '123456', 'maria', '98765432198', 'Maria da Silva');

INSERT INTO `product_model` (`product_type`,`descricao`,`nome`,`preco`,`modelo`,`quilometragem`,`automaker`,`category`,`part_condition`) VALUES (1,'Prata, 4 portas, ano 2010','Celta',10000,'2010/2011',200000,NULL,NULL,NULL), (1,'Vermelho, 4 portas, ano 2010, AC','Celta',12000,'2010/2011',150000,NULL,NULL,NULL), (1,'Preto, 4 portas, ano 2008','Uno',8500,'Mile',180000,NULL,NULL,NULL), (2,'c3 2010-2015','Amortecedor',450,NULL,NULL,7,'Comum',0);

INSERT INTO `announcement`(`bairro`,`cep`,`complemento`,`ddd`,`localidade`,`logradouro`,`uf`,`amount`,`date`,`product_id`,`user_id`) VALUES ('Centro','40000-000',NULL,'71','Salvador','Praça Castro Alves','BA',1,'2022-01-01 00:00:00',1,1), ('Lapa','42222-222',NULL,'21','Rio de Janeiro','Copacabana','RJ',1,'2022-05-20 00:00:00',2,1), ('Matriz','41000-000',NULL,'77','Vitoria da Conquista','Praça da Matriz','BA',3,'2022-07-29 00:00:00',4,2);

insert into `orders` (`discount`, `sub_total`, `user_id`) values (10, 450, 2);

insert into `order_to_product` values (1, 4);

INSERT INTO product_model(product_type, descricao, nome, preco, year, automaker, modelo, category, color, quilometragem) VALUES
(1, "Ar condicionado e vidro elétrico", "Palio", 35000, 2012, 5, "Palio", "carro popular", "prata", 200645.3),
(1, "Vidro elétrico", "Crossfox", 45000, 2010, 6, "Crossfox", "SUV", "Preto", 63213.2),
(1, "Ar condicionado, motor 1.6", "Argo", 76000, 2016, 5, "Argo", "carro popular", "Branco", 12300),
(1, "Carro 0km, vidro elétrico, ar condicionado, teto solar, câmbio automático", "Rav4", 180000, 2018, 8, "Rav4", "SUV", "Pérola", 0),
(1, "Central multimídia, motor 2.0", "Charger", 120000, 2014, 8, "Charger GT", "Muscle", "Preto", 204201.5),
(1, "Central multimídia", "Celta", 36500, 2006, 7, "Celta", "carro popular", "Vermelho", 120036.5),
(1, "Seminovo, motor 1.6", "Gol", 62000, 2013, 6, "Gol", "carro popular", "Vermelho", 5072.3);

INSERT INTO product_model(product_type, nome, descricao, preco, year, automaker, category, part_condition, brand, vehicle_type) VALUES
(2, "cilindro auxiliar", "cilindro auxiliar embreagem chevrolet s10", 305.9, 2015, 1, "embreagem", 1, "SKF", "Carro"),
(2, "correia dentada", "kit correia dentada renault duster", 229.9, 2016, 2, "correia", 1, "Zen", "Caminhão"),
(2, "amortecedor", "Amortecedor fiat uno dianteiro Nakata",	 279.9, 2010, 3, "armotecedor", 1, "Nakata", "Carro"),
(2, "amortecedor", "Amortecedor ford fiesta dianteiro Nakata", 310.9, 2016, 5, "armotecedor", 1, "Nakata", "Carro"),
(2, "filtro ar condicionado", "filtro ar condicionado chevrolet celta", 29.9, 2017, 7, "climatização", 2, "Tecfil", "Carro");
