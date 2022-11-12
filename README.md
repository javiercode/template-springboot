# Springboot

SpringBoot es un framework de Spring que permite crear aplicaciones standalone, sin necesidad de un servidor de aplicaciones externo a ella.

Para iniciar una aplicación SB (SpringBoot a partir de ahora) bastará con ejecutar el comando "java -jar nombre_de_la_aplicacion.jar"

## Índice
1. Introducción
2. Instalación
3. Habilitación de entorno
4. Plantilla Springboot
5. Primer rest
7. Consejos
8. FAQs
9. referencias

## Introducción

[`Spring Boot`] es un framework enfocado a la creación de aplicaciones basadas en Spring sin necesidad de contenedor de aplicaciones.

A pesar de poder ejecutar aplicaciones SB en Java 17. Recuerda que el compilado se ejecuta con un entorno virtual JRE

Los requisitos para tener configurado este proyecto son:
- **Manejador de dependencias:** El control de tecnologias que estaran disponibles y configuradas en nuestro proyecto.
- **Lenguaje de programación:** Para este caso usaremos Java 17 (que para la fecha es la version LTS).
- **Framework:** El framework más usado y común y que lo usaremos es Sprinboot.
- **IDE:** Este tutorial estará configurado para que incluso lo arranques de un bloc de notas, pero habra ejemplos con Jetbrains - Idea.


**[Ir al índice](#Índice)**

## Instalación
En este ejemplo se despliegue SB con Maven 3.8.6. Se puede consultar los pasos para realizar su instalación en la siguiente dirección [http://maven.apache.org/](http://maven.apache.org/).

También se desarrollo con el kit de desarrollo opensource (OpenJdk) version 17. La misma esta disponible en la siguiente dirección [https://docs.microsoft.com/es-es/java/openjdk/download/](https://docs.microsoft.com/es-es/java/openjdk/download/).

**Spring Initializr**

Con esta página puedes crear un proyecto base de SpringBoot en la siguiente dirección [https://start.spring.io/](https://start.spring.io/).

**SpringBoot CLI**

Tanto NetBeans o Intellijent Idea tienen integrado la opción de creación de un proyecto base con SB.


**[Ir al índice](#Índice)**

## Habilitación de entorno

Se necesita configurar únicamente MAVEN_HOME y JAVA_HOME:

- **MAVEN_HOME:** Para esto solo es necesario configurarlo con el archivo binario.
- **JAVA_HOME:** Para esto solo es necesario configurarlo con el archivo binario.

En el caso de usar Eclipse entonces:
- **STS plugin:** A través del propio ide STS que se puede descargar desde el siguiente [enlace](https://spring.io/tools/sts/all) se facilita de la posibilidad al usuario para crear un proyecto base. Para ello únicamente es necesario seguir los siguientes pasos:

**[Ir al índice](#Índice)**

## Plantilla Springboot

La clase principal se compila en base al archivo principal y se puede ejecutar con el siguiente ejemplo:

```java
@SpringBootApplication
public class DemoBGApplication {
	public static void main(String[] args) {
		SpringApplication.run(DemoBGApplication.class, args);
	}
	
	@Bean 
	public String saluda(){
		System.out.println("Hola mundo...");
		return "";
	}
	
}
```

Si arrancamos de nuevo la aplicación veremos cómo aparece en los logs la frase que hemos introducido "Hola mundo...".

Para ejecutar nativamente el proyecto usa los siguientes comandos,
- **para desarrollar**:
```cmd
mvn clean install
mvn spring-boot:run
```
- **para compilar**:
```cmd
mvn clean install
java -jar SpringBootHolaMundo-0.0.1-SNAPSHOT.jar
```

**[Ir al índice](#Índice)**

## Primer rest

Para implementar un servicio rest solo es necesario crear un archivo controlador con el siguiente formato:

La clase principal se compila en el proyecto y se puede ejecutar con el siguiente ejemplo:

```java
@RestController
public class TestController {

    @Autowired
	private ACHService achServicio;

    @GetMapping("/test")
    public ResponseEntity<String> test(){
        return new ResponseEntity<String>("Hola mundo!!", HttpStatus.OK);
    }
}
```
y si lo ejecutamos con os comandos mencionados sale:

<p align="center"><img src="https://raw.githubusercontent.com/javiercode/demoBG/main/src/main/resources/assets/holaMundo.png"></p>

**[Ir al índice](#Índice)**


## Consejos
En el siguiente apartado se han recopilado distintos consejos obtenidos con la experiencia a la hora de realizar desarrollos mediante el framework de SB:
### Estructura de un proyecto SB
La estructuración típica de los ficheros de una aplicación SB con distintas capas se definirá siguiendo la siguiente nomenclatura de paquetes:
```xml
└── src/main/java
    └── bg.com.bo.demoBG
        └── DemoBgApplication.java
    └── web/
        └── TestController.java
```
Para agreagar swwager solo añada la siguientes dependencias del siguiente [enlace](https://www.baeldung.com/spring-rest-openapi-documentation)

- Añada la dependencia de documentacion:
```xml
<dependency>
  <groupId>org.springdoc</groupId>
  <artifactId>springdoc-openapi-ui</artifactId>
  <version>1.6.4</version>
</dependency>
```
- Se podrá ver la documentacion asi:
<p align="center"><img src="https://raw.githubusercontent.com/javiercode/demoBG/main/src/main/resources/assets/api-docs.png"></p>
- Tambien se podra ver el resultado asi:

- Se puede acceder al listado de api docs desde [enlace](http://localhost:8080/v3/api-docs/).
- Se puede acceder al SWAGGER desde el siguiente [enlace](http://localhost:8080/swagger-ui.html).
- Se puede acceder al SWAGGER con el path (/apuesta/api), click el siguiente [enlace](http://localhost:8080/apuesta/api/swagger-ui.html).
- Se puede acceder al SWAGGER con el path en heroku, click el siguiente [enlace](https://template-springboot.herokuapp.com/apuesta/api/swagger-ui/index.html).
<p align="center"><img src="https://raw.githubusercontent.com/javiercode/demoBG/main/src/main/resources/assets/swagger.png"></p>

**[Ir al índice](#Índice)**

Para agreagar conexion a bd se usa y mapear las tablas se usan la siguientes dependencias

- Añada la dependencia de documentacion:
```xml
<dependencies>
  <dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <scope>runtime</scope>
  </dependency>
  <dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-jpa</artifactId>
  </dependency>
</dependencies>
```

**[Ir al índice](#Índice)**

### ¿Cómo se puede configurar una aplicación Spring Boot para que se redesplieguen los cambios automáticamente?
Mediante el uso de DevTools:
```xml
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-devtools</artifactId>
</dependency>
```

## Referencias
* [Spring Boot - Reference Documentation](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/)
* [Spring Boot in Action](https://doc.lagout.org/programmation/Spring%20Boot%20in%20Action.pdf)
* [Spring Boot Learn by examples](http://samples.leanpub.com/springboot-learn-by-example-sample.pdf)
* [Ejemplos de Spring Boot](https://github.com/spring-projects/spring-boot/tree/master/spring-boot-samples)
  **[Ir al índice](#Índice)**