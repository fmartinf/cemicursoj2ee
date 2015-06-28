Sitio: http://code.google.com/p/icefusion/

# Configuración #

  1. Nos descargamos la última versión: [icefusion-1.0.1.zip](http://icefusion.googlecode.com/files/icefusion-1.0.1.zip)
  1. Descomprimimos este ZIP en `C:\CEMi_J2EE`
  1. Editamos el `C:\CEMi_J2EE\icefusion-1.0.1\pom.xml` y vaciamos la property del password de base de datos:
```
    ...
    <jdbc.password></jdbc.password>
  </properties>
</project>
```
  1. Compilamos la aplicación a partir del BAT: `first-time-run.bat`. Posiblemente dé algún fallo en los web-test. Pero no nos preocupamos por eso.
  1. Ejecutamos el servidor Jetty a través del BAT: `run.bat`
  1. Convertimos el proyecto Maven en un proyecto Eclipse:
```
C:\CEMi_J2EE\icefusion-1.0.1> mvn eclipse:eclipse
```
  1. El resultado de todos estos pasos correspondería a: [icefusion-1.0.1](http://cemicursoj2ee.googlecode.com/svn/trunk/icefusion-1.0.1/)
  1. Probamos la generación de esqueletos de entidades, a partir de un POJO `Person`:
```
C:\CEMi_J2EE\icefusion-1.0.1> mvn appfuse:gen -Dentity=Person
```
  1. El resultado de ejecutar este comando equivale al siguiente parche SVN: [icefusion-Person.diff](http://cemicursoj2ee.googlecode.com/svn/trunk/icefusion-1.0.1/icefusion-Person.diff)