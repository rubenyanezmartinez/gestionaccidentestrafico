# Gestión Accidentes Tráfico
Proyecto para la asignatura Sistema Inteligentes del Máster en Ingeniería Informática



### Creación de base de datos
```
mysql> create database accidentes;
mysql> create user accidentes@localhost identified by "accidentes";
mysql> grant all privileges on accidentes.* to accidentes@localhost;
```

Adicionalmente, puede ser necesario establecer un formato de fecha compatible
```
mysql> set @@global.time_zone = '+00:00';
mysql> set @@session.time_zone = '+00:00';
```


### Crear un proyecto Maven usando el arquetipo `maven-archetype-quickstart` 
```
mvn archetype:generate -DgroupId=es.uvigo.mei \
                         -DartifactId=pedidos-persistencia \
                         -Dversion=1.0 \
                         -Dpackage=es.uvigo.mei.pedidos\
                         -DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeVersion=1.4
```
* Comprobar la estructura de directorios creada con `tree pedidos-persistencia` ó `ls -lR pedidos-persistencia`
* Comprobar el archivo `pom.xml`generado 
	1. Ajustar la versión de Java a utilizar, de 1.7 a 1.8 [la versión de Hibernte utilizada requiere Java 8 o superior]
```xml
  <properties>
    <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    <maven.compiler.source>1.8</maven.compiler.source>
    <maven.compiler.target>1.8</maven.compiler.target>
  </properties>
```

### Declarar las dependencias necesarias en `pom.xml`
1 Declarar el uso de Hibernate como _provider_ JPA (ver. 5.4.7) dentro de `<dependencies>...</dependencies>`
```xml
<project>
   ...
   <dependencies>
       <dependency>
          <groupId>org.hibernate</groupId>
          <artifactId>hibernate-entitymanager</artifactId>
          <version>5.4.23.Final</version>
       </dependency>
       ...
   </dependencies>
   ...
</project>
```
El resto de dependencias necesirias para `hibernate-entitymanager` serán descargadas e instalaldas por Maven.

2 Declarar el _connector_ JDBC para MySQL (ver. 8.0.18) dentro de `<dependencies>...</dependencies>`
```xml
<project>
   ...
   <dependencies>
      ...
      <dependency>
         <groupId>mysql</groupId>
         <artifactId>mysql-connector-java</artifactId>
         <version>8.0.22</version>
      </dependency>
   </dependencies>
   ...
</project>
```

### Ejecutar clase `Main` proporcionada
```
mvn package
mvn exec:java -Dexec.mainClass="es.uvigo.mei.accidentes.Main"

```