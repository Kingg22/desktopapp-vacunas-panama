USE master;
IF DB_ID('vacunas') IS NOT NULL
    SET NOEXEC ON
CREATE DATABASE vacunas;
GO

USE vacunas;
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
PRINT (N'Creando el login');
GO
-- Únicamente las aplicaciones deben tener un login y su user con permisos
CREATE LOGIN ApplicationsVacunas
    WITH PASSWORD = '',
    DEFAULT_DATABASE = vacunas
GO
PRINT (N'Creando el user');
GO
-- crear usuario de la base de datos y darle permisos
CREATE USER SpringAPI FOR LOGIN ApplicationsVacunas
GO
PRINT (N'Otorgando permisos al user');
GO
EXEC sp_addrolemember 'db_datareader', 'SpringApi'
EXEC sp_addrolemember 'db_datawriter', 'SpringApi'
GRANT EXECUTE ON SCHEMA::dbo TO SpringAPI
-- dependiendo la aplicación se le puede asignar más o menos permisos**

PRINT (N'Creando tablas');
GO
-- tablas de manejo de usuarios
CREATE TABLE permisos
(
    id_permiso          SMALLINT PRIMARY KEY IDENTITY (1,1),
    nombre_permiso      NVARCHAR(100) NOT NULL,
    descripcion_permiso NVARCHAR(100),
    CONSTRAINT uq_permisos_nombre UNIQUE (nombre_permiso),
    INDEX ix_permisos_nombre (nombre_permiso)
);
GO
CREATE TABLE roles
(
    id_rol          SMALLINT PRIMARY KEY IDENTITY (1,1),
    nombre_rol      NVARCHAR(100) NOT NULL,
    descripcion_rol NVARCHAR(100),
    CONSTRAINT uq_roles_rol UNIQUE (nombre_rol),
    INDEX ix_roles_nombre (nombre_rol)
);
GO
CREATE TABLE usuarios
(
    id_usuario       UNIQUEIDENTIFIER PRIMARY KEY
        CONSTRAINT df_usuarios_id DEFAULT NEWID(),
    cedula           NVARCHAR(20)  NOT NULL,
    usuario          NVARCHAR(50),
    correo_usuario   NVARCHAR(254),
    clave_hash       NVARCHAR(60)  NOT NULL,
    fecha_nacimiento SMALLDATETIME NOT NULL,
    disabled         BIT           NOT NULL
        CONSTRAINT df_usuarios_disabled DEFAULT 0,
    created_at       DATETIME      NOT NULL
        CONSTRAINT df_usuarios_created DEFAULT CURRENT_TIMESTAMP,
    updated_at       DATETIME
        CONSTRAINT df_usuarios_updated DEFAULT CURRENT_TIMESTAMP,
    last_used        DATETIME,
    CONSTRAINT ck_usuarios_fecha_nacimiento CHECK (fecha_nacimiento <= GETDATE()),
    CONSTRAINT uq_usuarios_cedula UNIQUE (cedula),
    INDEX ix_usuarios_cedula (cedula)
);
GO
CREATE UNIQUE NONCLUSTERED INDEX ix_usuarios_username
    ON usuarios (usuario)
    WHERE usuario IS NOT NULL;
GO
CREATE UNIQUE NONCLUSTERED INDEX ix_usuarios_email
    ON usuarios (correo_usuario)
    WHERE correo_usuario IS NOT NULL;
GO
CREATE TABLE usuarios_roles
(
    id_usuario UNIQUEIDENTIFIER,
    id_rol     SMALLINT,
    PRIMARY KEY (id_usuario, id_rol),
    CONSTRAINT fk_usuarios_roles_usuario FOREIGN KEY (id_usuario) REFERENCES usuarios (id_usuario) ON DELETE CASCADE,
    CONSTRAINT fk_usuarios_roles_rol FOREIGN KEY (id_rol) REFERENCES roles (id_rol) ON DELETE CASCADE
);
GO
CREATE TABLE roles_permisos
(
    id_rol     SMALLINT,
    id_permiso SMALLINT,
    PRIMARY KEY (id_rol, id_permiso),
    CONSTRAINT fk_roles_permisos_rol FOREIGN KEY (id_rol) REFERENCES roles (id_rol) ON DELETE CASCADE,
    CONSTRAINT fk_roles_permisos_permiso FOREIGN KEY (id_permiso) REFERENCES permisos (id_permiso) ON DELETE CASCADE
);
GO
-- tablas de vacunación
CREATE TABLE provincias
(
    id_provincia     TINYINT PRIMARY KEY IDENTITY (0,1),
    nombre_provincia NVARCHAR(30) NOT NULL,
    CONSTRAINT ck_provincia_existe CHECK (nombre_provincia IN
                                          ('Por registrar', /* Problemas o nueva provincia sin registrar aún */
                                           'Bocas del Toro', /*1*/
                                           N'Coclé', /*2*/
                                           N'Colón', /*3*/
                                           N'Chiriquí', /*4*/
                                           N'Darién', /*5*/
                                           'Herrera', /*6*/
                                           'Los Santos', /*7*/
                                           N'Panamá', /*8*/
                                           'Veraguas', /*9*/
                                           'Guna Yala', /*10*/
                                           N'Emberá-Wounaan', /*11*/
                                           N'Ngäbe-Buglé',/*12*/
                                           N'Panamá Oeste', /*13*/
                                           N'Naso Tjër Di', /*14*/
                                           N'Guna de Madugandí', /*15*/
                                           N'Guna de Wargandí' /*16*/
                                              )),
    INDEX ix_provincias_nombre (nombre_provincia)
);
GO
CREATE TABLE distritos
(
    id_distrito     TINYINT PRIMARY KEY IDENTITY (0,1),
    nombre_distrito NVARCHAR(100) NOT NULL,
    id_provincia    TINYINT       NOT NULL,
    CONSTRAINT fk_distritos_provincia FOREIGN KEY (id_provincia) REFERENCES provincias (id_provincia),
    CONSTRAINT ck_distritos_provincias CHECK (
        (id_provincia = 0 AND nombre_distrito LIKE 'Por registrar') OR
        (id_provincia = 1 AND nombre_distrito IN ('Almirante',
                                                  'Bocas del Toro',
                                                  'Changuinola',
                                                  N'Chiriquí Grande')) OR
        (id_provincia = 2 AND nombre_distrito IN ('Aguadulce',
                                                  N'Antón',
                                                  'La Pintada',
                                                  N'Natá',
                                                  N'Olá',
                                                  N'Penonomé')) OR
        (id_provincia = 3 AND nombre_distrito IN ('Chagres',
                                                  N'Colón',
                                                  'Donoso',
                                                  'Portobelo',
                                                  'Santa Isabel',
                                                  'Omar Torrijos Herrera')) OR
        (id_provincia = 4 AND nombre_distrito IN ('Alanje',
                                                  N'Barú',
                                                  N'Boquerón',
                                                  'Boquete',
                                                  'Bugaba',
                                                  'David',
                                                  'Dolega',
                                                  'Gualaca',
                                                  'Remedios',
                                                  'Renacimiento',
                                                  N'San Félix',
                                                  'San Lorenzo',
                                                  'Tierras Altas',
                                                  N'Tolé')) OR
        (id_provincia = 5 AND nombre_distrito IN ('Chepigana',
                                                  'Pinogana',
                                                  'Santa Fe',
                                                  N'Guna de Wargandí')) OR
        (id_provincia = 6 AND nombre_distrito IN (N'Chitré',
                                                  'Las Minas',
                                                  'Los Pozos',
                                                  N'Ocú',
                                                  'Parita',
                                                  N'Pesé',
                                                  N'Santa María')) OR
        (id_provincia = 7 AND nombre_distrito IN (N'Guararé',
                                                  'Las Tablas',
                                                  'Los Santos',
                                                  'Macaracas',
                                                  N'Pedasí',
                                                  N'Pocrí',
                                                  N'Tonosí')) OR
        (id_provincia = 8 AND nombre_distrito IN ('Balboa',
                                                  'Chepo',
                                                  N'Chimán',
                                                  N'Panamá',
                                                  'San Miguelito',
                                                  'Taboga')) OR
        (id_provincia = 9 AND nombre_distrito IN ('Atalaya',
                                                  'Calobre',
                                                  N'Cañazas',
                                                  'La Mesa',
                                                  'Las Palmas',
                                                  'Mariato',
                                                  'Montijo',
                                                  N'Río de Jesús',
                                                  'San Francisco',
                                                  'Santa Fe',
                                                  'Santiago',
                                                  N'Soná')) OR
            /*comarca guna yala, madugandi, wargandi no tiene distrito, provincia 10*/
        (id_provincia = 11 AND nombre_distrito IN (N'Cémaco', N'Sambú')) OR
        (id_provincia = 12 AND nombre_distrito IN (N'Besikó',
                                                   'Jirondai',
                                                   N'Kankintú',
                                                   N'Kusapín',
                                                   N'Mironó',
                                                   N'Müna',
                                                   'Nole Duima',
                                                   N'Ñürüm',
                                                   'Santa Catalina',
                                                   N'Calovébora')) OR
        (id_provincia = 13 AND nombre_distrito IN (N'Arraiján',
                                                   'Capira',
                                                   'Chame',
                                                   'La Chorrera',
                                                   'San Carlos')) OR
        (id_provincia = 14 AND nombre_distrito IN (N'Naso Tjër Di')) OR
        (id_provincia IS NULL AND nombre_distrito IS NULL) -- Permitir NULL si es necesario
        ),
    INDEX ix_distritos_nombre (nombre_distrito)
);
GO
CREATE TABLE direcciones
(
    id_direccion UNIQUEIDENTIFIER PRIMARY KEY
        CONSTRAINT df_direcciones_id DEFAULT NEWID(),
    direccion    VARCHAR(150) NOT NULL,
    id_distrito  TINYINT
        CONSTRAINT df_direcciones_distrito DEFAULT 0,
    CONSTRAINT fk_direcciones_distrito FOREIGN KEY (id_distrito) REFERENCES distritos (id_distrito),
    INDEX ix_direcciones_direccion (direccion)
);
GO
CREATE TABLE pacientes
(
    cedula             NVARCHAR(20) PRIMARY KEY,
    nombre_paciente    NVARCHAR(50)     NOT NULL,
    apellido1_paciente NVARCHAR(50)     NOT NULL,
    apellido2_paciente NVARCHAR(50),
    fecha_nacimiento   SMALLDATETIME    NOT NULL,
    edad_calculada     TINYINT,
    sexo               CHAR(1)          NOT NULL,
    telefono_paciente  NVARCHAR(15),
    correo_paciente    NVARCHAR(50),
    id_direccion       UNIQUEIDENTIFIER NOT NULL,
    created_at         DATETIME         NOT NULL
        CONSTRAINT df_pacientes_created DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT ck_pacientes_fecha_nacimiento CHECK (fecha_nacimiento <= GETDATE()),
    CONSTRAINT ck_pacientes_sexo_m_f CHECK (sexo LIKE 'M' OR sexo LIKE 'F'),
    CONSTRAINT ck_telefonos_paciente_no_signo_plus CHECK (telefono_paciente NOT LIKE '%+%'),
    CONSTRAINT ck_pacientes_edad CHECK (edad_calculada >= 0),
    CONSTRAINT fk_pacientes_direccion FOREIGN KEY (id_direccion) REFERENCES direcciones (id_direccion) ON UPDATE CASCADE,
    INDEX ix_pacientes_nombre_apellidos (nombre_paciente, apellido1_paciente, apellido2_paciente)
);
GO
CREATE UNIQUE NONCLUSTERED INDEX ix_pacientes_correo
    ON pacientes (correo_paciente)
    WHERE correo_paciente IS NOT NULL;
GO
CREATE UNIQUE NONCLUSTERED INDEX ix_pacientes_telefono
    ON pacientes (telefono_paciente)
    WHERE telefono_paciente IS NOT NULL;
GO
CREATE TABLE sedes
(
    id_sede          UNIQUEIDENTIFIER PRIMARY KEY
        CONSTRAINT df_sedes_id DEFAULT NEWID(),
    nombre_sede      NVARCHAR(100)    NOT NULL,
    correo_sede      NVARCHAR(50),
    telefono_sede    NVARCHAR(15),
    region           NVARCHAR(50),
    dependencia_sede NVARCHAR(13)     NOT NULL,
    id_direccion     UNIQUEIDENTIFIER NOT NULL,
    CONSTRAINT ck_sedes_telefono CHECK (telefono_sede NOT LIKE '%+%'),
    CONSTRAINT uq_sedes_nombre UNIQUE (nombre_sede),
    CONSTRAINT ck_sedes_dependencia CHECK (dependencia_sede IN ('CSS', 'MINSA', 'Privada', 'Por registrar')),
    CONSTRAINT fk_sedes_direccion FOREIGN KEY (id_direccion) REFERENCES direcciones (id_direccion) ON UPDATE CASCADE,
    INDEX ix_sedes_nombre_region_dependencia (nombre_sede, region, dependencia_sede)
);
GO
CREATE UNIQUE NONCLUSTERED INDEX ix_sedes_telefono
    ON sedes (telefono_sede)
    WHERE telefono_sede IS NOT NULL;
GO
CREATE UNIQUE NONCLUSTERED INDEX ix_sedes_email
    ON sedes (correo_sede)
    WHERE correo_sede IS NOT NULL;
GO
CREATE TABLE vacunas
(
    id_vacuna                 UNIQUEIDENTIFIER PRIMARY KEY
        CONSTRAINT df_vacunas_id DEFAULT NEWID(),
    nombre_vacuna             NVARCHAR(100) NOT NULL,
    edad_minima_meses         SMALLINT,
    intervalo_dosis_1_2_meses FLOAT,
    dosisMaxima               CHAR(2),
    CONSTRAINT ck_vacunas_edad_minima CHECK (edad_minima_meses >= 0),
    INDEX ix_vacunas_nombre (nombre_vacuna)
);
GO
CREATE TABLE dosis
(
    id_dosis         UNIQUEIDENTIFIER PRIMARY KEY
        CONSTRAINT df_dosis_id DEFAULT NEWID(),
    fecha_aplicacion DATETIME         NOT NULL
        CONSTRAINT df_dosis_aplicacion DEFAULT CURRENT_TIMESTAMP,
    numero_dosis     CHAR(2)          NOT NULL, -- ver tabla adjunta con detalles
    id_vacuna        UNIQUEIDENTIFIER NOT NULL,
    id_sede          UNIQUEIDENTIFIER,
    lote_dosis       NVARCHAR(50),
    CONSTRAINT ck_dosis_numero_dosis CHECK (numero_dosis IN ('1', '2', '3', 'R', 'R1', 'R2', 'P')),
    CONSTRAINT fk_dosis_vacuna FOREIGN KEY (id_vacuna) REFERENCES vacunas (id_vacuna) ON UPDATE CASCADE,
    CONSTRAINT fk_dosis_sede FOREIGN KEY (id_sede) REFERENCES sedes (id_sede) ON UPDATE CASCADE
);
GO
CREATE TABLE pacientes_dosis
(
    cedula_paciente NVARCHAR(20),
    id_dosis        UNIQUEIDENTIFIER,
    PRIMARY KEY (cedula_paciente, id_dosis),
    CONSTRAINT fk_pacientes_dosis_paciente FOREIGN KEY (cedula_paciente) REFERENCES pacientes (cedula),
    CONSTRAINT fk_pacientes_dosis_dosis FOREIGN KEY (id_dosis) REFERENCES dosis (id_dosis)
);
GO
CREATE NONCLUSTERED INDEX ix_pacientes_dosis
    ON pacientes_dosis (cedula_paciente, id_dosis);
GO
CREATE TABLE fabricantes
(
    id_fabricante        INT PRIMARY KEY IDENTITY (1,1),
    licencia             NVARCHAR(50)  NOT NULL,
    nombre_fabricante    NVARCHAR(100) NOT NULL,
    telefono_fabricante  NVARCHAR(15),
    correo_fabricante    NVARCHAR(50),
    direccion_fabricante NVARCHAR(150)
        CONSTRAINT df_fabricantes_direccion DEFAULT 'Por registrar',
    contacto_fabricante  NVARCHAR(50),
    CONSTRAINT ck_fabricantes_telefono CHECK (telefono_fabricante NOT LIKE '%+%'),
    INDEX ix_fabricantes_nombre_licencia (nombre_fabricante, licencia)
);
GO
CREATE UNIQUE NONCLUSTERED INDEX ix_fabricantes_telefono
    ON fabricantes (telefono_fabricante)
    WHERE telefono_fabricante IS NOT NULL;
GO
CREATE UNIQUE NONCLUSTERED INDEX ix_fabricantes_correo
    ON fabricantes (correo_fabricante)
    WHERE correo_fabricante IS NOT NULL;
GO
CREATE UNIQUE NONCLUSTERED INDEX ix_fabricantes_contacto
    ON fabricantes (contacto_fabricante)
    WHERE contacto_fabricante IS NOT NULL;
GO
CREATE TABLE almacenes
(
    id_almacen          SMALLINT PRIMARY KEY IDENTITY (1,1),
    nombre_almacen      NVARCHAR(100)    NOT NULL,
    dependencia_almacen NVARCHAR(7)      NOT NULL,
    correo_almacen      NVARCHAR(50),
    telefono_almacen    NVARCHAR(15),
    id_direccion        UNIQUEIDENTIFIER NOT NULL,
    encargado           NVARCHAR(50),
    CONSTRAINT ck_almacenes_telefono CHECK (telefono_almacen NOT LIKE '%+%'),
    CONSTRAINT ck_almacenes_dependencia CHECK (dependencia_almacen IN ('CSS', 'MINSA', 'Privada')),
    CONSTRAINT fk_almacenes_direccion FOREIGN KEY (id_direccion) REFERENCES direcciones (id_direccion) ON UPDATE CASCADE,
    INDEX ix_almacenes_nombre (nombre_almacen)
);
GO
CREATE UNIQUE NONCLUSTERED INDEX ix_almacenes_telefono
    ON almacenes (telefono_almacen)
    WHERE telefono_almacen IS NOT NULL;
GO
CREATE UNIQUE NONCLUSTERED INDEX ix_almacenes_email
    ON almacenes (correo_almacen)
    WHERE correo_almacen IS NOT NULL;
GO
CREATE TABLE almacenes_inventarios
(
    id_almacen               SMALLINT         NOT NULL,
    id_vacuna                UNIQUEIDENTIFIER NOT NULL,
    cantidad                 INT              NOT NULL,
    fecha_expiracion_almacen DATETIME         NOT NULL,
    lote_almacen             NVARCHAR(50)     NOT NULL,
    fecha_recepcion_almacen  DATETIME         NOT NULL
        CONSTRAINT df_almacenes_inventario_recepcion DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (id_almacen, id_vacuna),
    CONSTRAINT ck_almacenes_inventarios_fecha_expiracion CHECK (fecha_expiracion_almacen > GETDATE()),
    CONSTRAINT ck_almacenes_inventarios_cantidad CHECK (cantidad >= 0),
    CONSTRAINT fk_almacenes_inventarios_almacen FOREIGN KEY (id_almacen) REFERENCES almacenes (id_almacen),
    CONSTRAINT fk_almacenes_inventarios_vacuna FOREIGN KEY (id_vacuna) REFERENCES vacunas (id_vacuna)
);
GO
CREATE TABLE sedes_inventarios
(
    id_sede               UNIQUEIDENTIFIER NOT NULL,
    id_vacuna             UNIQUEIDENTIFIER NOT NULL,
    cantidad              INT              NOT NULL,
    fecha_expiracion_sede DATETIME         NOT NULL,
    lote_sede             NVARCHAR(50)     NOT NULL,
    fecha_recepcion_sede  DATETIME         NOT NULL
        CONSTRAINT df_sedes_inventarios_recepcion DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (id_sede, id_vacuna),
    CONSTRAINT ck_sedes_inventarios_fecha_expiracion CHECK (fecha_expiracion_sede > GETDATE()),
    CONSTRAINT ck_sedes_inventarios_cantidad CHECK (cantidad >= 0),
    CONSTRAINT fk_sedes_inventarios_sede FOREIGN KEY (id_sede) REFERENCES sedes (id_sede),
    CONSTRAINT fk_sedes_inventarios_vacuna FOREIGN KEY (id_vacuna) REFERENCES vacunas (id_vacuna)
);
GO
CREATE TABLE distribuciones_vacunas
(
    id_distribucion    UNIQUEIDENTIFIER PRIMARY KEY
        CONSTRAINT df_distribuciones_id DEFAULT NEWID(),
    id_almacen         SMALLINT         NOT NULL,
    id_sede            UNIQUEIDENTIFIER NOT NULL,
    id_vacuna          UNIQUEIDENTIFIER NOT NULL,
    cantidad           INT              NOT NULL,
    lote               NVARCHAR(50)     NOT NULL,
    fecha_distribucion DATETIME         NOT NULL
        CONSTRAINT df_distribucionas_fecha_distribucion DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT ck_distribuciones_fecha_distribucion CHECK (fecha_distribucion <= GETDATE()),
    CONSTRAINT fk_distribuciones_almacen FOREIGN KEY (id_almacen) REFERENCES almacenes (id_almacen),
    CONSTRAINT fk_distribuciones_sede FOREIGN KEY (id_sede) REFERENCES sedes (id_sede),
    CONSTRAINT fk_distribuciones_vacuna FOREIGN KEY (id_vacuna) REFERENCES vacunas (id_vacuna)
);
GO
CREATE TABLE fabricantes_vacunas
(
    id_fabricante INT,
    id_vacuna     UNIQUEIDENTIFIER,
    PRIMARY KEY (id_fabricante, id_vacuna),
    CONSTRAINT fk_fabricantes_vacunas_fabricante FOREIGN KEY (id_fabricante) REFERENCES fabricantes (id_fabricante) ON UPDATE CASCADE,
    CONSTRAINT fk_fabricantes_vacunas_vacuna FOREIGN KEY (id_vacuna) REFERENCES vacunas (id_vacuna) ON DELETE CASCADE
);
GO
CREATE TABLE enfermedades
(
    id_enfermedad     INT PRIMARY KEY IDENTITY (0,1),
    nombre_enfermedad NVARCHAR(100) NOT NULL,
    nivel_gravedad    NVARCHAR(50),
    CONSTRAINT uq_enfermedades_nombre UNIQUE (nombre_enfermedad),
    INDEX ix_enfermedades_nombre (nombre_enfermedad)
);
GO
CREATE TABLE sintomas
(
    id_sintoma     INT PRIMARY KEY IDENTITY (0,1),
    nombre_sintoma NVARCHAR(50) NOT NULL,
    CONSTRAINT uq_sintomas_nombre UNIQUE (nombre_sintoma),
    INDEX ix_sintomas_nombre (nombre_sintoma)
);
GO
CREATE TABLE enfermedades_sintomas
(
    id_sintoma    INT,
    id_enfermedad INT,
    PRIMARY KEY (id_sintoma, id_enfermedad),
    CONSTRAINT fk_enfermedades_sintomas_sintoma FOREIGN KEY (id_sintoma) REFERENCES sintomas (id_sintoma) ON UPDATE CASCADE,
    CONSTRAINT fk_enfermedades_sintomas_enfermedad FOREIGN KEY (id_enfermedad) REFERENCES enfermedades (id_enfermedad) ON UPDATE CASCADE
);
GO
CREATE TABLE vacunas_enfermedades
(
    id_vacuna     UNIQUEIDENTIFIER,
    id_enfermedad INT,
    PRIMARY KEY (id_vacuna, id_enfermedad),
    CONSTRAINT fk_vacunas_enfermedades_vacuna FOREIGN KEY (id_vacuna) REFERENCES vacunas (id_vacuna) ON DELETE CASCADE,
    CONSTRAINT fk_vacunas_enfermedades_enfermedad FOREIGN KEY (id_enfermedad) REFERENCES enfermedades (id_enfermedad) ON DELETE CASCADE
);
GO
PRINT (N'Tablas terminadas');
PRINT (N'Creando triggers');
GO
-- Triggers
-- Trigger para asignar automáticamente la región a las sedes cuando coincide con la provincia y/o distrito
CREATE TRIGGER tr_sedes_insert_region
    ON sedes
    AFTER INSERT
    AS
BEGIN
    UPDATE S
    SET region =
            CASE
                WHEN P.id_provincia = 1 THEN 'Bocas del Toro'
                WHEN P.id_provincia = 2 THEN N'Coclé'
                WHEN P.id_provincia = 3 THEN N'Colón'
                WHEN P.id_provincia = 4 THEN N'Chiriquí'
                WHEN P.id_provincia = 5 THEN N'Darién y la comarca Embera Waunán y Wargandí'
                WHEN P.id_provincia = 6 THEN 'Herrera'
                WHEN P.id_provincia = 7 THEN 'Los Santos'
                WHEN P.id_provincia = 8 AND D.id_distrito = 53 THEN 'San Miguelito'
                WHEN P.id_provincia = 8 AND D.id_distrito <> 53 THEN N'Panamá Norte/Este/Metro'
                WHEN P.id_provincia = 9 THEN 'Veraguas'
                WHEN P.id_provincia = 10 THEN 'Kuna Yala'
                WHEN P.id_provincia = 11 THEN N'Darién y la comarca Embera Waunán y Wargandí'
                WHEN P.id_provincia = 12 THEN N'Ngabe Buglé'
                WHEN P.id_provincia = 13 AND D.id_distrito <> 79 THEN N'Panamá Oeste'
                WHEN P.id_provincia = 13 AND D.id_distrito = 79 THEN N'Arraiján'
                WHEN P.id_provincia = 16 THEN N'Darién y la comarca Embera Waunán y Wargandí'
                ELSE 'Por registrar'
                END
    FROM sedes S
             INNER JOIN inserted I ON S.id_sede = I.id_sede
             INNER JOIN direcciones D ON I.id_direccion = D.id_direccion
             INNER JOIN distritos DD ON D.id_distrito = DD.id_distrito
             INNER JOIN provincias P ON DD.id_provincia = P.id_provincia
END;
GO
-- trigger para actualizar la edad calculada del paciente al momento de insertar o actualizar la fecha de nacimiento
CREATE TRIGGER tr_pacientes_update_edad
    ON pacientes
    AFTER INSERT, UPDATE
    AS
BEGIN
    UPDATE pacientes
    SET edad_calculada =
            IIF(DATEADD(YEAR, DATEDIFF(YEAR, fecha_nacimiento, GETDATE()), fecha_nacimiento) > GETDATE(),
                DATEDIFF(YEAR, fecha_nacimiento, GETDATE()) - 1, DATEDIFF(YEAR, fecha_nacimiento, GETDATE()))
    WHERE (edad_calculada IS NULL OR
           IIF(DATEADD(YEAR, DATEDIFF(YEAR, fecha_nacimiento, GETDATE()), fecha_nacimiento) > GETDATE(),
               DATEDIFF(YEAR, fecha_nacimiento, GETDATE()) - 1, DATEDIFF(YEAR, fecha_nacimiento, GETDATE())) <>
           edad_calculada);
END;
GO
-- trigger para mantener registro de cambios de usuarios
CREATE TRIGGER tr_usuarios_updated
    ON usuarios
    AFTER UPDATE
    AS
BEGIN
    UPDATE usuarios
    SET updated_at = CURRENT_TIMESTAMP
    WHERE id_usuario IN (SELECT id_usuario FROM INSERTED);
END
GO
-- trigger para validar las distribuciones y de forma automática actualiza o inserta en los inventarios
CREATE TRIGGER tr_distribuciones_validate_update_insert
    ON distribuciones_vacunas
    INSTEAD OF INSERT
    AS
BEGIN
    BEGIN TRY
        DECLARE @id_almacen SMALLINT, @id_vacuna UNIQUEIDENTIFIER, @cantidad INT, @lote NVARCHAR(10), @id_sede UNIQUEIDENTIFIER, @fecha_lote DATETIME;

        SELECT @id_almacen = id_almacen, @id_vacuna = id_vacuna, @cantidad = cantidad, @lote = lote, @id_sede = id_sede
        FROM inserted;

        -- Verificar la cantidad disponible en almacenes_inventarios
        IF EXISTS (SELECT 1
                   FROM almacenes_inventarios
                   WHERE id_almacen = @id_almacen
                     AND id_vacuna = @id_vacuna
                     AND lote_almacen LIKE @lote
                     AND cantidad >= @cantidad)
            BEGIN
                -- Actualizar inventario del almacén
                UPDATE almacenes_inventarios
                SET cantidad = cantidad - @cantidad
                WHERE id_almacen = @id_almacen
                  AND id_vacuna = @id_vacuna
                  AND lote_almacen LIKE @lote;

                SELECT @fecha_lote = fecha_expiracion_almacen
                FROM almacenes_inventarios
                WHERE id_almacen = @id_almacen
                  AND id_vacuna = @id_vacuna
                  AND lote_almacen LIKE @lote

                IF @fecha_lote < GETDATE()
                    BEGIN
                        RAISERROR (N'No se puede distribuir un lote con fecha menor al día de hoy. Revisar inventario almacen', 16, 1);
                    END

                -- Insertar la distribución
                INSERT INTO distribuciones_vacunas (id_distribucion, id_almacen, id_sede, id_vacuna, cantidad, lote,
                                                    fecha_distribucion)
                SELECT id_distribucion, id_almacen, id_sede, id_vacuna, cantidad, lote, fecha_distribucion
                FROM inserted;
            END
        ELSE
            BEGIN
                RAISERROR (N'No hay suficiente cantidad en el almacén.', 16, 1);
            END

        -- Si existe la vacuna en la sede, se actualiza
        IF EXISTS (SELECT 1
                   FROM sedes_inventarios
                   WHERE id_sede = @id_sede
                     AND id_vacuna = @id_vacuna
                     AND lote_sede LIKE @lote)
            BEGIN
                UPDATE sedes_inventarios
                SET cantidad = cantidad + @cantidad
                WHERE id_sede = @id_sede
                  AND id_vacuna = @id_vacuna
                  AND lote_sede LIKE @lote;
            END
        ELSE
            BEGIN
                -- Si no existe, se inserta un nuevo registro
                INSERT INTO sedes_inventarios (id_sede, id_vacuna, cantidad, fecha_expiracion_sede, lote_sede)
                VALUES (@id_sede, @id_vacuna, @cantidad, @fecha_lote, @lote);
            END
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
END;
GO
-- trigger que resta del inventario de la sede si existe para esa vacuna de dosis insertada
CREATE TRIGGER tr_dosis_update_inventario
    ON dosis
    INSTEAD OF INSERT
    AS
BEGIN
    BEGIN TRY
        DECLARE @numero_dosis CHAR(2), @id_vacuna UNIQUEIDENTIFIER, @id_sede UNIQUEIDENTIFIER, @lote NVARCHAR(10), @cantidad_disponible INT, @fecha_lote DATETIME;

        SELECT @numero_dosis = i.numero_dosis, @id_vacuna = i.id_vacuna, @id_sede = i.id_sede, @lote = i.lote_dosis
        FROM inserted i

        -- Verificar si hay suficiente inventario y fecha de vencimiento del mismo
        IF EXISTS (SELECT 1
                   FROM sedes_inventarios
                   WHERE id_sede = @id_sede
                     AND id_vacuna = @id_vacuna
                     AND lote_sede LIKE @lote)
            BEGIN
                SELECT @cantidad_disponible = Cantidad, @fecha_lote = fecha_expiracion_sede
                FROM sedes_inventarios
                WHERE id_sede = @id_sede
                  AND id_vacuna = @id_vacuna
                  AND lote_sede LIKE @lote;

                IF @cantidad_disponible < 1
                    BEGIN
                        RAISERROR ('Cantidad insuficiente de dosis de la vacuna en el inventario de la sede.', 16, 1);
                    END

                IF @fecha_lote <= CURRENT_TIMESTAMP
                    BEGIN
                        RAISERROR (N'La fecha de vencimiento del lote de esta vacuna es el día de hoy o anterior.', 16, 1);
                    END

                UPDATE sedes_inventarios
                SET cantidad = cantidad - 1
                WHERE id_sede = @id_sede
                  AND id_vacuna = @id_vacuna
                  AND lote_sede LIKE @lote;
            END

        INSERT INTO dosis (id_dosis, fecha_aplicacion, numero_dosis, id_vacuna, id_sede, lote_dosis)
        SELECT id_dosis, fecha_aplicacion, numero_dosis, id_vacuna, id_sede, lote_dosis
        FROM inserted
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
END;
GO
-- trigger que valida las dosis previas del paciente al insertar
CREATE TRIGGER tr_pacientes_dosis_validate_dosis_previa
    ON pacientes_dosis
    INSTEAD OF INSERT
    AS
BEGIN
    BEGIN TRY
        DECLARE @cedula NVARCHAR(20), @id_vacuna UNIQUEIDENTIFIER, @numero_dosis CHAR(2), @id_dosis UNIQUEIDENTIFIER;

        SELECT @cedula = i.cedula_paciente,
               @id_vacuna = d.id_vacuna,
               @numero_dosis = d.numero_dosis,
               @id_dosis = i.id_dosis
        FROM inserted i
                 JOIN dosis d ON i.id_dosis = d.id_dosis

        SET @numero_dosis = RTRIM(@numero_dosis);
        SET @numero_dosis = UPPER(@numero_dosis);

        -- Verifica si la dosis vacuna - numero de dosis ya existe
        IF EXISTS (SELECT 1
                   FROM pacientes_dosis pd
                            INNER JOIN dosis d ON pd.id_dosis = d.id_dosis
                   WHERE pd.cedula_paciente = @cedula
                     AND d.id_vacuna = @id_vacuna
                     AND d.numero_dosis LIKE @numero_dosis)
            BEGIN
                RAISERROR (N'La dosis para el paciente en esa vacuna y número de dosis ya existe. Elimine o corregir la dosis', 16, 1);
            END

        -- Validar dosis anteriores
        IF @numero_dosis = 'P' AND EXISTS (SELECT 1
                                           FROM pacientes_dosis pd
                                                    INNER JOIN Dosis d ON pd.id_dosis = d.id_dosis
                                           WHERE pd.cedula_paciente = @cedula
                                             AND d.id_vacuna = @id_vacuna)
            BEGIN
                RAISERROR ('La dosis P previa solo puede ser aplicada antes de la primera dosis de la misma vacuna.', 16, 1);
            END

        IF @numero_dosis = '2' AND NOT EXISTS (SELECT 1
                                               FROM pacientes_dosis pd
                                                        JOIN Dosis d ON pd.id_dosis = d.id_dosis
                                               WHERE pd.cedula_paciente = @cedula
                                                 AND d.id_vacuna = @id_vacuna
                                                 AND d.numero_dosis = '1')
            BEGIN
                RAISERROR ('La dosis 1 de la misma vacuna debe ser aplicada antes de la dosis 2.', 16, 1);
            END

        IF @numero_dosis = '3' AND NOT EXISTS (SELECT 1
                                               FROM pacientes_dosis pd
                                                        JOIN Dosis d ON pd.id_dosis = d.id_dosis
                                               WHERE pd.cedula_paciente = @cedula
                                                 AND d.id_vacuna = @id_vacuna
                                                 AND d.numero_dosis = '2')
            BEGIN
                RAISERROR ('La dosis 2 de la misma vacuna debe ser aplicada antes de la dosis 3.', 16, 1);
            END

        -- Validar refuerzos (R, R1, R2) para la misma vacuna
        IF @numero_dosis = 'R' AND NOT EXISTS (SELECT 1
                                               FROM pacientes_dosis pd
                                                        JOIN Dosis d ON pd.id_dosis = d.id_dosis
                                               WHERE pd.cedula_paciente = @cedula
                                                 AND d.id_vacuna = @id_vacuna
                                                 AND d.numero_dosis = '1')
            BEGIN
                RAISERROR ('La dosis 1 de la misma vacuna debe ser aplicada antes de la dosis R.', 16, 1);
            END

        IF @numero_dosis = 'R1' AND NOT EXISTS (SELECT 1
                                                FROM pacientes_dosis pd
                                                         JOIN Dosis d ON pd.id_dosis = d.id_dosis
                                                WHERE pd.cedula_paciente = @cedula
                                                  AND d.id_vacuna = @id_vacuna
                                                  AND d.numero_dosis = '1')
            BEGIN
                RAISERROR ('La dosis 1 de la misma vacuna debe ser aplicada antes de la dosis R1.', 16, 1);
            END

        IF @numero_dosis = 'R2' AND NOT EXISTS (SELECT 1
                                                FROM pacientes_dosis pd
                                                         JOIN Dosis d ON pd.id_dosis = d.id_dosis
                                                WHERE pd.cedula_paciente = @cedula
                                                  AND d.id_vacuna = @id_vacuna
                                                  AND d.numero_dosis IN ('R1', '1'))
            BEGIN
                RAISERROR ('La dosis R1 o 1 de la misma vacuna debe ser aplicada antes de la dosis R2.', 16, 1);
            END

        INSERT INTO pacientes_dosis (cedula_paciente, id_dosis)
        SELECT cedula_paciente, id_dosis
        FROM inserted
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

PRINT (N'Creando procedimientos almacenados');
GO
-- Procedimientos
-- algunos procedimiento dan opcional el nombre tabla, los sistemas deben procurar usar el id y no el nombre
CREATE PROCEDURE sp_vacunas_update_paciente_edad(
    @result INT OUTPUT
)
AS
BEGIN
    SET NOCOUNT ON;
    SET @result = 0;
    UPDATE pacientes
    SET edad_calculada = DATEDIFF(YEAR, fecha_nacimiento, GETDATE())
    WHERE DATEPART(MONTH, fecha_nacimiento) = DATEPART(MONTH, GETDATE())
      AND DATEPART(DAY, fecha_nacimiento) = DATEPART(DAY, GETDATE());
    SET @result = @@ROWCOUNT;
END;
GO

CREATE PROCEDURE sp_vacunas_insert_sede(
    @nombre_sede NVARCHAR(100),
    @dependencia_sede NVARCHAR(13),
    @correo_sede NVARCHAR(50) = NULL,
    @telefono_sede NVARCHAR(15) = NULL,
    @direccion_sede NVARCHAR(150) = NULL,
    @distrito_sede NVARCHAR(100) = NULL,
    @result INT OUTPUT
)
AS
BEGIN
    BEGIN TRY
        SET NOCOUNT ON;
        SET @result = 0;
        DECLARE @id_direccion UNIQUEIDENTIFIER;

        -- Validar que dirección y distrito estén ambos campos o ninguno
        IF (@direccion_sede IS NOT NULL AND @distrito_sede IS NULL) OR
           (@direccion_sede IS NULL AND @distrito_sede IS NOT NULL)
            BEGIN
                RAISERROR (N'Debe especificar ambos campos: dirección y distrito o ninguno.', 16, 1);
            END
        -- Validar la dependencia bien escrito
        IF (@dependencia_sede NOT LIKE 'CSS' AND @dependencia_sede NOT LIKE 'MINSA' AND
            @dependencia_sede NOT LIKE 'Privada' AND @dependencia_sede NOT LIKE 'Por registrar')
            BEGIN
                RAISERROR (N'La dependencia de la sede debe ser MINSA o CSS o Privada, si no encuentra su opción no se puede registrar.', 16, 1);
            END
        -- Verifica si la sede ya existe
        IF EXISTS (SELECT 1 FROM sedes WHERE nombre_sede = @nombre_sede)
            BEGIN
                RAISERROR ('La sede con ese nombre ya existe.', 16, 1);
            END

        BEGIN TRANSACTION

            -- Insertar la dirección si no existe
            IF @direccion_sede IS NOT NULL AND @distrito_sede IS NOT NULL
                BEGIN
                    -- Verificar si la dirección ya existe
                    SELECT @id_direccion = id_direccion
                    FROM direcciones
                    WHERE direccion = @direccion_sede;

                    IF @id_direccion IS NULL
                        BEGIN
                            SET @id_direccion = NEWID();
                            -- Insertar nueva dirección
                            INSERT INTO direcciones (id_direccion, direccion, id_distrito)
                            VALUES (@id_direccion, @direccion_sede,
                                    (SELECT id_distrito FROM distritos WHERE nombre_distrito = @distrito_sede))
                            SET @result = @result + @@ROWCOUNT;
                        END
                END
            ELSE
                BEGIN
                    SELECT @id_direccion = id_direccion
                    FROM direcciones
                    WHERE direccion = 'Por registrar'
                      AND id_distrito = 0
                END

            -- Insertar la sede
            INSERT INTO sedes (nombre_sede, dependencia_sede, correo_sede, telefono_sede, id_direccion)
            VALUES (@nombre_sede, @dependencia_sede, @correo_sede, @telefono_sede, @id_direccion);
            SET @result = @result + @@ROWCOUNT;
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

CREATE PROCEDURE sp_vacunas_insert_almacen(
    @nombre_almacen NVARCHAR(100),
    @dependencia_almacen NVARCHAR(13),
    @correo_almacen NVARCHAR(50) = NULL,
    @telefono_almacen NVARCHAR(15) = NULL,
    @direccion_almacen NVARCHAR(150) = NULL,
    @distrito_almacen NVARCHAR(100) = NULL,
    @encargado_almacen NVARCHAR(50) = NULL,
    @result INT OUTPUT
)
AS
BEGIN
    BEGIN TRY
        SET NOCOUNT ON;
        SET @result = 0;
        DECLARE @id_direccion UNIQUEIDENTIFIER;

        -- Validar que dirección y distrito estén ambos campos o ninguno
        IF (@direccion_almacen IS NOT NULL AND @distrito_almacen IS NULL) OR
           (@direccion_almacen IS NULL AND @distrito_almacen IS NOT NULL)
            BEGIN
                RAISERROR (N'Debe especificar ambos campos: dirección y distrito o ninguno.', 16, 1);
            END
        -- Validar la dependencia bien escrito
        IF (@dependencia_almacen NOT LIKE 'CSS' AND @dependencia_almacen NOT LIKE 'MINSA' AND
            @dependencia_almacen NOT LIKE 'Privada')
            BEGIN
                RAISERROR (N'La dependencia del almacen debe ser MINSA o CSS o Privada, si no encuentra su opción no se puede registrar.', 16, 1);
            END
        -- Verifica si la sede ya existe
        IF EXISTS (SELECT 1 FROM almacenes WHERE nombre_almacen = @nombre_almacen)
            BEGIN
                RAISERROR ('El almacen con ese nombre ya existe.', 16, 1);
            END

        BEGIN TRANSACTION

            -- Insertar la dirección si no existe
            IF @direccion_almacen IS NOT NULL AND @distrito_almacen IS NOT NULL
                BEGIN
                    -- Verificar si la dirección ya existe
                    SELECT @id_direccion = id_direccion
                    FROM direcciones
                    WHERE direccion = @direccion_almacen;

                    IF @id_direccion IS NULL
                        BEGIN
                            SET @id_direccion = NEWID();
                            -- Insertar nueva dirección
                            INSERT INTO direcciones (id_direccion, direccion, id_distrito)
                            VALUES (@id_direccion, @direccion_almacen,
                                    (SELECT id_distrito FROM distritos WHERE nombre_distrito = @distrito_almacen))
                            SET @result = @result + @@ROWCOUNT;
                        END
                END
            ELSE
                BEGIN
                    SELECT @id_direccion = id_direccion
                    FROM direcciones
                    WHERE direccion = 'Por registrar'
                      AND id_distrito = 0
                END

            -- Insertar el almacen
            INSERT INTO almacenes(nombre_almacen, dependencia_almacen, correo_almacen, telefono_almacen, id_direccion,
                                  encargado)
            VALUES (@nombre_almacen, @dependencia_almacen, @correo_almacen, @telefono_almacen, @id_direccion,
                    @encargado_almacen);
            SET @result = @result + @@ROWCOUNT;
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

CREATE PROCEDURE sp_vacunas_gestionar_paciente(
    @cedula_paciente NVARCHAR(20),
    @nombre_paciente NVARCHAR(50),
    @apellido1_paciente NVARCHAR(50),
    @apellido2_paciente NVARCHAR(50) = NULL,
    @fecha_nacimiento_paciente SMALLDATETIME,
    @sexo_paciente CHAR(1),
    @telefono_paciente NVARCHAR(15) = NULL,
    @correo_paciente NVARCHAR(50) = NULL,
    @direccion_residencial_paciente NVARCHAR(150) = NULL,
    @distrito_reside_paciente NVARCHAR(100) = NULL,
    @result INT OUTPUT
)
AS
BEGIN
    BEGIN TRY
        SET NOCOUNT ON;
        SET @result = 0;
        -- Validar que dirección y distrito estén ambos campos o ninguno
        IF (@direccion_residencial_paciente IS NOT NULL AND @distrito_reside_paciente IS NULL) OR
           (@direccion_residencial_paciente IS NULL AND @distrito_reside_paciente IS NOT NULL)
            BEGIN
                RAISERROR (N'Debe especificar ambos campos dirección y distrito o ninguno.', 16, 1);
            END

        -- Validar el sexo bien escrito
        IF (@sexo_paciente NOT LIKE 'M' AND @sexo_paciente NOT LIKE 'F')
            BEGIN
                RAISERROR (N'Debe especificar el sexo como M masculino y F femenino.', 16, 1);
            END

        BEGIN TRANSACTION
            DECLARE @id_direccion UNIQUEIDENTIFIER;

            -- Insertar la dirección si no existe
            IF @direccion_residencial_paciente IS NOT NULL AND @distrito_reside_paciente IS NOT NULL
                BEGIN
                    -- Verificar si la dirección ya existe
                    SELECT @id_direccion = id_direccion
                    FROM direcciones
                    WHERE direccion = @direccion_residencial_paciente;

                    IF @id_direccion IS NULL
                        BEGIN
                            SET @id_direccion = NEWID();
                            -- Insertar nueva dirección
                            INSERT INTO direcciones (id_direccion, direccion, id_distrito)
                            VALUES (@id_direccion, @direccion_residencial_paciente, (SELECT id_distrito
                                                                                     FROM distritos
                                                                                     WHERE nombre_distrito = @distrito_reside_paciente));
                            SET @result = @result + @@ROWCOUNT;
                        END
                END
            ELSE
                BEGIN
                    -- Obtener el uuid de la dirección por defecto si es null
                    SELECT @id_direccion = id_direccion
                    FROM direcciones
                    WHERE direccion = 'Por registrar'
                      AND id_distrito = 0
                END

            -- Verificar si el paciente ya existe
            IF EXISTS (SELECT 1 FROM pacientes WHERE cedula = @cedula_paciente)
                BEGIN
                    -- Actualizar el paciente si ya existe y los datos son diferentes
                    UPDATE pacientes
                    SET nombre_paciente    = @nombre_paciente,
                        apellido1_paciente = @apellido1_paciente,
                        apellido2_paciente = @apellido1_paciente,
                        fecha_nacimiento   = @fecha_nacimiento_paciente,
                        sexo               = @sexo_paciente,
                        telefono_paciente  = @telefono_paciente,
                        correo_paciente    = @correo_paciente,
                        id_direccion       = @id_direccion
                    WHERE cedula = @cedula_paciente
                      AND (nombre_paciente != @nombre_paciente OR
                           apellido1_paciente != @apellido1_paciente OR
                           apellido2_paciente != @apellido2_paciente OR
                           fecha_nacimiento != @fecha_nacimiento_paciente OR
                           sexo != @sexo_paciente OR
                           telefono_paciente != @telefono_paciente OR
                           correo_paciente != @correo_paciente OR
                           id_direccion != @id_direccion);
                    SET @result = @result + @@ROWCOUNT;
                END
            ELSE
                BEGIN
                    -- Insertar el paciente si no existe
                    INSERT INTO pacientes (cedula, nombre_paciente, apellido1_paciente, apellido2_paciente,
                                           fecha_nacimiento,
                                           sexo, telefono_paciente, correo_paciente, id_direccion)
                    VALUES (@cedula_paciente, @nombre_paciente, @apellido1_paciente, @apellido2_paciente,
                            @fecha_nacimiento_paciente,
                            @sexo_paciente, @telefono_paciente, @correo_paciente, @id_direccion);
                    SET @result = @result + @@ROWCOUNT;
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

CREATE PROCEDURE sp_vacunas_insert_dosis(
    @cedula_paciente NVARCHAR(20),
    @fecha_aplicacion DATETIME,
    @numero_dosis CHAR(2),
    @uuid_vacuna UNIQUEIDENTIFIER = NULL,
    @nombre_vacuna NVARCHAR(100) = NULL,
    @uuid_sede UNIQUEIDENTIFIER = NULL,
    @nombre_sede NVARCHAR(100) = NULL,
    @lote NVARCHAR(10) = NULL,
    @result INT OUTPUT
)
AS
BEGIN
    BEGIN TRY
        SET NOCOUNT ON;
        SET @result = 0;
        -- validar los datos opcionales tengan mínimo 1 dato para cada tabla
        IF @nombre_vacuna IS NULL AND @uuid_vacuna IS NULL
            BEGIN
                RAISERROR ('Debe especificar la vacuna por uuid o nombre.', 16, 1);
            END

        IF @uuid_sede IS NULL AND @nombre_sede IS NULL
            BEGIN
                RAISERROR ('Debe especificar la sede por uuid o nombre.', 16, 1);
            END

        IF @nombre_vacuna IS NOT NULL
            BEGIN
                SELECT @uuid_vacuna = id_vacuna
                FROM vacunas
                WHERE nombre_vacuna = @nombre_vacuna;

                -- Verificar si se encontró la vacuna
                IF @uuid_vacuna IS NULL
                    BEGIN
                        RAISERROR (N'No se encontró ninguna vacuna con el nombre proporcionado.', 16, 1);
                    END
            END

        IF @nombre_sede IS NOT NULL
            BEGIN
                SELECT @uuid_sede = id_sede
                FROM sedes
                WHERE nombre_sede = @nombre_sede;

                -- Verificar si se encontró la vacuna
                IF @uuid_sede IS NULL
                    BEGIN
                        RAISERROR (N'No se encontró ninguna sede con el nombre proporcionado.', 16, 1);
                    END
            END

        -- Verificar si la vacuna existe
        IF NOT EXISTS (SELECT 1 FROM vacunas WHERE id_vacuna = @uuid_vacuna)
            BEGIN
                RAISERROR ('La vacuna especificada no existe.', 16, 1);
            END

        -- Verificar si la sede existe
        IF NOT EXISTS (SELECT 1 FROM sedes WHERE id_sede = @uuid_sede)
            BEGIN
                RAISERROR ('La sede especificada no existe.', 16, 1);
            END

        -- Verificar si el paciente existe
        IF NOT EXISTS (SELECT 1 FROM pacientes WHERE cedula = @cedula_paciente)
            BEGIN
                RAISERROR ('El paciente no existe.', 16, 1);
            END

        BEGIN TRANSACTION
            DECLARE @id_dosis UNIQUEIDENTIFIER = NEWID();

            -- Insertar la nueva dosis
            INSERT INTO Dosis (id_dosis, fecha_aplicacion, numero_dosis, id_vacuna, id_sede, lote_dosis)
            VALUES (@id_dosis, @fecha_aplicacion, @numero_dosis, @uuid_vacuna, @uuid_sede, @lote);
            SET @result = @result + @@ROWCOUNT;

            -- Insertar la relación en Paciente_Dosis
            INSERT INTO pacientes_dosis (cedula_paciente, id_dosis)
            VALUES (@cedula_paciente, @id_dosis);
            SET @result = @result + @@ROWCOUNT;
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

CREATE PROCEDURE sp_vacunas_distribuir_vacunas(
    @id_almacen SMALLINT = NULL,
    @nombre_almacen NVARCHAR(100) = NULL,
    @id_sede UNIQUEIDENTIFIER = NULL,
    @nombre_sede NVARCHAR(100) = NULL,
    @uuid_vacuna UNIQUEIDENTIFIER = NULL,
    @nombre_vacuna NVARCHAR(100) = NULL,
    @cantidad INT,
    @lote NVARCHAR(10),
    @fecha_distribucion DATETIME = NULL,
    @result INT OUTPUT
)
AS
BEGIN
    BEGIN TRY
        SET NOCOUNT ON;
        SET @result = 0;
        -- Validar que se ingresó al menos 1 valor requerido para cada tabla
        IF @id_almacen IS NULL AND @nombre_almacen IS NULL
            BEGIN
                RAISERROR ('Debe especificar el almacen por su id o nombre', 16, 1);
            END

        IF @nombre_vacuna IS NULL AND @uuid_vacuna IS NULL
            BEGIN
                RAISERROR ('Debe especificar la vacuna por uuid o nombre.', 16, 1);
            END

        IF @id_sede IS NULL AND @nombre_sede IS NULL
            BEGIN
                RAISERROR ('Debe especificar la sede por uuid o nombre.', 16, 1);
            END

        IF @nombre_almacen IS NOT NULL
            BEGIN
                SELECT @id_almacen = id_almacen
                FROM almacenes
                WHERE nombre_almacen = @nombre_almacen;

                -- Verificar si se encontró la vacuna
                IF @id_almacen IS NULL
                    BEGIN
                        RAISERROR (N'No se encontró ningún almacen con el nombre proporcionado.', 16, 1);
                    END
            END

        IF @nombre_vacuna IS NOT NULL
            BEGIN
                SELECT @uuid_vacuna = id_vacuna
                FROM vacunas
                WHERE nombre_vacuna = @nombre_vacuna;

                -- Verificar si se encontró la vacuna
                IF @uuid_vacuna IS NULL
                    BEGIN
                        RAISERROR (N'No se encontró ninguna vacuna con el nombre proporcionado.', 16, 1);
                    END
            END

        IF @nombre_sede IS NOT NULL
            BEGIN
                SELECT @id_sede = id_sede
                FROM sedes
                WHERE nombre_sede = @nombre_sede;

                -- Verificar si se encontró la vacuna
                IF @id_sede IS NULL
                    BEGIN
                        RAISERROR (N'No se encontró ninguna sede con el nombre proporcionado.', 16, 1);
                    END
            END

        IF @fecha_distribucion IS NULL
            SET @fecha_distribucion = CURRENT_TIMESTAMP;

        INSERT INTO distribuciones_vacunas (id_almacen, id_sede, id_vacuna, cantidad, lote, fecha_distribucion)
        VALUES (@id_almacen, @id_sede, @uuid_vacuna, @cantidad, @lote, @fecha_distribucion);

        SET @result = @result + @@ROWCOUNT;
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
END;
GO

CREATE PROCEDURE sp_vacunas_gestionar_usuario(
    @cedula NVARCHAR(20),
    @usuario NVARCHAR(50),
    @clave_hash NVARCHAR(60),
    @fecha_nacimiento DATETIME,
    @correo_usuario NVARCHAR(254) = NULL,
    @result INT OUTPUT
)
AS
BEGIN
    BEGIN TRY
        BEGIN TRANSACTION
            SET NOCOUNT ON;
            SET @result = 0;

            -- Verificar si el usuario ya existe
            IF EXISTS (SELECT 1 FROM usuarios WHERE cedula = @cedula)
                BEGIN
                    -- Si existe, actualizar el registro
                    UPDATE usuarios
                    SET usuario          = @usuario,
                        clave_hash       = @clave_hash,
                        fecha_nacimiento = @fecha_nacimiento,
                        correo_usuario   = @correo_usuario,
                        last_used        = CURRENT_TIMESTAMP
                    WHERE cedula = @cedula
                      AND (usuario != @usuario OR
                           clave_hash != @clave_hash OR
                           fecha_nacimiento != @fecha_nacimiento OR
                           correo_usuario != @correo_usuario);
                    SET @result = @result + @@ROWCOUNT;
                END
            ELSE
                BEGIN
                    -- Si no existe, insertar un nuevo registro
                    INSERT INTO Usuarios (cedula, usuario, clave_hash, fecha_nacimiento, correo_usuario)
                    VALUES (@Cedula, @Usuario, @clave_hash, @fecha_nacimiento, @correo_usuario);
                    SET @result = @result + @@ROWCOUNT;
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

CREATE PROCEDURE sp_vacunas_insert_roles_usuario(
    @cedula NVARCHAR(20),
    @roles NVARCHAR(MAX), -- cadena delimitada por comas los roles
    @result INT OUTPUT
)
AS
BEGIN
    BEGIN TRY
        SET NOCOUNT ON;
        SET @result = 0;
        DECLARE @id_usuario UNIQUEIDENTIFIER;
        DECLARE @roles_tabla TABLE
                             (
                                 id_rol INT
                             ); -- tabla temporal para almacenar la cadena de roles
        SELECT @id_usuario = id_usuario FROM usuarios WHERE cedula = @cedula
		IF @id_usuario IS NULL 
		BEGIN
			RAISERROR (N'No se ha encontrado el usuario con la cédula proporcionada', 16, 1);
		END
        BEGIN TRANSACTION
            -- Convertir la cadena delimitada en la tabla temporal
            INSERT INTO @roles_tabla (id_rol)
            SELECT value
            FROM string_split(@roles, ',')
            SET @result = @result + @@ROWCOUNT;

            -- Eliminar los roles existentes
            DELETE FROM usuarios_roles WHERE id_usuario = @id_usuario
            SET @result = @result + @@ROWCOUNT;

            -- Insertar los roles nuevos
            INSERT INTO usuarios_roles (id_usuario, id_rol)
            SELECT @id_usuario, id_rol
            FROM @roles_tabla
            SET @result = @result + @@ROWCOUNT;
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

CREATE PROCEDURE sp_vacunas_insert_vacuna_enfermedad(
    @uuid_vacuna UNIQUEIDENTIFIER = NULL,
    @nombre_vacuna NVARCHAR(100) = NULL,
    @id_enfermedad INT = NULL,
    @nombre_enfermedad NVARCHAR(100) = NULL,
    @result INT OUTPUT
)
AS
BEGIN
    BEGIN TRY
        SET NOCOUNT ON;
        SET @result = 0;
        -- Validar que se ingresó al menos 1 valor requerido para cada tabla
        IF @nombre_vacuna IS NULL AND @uuid_vacuna IS NULL
            BEGIN
                RAISERROR ('Debe especificar la vacuna por uuid o nombre.', 16, 1);
            END

        IF @nombre_enfermedad IS NULL AND @id_enfermedad IS NULL
            BEGIN
                RAISERROR ('Debe especificar la enfermedad por id o nombre.', 16, 1);
            END

        -- Obtener uuid_vacuna si se proporcionó nombre_vacuna
        IF @nombre_vacuna IS NOT NULL
            BEGIN
                SELECT @uuid_vacuna = id_vacuna
                FROM vacunas
                WHERE nombre_vacuna = @nombre_vacuna;

                -- Verificar si se encontró la vacuna
                IF @uuid_vacuna IS NULL
                    BEGIN
                        RAISERROR (N'No se encontró ninguna vacuna con el nombre proporcionado.', 16, 1);
                    END
            END

        -- Obtener id_enfermedad si se proporcionó nombre_enfermedad
        IF @nombre_enfermedad IS NOT NULL
            BEGIN
                SELECT @id_enfermedad = id_enfermedad FROM enfermedadeS WHERE nombre_enfermedad = @nombre_enfermedad

                IF @id_enfermedad IS NULL
                    BEGIN
                        RAISERROR (N'No se encontró ninguna enfermedad con el nombre proporcionado.', 16, 1);
                    END
            END

        BEGIN TRANSACTION
            INSERT INTO vacunas_enfermedades (id_vacuna, id_enfermedad)
            VALUES (@uuid_vacuna, @id_enfermedad);
            SET @result = @result + @@ROWCOUNT;
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
END
GO

CREATE PROCEDURE sp_vacunas_insert_fabricante_vacuna(
    @id_fabricante INT = NULL,
    @nombre_fabricante NVARCHAR(100) = NULL,
    @uuid_vacuna UNIQUEIDENTIFIER = NULL,
    @nombre_vacuna NVARCHAR(100) = NULL,
    @result INT OUTPUT
)
AS
BEGIN
    BEGIN TRY
        SET NOCOUNT ON;
        SET @result = 0;
        -- validar que se ingresó al menos 1 valor requerido para cada tabla
        IF @id_fabricante IS NULL AND @nombre_fabricante IS NULL
            BEGIN
                RAISERROR ('Debe especificar un fabricante por su id o nombre.', 16, 1);
            END

        IF @nombre_vacuna IS NULL AND @uuid_vacuna IS NULL
            BEGIN
                RAISERROR ('Debe especificar la vacuna por uuid o nombre.', 16, 1);
            END

        -- Obtener id_fabricante si se proporcionó nombre_fabricante
        IF @nombre_fabricante IS NOT NULL
            BEGIN
                SELECT @id_fabricante = id_fabricante FROM fabricantes WHERE nombre_fabricante = @nombre_fabricante;

                IF @id_fabricante IS NULL
                    BEGIN
                        RAISERROR (N'No se encontró ningún fabricante con el nombre proporcionado.', 16, 1);
                    END
            END

        -- Obtener uuid_vacuna si se proporcionó nombre_vacuna
        IF @nombre_vacuna IS NOT NULL
            BEGIN
                SELECT @uuid_vacuna = id_vacuna
                FROM vacunas
                WHERE nombre_vacuna = @nombre_vacuna;

                -- Verificar si se encontró la vacuna
                IF @uuid_vacuna IS NULL
                    BEGIN
                        RAISERROR (N'No se encontró ninguna vacuna con el nombre proporcionado.', 16, 1);
                    END
            END

        BEGIN TRANSACTION
            INSERT INTO fabricantes_vacunas(id_fabricante, id_vacuna)
            VALUES (@id_fabricante, @uuid_vacuna);
            SET @result = @result + @@ROWCOUNT;
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
END
GO

CREATE PROCEDURE sp_vacunas_insert_almacen_inventario(
    @id_almacen SMALLINT = NULL,
    @nombre_almacen NVARCHAR(100) = NULL,
    @uuid_vacuna UNIQUEIDENTIFIER = NULL,
    @nombre_vacuna NVARCHAR(100) = NULL,
    @cantidad INT,
    @fecha_expiracion_lote DATETIME,
    @lote_almacen NVARCHAR(10),
    @result INT OUTPUT
)
AS
BEGIN
    BEGIN TRY
        SET NOCOUNT ON;
        SET @result = 0;
        -- Validar que se ingresó al menos 1 valor requerido para cada tabla
        IF @id_almacen IS NULL AND @nombre_almacen IS NULL
            BEGIN
                RAISERROR ('Debe especificar el almacen por su id o nombre', 16, 1);
            END

        IF @nombre_vacuna IS NULL AND @uuid_vacuna IS NULL
            BEGIN
                RAISERROR ('Debe especificar la vacuna por uuid o nombre.', 16, 1);
            END

        IF @nombre_almacen IS NOT NULL
            BEGIN
                SELECT @id_almacen = id_almacen
                FROM almacenes
                WHERE nombre_almacen = @nombre_almacen;

                -- Verificar si se encontró la vacuna
                IF @id_almacen IS NULL
                    BEGIN
                        RAISERROR (N'No se encontró ningún almacen con el nombre proporcionado.', 16, 1);
                    END
            END

        IF @nombre_vacuna IS NOT NULL
            BEGIN
                SELECT @uuid_vacuna = id_vacuna
                FROM vacunas
                WHERE nombre_vacuna = @nombre_vacuna;

                -- Verificar si se encontró la vacuna
                IF @uuid_vacuna IS NULL
                    BEGIN
                        RAISERROR (N'No se encontró ninguna vacuna con el nombre proporcionado.', 16, 1);
                    END
            END

        IF @fecha_expiracion_lote <= CURRENT_TIMESTAMP
            BEGIN
                RAISERROR ('La fecha de vencimiento del lote de la vacuna no puede ser pasada.', 16, 1);
            END

        BEGIN TRANSACTION
            INSERT INTO almacenes_inventarios (id_almacen, id_vacuna, cantidad, fecha_expiracion_almacen, lote_almacen)
            VALUES (@id_almacen, @uuid_vacuna, @cantidad, @fecha_expiracion_lote, @lote_almacen);
            SET @result = @result + @@ROWCOUNT;
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
END
GO

PRINT (N'Creando funciones');
GO
-- Funciones
CREATE FUNCTION fn_vacunas_get_paciente_by_full_name(
    @nombre_completo NVARCHAR(100) = NULL
)
    RETURNS TABLE
        AS
        RETURN(SELECT*
               FROM pacientes
               WHERE CONCAT(nombre_paciente, SPACE(1), apellido1_paciente) = @nombre_completo);
GO

CREATE FUNCTION fn_vacunas_find_fabricante(
    @id_fabricante INT = NULL,
    @id_vacuna UNIQUEIDENTIFIER = NULL
)
    RETURNS TABLE
        AS
        RETURN(SELECT f.id_fabricante,
                      f.nombre_fabricante,
                      f.telefono_fabricante,
                      f.correo_fabricante,
                      f.direccion_fabricante,
                      f.contacto_fabricante
               FROM fabricantes f
                        LEFT JOIN
                    fabricantes_vacunas fv ON f.id_fabricante = fv.id_fabricante
               WHERE (f.id_fabricante = @id_fabricante OR @id_fabricante IS NULL)
                 AND (fv.id_vacuna = @id_vacuna OR @id_vacuna IS NULL));
GO

CREATE FUNCTION fn_vacunas_find_dosis(
    @id_vacuna UNIQUEIDENTIFIER = NULL,
    @cedula_paciente NVARCHAR(20) = NULL,
    @numero_dosis CHAR(2) = NULL,
    @fecha_aplicacion DATETIME = NULL,
    @id_sede UNIQUEIDENTIFIER = NULL
)
    RETURNS TABLE
        AS
        RETURN(SELECT d.id_dosis,
                      d.fecha_aplicacion,
                      d.numero_dosis,
                      d.id_vacuna,
                      d.id_sede
               FROM dosis d
                        LEFT JOIN
                    pacientes_dosis pd ON d.id_dosis = pd.id_dosis
               WHERE (d.id_vacuna = @id_vacuna OR @id_vacuna IS NULL)
                 AND (pd.cedula_paciente = @cedula_paciente OR @cedula_paciente IS NULL)
                 AND (d.numero_dosis = @numero_dosis OR @numero_dosis IS NULL)
                 AND (d.fecha_aplicacion = @fecha_aplicacion OR @fecha_aplicacion IS NULL)
                 AND (d.id_sede = @id_sede OR @id_sede IS NULL));
GO

CREATE FUNCTION fn_vacunas_get_usuarios_by_cedula(@cedula NVARCHAR(20))
    RETURNS TABLE
        AS
        RETURN(SELECT u.id_usuario,
                      cedula,
                      usuario,
                      fecha_nacimiento,
                      correo_usuario,
                      created_at,
                      r.id_rol,
                      nombre_rol
               FROM usuarios u
                        INNER JOIN usuarios_roles r ON u.id_usuario = r.id_usuario
                        INNER JOIN roles ON r.id_rol = roles.id_rol
               WHERE cedula = @cedula);
GO

-- Vistas
/* ejemplo de uso
SELECT
    Provincia,
    COUNT(*) AS TotalVacunas
FROM
    [Reporte Vacunas Completo]
GROUP BY
    Provincia;
*/

/* ejemplo de uso
SELECT Vacuna, Cantidad, Lote, [Fecha Lote]  FROM [Sede - Inventario]
WHERE ID_Sede = 1
*/
PRINT (N'Creando vistas');
GO
CREATE VIEW view_pacientes_vacunas_enfermedades AS
SELECT p.cedula                      AS 'Cédula',
       p.nombre_paciente             AS 'Nombre',
       p.apellido1_paciente          AS 'Apellido 1',
       p.apellido2_paciente          AS 'Apellido 2',
       p.fecha_nacimiento            AS 'Fecha de Nacimiento',
       p.edad_calculada              AS 'Edad',
       p.sexo                        AS 'Sexo',
       p.telefono_paciente           AS 'Teléfono',
       p.correo_paciente             AS 'Correo electrónico',
       d.direccion                   AS 'Dirección residencia actual',
       dis.nombre_distrito           AS 'Distrito',
       prov.nombre_provincia         AS 'Provincia',
       vac.nombre_vacuna             AS 'Nombre vacuna',
       dos.numero_dosis              AS 'Número de dosis',
       e.nombre_enfermedad           AS 'Enfermedad previene',
       vac.edad_minima_meses         AS 'Edad mínima recomendada en meses',
       dos.fecha_aplicacion          AS 'Fecha de aplicación',
       vac.intervalo_dosis_1_2_meses AS 'Intervalo recomendado entre dosis 1 y 2 en meses',
       s.nombre_sede                 AS 'Sede',
       s.dependencia_sede            AS 'Dependencia'
FROM pacientes p
         JOIN pacientes_dosis pd ON p.cedula = pd.cedula_paciente
         JOIN dosis dos ON pd.id_dosis = dos.id_dosis
         JOIN vacunas vac ON dos.id_vacuna = vac.id_vacuna
         LEFT JOIN vacunas_enfermedades ve ON vac.id_vacuna = ve.id_vacuna
         LEFT JOIN enfermedades e ON ve.id_enfermedad = e.id_enfermedad
         LEFT JOIN sedes s ON dos.id_sede = s.id_sede
         LEFT JOIN direcciones d ON p.id_direccion = d.id_direccion
         LEFT JOIN distritos dis ON d.id_distrito = dis.id_distrito
         LEFT JOIN provincias prov ON dis.id_provincia = prov.id_provincia;
GO

CREATE VIEW view_pacientes_detalles AS
SELECT p.cedula                      AS 'Cédula',
       p.nombre_paciente             AS 'Nombre',
       p.apellido1_paciente          AS 'Apellido 1',
       p.apellido1_paciente          AS 'Apellido 2',
       p.fecha_nacimiento            AS 'Fecha de Nacimiento',
       p.edad_calculada              AS 'Edad',
       p.sexo                        AS 'Sexo',
       p.telefono_paciente           AS 'Teléfono',
       p.correo_paciente             AS 'Correo electrónico',
       d.direccion                   AS 'Dirección residencia actual',
       dis.nombre_distrito           AS 'Distrito',
       prov.nombre_provincia         AS 'Provincia',
       vac.id_vacuna                 AS 'ID Vacuna',
       vac.nombre_vacuna             AS 'Nombre vacuna',
       pp.nombre_fabricante          AS 'Fabricante',
       dos.fecha_aplicacion          AS 'Fecha de aplicación',
       s.id_sede                     AS 'ID Sede',
       s.nombre_sede                 AS 'Sede',
       s.dependencia_sede            AS 'Dependencia',
       dos.numero_dosis              AS 'Número de dosis',
       vac.intervalo_dosis_1_2_meses AS 'Intervalo dosis 1 y 2 recomendado en meses',
       DATEDIFF(DAY, dos.fecha_aplicacion,
                (SELECT MAX(dos2.fecha_aplicacion)
                 FROM dosis dos2
                          JOIN pacientes_dosis pd2 ON dos2.id_dosis = pd2.id_dosis
                 WHERE pd2.cedula_paciente = p.cedula
                   AND dos2.id_vacuna = dos.id_vacuna
                   AND dos2.numero_dosis > dos.numero_dosis))
                                     AS 'Intervalo real en días',
       vac.edad_minima_meses         AS 'Edad mínima recomendada en meses'
FROM pacientes p
         JOIN pacientes_dosis pd ON p.cedula = pd.cedula_paciente
         JOIN dosis dos ON pd.id_dosis = dos.id_dosis
         JOIN vacunas vac ON dos.id_vacuna = vac.id_vacuna
         LEFT JOIN fabricantes_vacunas pv ON vac.id_vacuna = pv.id_vacuna
         LEFT JOIN fabricantes pp ON pv.id_fabricante = pp.id_fabricante
         LEFT JOIN sedes s ON dos.id_sede = s.id_sede
         LEFT JOIN direcciones d ON p.id_direccion = d.id_direccion
         LEFT JOIN distritos dis ON d.id_distrito = dis.id_distrito
         LEFT JOIN provincias prov ON dis.id_provincia = prov.id_provincia;
GO

CREATE VIEW view_pacientes_usuarios AS
SELECT p.cedula              AS 'Cédula',
       p.nombre_paciente     AS 'Nombre',
       p.apellido1_paciente  AS 'Apellido 1',
       p.apellido2_paciente  AS 'Apellido 2',
       p.fecha_nacimiento    AS 'Fecha de nacimiento paciente',
       p.edad_calculada      AS 'Edad',
       p.sexo                AS 'Sexo',
       p.telefono_paciente   AS 'Teléfono',
       p.correo_paciente     AS 'Correo electrónico paciente',
       d.direccion           AS 'Dirección residencia actual',
       dis.nombre_distrito   AS 'Distrito',
       prov.nombre_provincia AS 'Provincia',
       u.usuario             AS 'Usuario',
       u.correo_usuario      AS 'Correo electrónico usuario',
       u.fecha_nacimiento    AS 'Fecha de nacimiento usuario'
FROM pacientes p
         LEFT JOIN direcciones d ON p.id_direccion = d.id_direccion
         LEFT JOIN distritos dis ON d.id_distrito = dis.id_distrito
         LEFT JOIN provincias prov ON dis.id_provincia = prov.id_provincia
         LEFT JOIN usuarios u ON p.cedula = u.cedula;
GO

CREATE VIEW view_pacientes_completos AS
SELECT p.cedula                      AS 'Cédula paciente',
       p.nombre_paciente             AS 'Nombre paciente',
       p.apellido1_paciente          AS 'Apellido 1 paciente',
       p.apellido2_paciente          AS 'Apellido 2 paciente',
       p.fecha_nacimiento            AS 'Fecha de nacimiento paciente',
       p.edad_calculada              AS 'Edad',
       p.sexo                        AS 'Sexo',
       p.telefono_paciente           AS 'Teléfono paciente',
       p.correo_paciente             AS 'Correo electrónico paciente',
       d.direccion                   AS 'Dirección residencial actual paciente',
       dis.nombre_distrito           AS 'Distrito paciente',
       prov.nombre_provincia         AS 'Provincia paciente',
       s.nombre_sede                 AS 'Sede vacunado',
       d2.direccion                  AS 'Dirección sede',
       dis2.nombre_distrito          AS 'Distrito sede',
       prov2.nombre_provincia        AS 'Provincia sede',
       s.telefono_sede               AS 'Teléfono sede',
       s.region                      AS 'Región de salud sede',
       s.dependencia_sede            AS 'Depedencia sede',
       vac.nombre_vacuna             AS 'Nombre vacuna',
       dos.fecha_aplicacion          AS 'Fecha de aplicación',
       dos.numero_dosis              AS 'Número de dosis aplicada',
       vac.intervalo_dosis_1_2_meses AS 'Intervalo dosis recomendado en meses',
       DATEDIFF(DAY, dos.fecha_aplicacion,
                (SELECT MAX(dos2.fecha_aplicacion)
                 FROM dosis dos2
                          JOIN pacientes_dosis pd2 ON dos2.id_dosis = pd2.id_dosis
                 WHERE pd2.cedula_paciente = p.cedula
                   AND dos2.id_vacuna = dos.id_vacuna
                   AND dos2.numero_dosis > dos.numero_dosis))
                                     AS 'Intervalo real en días',
       vac.edad_minima_meses         AS 'Edad mínima recomendada en meses',
       e.nombre_enfermedad           AS 'Enfermedad prevenida',
       e.nivel_gravedad              AS 'Nivel de gravedad enfermedad'
FROM pacientes p
         LEFT JOIN direcciones d ON p.id_direccion = d.id_direccion
         LEFT JOIN distritos dis ON d.id_distrito = dis.id_distrito
         LEFT JOIN provincias prov ON dis.id_provincia = prov.id_provincia
         LEFT JOIN pacientes_dosis pd ON p.cedula = pd.cedula_paciente
         LEFT JOIN dosis dos ON pd.id_dosis = dos.id_dosis
         LEFT JOIN vacunas vac ON dos.id_vacuna = vac.id_vacuna
         LEFT JOIN vacunas_enfermedades ve ON vac.id_vacuna = ve.id_vacuna
         LEFT JOIN enfermedades e ON ve.id_enfermedad = e.id_enfermedad
         LEFT JOIN sedes s ON dos.id_sede = s.id_sede
         LEFT JOIN direcciones d2 ON s.id_direccion = d2.id_direccion
         LEFT JOIN distritos dis2 ON d2.id_distrito = dis2.id_distrito
         LEFT JOIN provincias prov2 ON dis2.id_provincia = prov2.id_provincia;
GO

CREATE VIEW view_fabricantes_vacunas AS
SELECT p.nombre_fabricante         AS 'Nombre fabricante',
       v.nombre_vacuna             AS 'Vacuna ofrecida',
       v.edad_minima_meses         AS 'Edad mínima recomendada en meses',
       v.intervalo_dosis_1_2_meses AS 'Intervalo recomendado dosis 1 y 2 en meses',
       e.nombre_enfermedad         AS 'Enfermedad que previene',
       e.nivel_gravedad            AS 'Nivel de gravedad enfermedad'
FROM fabricantes p
         JOIN fabricantes_vacunas pv ON pv.id_fabricante = p.id_fabricante
         JOIN vacunas v ON pv.id_vacuna = v.id_vacuna
         LEFT JOIN vacunas_enfermedades ve ON v.id_vacuna = ve.id_vacuna
         LEFT JOIN enfermedades e ON ve.id_enfermedad = e.id_enfermedad;
GO

CREATE VIEW view_reporte_vacunas AS
SELECT p.cedula                    AS cedula_paciente,
       p.nombre_paciente           AS nombre_paciente,
       p.apellido1_paciente        AS apellido1_paciente,
       p.apellido2_paciente        AS apellido2_paciente,
       p.fecha_nacimiento          AS fecha_nacimiento_paciente,
       p.sexo                      AS sexo_paciente,
       p.telefono_paciente         AS telefono_paciente,
       p.correo_paciente           AS correo_paciente,
       v.nombre_vacuna             AS nombre_vacuna,
       d.fecha_aplicacion          AS fecha_aplicacion,
       d.numero_dosis              AS numero_dosis,
       v.intervalo_dosis_1_2_meses AS intervalo_dosis_recomendado_en_meses,
       DATEDIFF(DAY, d.fecha_aplicacion,
                (SELECT MAX(dos2.fecha_aplicacion)
                 FROM dosis dos2
                          JOIN pacientes_dosis pd2 ON dos2.id_dosis = pd2.id_dosis
                 WHERE pd2.cedula_paciente = p.cedula
                   AND dos2.id_vacuna = d.id_vacuna
                   AND dos2.numero_dosis > d.numero_dosis))
                                   AS intervalo_real_en_dias,
       v.edad_minima_meses         AS edad_minima_recomendada_en_meses,
       s.id_sede                   AS id_sede,
       s.nombre_sede               AS nombre_sede,
       dir.direccion               AS direccion_sede,
       dis.nombre_distrito         AS distrito,
       prov.nombre_provincia       AS provincia
FROM pacientes p
         JOIN pacientes_dosis pd ON p.cedula = pd.cedula_paciente
         JOIN dosis d ON pd.id_dosis = d.id_dosis
         JOIN vacunas v ON d.id_vacuna = v.id_vacuna
         JOIN sedes s ON d.id_sede = s.id_sede
         LEFT JOIN direcciones dir ON s.id_direccion = dir.id_direccion
         LEFT JOIN distritos dis ON dir.id_distrito = dis.id_distrito
         LEFT JOIN provincias prov ON dis.id_provincia = prov.id_provincia;
GO

CREATE VIEW view_enfermedades_sintomas AS
SELECT v.nombre_vacuna     AS vacuna,
       e.nombre_enfermedad AS enfermedad_prevenida,
       e.nivel_gravedad    AS nivel_gravedad_enfermedad,
       s.nombre_sintoma    AS sintomas_enfermedad
FROM vacunas_enfermedades ve
         LEFT JOIN vacunas v ON ve.id_vacuna = v.id_vacuna
         LEFT JOIN enfermedades e ON ve.id_enfermedad = e.id_enfermedad
         LEFT JOIN enfermedades_sintomas es ON e.id_enfermedad = es.id_enfermedad
         LEFT JOIN sintomas s ON es.id_sintoma = s.id_sintoma;
GO

CREATE VIEW view_sedes_inventarios AS
SELECT s.id_sede,
       s.nombre_sede            AS nombre_sede,
       s.dependencia_sede       AS dependencia_sede,
       v.id_vacuna              AS id_vacuna,
       v.nombre_vacuna          AS vacuna,
       si.cantidad              AS cantidad,
       si.lote_sede             AS lote,
       si.fecha_expiracion_sede AS fecha_expiracion_sede
FROM sedes_inventarios si
         INNER JOIN sedes s ON si.id_sede = s.id_sede
         INNER JOIN vacunas v ON si.id_vacuna = v.id_vacuna;
GO

PRINT (N'Creación de objetos finalizada!');
PRINT (N'Insertando datos globales');
GO
INSERT INTO provincias(nombre_provincia)
VALUES ('Por registrar' /*0*/),
       ('Bocas del Toro'), /*1*/
       (N'Coclé'), /*2*/
       (N'Colón'), /*3*/
       (N'Chiriquí'), /*4*/
       (N'Darién'), /*5*/
       ('Herrera'), /*6*/
       ('Los Santos'), /*7*/
       (N'Panamá'), /*8*/
       ('Veraguas'), /*9*/
       ('Guna Yala'), /*10*/
       (N'Emberá-Wounaan'), /*11*/
       (N'Ngäbe-Buglé'),/*12*/
       (N'Panamá Oeste'), /*13*/
       (N'Naso Tjër Di'), /*14*/
       (N'Guna de Madugandí'), /*15*/
       (N'Guna de Wargandí'); /*16*/
GO
INSERT INTO distritos(nombre_distrito, id_provincia)
VALUES ('Por registrar', 0),
       ('Aguadulce', 2),
       ('Alanje', 4),
       ('Almirante', 1),
       (N'Antón', 2),
       (N'Arraiján', 13),
       ('Atalaya', 9),
       ('Balboa', 8),
       (N'Barú', 4),
       (N'Besikó', 12),
       ('Bocas del Toro', 1),
       (N'Boquerón', 4),
       ('Boquete', 4),
       ('Bugaba', 4),
       ('Calobre', 9),
       (N'Calovébora', 12),
       (N'Cañazas', 9),
       ('Capira', 13),
       ('Chagres', 3),
       ('Chame', 13),
       ('Changuinola', 1),
       ('Chepigana', 5),
       ('Chepo', 8),
       (N'Chimán', 8),
       (N'Chiriquí Grande', 1),
       (N'Chitré', 6),
       (N'Colón', 3),
       (N'Cémaco', 11),
       ('David', 4),
       ('Donoso', 3),
       ('Dolega', 4),
       ('Gualaca', 4),
       (N'Guararé', 7),
       (N'Guna de Wargandí', 5),
       ('Jirondai', 12),
       (N'Kankintú', 12),
       (N'Kusapín', 12),
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
       (N'Mironó', 12),
       ('Montijo', 9),
       (N'Müna', 12),
       (N'Natá', 2),
       ('Nole Duima', 12),
       (N'Ñürüm', 12),
       (N'Ocú', 6),
       (N'Olá', 2),
       ('Omar Torrijos Herrera', 3),
       (N'Panamá', 8),
       ('Parita', 6),
       (N'Pedasí', 7),
       (N'Penonomé', 2),
       (N'Pesé', 6),
       ('Pinogana', 5),
       (N'Pocrí', 7),
       ('Portobelo', 3),
       ('Remedios', 4),
       ('Renacimiento', 4),
       (N'Río de Jesús', 9),
       (N'Sambú', 11),
       ('San Carlos', 13),
       (N'San Félix', 4),
       ('San Francisco', 9),
       ('San Lorenzo', 4),
       ('San Miguelito', 8),
       ('Santa Catalina', 12),
       ('Santa Fe', 5),
       ('Santa Fe', 9),
       ('Santa Isabel', 3),
       (N'Santa María', 6),
       ('Santiago', 9),
       (N'Soná', 9),
       ('Taboga', 8),
       ('Tierras Altas', 4),
       (N'Tolé', 4),
       (N'Tonosí', 7),
       (N'Naso Tjër Di', 14)
GO
INSERT INTO direcciones (direccion, id_distrito)
VALUES ('Por registrar', 0);
GO
PRINT (N'Insertando sede por defecto');
GO
EXEC sp_vacunas_insert_sede 'Por registrar', 'Por registrar', NULL, NULL, NULL, NULL, NULL;
GO
INSERT INTO enfermedades (nombre_enfermedad, nivel_gravedad)
VALUES ('Desconocida', NULL),
       ('Bacteriemia', 'Alta'),
       ('COVID-19', 'Alta'),
       ('Difteria', 'Alta'),
       (N'Enfermedad meningocócica', 'Alta'),
       (N'Enfermedades neumocócicas', 'Alta'),
       ('Fiebre Amarilla', 'Alta'),
       ('Hepatitis A', 'Moderada'),
       ('Hepatitis B', 'Moderada'),
       ('Hib (Haemophilus influenzae tipo b)', 'Alta'),
       ('Influenza (Gripe)', 'Moderada'),
       ('Meningitis', 'Alta'),
       (N'Neumonía', 'Moderada'),
       ('Paperas', 'Moderada'),
       ('Poliomelitis (Polio)', 'Alta'),
       ('Rabia', 'Alta'),
       ('Rotavirus', 'Moderada'),
       (N'Rubéola', 'Moderada'),
       (N'Sarampión', 'Alta'),
       (N'Tétanos', 'Alta'),
       ('Tos ferina', 'Alta'),
       ('Tuberculosis', 'Alta'),
       ('Varicela', 'Moderada'),
       ('Virus del papiloma humano (VPH)', 'Moderada');
GO
INSERT INTO sintomas (nombre_sintoma)
VALUES ('Desconocido'),
       ('Ataques de tos'),
       (N'Cáncer de cuello uterino'),
       (N'Confusión'),
       ('Conjuntivitis'),
       ('Convulsiones'),
       ('Diarrea grave'),
       ('Dificultad para respirar'),
       ('Dolor abdominal'),
       ('Dolor de cabeza'),
       ('Dolor de garganta'),
       (N'Dolor e hinchazón en las glándulas salivales'),
       ('Dolor en el pecho'),
       ('Dolor muscular'),
       (N'Erupción cutánea característica'),
       (N'Escalofríos'),
       ('Espasmos'),
       ('Fatiga'),
       ('Fiebre'),
       (N'Formación de una membrana gruesa en la garganta'),
       ('Ganglios inflamados'),
       ('Ictericia'),
       (N'Infección de la sangre'),
       ('Meningitis'),
       (N'Náuseas'),
       (N'Neumonía'),
       ('Orina oscura'),
       (N'Otros tipos de cáncer'),
       (N'Parálisis'),
       (N'Pérdida de peso'),
       (N'Pérdida del gusto o olfato'),
       (N'Picazón'),
       ('Poco apetito'),
       ('Rigidez en el cuello'),
       ('Rigidez muscular'),
       (N'Secreción nasal'),
       ('Sensibilidad a la luz'),
       ('Sepsis'),
       ('Sudores nocturnos'),
       ('Tos intensa y persistente'),
       ('Tos persistente'),
       ('Tos');
GO
INSERT INTO enfermedades_sintomas (id_enfermedad, id_sintoma)
VALUES
-- Enfermedad desconocida
(0, 0),   -- Síntomas desconocido
-- usado para registrar posteriormente la vacuna - enfermedad donde una vacuna por registrar tendrá su enfermedad desconocida y síntomas desconocidos

-- Bacteriemia
(1, 18),  -- Fiebre
(1, 16),  -- Escalofríos
(1, 35),  -- Sepsis

-- COVID-19
(2, 18),  -- Fiebre
(2, 40),  -- Tos persistente
(2, 7),   -- Dificultad para respirar
(2, 16),  -- Fatiga
(2, 29),  -- Pérdida del gusto o olfato
(2, 13),  -- Dolor muscular
(2, 9),   -- Dolor de cabeza

-- Difteria
(3, 18),  -- Fiebre
(3, 10),  -- Dolor de garganta
(3, 19),  -- Formación de una membrana gruesa en la garganta
(3, 7),   -- Dificultad para tragar
(3, 20),  -- Ganglios inflamados

-- Enfermedad meningocócica
(4, 18),  -- Fiebre
(4, 9),   -- Dolor de cabeza
(4, 31),  -- Rigidez en el cuello
(4, 3),   -- Confusión
(4, 32),  -- Sensibilidad a la luz
(4, 4),   -- Convulsiones

-- Enfermedades neumocócicas
(5, 18),  -- Fiebre
(5, 9),   -- Dolor de cabeza
(5, 31),  -- Rigidez en el cuello
(5, 3),   -- Confusión
(5, 32),  -- Sensibilidad a la luz
(5, 35),  -- Sepsis

-- Fiebre Amarilla
(6, 18),  -- Fiebre
(6, 21),  -- Ictericia
(6, 13),  -- Dolor muscular
(6, 22),  -- Náuseas
(6, 23),  -- Vómito
(6, 16),  -- Fatiga

-- Hepatitis A
(7, 18),  -- Fiebre
(7, 16),  -- Fatiga
(7, 7),   -- Dolor abdominal
(7, 24),  -- Orina oscura
(7, 21),  -- Ictericia
(7, 22),  -- Náuseas
(7, 23),  -- Vómito
(7, 31),  -- Poco apetito

-- Hepatitis B
(8, 18),  -- Fiebre
(8, 16),  -- Fatiga
(8, 7),   -- Dolor abdominal
(8, 24),  -- Orina oscura
(8, 21),  -- Ictericia
(8, 22),  -- Náuseas
(8, 23),  -- Vómito
(8, 31),  -- Poco apetito

-- Hib (Haemophilus influenzae tipo b)
(9, 18),  -- Fiebre
(9, 25),  -- Meningitis
(9, 26),  -- Neumonía
(9, 27),  -- Infección de la sangre

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
(11, 3),  -- Confusión
(11, 32), -- Sensibilidad a la luz
(11, 4),  -- Convulsiones

-- Neumonía
(12, 18), -- Fiebre
(12, 7),  -- Dificultad para respirar
(12, 41), -- Tos
(12, 11), -- Dolor en el pecho

-- Paperas
(13, 18), -- Fiebre
(13, 11), -- Dolor e hinchazón en las glándulas salivales
(13, 9),  -- Dolor de cabeza
(13, 16), -- Fatiga

-- Poliomelitis (Polio)
(14, 18), -- Fiebre
(14, 16), -- Fatiga
(14, 9),  -- Dolor de cabeza
(14, 31), -- Rigidez en el cuello
(14, 24), -- Parálisis

-- Rabia
(15, 18), -- Fiebre
(15, 9),  -- Dolor de cabeza
(15, 15), -- Espasmos
(15, 3),  -- Confusión
(15, 24), -- Parálisis

-- Rotavirus
(16, 6),  -- Diarrea grave
(16, 23), -- Vómito
(16, 18), -- Fiebre
(16, 7),  -- Dolor abdominal

-- Rubéola
(17, 18), -- Fiebre
(17, 12), -- Erupción cutánea característica
(17, 20), -- Ganglios inflamados

-- Sarampión
(18, 18), -- Fiebre
(18, 12), -- Erupción cutánea característica
(18, 41), -- Tos
(18, 34), -- Secreción nasal
(18, 3),  -- Conjuntivitis

-- Tétanos
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
(21, 28), -- Pérdida de peso
(21, 6),  -- Escalofríos
(21, 36), -- Sudores nocturnos

-- Varicela
(22, 18), -- Fiebre
(22, 12), -- Erupción cutánea característica
(22, 31), -- Picazón
(22, 16), -- Fatiga

-- Virus del papiloma humano (VPH)
(23, 37), -- Verrugas genitales
(23, 1),  -- Cáncer de cuello uterino
(23, 24); -- Otros tipos de cáncer
GO
-- por defecto estos roles con permisos
INSERT INTO roles (nombre_rol, descripcion_rol)
VALUES ('Paciente', N'Usuario que recibe tratamiento y consulta información médica.'),
       ('Fabricante', 'Persona o empresa que produce o distribuye vacunas.'),
       ('Doctor', N'Profesional médico que diagnostica y trata a los pacientes.'),
       ('Enfermera', N'Especialista en cuidados y asistencia directa a pacientes.'),
       ('Administrativo', N'Responsable de la atención, gestión, planificación de la institución.'),
       ('Autoridad', N'Persona con poderes decisionales y supervisión en la institución.'),
       ('Developer', 'Administra y desarrolla aplicaciones, bases de datos y sistemas.')
GO
INSERT INTO permisos (nombre_permiso, descripcion_permiso)
VALUES ('PACIENTE_READ', N'Permite leer datos básicos de pacientes y sus referencias médicas.'),
       ('MED_READ', N'Permite leer datos médicos detallados de pacientes.'),
       ('MED_WRITE', N'Permite añadir o modificar datos médicos.'),
       ('USER_MANAGER_WRITE', N'Permite gestionar los usuarios, sin incluir restricciones a los mismos.'),
       ('USER_MANAGER_READ', 'Permite leer los datos de los usuarios.'),
       ('FABRICANTE_READ', 'Permite leer los datos generales del fabricante de vacunas.'),
       ('FABRICANTE_WRITE',
        N'Permite gestionar datos relacionados a las vacunas ofrecidos y referencias médicas de las mismas.'),
       ('ADMINISTRATIVO_WRITE', N'Permite gestionar usuarios y configuraciones de enfermedades, síntomas y vacunas.'),
       ('AUTORIDAD_READ', N'Permite supervisar todos los datos.'),
       ('AUTORIDAD_WRITE', N'Permite modificar todos los datos sin restricciones de lógica del negocio o permisos.'),
       ('DEV_DB_ADMIN', N'Permite administrar, configurar y desarollar la base de datos.'),
       ('GUEST_READ', N'Permite leer datos generales de la base de datos. Información no sensitiva ni confidencial.')
GO
/*
Aclaraciones:
- Diferencia entre ADMINISTRATIVO_WRITE y MED_WRITE, radica en poder gestionar las categorías padre llamase Vacunas, sus enfermedades y síntomas.
  MED unicamente puede gestionar las dosis de las categorías ya creadas, dando la posibilidad de usar 'Por registrar' para el rol correspondiente corrija.
- Diferencia entre ADMINISTRATIVO_WRITE y USER_MANAGER_WRITE, ambos roles permiten modificar usuarios, pero administrativo puede deshabilitar un usuario y sus roles.
  Ninguno puede crear usuarios ya que es una facultad de las aplicaciones o sistemas que implementan automáticamente el hash de contraseñas y otorga roles ya definidos.
- Diferencia entre AUTORIDAD_WRITE y DEV_DB_ADMIN es directamente en crear datos sin restricciones, los dev pueden modificar la estructura más no los datos.
*/
INSERT INTO roles_permisos (id_rol, id_permiso)
VALUES (1, 1),  -- Paciente, PACIENTE_READ
       (2, 2),  -- Doctor, MED_READ
       (2, 3),  -- Doctor, MED_WRITE
       (2, 4),  -- Doctor, USER_MANAGER_WRITE
       (2, 5),  -- Doctor, USER_MANAGER_READ
       (3, 2),  -- Enfermera, MED_READ
       (3, 3),  -- Enfermera, MED_WRITE
       (4, 8),  -- Administrativo, ADMINISTRATIVO_WRITE
       (4, 5),  -- Administrativo, USER_MANAGER_READ
       (4, 12), -- Administrativo, GUEST_READ
       (5, 9),  -- Autoridad, AUTORIDAD_READ
       (5, 10), -- Autoridad, AUTORIDAD_WRITE
       (6, 11) -- Developer, DEV_DB_ADMIN
GO
PRINT (N'Insertando datos de prueba');
GO
-- datos de prueba. Las direcciones se insertan a medida que se requieren. Se recomienda utilizar los procedimientos para insertar ya que respeta la lógica y facilita insertar a varias tablas
INSERT INTO vacunas (nombre_vacuna, edad_minima_meses, intervalo_dosis_1_2_meses)
VALUES ('Por registrar', NULL, NULL),
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
       (N'MR (antisarampión, antirrubéola)', 12, 72),
       ('Neumoco conjugado (Prevenar 13 valente)', 2, NULL),
       ('Papiloma Humano (Gardasil)', 132, NULL),
       ('Pneumo23', 780, NULL),
       ('Pneumovax', 780, NULL),
       ('Priorix', 9, 3),
       ('Rotarix', 2, NULL),
       ('TD', 48, 120),
       ('Tetravalente', NULL, NULL), -- No se especifica la edad mínima y el intervalo es según el calendario infantil
       ('Varivax', 12, 69),
       ('Verorab', NULL, NULL); -- Según el esquema de post-exposición
GO
PRINT (N'Relacionando vacunas con enfermedades');
GO
-- Vacuna por registrar
EXEC sp_vacunas_insert_vacuna_enfermedad NULL, 'Por registrar', NULL, 'Desconocida', NULL;
-- enfermedad desconocida y síntomas desconocidos
-- Adacel
EXEC sp_vacunas_insert_vacuna_enfermedad NULL, 'Adacel', NULL, 'Difteria', NULL;
EXEC sp_vacunas_insert_vacuna_enfermedad NULL, 'Adacel', NULL, N'Tétanos', NULL;
EXEC sp_vacunas_insert_vacuna_enfermedad NULL, 'Adacel', NULL, 'Tos ferina', NULL;

EXEC sp_vacunas_insert_vacuna_enfermedad NULL, 'BCG', NULL, 'Tuberculosis', NULL;

EXEC sp_vacunas_insert_vacuna_enfermedad NULL, 'COVID-19', NULL, 'COVID-19', NULL;

EXEC sp_vacunas_insert_vacuna_enfermedad NULL, 'Fiebre Amarilla', NULL, 'Fiebre Amarilla', NULL;

EXEC sp_vacunas_insert_vacuna_enfermedad NULL, 'Hep A (Euvax) (adultos)', NULL, 'Hepatitis A', NULL;

EXEC sp_vacunas_insert_vacuna_enfermedad NULL, 'Hep A (Euvax) (infantil)', NULL, 'Hepatitis A', NULL;

EXEC sp_vacunas_insert_vacuna_enfermedad NULL, 'Hep B (adultos)', NULL, 'Hepatitis B', NULL;

EXEC sp_vacunas_insert_vacuna_enfermedad NULL, 'Hep B (infantil)', NULL, 'Hepatitis B', NULL;
-- Hexaxim
EXEC sp_vacunas_insert_vacuna_enfermedad NULL, 'Hexaxim', NULL, 'Difteria', NULL;
EXEC sp_vacunas_insert_vacuna_enfermedad NULL, 'Hexaxim', NULL, N'Tétanos', NULL;
EXEC sp_vacunas_insert_vacuna_enfermedad NULL, 'Hexaxim', NULL, 'Tos ferina', NULL;
EXEC sp_vacunas_insert_vacuna_enfermedad NULL, 'Hexaxim', NULL, 'Hepatitis B', NULL;
EXEC sp_vacunas_insert_vacuna_enfermedad NULL, 'Hexaxim', NULL, 'Poliomelitis (Polio)', NULL;
EXEC sp_vacunas_insert_vacuna_enfermedad NULL, 'Hexaxim', NULL, 'Hib (Haemophilus influenzae tipo b)', NULL;

EXEC sp_vacunas_insert_vacuna_enfermedad NULL, 'Influenza (FluQuadri)', NULL, 'Influenza (Gripe)', NULL;

EXEC sp_vacunas_insert_vacuna_enfermedad NULL, 'Meningococo', NULL, N'Enfermedad meningocócica', NULL;
-- MMR
EXEC sp_vacunas_insert_vacuna_enfermedad NULL, 'MMR', NULL, N'Sarampión', NULL;
EXEC sp_vacunas_insert_vacuna_enfermedad NULL, 'MMR', NULL, 'Paperas', NULL;
EXEC sp_vacunas_insert_vacuna_enfermedad NULL, 'MMR', NULL, N'Rubéola', NULL;
-- MR (antisarampión, antirrubéola)
EXEC sp_vacunas_insert_vacuna_enfermedad NULL, N'MR (antisarampión, antirrubéola)', NULL, N'Sarampión', NULL;
EXEC sp_vacunas_insert_vacuna_enfermedad NULL, N'MR (antisarampión, antirrubéola)', NULL, N'Rubéola', NULL;
-- Neumoco conjugado (Prevenar 13 valente)
EXEC sp_vacunas_insert_vacuna_enfermedad NULL, 'Neumoco conjugado (Prevenar 13 valente)', NULL, N'Neumonía', NULL;
EXEC sp_vacunas_insert_vacuna_enfermedad NULL, 'Neumoco conjugado (Prevenar 13 valente)', NULL, 'Meningitis', NULL;
EXEC sp_vacunas_insert_vacuna_enfermedad NULL, 'Neumoco conjugado (Prevenar 13 valente)', NULL, 'Bacteriemia', NULL;

EXEC sp_vacunas_insert_vacuna_enfermedad NULL, 'Papiloma Humano (Gardasil)', NULL, 'Virus del papiloma humano (VPH)',
     NULL;

EXEC sp_vacunas_insert_vacuna_enfermedad NULL, 'Pneumo23', NULL, N'Enfermedades neumocócicas', NULL;

EXEC sp_vacunas_insert_vacuna_enfermedad NULL, 'Pneumovax', NULL, N'Enfermedades neumocócicas', NULL;
-- Priorix
EXEC sp_vacunas_insert_vacuna_enfermedad NULL, 'Priorix', NULL, N'Sarampión', NULL;
EXEC sp_vacunas_insert_vacuna_enfermedad NULL, 'Priorix', NULL, N'Rubéola', NULL;
EXEC sp_vacunas_insert_vacuna_enfermedad NULL, 'Priorix', NULL, 'Paperas', NULL;
EXEC sp_vacunas_insert_vacuna_enfermedad NULL, 'Rotarix', NULL, 'Rotavirus', NULL;
-- TD
EXEC sp_vacunas_insert_vacuna_enfermedad NULL, 'TD', NULL, N'Tétanos', NULL;
EXEC sp_vacunas_insert_vacuna_enfermedad NULL, 'TD', NULL, 'Difteria', NULL;
-- Tetravalente
EXEC sp_vacunas_insert_vacuna_enfermedad NULL, 'Tetravalente', NULL, 'Difteria', NULL;
EXEC sp_vacunas_insert_vacuna_enfermedad NULL, 'Tetravalente', NULL, N'Tétanos', NULL;
EXEC sp_vacunas_insert_vacuna_enfermedad NULL, 'Tetravalente', NULL, 'Tos ferina', NULL;
EXEC sp_vacunas_insert_vacuna_enfermedad NULL, 'Tetravalente', NULL, 'Poliomelitis (Polio)', NULL;

EXEC sp_vacunas_insert_vacuna_enfermedad NULL, 'Varivax', NULL, 'Varicela', NULL;
EXEC sp_vacunas_insert_vacuna_enfermedad NULL, 'Verorab', NULL, 'Rabia', NULL;

PRINT (N'Insertando pacientes');
-- Pacientes ficticios
EXEC sp_vacunas_gestionar_paciente '8-1006-14', 'Jorge', 'Ruiz', NULL, '1999-05-31', 'M', '507 6068-4595', NULL,
     'Samaria, sector 4, casa E1', 'San Miguelito', NULL;
EXEC sp_vacunas_gestionar_paciente '1-54-9635', 'Luis', 'Mendoza', NULL, '2006-05-05', 'M', '507 6325-7865', NULL,
     'Finca 30, casa 45', 'Changuinola', NULL;
EXEC sp_vacunas_gestionar_paciente '2-4558-5479', N'José', 'Perez', NULL, '1959-12-13', 'M', '507 6265-4789', NULL,
     N'Vía Interamericana, casa L78', N'Natá', NULL;
EXEC sp_vacunas_gestionar_paciente '5-554-321', 'Martha', 'Cornejo', NULL, '1979-08-24', 'F', '507 6784-1296', NULL,
     N'Vía Interamericana, Metetí, casa 87F', 'Pinogana', NULL;
EXEC sp_vacunas_gestionar_paciente '8-9754-1236', 'Suleimi', 'Rodriguez', NULL, '2001-02-17', 'F', '507 6785-9631',
     NULL, 'Calle 51, casa 74', N'Panamá', NULL;

EXEC sp_vacunas_gestionar_paciente 'PE-234-567', 'Carlos', 'Mendez', NULL, '1990-04-12', 'M', '507 6000-1111',
     'carlos.mendez@example.com', 'Avenida 4B, Casa 12', N'Panamá', NULL;
EXEC sp_vacunas_gestionar_paciente 'E-12-123456', 'Luis', N'Pérez', NULL, '1978-03-19', 'M', NULL,
     'luis.perez@example.com', 'Edificio Las Palmas, Piso 3', N'Colón', NULL;
EXEC sp_vacunas_gestionar_paciente 'N-456-789', N'María', N'Rodríguez', N'Hernández', '1992-11-05', 'F',
     '507 6000-3333', NULL, 'Calle 12, Casa 56', 'David', NULL;
EXEC sp_vacunas_gestionar_paciente '5AV-9-1234', 'Javier', N'Fernández', NULL, '1988-02-21', 'M', '507 6000-4444',
     'javier.fernandez@example.com', 'Avenida 1A, Local 9', N'Panamá', NULL;
EXEC sp_vacunas_gestionar_paciente '2PI-3421-456', 'Ricardo', 'Mora', NULL, '1980-12-30', 'M', '507 6000-6666', NULL,
     'Calle 14, Casa 89', 'Bocas del Toro', NULL;
EXEC sp_vacunas_gestionar_paciente 'E-78-654321', 'Paola', N'García', 'Torres', '1996-06-11', 'F', '507 6000-7777',
     'paola.garcia@example.com', 'Edificio El Dorado, Oficina 10', N'Panamá', NULL;
EXEC sp_vacunas_gestionar_paciente 'PE-9-123', 'Sergio', N'Ramírez', NULL, '1983-09-23', 'M', '507 6000-8888',
     'sergio.ramirez@example.com', 'Avenida 8, Apartamento 20', 'La Chorrera', NULL;
EXEC sp_vacunas_gestionar_paciente '4-4321-123', 'Elena', 'Cruz', N'Gómez', '1991-01-15', 'F', '507 6000-9999',
     'elena.cruz@example.com', 'Calle 9, Casa 43', N'Penonomé', NULL;
EXEC sp_vacunas_gestionar_paciente '6-2-987654', 'Sofia', N'Méndez', N'Hernández', '1993-07-17', 'F', '507 6001-1111',
     'sofia.mendez@example.com', 'Avenida 2B, Piso 2', N'Panamá', NULL;
EXEC sp_vacunas_gestionar_paciente 'PE-5-3456', 'Alejandro', N'Rodríguez', NULL, '1989-04-09', 'M', '507 6001-2222',
     NULL, 'Calle 6, Edificio 5', N'Colón', NULL;
EXEC sp_vacunas_gestionar_paciente 'N-1234-654', 'Camila', N'Vásquez', 'Ruiz', '1995-10-11', 'F', '507 6001-3333',
     'camila.vasquez@example.com', 'Edificio La Roca, Apartamento 10', 'David', NULL;
EXEC sp_vacunas_gestionar_paciente '8-123-56789', 'Hugo', 'Cruz', NULL, '1980-02-15', 'M', '507 6001-4444', NULL,
     'Avenida 3, Local 14', 'San Miguelito', NULL;
EXEC sp_vacunas_gestionar_paciente '3-12-543', 'Valeria', 'Castillo', N'García', '1997-11-24', 'F', '507 6001-5555',
     'valeria.castillo@example.com', 'Calle 13, Edificio A', 'Bocas del Toro', NULL;
EXEC sp_vacunas_gestionar_paciente '7AV-678-123', 'Jorge', N'Fernández', NULL, '1986-09-30', 'M', '507 6001-6666', NULL,
     'Calle 8, Apartamento 2', 'La Chorrera', NULL;
EXEC sp_vacunas_gestionar_paciente '9PI-1-98765', 'Natalia', 'Morales', N'Vásquez', '1990-06-14', 'F', '507 6001-7777',
     'natalia.morales@example.com', 'Edificio Los Pinos, Piso 4', N'Panamá', NULL;
EXEC sp_vacunas_gestionar_paciente 'PE-345-234', 'Laura', N'Rodríguez', N'Pérez', '1998-08-05', 'F', '507 6001-9999',
     'laura.rodriguez@example.com', 'Avenida 6, Apartamento 8', N'Penonomé', NULL;
EXEC sp_vacunas_gestionar_paciente '4-987-123456', 'Felipe', N'Hernández', NULL, '1987-03-17', 'M', '507 6002-0000',
     'felipe.hernandez@example.com', 'Calle 5, Local 6', N'Panamá', NULL;
EXEC sp_vacunas_gestionar_paciente 'N-543-567', 'Daniela', N'Gómez', N'Fernández', '1994-04-22', 'F', '507 6002-1111',
     'daniela.gomez@example.com', 'Calle 4, Edificio 7', N'Colón', NULL;
EXEC sp_vacunas_gestionar_paciente '6AV-99-1', 'Luis', 'Salazar', NULL, '1985-12-14', 'M', '507 6002-2222',
     'luis.salazar@example.com', 'Avenida 1, Casa 9', 'David', NULL;
EXEC sp_vacunas_gestionar_paciente '2-4567-876543', 'Gabriela', N'Vásquez', N'Rodríguez', '1991-07-09', 'F',
     '507 6002-3333', 'gabriela.vasquez@example.com', 'Calle 7, Apartamento 4', 'San Miguelito', NULL;
EXEC sp_vacunas_gestionar_paciente 'E-23-321', 'Alejandra', 'Morales', NULL, '1984-10-18', 'F', '507 6002-4444',
     'alejandra.morales@example.com', 'Edificio El Sol, Oficina 3', 'Bocas del Toro', NULL;
EXEC sp_vacunas_gestionar_paciente 'N-89-654', N'Joaquín', N'Ramírez', N'García', '1999-02-20', 'M', '507 6002-5555',
     'joaquin.ramirez@example.com', 'Calle 10, Edificio 8', 'La Chorrera', NULL;
EXEC sp_vacunas_gestionar_paciente 'PE-3456-321', 'Cristina', N'Pérez', NULL, '1988-11-12', 'F', '507 6002-6666',
     'cristina.perez@example.com', 'Calle 11, Casa 12', N'Panamá', NULL;
EXEC sp_vacunas_gestionar_paciente '1PI-678-12', 'Beatriz', 'Castillo', NULL, '1996-06-19', 'F', '507 6002-8888',
     'beatriz.castillo@example.com', 'Calle 3, Local 10', N'Colón', NULL;
EXEC sp_vacunas_gestionar_paciente '7-234-1234', 'Diego', N'Jiménez', 'Morales', '1983-12-15', 'M', '507 6002-9999',
     'diego.jimenez@example.com', 'Avenida 9, Edificio B', 'David', NULL;
EXEC sp_vacunas_gestionar_paciente '4-123-56789', 'Paola', 'Ramos', NULL, '1987-03-28', 'F', '507 6003-0000',
     'paola.ramos@example.com', 'Calle 6, Edificio 3', N'Panamá', NULL;
EXEC sp_vacunas_gestionar_paciente 'N-56-987', 'Juan', N'García', 'Ruiz', '1994-08-15', 'M', '507 6003-1111',
     'juan.garcia@example.com', 'Calle 4, Casa 8', 'San Miguelito', NULL;
EXEC sp_vacunas_gestionar_paciente '5-567-65432', 'Natalia', 'Moreno', NULL, '1992-07-21', 'F', '507 6003-2222',
     'natalia.moreno@example.com', 'Edificio La Vista, Piso 6', N'Colón', NULL;
EXEC sp_vacunas_gestionar_paciente 'PE-8-123', 'Marcos', 'Salinas', N'Gómez', '1989-05-30', 'M', '507 6003-3333',
     'marcos.salinas@example.com', 'Avenida 7, Local 5', 'David', NULL;
EXEC sp_vacunas_gestionar_paciente 'E-7-7654', 'Julia', N'Sánchez', NULL, '1991-12-25', 'F', '507 6003-4444',
     'julia.sanchez@example.com', 'Calle 8, Casa 14', 'San Miguelito', NULL;
EXEC sp_vacunas_gestionar_paciente '6-2345-123', N'Andrés', 'Torres', 'Castillo', '1986-04-12', 'M', '507 6003-5555',
     'andres.torres@example.com', 'Edificio La Colina, Apartamento 3', 'Bocas del Toro', NULL;
EXEC sp_vacunas_gestionar_paciente '3PI-1-654', 'Elena', N'González', NULL, '1993-09-29', 'F', '507 6003-6666',
     'elena.gonzalez@example.com', 'Calle 11, Edificio C', 'La Chorrera', NULL;
EXEC sp_vacunas_gestionar_paciente 'PE-12-3456', N'Héctor', N'Ramírez', 'Ruiz', '1997-06-14', 'M', '507 6003-7777',
     'hector.ramirez@example.com', 'Calle 5, Casa 10', N'Panamá', NULL;
EXEC sp_vacunas_gestionar_paciente '9-1-123456', 'Sandra', 'Montes', NULL, '1984-08-19', 'F', '507 6003-8888',
     'sandra.montes@example.com', 'Edificio Los Jardines, Piso 2', 'San Miguelito', NULL;
EXEC sp_vacunas_gestionar_paciente 'N-78-987', 'Santiago', N'Méndez', N'Vásquez', '1990-11-25', 'M', '507 6003-9999',
     'santiago.mendez@example.com', 'Calle 9, Apartamento 5', N'Colón', NULL;
EXEC sp_vacunas_gestionar_paciente '7-4567-123', 'Camila', 'Ruiz', NULL, '1996-03-14', 'F', '507 6004-0000',
     'camila.ruiz@example.com', 'Avenida 3, Casa 12', 'David', NULL;
EXEC sp_vacunas_gestionar_paciente '5AV-34-654', N'Tomás', 'Alvarado', 'Castillo', '1988-02-18', 'M', '507 6004-1111',
     'tomas.alvarado@example.com', 'Calle 2, Edificio 1', N'Panamá', NULL;
EXEC sp_vacunas_gestionar_paciente '8-12-321', 'Isabel', N'García', NULL, '1994-07-09', 'F', '507 6004-2222',
     'isabel.garcia@example.com', 'Edificio Los Robles, Apartamento 8', 'San Miguelito', NULL;
EXEC sp_vacunas_gestionar_paciente 'E-345-1', 'Federico', N'Gómez', NULL, '1991-06-28', 'M', '507 6004-3333',
     'federico.gomez@example.com', 'Calle 10, Local 7', N'Colón', NULL;
EXEC sp_vacunas_gestionar_paciente 'PE-1234-567', 'Paola', N'Martínez', N'Vásquez', '1985-11-15', 'F', '507 6004-4444',
     'paola.martinez@example.com', 'Calle 4, Casa 6', 'David', NULL;
EXEC sp_vacunas_gestionar_paciente 'N-9-876', 'Miguel', N'Vásquez', NULL, '1989-05-21', 'M', '507 6004-5555',
     'miguel.vasquez@example.com', 'Avenida 8, Edificio 3', N'Panamá', NULL;
EXEC sp_vacunas_gestionar_paciente '4-5678-12345', 'Fernanda', 'Torres', NULL, '1998-03-13', 'F', '507 6004-6666',
     'fernanda.torres@example.com', 'Calle 7, Casa 5', 'San Miguelito', NULL;
EXEC sp_vacunas_gestionar_paciente '2PI-23-789', 'Alejandro', N'Jiménez', 'Salazar', '1992-08-19', 'M', '507 6004-7777',
     'alejandro.jimenez@example.com', N'Edificio El Águila, Piso 1', 'Bocas del Toro', NULL;
EXEC sp_vacunas_gestionar_paciente '6-1234-65432', 'Rosa', N'González', NULL, '1981-10-29', 'F', '507 6004-8888',
     'rosa.gonzalez@example.com', 'Calle 8, Edificio 6', 'La Chorrera', NULL;
EXEC sp_vacunas_gestionar_paciente '7-345-678', 'Gabriel', N'Ramírez', 'Ramos', '1996-04-21', 'M', '507 6004-9999',
     'gabriel.ramirez@example.com', 'Calle 11, Casa 15', N'Panamá', NULL;
EXEC sp_vacunas_gestionar_paciente 'PE-9-1', 'Luisa', 'Castillo', NULL, '1990-06-25', 'F', '507 6005-0000',
     'luisa.castillo@example.com', 'Avenida 5, Local 3', 'San Miguelito', NULL;
EXEC sp_vacunas_gestionar_paciente 'E-12-54321', 'Mauricio', 'Ruiz', N'Gómez', '1987-02-16', 'M', '507 6005-1111',
     'mauricio.ruiz@example.com', 'Edificio La Palma, Apartamento 6', N'Colón', NULL;
EXEC sp_vacunas_gestionar_paciente 'N-234-567', 'Daniela', N'Hernández', NULL, '1995-01-18', 'F', '507 6005-2222',
     'daniela.hernandez@example.com', 'Calle 6, Edificio 4', 'David', NULL;
EXEC sp_vacunas_gestionar_paciente '5-678-98765', 'Ricardo', 'Salazar', N'Pérez', '1983-09-13', 'M', '507 6005-3333',
     'ricardo.salazar@example.com', 'Calle 5, Casa 8', 'San Miguelito', NULL;
EXEC sp_vacunas_gestionar_paciente '4AV-8-12', 'Victoria', N'Gómez', NULL, '1992-03-14', 'F', '507 6005-4444',
     'victoria.gomez@example.com', 'Edificio La Vista, Piso 5', 'Bocas del Toro', NULL;
EXEC sp_vacunas_gestionar_paciente '8-123-1234', N'Andrés', N'Martínez', N'García', '1986-12-11', 'M', '507 6005-5555',
     'andres.martinez@example.com', 'Calle 12, Local 2', 'La Chorrera', NULL;
EXEC sp_vacunas_gestionar_paciente 'N-56-2345', 'Carla', N'Sánchez', NULL, '1994-06-28', 'F', '507 6005-6666',
     'carla.sanchez@example.com', 'Calle 9, Casa 4', N'Panamá', NULL;
EXEC sp_vacunas_gestionar_paciente 'E-7-876', 'Javier', N'García', NULL, '1991-08-20', 'M', '507 6005-7777',
     'javier.garcia@example.com', 'Avenida 7, Edificio 9', 'San Miguelito', NULL;
EXEC sp_vacunas_gestionar_paciente 'PE-345-6789', 'Elena', N'Pérez', 'Morales', '1998-05-10', 'F', '507 6005-8888',
     'elena.perez@example.com', 'Calle 4, Apartamento 11', N'Colón', NULL;
EXEC sp_vacunas_gestionar_paciente '9-123-123', 'Ricardo', 'Castillo', NULL, '1987-11-15', 'M', '507 6005-9999',
     'ricardo.castillo@example.com', 'Edificio Los Robles, Piso 3', 'David', NULL;
EXEC sp_vacunas_gestionar_paciente '3-567-9876', 'Marta', 'Alvarez', N'Rodríguez', '1992-07-19', 'F', '507 6006-0000',
     'marta.alvarez@example.com', 'Calle 5, Casa 10', 'San Miguelito', NULL;
EXEC sp_vacunas_gestionar_paciente '4PI-12-345', 'Eduardo', 'Salazar', NULL, '1984-04-22', 'M', '507 6006-1111',
     'eduardo.salazar@example.com', 'Avenida 6, Edificio 3', N'Panamá', NULL;
EXEC sp_vacunas_gestionar_paciente '6-12345-678', 'Laura', N'Gómez', 'Morales', '1995-10-30', 'F', '507 6006-2222',
     'laura.gomez@example.com', 'Calle 12, Edificio 7', N'Colón', NULL;
EXEC sp_vacunas_gestionar_paciente 'E-2345-123', 'Luis', N'Vásquez', NULL, '1988-02-15', 'M', '507 6006-3333',
     'luis.vasquez@example.com', 'Calle 3, Casa 7', 'David', NULL;
EXEC sp_vacunas_gestionar_paciente 'N-89-1', N'Sofía', N'González', NULL, '1986-12-15', 'F', '507 6206-6666',
     'sofia.gonzalez@example.com', 'Calle 11, Casa 6', 'La Chorrera', NULL;
EXEC sp_vacunas_gestionar_paciente 'PE-12-1234', N'Verónica', N'Vásquez', N'Gómez', '1992-07-15', 'F', '507 6106-8888',
     'veronica.vasquez@example.com', 'Edificio La Vista, Piso 7', 'San Miguelito', NULL;
EXEC sp_vacunas_gestionar_paciente '7-456-987', 'Francisco', N'Sánchez', NULL, '1988-11-02', 'M', '507 6306-9999',
     'francisco.sanchez@example.com', 'Calle 7, Casa 9', N'Colón', NULL;
EXEC sp_vacunas_gestionar_paciente '2-1234-654', 'Daniel', 'Cruz', 'Alvarado', '1993-10-20', 'M', '507 6107-0000',
     'daniel.cruz@example.com', 'Avenida 2, Edificio 4', 'David', NULL;
EXEC sp_vacunas_gestionar_paciente '9PI-234-1', N'Tomás', N'González', N'Sánchez', '1991-08-15', 'M', '507 6007-2222',
     'tomas.gonzalez@example.com', 'Calle 6, Local 8', N'Panamá', NULL;
EXEC sp_vacunas_gestionar_paciente 'PE-8-567', 'Luis', 'Alvarado', NULL, '1986-05-18', 'M', '507 6407-4444',
     'luis.alvarado@example.com', 'Calle 3, Casa 9', N'Colón', NULL;
EXEC sp_vacunas_gestionar_paciente 'E-3456-78', 'Elena', N'Sánchez', N'Vásquez', '1994-09-19', 'F', '507 6507-5555',
     'elena.sanchez@example.com', 'Avenida 8, Edificio 5', 'David', NULL;
EXEC sp_vacunas_gestionar_paciente 'N-12-987', 'Marta', N'Gómez', 'Alvarado', '1988-11-12', 'F', '507 6607-7777',
     'marta.gomez@example.com', 'Edificio El Sol, Apartamento 4', N'Panamá', NULL;
EXEC sp_vacunas_gestionar_paciente '6-789-654', 'Laura', 'Salazar', N'García', '1993-07-12', 'F', '507 6007-9999',
     'laura.salazar@example.com', 'Calle 8, Edificio 6', N'Colón', NULL;
EXEC sp_vacunas_gestionar_paciente '4-123-5678', 'Fernando', N'Pérez', NULL, '1990-05-14', 'M', '507 6708-0000',
     'fernando.perez@example.com', 'Edificio La Roca, Apartamento 7', 'David', NULL;
EXEC sp_vacunas_gestionar_paciente 'PE-1-4321', 'Natalia', N'Vásquez', NULL, '1988-02-24', 'F', '507 6908-1111',
     'natalia.vasquez@example.com', 'Calle 4, Edificio 1', N'Panamá', NULL;
EXEC sp_vacunas_gestionar_paciente '8-3456-123', N'Sofía', N'Rodríguez', NULL, '1995-12-20', 'F', '507 6808-3333',
     'sofia.rodriguez@example.com', 'Avenida 3, Edificio 9', N'Colón', NULL;
EXEC sp_vacunas_gestionar_paciente 'N-9-567', 'Carlos', 'Alvarez', N'Gómez', '1986-06-14', 'M', '507 6008-4444',
     'carlos.alvarez@example.com', 'Calle 12, Local 7', 'David', NULL;
EXEC sp_vacunas_gestionar_paciente '1-145-987', 'Luis', N'Gómez', NULL, '1984-01-12', 'M', '507 6008-6666',
     'luis.gomez@example.com', 'Calle 7, Edificio 6', N'Panamá', NULL;
EXEC sp_vacunas_gestionar_paciente '3-721-284', 'Sandra', N'Pérez', 'Castillo', '1995-10-10', 'F', '507 6058-7777',
     'sandra.perez@example.com', 'Calle 5, Casa 12', N'Colón', NULL;
EXEC sp_vacunas_gestionar_paciente '7-114-10', 'Antonio', N'Sánchez', NULL, '1989-07-14', 'M', '507 6008-8888',
     'antonio.sanchez@example.com', 'Calle 9, Edificio 8', 'David', NULL;

EXEC sp_vacunas_gestionar_paciente 'AB1234567X', N'Sofía', N'González', NULL, '1986-12-15', 'F', '507 6006-6666',
     'sofia.gonzalez1@example.com', 'Calle 11, Casa 6', 'La Chorrera', NULL;
EXEC sp_vacunas_gestionar_paciente 'CD9876543Y', 'Mario', N'Ramírez', NULL, '1995-09-12', 'M', '507 6006-7777',
     'mario.ramirez@example.com', 'Calle 3, Edificio 2', N'Panamá', NULL;
EXEC sp_vacunas_gestionar_paciente 'EF123456Z', N'Verónica', N'Vásquez', N'Gómez', '1992-07-15', 'F', '507 6006-8888',
     'veronica.vasquez1@example.com', 'Edificio La Vista, Piso 7', 'San Miguelito', NULL;
EXEC sp_vacunas_gestionar_paciente 'GH6543210W', 'Francisco', N'Sánchez', NULL, '1988-11-02', 'M', '507 6006-9999',
     'francisco.sanchez1@example.com', 'Calle 7, Casa 9', N'Colón', NULL;
EXEC sp_vacunas_gestionar_paciente 'IJ789456A', 'Daniel', 'Cruz', 'Alvarado', '1993-10-20', 'M', '507 6007-0000',
     'daniel.cruz1@example.com', 'Avenida 2, Edificio 4', 'David', NULL;
EXEC sp_vacunas_gestionar_paciente 'KL0123456B', 'Camila', N'Pérez', NULL, '1995-01-05', 'F', '507 6007-1111',
     'camila.perez@example.com', 'Calle 4, Casa 12', 'San Miguelito', NULL;
EXEC sp_vacunas_gestionar_paciente 'MN876543C', N'Tomás', N'González', N'Sánchez', '1991-08-15', 'M', '507 6607-2222',
     'tomas.gonzalez1@example.com', 'Calle 6, Local 8', N'Panamá', NULL;
EXEC sp_vacunas_gestionar_paciente 'OP3456789D', N'María', N'Rodríguez', NULL, '1987-12-25', 'F', '507 6007-3333',
     'maria.rodriguez@example.com', 'Edificio Los Cedros, Apartamento 2', 'San Miguelito', NULL;
EXEC sp_vacunas_gestionar_paciente 'QR4567890E', 'Luis', 'Alvarado', NULL, '1986-05-18', 'M', '507 6007-4444',
     'luis.alvarado1@example.com', 'Calle 3, Casa 9', N'Colón', NULL;
EXEC sp_vacunas_gestionar_paciente 'ST2345678F', 'Elena', N'Sánchez', N'Vásquez', '1994-09-19', 'F', '507 6007-5555',
     'elena.sanchez1@example.com', 'Avenida 8, Edificio 5', 'David', NULL;
EXEC sp_vacunas_gestionar_paciente 'UV3456789G', 'Gabriel', 'Ruiz', NULL, '1992-06-22', 'M', '507 6007-6666',
     'gabriel.ruiz@example.com', 'Calle 7, Edificio 3', 'San Miguelito', NULL;
EXEC sp_vacunas_gestionar_paciente 'WX4561234H', 'Marta', N'Gómez', 'Alvarado', '1988-11-12', 'F', '507 6007-7777',
     'marta.gomez1@example.com', 'Edificio El Sol, Apartamento 4', N'Panamá', NULL;
EXEC sp_vacunas_gestionar_paciente 'YZ7890123J', 'Juan', N'Martínez', NULL, '1996-03-28', 'M', '507 6007-8888',
     'juan.martinez@example.com', 'Calle 12, Casa 15', 'San Miguelito', NULL;
EXEC sp_vacunas_gestionar_paciente 'AB9876543K', 'Laura', 'Salazar', N'García', '1993-07-12', 'F', '507 6707-9999',
     'laura.salazar1@example.com', 'Calle 8, Edificio 6', N'Colón', NULL;
EXEC sp_vacunas_gestionar_paciente 'CD6543210L', 'Fernando', N'Pérez', NULL, '1990-05-14', 'M', '507 6008-0000',
     'fernando.perez1@example.com', 'Edificio La Roca, Apartamento 7', 'David', NULL;
EXEC sp_vacunas_gestionar_paciente 'EF4321098M', 'Natalia', N'Vásquez', NULL, '1988-02-24', 'F', '507 6008-1111',
     'natalia.vasquez1@example.com', 'Calle 4, Edificio 1', N'Panamá', NULL;
EXEC sp_vacunas_gestionar_paciente 'GH3210987N', 'Pedro', 'Castillo', 'Morales', '1992-04-18', 'M', '507 6008-2222',
     'pedro.castillo@example.com', 'Calle 9, Casa 14', 'San Miguelito', NULL;
EXEC sp_vacunas_gestionar_paciente 'IJ2109876O', N'Sofía', N'Rodríguez', NULL, '1995-12-20', 'F', '507 6008-3333',
     'sofia.rodriguez1@example.com', 'Avenida 3, Edificio 9', N'Colón', NULL;
EXEC sp_vacunas_gestionar_paciente 'KL1098765P', 'Carlos', 'Alvarez', N'Gómez', '1986-06-14', 'M', '507 6098-4444',
     'carlos.alvarez1@example.com', 'Calle 12, Local 7', 'David', NULL;
EXEC sp_vacunas_gestionar_paciente 'MN0987654Q', 'Camila', N'Hernández', NULL, '1993-08-15', 'F', '507 6008-5555',
     'camila.hernandez@example.com', 'Edificio El Dorado, Apartamento 2', 'San Miguelito', NULL;
EXEC sp_vacunas_gestionar_paciente 'OP8765432R', 'Luis', N'Gómez', NULL, '1984-01-12', 'M', '507 6208-6666',
     'luis.gomez1@example.com', 'Calle 7, Edificio 6', N'Panamá', NULL;
EXEC sp_vacunas_gestionar_paciente 'QR7654321S', 'Sandra', N'Pérez', 'Castillo', '1995-10-10', 'F', '507 6008-7777',
     'sandra.perez1@example.com', 'Calle 5, Casa 12', N'Colón', NULL;
EXEC sp_vacunas_gestionar_paciente 'ST6543210T', 'Antonio', N'Sánchez', NULL, '1989-07-14', 'M', '507 6808-8888',
     'antonio.sanchez1@example.com', 'Calle 9, Edificio 8', 'David', NULL;
EXEC sp_vacunas_gestionar_paciente 'UV5432109U', 'Isabella', 'Alvarado', 'Ruiz', '1996-03-22', 'F', '507 6008-9999',
     'isabella.alvarado@example.com', 'Edificio La Vista, Piso 4', 'San Miguelito', NULL;
EXEC sp_vacunas_gestionar_paciente 'WX4321098V', 'Santiago', 'Morales', N'Rodríguez', '1991-03-27', 'M',
     '507 6006-5555', 'santiago.morales@example.com', 'Calle 8, Local 11', 'Bocas del Toro', NULL;

PRINT (N'Insertando sedes');
-- Sedes algunos datos no son veraces **
EXEC sp_vacunas_insert_sede 'Hospital San Miguel Arcangel', 'MINSA', NULL, '507 523-6906',
     N'HISMA, Vía Ricardo J. Alfaro', 'San Miguelito', NULL;
EXEC sp_vacunas_insert_sede 'MINSA CAPSI FINCA 30 CHANGINOLA', 'MINSA', NULL, '507 758-8096', 'Finca 32',
     'Changuinola', NULL;
EXEC sp_vacunas_insert_sede 'Hospital Aquilino Tejeira', 'CSS', NULL, '507 997-9386', 'Calle Manuel H Robles',
     N'Penonomé', NULL;
EXEC sp_vacunas_insert_sede 'CENTRO DE SALUD METETI', 'MINSA', NULL, '507 299-6151', 'La Palma', 'Pinogana', NULL;
EXEC sp_vacunas_insert_sede 'POLICENTRO DE SALUD de Chepo', 'MINSA', NULL, '507 296-7220',
     'Via Panamericana Las Margaritas', 'Chepo', NULL;
EXEC sp_vacunas_insert_sede N'Clínica Hospital San Fernando', 'Privada', NULL, '507 305-6300',
     N'Via España, Hospital San Fernando', N'Panamá', NULL;
EXEC sp_vacunas_insert_sede 'Complejo Hospitalario Doctor Arnulfo Arias Madrid', 'CSS', NULL, '507 503-6032',
     N'Avenida José de Fábrega, Complejo Hospitalario', N'Panamá', NULL;
EXEC sp_vacunas_insert_sede N'Hospital Santo Tomás', 'MINSA', NULL, '507 507-5830', 'Avenida Balboa y Calle 37 Este',
     N'Panamá', NULL;
EXEC sp_vacunas_insert_sede N'Hospital Regional de Changuinola Raul Dávila Mena', 'MINSA', NULL, '507 758-8295',
     'Changuinola, Bocas del Toro', 'Changuinola', NULL;
EXEC sp_vacunas_insert_sede N'Hospital Dr. Rafael Hernández', 'MINSA', NULL, '507 774-8400', N'David, Chiriquí',
     'David', NULL;
EXEC sp_vacunas_insert_sede N'Hospital Punta Pacífica Pacífica Salud', 'Privada', NULL, '507 204-8000',
     N'Punta Pacífica, Ciudad de Panamá', N'Panamá', NULL;
EXEC sp_vacunas_insert_sede 'Hospital Nacional', 'Privada', NULL, '507 307-2102', N'Av. Cuba, Ciudad de Panamá',
     N'Panamá', NULL;
EXEC sp_vacunas_insert_sede 'Centro de salud Pacora', 'MINSA', NULL, '507 296-0005', N'Pacora, Ciudad de Panamá',
     N'Panamá', NULL;
EXEC sp_vacunas_insert_sede N'Hospital Dr. Nicolás A. Solano', 'MINSA', NULL, '507 254-8926',
     N'La Chorrera, Panamá Oeste', 'La Chorrera', NULL;
EXEC sp_vacunas_insert_sede 'Complejo Hospitalario Dr. Manuel Amador Guerrero', 'CSS', NULL, '507 475-2207',
     N'Colón, Colón', N'Colón', NULL;
EXEC sp_vacunas_insert_sede N'Policlínica Lic. Manuel María Valdés', 'CSS', NULL, '507 503-1500',
     N'San Miguelito, Ciudad de Panamá', N'Panamá', NULL;
EXEC sp_vacunas_insert_sede 'CSS Complejo Metropolitano', 'CSS', NULL, '507 506-4000', N'Vía España, Ciudad de Panamá',
     N'Panamá', NULL;
EXEC sp_vacunas_insert_sede N'Hospital de Especialidades Pediátricas Omar Torrijos Herrena', 'CSS', NULL,
     '507 513-7008', N'Vía España, Ciudad de Panamá', N'Panamá', NULL;

PRINT (N'Insertando fabricantes');
INSERT INTO fabricantes (licencia, nombre_fabricante, telefono_fabricante, correo_fabricante, direccion_fabricante,
                         contacto_fabricante)
VALUES -- algunos datos no son veraces **
       ('08-001 LA/DNFD', 'Sanofi Pasteur', '1-800-822-2463', 'info@sanofipasteur.com',
        'Sanofi Pasteur Inc., 1 Discovery Drive, Swiftwater, PA 18370, USA', 'John Doe'),
       ('08-002 LA/DNFD', 'Pfizer', '1-212-733-2323', 'support@pfizer.com',
        'Pfizer Inc., 235 East 42nd Street, New York, NY 10017, USA', 'Alice Johnson'),
       ('08-003 LA/DNFD', 'GlaxoSmithKline', '44-20-8047-5000', 'info@gsk.com',
        'GSK plc, 980 Great West Road, Brentford, Middlesex, TW8 9GS, UK', 'Bob Brown'),
       ('08-004 LA/DNFD', 'Merck', '1-908-740-4000', 'contact@merck.com',
        'Merck & Co., Inc., 2000 Galloping Hill Road, Kenilworth, NJ 07033, USA', 'Jane Smith'),
       ('08-005 LA/DNFD', 'Serum Institute', '91-20-26993900', 'contact@seruminstitute.com',
        '212/2, Hadapsar, Off Soli Poonawalla Road, Pune 411028, Maharashtra, India', 'Mr. Muralidharan Poduval');
GO

PRINT (N'Relacionando fabricantes con vacunas')
-- insertar la relación fabricante vacuna usando el procedimiento almacenado
EXEC sp_vacunas_insert_fabricante_vacuna 1, NULL, NULL, 'Adacel', NULL;
EXEC sp_vacunas_insert_fabricante_vacuna 1, NULL, NULL, 'BCG', NULL;
EXEC sp_vacunas_insert_fabricante_vacuna 2, NULL, NULL, 'COVID-19', NULL;
EXEC sp_vacunas_insert_fabricante_vacuna 1, NULL, NULL, 'Fiebre Amarilla', NULL;
EXEC sp_vacunas_insert_fabricante_vacuna 3, NULL, NULL, 'Hep A (Euvax) (adultos)', NULL;
EXEC sp_vacunas_insert_fabricante_vacuna 3, NULL, NULL, 'Hep A (Euvax) (infantil)', NULL;
EXEC sp_vacunas_insert_fabricante_vacuna 4, NULL, NULL, 'Hep B (adultos)', NULL;
EXEC sp_vacunas_insert_fabricante_vacuna 4, NULL, NULL, 'Hep B (infantil)', NULL;
EXEC sp_vacunas_insert_fabricante_vacuna 1, NULL, NULL, 'Hexaxim', NULL;
EXEC sp_vacunas_insert_fabricante_vacuna 1, NULL, NULL, 'Influenza (FluQuadri)', NULL;
EXEC sp_vacunas_insert_fabricante_vacuna 3, NULL, NULL, 'Meningococo', NULL;
EXEC sp_vacunas_insert_fabricante_vacuna 4, NULL, NULL, 'MMR', NULL;
EXEC sp_vacunas_insert_fabricante_vacuna 5, NULL, NULL, N'MR (antisarampión, antirrubéola)', NULL;
EXEC sp_vacunas_insert_fabricante_vacuna 2, NULL, NULL, 'Neumoco conjugado (Prevenar 13 valente)', NULL;
EXEC sp_vacunas_insert_fabricante_vacuna 4, NULL, NULL, 'Papiloma Humano (Gardasil)', NULL;
EXEC sp_vacunas_insert_fabricante_vacuna 4, NULL, NULL, 'Pneumo23', NULL;
EXEC sp_vacunas_insert_fabricante_vacuna 4, NULL, NULL, 'Pneumovax', NULL;
EXEC sp_vacunas_insert_fabricante_vacuna 3, NULL, NULL, 'Priorix', NULL;
EXEC sp_vacunas_insert_fabricante_vacuna 3, NULL, NULL, 'Rotarix', NULL;
EXEC sp_vacunas_insert_fabricante_vacuna 1, NULL, NULL, 'TD', NULL;
EXEC sp_vacunas_insert_fabricante_vacuna 4, NULL, NULL, 'Tetravalente', NULL;
EXEC sp_vacunas_insert_fabricante_vacuna 4, NULL, NULL, 'Varivax', NULL;
EXEC sp_vacunas_insert_fabricante_vacuna 1, NULL, NULL, 'Verorab', NULL;

PRINT (N'Insertando almacen');
-- ficticios
EXEC sp_vacunas_insert_almacen N'Almacen Vacúnate Panamá', 'MINSA', NULL, '507 275-9689', NULL, NULL, 'Carlos Gonzalez',
     NULL

PRINT (N'Insertando almacen inventario');
-- Insertar el inventario en el almacén usando el procedimiento almacenado
EXEC sp_vacunas_insert_almacen_inventario 1, NULL, NULL, 'Adacel', 160, '2025-12-15', 'LoteA1', NULL;
EXEC sp_vacunas_insert_almacen_inventario 1, NULL, NULL, 'BCG', 215, '2025-12-16', 'LoteA2', NULL;
EXEC sp_vacunas_insert_almacen_inventario 1, NULL, NULL, 'COVID-19', 140, '2025-12-17', 'LoteA3', NULL;
EXEC sp_vacunas_insert_almacen_inventario 1, NULL, NULL, 'Fiebre Amarilla', 325, '2025-12-18', 'LoteA4', NULL;
EXEC sp_vacunas_insert_almacen_inventario 1, NULL, NULL, 'Hep A (Euvax) (adultos)', 280, '2025-12-19', 'LoteA5', NULL;
EXEC sp_vacunas_insert_almacen_inventario 1, NULL, NULL, 'Hep A (Euvax) (infantil)', 215, '2025-12-20', 'LoteA6', NULL;
EXEC sp_vacunas_insert_almacen_inventario 1, NULL, NULL, 'Hep B (adultos)', 260, '2025-12-21', 'LoteA7', NULL;
EXEC sp_vacunas_insert_almacen_inventario 1, NULL, NULL, 'Hep B (infantil)', 235, '2025-12-22', 'LoteA8', NULL;
EXEC sp_vacunas_insert_almacen_inventario 1, NULL, NULL, 'Hexaxim', 190, '2025-12-23', 'LoteA9', NULL;
EXEC sp_vacunas_insert_almacen_inventario 1, NULL, NULL, 'Influenza (FluQuadri)', 185, '2025-12-24', 'LoteA10', NULL;
EXEC sp_vacunas_insert_almacen_inventario 1, NULL, NULL, 'Meningococo', 170, '2025-12-25', 'LoteA11', NULL;
EXEC sp_vacunas_insert_almacen_inventario 1, NULL, NULL, 'MMR', 235, '2025-12-26', 'LoteA12', NULL;
EXEC sp_vacunas_insert_almacen_inventario 1, NULL, NULL, N'MR (antisarampión, antirrubéola)', 230, '2025-12-27',
     'LoteA13', NULL;
EXEC sp_vacunas_insert_almacen_inventario 1, NULL, NULL, 'Neumoco conjugado (Prevenar 13 valente)', 165, '2025-12-28',
     'LoteA14', NULL;
EXEC sp_vacunas_insert_almacen_inventario 1, NULL, NULL, 'Papiloma Humano (Gardasil)', 160, '2025-12-29', 'LoteA15',
     NULL;
EXEC sp_vacunas_insert_almacen_inventario 1, NULL, NULL, 'Pneumo23', 155, '2025-12-30', 'LoteA16', NULL;
EXEC sp_vacunas_insert_almacen_inventario 1, NULL, NULL, 'Pneumovax', 150, '2025-12-31', 'LoteA17', NULL;
EXEC sp_vacunas_insert_almacen_inventario 1, NULL, NULL, 'Priorix', 145, '2025-12-01', 'LoteA18', NULL;
EXEC sp_vacunas_insert_almacen_inventario 1, NULL, NULL, 'Rotarix', 140, '2025-12-02', 'LoteA19', NULL;
EXEC sp_vacunas_insert_almacen_inventario 1, NULL, NULL, 'TD', 135, '2025-12-03', 'LoteA20', NULL;
EXEC sp_vacunas_insert_almacen_inventario 1, NULL, NULL, 'Tetravalente', 130, '2025-12-04', 'LoteA21', NULL;
EXEC sp_vacunas_insert_almacen_inventario 1, NULL, NULL, 'Varivax', 125, '2025-12-05', 'LoteA22', NULL;
EXEC sp_vacunas_insert_almacen_inventario 1, NULL, NULL, 'Verorab', 125, '2025-12-06', 'LoteA23', NULL;

PRINT (N'Distribuyendo inventario a sedes');
-- Distribución de vacunas usando el procedimiento almacenado
EXEC sp_vacunas_distribuir_vacunas 1, NULL, NULL, 'Hospital San Miguel Arcangel', NULL, 'Adacel', 10, 'LoteA1', NULL,
     NULL;
EXEC sp_vacunas_distribuir_vacunas 1, NULL, NULL, 'MINSA CAPSI FINCA 30 CHANGINOLA', NULL, 'BCG', 15, 'LoteA2', NULL,
     NULL;
EXEC sp_vacunas_distribuir_vacunas 1, NULL, NULL, 'Hospital Aquilino Tejeira', NULL, 'COVID-19', 20, 'LoteA3', NULL,
     NULL;
EXEC sp_vacunas_distribuir_vacunas 1, NULL, NULL, 'CENTRO DE SALUD METETI', NULL, 'Fiebre Amarilla', 25, 'LoteA4', NULL,
     NULL;
EXEC sp_vacunas_distribuir_vacunas 1, NULL, NULL, 'POLICENTRO DE SALUD de Chepo', NULL, 'Hep A (Euvax) (adultos)', 30,
     'LoteA5', NULL, NULL;
EXEC sp_vacunas_distribuir_vacunas 1, NULL, NULL, N'Clínica Hospital San Fernando', NULL, 'Hep A (Euvax) (infantil)',
     35, 'LoteA6', NULL, NULL;
EXEC sp_vacunas_distribuir_vacunas 1, NULL, NULL, 'Complejo Hospitalario Doctor Arnulfo Arias Madrid', NULL,
     'Hep B (adultos)', 40, 'LoteA7', NULL, NULL;
EXEC sp_vacunas_distribuir_vacunas 1, NULL, NULL, N'Hospital Santo Tomás', NULL, 'Hep B (infantil)', 45, 'LoteA8', NULL,
     NULL;
EXEC sp_vacunas_distribuir_vacunas 1, NULL, NULL, N'Hospital Regional de Changuinola Raul Dávila Mena', NULL,
     'Hexaxim', 50, 'LoteA9', NULL, NULL;
EXEC sp_vacunas_distribuir_vacunas 1, NULL, NULL, N'Hospital Dr. Rafael Hernández', NULL, 'Influenza (FluQuadri)', 55,
     'LoteA10', NULL, NULL;
EXEC sp_vacunas_distribuir_vacunas 1, NULL, NULL, N'Hospital Punta Pacífica Pacífica Salud', NULL, 'Meningococo', 60,
     'LoteA11', NULL, NULL;
EXEC sp_vacunas_distribuir_vacunas 1, NULL, NULL, 'Hospital Nacional', NULL, 'MMR', 65, 'LoteA12', NULL, NULL;
EXEC sp_vacunas_distribuir_vacunas 1, NULL, NULL, 'Centro de salud Pacora', NULL, N'MR (antisarampión, antirrubéola)',
     70, 'LoteA13', NULL, NULL;
EXEC sp_vacunas_distribuir_vacunas 1, NULL, NULL, N'Hospital Dr. Nicolás A. Solano', NULL,
     'Neumoco conjugado (Prevenar 13 valente)', 75, 'LoteA14', NULL, NULL;
EXEC sp_vacunas_distribuir_vacunas 1, NULL, NULL, 'Complejo Hospitalario Dr. Manuel Amador Guerrero', NULL,
     'Papiloma Humano (Gardasil)', 80, 'LoteA15', NULL, NULL;
EXEC sp_vacunas_distribuir_vacunas 1, NULL, NULL, N'Policlínica Lic. Manuel María Valdés', NULL, 'Pneumo23', 85,
     'LoteA16', NULL, NULL;
EXEC sp_vacunas_distribuir_vacunas 1, NULL, NULL, 'CSS Complejo Metropolitano', NULL, 'Pneumovax', 90, 'LoteA17', NULL,
     NULL;
EXEC sp_vacunas_distribuir_vacunas 1, NULL, NULL, N'Hospital de Especialidades Pediátricas Omar Torrijos Herrena',
     NULL, 'Priorix', 95, 'LoteA18', NULL, NULL;
EXEC sp_vacunas_distribuir_vacunas 1, NULL, NULL, 'Hospital San Miguel Arcangel', NULL, 'Rotarix', 100, 'LoteA19', NULL,
     NULL;
EXEC sp_vacunas_distribuir_vacunas 1, NULL, NULL, 'MINSA CAPSI FINCA 30 CHANGINOLA', NULL, 'TD', 105, 'LoteA20', NULL,
     NULL;
EXEC sp_vacunas_distribuir_vacunas 1, NULL, NULL, 'Hospital Aquilino Tejeira', NULL, 'Tetravalente', 110, 'LoteA21',
     NULL, NULL;
EXEC sp_vacunas_distribuir_vacunas 1, NULL, NULL, 'CENTRO DE SALUD METETI', NULL, 'Varivax', 115, 'LoteA22', NULL, NULL;
EXEC sp_vacunas_distribuir_vacunas 1, NULL, NULL, 'POLICENTRO DE SALUD de Chepo', NULL, 'Verorab', 120, 'LoteA23', NULL,
     NULL;

PRINT (N'Insertando dosis a pacientes');
-- crear las dosis y relacionar con su paciente usando el procedimiento almacenado
EXEC sp_vacunas_insert_dosis '8-9754-1236', '2017-12-01 15:00', '1', NULL, 'Tetravalente', NULL,
     'Complejo Hospitalario Dr. Manuel Amador Guerrero', NULL, NULL;
EXEC sp_vacunas_insert_dosis '9-123-123', '2016-07-20 09:45', '1', NULL, 'Hep B (infantil)', NULL,
     'Hospital San Miguel Arcangel', NULL, NULL;
EXEC sp_vacunas_insert_dosis 'AB1234567X', '2015-03-14 13:30', '1', NULL, 'Hep B (adultos)', NULL,
     N'Hospital Regional de Changuinola Raul Dávila Mena', NULL, NULL;
EXEC sp_vacunas_insert_dosis '1-54-9635', '2024-08-10 10:00', '1', NULL, 'Hep B (adultos)', NULL,
     'Hospital Aquilino Tejeira', NULL, NULL;
EXEC sp_vacunas_insert_dosis '2-4567-876543', '2024-07-22 11:15', '1', NULL, 'Neumoco conjugado (Prevenar 13 valente)',
     NULL, N'Hospital Dr. Rafael Hernández', NULL, NULL;
EXEC sp_vacunas_insert_dosis '3-567-9876', '2024-06-30 13:00', '1', NULL, 'Hexaxim', NULL,
     N'Policlínica Lic. Manuel María Valdés', NULL, NULL;
EXEC sp_vacunas_insert_dosis '4-4321-123', '2024-05-25 14:30', '1', NULL, 'Papiloma Humano (Gardasil)', NULL,
     N'Hospital Santo Tomás', NULL, NULL;
EXEC sp_vacunas_insert_dosis '5AV-9-1234', '2024-04-15 09:00', '1', NULL, 'Varivax', NULL,
     N'Hospital de Especialidades Pediátricas Omar Torrijos Herrena', NULL, NULL;
EXEC sp_vacunas_insert_dosis '6-2345-123', '2024-03-20 10:30', '1', NULL, 'Pneumovax', NULL, 'Centro de salud Pacora',
     NULL, NULL;
EXEC sp_vacunas_insert_dosis '7-456-987', '2024-02-12 15:00', '1', NULL, 'Fiebre Amarilla', NULL, 'Hospital Nacional',
     NULL, NULL;
EXEC sp_vacunas_insert_dosis '8-12-321', '2024-01-30 16:45', '1', NULL, 'TD', NULL, 'Hospital San Miguel Arcangel',
     NULL, NULL;
EXEC sp_vacunas_insert_dosis '9-1-123456', '2023-12-25 09:30', '1', NULL, 'BCG', NULL,
     'Complejo Hospitalario Dr. Manuel Amador Guerrero', NULL, NULL;
EXEC sp_vacunas_insert_dosis 'AB9876543K', '2023-11-10 12:15', '1', NULL, 'Rotarix', NULL,
     N'Hospital Punta Pacífica Pacífica Salud', NULL, NULL;
EXEC sp_vacunas_insert_dosis 'CD6543210L', '2023-10-05 14:00', '1', NULL, 'Priorix', NULL, 'CSS Complejo Metropolitano',
     NULL, NULL;
EXEC sp_vacunas_insert_dosis 'E-12-123456', '2023-09-20 16:30', '1', NULL, 'Influenza (FluQuadri)', NULL,
     N'Hospital Regional de Changuinola Raul Dávila Mena', NULL, NULL;
EXEC sp_vacunas_insert_dosis 'E-7-7654', '2023-08-15 11:00', '1', NULL, 'Hep A (Euvax) (adultos)', NULL,
     'Hospital Aquilino Tejeira', NULL, NULL;
EXEC sp_vacunas_insert_dosis 'EF123456Z', '2023-07-10 09:45', '1', NULL, 'Tetravalente', NULL,
     N'Hospital Dr. Nicolás A. Solano', NULL, NULL;
EXEC sp_vacunas_insert_dosis 'GH3210987N', '2023-06-05 13:30', '1', NULL, 'Meningococo', NULL, N'Hospital Santo Tomás',
     NULL, NULL;
EXEC sp_vacunas_insert_dosis 'IJ789456A', '2023-05-25 10:00', '1', NULL, 'Hep B (infantil)', NULL,
     N'Policlínica Lic. Manuel María Valdés', NULL, NULL;
EXEC sp_vacunas_insert_dosis 'KL1098765P', '2023-04-20 14:15', '1', NULL, 'Neumoco conjugado (Prevenar 13 valente)',
     NULL, 'Complejo Hospitalario Dr. Manuel Amador Guerrero', NULL, NULL;
EXEC sp_vacunas_insert_dosis 'MN876543C', '2023-03-15 16:00', '1', NULL, 'Hep A (Euvax) (infantil)', NULL,
     'Centro de salud Pacora', NULL, NULL;
EXEC sp_vacunas_insert_dosis 'N-12-987', '2023-02-10 08:30', '1', NULL, 'BCG', NULL,
     N'Hospital Punta Pacífica Pacífica Salud', NULL, NULL;
EXEC sp_vacunas_insert_dosis 'OP8765432R', '2023-01-05 10:45', '1', NULL, 'Pneumovax', NULL,
     'Hospital San Miguel Arcangel', NULL, NULL;
EXEC sp_vacunas_insert_dosis 'PE-3456-321', '2022-12-25 13:00', '1', NULL, 'COVID-19', NULL, 'Hospital Nacional', NULL,
     NULL;
EXEC sp_vacunas_insert_dosis 'QR7654321S', '2022-11-10 11:30', '1', NULL, 'Fiebre Amarilla', NULL,
     N'Hospital Dr. Rafael Hernández', NULL, NULL;
EXEC sp_vacunas_insert_dosis 'ST6543210T', '2022-10-15 09:00', '1', NULL, 'COVID-19', NULL,
     N'Policlínica Lic. Manuel María Valdés', NULL, NULL;
EXEC sp_vacunas_insert_dosis 'UV5432109U', '2022-09-05 15:00', '1', NULL, 'Varivax', NULL,
     N'Hospital de Especialidades Pediátricas Omar Torrijos Herrena', NULL, NULL;
EXEC sp_vacunas_insert_dosis 'WX4561234H', '2022-08-20 10:30', '1', NULL, 'Priorix', NULL,
     'Complejo Hospitalario Doctor Arnulfo Arias Madrid', NULL, NULL;
EXEC sp_vacunas_insert_dosis 'YZ7890123J', '2022-07-10 12:45', '1', NULL, 'Influenza (FluQuadri)', NULL,
     'CSS Complejo Metropolitano', NULL, NULL;
EXEC sp_vacunas_insert_dosis '1PI-678-12', '2022-06-05 09:00', '1', NULL, 'Hep B (adultos)', NULL,
     N'Hospital Regional de Changuinola Raul Dávila Mena', NULL, NULL;
EXEC sp_vacunas_insert_dosis '2PI-3421-456', '2022-05-20 11:15', '1', NULL, 'Pneumovax', NULL, N'Hospital Santo Tomás',
     NULL, NULL;
EXEC sp_vacunas_insert_dosis '3-721-284', '2022-04-10 10:30', '1', NULL, 'MMR', NULL, 'Hospital Aquilino Tejeira', NULL,
     NULL;
EXEC sp_vacunas_insert_dosis '4-987-123456', '2022-03-15 14:00', '1', NULL, 'Neumoco conjugado (Prevenar 13 valente)',
     NULL, N'Hospital Dr. Nicolás A. Solano', NULL, NULL;
EXEC sp_vacunas_insert_dosis '5-678-98765', '2022-02-05 12:15', '1', NULL, 'Hep A (Euvax) (infantil)', NULL,
     'Centro de salud Pacora', NULL, NULL;
EXEC sp_vacunas_insert_dosis '6-12345-678', '2022-01-25 10:00', '1', NULL, 'Varivax', NULL,
     'Complejo Hospitalario Dr. Manuel Amador Guerrero', NULL, NULL;
EXEC sp_vacunas_insert_dosis '7-345-678', '2021-12-15 13:30', '1', NULL, 'Hep B (infantil)', NULL,
     'Hospital San Miguel Arcangel', NULL, NULL;
EXEC sp_vacunas_insert_dosis '8-1006-14', '2021-11-05 09:45', '1', NULL, 'TD', NULL,
     N'Policlínica Lic. Manuel María Valdés', NULL, NULL;
EXEC sp_vacunas_insert_dosis '9PI-234-1', '2021-10-20 12:00', '1', NULL, 'Hep B (adultos)', NULL,
     N'Hospital de Especialidades Pediátricas Omar Torrijos Herrena', NULL, NULL;
EXEC sp_vacunas_insert_dosis 'AB9876543K', '2021-09-10 14:15', '1', NULL, 'Pneumovax', NULL,
     'CSS Complejo Metropolitano', NULL, NULL;
EXEC sp_vacunas_insert_dosis 'CD9876543Y', '2021-08-01 10:30', '1', NULL, 'COVID-19', NULL,
     N'Hospital Punta Pacífica Pacífica Salud', NULL, NULL;
EXEC sp_vacunas_insert_dosis 'E-3456-78', '2021-07-15 13:45', '1', NULL, 'Influenza (FluQuadri)', NULL,
     N'Hospital Dr. Rafael Hernández', NULL, NULL;
EXEC sp_vacunas_insert_dosis 'EF4321098M', '2021-06-25 11:00', '1', NULL, 'Priorix', NULL, N'Hospital Santo Tomás',
     NULL, NULL;
EXEC sp_vacunas_insert_dosis 'GH6543210W', '2021-05-10 12:30', '1', NULL, 'Tetravalente', NULL,
     'Complejo Hospitalario Doctor Arnulfo Arias Madrid', NULL, NULL;
EXEC sp_vacunas_insert_dosis 'IJ2109876O', '2021-04-20 09:00', '1', NULL, 'Hep A (Euvax) (adultos)', NULL,
     N'Hospital Regional de Changuinola Raul Dávila Mena', NULL, NULL;
EXEC sp_vacunas_insert_dosis 'KL0123456B', '2021-03-15 10:45', '1', NULL, 'Neumoco conjugado (Prevenar 13 valente)',
     NULL, 'Hospital Aquilino Tejeira', NULL, NULL;
EXEC sp_vacunas_insert_dosis 'MN0987654Q', '2021-02-10 14:00', '1', NULL, 'BCG', NULL, 'Centro de salud Pacora', NULL,
     NULL;
EXEC sp_vacunas_insert_dosis 'N-56-2345', '2021-01-05 16:30', '1', NULL, 'Varivax', NULL,
     N'Hospital de Especialidades Pediátricas Omar Torrijos Herrena', NULL, NULL;
EXEC sp_vacunas_insert_dosis 'OP3456789D', '2020-12-15 13:00', '1', NULL, 'Pneumovax', NULL, N'Hospital Santo Tomás',
     NULL, NULL;
EXEC sp_vacunas_insert_dosis 'PE-8-567', '2020-11-10 10:30', '1', NULL, 'Hep B (infantil)', NULL,
     N'Policlínica Lic. Manuel María Valdés', NULL, NULL;
EXEC sp_vacunas_insert_dosis 'QR4567890E', '2020-10-05 09:45', '1', NULL, 'Hep A (Euvax) (infantil)', NULL,
     N'Hospital Punta Pacífica Pacífica Salud', NULL, NULL;
EXEC sp_vacunas_insert_dosis 'ST2345678F', '2020-09-20 15:00', '1', NULL, 'Priorix', NULL,
     'Complejo Hospitalario Doctor Arnulfo Arias Madrid', NULL, NULL;
EXEC sp_vacunas_insert_dosis 'UV3456789G', '2020-08-10 14:15', '1', NULL, 'MMR', NULL, 'Hospital Nacional', NULL, NULL;
EXEC sp_vacunas_insert_dosis 'WX4321098V', '2020-07-01 12:00', '1', NULL, 'Influenza (FluQuadri)', NULL,
     'Hospital San Miguel Arcangel', NULL, NULL;
EXEC sp_vacunas_insert_dosis 'YZ7890123J', '2020-06-10 11:15', '1', NULL, 'Hep A (Euvax) (adultos)', NULL,
     N'Hospital Dr. Rafael Hernández', NULL, NULL;
EXEC sp_vacunas_insert_dosis 'YZ7890123J', '2020-05-15 13:30', '1', NULL, 'Fiebre Amarilla', NULL,
     N'Hospital Regional de Changuinola Raul Dávila Mena', NULL, NULL;
EXEC sp_vacunas_insert_dosis '2-4558-5479', '2020-04-10 10:00', '1', NULL, 'Tetravalente', NULL,
     'Centro de salud Pacora', NULL, NULL;
EXEC sp_vacunas_insert_dosis '3PI-1-654', '2020-03-01 09:30', '1', NULL, 'Rotarix', NULL, 'Hospital Aquilino Tejeira',
     NULL, NULL;
EXEC sp_vacunas_insert_dosis '4-5678-12345', '2020-02-15 11:45', '1', NULL, 'Pneumo23', NULL,
     N'Hospital de Especialidades Pediátricas Omar Torrijos Herrena', NULL, NULL;
EXEC sp_vacunas_insert_dosis '5-567-65432', '2020-01-10 10:30', '1', NULL, 'Hep A (Euvax) (adultos)', NULL,
     N'Policlínica Lic. Manuel María Valdés', NULL, NULL;
EXEC sp_vacunas_insert_dosis '6-1234-65432', '2019-12-25 14:00', '1', NULL, 'Hep B (infantil)', NULL,
     N'Hospital Santo Tomás', NULL, NULL;
EXEC sp_vacunas_insert_dosis '7-4567-123', '2019-11-15 16:30', '1', NULL, 'COVID-19', NULL, 'Hospital Nacional', NULL,
     NULL;
EXEC sp_vacunas_insert_dosis '8-3456-123', '2019-10-05 09:00', '1', NULL, 'Hep B (adultos)', NULL,
     'Centro de salud Pacora', NULL, NULL;
EXEC sp_vacunas_insert_dosis '9PI-1-98765', '2019-09-20 11:15', '1', NULL, 'Varivax', NULL,
     N'Hospital Dr. Nicolás A. Solano', NULL, NULL;
EXEC sp_vacunas_insert_dosis 'AB1234567X', '2019-08-10 12:30', '1', NULL, 'Influenza (FluQuadri)', NULL,
     N'Hospital de Especialidades Pediátricas Omar Torrijos Herrena', NULL, NULL;
EXEC sp_vacunas_insert_dosis 'CD6543210L', '2019-07-05 13:00', '1', NULL, 'Meningococo', NULL,
     'Hospital Aquilino Tejeira', NULL, NULL;
EXEC sp_vacunas_insert_dosis 'E-12-123456', '2019-06-20 09:45', '1', NULL, 'TD', NULL,
     N'Hospital Regional de Changuinola Raul Dávila Mena', NULL, NULL;
EXEC sp_vacunas_insert_dosis 'E-78-654321', '2019-05-15 10:30', '1', NULL, 'Neumoco conjugado (Prevenar 13 valente)',
     NULL, N'Hospital Santo Tomás', NULL, NULL;
EXEC sp_vacunas_insert_dosis 'EF123456Z', '2019-04-10 11:45', '1', NULL, 'Hep B (adultos)', NULL,
     'Centro de salud Pacora', NULL, NULL;
EXEC sp_vacunas_insert_dosis 'GH6543210W', '2019-03-05 14:00', '1', NULL, 'Hexaxim', NULL,
     'Hospital San Miguel Arcangel', NULL, NULL;
EXEC sp_vacunas_insert_dosis 'IJ789456A', '2019-02-20 15:30', '1', NULL, 'COVID-19', NULL,
     N'Policlínica Lic. Manuel María Valdés', NULL, NULL;
EXEC sp_vacunas_insert_dosis 'KL1098765P', '2019-01-10 12:00', '1', NULL, 'Fiebre Amarilla', NULL,
     N'Hospital de Especialidades Pediátricas Omar Torrijos Herrena', NULL, NULL;
EXEC sp_vacunas_insert_dosis 'MN876543C', '2018-12-05 13:30', '1', NULL, 'Hep A (Euvax) (adultos)', NULL,
     'Hospital Nacional', NULL, NULL;
EXEC sp_vacunas_insert_dosis 'N-78-987', '2018-11-10 09:00', '1', NULL, 'Pneumo23', NULL,
     N'Hospital de Especialidades Pediátricas Omar Torrijos Herrena', NULL, NULL;
EXEC sp_vacunas_insert_dosis 'OP8765432R', '2018-10-01 10:15', '1', NULL, 'Priorix', NULL, 'Hospital Aquilino Tejeira',
     NULL, NULL;
EXEC sp_vacunas_insert_dosis 'PE-5-3456', '2018-09-15 12:00', '1', NULL, 'Varivax', NULL,
     N'Hospital Regional de Changuinola Raul Dávila Mena', NULL, NULL;
EXEC sp_vacunas_insert_dosis 'QR4567890E', '2018-08-10 13:00', '1', NULL, 'Meningococo', NULL, N'Hospital Santo Tomás',
     NULL, NULL;
EXEC sp_vacunas_insert_dosis 'ST6543210T', '2018-07-20 14:15', '1', NULL, 'TD', NULL,
     N'Policlínica Lic. Manuel María Valdés', NULL, NULL;
EXEC sp_vacunas_insert_dosis 'UV5432109U', '2018-06-10 16:00', '1', NULL, 'Hep B (infantil)', NULL,
     N'Hospital Dr. Nicolás A. Solano', NULL, NULL;
EXEC sp_vacunas_insert_dosis 'WX4321098V', '2018-05-05 10:30', '1', NULL, 'Neumoco conjugado (Prevenar 13 valente)',
     NULL, 'Centro de salud Pacora', NULL, NULL;
EXEC sp_vacunas_insert_dosis 'YZ7890123J', '2018-04-20 11:00', '1', NULL, 'Hexaxim', NULL,
     N'Hospital Punta Pacífica Pacífica Salud', NULL, NULL;
EXEC sp_vacunas_insert_dosis '1-145-987', '2018-03-15 12:15', '1', NULL, 'Influenza (FluQuadri)', NULL,
     N'Hospital de Especialidades Pediátricas Omar Torrijos Herrena', NULL, NULL;
EXEC sp_vacunas_insert_dosis '2-1234-654', '2018-02-10 09:45', '1', NULL, 'COVID-19', NULL,
     N'Hospital Regional de Changuinola Raul Dávila Mena', NULL, NULL;
EXEC sp_vacunas_insert_dosis '3-12-543', '2018-01-05 13:00', '1', NULL, 'Varivax', NULL,
     N'Policlínica Lic. Manuel María Valdés', NULL, NULL;
EXEC sp_vacunas_insert_dosis '4AV-8-12', '2017-12-15 10:30', '1', NULL, 'Hep B (adultos)', NULL,
     'Hospital Aquilino Tejeira', NULL, NULL;
EXEC sp_vacunas_insert_dosis '5-554-321', '2017-11-10 11:45', '1', NULL, 'Priorix', NULL,
     N'Hospital de Especialidades Pediátricas Omar Torrijos Herrena', NULL, NULL;
EXEC sp_vacunas_insert_dosis '6-2-987654', '2017-10-01 09:30', '1', NULL, 'Pneumovax', NULL,
     'Hospital San Miguel Arcangel', NULL, NULL;
EXEC sp_vacunas_insert_dosis '7-114-10', '2017-09-20 14:00', '1', NULL, 'Neumoco conjugado (Prevenar 13 valente)', NULL,
     'Complejo Hospitalario Dr. Manuel Amador Guerrero', NULL, NULL;
EXEC sp_vacunas_insert_dosis '8-123-1234', '2017-08-15 12:30', '1', NULL, 'Rotarix', NULL, 'Hospital Nacional', NULL,
     NULL;
EXEC sp_vacunas_insert_dosis '9PI-234-1', '2017-07-10 11:15', '1', NULL, 'Fiebre Amarilla', NULL,
     'Centro de salud Pacora', NULL, NULL;
EXEC sp_vacunas_insert_dosis 'AB9876543K', '2017-06-05 10:30', '1', NULL, 'Tetravalente', NULL, N'Hospital Santo Tomás',
     NULL, NULL;
EXEC sp_vacunas_insert_dosis 'CD9876543Y', '2017-05-20 09:00', '1', NULL, 'Hep A (Euvax) (adultos)', NULL,
     N'Hospital de Especialidades Pediátricas Omar Torrijos Herrena', NULL, NULL;
EXEC sp_vacunas_insert_dosis 'E-12-54321', '2017-04-10 13:00', '1', NULL, 'Hexaxim', NULL,
     N'Hospital Dr. Nicolás A. Solano', NULL, NULL;
EXEC sp_vacunas_insert_dosis 'EF4321098M', '2017-03-05 14:15', '1', NULL, 'Varivax', NULL,
     N'Hospital Regional de Changuinola Raul Dávila Mena', NULL, NULL;

PRINT('Insertando usuarios de roles superior de pruebas');
-- crear usuarios
EXEC sp_vacunas_gestionar_usuario '1-1-2', NULL, '', '2000-12-12', NULL, NULL;
EXEC sp_vacunas_insert_roles_usuario '1-1-2', '3', NULL;

EXEC sp_vacunas_gestionar_usuario '1-1-1', NULL, '', '2000-01-12', NULL, NULL;
EXEC sp_vacunas_insert_roles_usuario '1-1-1', '6', NULL;

PRINT (N'Fin de la inicialización vacunas Panamá');
USE master;
