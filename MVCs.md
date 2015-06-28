# Modelos de desarrollo de aplicaciones web en Java #

  * Los servlets son buenos ejecutando lógica de negocio, pero no son tan buenos presentando información
  * JSPs son muy buenos presentando pero pésimos introduciendo lógica programática en ellos
  * La combinación Servlet/JSPs es lo más común hoy en día en el desarrollo de aplicaciones web
  * Dos arquitecturas:
    * **Model-1**: JSPs para presentación y control y JavaBeans para la lógica
    * **Model-2**: Model-View-Controller = JavaBeans-JSPs-Servlets
      * MVC es tan común que se han desarrollado varias infraestructuras en torno a este patrón de diseño:
        * Apache Struts
        * Java Server Faces
        * Spring MVC

## Model-1 ##

http://cemicursoj2ee.googlecode.com/files/model-1.JPG

## Model-2 ##

http://cemicursoj2ee.googlecode.com/files/model-2.JPG

## MVC (Model View Controller) ##

http://cemicursoj2ee.googlecode.com/files/model-mvc.JPG

  * El **Controlador** _(Controller)_
    * Servlet central recibe peticiones, procesa URL recibida y delega procesamiento a JavaBeans
    * Servlet guarda resultado de procesamiento realizado por JavaBeans en el contexto de la petición, la sesión o la aplicación
    * Servlet transfiere control a un JSP que lleva a cabo la presentación de resultados
  * El **Modelo** _(Model)_
    * JavaBeans (o EJBs para aplicaciones más escalables) desempeña el rol de modelo:
      * Algunos beans ejecutan lógica
      * Otros guardan datos
    * Normalmente:
      1. Servlet controlador invoca un método en bean lógico y éste devuelve un bean de datos
      1. Autor de JSP tiene acceso a bean de datos
  * La **Vista** _(View)_
    * Rol ejecutado por JSPs
    * Servlet Controlador transfiere control al JSP después de haber guardado en un contexto el resultado en forma de un bean de datos
    * JSP usa `jsp:useBean` y `jsp:getProperty` para recuperar datos y formatear respuesta en HTML o XML


# Características generales de un Framework MVC en J2EE #

  * Los frameworks pueden ser vistos como implementaciones de patrones de diseño que facilitan la reutilización de diseño y código
  * Dado que MVC ha sido utilizado en muchas aplicaciones web, el desarrollo de frameworks que den soporte a áreas comunes en todas las aplicaciones MVC es necesario
  * Requisitos exigibles a un framework:
    * Validación de campos
    * Control de errores
    * Internacionalización (mensajes _Locale_)
    * Mecanismo de creación de _TagLibs_ (librerías de etiquetas)
    * Listeners en el contexto del framework:
      * _Interceptors_
      * _Phase Listeners_
      * etc.
    * Plantillas:
      * Mecanismo de integración con _Decoration Frameworks_ (plantillas o templates):
        * Sitemesh http://www.opensymphony.com/sitemesh/
          * Artículo: http://today.java.net/pub/a/today/2004/03/11/sitemesh.html
      * Template engines:
        * FreeMarker http://freemarker.org/
        * Velocity http://velocity.apache.org/
    * Componentes de Interfaz de usuario _(UI Components)_
      * Extensiones enriquecidas de elementos HTML: inputs, radios, selects
      * Listados con paginación (`<display:table />`, `<t:dataTable />`)
      * Pestañas
      * AJAX

# Principales Frameworks MVC J2EE #

  * Struts 2: http://struts.apache.org/2.1.8/index.html
  * JSF: http://java.sun.com/javaee/javaserverfaces/
    * Implementaciones:
      * ICEfaces: http://www.icefaces.org/main/home/
      * Apache MyFaces Tomahawk: http://myfaces.apache.org/tomahawk/index.html
      * Apache MyFaces Sandbox: http://myfaces.apache.org/sandbox/
      * Prime Faces: http://primefaces.prime.com.tr/en/
      * RichFaces: http://www.jboss.org/richfaces http://www.juntadeandalucia.es/xwiki/bin/view/MADEJA/RichFaces
  * Spring MVC: http://static.springsource.org/spring/docs/2.5.x/reference/mvc.html

Tutoriales - AppFuse QuickStart - Español: http://appfuse.org/pages/viewpage.action?pageId=3866645