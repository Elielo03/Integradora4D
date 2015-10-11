/*Insert en Tipo de Usuario*/
INSERT INTO TipoUsuario VALUES ('Super Administrador')
INSERT INTO TipoUsuario VALUES ('Administrador')
INSERT INTO TipoUsuario VALUES ('Empleado')
INSERT INTO TipoUsuario VALUES ('Usuario')

/*Insert en Usuario*/
INSERT INTO Usuario VALUES ('xavier_fjuan', 'JavierJuan', 1)
INSERT INTO Usuario VALUES ('eliel_david', 'elielo',4)

/*Insert en Departamento, DEPARTAMENTO EMPIEZA CON SU ID EN 0*/
INSERT INTO Departamento VALUES ('Clintes', 'Clientes', 1)
INSERT INTO Departamento VALUES ('Electronicos', 'Depto. Electronica', 1)

/*Insert en Persona*/
INSERT INTO Persona VALUES ('Francisco Javier', 'Juan', 'Amador', 'Calle Gavilan #14', '03-04-1990', 1, 'xavier_fjuan@outlook.com', '777-339-69-30', 1, null)
INSERT INTO Persona VALUES ('Eliel David', 'Rodriguez', null, 'Conocida', '02-08-1992', 1, 'eliel_david@outlook.com', '777-123-45-67', 2, 0)

/*Insert en Categoria*/
INSERT INTO Categoria VALUES('Blancos', 1, 1)

/*Insert en Producto*/
INSERT INTO Producto VALUES ('Refrigerador Wirpool', 'DEB0125', 'Refrigerador de 3 pies', 20, 50, 6500, 7000, 1, 'Wirpool', 'localhost/8080/imagen1.jpg', 1)

/*Insert en Venta*/
INSERT INTO Venta VALUES ('10-10-2015', 'Refrigerador Wirpool 3 Pies, Cliente Premium', 1, 1)

/*Insert en Venta_detalle*/
INSERT INTO Venta_detalle VALUES (1, 7000, 1, 1)

/*Select de prueba, no importante*/
SELECT producto.nombre, cantidad, costo_venta FROM Venta_detalle, Producto WHERE Venta_detalle.idProducto = Producto.idProducto;

/*Primer procedimiento*/

CREATE PROCEDURE InsertaPersona
	@nombre varchar(20),
	@app varchar(20),
	@apm varchar(20),
	@direccion varchar(50),
	@fecha_nac date,
	@estado bit,
	@correoE varchar(30),
	@telefono varchar(15),
	@idUsuario int,
	@idDepartamento int
AS
BEGIN
	INSERT INTO Usuario VALUES ('alansaucedo','alan123', 4); /*Aqui se va a tomar la primera parte del correo y la contraseņa, VERIFICAR ESO*/
	INSERT INTO Persona VALUES (@nombre,@app,@apm,@direccion,@fecha_nac,@estado,@correoE,@telefono,@idUsuario,@idDepartamento);
END

EXECUTE InsertaPersona 'Alan', 'Saucedo', 'Colin', 'Conocida', '05-07-1989', 1, 'alansaucedo@outlook.com', '777-320-57-89', 3, 0