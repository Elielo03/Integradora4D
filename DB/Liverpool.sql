create database Liverpool
go
use Liverpool
go

create table TipoUsuario(
idTipoUsuario int identity(1,1),
tipo varchar(20) not null,
constraint pk_idTipo primary key (idTipoUsuario))

create table Usuario(
idUsuario int identity(1,1),
username varchar(20)not null,
pass varchar(20)not null,
idTipoUsuario int,
constraint pk_idUsuario primary key (idUsuario),
constraint fk_Usuario_Tipo foreign key (idTipoUsuario) references TipoUsuario(idTipoUsuario))

create table Departamento(
idDepartamento int identity (0,1),
nombre varchar(20) not null,
descripcion varchar(45),
estado bit not null,
constraint pk_idDepartamento primary key (idDepartamento))

create table Persona(
idPersona int identity(1,1),
nombre varchar(20)not null,
app varchar(20)not null,
apm varchar(20),
direccion varchar(50)not null,
fecha_nac date,
estado bit not null,
correoE varchar(30) not null,
telefono varchar(15),
idUsuario int,
idDepartamento int,
constraint pk_idPersona primary key (idPersona),
constraint fk_persona_Usuario foreign key (idUsuario) references Usuario(idUsuario),
constraint fk_Persona_Departamento foreign key (idDepartamento) references Departamento(idDepartamento))

create table Categoria(
idCategoria int identity(1,1),
nombre varchar(45) not null,
estado bit not null,
idDepartamento int,
constraint pk_idCategoria primary key (idCategoria),
constraint fk_Categoria_Departamento foreign key (idDepartamento) references Departamento(idDepartamento))

create table Venta(
idVenta int identity(1,1),
fecha_compra date not null,
descripcion varchar(45),
estado bit not null,
idPersona int,
constraint pk_idVenta primary key (idVenta),
constraint fk_Venta_Persona foreign key (idPersona) references Persona (idPersona))

create table Producto(
idProducto int identity(1,1),
nombre varchar(40) not null,
codigo varchar(45) not null,
descripcion varchar(50),
existencias int,
stock int,
precio_c MONEY not null,
precio_v MONEY not null,
estado bit not null,
marca varchar(45) not null,
imagen varchar(80) not null,
idCategoria int,
constraint pk_idProducto primary key (idProducto),
constraint fk_Producto_Categoria foreign key (idCategoria) references Categoria(idCategoria))

create table Venta_detalle(
idVenta_detalle int identity(1,1),
cantidad int,
costo_venta MONEY,
idVenta int,
idProducto int,
constraint pk_idVenta_detalle primary key (idVenta_Detalle),
constraint fk_Venta_detalle_Venta foreign key (idVenta) references Venta(idVenta),
constraint fk_Venta_detalle_Producto foreign key (idProducto) references Producto(idProducto))