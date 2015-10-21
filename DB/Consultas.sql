/*Primero*/
CREATE PROCEDURE IncioSesion
	@username varchar(20),
	@pass varchar(20),
	@resul varchar(5) output
AS
BEGIN
	SELECT idUsuario FROM Usuario WHERE username = @username AND pass = @pass;
	IF @@ROWCOUNT == 1
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
AS
BEGIN
	SELECT * FROM Producto;
END