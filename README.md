# Título del Proyecto

Proyecto de Gestión de Información sobre Vacunación en Panamá

![Imagen logo del proyecto](https://github.com/Kingg22/Proyecto_App-MINSA-2.0/blob/558997ac0ca507279a87c716cf0c4a89aaf71eb0/src/images/operacionVacunas_logo_pequeno.png)

## Descripción

Este proyecto tiene como objetivo mejorar el control y la gestión de la información sobre vacunación en las distintas
sedes sanitarias de Panamá, tanto públicas como privadas. La implementación de este sistema permitirá optimizar el
seguimiento de las vacunaciones, mejorar la precisión de los datos y apoyar en la toma de decisiones para el control
sanitario del país. A continuación, se detallan los aspectos clave del proyecto, sus objetivos, alcance y
recomendaciones para su implementación.
Este proyecto consiste en el desarrollo de una aplicación que gestiona la información sobre vacunación en Panamá. La
solución está diseñada utilizando tecnologías como Java, Python y SQL Server, y se enfoca en varios aspectos clave,
incluyendo la precisión de los datos, la seguridad, la interoperabilidad y la facilidad de uso. Es un proyecto
universitario y solo realizamos la interfaz de usuario para pacientes, doctores y administradores por temas de tiempo.

:white_check_mark: Proyecto terminado para la universidad :white_check_mark:

:construction: Proyecto mejorado lentamente en los tiempos libres :construction:

## :hammer:Funcionalidades del proyecto

- `Funcionalidad 1`: descripción de la funcionalidad 1
- `Funcionalidad 2`: descripción de la funcionalidad 2
- `Funcionalidad 3`: descripción de la funcionalidad 3

### Objetivo del Proyecto

El objetivo principal del proyecto es llevar un mejor control sobre la vacunación en las distintas sedes sanitarias del
país, brindando datos precisos para combatir y tomar medidas necesarias en casos de epidemias y pandemias. Este sistema
contribuirá al Plan Nacional de Salud 2016-2025, específicamente en la Política 2, que se enfoca en ejercer el liderazgo
en salud a nivel nacional y en la integración del sistema de información de salud en las entidades públicas y privadas.

### Alcance del Proyecto

Cobertura Nacional:
La base de datos será utilizada a nivel nacional por centros médicos estatales y centros privados que deseen participar.

### Limitaciones del Proyecto

- Nuestras GUI están creadas para Escritorio.
- Preferencias del usuario local de Java.
- Cifrado de datos solamente en contraseñas.
- El proyecto fue pensando de manera local respecto a conexión con la base de datos e inicio de la GUI.
- Las tablas en Java Swing tienen algún problema de renderizado donde los títulos y data en las columnas derechas se
  desfasan. Estamos investigando si fue error de implementación o del lenguaje.
- Si del proyecto creamos un ejecutable para los usuarios, este tendría que ser para escritorio y límitado a instalarlo
  incluso para el paciente consultar sus dosis 1 sola vez.
- De las reglas de vacunación en el proyecto solo implementamos: la edad mínima, intervalo entre primera y segunda
  dosis.
- El listado de vacunas (por lo tanto, enfermedades, síntomas y 1 fabricante por vacuna) fue
  del [esquema de vacunación de Panamá 2023 abril](https://www.spp.com.pa/publicaciones/documentos-interes/vacunacion/ESQUEMA-DE-VACUNACION_2023_3Abril.pdf).

### Recolección de Datos:

Capturar información detallada sobre las vacunas, eventos supuestamente atribuibles a la vacunación e inmunización
(ESAVI), y datos demográficos de los pacientes.

### Gestión de Información:

Permitir la entrada, actualización y eliminación de datos sobre vacunaciones.

### Seguridad:

Implementar mecanismos de seguridad para proteger la información sensible de los pacientes.

### Interoperabilidad:

Asegurar que la base de datos pueda integrarse con otros sistemas de información de salud.

## Recomendaciones para la Implementación

### Precisión en la Edad de los Pacientes:

Utilizar eventos programados o jobs de SQL Server Agent para actualizar la edad de los pacientes anualmente en su
cumpleaños.

### Autocompletado de Direcciones:

Implementar un sistema de autocompletado para evitar duplicidades y mejorar la precisión en la base de datos.

### Expediente Digital:

Integrar reacciones a vacunas, efectos secundarios y contraindicaciones en el expediente digital del paciente.

### Esquemas Especiales de Vacunación:

Implementar reglas de negocio para manejar esquemas especiales de vacunación para niños rezagados, mujeres embarazadas y
otras poblaciones específicas.

### Mejora en la Validación de Datos:

Fortalecer la validación de datos en la entrada para asegurar la calidad de la información y seguridad.

### Generación de Certificados de Vacunas:

Implementar la generación de certificados de vacunas en formatos PDF, Excel.

### Autenticación de 2 Factores:

Añadir autenticación de dos factores vía correo electrónico para mejorar la seguridad del sistema.

### Seguridad de la Base de Datos:

Implementar timeout para consultas a la base de datos y manipulación de información, y cifrar los datos sensibles.

### Gestión de Usuarios y Roles:

Cambiar el enfoque de usuarios específicos a roles con permisos específicos, y utilizar usuarios individuales para cada
paciente.

### Interfaz de Usuario Portable:

Desarrollar la aplicación como una solución web o de microservicios para facilitar el acceso sin necesidad de instalar
una aplicación de escritorio.

### Preferencias de Interfaz:

Permitir personalización de la interfaz de usuario, como tamaño y tipo de letra, independiente de la plataforma y
arquitectura.

### Auditoría y Logs:

Mantener logs de todos los eventos en la base de datos para realizar auditorías.

## :hammer_and_wrench:Tecnologías Utilizadas

* [Java](https://www.java.com/es/) - Para el desarrollo de la interfaz de usuario principal.
* [Python](https://www.python.org/) - Para el desarrollo de la interfaz de usuario de pacientes.
* [SQL Server](https://www.microsoft.com/es-mx/sql-server) - Para la gestión de la base de datos.
* [Absolute Layout](https://www.cs.brandeis.edu/~hosang/BiVoSite/API/org/netbeans/lib/awtextra/AbsoluteLayout.html) -
  Layout para posiciones fijas del GUI Building by Netbeans
* [Bcrypt](https://docs.spring.io/spring-security/reference/features/integrations/cryptography.html) - Librería de
  Spring Security Crypto que utilizamos para el hash de contraseñas.
* [Dotenv-Java](https://github.com/cdimascio/dotenv-java) - Librería de Java para cargar las variables de entornos .env
* [Dotenv-Python](https://github.com/theskumar/python-dotenv) - Librería de Python para cargar las variables de entorno
  .env
* [JDBC SQL Driver](https://learn.microsoft.com/en-us/sql/connect/jdbc/download-microsoft-jdbc-driver-for-sql-server?view=sql-server-ver16) -
  Driver para conectar con la base de datos SQL Server en Java
* [ODBC Driver](https://github.com/mkleehammer/pyodbc) - Driver para conectar bases de datos en Python

## Autores

* **Rey Acosta** - *Java* - [Kingg22](https://github.com/Kingg22)
* **Patrick Villarroel** - *Python* - [patrickvillarroel](https://github.com/patrickvillarroel)

## Conclusión

Este proyecto representa un paso significativo hacia la modernización y mejora del control de la vacunación en Panamá. A
través de la implementación de tecnologías modernas y prácticas de desarrollo robustas, se espera mejorar la eficiencia
y efectividad del sistema de salud en el manejo de la información sobre vacunación.