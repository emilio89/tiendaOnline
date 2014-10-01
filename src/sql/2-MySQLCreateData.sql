-- ----------------------------------------------------------------------------
-- Put here INSERT statements for inserting data required by the application
-- in the "pojo" database.
-------------------------------------------------------------------------------

INSERT INTO UserProfile VALUES(7,'emilio2','789','Emilio','Dominguez','emilio89@gmail.com' ,'9999999s',635882115,'23/02/2999','Normal',5);

INSERT INTO Categoria VALUES (1,'Ropa Hombre', 0);
INSERT INTO Categoria VALUES (2,'Ropa Mujer', 0);
INSERT INTO Categoria VALUES (3,'Ropa Niño', 1);
INSERT INTO Categoria VALUES (4,'Ropa Niña', 2);
INSERT INTO Categoria VALUES (5,'Calzado Niño', 3);



INSERT INTO Ropa VALUES (1,'Camiseta',14, 'Joma' ,'Azul e branca' ,'Camiseta do depor',1);
INSERT INTO Ropa VALUES (2,'Pantalon',54, 'Joma' ,'Azul' ,'Pantalon do depor',1);
INSERT INTO Ropa VALUES (3,'Medias',51, 'Primark' ,'Marrons' ,'Medias normales de todo',2);
INSERT INTO Ropa VALUES (4,'Tenis',98, 'Nike' ,'Negros e naranxas' ,'Tenis para neno último modelo',5);

INSERT INTO StockTalla VALUES (1, 'L',50,1);
INSERT INTO StockTalla VALUES (4, 'XXL',50,1);

INSERT INTO StockTalla VALUES (2, 'M',50,2);
INSERT INTO StockTalla VALUES (3, 'XL',50,3);
INSERT INTO StockTalla VALUES (5, 'L',50,4);


INSERT INTO Comentario VALUES (1, 'Comentario sobre a camiseta do depor con id-1', 7, 1);
INSERT INTO Comentario VALUES (2, 'Comentario sobre as medias do primark con id-3', 7, 3);
INSERT INTO Comentario VALUES (3, 'Comentarioooooooooo sobre o tenis do nike con id-4', 7, 4);








	
