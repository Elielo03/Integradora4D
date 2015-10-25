CREATE PROCEDURE actualizaPersona
	@idPersona int,
	@nombre varchar(20),
	@app varchar(20),
	@apm varchar(20),
	@direccion varchar(50),
	@fecha_nac date,
	@correoE varchar(50),
	@telefono varchar(15),
	@idUsuario int,
	@idDepartamento int,
	@pass varchar(20),
	@idTipoUsuario int
AS
BEGIN
	UPDATE Persona SET nombre = @nombre, app = @app, apm = @apm, direccion = @direccion, fecha_nac = @fecha_nac,
		correoE = @correoE, telefono = @telefono, idDepartamento = @idDepartamento WHERE idPersona = @idPersona;
	UPDATE Usuario SET pass = @pass, idTpoUsuario = @idTipoUsuario WHERE idUsuario = @idUsuario;
END

EXECUTE actualizaPersona 1,'nombre', 'app', 'apm', 'direccion', '20-12-1990', 'correoE', '777-3-20-54-63', 1, 0, 'pass', 4