/*Insert en Tipo de Usuario*/
INSERT INTO TipoUsuario VALUES ('Super Administrador')
INSERT INTO TipoUsuario VALUES ('Administrador')
INSERT INTO TipoUsuario VALUES ('Empleado')
INSERT INTO TipoUsuario VALUES ('Usuario')

/*Insert en Usuario*/
INSERT INTO Usuario VALUES ('xavier_fjuan', 'JavierJuan', 1)
INSERT INTO Usuario VALUES ('eliel_david', 'elielo',4)

/*Insert en Departamento, DEPARTAMENTO EMPIEZA CON SU ID EN 0*/
INSERT INTO Departamento VALUES ('Clientes', 'Clientes', 'true')
INSERT INTO Departamento VALUES ('Electronica', 'Depto. Electronica', 'true')
INSERT INTO Departamento Values ('Perfumeria', 'Depto. Perfumeria y Fragancias', 'true')
INSERT INTO Departamento Values ('Ropa', 'Ropa para la familia', 'true')
INSERT INTO Departamento Values ('Muebleria', 'Depto. de Muebles para el hogar', 'true')

/*Insert en Persona*/
INSERT INTO Persona VALUES ('Francisco Javier', 'Juan', 'Amador', 'Calle Gavilan #14', '03-04-1990', 'true', 'xavier_fjuan@outlook.com', '777-339-69-30', 1, null)
INSERT INTO Persona VALUES ('Eliel David', 'Rodriguez', null, 'Conocida', '02-08-1992', 'true', 'eliel_david@outlook.com', '777-123-45-67', 2, 0)

/*Insert en Categoria*/
INSERT INTO Categoria VALUES('Blancos', 'true', 1)
INSERT INTO Categoria VALUES('Compúto', 'true', 1)
INSERT INTO Categoria VALUES('Perfumes Importados', 'true', 2)
INSERT INTO Categoria VALUES('Perfumes Nacionales', 'true', 2)
INSERT INTO Categoria VALUES('Ropa Niños', 'true', 3)
INSERT INTO Categoria VALUES('Ropa Mujer', 'true', 3)
INSERT INTO Categoria VALUES('Bebes', 'true', 4)
INSERT INTO Categoria VALUES('Salas', 'true', 4)

/*Insert en Producto*/
INSERT INTO Producto VALUES ('Refrigerador Wirpool', 'DEB0125', 'Refrigerador de 3 pies', 20, 50, 6500, 7000, 'true', 'Wirpool', 'localhost/8080/imagen1.jpg', 1)
INSERT INTO Producto VALUES ('Laptop Toshiba', 'DEB0126', 'Laptop 2015', 20, 50, 4500, 5000, 'true', 'Toshiba', 'localhost/8080/imagen1.jpg', 2)
INSERT INTO Producto VALUES ('Perfume Hugo Boss', 'DEB0127', 'Perfume Importado', 20, 50, 1000, 1500, 'true', 'Hugo Boss', 'localhost/8080/imagen1.jpg', 3)
INSERT INTO Producto VALUES ('Perfume Carolina Herrera', 'DEB0128', 'Perfume Nacional', 20, 50, 1000, 1500, 'true', 'CH', 'localhost/8080/imagen1.jpg', 4)
INSERT INTO Producto VALUES ('Mameluco', 'DEB0129', 'Mameluco Niños 1 año', 20, 50, 800, 1300, 'true', 'Pata de Perro', 'localhost/8080/imagen1.jpg', 5)
INSERT INTO Producto VALUES ('Falda', 'DEB0130', 'Falda niñas', 20, 50, 300, 500, 'true', 'NonStop', 'localhost/8080/imagen1.jpg', 6)
INSERT INTO Producto VALUES ('Cunero', 'DEB0131', 'Cunero con cambiador', 20, 50, 4000, 4500, 'true', 'Mueble1', 'localhost/8080/imagen1.jpg', 7)
INSERT INTO Producto VALUES ('Sala California', 'DEB0132', 'Sala de 3 piezas', 20, 50, 8000, 12000, 'true', 'Mueble2', 'localhost/8080/imagen1.jpg', 8)

/*Insert en Venta*/
INSERT INTO Venta VALUES ('2015-10-10', 'Refrigerador Wirpool 3 Pies, Cliente Premium', 'true', 1)
INSERT INTO Venta VALUES ('2015-10-10', 'Venta2', 'true', 2)
INSERT INTO Venta VALUES ('2015-10-12', 'Venta3', 'true', 1)
INSERT INTO Venta VALUES ('2015-10-12', 'Venta4', 'true', 2)
INSERT INTO Venta VALUES ('2015-10-13', 'Venta5', 'true', 1)
INSERT INTO Venta VALUES ('2015-10-14', 'Venta6', 'true', 2)

/*Insert en Venta_detalle*/
INSERT INTO Venta_detalle VALUES (1, 7000, 1, 1)
INSERT INTO Venta_detalle VALUES (3, 5000, 2, 2)
INSERT INTO Venta_detalle VALUES (2, 10000, 3, 3)
INSERT INTO Venta_detalle VALUES (9, 3000, 4, 2)
INSERT INTO Venta_detalle VALUES (4, 90000, 5, 1)
INSERT INTO Venta_detalle VALUES (10, 15000, 6, 4)

/*Select de prueba, no importante*/
SELECT producto.nombre, cantidad, costo_venta FROM Venta_detalle, Producto WHERE Venta_detalle.idProducto = Producto.idProducto;
------------------------------------------------------------------------------------------------------------------------------------
/*Primer procedimiento*/
CREATE PROCEDURE InsertaPersona
	@nombre varchar(20),
	@app varchar(20),
	@apm varchar(20),
	@direccion varchar(50),
	@fecha_nac date,
	@correoE varchar(30),
	@telefono varchar(15),
	@pass varchar(20),
	@idTipoUsuario int,
	@idDepartamento int
AS
BEGIN
	DECLARE @id int;
	INSERT INTO Usuario VALUES (@correoE, @pass, @idTipoUsuario); /*Aqui se va a tomar la primera parte del correo y la contraseña, VERIFICAR ESO*/
	SELECT @id=idUsuario FROM Usuario WHERE username = @correoE AND pass = @pass;
	INSERT INTO Persona VALUES (@nombre,@app,@apm,@direccion,@fecha_nac,'true',@correoE,@telefono,@id,@idDepartamento);
END

EXECUTE InsertaPersona 'Alan', 'Saucedo', 'Colin', 'Conocida', '05-07-1989', 'alansaucedo@outlook.com', '777-320-57-89','AlanColin2',4,0
-----------------------------------------------------------------------------------------------------------------------------------------
/*Segundo Procedimiento*/
CREATE PROCEDURE InsertaCategoria
	@nombre varchar(45),
	@estado varchar(5),
	@idDepartamento int
AS
BEGIN
	INSERT INTO Categoria VALUES (@nombre, @estado, @idDepartamento);
END

EXECUTE InsertaCategoria 'Blancos','true',1
---------------------------------------------------------------------------------------------
/*Tercero Procedimiento*/
CREATE PROCEDURE InsertaDepartamento
	@nombre varchar(20),
	@descripcion varchar(45),
	@estado varchar(5)
AS
BEGIN
	INSERT INTO Departamento VALUES (@nombre, @descripcion, @estado);
END

EXECUTE InsertaDepartamento 'Electronica','Productos electronicos','true'
------------------------------------------------------------------------------------------------
/*Cuarto Procedimiento*/
CREATE PROCEDURE InsertaProducto
	@nombre varchar(40),
	@codigo varchar(45),
	@descripcion varchar(50),
	@existencias int,
	@stock int,
	@precio_c MONEY,
	@precio_v MONEY,
	@estado varchar(5),
	@marca varchar(45),
	@imagen varchar(80),
	@idCategoria int
AS
BEGIN
	INSERT INTO Producto VALUES (@nombre, @codigo, @descripcion, @existencias, @stock, @precio_c, @precio_v, @estado, @marca, @imagen, @idCategoria);
END

EXECUTE InsertaProducto 'Refrigerador','REF2015BLA1','Refrigerador GE de 2 Pies',2500,2000,8000,85000,'true','General Electric','http://localhost:8080/etc',1
-----------------------------------------------------------------------------------------------------
/*Quinto Procedimiento*/
CREATE PROCEDURE InsertaVenta
	@fecha_compra DATE,
	@descripcion varchar(45),
	@estado varchar(5),
	@idPersona int,
	@cantidad int,
	@costo_venta money,
	@idProducto int
AS
BEGIN
	DECLARE @idVenta int;
	INSERT INTO Venta VALUES (@fecha_compra,@descripcion,@estado,@idPersona);
	SELECT @idVenta = idVenta FROM Venta WHERE idPersona = @idPersona;
	INSERT INTO Venta_detalle VALUES (@cantidad, @costo_venta, @idVenta, @idProducto);
END

EXECUTE InsertaVenta '30-10-2015','Compra tarjeta BANAMEX','true',1,1,8500,1