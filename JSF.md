# Introducción #

http://java.sun.com/javaee/javaserverfaces/

# Ejemplo de aplicación JSF básica #

Creamos una aplicación **jsfapp** a partir del archetipo Maven **JSF Basic**:

Nos abrimos una consola de comandos y nos situamos en el directorio de nuestro workspace de Eclipse `C:\CEMi_J2EE`:

```
C:\CEMi_J2EE> mvn archetype:create /
 -DarchetypeGroupId=org.appfuse.archetypes /
 -DarchetypeArtifactId=appfuse-basic-jsf /
 -DremoteRepositories=http://static.appfuse.org/releases /
 -DarchetypeVersion=2.0.2 /
 -DgroupId=es.cemi.samples /
 -DartifactId=jsfapp
```

A continuación realizamos la primera compilación del ejemplo. Dicha compilación con Maven tiene asociada una descarga importante de JARs que puede tardar mucho tiempo. Para acelerar este proceso, contamos en el aptdo. de descargas con un **repository.rar** que podremos descomprimir en nuestro repositorio Maven: `%M2_HOME%\repository`

Una vez tengamos todos los JARs, ya podemos proceder a realizar la primera compilación:

```
C:\CEMi_J2EE\jsfapp> mvn clean install
```

Por último, importamos **jsfapp** a nuestro _workspace_ de Eclipse. Para realizar esta operación, tenemos dos posibilidades:

1. Utilizamos el plugin de Eclipse para Maven: [Eclipse IAM](http://www.eclipse.org/iam/)

2. Utilizamos el plugin de Maven [Maven Eclipse Plugin](http://maven.apache.org/plugins/maven-eclipse-plugin/), tal y como se explica en el aptdo. _¿Cómo convertir un proyecto Maven en un proyecto Eclipse?_ del artículo de la WIKI ApacheMaven2

# Enlaces de interés #

Útil maquetando HTML: http://www.exadel.com/tutorial/jsf/jsftags-guide.html

MADEJA JSF: http://www.juntadeandalucia.es/xwiki/bin/view/MADEJA/JSF

MyFaces Tomahawk for JSF 1.2 - tags doc: http://myfaces.apache.org/tomahawk-project/tomahawk12/tagdoc.html

MyFaces Tomahawk WIKI: http://wiki.apache.org/myfaces/Tomahawk

Primefaces: http://primefaces.prime.com.tr/en/