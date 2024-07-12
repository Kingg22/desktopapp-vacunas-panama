CREATE DATABASE MINSA;
GO

USE MINSA;
-- crear todas las tablas
CREATE TABLE Provincia
(
    ID_provincia INT PRIMARY KEY IDENTITY (0,1),
    provincia    VARCHAR(30),
    CONSTRAINT CK_Provincia_existe CHECK (provincia IN
                                          ('Provincia por registrar', /* Problemas o nueva provincia sin registrar a�n */
                                           'Bocas del Toro', /*1*/
                                           'Cocl�', /*2*/
                                           'Col�n', /*3*/
                                           'Chiriqu�', /*4*/
                                           'Dari�n', /*5*/
                                           'Herrera', /*6*/
                                           'Los Santos', /*7*/
                                           'Panam�', /*8*/
                                           'Veraguas', /*9*/
                                           'Guna Yala', /*10*/
                                           'Ember�-Wounaan', /*11*/
                                           'Ng�be-Bugl�',/*12*/
                                           'Panam� Oeste', /*13*/
                                           'Naso Tj�r Di', /*14*/
                                           'Guna de Madugand�', /*15*/
                                           'Guna de Wargand�' /*16*/
                                              ))
);
GO
CREATE TABLE Distrito
(
    ID_distrito INT PRIMARY KEY IDENTITY (0,1),
    distrito    VARCHAR(100) DEFAULT 'Panama',
    idProvincia INT          DEFAULT 8,            --Provincia por defecto (Panama)
    CONSTRAINT FK_Distritos_Provincias FOREIGN KEY (idProvincia) REFERENCES Provincia (ID_provincia),
    CONSTRAINT CK_Distritos_Provincias CHECK (
        (idProvincia = 0 AND distrito LIKE 'Distrito por registrar') OR
        (idProvincia = 1 AND distrito IN ('Almirante',
                                          'Bocas del Toro',
                                          'Changuinola',
                                          'Chiriqu� Grande')) OR
        (idProvincia = 2 AND distrito IN ('Aguadulce',
                                          'Ant�n',
                                          'La Pintada',
                                          'Nat�',
                                          'Ol�',
                                          'Penonom�')) OR
        (idProvincia = 3 AND distrito IN ('Chagres',
                                          'Col�n',
                                          'Donoso',
                                          'Portobelo',
                                          'Santa Isabel',
                                          'Omar Torrijos Herrera')) OR
        (idProvincia = 4 AND distrito IN ('Alanje',
                                          'Bar�',
                                          'Boquer�n',
                                          'Boquete',
                                          'Bugaba',
                                          'David',
                                          'Dolega',
                                          'Gualaca',
                                          'Remedios',
                                          'Renacimiento',
                                          'San F�lix',
                                          'San Lorenzo',
                                          'Tierras Altas',
                                          'Tol�')) OR
        (idProvincia = 5 AND distrito IN ('Chepigana',
                                          'Pinogana',
                                          'Santa Fe',
                                          'Guna de Wargand�')) OR
        (idProvincia = 6 AND distrito IN ('Chitr�',
                                          'Las Minas',
                                          'Los Pozos',
                                          'Oc�',
                                          'Parita',
                                          'Pes�',
                                          'Santa Mar�a')) OR
        (idProvincia = 7 AND distrito IN ('Guarar�',
                                          'Las Tablas',
                                          'Los Santos',
                                          'Macaracas',
                                          'Pedas�',
                                          'Pocr�',
                                          'Tonos�')) OR
        (idProvincia = 8 AND distrito IN ('Balboa',
                                          'Chepo',
                                          'Chim�n',
                                          'Panam�',
                                          'San Miguelito',
                                          'Taboga')) OR
        (idProvincia = 9 AND distrito IN ('Atalaya',
                                          'Calobre',
                                          'Ca�azas',
                                          'La Mesa',
                                          'Las Palmas',
                                          'Mariato',
                                          'Montijo',
                                          'R�o de Jes�s',
                                          'San Francisco',
                                          'Santa Fe',
                                          'Santiago',
                                          'Son�')) OR
            /*comarca guna yala, madugandi, wargandi no tiene distrito, provincia 10*/
        (idProvincia = 11 AND distrito IN ('C�maco', 'Samb�')) OR
        (idProvincia = 12 AND distrito IN ('Besik�',
                                           'Jirondai',
                                           'Kankint�',
                                           'Kusap�n',
                                           'Miron�',
                                           'M�na',
                                           'Nole Duima',
                                           '��r�m',
                                           'Santa Catalina',
                                           'Calov�bora')) OR
        (idProvincia = 13 AND distrito IN ('Arraij�n',
                                           'Capira',
                                           'Chame',
                                           'La Chorrera',
                                           'San Carlos')) OR
        (idProvincia = 14 AND distrito IN ('Naso Tj�r Di')) OR
        (idProvincia IS NULL AND distrito IS NULL) -- Permitir NULL si es necesario
        )
);
GO
CREATE TABLE Direccion
(
    ID_direccion INT PRIMARY KEY IDENTITY (0,1),
    direccion    VARCHAR(255),
    idDistrito   INT DEFAULT 0,
    CONSTRAINT FK_Paciente_distrito FOREIGN KEY (idDistrito) REFERENCES Distrito (ID_distrito)
);
GO
CREATE TABLE Paciente
(
    cedula                      VARCHAR(20) PRIMARY KEY,
    nombre_paciente             VARCHAR(50) NOT NULL,
    apellido_paciente           VARCHAR(50) NOT NULL,
    fecha_nacimiento            DATETIME    NOT NULL,
    edad_calculada              INT,
    sexo                        char(1)     NOT NULL,
    telefono_paciente           VARCHAR(15),
    correo_electronico_paciente VARCHAR(50),
    idDireccion                 INT DEFAULT 0,
    CONSTRAINT CK_Paciente_fechaNacimiento CHECK (fecha_nacimiento <= GETDATE()),
    CONSTRAINT CK_Paciente_sexo_M_F CHECK (sexo LIKE 'M' OR sexo LIKE 'F'),
    CONSTRAINT CK_telefono_paciente_no_signo_plus CHECK (telefono_paciente NOT LIKE '%+%'),
    CONSTRAINT CK_Paciente_Edad CHECK (edad_calculada >= 0),
    CONSTRAINT FK_Paciente_Direccion FOREIGN KEY (idDireccion) REFERENCES Direccion (ID_direccion) ON UPDATE CASCADE
);
GO
CREATE TABLE Usuarios
(
    id               INT PRIMARY KEY IDENTITY (1,1),
    cedula           VARCHAR(20) NOT NULL,
    usuario          VARCHAR(50) NOT NULL,
    clave_hash       VARCHAR(60) NOT NULL,
    tipo             INT         NOT NULL,
    fecha_nacimiento DATETIME    NOT NULL,
    created_at       DATETIME DEFAULT CURRENT_TIMESTAMP,
    last_used        DATETIME DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT CK_Usuario_TipoVario UNIQUE (cedula, tipo),
    CONSTRAINT CK_Usuario_fechaNacimiento CHECK (fecha_nacimiento <= GETDATE()),
    CONSTRAINT CK_Usuarios_TipoValido CHECK (tipo in (1, 2, 3, 4, 5, 6))
    /*  1 paciente
        2 doctor
        3 oficinista (Administrativo)
        4 fabricante
        5�admin
        6 autoridad */
)
GO
CREATE TABLE Sede
(
    ID_sede                 INT PRIMARY KEY IDENTITY (0,1),
    nombre_sede             VARCHAR(100) NOT NULL,
    correo_electronico_sede VARCHAR(50),
    telefono_sede           VARCHAR(15),
    region                  VARCHAR(50),
    dependencia_sede        VARCHAR(13)  NOT NULL,
    idDireccion             INT DEFAULT 0,
    CONSTRAINT CK_telefono_sede_no_signo_plus CHECK (telefono_sede NOT LIKE '%+%'),
    CONSTRAINT CK_depedencia_sede CHECK (dependencia_sede IN ('CSS', 'MINSA', 'Privada', 'Por registrar')),
    CONSTRAINT FK_Sede_Direccion FOREIGN KEY (idDireccion) REFERENCES Direccion (ID_direccion) ON UPDATE CASCADE
);
GO
CREATE TABLE Vacuna
(
    ID_vacuna                 INT PRIMARY KEY IDENTITY (0, 1),
    nombre_vacuna             VARCHAR(100),
    edad_minima               INT,
    intervalo_dosis_1_2_meses FLOAT,
    CONSTRAINT CHK_edad_minima CHECK (edad_minima >= 0)
);
GO
CREATE TABLE Dosis
(
    ID_dosis         INT PRIMARY KEY IDENTITY (1,1),
    fecha_aplicacion DATETIME,
    numero_dosis     CHAR(2) NOT NULL, -- ver tabla adjunta con detalles
    idVacuna         INT     NOT NULL, --La vacuna no puede ser nula
    idSede           INT DEFAULT 1,    -- esta debe ser obligatoria para investigar los ESAVI (DEFAULT = San Miguel �rcangel)
    CONSTRAINT CK_NumeroDosis_valor CHECK (numero_dosis in ('1', '2', '3', 'R', 'R1', 'R2', 'P ')),
    CONSTRAINT FK_Dosis_Vacuna FOREIGN KEY (idVacuna) REFERENCES Vacuna (ID_vacuna) ON UPDATE CASCADE,
    CONSTRAINT FK_Dosis_Sede FOREIGN KEY (idSede) REFERENCES Sede (ID_sede) ON UPDATE CASCADE
);
GO
CREATE TABLE Paciente_Dosis
(
    cedulaPac VARCHAR(20) NOT NULL, --Importante la cedula del paciente
    idDosis   INT,
    PRIMARY KEY (cedulaPac, idDosis),
    CONSTRAINT FK_PacienteDosis_Paciente FOREIGN KEY (cedulaPac) REFERENCES Paciente (cedula),
    CONSTRAINT FK_PacienteDosis_Dosis FOREIGN KEY (idDosis) REFERENCES Dosis (ID_dosis)
);
GO
CREATE TABLE Fabricante
(
    ID_fabricante                 INT PRIMARY KEY IDENTITY (1,1),
    nombre_fabricante             VARCHAR(255) NOT NULL,
    telefono_fabricante           VARCHAR(15),
    correo_electronico_fabricante VARCHAR(50),
    direccion_fabricante          VARCHAR(255) DEFAULT 'Direcci�n por registrar',
    contacto_fabricante           VARCHAR(50),
    CONSTRAINT CK_telefono_fabricante_no_signo_plus CHECK (telefono_fabricante NOT LIKE '%+%')
);
GO
CREATE TABLE Almacen
(
    ID_almacen                 INT PRIMARY KEY IDENTITY (1,1) NOT NULL,
    nombre_almacen             VARCHAR(100)                   NOT NULL,
    dependencia_almacen        VARCHAR(7)                     NOT NULL,
    correo_electronico_almacen VARCHAR(50),
    telefono_almacen           VARCHAR(15),
    ID_direccion               INT DEFAULT 0,
    encargado                  VARCHAR(50),
    CONSTRAINT CK_telefono_almacen_no_signo_plus CHECK (telefono_almacen NOT LIKE '%+%'),
    CONSTRAINT CK_Almacen_dependencia CHECK (dependencia_almacen IN ('CSS', 'MINSA', 'Privada')),
    CONSTRAINT FK_Almacen_Direccion FOREIGN KEY (ID_direccion) REFERENCES Direccion (ID_direccion) ON UPDATE CASCADE
);
GO
CREATE TABLE Almacen_Inventario
(
    ID_almacen         INT         NOT NULL,
    ID_vacuna          INT         NOT NULL,
    cantidad           INT         NOT NULL,
    fecha_lote_almacen DATETIME    NOT NULL,
    lote_almacen       VARCHAR(10) NOT NULL,
    PRIMARY KEY (ID_almacen, ID_vacuna),
    CONSTRAINT CK_AlmacenInventario_FechaLote CHECK (Fecha_lote_almacen > GETDATE()),
    CONSTRAINT FK_AlmacenInventario_Almacen FOREIGN KEY (ID_almacen) REFERENCES Almacen (ID_almacen),
    CONSTRAINT FK_AlmacenInventario_Vacuna FOREIGN KEY (ID_vacuna) REFERENCES Vacuna (ID_vacuna)
);
GO
CREATE TABLE Sede_Inventario
(
    ID_sede         INT DEFAULT 1,
    ID_vacuna       INT         NOT NULL,
    cantidad        INT         NOT NULL,
    fecha_lote_sede DATETIME    NOT NULL,
    lote_sede       VARCHAR(10) NOT NULL,
    PRIMARY KEY (ID_sede, ID_vacuna),
    CONSTRAINT CK_SedeInventario_FechaLote CHECK (Fecha_lote_sede > GETDATE()),
    CONSTRAINT CHK_Cantidad CHECK (Cantidad >= 0),
    CONSTRAINT FK_Inventario_Sede FOREIGN KEY (ID_sede) REFERENCES Sede (ID_sede),
    CONSTRAINT FK_Inventario_Vacuna FOREIGN KEY (ID_vacuna) REFERENCES Vacuna (ID_vacuna)
)
GO
CREATE TABLE Distribucion_Vacunas
(
    ID_distribucion    INT PRIMARY KEY IDENTITY (1,1),
    ID_almacen         INT         NOT NULL,
    ID_sede            INT         NOT NULL,
    ID_vacuna          INT         NOT NULL,
    cantidad           INT         NOT NULL,
    lote               VARCHAR(10) NOT NULL,
    fecha_distribucion DATETIME    NOT NULL,
    CONSTRAINT CK_Distribucion_FechaDistribucion CHECK (Fecha_distribucion <= GETDATE()),
    CONSTRAINT FK_Distribucion_Almacen FOREIGN KEY (ID_almacen) REFERENCES Almacen (ID_almacen),
    CONSTRAINT FK_Distribucion_Sede FOREIGN KEY (ID_sede) REFERENCES Sede (ID_sede),
    CONSTRAINT FK_Distribucion_Vacuna FOREIGN KEY (ID_vacuna) REFERENCES Vacuna (ID_vacuna)
);
GO
-- Se crea esta nueva tabla donde solo vemos la relaci�n si existe, esto permite libertad para sedes privadas
CREATE TABLE Fabricante_Vacuna
(
    ID_fabricante INT NOT NULL,
    ID_vacuna     INT NOT NULL,
    PRIMARY KEY (ID_fabricante, ID_vacuna),
    CONSTRAINT FK_Fabricante_Vacuna_Fabricante FOREIGN KEY (ID_fabricante) REFERENCES Fabricante (ID_fabricante) ON UPDATE CASCADE,
    CONSTRAINT FK_Fabricante_Vacuna_Vacuna FOREIGN KEY (ID_vacuna) REFERENCES Vacuna (ID_vacuna) ON DELETE CASCADE
);
GO
CREATE TABLE Enfermedad
(
    ID_enfermedad     INT PRIMARY KEY IDENTITY (0,1),
    nombre_enfermedad VARCHAR(255) NOT NULL,
    nivel_gravedad    VARCHAR(50)
);
GO
CREATE TABLE Sintomas
(
    ID_sintoma     INT PRIMARY KEY IDENTITY (0,1),
    nombre_sintoma VARCHAR(50) NOT NULL
);
GO
CREATE TABLE Enfermedad_Sintoma
(
    ID_sintoma    INT NOT NULL,
    ID_enfermedad INT NOT NULL,
    PRIMARY KEY (ID_sintoma, ID_enfermedad),
    CONSTRAINT FK_EnfermedadSintoma_sintoma FOREIGN KEY (ID_sintoma) REFERENCES Sintomas (ID_sintoma) ON UPDATE CASCADE,
    CONSTRAINT FK_EnfermedadSintoma_enfermedad FOREIGN KEY (ID_enfermedad) REFERENCES Enfermedad (ID_enfermedad) ON UPDATE CASCADE
);
GO
CREATE TABLE Vacuna_Enfermedad
(
    ID_vacuna     INT NOT NULL,
    ID_enfermedad INT NOT NULL,
    PRIMARY KEY (ID_vacuna, ID_enfermedad),
    CONSTRAINT FK_VacunaEnfermedad_vacuna FOREIGN KEY (ID_vacuna) REFERENCES Vacuna (ID_vacuna) ON DELETE CASCADE,
    CONSTRAINT FK_VacunaEnfermedad_enfermedad FOREIGN KEY (ID_enfermedad) REFERENCES Enfermedad (ID_enfermedad) ON DELETE CASCADE
);
GO

-- Triggers
-- Trigger para asignar autom�ticamente la regi�n a las sedes cuando coincide con la provincia y/o distrito
CREATE TRIGGER ActualizarRegion
    ON Sede
    AFTER INSERT
    AS
BEGIN
    UPDATE S
    SET region =
            CASE
                WHEN P.ID_provincia = 1 THEN 'Bocas del Toro'
                WHEN P.ID_provincia = 2 THEN 'Cocl�'
                WHEN P.ID_provincia = 3 THEN 'Col�n'
                WHEN P.ID_provincia = 4 THEN 'Chiriqu�'
                WHEN P.ID_provincia = 5 THEN 'Dari�n y la comarca Embera Waun�n y Wargand�'
                WHEN P.ID_provincia = 6 THEN 'Herrera'
                WHEN P.ID_provincia = 7 THEN 'Los Santos'
                WHEN P.ID_provincia = 8 AND D.idDistrito = 53 THEN 'San Miguelito'
                WHEN P.ID_provincia = 8 AND D.idDistrito <> 53 THEN 'Panam� Norte/Este/Metro'
                WHEN P.ID_provincia = 9 THEN 'Veraguas'
                WHEN P.ID_provincia = 10 THEN 'Kuna Yala'
                WHEN P.ID_provincia = 11 THEN 'Dari�n y la comarca Embera Waun�n y Wargand�'
                WHEN P.ID_provincia = 12 THEN 'Ngabe Bugl�'
                WHEN P.ID_provincia = 13 AND D.idDistrito <> 79 THEN 'Panam� Oeste'
                WHEN P.ID_provincia = 13 AND D.idDistrito = 79 THEN 'Arraij�n'
                WHEN P.ID_provincia = 16 THEN 'Dari�n y la comarca Embera Waun�n y Wargand�'
                ELSE 'n/a'
                END
    FROM Sede S
             INNER JOIN inserted I ON S.ID_sede = I.ID_sede
             INNER JOIN Direccion D ON I.idDireccion = D.ID_direccion
             INNER JOIN Distrito DD ON D.idDistrito = DD.ID_distrito
             INNER JOIN Provincia P ON DD.idProvincia = P.ID_provincia
END;
GO
-- trigger para actualizar la edad calculada del paciente al momento de insertar o actualizar los datos de esta columna 
CREATE TRIGGER CalcularEdad
    ON Paciente
    AFTER INSERT, UPDATE
    AS
BEGIN
    UPDATE Paciente
    SET edad_calculada =
            CASE
                WHEN DATEADD(YEAR, DATEDIFF(YEAR, fecha_nacimiento, GETDATE()), fecha_nacimiento) > GETDATE()
                    THEN DATEDIFF(YEAR, fecha_nacimiento, GETDATE()) - 1
                ELSE DATEDIFF(YEAR, fecha_nacimiento, GETDATE())
                END
    WHERE fecha_nacimiento IS NOT NULL
      AND (edad_calculada IS NULL OR
           CASE
               WHEN DATEADD(YEAR, DATEDIFF(YEAR, fecha_nacimiento, GETDATE()), fecha_nacimiento) > GETDATE()
                   THEN DATEDIFF(YEAR, fecha_nacimiento, GETDATE()) - 1
               ELSE DATEDIFF(YEAR, fecha_nacimiento, GETDATE())
               END <> edad_calculada);
END;
GO

-- Procedimientos
CREATE PROCEDURE ActualizarEdadPacientes
AS
BEGIN
    UPDATE Paciente
    SET edad_calculada = DATEDIFF(YEAR, fecha_nacimiento, GETDATE())
    WHERE DATEPART(MONTH, fecha_nacimiento) = DATEPART(MONTH, GETDATE())
      AND DATEPART(DAY, fecha_nacimiento) = DATEPART(DAY, GETDATE());
END;
GO
CREATE PROCEDURE InsertarSede @NombreSede VARCHAR(100),
                              @DependenciaSede VARCHAR(13),
                              @CorreoElectronicoSede VARCHAR(50) = NULL,
                              @TelefonoSede VARCHAR(15) = NULL,
                              @DireccionSede VARCHAR(255) = NULL,
                              @DistritoSede VARCHAR(100) = NULL
AS
BEGIN
    DECLARE @ID_Direccion INT;
    DECLARE @ID_Distrito INT;

    -- Validar que direcci�n y distrito esten ambos campos
    IF (@DireccionSede IS NOT NULL AND @DistritoSede IS NULL) OR (@DireccionSede IS NULL AND @DistritoSede IS NOT NULL)
        BEGIN
            RAISERROR ('Debe especificar ambos campos: direcci�n y distrito o ninguno.', 16, 1);
            RETURN;
        END
    -- Validar la dependencia bien escrito
    IF (@DependenciaSede NOT LIKE 'CSS' AND @DependenciaSede NOT LIKE 'MINSA' AND
        @DependenciaSede NOT LIKE 'Privada' AND @DependenciaSede NOT LIKE 'Por registrar')
        BEGIN
            RAISERROR ('La dependencia de la sede debe ser MINSA o CSS o Privada, si no encuentra su opci�n no se puede registrar.', 16, 1);
            RETURN;
        END
    -- Verifica si la sede ya existe
    IF EXISTS (SELECT 1 FROM Sede WHERE nombre_sede = @NombreSede)
        BEGIN
            RAISERROR ('La sede con ese nombre ya existe.', 16, 1);
            RETURN;
        END

    BEGIN TRY
        BEGIN TRANSACTION;

        -- Insertar la direcci�n si no existe
        IF @DireccionSede IS NOT NULL AND @DistritoSede IS NOT NULL
            BEGIN
                -- Verificar si la direcci�n ya existe
                SELECT @ID_Direccion = ID_direccion
                FROM Direccion
                WHERE direccion = @DireccionSede;

                IF @ID_Direccion IS NULL
                    BEGIN
                        -- Insertar nueva direcci�n
                        INSERT INTO Direccion (direccion, idDistrito)
                        VALUES (@DireccionSede, (SELECT ID_distrito FROM Distrito WHERE distrito = @DistritoSede));

                        SET @ID_Direccion = SCOPE_IDENTITY(); -- Obtener el ID de la direcci�n insertada
                    END
            END

        -- Insertar la sede
        INSERT INTO Sede (nombre_sede, dependencia_sede, correo_electronico_sede, telefono_sede, idDireccion)
        VALUES (@NombreSede, @DependenciaSede, @CorreoElectronicoSede, @TelefonoSede, @ID_Direccion);

        COMMIT TRANSACTION;
    END TRY
    BEGIN CATCH
        IF @@TRANCOUNT > 0
            ROLLBACK TRANSACTION;

        DECLARE @ErrorMessage NVARCHAR(4000);
        DECLARE @ErrorSeverity INT;
        DECLARE @ErrorState INT;

        SELECT @ErrorMessage = ERROR_MESSAGE(),
               @ErrorSeverity = ERROR_SEVERITY(),
               @ErrorState = ERROR_STATE();

        RAISERROR (@ErrorMessage, @ErrorSeverity, @ErrorState);
    END CATCH;
END;
GO
CREATE PROCEDURE ManipularPaciente @CedulaPaciente VARCHAR(20),
                                   @NombrePaciente VARCHAR(50),
                                   @ApellidoPaciente VARCHAR(50),
                                   @FechaNacimientoPaciente DATETIME,
                                   @SexoPaciente CHAR(1),
                                   @TelefonoPaciente VARCHAR(15) = NULL,
                                   @CorreoElectronicoPaciente VARCHAR(50) = NULL,
                                   @DireccionResidencialPaciente VARCHAR(255) = NULL,
                                   @DistritoResidePaciente VARCHAR(100) = NULL
AS
BEGIN
    DECLARE @ID_Direccion INT;
    DECLARE @ID_Distrito INT;

    -- Validar que direcci�n y distrito est�n ambos campos
    IF (@DireccionResidencialPaciente IS NOT NULL AND @DistritoResidePaciente IS NULL) OR
       (@DireccionResidencialPaciente IS NULL AND @DistritoResidePaciente IS NOT NULL)
        BEGIN
            RAISERROR ('Debe especificar ambos campos: direcci�n y distrito o ninguno.', 16, 1);
            RETURN;
        END

    -- Validar el sexo bien escrito
    IF (@SexoPaciente NOT LIKE 'M' AND @SexoPaciente NOT LIKE 'F')
        BEGIN
            RAISERROR ('Debe especificar el sexo como M masculino y F femenino.', 16, 1);
            RETURN;
        END

    -- Validar fecha nacimiento en el formato esperado
    IF TRY_CAST(@FechaNacimientoPaciente AS DATETIME) IS NULL OR TRY_CAST(@FechaNacimientoPaciente AS DATE) IS NULL
        BEGIN
            RAISERROR ('Las fechas deben estar en el formato YYYY-MM-DD o YYYY/MM/DD y con hora opcional HH:MM:SS', 16, 1);
            RETURN;
        END

    BEGIN TRY
        BEGIN TRANSACTION;

        -- Insertar la direcci�n si no existe
        IF @DireccionResidencialPaciente IS NOT NULL AND @DistritoResidePaciente IS NOT NULL
            BEGIN
                -- Verificar si la direcci�n ya existe
                SELECT @ID_Direccion = ID_direccion
                FROM Direccion
                WHERE direccion = @DireccionResidencialPaciente;

                IF @ID_Direccion IS NULL
                    BEGIN
                        -- Insertar nueva direcci�n
                        INSERT INTO Direccion (direccion, idDistrito)
                        VALUES (@DireccionResidencialPaciente,
                                (SELECT ID_distrito FROM Distrito WHERE distrito = @DistritoResidePaciente));

                        SET @ID_Direccion = SCOPE_IDENTITY(); -- Obtener el ID de la direcci�n insertada
                    END
            END

        -- Verificar si el paciente ya existe
        IF EXISTS (SELECT 1 FROM Paciente WHERE cedula = @CedulaPaciente)
            BEGIN
                -- Actualizar el paciente si ya existe y los datos son diferentes
                UPDATE Paciente
                SET nombre_paciente             = @NombrePaciente,
                    apellido_paciente           = @ApellidoPaciente,
                    fecha_nacimiento            = @FechaNacimientoPaciente,
                    sexo                        = @SexoPaciente,
                    telefono_paciente           = @TelefonoPaciente,
                    correo_electronico_paciente = @CorreoElectronicoPaciente,
                    idDireccion                 = @ID_Direccion
                WHERE cedula = @CedulaPaciente
                  AND (nombre_paciente != @NombrePaciente OR
                       apellido_paciente != @ApellidoPaciente OR
                       fecha_nacimiento != @FechaNacimientoPaciente OR
                       sexo != @SexoPaciente OR
                       telefono_paciente != @TelefonoPaciente OR
                       correo_electronico_paciente != @CorreoElectronicoPaciente OR
                       idDireccion != @ID_Direccion);
            END
        ELSE
            BEGIN
                -- Insertar el paciente si no existe
                INSERT INTO Paciente (cedula, nombre_paciente, apellido_paciente, fecha_nacimiento,
                                      sexo, telefono_paciente, correo_electronico_paciente, idDireccion)
                VALUES (@CedulaPaciente, @NombrePaciente, @ApellidoPaciente, @FechaNacimientoPaciente,
                        @SexoPaciente, @TelefonoPaciente, @CorreoElectronicoPaciente, @ID_Direccion);
            END
        COMMIT TRANSACTION;
    END TRY
    BEGIN CATCH
        IF @@TRANCOUNT > 0
            ROLLBACK TRANSACTION;

        DECLARE @ErrorMessage NVARCHAR(4000);
        DECLARE @ErrorSeverity INT;
        DECLARE @ErrorState INT;

        SELECT @ErrorMessage = ERROR_MESSAGE(),
               @ErrorSeverity = ERROR_SEVERITY(),
               @ErrorState = ERROR_STATE();

        RAISERROR (@ErrorMessage, @ErrorSeverity, @ErrorState);
    END CATCH;
END;
GO
/* Ejemplo de uso 
EXEC dbo.ManipularPaciente '1-1-1', 'Nombre prueba', 'Apellido prueba', '2000-01-01', @Sexo = 'M';
GO
*/
CREATE PROCEDURE InsertarDosis @cedulaPaciente VARCHAR(20),
                               @fecha_aplicacion DATETIME,
                               @numero_dosis CHAR(2),
                               @idVacuna INT,
                               @idSede INT,
                               @Lote VARCHAR(10)
AS
BEGIN
    -- Verificar si la vacuna existe
    IF NOT EXISTS (SELECT 1 FROM Vacuna WHERE ID_vacuna = @idVacuna)
        BEGIN
            RAISERROR ('La vacuna especificada no existe.', 16, 1);
            RETURN;
        END

    -- Verificar si la sede existe
    IF NOT EXISTS (SELECT 1 FROM Sede WHERE ID_sede = @idSede)
        BEGIN
            RAISERROR ('La sede especificada no existe.', 16, 1);
            RETURN;
        END

    -- Verificar si el paciente existe
    IF NOT EXISTS (SELECT 1 FROM Paciente WHERE cedula = @cedulaPaciente)
        BEGIN
            RAISERROR ('El paciente no existe.', 16, 1);
            RETURN;
        END

    -- Validar fecha aplicaci�n en el formato esperado
    IF TRY_CAST(@fecha_aplicacion AS DATETIME) IS NULL OR TRY_CAST(@fecha_aplicacion AS DATE) IS NULL
        BEGIN
            RAISERROR ('Las fechas deben estar en el formato YYYY-MM-DD o YYYY/MM/DD HH:MM:SS', 16, 1);
            RETURN;
        END

    -- Verifica si la dosis vacuna - numero de dosis ya existe
    IF EXISTS (SELECT 1
               FROM Paciente_Dosis pd
                        INNER JOIN Dosis d ON pd.idDosis = d.ID_dosis
               WHERE pd.cedulaPac = @CedulaPaciente
                 AND d.idVacuna = @idVacuna
                 AND d.numero_dosis = @numero_dosis)
        BEGIN
            RAISERROR ('La dosis para el paciente en esa vacuna y n�mero de dosis ya existe.', 16, 1);
            RETURN;
        END

    IF NOT EXISTS (SELECT 1
                   FROM Sede_Inventario
                   WHERE ID_sede = @idSede AND ID_vacuna = @idVacuna AND lote_Sede LIKE @Lote)
        BEGIN
            RAISERROR ('La informaci�n del lote de la vacuna en esta sede no se encuentra. Verifique el inventario y lote.', 16, 1);
            RETURN;
        END

    -- Validar dosis anteriores
    IF @numero_dosis <> '1' AND @numero_dosis <> 'P'
        BEGIN
            IF @numero_dosis = '2' AND NOT EXISTS (SELECT 1
                                                   FROM Paciente_Dosis pd
                                                            JOIN Dosis d ON pd.idDosis = d.ID_dosis
                                                   WHERE pd.cedulaPac = @cedulaPaciente
                                                     AND d.numero_dosis = '1')
                BEGIN
                    RAISERROR ('La dosis 1 debe ser aplicada antes de la dosis 2.', 16, 1);
                    RETURN;
                END

            IF @numero_dosis = '3' AND NOT EXISTS (SELECT 1
                                                   FROM Paciente_Dosis pd
                                                            JOIN Dosis d ON pd.idDosis = d.ID_dosis
                                                   WHERE pd.cedulaPac = @cedulaPaciente
                                                     AND d.numero_dosis = '1')
                BEGIN
                    RAISERROR ('La dosis 1 debe ser aplicada antes de la dosis 3.', 16, 1);
                    RETURN;
                END

            IF @numero_dosis = 'R' AND NOT EXISTS (SELECT 1
                                                   FROM Paciente_Dosis pd
                                                            JOIN Dosis d ON pd.idDosis = d.ID_dosis
                                                   WHERE pd.cedulaPac = @cedulaPaciente
                                                     AND d.numero_dosis = '1')
                BEGIN
                    RAISERROR ('La dosis 1 debe ser aplicada antes de la dosis R.', 16, 1);
                    ROLLBACK TRANSACTION;
                    RETURN;
                END

            IF @numero_dosis = 'R1' AND NOT EXISTS (SELECT 1
                                                    FROM Paciente_Dosis pd
                                                             JOIN Dosis d ON pd.idDosis = d.ID_dosis
                                                    WHERE pd.cedulaPac = @cedulaPaciente
                                                      AND d.numero_dosis IN ('1', 'R'))
                BEGIN
                    RAISERROR ('La dosis 1 o R debe ser aplicada antes de la dosis R1.', 16, 1);
                    RETURN;
                END

            IF @numero_dosis = 'R2' AND NOT EXISTS (SELECT 1
                                                    FROM Paciente_Dosis pd
                                                             JOIN Dosis d ON pd.idDosis = d.ID_dosis
                                                    WHERE pd.cedulaPac = @cedulaPaciente
                                                      AND d.numero_dosis IN ('R1', '2'))
                BEGIN
                    RAISERROR ('La dosis R1 o 2 debe ser aplicada antes de la dosis R2.', 16, 1);
                    RETURN;
                END
        END
    ELSE
        IF @numero_dosis LIKE 'P'
            BEGIN
                IF EXISTS (SELECT 1
                           FROM Paciente_Dosis pd
                                    INNER JOIN Dosis d ON pd.idDosis = d.ID_dosis
                           WHERE pd.cedulaPac = @cedulaPaciente)
                    BEGIN
                        RAISERROR ('La dosis "P" previa solo puede ser antes de la primera dosis.', 16, 1);
                        RETURN;
                    END
            END

    -- Verificar la edad del paciente y la fecha de la �ltima dosis

    DECLARE @edad_en_meses INT;
    DECLARE @ultima_dosis DATETIME;
    DECLARE @intervalo_dosis INT;
    DECLARE @edad_minima INT;

    SELECT @edad_en_meses = DATEDIFF(MONTH, P.fecha_nacimiento, @fecha_aplicacion)
    FROM Paciente P
    WHERE P.cedula = @cedulaPaciente;

    SELECT @ultima_dosis = MAX(D.fecha_aplicacion)
    FROM Paciente_Dosis PD
             JOIN Dosis D ON PD.idDosis = D.ID_dosis
    WHERE PD.cedulaPac = @cedulaPaciente
      AND D.idVacuna = @idVacuna;

    SELECT @intervalo_dosis = intervalo_dosis_1_2_meses, @edad_minima = edad_minima
    FROM Vacuna
    WHERE ID_vacuna = @idVacuna;

    -- No seguir si no se obtuvo la edad del paciente
    IF @edad_en_meses IS NULL
        BEGIN
            RAISERROR ('No se pudo obtener la edad del paciente.', 16, 1);
            RETURN;
        END

    -- Verificar la edad m�nima para la primera dosis o dosis previa
    IF @numero_dosis IN ('1', 'P') AND @edad_en_meses < @edad_minima
        BEGIN
            RAISERROR ('Paciente no tiene la edad adecuada para esta vacuna.', 16, 1);
            RETURN;
        END

    -- Verificar el intervalo entre dosis
    IF @numero_dosis = '2' AND @ultima_dosis IS NOT NULL AND
       DATEDIFF(MONTH, @ultima_dosis, @fecha_aplicacion) < @intervalo_dosis
        BEGIN
            RAISERROR ('No ha pasado el tiempo suficiente desde la primera dosis.', 16, 1);
            RETURN;
        END

    BEGIN TRY
        BEGIN TRANSACTION;
        -- Verificar si hay suficiente cantidad de dosis del lote en el inventario de la sede
        DECLARE @CantidadDisponible INT;
        DECLARE @FechaLote DATETIME;
        SELECT @CantidadDisponible = Cantidad, @FechaLote = fecha_lote_sede
        FROM Sede_Inventario
        WHERE ID_sede = @idSede
          AND ID_vacuna = @idVacuna
          AND lote_sede LIKE @Lote;

        IF @CantidadDisponible < 1
            BEGIN
                RAISERROR ('Cantidad insuficiente de dosis de la vacuna en el inventario de la sede.', 16, 1);
                ROLLBACK TRANSACTION;
                RETURN;
            END

        IF @FechaLote <= CURRENT_TIMESTAMP
            BEGIN
                RAISERROR ('La fecha de vencimiento del lote de esta vacuna es el d�a de hoy o anterior.', 16, 1);
                ROLLBACK TRANSACTION;
                RETURN;
            END

        SET @numero_dosis = RTRIM(@numero_dosis);
        -- Insertar la nueva dosis
        INSERT INTO Dosis (fecha_aplicacion, numero_dosis, idVacuna, idSede)
        VALUES (@fecha_aplicacion, @numero_dosis, @idVacuna, @idSede);

        DECLARE @idDosis INT;
        SET @idDosis = SCOPE_IDENTITY();
        -- Obtener el ID de la dosis insertada

        -- Insertar la relaci�n en Paciente_Dosis
        INSERT INTO Paciente_Dosis (cedulaPac, idDosis)
        VALUES (@cedulaPaciente, @idDosis);

        -- Restar la cantidad del inventario de la sede
        UPDATE Sede_Inventario
        SET Cantidad = Cantidad - 1
        WHERE ID_sede = @idSede
          AND ID_vacuna = @idVacuna
          AND lote_sede LIKE @Lote;

        COMMIT TRANSACTION;
    END TRY
    BEGIN CATCH
        IF @@TRANCOUNT > 0
            ROLLBACK TRANSACTION;

        DECLARE @ErrorMessage NVARCHAR(4000);
        DECLARE @ErrorSeverity INT;
        DECLARE @ErrorState INT;

        SELECT @ErrorMessage = ERROR_MESSAGE(),
               @ErrorSeverity = ERROR_SEVERITY(),
               @ErrorState = ERROR_STATE();

        RAISERROR (@ErrorMessage, @ErrorSeverity, @ErrorState);
    END CATCH;
END;
GO
CREATE PROCEDURE DistribuirVacunas @ID_almacen INT,
                                   @ID_sede INT,
                                   @ID_vacuna INT,
                                   @Cantidad INT,
                                   @Lote VARCHAR(10)
AS
BEGIN
    IF NOT EXISTS (SELECT 1
                   FROM Almacen_Inventario
                   WHERE ID_almacen = @ID_almacen AND ID_vacuna = @ID_vacuna AND lote_almacen LIKE @Lote)
        BEGIN
            RAISERROR ('No se pudo obtener informaci�n del lote de vacuna en el inventario almacen', 16, 1);
            RETURN;
        END

    -- Verificar si hay suficiente cantidad en el inventario del almac�n y si la fecha de lote es v�lida
    DECLARE @CantidadDisponible INT;
    DECLARE @FechaLote DATETIME;
    SELECT @CantidadDisponible = cantidad, @FechaLote = fecha_lote_almacen
    FROM Almacen_Inventario
    WHERE ID_almacen = @ID_almacen
      AND ID_vacuna = @ID_vacuna
      AND lote_almacen LIKE @Lote;

    IF @CantidadDisponible < @Cantidad
        BEGIN
            RAISERROR ('Cantidad insuficiente en el almac�n para poder distribuir.', 16, 1);
            RETURN;
        END

    IF @FechaLote < GETDATE()
        BEGIN
            RAISERROR ('No se puede distribuir un lote con fecha menor al d�a de hoy. Revisar inventario almacen', 16, 1);
            RETURN;
        END

    BEGIN TRY
        BEGIN TRANSACTION;
        -- Restar la cantidad del inventario del almac�n
        UPDATE Almacen_Inventario
        SET cantidad = cantidad - @Cantidad
        WHERE ID_almacen = @ID_almacen
          AND ID_vacuna = @ID_vacuna
          AND lote_almacen LIKE @Lote;

        -- Agregar la cantidad al inventario de la sede
        IF EXISTS (SELECT 1
                   FROM Sede_Inventario
                   WHERE ID_sede = @ID_sede AND ID_vacuna = @ID_vacuna AND lote_sede LIKE @Lote)
            BEGIN
                UPDATE Sede_Inventario
                SET cantidad = cantidad + @Cantidad
                WHERE ID_sede = @ID_sede
                  AND ID_vacuna = @ID_vacuna
                  AND lote_sede LIKE @Lote;
            END
        ELSE
            BEGIN
                INSERT INTO Sede_Inventario (ID_sede, ID_vacuna, Cantidad, Fecha_lote_sede, Lote_sede)
                VALUES (@ID_sede, @ID_vacuna, @Cantidad, @FechaLote, @Lote);
            END

        -- Registrar la distribuci�n
        INSERT INTO Distribucion_Vacunas (ID_almacen, ID_sede, ID_vacuna, cantidad, lote, fecha_distribucion)
        VALUES (@ID_almacen, @ID_sede, @ID_vacuna, @Cantidad, @Lote, CURRENT_TIMESTAMP);

        -- Confirmar la transacci�n
        COMMIT TRANSACTION;
    END TRY
    BEGIN CATCH
        -- Manejar errores
        ROLLBACK TRANSACTION;
        DECLARE @ErrorMessage NVARCHAR(4000);
        DECLARE @ErrorSeverity INT;
        DECLARE @ErrorState INT;

        SELECT @ErrorMessage = ERROR_MESSAGE(),
               @ErrorSeverity = ERROR_SEVERITY(),
               @ErrorState = ERROR_STATE();

        RAISERROR (@ErrorMessage, @ErrorSeverity, @ErrorState);
    END CATCH
END;
GO
-- del app usuarios
CREATE PROCEDURE CrearUsuario @Cedula NVARCHAR(50),
                              @Usuario NVARCHAR(50),
                              @Clave NVARCHAR(60),
                              @Tipo INT,
                              @FechaNacimiento DATETIME
AS
BEGIN
    BEGIN TRY
        BEGIN TRANSACTION
            -- Verificar si el usuario ya existe
            IF EXISTS (SELECT 1 FROM Usuarios WHERE cedula = @Cedula AND tipo = @Tipo)
                BEGIN
                    -- Si existe, actualizar el registro
                    UPDATE Usuarios
                    SET usuario    = @Usuario,
                        clave_hash = @Clave,
                        tipo       = @Tipo
                    WHERE cedula = @Cedula
                      AND tipo = @Tipo;
                END
            ELSE
                BEGIN
                    -- Si no existe, insertar un nuevo registro
                    INSERT INTO Usuarios (cedula, usuario, clave_hash, tipo, fecha_nacimiento)
                    VALUES (@Cedula, @Usuario, @Clave, @Tipo, @FechaNacimiento);
                END
        COMMIT TRANSACTION;
    END TRY
    BEGIN CATCH
        IF @@TRANCOUNT > 0
            ROLLBACK TRANSACTION;

        DECLARE @ErrorMessage NVARCHAR(4000);
        DECLARE @ErrorSeverity INT;
        DECLARE @ErrorState INT;

        SELECT @ErrorMessage = ERROR_MESSAGE(),
               @ErrorSeverity = ERROR_SEVERITY(),
               @ErrorState = ERROR_STATE();

        RAISERROR (@ErrorMessage, @ErrorSeverity, @ErrorState);
    END CATCH
END
GO

-- Funciones
CREATE FUNCTION BuscarPacientePorCedula(@cedulaPaciente VARCHAR(20))
    RETURNS VARCHAR(250)
AS
BEGIN
    DECLARE @result VARCHAR(250);

    IF EXISTS (SELECT 1 FROM Paciente WHERE cedula = @cedulaPaciente)
        BEGIN
            SELECT @result =
                   'Paciente encontrado: ' + nombre_paciente + ' ' + apellido_paciente + ', Fecha de nacimiento: ' +
                   CONVERT(VARCHAR, fecha_nacimiento, 103)
            FROM Paciente
            WHERE cedula = @cedulaPaciente;
        END
    ELSE
        BEGIN
            SET @result = 'Paciente no encontrado.';
        END

    RETURN @result;
END;
GO
CREATE FUNCTION BuscarFabricante(
    @idFabricante INT = NULL,
    @idVacuna INT = NULL
)
    RETURNS TABLE
        AS
        RETURN(SELECT f.ID_fabricante,
                      f.nombre_fabricante,
                      f.telefono_fabricante,
                      f.correo_electronico_fabricante,
                      f.direccion_fabricante,
                      f.contacto_fabricante
               FROM Fabricante f
                        INNER JOIN
                    Fabricante_Vacuna fv ON f.ID_fabricante = fv.ID_fabricante
               WHERE (f.ID_fabricante = @idFabricante OR @idFabricante IS NULL)
                 AND (fv.ID_vacuna = @idVacuna OR @idVacuna IS NULL));
GO
CREATE FUNCTION BuscarDosis(
    @idVacuna INT = NULL,
    @cedulaPac VARCHAR(20) = NULL,
    @numeroDosis CHAR(2) = NULL,
    @fechaAplicacion DATETIME = NULL,
    @idSede INT = NULL
)
    RETURNS TABLE
        AS
        RETURN(SELECT d.ID_dosis,
                      d.fecha_aplicacion,
                      d.numero_dosis,
                      d.idVacuna,
                      d.idSede
               FROM Dosis d
                        LEFT JOIN
                    Paciente_Dosis pd ON d.ID_dosis = pd.idDosis
               WHERE (d.idVacuna = @idVacuna OR @idVacuna IS NULL)
                 AND (pd.cedulaPac = @cedulaPac OR @cedulaPac IS NULL)
                 AND (d.numero_dosis = @numeroDosis OR @numeroDosis IS NULL)
                 AND (d.fecha_aplicacion = @fechaAplicacion OR @fechaAplicacion IS NULL)
                 AND (d.idSede = @idSede OR @idSede IS NULL));
GO
-- del app usuarios
CREATE FUNCTION BuscarUsuario(@cedula VARCHAR(20), @tipo int)
    RETURNS TABLE
        AS
        RETURN(SELECT cedula, usuario, tipo, fecha_nacimiento, created_at
               FROM Usuarios
               where cedula = @cedula
                 and tipo = @tipo);
GO
-- Vistas
CREATE VIEW [Vista Paciente] AS
SELECT p.cedula                      as 'C�dula',
       p.nombre_paciente             as 'Nombre',
       p.apellido_paciente           as 'Apellido',
       p.fecha_nacimiento            as 'Fecha de Nacimiento',
       p.edad_calculada              as 'Edad calculada',
       p.sexo                        as 'Sexo',
       p.telefono_paciente           as 'Tel�fono',
       p.correo_electronico_paciente as 'Correo electr�nico',
       d.direccion                   as 'Direcci�n residencia actual',
       dis.distrito                  as 'Distrito',
       prov.provincia                as 'Provincia',
       vac.nombre_vacuna             as 'Nombre vacuna',
       dos.numero_dosis              as 'N�mero de dosis',
       e.nombre_enfermedad           as 'Enfermedad previene',
       vac.edad_minima               as 'Edad m�nima recomendada en meses',
       dos.fecha_aplicacion          as 'Fecha de aplicaci�n',
       vac.intervalo_dosis_1_2_meses as 'Intervalo recomendado entre dosis 1 y 2 en meses',
       s.nombre_sede                 as 'Sede',
       s.dependencia_sede            as 'Dependencia'
FROM Paciente p
         JOIN Paciente_Dosis pd ON p.cedula = pd.cedulaPac
         JOIN Dosis dos ON pd.idDosis = dos.ID_dosis
         JOIN Vacuna vac ON dos.idVacuna = vac.ID_vacuna
         LEFT JOIN Vacuna_Enfermedad ve ON vac.ID_vacuna = ve.ID_vacuna
         LEFT JOIN Enfermedad e ON ve.ID_enfermedad = e.ID_enfermedad
         LEFT JOIN Sede s ON dos.idSede = s.ID_sede
         LEFT JOIN Direccion d ON p.idDireccion = d.ID_direccion
         LEFT JOIN Distrito dis ON d.idDistrito = dis.ID_distrito
         LEFT JOIN Provincia prov ON dis.idProvincia = prov.ID_provincia
GO
CREATE VIEW [Vista Doctor] AS
SELECT p.cedula                                        as 'C�dula',
       p.nombre_paciente                               as 'Nombre',
       p.apellido_paciente                             as 'Apellido',
       CONCAT(nombre_paciente, ' ', apellido_paciente) AS 'Nombre Completo',
       p.fecha_nacimiento                              as 'Fecha de Nacimiento',
       p.edad_calculada                                as 'Edad calculada',
       p.sexo                                          as 'Sexo',
       p.telefono_paciente                             as 'Tel�fono',
       p.correo_electronico_paciente                   as 'Correo electr�nico',
       d.direccion                                     as 'Direcci�n residencia actual',
       dis.distrito                                    as 'Distrito',
       prov.provincia                                  as 'Provincia',
       vac.ID_vacuna                                   as 'ID Vacuna',
       vac.nombre_vacuna                               as 'Nombre vacuna',
       pp.nombre_fabricante                            as 'Fabricante',
       dos.fecha_aplicacion                            as 'Fecha de aplicaci�n',
       s.ID_sede                                       as 'ID Sede',
       s.nombre_sede                                   as 'Sede',
       s.dependencia_sede                              as 'Dependencia',
       dos.numero_dosis                                as 'N�mero de dosis',
       vac.intervalo_dosis_1_2_meses                   as 'Intervalo dosis 1 y 2 recomendado en meses',
       DATEDIFF(DAY, dos.fecha_aplicacion,
                (SELECT MAX(dos2.fecha_aplicacion)
                 FROM Dosis dos2
                          JOIN Paciente_Dosis pd2 ON dos2.ID_dosis = pd2.idDosis
                 WHERE pd2.cedulaPac = p.cedula
                   AND dos2.idVacuna = dos.idVacuna
                   AND dos2.numero_dosis > dos.numero_dosis))
                                                       AS 'Intervalo real en d�as',
       vac.edad_minima                                 AS 'Edad m�nima recomandada en meses'
FROM Paciente p
         JOIN Paciente_Dosis pd ON p.cedula = pd.cedulaPac
         JOIN Dosis dos ON pd.idDosis = dos.ID_dosis
         JOIN Vacuna vac ON dos.idVacuna = vac.ID_vacuna
         LEFT JOIN Fabricante_Vacuna pv ON vac.ID_vacuna = pv.ID_vacuna
         LEFT JOIN Fabricante pp ON pv.ID_fabricante = pp.ID_fabricante
         LEFT JOIN Sede s ON dos.idSede = s.ID_sede
         LEFT JOIN Direccion d ON p.idDireccion = d.ID_direccion
         LEFT JOIN Distrito dis ON d.idDistrito = dis.ID_distrito
         LEFT JOIN Provincia prov ON dis.idProvincia = prov.ID_provincia
GO
CREATE VIEW [Vista Administrativo] AS
SELECT p.cedula                      as 'C�dula',
       p.nombre_paciente             as 'Nombre',
       p.apellido_paciente           as 'Apellido',
       p.fecha_nacimiento            as 'Fecha de nacimiento',
       p.edad_calculada              as 'Edad calculada',
       p.sexo                        as 'Sexo',
       p.telefono_paciente           as 'Tel�fono',
       p.correo_electronico_paciente as 'Correo electr�nico',
       d.direccion                   AS 'Direcci�n residencia actual',
       dis.distrito                  as 'Distrito',
       prov.provincia                as 'Provincia'
FROM Paciente p
         LEFT JOIN Direccion d ON p.idDireccion = d.ID_direccion
         LEFT JOIN Distrito dis ON d.idDistrito = dis.ID_distrito
         LEFT JOIN Provincia prov ON dis.idProvincia = prov.ID_provincia
         LEFT JOIN Paciente_Dosis ON p.cedula = Paciente_Dosis.cedulaPac
         LEFT JOIN Dosis ON Dosis.ID_dosis = Paciente_Dosis.idDosis
GO
CREATE VIEW [Vista Admin] AS
SELECT p.cedula                      as 'C�dula paciente',
       p.nombre_paciente             as 'Nombre paciente',
       p.apellido_paciente           as 'Apellido paciente',
       p.fecha_nacimiento            as 'Fecha de nacimiento paciente',
       p.edad_calculada              as 'Edad calculada',
       p.sexo                        as 'Sexo',
       p.telefono_paciente           as 'Tel�fono paciente',
       p.correo_electronico_paciente as 'Correo electr�nico paciente',
       d.direccion                   as 'Direcci�n residencial actual paciente',
       dis.distrito                  as 'Distrito paciente',
       prov.provincia                as 'Provincia paciente',
       s.nombre_sede                 as 'Sede vacunado',
       d2.direccion                  as 'Direcci�n sede',
       dis2.distrito                 as 'Distrito sede',
       prov2.provincia               as 'Provincia sede',
       s.telefono_sede               as 'Tel�fono sede',
       s.region                      as 'Regi�n de salud sede',
       s.dependencia_sede            as 'Depedencia sede',
       vac.nombre_vacuna             as 'Nombre vacuna',
       dos.fecha_aplicacion          as 'Fecha de aplicaci�n',
       dos.numero_dosis              as 'N�mero de dosis aplicada',
       vac.intervalo_dosis_1_2_meses as 'Intervalo dosis recomendado en meses',
       DATEDIFF(DAY, dos.fecha_aplicacion,
                (SELECT MAX(dos2.fecha_aplicacion)
                 FROM Dosis dos2
                          JOIN Paciente_Dosis pd2 ON dos2.ID_dosis = pd2.idDosis
                 WHERE pd2.cedulaPac = p.cedula
                   AND dos2.idVacuna = dos.idVacuna
                   AND dos2.numero_dosis > dos.numero_dosis))
                                     AS 'Intervalo real en d�as',
       vac.edad_minima               as 'Edad m�nima recomendada en meses',
       e.nombre_enfermedad           as 'Enfermedad prevenida',
       e.nivel_gravedad              as 'Nivel de gravedad enfermedad'
FROM Paciente p
         LEFT JOIN Direccion d ON p.idDireccion = d.ID_direccion
         LEFT JOIN Distrito dis ON d.idDistrito = dis.ID_distrito
         LEFT JOIN Provincia prov ON dis.idProvincia = prov.ID_provincia
         LEFT JOIN Paciente_Dosis pd ON p.cedula = pd.cedulaPac
         LEFT JOIN Dosis dos ON pd.idDosis = dos.ID_dosis
         LEFT JOIN Vacuna vac ON dos.idVacuna = vac.ID_vacuna
         LEFT JOIN Vacuna_Enfermedad ve ON vac.ID_vacuna = ve.ID_vacuna
         LEFT JOIN Enfermedad e ON ve.ID_enfermedad = e.ID_enfermedad
         LEFT JOIN Sede s ON dos.idSede = s.ID_sede
         LEFT JOIN Direccion d2 ON s.idDireccion = d2.ID_direccion
         LEFT JOIN Distrito dis2 ON d2.idDistrito = dis2.ID_distrito
         LEFT JOIN Provincia prov2 ON dis2.idProvincia = prov2.ID_provincia
GO
CREATE VIEW [Vista Fabricante] AS
SELECT p.nombre_fabricante         as 'Nombre fabricante',
       v.nombre_vacuna             as 'Vacuna ofrecida',
       v.edad_minima               as 'Edad m�nima recomendada',
       v.intervalo_dosis_1_2_meses as 'Intervalo recomendado dosis 1 y 2 en meses',
       e.nombre_enfermedad         as 'Enfermedad que previene',
       e.nivel_gravedad            as 'Nivel de gravedad enfermedad'
FROM Fabricante p
         JOIN Fabricante_Vacuna pv ON pv.ID_fabricante = p.ID_fabricante
         JOIN Vacuna v ON pv.ID_vacuna = v.ID_vacuna
         LEFT JOIN Vacuna_Enfermedad ve ON v.ID_vacuna = ve.ID_vacuna
         LEFT JOIN Enfermedad e ON ve.ID_enfermedad = e.ID_enfermedad;
GO
CREATE VIEW [Reporte Vacunas Completo] AS
SELECT P.cedula                      AS CedulaPaciente,
       P.nombre_paciente             AS NombrePaciente,
       P.apellido_paciente           AS ApellidoPaciente,
       P.fecha_nacimiento            AS FechaNacimiento,
       P.sexo                        AS Sexo,
       P.telefono_paciente           AS TelefonoPaciente,
       P.correo_electronico_paciente AS CorreoElectronicoPaciente,
       V.nombre_vacuna               AS NombreVacuna,
       D.fecha_aplicacion            AS FechaAplicacion,
       D.numero_dosis                AS NumeroDosis,
       V.intervalo_dosis_1_2_meses   as 'Intervalo dosis recomendado en meses',
       DATEDIFF(DAY, D.fecha_aplicacion,
                (SELECT MAX(dos2.fecha_aplicacion)
                 FROM Dosis dos2
                          JOIN Paciente_Dosis pd2 ON dos2.ID_dosis = pd2.idDosis
                 WHERE pd2.cedulaPac = p.cedula
                   AND dos2.idVacuna = D.idVacuna
                   AND dos2.numero_dosis > D.numero_dosis))
                                     AS 'Intervalo real en d�as',
       V.edad_minima                 as 'Edad m�nima recomendada en meses',
       S.ID_sede                     AS IDSede,
       S.nombre_sede                 AS NombreSede,
       DIR.direccion                 AS DireccionSede,
       DIS.distrito                  AS Distrito,
       PROV.provincia                AS Provincia
FROM Paciente P
         JOIN Paciente_Dosis PD ON P.cedula = PD.cedulaPac
         JOIN Dosis D ON PD.idDosis = D.ID_dosis
         JOIN Vacuna V ON D.idVacuna = V.ID_vacuna
         JOIN Sede S ON D.idSede = S.ID_sede
         LEFT JOIN Direccion DIR ON S.idDireccion = DIR.ID_direccion
         LEFT JOIN Distrito DIS ON DIR.idDistrito = DIS.ID_distrito
         LEFT JOIN Provincia PROV ON DIS.idProvincia = PROV.ID_provincia;
GO
/* ejemplo de uso
SELECT 
    Provincia, 
    COUNT(*) AS TotalVacunas 
FROM 
    [Reporte Vacunas Completo]
GROUP BY 
    Provincia;
*/
CREATE VIEW [Enfermedad - Sintomas] AS
SELECT v.nombre_vacuna     AS 'Vacuna',
       e.nombre_enfermedad AS 'Enfermedad prevenida',
       e.nivel_gravedad    AS 'Nivel de gravedad enfermedad',
       s.nombre_sintoma    AS 'S�ntomas enfermedad'
FROM Vacuna_Enfermedad ve
         LEFT JOIN Vacuna v ON ve.ID_vacuna = v.ID_vacuna
         LEFT JOIN Enfermedad e ON ve.ID_enfermedad = e.ID_enfermedad
         LEFT JOIN Enfermedad_Sintoma es ON e.ID_enfermedad = es.ID_enfermedad
         LEFT JOIN Sintomas s ON es.ID_sintoma = s.ID_sintoma;
GO
CREATE VIEW [Sede - Inventario] AS
SELECT s.ID_sede,
       s.nombre_sede      AS 'Nombre sede',
       s.dependencia_sede AS 'Depedencia sede',
       v.nombre_vacuna    AS 'Vacuna',
       si.Cantidad,
       si.Lote_Sede       AS 'Lote',
       si.Fecha_lote_sede AS 'Fecha Lote'
FROM Sede_Inventario si
         INNER JOIN Sede s ON si.ID_sede = s.ID_sede
         INNER JOIN Vacuna v ON si.ID_vacuna = v.ID_vacuna
GO
/* ejemplo de uso 
SELECT Vacuna, Cantidad, Lote, [Fecha Lote]  FROM [Sede - Inventario]
WHERE ID_Sede = 1
*/
-- Crear LOGINS
CREATE LOGIN Pacientes
    WITH PASSWORD = 'pac2024MINSA17Bd2',
    DEFAULT_DATABASE = [MINSA]
GO
CREATE LOGIN Doctores
    WITH PASSWORD = 'doc2024MINSA17Bd2',
    DEFAULT_DATABASE = [MINSA]
GO
CREATE LOGIN Fabricantes
    WITH PASSWORD = 'fabr2024MINSA17Bd2',
    DEFAULT_DATABASE = [MINSA]
GO
CREATE LOGIN Administradores
    WITH PASSWORD = 'admin2024MINSA2.0Bd2',
    DEFAULT_DATABASE = [MINSA]
GO
CREATE LOGIN Administrativos
    WITH PASSWORD = 'ofic2024MINSA17Bd2.0',
    DEFAULT_DATABASE = [MINSA]
GO

-- crear usuarios de la base de datos
/* TODO USUARIOS: FALTAN LOS PERMISOS PARA LA LLAMADA DE LOS PROCEDIMIENTOS (SP)   Y FUNCIONES */
CREATE USER Administrador FOR LOGIN Administradores
--Administrador
ALTER ROLE db_owner ADD MEMBER Administrador;
GO
CREATE USER Fabricante FOR LOGIN Fabricantes
--Fabricante
GRANT SELECT ON [Vista Fabricante] TO Fabricante
GRANT SELECT ON Fabricante TO Fabricante
GRANT SELECT ON Fabricante_Vacuna TO Fabricante
GRANT SELECT ON Almacen TO Fabricante
GRANT SELECT ON Almacen_Inventario TO Fabricante
GRANT SELECT ON [Sede - Inventario] TO Fabricante
-- permitido insertar sus vacunas
GRANT INSERT ON Fabricante_Vacuna TO Fabricante
GO
CREATE USER Doctor FOR LOGIN Doctores
--Doc
GRANT SELECT ON [Vista Doctor] TO Doctor
GRANT SELECT ON Paciente TO Doctor
GRANT SELECT ON Dosis TO Doctor
GRANT SELECT ON Paciente_Dosis TO Doctor
GRANT SELECT ON Vacuna TO Doctor
GRANT SELECT ON [Vista Paciente] TO Doctor
GRANT SELECT ON Sede_Inventario TO Doctor
GRANT SELECT ON [Sede - Inventario] TO Doctor
GRANT SELECT ON [Reporte Vacunas Completo] TO Doctor
-- permitido para los doctores o enfermeras insertar
GRANT INSERT ON Paciente TO Doctor
GRANT INSERT ON Dosis TO Doctor
GRANT INSERT ON Paciente_Dosis TO Doctor
-- permitido actualizar 
GRANT UPDATE ON Dosis TO Doctor
GRANT UPDATE ON Paciente TO Doctor
GRANT UPDATE ON Paciente_Dosis TO Doctor
-- permitido utilizar procedimientos
GRANT EXECUTE ON ActualizarEdadPacientes TO Doctor
GRANT EXECUTE ON ManipularPaciente TO Doctor
GRANT EXECUTE ON CrearDosis TO Doctor
GO
CREATE USER Paciente FOR LOGIN Pacientes
--Paciente
GRANT SELECT ON Paciente TO Paciente
GRANT SELECT ON [Vista Paciente] TO Paciente
GRANT SELECT ON [Enfermedad - Sintomas] TO Paciente
GRANT SELECT ON Paciente_Dosis TO Paciente
-- permitido utilizar procedimientos
GRANT EXECUTE ON ActualizarEdadPacientes TO Paciente
GO
CREATE USER Oficinista FOR LOGIN Administrativos --Oficinista
GRANT SELECT ON [Vista Administrativo] TO Oficinista
GRANT SELECT ON Sede TO Oficinista
GRANT SELECT ON Sede_Inventario TO Oficinista
GRANT SELECT ON [Sede - Inventario] TO Oficinista
-- permitido insertar a los oficinistas
GRANT INSERT ON Sede_Inventario TO Oficinista
GRANT INSERT ON Paciente TO Oficinista
-- permitido actualizar 
GRANT UPDATE ON Sede_Inventario TO Oficinista
GRANT UPDATE ON Paciente TO Oficinista
GRANT UPDATE ON Sede TO Oficinista
-- permitido utilizar procedimientos
GRANT EXECUTE ON ActualizarEdadPacientes TO Oficinista
GRANT EXECUTE ON ManipularPaciente TO Oficinista
GRANT EXECUTE ON CrearUsuario TO Oficinista
GO

-- Insertar valores iniciales de prueba. Las direcciones se insertan a medida que se requieren
INSERT INTO Provincia(provincia)
VALUES ('Provincia por registrar' /*0*/),
       ('Bocas del Toro'), /*1*/
       ('Cocl�'), /*2*/
       ('Col�n'), /*3*/
       ('Chiriqu�'), /*4*/
       ('Dari�n'), /*5*/
       ('Herrera'), /*6*/
       ('Los Santos'), /*7*/
       ('Panam�'), /*8*/
       ('Veraguas'), /*9*/
       ('Guna Yala'), /*10*/
       ('Ember�-Wounaan'), /*11*/
       ('Ng�be-Bugl�'),/*12*/
       ('Panam� Oeste'), /*13*/
       ('Naso Tj�r Di'), /*14*/
       ('Guna de Madugand�'), /*15*/
       ('Guna de Wargand�'); /*16*/
GO
INSERT INTO Distrito (distrito, idProvincia)
VALUES ('Distrito por registrar', 0),
       ('Aguadulce', 2),
       ('Alanje', 4),
       ('Almirante', 1),
       ('Ant�n', 2),
       ('Arraij�n', 13),
       ('Atalaya', 9),
       ('Balboa', 8),
       ('Bar�', 4),
       ('Besik�', 12),
       ('Bocas del Toro', 1),
       ('Boquer�n', 4),
       ('Boquete', 4),
       ('Bugaba', 4),
       ('Calobre', 9),
       ('Calov�bora', 12),
       ('Ca�azas', 9),
       ('Capira', 13),
       ('Chagres', 3),
       ('Chame', 13),
       ('Changuinola', 1),
       ('Chepigana', 5),
       ('Chepo', 8),
       ('Chim�n', 8),
       ('Chiriqu� Grande', 1),
       ('Chitr�', 6),
       ('Col�n', 3),
       ('C�maco', 11),
       ('David', 4),
       ('Donoso', 3),
       ('Dolega', 4),
       ('Gualaca', 4),
       ('Guarar�', 7),
       ('Guna de Wargand�', 5),
       ('Jirondai', 12),
       ('Kankint�', 12),
       ('Kusap�n', 12),
       ('La Chorrera', 13),
       ('La Mesa', 9),
       ('La Pintada', 2),
       ('Las Minas', 6),
       ('Las Palmas', 9),
       ('Las Tablas', 7),
       ('Los Pozos', 6),
       ('Los Santos', 7),
       ('Macaracas', 7),
       ('Mariato', 9),
       ('Miron�', 12),
       ('Montijo', 9),
       ('M�na', 12),
       ('Nat�', 2),
       ('Nole Duima', 12),
       ('��r�m', 12),
       ('Oc�', 6),
       ('Ol�', 2),
       ('Omar Torrijos Herrera', 3),
       ('Panam�', 8),
       ('Parita', 6),
       ('Pedas�', 7),
       ('Penonom�', 2),
       ('Pes�', 6),
       ('Pinogana', 5),
       ('Pocr�', 7),
       ('Portobelo', 3),
       ('Remedios', 4),
       ('Renacimiento', 4),
       ('R�o de Jes�s', 9),
       ('Samb�', 11),
       ('San Carlos', 13),
       ('San F�lix', 4),
       ('San Francisco', 9),
       ('San Lorenzo', 4),
       ('San Miguelito', 8),
       ('Santa Catalina', 12),
       ('Santa Fe', 5),
       ('Santa Fe', 9),
       ('Santa Isabel', 3),
       ('Santa Mar�a', 6),
       ('Santiago', 9),
       ('Son�', 9),
       ('Taboga', 8),
       ('Tierras Altas', 4),
       ('Tol�', 4),
       ('Tonos�', 7),
       ('Naso Tj�r Di', 14)
GO
INSERT INTO Direccion (direccion, idDistrito)
VALUES ('Direcci�n por registrar', 0);
GO
-- insertar los pacientes con el procedimiento creado
EXEC dbo.ManipularPaciente '8-1006-14', 'Jorge', 'Ruiz', '1999-05-31', 'M', '507 6068-4595', NULL,
     'Samaria, sector 4, casa E1', 'San Miguelito';
GO
EXEC dbo.ManipularPaciente '1-54-9635', 'Luis', 'Mendoza', '2006-05-05', 'M', '507 6325-7865', NULL,
     'Finca 30, casa 45', 'Changuinola';
GO
EXEC dbo.ManipularPaciente '2-4558-5479', 'Jos�', 'Perez', '1959-12-13', 'M', '507 6265-4789', NULL,
     'V�a Interamericana, casa L78', 'Nat�';
GO
EXEC dbo.ManipularPaciente '5-554-321', 'Martha', 'Cornejo', '1979-08-24', 'F', '507 6784-1296', NULL,
     'V�a Interamericana, Metet�, casa 87F', 'Pinogana';
GO
EXEC dbo.ManipularPaciente '8-9754-1236', 'Suleimi', 'Rodriguez', '2001-02-17', 'F', '507 6785-9631', NULL,
     'Calle 51, casa 74', 'Panam�';
GO
-- insertar sede con procedimiento
EXEC dbo.InsertarSede 'Sede por registrar', 'Por registrar', NULL, NULL, NULL, NULL;
GO
EXEC dbo.InsertarSede 'Hospital San Miguel Arcangel', 'MINSA', NULL, '507 523-6906', 'HISMA, V�a Ricardo J. Alfaro',
     'San Miguelito';
GO
EXEC dbo.InsertarSede 'MINSA CAPSI FINCA 30 CHANGINOLA', 'MINSA', NULL, '507 758-8096', 'Finca 32', 'Changuinola';
GO
EXEC dbo.InsertarSede 'Hospital Aquilino Tejeira', 'CSS', NULL, '507 997-9386', 'Calle Manuel H Robles', 'Penonom�';
GO
EXEC dbo.InsertarSede 'CENTRO DE SALUD METETI', 'MINSA', NULL, '507 299-6151', 'La Palma', 'Pinogana';
GO
EXEC dbo.InsertarSede 'POLICENTRO DE SALUD de Chepo', 'MINSA', NULL, '507 296-7220', 'Via Panamericana Las Margaritas',
     'Chepo';
GO
EXEC dbo.InsertarSede 'Cl�nica Hospital San Fernando', 'Privada', NULL, '507 305-6300',
     'Via Espa�a, Hospital San Fernando', 'Panam�';
GO
EXEC dbo.InsertarSede 'Complejo Hospitalario Doctor Arnulfo Arias Madrid', 'CSS', NULL, '507 503-6032',
     'Avenida Jos� de F�brega, Complejo Hospitalario', 'Panam�';
GO
EXEC dbo.InsertarSede 'Hospital Santo Tom�s', 'MINSA', NULL, '507 507-5830', 'Avenida Balboa y Calle 37 Este', 'Panam�';
GO
EXEC dbo.InsertarSede 'Hospital Regional de Changuinola Raul D�vila Mena', 'MINSA', NULL, '507 758-8295',
     'Changuinola, Bocas del Toro', 'Changuinola';
GO
EXEC dbo.InsertarSede 'Hospital Dr. Rafael Hern�ndez', 'MINSA', NULL, '507 774-8400', 'David, Chiriqu�', 'David';
GO
EXEC dbo.InsertarSede 'Hospital Punta Pac�fica Pac�fica Salud', 'Privada', NULL, '507 204-8000',
     'Punta Pac�fica, Ciudad de Panam�', 'Panam�';
GO
EXEC dbo.InsertarSede 'Hospital Nacional', 'Privada', NULL, '507 307-2102', 'Av. Cuba, Ciudad de Panam�', 'Panam�';
GO
EXEC dbo.InsertarSede 'Centro de salud Pacora', 'MINSA', NULL, '507 296-0005', 'Pacora, Ciudad de Panam�', 'Panam�';
GO
EXEC dbo.InsertarSede 'Hospital Dr. Nicol�s A. Solano', 'MINSA', NULL, '507 254-8926', 'La Chorrera, Panam� Oeste',
     'La Chorrera';
GO
EXEC dbo.InsertarSede 'C�mplejo Hospitalario Dr. Manuel Amador Guerrero', 'CSS', NULL, '507 475-2207', 'Col�n, Col�n',
     'Col�n';
GO
EXEC dbo.InsertarSede 'Policl�nica Lic. Manuel Mar�a Vald�s', 'CSS', NULL, '507 503-1500',
     'San Miguelito, Ciudad de Panam�', 'Panam�';
GO
EXEC dbo.InsertarSede 'CSS Complejo Metropolitano', 'CSS', NULL, '507 506-4000', 'V�a Espa�a, Ciudad de Panam�',
     'Panam�';
GO
EXEC dbo.InsertarSede 'Hospital de Especialidades Pedi�tricas Omar Torrijos Herrena', 'CSS', NULL, '507 513-7008',
     'V�a Espa�a, Ciudad de Panam�', 'Panam�';
GO
INSERT INTO Vacuna (nombre_vacuna, edad_minima, intervalo_dosis_1_2_meses)
VALUES ('Vacuna por registrar', NULL, NULL),
       ('Adacel', 132, NULL),
       ('BCG', 0, NULL),
       ('COVID-19', 6, 0.92),
       ('Fiebre Amarilla', NULL, NULL),
       ('Hep A (Euvax) (adultos)', 240, 6),
       ('Hep A (Euvax) (infantil)', 12, NULL),
       ('Hep B (adultos)', 240, 6),
       ('Hep B (infantil)', 0, 1),
       ('Hexaxim', 2, NULL),
       ('Influenza (FluQuadri)', 6, 12),
       ('Meningococo', 132, 48),
       ('MMR', 12, NULL),
       ('MR (antisarampi�n, antirrub�ola)', 12, 72),
       ('Neumoco conjugado (Prevenar 13 valente)', 2, NULL),
       ('Papiloma Humano (Gardasil)', 132, NULL),
       ('Pneumo23', 780, NULL),
       ('Pneumovax', 780, NULL),
       ('Priorix', 9, 3),
       ('Rotarix', 2, NULL),
       ('TD', 48, 120),
       ('Tetravalente', NULL, NULL), -- No se especifica la edad m�nima y el intervalo es seg�n el calendario infantil
       ('Varivax', 12, 69),
       ('Verorab', NULL, NULL); -- Seg�n el esquema de post-exposici�n
GO
-- insertar Fabricantes 
INSERT INTO Fabricante (nombre_fabricante, telefono_fabricante, correo_electronico_fabricante, direccion_fabricante,
                        contacto_fabricante)
VALUES -- algunos datos no son veraces 
       ('Sanofi Pasteur', '1-800-822-2463', 'info@sanofipasteur.com',
        'Sanofi Pasteur Inc., 1 Discovery Drive, Swiftwater, PA 18370, USA', 'John Doe'),
       ('Pfizer', '1-212-733-2323', 'support@pfizer.com', 'Pfizer Inc., 235 East 42nd Street, New York, NY 10017, USA',
        'Alice Johnson'),
       ('GlaxoSmithKline', '44-20-8047-5000', 'info@gsk.com',
        'GSK plc, 980 Great West Road, Brentford, Middlesex, TW8 9GS, UK', 'Bob Brown'),
       ('Merck', '1-908-740-4000', 'contact@merck.com',
        'Merck & Co., Inc., 2000 Galloping Hill Road, Kenilworth, NJ 07033, USA', 'Jane Smith'),
       ('Serum Institute', '91-20-26993900', 'contact@seruminstitute.com',
        '212/2, Hadapsar, Off Soli Poonawalla Road, Pune 411028, Maharashtra, India', 'Mr. Muralidharan Poduval');
GO
INSERT INTO Fabricante_Vacuna (ID_fabricante, ID_vacuna)
VALUES (1, 1),  -- Adacel - Sanofi Pasteur
       (1, 2),  -- BCG - Sanofi Pasteur
       (2, 3),  -- COVID-19 - Pfizer
       (1, 4),  -- Fiebre Amarilla - Sanofi Pasteur
       (3, 5),  -- Hep A (Euvax) (adultos) - GlaxoSmithKline
       (3, 6),  -- Hep A (Euvax) (infantil) - GlaxoSmithKline
       (4, 7),  -- Hep B (adultos) - Merck
       (4, 8),  -- Hep B (infantil) - Merck
       (1, 9),  -- Hexaxim - Sanofi Pasteur
       (1, 10), -- Influenza (FluQuadri) - Sanofi Pasteur
       (3, 11), -- Meningococo - GlaxoSmithKline
       (4, 12), -- MMR - Merck
       (5, 13), -- MR (antisarampi�n, antirrub�ola) - Serum Institute
       (2, 14), -- Neumoco conjugado (Prevenar 13 valente) - Pfizer
       (4, 15), -- Papiloma Humano (Gardasil) - Merck
       (4, 16), -- Pneumo23 - Merck
       (4, 17), -- Pneumovax - Merck
       (3, 18), -- Priorix - GlaxoSmithKline
       (3, 19), -- Rotarix - GlaxoSmithKline
       (1, 20), -- TD - Sanofi Pasteur
       (4, 21), -- Tetravalente - Merck
       (4, 22), -- Varivax - Merck
       (1, 23); -- Verorab - Sanofi Pasteur
GO
INSERT INTO Almacen (nombre_almacen, encargado, telefono_almacen, dependencia_almacen)
VALUES ('Almacen Vac�nate Panam�', 'Carlos Gonzalez', '507 275-9689', 'MINSA') -- ficticios
GO
INSERT INTO Almacen_Inventario (ID_almacen, ID_vacuna, Cantidad, Fecha_lote_almacen, Lote_almacen)
VALUES (1, 1, 160, '2024-07-15', 'LoteA1'),
       (1, 2, 215, '2024-07-16', 'LoteA2'),
       (1, 3, 140, '2024-07-17', 'LoteA3'),
       (1, 4, 325, '2024-07-18', 'LoteA4'),
       (1, 5, 280, '2024-07-19', 'LoteA5'),
       (1, 6, 215, '2024-07-20', 'LoteA6'),
       (1, 7, 260, '2024-07-21', 'LoteA7'),
       (1, 8, 235, '2024-07-22', 'LoteA8'),
       (1, 9, 190, '2024-07-23', 'LoteA9'),
       (1, 10, 185, '2024-07-24', 'LoteA10'),
       (1, 11, 170, '2024-07-25', 'LoteA11'),
       (1, 12, 235, '2024-07-26', 'LoteA12'),
       (1, 13, 230, '2024-07-27', 'LoteA13'),
       (1, 14, 165, '2024-07-28', 'LoteA14'),
       (1, 15, 160, '2024-07-29', 'LoteA15'),
       (1, 16, 155, '2024-07-30', 'LoteA16'),
       (1, 17, 150, '2024-07-31', 'LoteA17'),
       (1, 18, 145, '2024-08-01', 'LoteA18'),
       (1, 19, 140, '2024-08-02', 'LoteA19'),
       (1, 20, 135, '2024-08-03', 'LoteA20'),
       (1, 21, 130, '2024-08-04', 'LoteA21'),
       (1, 22, 125, '2024-08-05', 'LoteA22'),
       (1, 23, 125, '2024-08-06', 'LoteA23');
GO
-- hacer el movimiento de distribuci�n entre almacen y sedes
EXEC dbo.DistribuirVacunas 1, 1, 1, 10, 'LoteA1';
GO
EXEC dbo.DistribuirVacunas 1, 2, 2, 15, 'LoteA2';
GO
EXEC dbo.DistribuirVacunas 1, 3, 3, 20, 'LoteA3';
GO
EXEC dbo.DistribuirVacunas 1, 4, 4, 25, 'LoteA4';
GO
EXEC dbo.DistribuirVacunas 1, 5, 5, 30, 'LoteA5';
GO
EXEC dbo.DistribuirVacunas 1, 6, 6, 35, 'LoteA6';
GO
EXEC dbo.DistribuirVacunas 1, 7, 7, 40, 'LoteA7';
GO
EXEC dbo.DistribuirVacunas 1, 8, 8, 45, 'LoteA8';
GO
EXEC dbo.DistribuirVacunas 1, 9, 9, 50, 'LoteA9';
GO
EXEC dbo.DistribuirVacunas 1, 10, 10, 55, 'LoteA10';
GO
EXEC dbo.DistribuirVacunas 1, 11, 11, 60, 'LoteA11';
GO
EXEC dbo.DistribuirVacunas 1, 12, 12, 65, 'LoteA12';
GO
EXEC dbo.DistribuirVacunas 1, 13, 13, 70, 'LoteA13';
GO
EXEC dbo.DistribuirVacunas 1, 14, 14, 75, 'LoteA14';
GO
EXEC dbo.DistribuirVacunas 1, 15, 15, 80, 'LoteA15';
GO
EXEC dbo.DistribuirVacunas 1, 16, 16, 85, 'LoteA16';
GO
EXEC dbo.DistribuirVacunas 1, 17, 17, 90, 'LoteA17';
GO
EXEC dbo.DistribuirVacunas 1, 18, 18, 95, 'LoteA18';
GO
EXEC dbo.DistribuirVacunas 1, 1, 19, 100, 'LoteA19';
GO
EXEC dbo.DistribuirVacunas 1, 2, 20, 105, 'LoteA20';
GO
EXEC dbo.DistribuirVacunas 1, 3, 21, 110, 'LoteA21';
GO
EXEC dbo.DistribuirVacunas 1, 4, 22, 115, 'LoteA22';
GO
EXEC dbo.DistribuirVacunas 1, 5, 23, 120, 'LoteA23';
GO
-- crear las dosis y relacionar con su paciente
EXEC dbo.InsertarDosis '1-54-9635', '2023-04-03 07:00', '1', 2, 2, 'LoteA2'; -- BCG en MINSA CAPSI FINCA 30 CHANGINOLA
GO
EXEC dbo.InsertarDosis '1-54-9635', '2024-07-04 10:00:00', '2', 2, 2,
     'LoteA2'; -- BCG en MINSA CAPSI FINCA 30 CHANGINOLA
GO
EXEC dbo.InsertarDosis '2-4558-5479', '2024-01-03 08:35', '1', 7, 7,
     'LoteA7'; -- Hep B en Complejo Hospitalario Doctor Arnulfo Arias Madrid
GO
EXEC dbo.InsertarDosis '5-554-321', '2023-12-03 18:45', '1', 14, 14, 'LoteA14'; -- Neumococo en Hospital Punta Pac�fica
GO
EXEC dbo.InsertarDosis '8-1006-14', '2023-11-03 09:30', '1', 12, 12, 'LoteA12'; -- MMR en CSS Bella Vista
GO
EXEC dbo.InsertarDosis '8-9754-1236', '2022-10-03 16:00', '1', 18, 18,
     'LoteA18'; -- Priorix en Hospital Manuel Amador Guerrero
GO
EXEC dbo.InsertarDosis '8-9754-1236', '2023-11-30 07:00', '2', 18, 18,
     'LoteA18'; -- Priorix en Hospital Manuel Amador Guerrero
GO
INSERT INTO Enfermedad (nombre_enfermedad, nivel_gravedad)
VALUES ('Desconocida', NULL),
       ('Bacteriemia', 'Alta'),
       ('COVID-19', 'Alta'),
       ('Difteria', 'Alta'),
       ('Enfermedad menigoc�cica', 'Alta'),
       ('Enfermedades neumoc�cicas', 'Alta'),
       ('Fiebre Amarilla', 'Alta'),
       ('Hepatitis A', 'Moderada'),
       ('Hepatitis B', 'Moderada'),
       ('Hib (Haemophilus influenzae tipo b)', 'Alta'),
       ('Influenza (Gripe)', 'Moderada'),
       ('Meningitis', 'Alta'),
       ('Neumon�a', 'Moderada'),
       ('Paperas', 'Moderada'),
       ('Poliomelitis (Polio)', 'Alta'),
       ('Rabia', 'Alta'),
       ('Rotavirus', 'Moderada'),
       ('Rub�ola', 'Moderada'),
       ('Sarampi�n', 'Alta'),
       ('T�tanos', 'Alta'),
       ('Tos ferina', 'Alta'),
       ('Tuberculosis', 'Alta'),
       ('Varicela', 'Moderada'),
       ('Virus del papiloma humano (VPH)', 'Moderada');
GO
INSERT INTO Sintomas (nombre_sintoma)
VALUES ('Desconocido'),
       ('Ataques de tos'),
       ('C�ncer de cuello uterino'),
       ('Confusi�n'),
       ('Conjuntivitis'),
       ('Convulsiones'),
       ('Diarrea grave'),
       ('Dificultad para respirar'),
       ('Dolor abdominal'),
       ('Dolor de cabeza'),
       ('Dolor de garganta'),
       ('Dolor e hinchaz�n en las gl�ndulas salivales'),
       ('Dolor en el pecho'),
       ('Dolor muscular'),
       ('Erupci�n cut�nea caracter�stica'),
       ('Escalofr�os'),
       ('Espasmos'),
       ('Fatiga'),
       ('Fiebre'),
       ('Formaci�n de una membrana gruesa en la garganta'),
       ('Ganglios inflamados'),
       ('Ictericia'),
       ('Infecci�n de la sangre'),
       ('Meningitis'),
       ('N�useas'),
       ('Neumon�a'),
       ('Orina oscura'),
       ('Otros tipos de c�ncer'),
       ('Par�lisis'),
       ('P�rdida de peso'),
       ('P�rdida del gusto o olfato'),
       ('Picaz�n'),
       ('Poco apetito'),
       ('Rigidez en el cuello'),
       ('Rigidez muscular'),
       ('Secreci�n nasal'),
       ('Sensibilidad a la luz'),
       ('Sepsis'),
       ('Sudores nocturnos'),
       ('Tos intensa y persistente'),
       ('Tos persistente'),
       ('Tos');
GO
INSERT INTO Enfermedad_Sintoma (ID_enfermedad, ID_sintoma)
VALUES
-- Enfermedad desconocida
(0, 0),   -- S�ntomas desconocido
-- usado para registrar posteriormente la vacuna - enfermedad donde una vacuna por registrar tendr� su enfermedad desconocida y s�ntomas desconocidos 

-- Bacteriemia
(1, 18),  -- Fiebre
(1, 16),  -- Escalofr�os
(1, 35),  -- Sepsis

-- COVID-19
(2, 18),  -- Fiebre
(2, 40),  -- Tos persistente
(2, 7),   -- Dificultad para respirar
(2, 16),  -- Fatiga
(2, 29),  -- P�rdida del gusto o olfato
(2, 13),  -- Dolor muscular
(2, 9),   -- Dolor de cabeza

-- Difteria
(3, 18),  -- Fiebre
(3, 10),  -- Dolor de garganta
(3, 19),  -- Formaci�n de una membrana gruesa en la garganta
(3, 7),   -- Dificultad para tragar
(3, 20),  -- Ganglios inflamados

-- Enfermedad meningoc�cica
(4, 18),  -- Fiebre
(4, 9),   -- Dolor de cabeza
(4, 31),  -- Rigidez en el cuello
(4, 3),   -- Confusi�n
(4, 32),  -- Sensibilidad a la luz
(4, 4),   -- Convulsiones

-- Enfermedades neumoc�cicas
(5, 18),  -- Fiebre
(5, 9),   -- Dolor de cabeza
(5, 31),  -- Rigidez en el cuello
(5, 3),   -- Confusi�n
(5, 32),  -- Sensibilidad a la luz
(5, 35),  -- Sepsis

-- Fiebre Amarilla
(6, 18),  -- Fiebre
(6, 21),  -- Ictericia
(6, 13),  -- Dolor muscular
(6, 22),  -- N�useas
(6, 23),  -- V�mito
(6, 16),  -- Fatiga

-- Hepatitis A
(7, 18),  -- Fiebre
(7, 16),  -- Fatiga
(7, 7),   -- Dolor abdominal
(7, 24),  -- Orina oscura
(7, 21),  -- Ictericia
(7, 22),  -- N�useas
(7, 23),  -- V�mito
(7, 31),  -- Poco apetito

-- Hepatitis B
(8, 18),  -- Fiebre
(8, 16),  -- Fatiga
(8, 7),   -- Dolor abdominal
(8, 24),  -- Orina oscura
(8, 21),  -- Ictericia
(8, 22),  -- N�useas
(8, 23),  -- V�mito
(8, 31),  -- Poco apetito

-- Hib (Haemophilus influenzae tipo b)
(9, 18),  -- Fiebre
(9, 25),  -- Meningitis
(9, 26),  -- Neumon�a
(9, 27),  -- Infecci�n de la sangre

-- Influenza (Gripe)
(10, 18), -- Fiebre
(10, 16), -- Fatiga
(10, 13), -- Dolor muscular
(10, 9),  -- Dolor de cabeza
(10, 41), -- Tos

-- Meningitis
(11, 18), -- Fiebre
(11, 9),  -- Dolor de cabeza
(11, 31), -- Rigidez en el cuello
(11, 3),  -- Confusi�n
(11, 32), -- Sensibilidad a la luz
(11, 4),  -- Convulsiones

-- Neumon�a
(12, 18), -- Fiebre
(12, 7),  -- Dificultad para respirar
(12, 41), -- Tos
(12, 11), -- Dolor en el pecho

-- Paperas
(13, 18), -- Fiebre
(13, 11), -- Dolor e hinchaz�n en las gl�ndulas salivales
(13, 9),  -- Dolor de cabeza
(13, 16), -- Fatiga

-- Poliomelitis (Polio)
(14, 18), -- Fiebre
(14, 16), -- Fatiga
(14, 9),  -- Dolor de cabeza
(14, 31), -- Rigidez en el cuello
(14, 24), -- Par�lisis

-- Rabia
(15, 18), -- Fiebre
(15, 9),  -- Dolor de cabeza
(15, 15), -- Espasmos
(15, 3),  -- Confusi�n
(15, 24), -- Par�lisis

-- Rotavirus
(16, 6),  -- Diarrea grave
(16, 23), -- V�mito
(16, 18), -- Fiebre
(16, 7),  -- Dolor abdominal

-- Rub�ola
(17, 18), -- Fiebre
(17, 12), -- Erupci�n cut�nea caracter�stica
(17, 20), -- Ganglios inflamados

-- Sarampi�n
(18, 18), -- Fiebre
(18, 12), -- Erupci�n cut�nea caracter�stica
(18, 41), -- Tos
(18, 34), -- Secreci�n nasal
(18, 3),  -- Conjuntivitis

-- T�tanos
(19, 33), -- Rigidez muscular
(19, 15), -- Espasmos
(19, 9),  -- Dolor de cabeza
(19, 7),  -- Dificultad para tragar

-- Tos ferina
(20, 39), -- Tos intensa y persistente
(20, 1),  -- Ataques de tos
(20, 7),  -- Dificultad para respirar

-- Tuberculosis
(21, 18), -- Fiebre
(21, 16), -- Fatiga
(21, 40), -- Tos persistente
(21, 7),  -- Dificultad para respirar
(21, 28), -- P�rdida de peso
(21, 6),  -- Escalofr�os
(21, 36), -- Sudores nocturnos

-- Varicela
(22, 18), -- Fiebre
(22, 12), -- Erupci�n cut�nea caracter�stica
(22, 31), -- Picaz�n
(22, 16), -- Fatiga

-- Virus del papiloma humano (VPH)
(23, 37), -- Verrugas genitales
(23, 1),  -- C�ncer de cuello uterino
(23, 24); -- Otros tipos de c�ncer
GO
INSERT INTO Vacuna_Enfermedad (ID_vacuna, ID_enfermedad)
VALUES
-- Vacuna por registrar
(0, 0),   -- enfermedad desconocida y s�ntomas desconocidos

-- Adacel
(1, 3),   -- Difteria
(1, 19),  -- T�tanos
(1, 20),  -- Tos ferina

-- BCG
(2, 21),  -- Tuberculosis

-- COVID-19
(3, 2),   -- COVID-19

-- Fiebre Amarilla
(4, 6),   -- Fiebre Amarilla

-- Hep A (Euvax) (adultos)
(5, 7),   -- Hepatitis A

-- Hep A (Euvax) (infantil)
(6, 7),   -- Hepatitis A

-- Hep B (adultos)
(7, 8),   -- Hepatitis B

-- Hep B (infantil)
(8, 8),   -- Hepatitis B

-- Hexaxim
(9, 3),   -- Difteria
(9, 19),  -- T�tanos
(9, 20),  -- Tos ferina
(9, 8),   -- Hepatitis B
(9, 14),  -- Polio
(9, 9),   -- Hib (Haemophilus influenzae tipo b)

-- Influenza (FluQuadri)
(10, 10), -- Influenza (Gripe)

-- Meningococo
(11, 4),  -- Enfermedad meningoc�cica

-- MMR
(12, 18), -- Sarampi�n
(12, 13), -- Paperas
(12, 17), -- Rub�ola

-- MR (antisarampi�n, antirrub�ola)
(13, 18), -- Sarampi�n
(13, 17), -- Rub�ola

-- Neumoco conjugado (Prevenar 13 valente)
(14, 12), -- Neumon�a
(14, 11), -- Meningitis
(14, 1),  -- Bacteriemia

-- Papiloma Humano (Gardasil)
(15, 23), -- Virus del papiloma humano (VPH)

-- Pneumo23
(16, 5),  -- Enfermedades neumoc�cicas

-- Pneumovax
(17, 5),  -- Enfermedades neumoc�cicas

-- Priorix
(18, 18), -- Sarampi�n
(18, 17), -- Rub�ola
(18, 13), -- Paperas

-- Rotarix
(19, 16), -- Rotavirus

-- TD
(20, 19), -- T�tanos
(20, 3),  -- Difteria

-- Tetravalente
(21, 3),  -- Difteria
(21, 19), -- T�tanos
(21, 20), -- Tos ferina
(21, 14), -- Polio

-- Varivax
(22, 22), -- Varicela

-- Verorab
(23, 15); -- Rabia
GO
USE master;