[![](http://maven.apache.org/images/maven-logo-2.gif)](http://maven.apache.org)

  * Introducción
  * Instalación
  * Configuración
  * [Control del ciclo de desarrollo](ApacheMaven2#Control_del_ciclo_de_desarrollo.md)
  * [Comprendiendo el POM](ApacheMaven2#Comprendiendo_el_POM_(Project_Object_Model).md)
  * [Gestión automática de dependencias](ApacheMaven2#Gesti&oacute;n_autom&aacute;tica_de_dependencias.md)
  * [El repositorio de Maven](ApacheMaven2#El_repositorio_de_Maven.md)
    * [Comprendiendo el concepto de repositorio](ApacheMaven2#Comprendiendo_el_concepto_de_repositorio.md)
    * [Repositorios oficiales](ApacheMaven2#Repositorios_oficiales.md)
    * ¿Cómo encontrar la dependencia asociada a un JAR concreto?
    * [Añadir repositorios](ApacheMaven2#A&ntilde;adir_repositorios.md)
    * [Creación de repositorios internos](ApacheMaven2#Creaci&oacute;n_de_repositorios_internos.md)
  * [Compilando y empaquetando](ApacheMaven2#Compilando_y_empaquetando.md)
  * [Gestionando varios proyectos a la vez](ApacheMaven2#Gestionando_varios_proyectos_a_la_vez.md)
    * [Dependency Management](ApacheMaven2#Dependency_Management.md)
    * [Eclipse IAM](ApacheMaven2#Eclipse_IAM.md)
  * [Preparando una release](ApacheMaven2#Preparando_una_release.md)
  * [Generando informes automáticos](ApacheMaven2#Generando_informes_autom&aacute;ticos.md)
  * [Plugins interesantes](ApacheMaven2#Plugins_interesantes.md)
  * [Arquetipos Maven](ApacheMaven2#Arquetipos_Maven.md)
  * [Otros temas](ApacheMaven2#Otros_temas.md)
  * Convertir un proyecto Maven a Eclipse
  * [Sincronización manual de dependencias Eclipse-Maven](ApacheMaven2#Sincronizaci&oacute;n_manual_de_dependencias_Eclipse-Maven.md)
  * [Parámetros Adicionales](ApacheMaven2#Par&aacute;metros_Adicionales.md)
  * [Enlaces Interesantes](ApacheMaven2#Enlaces_Interesantes.md)

# Introducción #

_**"Si no existiera, habría que inventarlo"**_

**Maven** es una herramienta de software para la gestión y construcción de proyectos Java creada por Jason van Zyl, de Sonatype, en 2002. Es similar en funcionalidad a **Apache Ant** (y en menor medida a PEAR de PHP y CPAN de Perl), pero tiene un modelo de configuración de construcción más simple, basado en un formato XML.
Maven utiliza un _Project Object Model_ (POM) para describir el proyecto de software a construir, sus dependencias de otros módulos y componentes externos, y el orden de construcción de los elementos. Viene con objetivos predefinidos para realizar ciertas tareas claramente definidas, como la compilación del código y su empaquetado.

En los ejemplos del curso vamos a utilizar Maven 2 como mecanismo de creación de nuestras aplicaciones de ejemplo

  * Libro _online_ **Better Builds with Maven**: http://www.maestrodev.com/better-build-maven

  * Tutorial **Maven in 5 Minutes**: http://maven.apache.org/guides/getting-started/maven-in-five-minutes.html

  * Chuletario de Maven: http://cemicursoj2ee.googlecode.com/files/MavenQuickReferenceCard.pdf

# Instalación #
En algunos ejemplos de este curso usaremos [Arquetipos Maven](ApacheMaven2#Arquetipos_Maven.md) para familiarizarnos rápidamente tanto con Struts 2 como con JSF.

Es por ello que se hace imprescindible la instalación de Maven.

Pasos:

  1. Nos descargamos la última versión de Apache Maven: http://maven.apache.org/download.html
  1. Descomprimimos el **apache-maven-2.2.1-bin.zip** en `C:\CEMi\_J2EE\apache-maven-2.2.1
  1. Creamos la _variable de entorno_ de **sistema** **M2\_HOME** (_Para acceder a las variables de entorno en entornos Windows: `Mi PC > Propiedades > Opciones Avanzadas > Variables de entorno`_)
    * `M2_HOME=C:\CEMi_J2EE\apache-maven-2.2.1`
  1. Creamos las _variables de entorno_ de **usuario** **M2** y **MAVEN\_OPTS**
    * `M2=%M2_HOME%\bin`
    * `MAVEN_OPTS=-Xms256m -Xmx512m`
  1. Añadimos al **Path** el directorio `bin` de Maven
    * `Path=%Path%;%M2%;`
  1. Nos abrimos una consola y ejecutamos: `$> mvn --version`

```
Apache Maven 2.2.1 (r801777; 2009-08-06 21:16:01+0200)
Java version: 1.5.0_11
Java home: C:\CEMi_J2EE\jdk1.5.0_11\jre
Default locale: es_ES, platform encoding: Cp1252
OS name: "windows xp" version: "5.1" arch: "x86" Family: "windows"
```

_Recomendación para entornos Windows: Ya que la consola de comandos de Windows no cuenta con pestañas, se recomienda la utilización de **Console2**_ http://sourceforge.net/projects/console


http://garbageburrito.com/media/AA/AA/ben/images/379/main/console.jpg?1204641919

# Configuración #
Toda la configuración de Maven corre a cargo del fichero `%M2_HOME%\conf\settings.xml`.

En nuestro caso, queremos cambiar la ruta de nuestro repositorio de JARs

```
<settings>
  <localRepository>${ruta_repositorio}</localRepository>
</settings>
```

La marca _localRepository_ viene comentada por defecto, estableciendose así el directorio `C:\Document and settings\${current_user}\.m2\repository`.

Así que añadimos lo siguiente en dicho fichero, para unificar el emplazamiento del repositorio maven y evitar problemas con posibles nombres de usuario que contengan acentos.

```
<localRepository>C:\CEMi_J2EE\apache-maven-2.2.1\repository</localRepository>
```

Si nos encontramos en una red protegida por un proxy, será necesario especificarlo en el `%M2_HOME%/bin/conf/settings.xml`, tal y como figura en la documentación oficial de Maven:
[Maven - Guide to using proxies](http://maven.apache.org/guides/mini/guide-proxies.html)

# Control del ciclo de desarrollo #

  * Hasta ahora muchas fases de un proyecto Software eran gestionadas de una forma "pseudo-manual":
    * Compilación
    * Empaquetado
    * Versionado
    * Control de dependencias
    * Generación de documentación
    * ...
  * Maven es una herramienta que facilita la automatización de todas estas tareas.
  * Maven se involucra totalmente en la **Gestión de la Configuración**. Según la Wikipedia, se entiende por "Gestión de la Configuración" a ..

_Se denomina **Gestión de la Configuración** al conjunto de procesos destinados a asegurar la validez de todo producto obtenido durante cualquiera de las etapas del desarrollo de un Sistema de Información (S.I.), a través del estricto control de los cambios realizados sobre los mismos y de la disponibilidad constante de una versión estable de cada elemento para toda persona involucrada en el citado desarrollo._

# Comprendiendo el POM (Project Object Model). #

  * El POM (Project Object Model) es la piedra angular de Maven.
  * En el fichero pom.xml se "declara" el proyecto. Esto quiere decir que Maven se basa en un conjunto de patrones y estándares.
    * Fases en el ciclo de construcción del proyecto
    * Estructura de directorios
    * ...
  * Esta es la principal diferencia frente a otros sistemas de automatización de tareas como Ant:
    * Muchos proyectos con diferentes scripts Ant, donde todos hacen básicamente lo mismo.
  * Podemos crear un proyecto de Maven usando los “arquetipos”.
  * Para Maven un “arquetipo” es una plantilla de proyecto.
  * Gracias a los arquetipos perdemos el miedo al folio en blanco:
    * Para crear un proyecto java:
```
$ mvn archetype:create \
-DgroupId=es.cemi.app \
-DartifactId=cemi-model
```
    * Para crear un proyecto web:
```
$ mvn archetype:create -DgroupId=es.cemi.app \
-DartifactId=cemi-web \
-DarchetypeArtifactId=maven-archetype-webapp
```
  * La estructura de directorios estándar de Maven:
    * `src/main/java` Fuentes de la Aplicación/Librería
    * `src/main/resources` Recursos de la Aplicación/Librería
    * `src/main/filters` Ficheros de filtros
    * `src/main/assembly` Descriptores del Assembly
    * `src/main/config` Ficheros de configuración
    * `src/main/webapp` Fuentes de la aplicación Web
    * `src/main/sql` Scripts de bbdd
    * `src/test/java` Fuentes de los Test
    * `src/test/resources` Recursos de los Test
    * `src/test/filters` Ficheros de filtros para los Test
    * `src/site` Documentación “apt” sobre el proyecto
    * `target` Directorio donde Maven deja los resultados
    * `target/classes` Resultado de la compilación.
    * `LICENSE.txt` Licencia del Proyecto
    * `README.txt` Readme del Proyecto
    * `pom.xml` Descriptor Maven del proyecto
  * El pom.xml resultado del arquetipo:
```
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/mavenv4_0_0.xsd">
  <modelVersion>4.0.0</modelVersion>
  <groupId>es.cemi.app</groupId>
  <artifactId>cemi-model</artifactId>
  <version>1.0-SNAPSHOT</version>
  <packaging>jar</packaging>
  <name>cemi-model</name>
  <url>http://maven.apache.org</url>
  
  <build>
  
    <!-- listado de plugins declarados para ejecución automatizada o redefinidos para la utilización del usuario -->
    <plugins>
  	  <!-- plugin que se ejecutará automáticamente en la phase 'test-compile' -->
  	  <plugin>
        <groupId>org.apache.maven.plugins</groupId>
        <artifactId>maven-source-plugin</artifactId>
        <executions>
          <execution>
          	<id>attach-sources</id>
          	<phase>test-compile</phase>            
            <goals>
              <goal>jar</goal>
            </goals>
          </execution>
        </executions>
      </plugin>
            
      <!-- en el caso de que se lance el comando '$> mvn deploy -Dmodel.skip.deploy=false' se ejecutará el plugin deploy -->
      <plugin>
        <groupId>org.apache.maven.plugins</groupId>
        <artifactId>maven-deploy-plugin</artifactId>
        <version>${deploy.maven.version}</version>
        <configuration>
          <skip>${model.skip.deploy}</skip>
        </configuration>
      </plugin>  	  
    </plugins>
  
  </build>
  
  <!-- listado de dependencias: JARs -->
  <dependencies>
    <dependency>
      <groupId>com.opensymphony</groupId>
      <artifactId>xwork-core</artifactId>
      <version>${xwork-core.version}</version>
    </dependency>
    <dependency>
      <groupId>junit</groupId>
      <artifactId>junit</artifactId>
      <version>4.4</version>
      <scope>test</scope>
    </dependency>
  </dependencies>
  <properties>
  	<xwork-core.version>2.1.6</xwork-core.version>
  </properties>
</project>
```

# Gestión automática de dependencias. #

  * ¿Cuantas veces no nos funciona un proyecto porque nos falta algún .jar?
  * ¿En cuantas ocasiones desconozco las versiones de mis dependencias?
  * ¿Cuantas veces tengo un .jar copiado en una carpeta, y no sé porque lo tengo?
  * Una de las principales y mas potentes características de Maven es la gestión de dependencias.
  * Después de usar la gestión de dependencias de Maven ya no querrá usar otra herramienta para construir sus aplicaciones.
  * ¿Para que sirven realmente los repositorios?
  * Los repositorios son el medio para conseguir una
gestión automática de las dependencias:
    * Directas: .jar de los que depende nuestro proyecto.
    * Indirectas: Otros .jar que son dependencias de las dependencias (y así sucesivamente)
  * Maven busca de forma automática todas las dependencias de nuestro proyecto en los repositorios que tenemos dados de alta.
  * La resolución de dependencias es un proceso recursivo.
  * Para declarar las dependencias de un proyecto usamos el elemento `<dependencies>`
    * http://maven.apache.org/guides/introduction/introduction-to-dependency-mechanism.html)
    * Una depedencia tiene los siguientes _scopes_ posibles:
      * _compile_
      * _provided_
      * _runtime_
      * _test_
      * _system_
```
<project>
  ...
  <dependencies>
    ...
    <dependency>
      <groupId>commons-logging</groupId>
      <artifactId>commons-logging</artifactId>
      <version>1.1</version>
    </dependency>
    <dependency>
      <groupId>mysql</groupId>
      <artifactId>mysql-connector-java</artifactId>
      <version>5.0.3</version>
      <scope>runtime</scope>
    </dependency>
    ...
  </dependencies>
  ...
</project>
```

# El repositorio de Maven. #

## Comprendiendo el concepto de repositorio ##
  * ¿Por que tenemos que gestionar manualmente las dependencias de los proyectos, si hay muchas que se repiten constantemente?
    * commons-logging, log4j
    * Hibernate
    * Struts
    * Spring
    * ...
  * Incluso dependencias entre nuestros propios proyectos
  * El repositorio es el sitio donde se almacenan todos los proyectos (internos o externos) para que sean accesibles desde cualquier otro proyecto.

## Repositorios oficiales ##
  * Maven tiene publicado un repositorio en Internet donde podemos encontrar gran cantidad de proyectos (dependencias en casi todos nuestros desarrollos).
  * Este repositorio lo podemos encontrar en: http://www.ibiblio.org/maven2

## ¿Como encontrar la dependencia asociada a un JAR concreto? ##
  * El repositorio de Maven es muy extenso y a menudo cuesta encontrar el proyecto que nos interesa.
  * Para buscar en el repositorio nos podemos valer de Google, y algunos sitios especializados:
    * `$> site:www.ibiblio.org maven2 log4j`
    * MVN Repository - Search/Browse/Explore: http://mvnrepository.com
    * Sonatype Nexus™ Professional Edition: http://repository.sonatype.org/index.html#welcome

## Añadir repositorios ##
  * Generalmente nos interesa añadir repositorios para encontrar dependencias que no existen en el repositorio por defecto:
```
<repositories>
  <repository>
    <id>repository.jboss.org</id>
    <url>http://repository.jboss.org/maven2</url>
    <snapshots>
      <enabled>false</enabled>
      <updatePolicy>daily</updatePolicy>
      <checksumPolicy>warn</checksumPolicy>
    </snapshots>
    <releases>
      <enabled>true</enabled>
      <updatePolicy>daily</updatePolicy>
      <checksumPolicy>ignore</checksumPolicy>
    </releases>
  </repository>
</repositories>
```

## ¿Y si... mi empresa tuviese su propio repositorio? ##
  * En proyectos grandes en los que coexisten varios desarrolladores, es interesante la utilización de un repositorio común.
    * Apache Archiva: http://archiva.apache.org/

# Compilando y empaquetando. #
  * A estas alturas ya hemos declarado suficientemente el
proyecto como para poder compilar.
  * Maven define un ciclo de vida estándar para la construcción de los proyectos:
    * http://maven.apache.org/guides/introduction/introduction-to-the-lifecycle.html
  * Las fases más comunes son:
    * **compile** compila el código
    * **test** ejecuta los test unitarios (JUnit)
    * **package** empaqueta el proyecto
    * **install** instala el paquete en el repositorio local
    * **deploy** copia el proyecto en el repositorio remoto

# Gestionando varios proyectos a la vez. #
  * Lo habitual es que un proyecto esté compuesto por varios módulos o librerías.
  * Con Maven podemos crear un POM para controlarlos a todos.
  * Maven se encargará de compilarlos en el orden correcto para poder satisfacer las dependencias entre ellos.
  * En Maven también existe la "herencia", de forma que las declaraciones que hagamos en el POM "padre" se heredarán por los POM "hijos".
  * El `pom.xml` padre:
```
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0
         http://maven.apache.org/maven-v4_0_0.xsd">
  <modelVersion>4.0.0</modelVersion>
  <groupId>es.cemi.app</groupId>
  <artifactId>cemi-parent</artifactId>
  <version>1.0-SNAPSHOT</version>
  <packaging>pom</packaging>
  <modules>
    <module>cemi-model</module>
    <module>cemi-web</module>
  </modules>
</project>
```
  * El `pom.xml` hijo:
```
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0
         http://maven.apache.org/maven-v4_0_0.xsd">
  <parent>
    <groupId>es.cemi.app</groupId>
    <artifactId>cemi-parent</artifactId>
    <version>1.0-SNAPSHOT</version>
  </parent>
  ...
</project>
```

## Dependency Management ##
  * Algunas veces nos interesa controlar las versiones de la que dependen los “hijos” de mi proyecto desde el padre.
  * Los hijos únicamente deberán indicar grupo y artefacto
  * `pom.xml` del padre:
```
<dependencyManagement>
  <dependencies>
    <dependency>
      <groupId>com.acme</groupId>
      <artifactId>tntexplosive</artifactId>
      <version>1.0</version>
    </dependency>
  </dependencies>
</dependencyManagement>
```
**`pom.xml` del hijo:
```
<dependencies>
  <dependency>
    <groupId>com.acme</groupId>
    <artifactId>tntexplosive</artifactId>
  </dependency>
</dependencies>
```**

## Eclipse IAM ##
  * Integración de Maven en Eclipse:
    * Q4E > IAM (incubation phase): http://code.google.com/p/q4e/ > http://www.eclipse.org/iam/
  * http://www.adictosaltrabajo.com/tutoriales/tutoriales.php?pagina=eclipseGanymede
    * Importación directa de proyectos y creación en base a arquetipos.
    * Gestión integrada de dependencias (descarga automática):
  * JDT y WTP.
  * Dependency analysis,
  * Dependency graphing.
    * POM editor.
    * Ejecución de goals integrada.

# Preparando una release. #
  * En todo proceso de desarrollo se hacen "subidas" a producción de la aplicación en un estado determinado.
  * Es fundamental marcar de alguna manera este "estado" para que sea recuperable.
  * Es desaconsejable hacer estas tareas de forma manual.
  * Maven se integra con el sistema de control de versiones y es capaz de gestionar estas tareas de forma automática.
  * Además Maven hará un "deploy" de la release en nuestro repositorio remoto.
  * Configurar el sistema de control de versiones:
    * http://maven.apache.org/scm/scm-url-format.html
```
<project>
  ...
  <scm>
    <connection>scm:svn:svn://servidor/test/trunk/cemi-parent</connection>
    <developerConnection>
      scm:svn:svn://servidor/test/trunk/cemi-parent
    </developerConnection>
  </scm>
  ...
  <build>
    <plugins>
      <plugin>
        <artifactId>maven-release-plugin</artifactId>
        <configuration>
          <username>${scm.username}</username>
          <password>${scm.password}</password>
          <tagBase>svn://servidor/test/tags</tagBase>
        </configuration>
      </plugin>
    </plugins>
    ...
  </build>
  ...
</project>
```
  * Indicar el usuario y la clave:
    * En línea de comandos: `$> mvn ... -Dscm.username=USUARIO -Dscm.password=CONTRASEÑA`
    * En el fichero de configuración `%M2_HOME%/conf/settings.xml`
```
<settings>
  ...
  <profiles>
  <profile>
    <id>scmConfig</id>
    <activation>
      <activeByDefault>true</activeByDefault>
    </activation>
    <properties>
      <scm.username>USUARIO</scm.username>
      <scm.password>CONTRASEÑA</scm.password>
    </properties>
  </profile>
</profiles>
...
</settings>
```
  * Configurar el repositorio remoto para hacer el **deploy**:
```
<project>
  ...
  <distributionManagement>
    <repository>
      <id>cemi-repository</id>
      <name>CEMI Repository</name>
      <url>scp://CEMISERVER/var/maven/repository</url>
    </repository>
  </distributionManagement>
  ...
<project>
```
  * Configurar el usuario y la clave para hacer el **deploy**.
    * Modificando el fichero `%M2_HOME%/conf/settings.xml`
```
<settings>
  ...
  <servers>
    <server>
      <id>cemi-repository</id>
      <username>miNombre</username>
      <password>miClave</password>
    </server>
  </servers>
  ...
</settings>
```

  * Por último:
```
$> mvn release:prepare
$> mvn release:perform
```

# Generando informes automáticos. #

  * Cuando usamos Maven podemos documentar los proyectos a través de lo que Maven denomina “el site”.
  * Maven es capaz de generar de forma automática numerosos informes en el site.
  * Estos informes los podemos configurar a través del `site.xml`
  * A continuación tenemos un ejemplo de este fichero y resaltado, como configurarlo para que genere los informes de forma automática al ejecutar:
```
$> mvn site
```

```
<?xml version="1.0" encoding="UTF-8"?>
<project name="CEMI ntjee application (ntjee)">
  <bannerLeft>
    <name>CEMI ntjee application</name>
  </bannerLeft>
  <body>
    <menu ref="modules" />
      <menu name="Sección 1">
      <item name="Menú item 1.1" href="menu1_1.html" />
    </menu>
    <menu name="Sección 2">
      <item name="Menú item 2.1" href="menu2_1.html" />
    </menu>
    <menu ref="reports" />
  </body>
</project>
```

  * Ejemplos de informes:
    * Generar un histórico de cambios del proyecto: http://www.adictosaltrabajo.com/tutoriales/tutoriales.php?pagina=mavenChangesPlugin
    * Verificación de código con PMD: http://www.adictosaltrabajo.com/tutoriales/tutoriales.php?pagina=maven_pmd_plugin
    * ¿Cuánto código prueban nuestros tests?: http://www.adictosaltrabajo.com/tutoriales/tutoriales.php?pagina=mavenCobertura
    * JXR Plugin, publica el código fuente en el site: http://www.adictosaltrabajo.com/tutoriales/tutoriales.php?pagina=maven_jxr_plugin

# Plugins interesantes #
> Catálogo oficial: http://maven.apache.org/plugins/

  * Hibernate Maven Plugin: http://mojo.codehaus.org/maven-hibernate3/hibernate3-maven-plugin/
  * SQL Maven Plugin: http://mojo.codehaus.org/sql-maven-plugin/
  * Tomcat Maven Plugin: http://mojo.codehaus.org/tomcat-maven-plugin/
  * Jetty Maven Plugin: http://docs.codehaus.org/display/JETTY/Maven+Jetty+Plugin
  * Axis 2 Maven Plugins: http://ws.apache.org/axis2/tools/
  * PDF Maven Plugin: http://maven.apache.org/plugins/maven-pdf-plugin/
  * Java Web Start Maven Plugin: http://mojo.codehaus.org/webstart/webstart-maven-plugin/
> ..

# Arquetipos Maven #

Un arquetipo es un patrón o modelo original sobre el que pueden desarrollar todas aquellas cosas que son de un mismo tipo. Puede decirse que son plantillas, parametrizadas o configuradas para utilizar determinadas tecnologías, que los programadores utilizan como base para escribir y organizar el código de la aplicación.

Que todos los proyectos que involucren ciertas tecnologías partan de una base (arquetipo, plantilla o esqueleto configurado) común, tiene ventajas evidentes:
  * Consistencia entre distintos desarrollos cuyo punto en común son las mismas tecnologías o el entorno configurado sobre las que serán deplegados y ejecutados
  * Reutilización y composición de unos arquetipos como suma de otros.
  * Estandarización de los proyectos dentro de una organización. Los arquetipos son compartidos desde uno o más repositorios y todos los empleados tienen acceso a ellos.
  * Se evitan tiempos muertos en el comienzo de la implementación al disponerse de un entorno ya correctamente configurado.
  * La estructura del proyecto facilita las tareas de desarrollar, distribuir, portar y desplegar, al equipo de programadores.

_Más info:_ http://maven.apache.org/guides/introduction/introduction-to-archetypes.html

_En español:_ http://www.adictosaltrabajo.com/tutoriales/tutoriales.php?pagina=creararquetiposmaven

1. Seguimos el [tutorial anterior](http://www.adictosaltrabajo.com/tutoriales/tutoriales.php?pagina=creararquetiposmaven):
```
C:\CEMi_J2EE> mvn archetype:create -DgroupId=es.cemi -DartifactId=arquetipo-maven -DarchetypeArtifactId=maven-archetype-archetype

C:\CEMi_J2EE\arquetipo-maven> mvn eclipse:eclipse
```


---


**NOTA: Corregimos algunos bugs de este arquetipo**

En este punto debemos hacer un inciso. Los arquetipos generados con el plugin maven-archetype-archetype contienen un bug (reportado en http://jira.codehaus.org/browse/ARCHETYPE-96), y debemos corregir lo siguiente:

  * En `src/main/resouces/archetype-resources/src/main/java/App.java` y `src/main/resouces/archetype-resources/src/test/java/AppTest.java`, sustituir: `package $es.cemi;` por: `package $package;`
  * En `src/main/resouces/archetype-resources/pom.xml` cambiar:
```
   	<groupId>$es.cemi</groupId>  
   	<artifactId>$arquetipo-maven</artifactId>
   	<version>$1.0-SNAPSHOT</version>
```

> por

```
   <groupId>$groupId</groupId>
   <artifactId>$artifactId</artifactId>  
   <version>$version</version>
```


---


2. Llegado a este punto es donde entraría en juego la creación customizada del arquetipo.

  * Si nuestro arquetipo debe contener ciertas clases java, las emplazaremos en la ruta: `src/main/resources/archetype-resources/src/main/java/*`
  * Idem para los tests: `src/main/resources/archetype-resources/src/test/java/*`
  * La configuración del POM, deberá hacerse en el fichero: `src/main/resources/archetype-resources/pom.xml`

```
│   pom.xml
│
├───src
│   └───main
│       └───resources
│           ├───archetype-resources
│           │   │   pom.xml
│           │   │
│           │   └───src
│           │       ├───main
│           │       │   └───java
│           │       │           App.java
│           │       │
│           │       └───test
│           │           └───java
│           │                   AppTest.java
│           │
│           └───META-INF
│               └───maven
│                       archetype.xml
```

3. Compilamos el arquetipo
```
C:\CEMi_J2EE\arquetipo-maven> mvn install
...
[INFO] Installing C:\CEMi_J2EE\arquetipo-maven\target\arquetipo-maven-1.0-SNAPSHOT.jar to
 C:\00-FACTORIA\share\maven2-repository\es\cemi\arquetipo-maven\1.0-SNAPSHOT\arquetipo-maven-1.0-SNAPSHOT.jar
...
```

4. Probamos este arquetipo creando un proyecto nuevo que lo utilice:
```
C:\CEMi_J2EE> mvn archetype:create -DarchetypeGroupId=es.cemi -DarchetypeArtifactId=arquetipo-maven -DarchetypeVersion=1.0-SNAPSHOT -DgroupId=es.ayto.mlg -DartifactId=gestor-ayto
```

5. Compilamos el nuevo proyecto arquetipado:
```
C:\CEMi_J2EE\gestor-ayto> mvn clean install
```

# Otros temas #
  * Creación de perfiles (profiles)
    * http://maven.apache.org/guides/introduction/introduction-to-profiles.html
  * Uso de filtros.
  * Configuración y construcción de plugins
  * Personalización del empaquetado (`assembly`)

# Convertir un proyecto Maven a Eclipse #

Para generar los archivos _.project_, _.classpath_ y el directorio _.settings_ necesarios para generar el proyecto Eclipse de una aplicación Maven, procederemos de la siguiente forma:

```
C:\CEMi_J2EE\${app}> mvn eclipse:eclipse -o
```

Cada vez que añadamos una nueva dependencia y queramos que Eclipse actualice este JAR en el classpath, deberemos ejecutar el comando anterior y hacer un refresh (F5) del proyecto.

Una vez creado el proyecto, ya podremos importarlo a nuestro workspace de Eclipse.

Arrancamos Eclipse y establecemos como workspace `C:\CEMi_J2EE`. Importaremos nuestro proyecto mediante: `File > Import > General > Existing projects into workspace`
`C:\CEMi_J2EE\${app}`

Una vez hemos importado nuestro proyecto al _workspace_ de Eclipse, deberemos crear la siguiente variable de classpath `M2_REPO`. Para ello, accedemos a `Window > Preferences > Java > Build Path > Classpath Variables > New`:

Name: `M2_REPO`

Path: `C:\CEMi_J2EE\apache-maven-2.2.1\repository`

De esta forma Eclipse encontrará las referencias que hay establecidas en el fichero `.classpath` del proyecto.


# Sincronización manual de dependencias Eclipse-Maven #

En este caso, el `.classpath` no cuenta con este nuevo JAR en el _classpath_ del proyecto, con lo que deberemos regerar el proyecto Eclipse.

```
C:\CEMi_J2EE\${app}> mvn eclipse:clean eclipse:eclipse -o
```

_El parámetro `-o` sirve para ejecutar Maven en modo offline. Este modo es conveniente utilizarlo siempre que sea posible._

Si ya teníamos importado el proyecto y se ha regenerado el proyecto "en caliente" (con el Eclipse abierto), bastará con hacer un _Refresh_ (F5) de dicho proyecto. Si no comienza a compilar automaticamente, deberemos forzar la compilación mediante `Projec > Clean..`


# Parámetros Adicionales #

```
C:\CEMi_J2EE\struts2app>mvn -?
```

```
usage: mvn [options] [<goal(s)>] [<phase(s)>]

Options:
 -am,--also-make                        If project list is specified, also
                                        build projects required by the
                                        list
 -amd,--also-make-dependents            If project list is specified, also
                                        build projects that depend on
                                        projects on the list
 -B,--batch-mode                        Run in non-interactive (batch)
                                        mode
 -c,--lax-checksums                     Warn if checksums don't match
 -C,--strict-checksums                  Fail the build if checksums don't
                                        match
 -cpu,--check-plugin-updates            Force upToDate check for any
                                        relevant registered plugins
 -D,--define <arg>                      Define a system property
 -e,--errors                            Produce execution error messages
 -emp,--encrypt-master-password <arg>   Encrypt master security password
 -ep,--encrypt-password <arg>           Encrypt server password
 -f,--file                              Force the use of an alternate POM
                                        file.
 -fae,--fail-at-end                     Only fail the build afterwards;
                                        allow all non-impacted builds to
                                        continue
 -ff,--fail-fast                        Stop at first failure in
                                        reactorized builds
 -fn,--fail-never                       NEVER fail the build, regardless
                                        of project result
 -gs,--global-settings <arg>            Alternate path for the global
                                        settings file
 -h,--help                              Display help information
 -N,--non-recursive                     Do not recurse into sub-projects
 -npr,--no-plugin-registry              Don't use
                                        ~/.m2/plugin-registry.xml for
                                        plugin versions
 -npu,--no-plugin-updates               Suppress upToDate check for any
                                        relevant registered plugins
 -o,--offline                           Work offline
 -P,--activate-profiles <arg>           Comma-delimited list of profiles
                                        to activate
 -pl,--projects <arg>                   Build specified reactor projects
                                        instead of all projects
 -q,--quiet                             Quiet output - only show errors
 -r,--reactor                           Dynamically build reactor from
                                        subdirectories
 -rf,--resume-from <arg>                Resume reactor from specified
                                        project
 -s,--settings <arg>                    Alternate path for the user
                                        settings file
 -U,--update-snapshots                  Forces a check for updated
                                        releases and snapshots on remote
                                        repositories
 -up,--update-plugins                   Synonym for cpu
 -V,--show-version                      Display version information
                                        WITHOUT stopping build
 -v,--version                           Display version information
 -X,--debug                             Produce execution debug output
```

# Enlaces Interesantes #

  * Video tutorial - Trabajando con Q4E y WTP: http://joakim.erdfelt.com/q4e/q4e-wtp.swf
  * Guide to Moving from Maven 1.x to Maven 2.x: http://maven.apache.org/guides/mini/guide-m1-m2.html
  * 
