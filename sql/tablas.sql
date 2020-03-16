
--TABLAS
CREATE TABLE Cliente (
documento VARCHAR(50) NOT NULL,
tipoDocumento VARCHAR(50) NOT NULL,
nombre VARCHAR(100) NOT NULL,
correo VARCHAR(50) NOT NULL,
telefono VARCHAR(70) NOT NULL,
password VARCHAR(200) NOT NULL
);

CREATE TABLE Paseador(
documento VARCHAR(50) NOT NULL,
tipoDocumento VARCHAR(50) NOT NULL,
nombre VARCHAR(100) NOT NULL,
correo VARCHAR(50) NOT NULL,
telefono VARCHAR(70) NOT NULL,
password VARCHAR(200) NOT NULL,
idPaseoEnCurso INTEGER
);

CREATE TABLE Mascota(
id INTEGER NOT NULL,
nombre VARCHAR(50) NOT NULL,
raza VARCHAR(50) NOT NULL,
edad INTEGER NOT NULL,
genero VARCHAR(50) NOT NULL,
idCliente VARCHAR(50) NOT NULL,
idPaseador VARCHAR(50),
idPaseoEnCurso INTEGER
);

CREATE TABLE Paseo(
id INTEGER NOT NULL,
duracion INTEGER,
precio INTEGER NOT NULL,
especificaciones VARCHAR(300),
idRuta INTEGER NOT NULL
);

CREATE TABLE Subasta(
id INTEGER NOT NULL,
oferta INTEGER NOT NULL,
creador VARCHAR(50) NOT NULL,
idPaseo INTEGER NOT NULL
);

CREATE TABLE Ruta(
id INTEGER NOT NULL,
puntoPartida VARCHAR(50) NOT NULL,
puntoLlegada VARCHAR(50) NOT NULL
);

CREATE TABLE PaseoEnCurso(
id INTEGER NOT NULL,
idPaseador VARCHAR(50) NOT NULL,
idPaseo INTEGER NOT NULL,
latitudUbicacion INTEGER NOT NULL,
longitudUbicacion INTEGER NOT NULL
);

CREATE TABLE Ubicacion(
latitud INTEGER NOT NULL,
longitud INTEGER NOT NULL
);

CREATE TABLE Cliente_Paseo(
idCliente VARCHAR(50) NOT NULL,
idPaseo INTEGER NOT NULL
);

CREATE TABLE Paseador_Subasta(
idPaseador VARCHAR(50) NOT NULL,
idSubasta INTEGER NOT NULL
);

CREATE TABLE Paseador_Paseo(
idPaseador VARCHAR(50) NOT NULL,
idPaseo INTEGER NOT NULL
);

CREATE TABLE Cliente_Ruta(
idCliente VARCHAR(50) NOT NULL,
idRuta INTEGER NOT NULL
);

CREATE TABLE Cliente_Subasta(
idCliente VARCHAR(50) NOT NULL,
idSubasta INTEGER NOT NULL
);

--PRIMARIAS

ALTER TABLE Cliente 
   ADD CONSTRAINT PK_Cliente PRIMARY KEY (documento, tipoDocumento);

ALTER TABLE Paseador 
   ADD CONSTRAINT PK_Paseador PRIMARY KEY (documento, tipoDocumento);
   
ALTER TABLE Mascota 
   ADD CONSTRAINT PK_Mascota PRIMARY KEY (id);

ALTER TABLE Paseo 
   ADD CONSTRAINT PK_Paseo PRIMARY KEY (id);
   
ALTER TABLE Subasta 
   ADD CONSTRAINT PK_Subasta PRIMARY KEY (id);
   
ALTER TABLE Ruta 
   ADD CONSTRAINT PK_Ruta PRIMARY KEY (id);
   
ALTER TABLE Ubicacion
   ADD CONSTRAINT PK_Ubicacion PRIMARY KEY (latitud, longitud);
   
ALTER TABLE PaseoEnCurso 
   ADD CONSTRAINT PK_PaseoEnCurso PRIMARY KEY (id);

ALTER TABLE Cliente_Paseo 
   ADD CONSTRAINT PK_Cliente_Paseo PRIMARY KEY (idCliente, idPaseo);

ALTER TABLE Paseador_Subasta 
   ADD CONSTRAINT PK_Paseador_Subasta PRIMARY KEY (idPaseador, idSubasta);

ALTER TABLE Cliente_Ruta 
   ADD CONSTRAINT PK_Cliente_Ruta PRIMARY KEY (idCliente, idRuta);

ALTER TABLE Cliente_Subasta 
   ADD CONSTRAINT PK_Cliente_Subasta PRIMARY KEY (idCliente, idSubasta);
   
ALTER TABLE Paseador_Paseo 
   ADD CONSTRAINT PK_Paseador_Paseo PRIMARY KEY (idPaseador, idPaseo);
   
--FORANEAS

ALTER TABLE Paseador
ADD CONSTRAINT fk_paseoencurso
    FOREIGN KEY (idPaseoEnCurso)
    REFERENCES PaseoEnCurso (id);

ALTER TABLE Mascota
ADD CONSTRAINT fk_cliente
    FOREIGN KEY (idCliente)
    REFERENCES Cliente (documento, tipoDocumento);

ALTER TABLE Mascota
ADD CONSTRAINT fk_paseador
    FOREIGN KEY (idPaseador)
    REFERENCES Paseador (documento, tipoDocumento);

ALTER TABLE Mascota
ADD CONSTRAINT fk_paseo
    FOREIGN KEY (idPaseoEnCurso)
    REFERENCES PaseoEnCurso (id);
	
ALTER TABLE Paseo
ADD CONSTRAINT fk_ruta
    FOREIGN KEY (idRuta)
    REFERENCES Ruta (id);
	
ALTER TABLE Subasta
ADD CONSTRAINT fk_paseo
    FOREIGN KEY (idPaseo)
    REFERENCES Paseo (id);
	
ALTER TABLE PaseoEnCurso
ADD CONSTRAINT fk_paseador
    FOREIGN KEY (idPaseador)
    REFERENCES Paseador (documento, tipoDocumento);

ALTER TABLE PaseoEnCurso
ADD CONSTRAINT fk_paseo
    FOREIGN KEY (idPaseo)
    REFERENCES Paseo (id);

ALTER TABLE Cliente_Paseo
ADD CONSTRAINT fk_cliente
    FOREIGN KEY (idCliente)
    REFERENCES Cliente (documento, tipoDocumento);
	
ALTER TABLE Cliente_Paseo
ADD CONSTRAINT fk_paseo
    FOREIGN KEY (idPaseo)
    REFERENCES Paseo (id);
	
ALTER TABLE Paseador_Subasta
ADD CONSTRAINT fk_paseador
    FOREIGN KEY (idPaseador)
    REFERENCES Paseador (documento, tipoDocumento);
	
ALTER TABLE Paseador_Subasta
ADD CONSTRAINT fk_subasta
    FOREIGN KEY (idSubasta)
    REFERENCES Subasta (id);
	
ALTER TABLE Paseador_Paseo
ADD CONSTRAINT fk_paseador
    FOREIGN KEY (idPaseador)
    REFERENCES Paseador (documento, tipoDocumento);
	
ALTER TABLE Paseador_Paseo
ADD CONSTRAINT fk_paseo
    FOREIGN KEY (idPaseo)
    REFERENCES Paseo (id);
	
ALTER TABLE Cliente_Ruta
ADD CONSTRAINT fk_cliente
    FOREIGN KEY (idCliente)
    REFERENCES Cliente (documento, tipoDocumento);
	
ALTER TABLE Cliente_Ruta
ADD CONSTRAINT fk_ruta
    FOREIGN KEY (idRuta)
    REFERENCES Ruta (id);
	
ALTER TABLE Cliente_Subasta
ADD CONSTRAINT fk_cliente
    FOREIGN KEY (idCliente)
    REFERENCES Cliente (documento, tipoDocumento);
	
ALTER TABLE Cliente_Subasta
ADD CONSTRAINT fk_subasta
    FOREIGN KEY (idSubasta)
    REFERENCES Subasta (id);
   
--CHECKS

ALTER TABLE Cliente ADD CONSTRAINT Correo
		CHECK (Cliente.correo LIKE '%@%.%');
		
ALTER TABLE Paseador ADD CONSTRAINT Correo
		CHECK (Paseador.correo LIKE '%@%.%');

--SECUENCIAS
CREATE SEQUENCE id_mascota;
CREATE SEQUENCE id_paseo;
CREATE SEQUENCE id_subasta;
CREATE SEQUENCE id_ruta;
CREATE SEQUENCE id_paseoEnCurso;