# Ejemplo de CRUD sin Maven y sin WAR Overlays #

La aplicación que hemos generado antes nos ha servido para analizar que elementos constituyen una aplicación CRUD en Struts2, Spring e Hibernate.
No obstante, tenemos un problema con Eclipse, ya que no funciona correctamente la integración entre Maven y los WTP Servers. Este problema debería resolverlo [Eclipse IAM](http://www.eclipse.org/iam/), pero... este plugin está verde todavía, así que lo mejor es refactorizar el proyecto anterior para poder trabajar facilmente con un WTP Server.

## Importamos el proyecto Struts2Webapp ##

`Eclipse > File > Import > SVN > Checkout Projects from SVN`

http://cemicursoj2ee.googlecode.com/svn/trunk/Struts2Webapp/

Desplegamos dicho proyecto en el WTP Server que creamos con los ejemplos introductorios y lo arrancamos.

En dicho proyecto se ha simplificado toda la capa web de Appfuse, dejando unicamente las JSPs del listado y detalle de personas.

Para **Hibernate**:
```
+ /src/main/java
  + es.cemi.samples.model.Person
+ /src/main/resources
  - hibernate.cfg.xml
  - jdbc.properties
```

Para **Spring**:
```
+ /src/main/resources
  - applicationContext-resources.xml

+ /WebContent/WEB-INF
  - applicationContext.xml
  - security.xml
```

Para **Struts2**:
```
+ /src/main/java
  + es.cemi.samples.webapp.action.PersonAction
  + org.appfuse.webapp.action.BaseAction
  
+ /src/main/resources
  - struts2.xml
  - ApplicationResources*.properties
  - errors*.properties
  - displaytag*.properties
  
+ /WebContent
  - index.jsp

+ /WebContent/common
  - taglibs.jsp
  
+ /WebContent/WEB-INF
  - appfuse.tld

+ /WebContent/WEB-INF/pages
  - personList.jsp
  - personForm.jsp
```