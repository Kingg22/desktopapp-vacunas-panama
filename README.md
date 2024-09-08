# :syringe: Proyecto de Gestión de Información sobre Vacunación en Panamá

![Imagen logo del proyecto](https://github.com/Kingg22/Proyecto_App-MINSA-2.0/blob/558997ac0ca507279a87c716cf0c4a89aaf71eb0/src/images/operacionVacunas_logo_pequeno.png)

## Descripción

Este proyecto tiene como objetivo mejorar el control y la gestión de la información sobre vacunación en las distintas
sedes sanitarias de Panamá, tanto públicas como privadas. La implementación de este sistema permitirá optimizar el
seguimiento de las vacunaciones, mejorar la precisión de los datos y apoyar en la toma de decisiones para el control
sanitario del país. A continuación, se detallan los aspectos clave del proyecto, sus objetivos, alcance y
recomendaciones para su implementación.
Este proyecto consiste en el desarrollo de una API que gestiona la información sobre vacunación en Panamá. La
solución está diseñada utilizando tecnologías como Java con Spring Boot y SQL Server, y se enfoca en varios aspectos clave,
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

~~TODO Agregar limitaciones nuevas al readme~~

## :hammer_and_wrench:Tecnologías Utilizadas
- [Java](https://www.java.com/es/) - Para el desarrollo de la API.
- [SQL Server](https://www.microsoft.com/es-mx/sql-server) - Para la gestión de la base de datos.
- [Spring Boot](https://spring.io/) - Framework de Java, módulos utilizados: acceso a datos, web server, validaciones, seguridad y testing.
- [Spring Dotenv](https://github.com/paulschwarz/spring-dotenv) - Librería de Java para cargar las variables de entornos .env para Spring.
- [JDBC SQL Driver](https://learn.microsoft.com/en-us/sql/connect/jdbc/download-microsoft-jdbc-driver-for-sql-server?view=sql-server-ver16) - Driver para conectar con la base de datos SQL Server en Java.
- [Error handling Spring Boot](https://github.com/wimdeblauwe/error-handling-spring-boot-starter/) - Librería de Java para Spring Boot utilizada para dar Error Response uniformes y Logger de los mismos. 

## :pencil: Autores

- **Rey Acosta** - _Java_ - [kingg22](https://github.com/Kingg22)

## Conclusión

Este proyecto representa un paso significativo hacia la modernización y mejora del control de la vacunación en Panamá. A
través de la implementación de tecnologías modernas y prácticas de desarrollo robustas, se espera mejorar la eficiencia
y efectividad del sistema de salud en el manejo de la información sobre vacunación.

## :wrench: Clonación y configuración del repositorio
> [!NOTE]
> Para disfrutar de un buen ambiente para programar necesita Java JDK 21 ya instalado.
> Maven viene de forma portable con maven wrapper.

Sigue estos pasos para clonar el repositorio: 

Abre una terminal y ejecuta los siguientes comandos:
### 1. Clonar el repositorio
```bash
git clone https://github.com/Kingg22/Programa_Vacunas_Panama.git
```
### 2. Abrir la carpeta donde fue clonado el repositorio

### 3. Verificación
Utilizando el IDE integrado con Maven o el siguiente comando:
```bash
.\mvn clean spring-boot:run
```
Cualquier error verificar la versión del Java JDK, tu archivo .env, tener en resources/certs un certificado RSA 
(con nombres: public.pem y private.pem), la base de datos esté levantada y con las credenciales correctas.

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
- Se implementó una [convención de nombres](https://blog.sqlauthority.com/i/dl/SQLServerGuideLines.pdf), brindada por [Pinal Dave](https://blog.sqlauthority.com/) en su blog.
- El tipo de dato de las dosis se cambió a UUID para mejorar la concurrencia.
- Se centralizó el manejo de usuarios, roles y permisos, delegando la autorización a los sistemas.
- Se añadieron índices para optimizar las búsquedas.
- Las funciones devuelven columnas sin alias; los alias se usan solo en las vistas.

## :high_brightness: Recomendaciones para implementar esta API en producción
- Utilizar un gestor de secretos para los datos en .env
- Se está analizando traducir la base de datos para estandarizar principalmente los nombres de vacunas dando posibilidad a exportar datos.
- Separar el manejo de usuarios a otra base de datos incluyendo el registro de logs y tokens de autorización.
- Complemento a métricas y observabilidad implementando [Prometheus exporter](https://docs.spring.io/spring-boot/api/rest/actuator/prometheus.html) protegiendo el acceso a estas.
- Manejar con otros u más datos personales la recuperación de contraseña del usuario, similar a Panamá Digital.
- Migrar el OAuth Server de JWT hacia [Auth0](https://auth0.com/docs/quickstart/backend/java-spring-security5/interactive).
  - Utilizar un [Authentication Flow seguro](https://auth0.com/docs/get-started/authentication-and-authorization-flow#authorization-code-flow-with-enhanced-privacy-protection) de Auth0, garantizando la seguridad y confidencialidad de la data.
  - Con este feature abre la posibilidad de tener todos los JWT con las mismas credenciales entre varios sistemas y poder guardarlos en la BD de logs sugerida.
- Precisión en la Edad de los Pacientes: Utilizar eventos programados o jobs de SQL Server Agent para actualizar la edad de los pacientes anualmente en su cumpleaños.
- Implementar un sistema de autocompletado para evitar duplicidades y mejorar la precisión en la base de datos.
- Expediente Digital: Integrar reacciones a vacunas, efectos secundarios y contraindicaciones en el expediente digital del paciente.
- Esquemas Especiales de Vacunación: Implementar reglas de negocio para manejar esquemas especiales de vacunación para niños rezagados, mujeres embarazadas y otras poblaciones específicas.
- Autenticación de 2 Factores.
- Cifrar los datos sensibles en la base de datos y comunicación de los sistemas.
- Se está planeando para la v2:
  - Filtrado de respuestas. Con este feature se completa la migración de la versión desktoapp.
  - Paginación de respuestas.
  - Implementar sistema de caché con comodín para forzar la respuesta. 
  - Más herramientas de seguridad.
  - Generación de Certificados de Vacunas en formatos PDF.
  - Inicio de sesión con OAuth como Google para facilidad de los usuarios, únicamente se le pide su CIP como dato adicional.
### :busts_in_silhouette: Otros sistemas o API's que interactúen con la base de datos:
- Todos los sistemas creados que se conectan a esta API deben mantener el formato de CIP dada.
- Todas las contraseñas deben utilizar BCryptEncoder con strength 10.
- Validar los datos con pattern y demás, antes de conectar a la base de datos.
- Implementar la autorización basada en los roles y permisos.
- Si utilizan Persistence deben asegurarse que se verifique la estructura de la base de datos, NO modificarla, truncarla o generar una nueva.
- Obtener su usuario de acceso a la base de datos con permisos mínimos requeridos.
