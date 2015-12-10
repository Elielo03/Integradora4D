CREATE PROCEDURE actualizaPersona
	@idPersona int,
	@nombre varchar(20),
	@app varchar(20),
	@apm varchar(20),
	@direccion varchar(50),
	@fecha_nac date,
	@correoE varchar(50),
	@telefono varchar(15),
	@idDepartamento int,
	@pass varchar(20),
	@idTipoUsuario int
AS
BEGIN
	DECLARE @idUsuario int
	SELECT @idUsuario = idUsuario FROM Persona WHERE idPersona = @idPersona;
	UPDATE Persona SET nombre = @nombre, app = @app, apm = @apm, direccion = @direccion, fecha_nac = @fecha_nac,
		correoE = @correoE, telefono = @telefono, idDepartamento = @idDepartamento WHERE idPersona = @idPersona;
	UPDATE Usuario SET pass = @pass, idTipoUsuario = @idTipoUsuario WHERE idUsuario = @idUsuario;
END

EXECUTE actualizaPersona 1,'nombre', 'app', 'apm', 'direccion', '20-12-1990', 'correoE', '777-3-20-54-63', 0, 'pass', 4

CREATE PROCEDURE actProductoExistencias
	@codigo varchar(45),
	@existencias int
AS
BEGIN
	UPDATE Producto SET existencias = @existencias WHERE codigo = @codigo;
END

EXECUTE actProductoExistencias 1ABC,200