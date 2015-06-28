# Ejemplo de CRUD basado en Appfuse #

  * [Creamos la estructura a partir de un archetipo Maven](Struts2Appfuse#Creamos_la_estructura_a_partir_de_un_archetipo_Maven.md)
  * [Compilamos el proyecto Maven](Struts2Appfuse#Compilamos_el_proyecto_Maven.md)
  * [Desplegamos la aplicación en un Servidor](Struts2Appfuse#Desplegamos_la_aplicaci&oacute;n_en_un_Servidor.md)
  * [Ejecutamos la aplicación](Struts2Appfuse#Ejecutamos_la_aplicaci&oacute;n.md)
  * [Importamos a Eclipse el proyecto Maven](Struts2Appfuse#Importamos_a_Eclipse_el_proyecto_Maven.md)
  * [Creamos una nueva Entidad](Struts2Appfuse#Creamos_una_nueva_Entidad.md)

_NOTA: Para poder probar este ejemplo deberemos instalarnos ApacheMaven2 y MySQL 5.0_

## Creamos la estructura a partir de un archetipo Maven ##

Creamos una aplicación **struts2app** a partir del archetipo Maven **Struts 2 Basic**:

Nos abrimos una consola de comandos y nos situamos en el directorio de nuestro workspace de Eclipse `C:\CEMi_J2EE`:

```
C:\CEMi_J2EE> mvn archetype:create / 
 -DarchetypeGroupId=org.appfuse.archetypes /
 -DarchetypeArtifactId=appfuse-basic-struts /
 -DremoteRepositories=http://static.appfuse.org/releases /
 -DarchetypeVersion=2.0.2 
 -DgroupId=es.cemi.samples -DartifactId=struts2app
```

## Compilamos el proyecto Maven ##

A continuación realizamos la primera compilación del ejemplo. Dicha compilación con Maven tiene asociada una descarga importante de JARs que puede tardar mucho tiempo. Para acelerar este proceso, contamos en el aptdo. de descargas con un **repository.rar** que podremos descomprimir en nuestro repositorio Maven: `%M2_HOME%\repository`

Una vez tengamos todos los JARs, ya podemos proceder a realizar la primera compilación:

```
C:\CEMi_J2EE\struts2app> mvn clean install
```

```
...
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESSFUL
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 8 minutes 1 second
[INFO] Finished at: Thu Oct 22 21:32:14 CEST 2009
[INFO] Final Memory: 65M/254M
[INFO] ------------------------------------------------------------------------
C:\CEMi_J2EE\struts2app>
```

## Desplegamos la aplicación en un Servidor ##

Arrancamos la aplicación mediante el [Tomcat Maven Plugin](http://mojo.codehaus.org/tomcat-maven-plugin/):

```
C:\CEMi_J2EE\struts2app> mvn tomcat:run-war
```

```
[INFO] [war:war {execution: default-war}]
...
[INFO] Generating war C:\00-FACTORIA\Proyectos\CEMi_J2EE\struts2app\target\struts2app-1.0-SNAPSHOT.war
[INFO] Building war: C:\00-FACTORIA\Proyectos\CEMi_J2EE\struts2app\target\struts2app-1.0-SNAPSHOT.war
[INFO] [tomcat:run-war {execution: default-cli}]
[INFO] Running war on http://localhost:8080/struts2app
...
INFO: Initializing Spring root WebApplicationContext
[struts2app] WARN [main] Settings.getLocale(143) | Settings: Could not parse struts.locale setting, substituting default VM locale
23-oct-2009 16:01:07 org.apache.coyote.http11.Http11Protocol init
INFO: Initializing Coyote HTTP/1.1 on http-8080
23-oct-2009 16:01:07 org.apache.coyote.http11.Http11Protocol start
INFO: Starting Coyote HTTP/1.1 on http-8080
```

## Ejecutamos la aplicación ##

Accedemos a la aplicación desde un navegador: http://localhost:8080/struts2app

Introducimos las credenciales: `admin`/`admin`

## Importamos a Eclipse el proyecto Maven ##

Por último, importamos **struts2app** a nuestro _workspace_ de Eclipse. Para realizar esta operación, tenemos dos posibilidades:
  1. Utilizamos el plugin de Eclipse para Maven: [Eclipse IAM](http://www.eclipse.org/iam/)
  1. Utilizamos el plugin de Maven [Maven Eclipse Plugin](http://maven.apache.org/plugins/maven-eclipse-plugin/), tal y como se explica en [Convertir un proyecto Maven a Eclipse](ApacheMaven2#Convertir_un_proyecto_Maven_a_Eclipse.md)

## Creamos una nueva Entidad ##

Creamos una Entidad `Person` con anotaciones JPA:

`es.cemi.samples.model.Person`
```
import org.appfuse.model.BaseObject;

import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;

@Entity
public class Person extends BaseObject {
  private Long id;
  private String firstName;
  private String lastName;
  
  // Eclipse > Source > Generate getter & setters
  ..
  @Id @GeneratedValue(strategy = GenerationType.AUTO) 
  public Long getId() {
  ..
  @Column(name="first_name", length=50)
  public String getFirstName() {
  ..
  @Column(name="last_name", length=50)
  public String getLastName() {
  ..
}
```

Invocamos al plugin de AppFuse para la generación de todo el esqueleto de código asociado a dicha entidad:

```
C:\CEMi_J2EE\struts2app>mvn appfuse:gen -Dentity=Person
```

Esta acción genera los siguientes archivos:
  * src/main/java/es/cemi/samples/webapp/action/PersonAction.java
  * src/main/resources/es/cemi/samples/model/Person-validation.xml
  * src/main/resources/es/cemi/samples/webapp/action/PersonAction-validation.xml
  * src/main/webapp/WEB-INF/pages/personForm.jsp
  * src/main/webapp/WEB-INF/pages/personList.jsp
  * src/test/java/es/cemi/samples/webapp/action/PersonActionTest.java

Y modifica los siguientes:
  * src/main/resources/ApplicationResources.properties
  * src/main/resources/hibernate.cfg.xml
    * Mapeamos la nueva entidad en Hibernate:
```
   <mapping class="es.cemi.samples.model.Person"/>
```
  * src/main/resources/struts.xml
    * Declaramos en Struts2 las instancias que vamos a utilizar en las JSPs para esta entidad Person
```
   <action name="persons" class="es.cemi.samples.webapp.action.PersonAction" method="list">
     <result>/WEB-INF/pages/personList.jsp</result>
   </action>
   
   <action name="editPerson" class="es.cemi.samples.webapp.action.PersonAction" method="edit">
     <result>/WEB-INF/pages/personForm.jsp</result>
     <result name="error">/WEB-INF/pages/personList.jsp</result>
   </action>
   
   <action name="savePerson" class="es.cemi.samples.webapp.action.PersonAction" method="save">
     <result name="input">/WEB-INF/pages/personForm.jsp</result>
     <result name="cancel" type="redirect-action">persons</result>
     <result name="delete" type="redirect-action">persons</result>
     <result name="success" type="redirect-action">persons</result>
   </action>
```
  * src/main/webapp/common/menu.jsp
  * src/main/webapp/WEB-INF/applicationContext.xml
    * Creamos una instancia nueva de DAO genérico y Manager genérico para esta nueva entidad en el contexto de Spring
```
   <bean id="personManager" class="org.appfuse.service.impl.GenericManagerImpl">
     <constructor-arg>
       <bean class="org.appfuse.dao.hibernate.GenericDaoHibernate">
         <constructor-arg value="es.cemi.samples.model.Person"/>
         <property name="sessionFactory" ref="sessionFactory"/>
        </bean>
      </constructor-arg>
    </bean>
```
  * src/main/webapp/WEB-INF/menu-config.xml
  * src/test/resources/sample-data.xml
  * src/test/resources/web-tests.xml

Recompilamos la aplicación. Ver [Compilamos el proyecto Maven](Struts2#Compilamos_el_proyecto_Maven.md)

Y volvemos a desplegar la aplicación a Tomcat. Ver [Desplegamos la aplicación en un Servidor](Struts2#Desplegamos_la_aplicaci&oacute;n_en_un_Servidor.md)

Si analizamos cualquier de las JSPs generadas, por ejemplo: `personList.jsp`. Rapidamente nos daremos cuenta de que no contamos con algunos archivos como de forma directa.
  * `/common/taglibs.jsp` no se encuentra en nuestro workspace
  * Etc

La respuesta a la ausencia de estos archivos está en la existencia de una dependencia _WAR Overlay_ en nuestro POM. Ver [Maven WAR Plugin - Overlays](http://maven.apache.org/plugins/maven-war-plugin/overlays.html):

```
<dependency>
  <groupId>org.appfuse</groupId>
  <artifactId>appfuse-struts</artifactId>
  <version>2.0.2</version>
  <type>war</type>
</dependency>
```

Dicha dependencia se encuentra localizada en nuestro repositorio local Maven:
