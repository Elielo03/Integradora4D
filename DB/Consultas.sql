/*Primero*/
CREATE PROCEDURE IncioSesion
	@username varchar(20),
	@pass varchar(20),
	@resul varchar(5) OUTPUT
AS
BEGIN
	SELECT idUsuario FROM Usuario WHERE username = @username AND pass = @pass;
	IF @@ROWCOUNT = 1
	BEGIN
		set @resul = 'true'
	END
	ELSE
	BEGIN
		set @resul = 'false'
	END
END

EXECUTE InicioSesion 'xavier_fjuan@outlook.com', 'JavierJuan1', @resul
--------------------------------------------------------------------------------
/*Segundo*/
CREATE PROCEDURE ConsultaProducto
	@idProducto int OUTPUT,
	@nombre varchar(40) OUTPUT,
	@codigo varchar(45) OUTPUT,
	@descripcion varchar(50) OUTPUT,
	@existencias int OUTPUT,
	@stock int OUTPUT,
	@precio_c MONEY OUTPUT,
	@precio_v MONEY OUTPUT,
	@estado varchar(5) OUTPUT,
	@marca varchar(45) OUTPUT,
	@imagen varchar(80) OUTPUT,
	@idCategoria int OUTPUT
AS
BEGIN
	SELECT @idProducto = idProducto, @nombre = nombre, @codigo = codigo,
		@descripcion = descripcion, @existencias = existencias, @stock = stock, @precio_c = precio_c,
		@precio_v = precio_v, @estado = estado, @marca = marca, @imagen = imagen FROM Producto;
END

EXECUTE ConsultaProducto @idProducto, @nombre, @codigo, @descripcion, @existencias, @stock, @precio_c, @precio_v, @estado, @marca, @imagen, @idCategoria
-------------------------------------------------------------------------------------------------------------------------------------------------------------
/*Tercero*/
CREATE PROCEDURE ConsultaDepartamento
	@idDepartamento int OUTPUT,
	@nombre varchar(20) OUTPUT,
	@descripcion varchar(45) OUTPUT,
	@estado varchar(5) OUTPUT
AS
BEGIN
	SELECT @idDepartamento = idDepartamento, @nombre = nombre, @descripcion = descripcion, @estado = estado FROM Departamento;
END

EXECUTE ConsultaDepartamento @idDepartamento, @nombre, @descripcion, @estado
-----------------------------------------------------------------------------------------------------------------------------------------
/*Cuarto*/
CREATE PROCEDURE ConsultaCategoria
	@idCategoria int OUTPUT,
	@nombre varchar(45) OUTPUT,
	@estado varchar(5) OUTPUT,
	@idDepartamento int OUTPUT
AS
BEGIN

END

