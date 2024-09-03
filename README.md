# :syringe: Proyecto de Gestión de Información sobre Vacunación en Panamá

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

### :pushpin: Objetivo del Proyecto

El objetivo principal del proyecto es llevar un mejor control sobre la vacunación en las distintas sedes sanitarias del
país, brindando datos precisos para combatir y tomar medidas necesarias en casos de epidemias y pandemias. Este sistema
contribuirá al Plan Nacional de Salud 2016-2025, específicamente en la Política 2, que se enfoca en ejercer el liderazgo
en salud a nivel nacional y en la integración del sistema de información de salud en las entidades públicas y privadas.

### :dart: Alcance del Proyecto

Cobertura Nacional:
La base de datos será utilizada a nivel nacional por centros médicos estatales y centros privados que deseen participar.

~~Agregar limitaciones nuevas al readme~~

## :hammer_and_wrench:Tecnologías Utilizadas

**Trabajando en hacer referencia a las licencias correctamente. Una disculpa.**

- [Java](https://www.java.com/es/) - Para el desarrollo de la interfaz de usuario principal.
- [Python](https://www.python.org/) - Para el desarrollo de la interfaz de usuario de pacientes.
- [SQL Server](https://www.microsoft.com/es-mx/sql-server) - Para la gestión de la base de datos.
- [Spring](https://spring.io/)
- [Spring Dotenv](https://github.com/paulschwarz/spring-dotenv) - Librería de Java para cargar las variables de entornos .env para Spring
- [JDBC SQL Driver](https://learn.microsoft.com/en-us/sql/connect/jdbc/download-microsoft-jdbc-driver-for-sql-server?view=sql-server-ver16) -
  Driver para conectar con la base de datos SQL Server en Java.

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

Sigue estos pasos para clonar el repositorio, configurar el entorno en tu IDE y preparar el entorno virtual de Python: 

Abre una terminal y ejecuta los siguientes comandos:
### 1. Clonar el repositorio
```bash
git clone https://github.com/Kingg22/Programa_Vacunas_Panama.git
```
### 2. Abrir el proyecto donde fue clonado el repositorio

### 3. Verificación
Para verificar que todo ha sido configurado correctamente seguir los siguientes pasos:
#### 1. Crear el package con Maven
Utilizando el IDE integrado con Maven o el siguiente comando:
```bash
mvn package -f ".\pom.xml"
```
#### 2. Ejecutar en su consola:
```bash
java -jar .\target\Programa_Vacunas_Panama-0.1-jar-with-dependencies.jar
```
Cualquier error verificar la versión del Java JDK, el python venv y las rutas relativas o absolutas de los archivos.
