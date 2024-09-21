# :syringe: Proyecto de Gestión de Información sobre Vacunación en Panamá

![Imagen logo del proyecto](https://github.com/Kingg22/desktopapp-vacunas-panama/blob/8a9c61eaada5e77ada158bd032a3814ea4402b22/src/main/resources/images/operacionVacunas_logo_pequeno.png)

## Descripción

Este proyecto tiene como objetivo mejorar el control y la gestión de la información sobre vacunación en las distintas
sedes sanitarias de Panamá, tanto públicas como privadas. La implementación de este sistema permitirá optimizar el
seguimiento de las vacunaciones, mejorar la precisión de los datos y apoyar en la toma de decisiones para el control
sanitario del país. A continuación, se detallan los aspectos clave del proyecto, sus objetivos, alcance y
recomendaciones para su implementación.
Este proyecto consiste en el desarrollo de una API que gestiona la información sobre vacunación en Panamá. La
solución está diseñada utilizando tecnologías como Java con Spring Boot y SQL Server, y se enfoca en varios aspectos
clave,
incluyendo la precisión de los datos, la seguridad, la interoperabilidad y la facilidad de uso.

:construction: Proyecto mejorado lentamente en los tiempos libres :construction:

### :pushpin: Objetivo del Proyecto

El objetivo principal del proyecto es llevar un mejor control sobre la vacunación en las distintas sedes sanitarias del
país, brindando datos precisos para combatir y tomar medidas necesarias en casos de epidemias y pandemias. Este sistema
contribuirá al Plan Nacional de Salud 2016-2025, específicamente en la Política 2, que se enfoca en ejercer el liderazgo
en salud a nivel nacional y en la integración del sistema de información de salud en las entidades públicas y privadas.

### :dart: Alcance del Proyecto

Cobertura Nacional:
La base de datos será utilizada a nivel nacional por centros médicos estatales y centros privados que deseen participar.

## :x: Limitaciones actuales de la API

- Los roles es una entidad que se puede modificar posterior a la creación del enum utilizado por la API al verificar los
  roles y su jerarquía.
  Se debe modificar a medida que los roles cambien.
- Se valida el formato del email mas no su dominio existente.
- La v1 de la API está limitada en:
    - Búsquedas por ID, por ejemplo no puedes buscar un paciente por su fecha de nacimiento solo por su CIP. Como
      paliativo a esto se utilizan funciones.
    - No hay endpoint u operaciones asíncronas.
- De las reglas de vacunación en el proyecto solo implementamos: la edad mínima, intervalo entre primera y segunda
  dosis.
- Aún no se implementan las reglas de negocio para manejar esquemas especiales de vacunación para niños rezagados,
  mujeres embarazadas y
  otras poblaciones específicas.
- El listado de vacunas (por lo tanto, enfermedades, síntomas y 1 fabricante por vacuna) se mantiene
  el [esquema de vacunación de Panamá 2023 abril](https://www.spp.com.pa/publicaciones/documentos-interes/vacunacion/ESQUEMA-DE-VACUNACION_2023_3Abril.pdf).

## :hammer_and_wrench:Tecnologías Utilizadas

- [Java](https://www.java.com/es/) - Para el desarrollo de la API.
- [SQL Server](https://www.microsoft.com/es-mx/sql-server) - Para la gestión de la base de datos.
- [Spring Boot](https://spring.io/) - Framework de Java, módulos utilizados: acceso a datos, web server, validaciones,
  seguridad y testing.
- [Spring Dotenv](https://github.com/paulschwarz/spring-dotenv) - Librería de Java para cargar las variables de entornos
  .env para Spring.
- [JDBC SQL Driver](https://learn.microsoft.com/en-us/sql/connect/jdbc/download-microsoft-jdbc-driver-for-sql-server?view=sql-server-ver16) -
  Driver para conectar con la base de datos SQL Server en Java.
- [Error handling Spring Boot](https://github.com/wimdeblauwe/error-handling-spring-boot-starter/) - Librería de Java
  para Spring Boot utilizada para dar Error Response uniformes y Logger de los mismos.

Puede encontrar más detalles de las licencias
en [THIRD-PARTY](https://github.com/Kingg22/desktopapp-vacunas-panama/blob/fe49877f9930485f0dc147c5dc2938b427588f39/THIRD-PARTY.txt)

## :pencil: Autores

- **Rey Acosta** - _Java_ - [kingg22](https://github.com/Kingg22)

## Conclusión

Este proyecto representa un paso significativo hacia la modernización y mejora del control de la vacunación en Panamá. A
través de la implementación de tecnologías modernas y prácticas de desarrollo robustas, se espera mejorar la eficiencia
y efectividad del sistema de salud en el manejo de la información sobre vacunación.

## :loudspeaker: Diferencias de api respecto a desktoapp

### Sistema

- Se adoptó una arquitectura API REST manteniendo la lógica existente.
- Se reemplazó JDBC por Jakarta Persistence para optimizar la persistencia.
- La tokenización mediante JWT sigue vigente, cambio de algorithm a RSA y mayor información de claims.
- Mayor documentación del código y API.
- Adición de test unitarios.
- Se definen patrones alternativos a la cédula de identificación personal de Panamá (en adelante CIP):
    - Recién nacidos no registrado: Registre con la cédula de la madre con las letras RN o múltiples con RN1 máximo 19.
    - No identificados: Registrar con identificador de la sede con las letras "NI-" al inicio.
    - Pasaporte: Tal cual escrito máximo 20 caracteres. Recomendamos reducir el uso de esta opción.

### Base de datos

- Se implementó una [convención de nombres](https://blog.sqlauthority.com/i/dl/SQLServerGuideLines.pdf), brindada
  por [Pinal Dave](https://blog.sqlauthority.com/) en su blog, modificada.
- Los tipos de datos fueron cambiados para mejorar rendimiento y concurrencia.
- Se centralizó el manejo de usuarios, roles y permisos, delegando la autorización a los sistemas.
- Se añadieron índices para optimizar las búsquedas.
- Las funciones devuelven columnas sin alias; los alias se usan solo en las vistas.
- Más procedimientos almacenados para facilitar transacciones comunes.
- Se define el campo "licencia" para los fabricantes puedan utilizarlo como CIP de su usuario, esto facilita la búsqueda
  del fabricante con su JWT.
- Más datos de pruebas.

## :high_brightness: Recomendaciones para implementar esta API en producción

- Utilizar un gestor de secretos para los datos en el .env
- Se está analizando traducir la base de datos para estandarizar principalmente los nombres de vacunas dando posibilidad
  a exportar datos.
- Separar el manejo de usuarios a otra base de datos incluyendo el registro de logs y tokens de autorización.
- Complemento a métricas y observabilidad
  implementando [Prometheus exporter](https://docs.spring.io/spring-boot/api/rest/actuator/prometheus.html) protegiendo
  el acceso a estas.
- Manejar con otros u más datos personales la recuperación de contraseña del usuario, similar a Panamá Digital.
- Migrar el OAuth Server de JWT
  hacia [Auth0](https://auth0.com/docs/quickstart/backend/java-spring-security5/interactive).
    - Utilizar
      un [Authentication Flow seguro](https://auth0.com/docs/get-started/authentication-and-authorization-flow#authorization-code-flow-with-enhanced-privacy-protection)
      de Auth0, garantizando la seguridad y confidencialidad de la data.
    - Con este feature abre la posibilidad de tener todos los JWT con las mismas credenciales entre varios sistemas y
      poder guardarlos en la BD de logs sugerida.
- Precisión en la Edad de los Pacientes: Utilizar eventos programados o jobs de SQL Server Agent para actualizar la edad
  de los pacientes anualmente en su cumpleaños.
- Implementar un sistema de autocompletado para evitar duplicidades y mejorar la precisión en la base de datos.
- Crear [índices de texto](https://learn.microsoft.com/es-es/sql/t-sql/statements/create-fulltext-index-transact-sql?view=sql-server-ver16)
en el idioma de los datos para facilitar este feature y reducir el tiempo de búsquedas.
- Expediente Digital: Integrar reacciones a vacunas, efectos secundarios y contraindicaciones en el expediente digital
  del paciente.
- Esquemas Especiales de Vacunación: Implementar reglas de negocio para manejar esquemas especiales de vacunación para
  niños rezagados, mujeres embarazadas y otras poblaciones específicas.
- Autenticación de 2 Factores.
- Cifrar los datos sensibles en la base de datos y comunicación de los sistemas.
- Se está planeando para la v2:
    - Filtrado de respuestas. Con este feature se completa la migración de la versión desktoapp.

### :busts_in_silhouette: Otros sistemas o API's que interactúen con la base de datos:

- Todos los sistemas creados que se conectan a esta API deben mantener el formato de CIP dada.
- Todas las contraseñas deben utilizar BCryptEncoder con strength 10.
- Validar los datos con pattern y demás, antes de conectar a la base de datos.
- Implementar la autorización basada en los roles y permisos.
- Si utilizan Persistence deben asegurarse que se verifique la estructura de la base de datos, NO modificarla, truncarla
  o generar una nueva.
- Obtener su usuario de acceso a la base de datos con permisos mínimos requeridos.

## :wrench: Clonación y configuración del repositorio

> [!NOTE]
> Para disfrutar de un buen ambiente para **programar** necesita Java JDK 21 ya instalado.
> Maven viene de forma portable con maven wrapper. Docker y Git son necesarios.

Sigue estos pasos para clonar el repositorio:

Abre una terminal y ejecuta los siguientes comandos:

### 1. Clonar el repositorio

```bash
git clone https://github.com/Kingg22/desktopapp-vacunas-panama.git
```

### 2. Abrir la carpeta donde fue clonado el repositorio

### 3. Crear entorno propio para deploy

1. Modificar vacunas-init.sql el login colocando una contraseña segura.
2. Con las credenciales anteriores colocarlo en su .env DB_USER y DB_PASSWORD.
    - Recordatorio: Al estar en docker la URL de la base de datos no es localhost sino la IP del host y el puerto
      externo que coloquemos, inicialmente 1440.
    - Colocar characterEncoding=UTF-8;useUnicode=true al final de la URL para mostrar los carácteres del español.
3. Crear el par de llaves del certificado RSA. Abra una terminal de git en el proyecto y ejecute:
    ``` bash
    openssl genrsa -out private.pem 4096
    openssl rsa -in private.pem -pubout -out public.pem
    ```
4. Colocar en su .env como JWT_PRIVATE y JWT_PUBLIC el contenido de cada archivo correspondiente. Puede eliminar los
   archivos por seguridad.
    1. Se tiene un [problema](https://github.com/cdimascio/dotenv-java/issues/77) con los valores multi líneas y la
       dependencia real que tiene el proyecto (spring dotenv) también la sufre.
    2. Para solucionar el problema anterior debe colocar el contenido generado en las llaves de forma que cada fin de
       línea eliminar ese espacio, debe quedarle un string largo.
5. Por último en el archivo .env, JWT_EXPIRATION_TIME y JWT_ISSUER puede personalizarlo a su gusto.
6. Configurar su contraseña sa en docker-compose.yaml. Tenga **mucho cuidado** con subir este archivo.
7. Crear la docker images de la API con su IDE o terminal con maven.
    ``` bash
    mvn clean spring-boot:build-image -DskipTests=true 
    ```
   Este proceso puede demorar un poco la primera vez, se recomienda skip tests para disminuir el tiempo de espera.
8. Levantar docker compose por primera vez. Abra una terminal en el proyecto y ejecute:
    ``` bash
    docker-compose up --build -d bd-vacunas
    docker exec -it sql-server-vacunas /opt/mssql-tools18/bin/sqlcmd -S localhost -U SA -P '' -No -C -d master -i /vacunas-init.sql
    ```
   Donde en -P debe colocar la contraseña creada en el docker-compose.yaml

   Observación: Si cambia el nombre del contenedor de la base de datos el comando cambia en -it <container_name>.
9. Verificar que la base de datos fue creada con éxito.

   Utilizando [docker desktop](https://www.docker.com/products/docker-desktop/) podrá ver los 2 contenedores, revise el
   log de sql_server_vacunas, una de las últimas instrucciones debe ser
    ``` sql
    (1 rows affected)
    Changed database context to 'master'.
    ```
   O puede ser
    ``` sql
    Starting up database 'vacunas'.
    Parallel redo is started for database 'vacunas' with worker pool size [4].
    Parallel redo is shutdown for database 'vacunas' with worker pool size [4].
    ```
   En su defecto utilice una terminal en el proyecto ejecute:
    ``` bash
    docker logs sql-server-vacunas
    ```

### 4. Levantar los contenedores después de configurar:

1. Cambiar los tiempos del healthcheck en docker-compose.yaml como mínimo de start_period 20s
2. Abrir una terminal en el proyecto para levantar todo si no está activa, ejecutar:
   ``` bash
   docker-compose up --build -d
   ```

### 5. Verificación

Con un cliente como [Postman](https://www.postman.com/) puede probar los endpoint con localhost:8080

Observación: Si cambia el puerto que se expone en docker-compose.yaml debe apuntar a este nuevo puerto.

### Verificar modificaciones sin desplegar contenedor de API

1. Levantar la base de datos si no esta activa:
    ``` bash
    docker-compose up --build -d bd-vacunas 
    ```
2. Utilizando el IDE integrado con Maven o el siguiente comando:
    ```bash
    mvn clean spring-boot:run
    ```
3. Utilizar el cliente Postman o su propio API client al endpoint configurado.

Cualquier error verificar la versión del Java JDK 21, tu archivo .env, certificado RSA mínima 2056,
la base de datos esté levantada y con las credenciales correctas, el login tiene su usuario con los permisos mínimos
requeridos,
todas las tablas y datos iniciales esten presentes.
