INSERT INTO TipoUsuario VALUES ('Administrador')
INSERT INTO Usuario VALUES ('xavier_fjuan', 'JavierJuan', 1)
INSERT INTO Persona VALUES ('Francisco Javier', 'Juan', 'Amador', 'Calle Gavilan #14', '03-04-1990', 1, 'xavier_fjuan@outlook.com', '777-339-69-30', 1, 0)

INSERT INTO Departamento VALUES ('Deportes', 'Deportes Marti', 1)
INSERT INTO Categoria VALUES('Blancos', 1, 0)

INSERT INTO Producto VALUES ('Refrigerador Wirpool', 'DEB0125', 'Refrigerador de 3 pies', 20, 50, 6500, 7000, 1, 'Wirpool', 'localhost/8080/imagen1.jpg', 1)

INSERT INTO Venta VALUES ('10-10-2015', 'Refrigerador Wirpool 3 Pies, Cliente Premium', 1, 1)

INSERT INTO Venta_detalle VALUES (1, 7000, 1, 1)


SELECT producto.nombre, cantidad, costo_venta FROM Venta_detalle, Producto WHERE Venta_detalle.idProducto = Producto.idProducto;