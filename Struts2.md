[![](http://struts.apache.org/2.1.8/images/struts2.png)](http://struts.apache.org/2.1.8/index.html)

  * [Introducción](Struts2#Introducci&oacute;n.md)
  * [Contenido](Struts2#Contenido.md)
  * [Ejemplos introductorios](Struts2#Ejemplos_introductorios.md)
  * [Ejercicios](Struts2#Ejercicios.md)
  * [Mecanismo para crear operaciones de tipo CRUD en el mismo Action](Struts2#Mecanismo_para_crear_operaciones_de_tipo_CRUD_en_el_mismo__Action_.md)

# Introducción #

Sitio: http://struts.apache.org/2.1.8/index.html

Documentación oficial: http://struts.apache.org/2.1.8/docs/core-developers-guide.html

Tutoriales recomendados: http://struts.apache.org/2.1.8/docs/tutorials.html

[![](http://struts.apache.org/2.1.8/images/struts2-merger2.png)](http://www.opensymphony.com/webwork/)

Extraído de `struts-2.1.8\src\core\pom.xml`
```
<dependency>
  <groupId>com.opensymphony</groupId>
  <artifactId>xwork-core</artifactId>
  <version>2.1.6</version>
</dependency>
```

_Obtengo los fuentes tanto de [OpenSymphony xwork-core 2.1.5](http://release.opensymphony.com/xwork/2.1.5/xwork-2.1.5-src.zip), como de [Apache Struts 2.1.8](http://struts.apache.org/download.cgi#struts218) para incluirlos en el debugger de Eclipse_

Tutorial: http://www.vaannila.com/struts-2/struts-2-tutorial/struts-2-tutorial.html

[![](http://www.vaannila.com/images/struts2/Interceptor1Pic1.gif)](http://www.vaannila.com/struts-2/struts-2-tutorial/struts-2-tutorial.html)

# Contenido #

  * Concepto de Struts
    * Action Oriented Framework basado en el patrón MVC al igual que Struts 1
    * MVC en partes:
      * El **Modelo** es el _Action_
        * Se trata del estado interno de la aplicación. Este estado se compone del modelo de datos (datos transferidos) y de la lógica de negocio (funcionalidades con esos datos).
      * La **Vista** es el _Result_
      * El **Controlador** es el _FilterDispatcher_
        * Se trata de un _front-controller_ (es el primer componente que procesa una petición)
        * A grandes rasgos la tarea del controlador es realizar la traducción de una petición HTTP a una instancia de un _action_.
        * Esta tarea la realiza el _FilterDispatcher_. Se trata de un _servlet filter_ que inspecciona para cada petición entrante qué _action_ Struts2 debería procesar la petición.
        * Hay dos formas de definir este mapeo `URL-action`:
          * A través del fichero de configuración `struts.xml`
          * A través de anotaciones Java 1.5
    * Struts 2 no es sólo una nueva versión de Struts 1, es un framework completamente nuevo basado en la arquitectura de _OpenSymphony WebWork framework_
    * Es un framework de desarrollo de aplicaciones web de segunda generación.
    * Al igual que Struts 1, Struts 2  tiene un diseño robusto (utilización de patrones de diseño y buenas prácticas)
  * Componentes estándares de Struts
  * Flujo de Control en Struts
  * Procesamiento de Peticiones
  * Control de Errores
  * Manejo de Formularios
  * Librerías de Etiquetas (_TagLibs_)
  * Internacionalización
  * Mejoras y ventajas respecto a la versión 1.3
    * Inclusión de mecanismos como Interceptores
    * Configuración basada en anotaciones (Java 1.5 Annotations)
    * Inclusión de OGNL
    * Un API de etiquetas que constitute un mini-MVC modificable y que permite reutilizar _UI Components_
    * Según la documentación oficial de Struts, la migración de una aplicación `Struts` a `Struts2` es directa. Es compatible hacia atrás. No obstante: http://www.infoq.com/articles/converting-struts-2-part1

# Ejemplos introductorios #

  1. Struts 2 Annotation Tutorial 1 [Struts2Example1](http://cemicursoj2ee.googlecode.com/svn/trunk/Struts2Example1/)
  1. Struts 2 Annotation Tutorial 2 [Struts2ExampleAnnotations](http://cemicursoj2ee.googlecode.com/svn/trunk/Struts2Example2/)
    * http://struts.apache.org/2.0.11.1/docs/annotations.html
  1. Struts 2 Hello World Tutorial [Struts2HelloWorld1](http://cemicursoj2ee.googlecode.com/svn/trunk/Struts2HelloWorld1/)
  1. Struts 2 UI Tags Tutorial [Struts2ExampleUITags](http://cemicursoj2ee.googlecode.com/svn/trunk/Struts2Example7/)
    * http://struts.apache.org/2.0.11.1/docs/ui-tags.html
    * http://struts.apache.org/2.0.9/docs/tag-reference.html
    * Ver StrutsXML > "2.7 Action. Utilizando _wildcards_ (`*`) para definir _actions_ dinámicos"
  1. Struts 2 Data Tags Tutorial [Struts2ExampleDataTags](http://cemicursoj2ee.googlecode.com/svn/trunk/Struts2Example11/)
  1. Struts 2 Bean Tag Tutorial [Struts2ExampleBeanTag](http://cemicursoj2ee.googlecode.com/svn/trunk/Struts2Example12/)
  1. Struts 2 Control Tags Tutorial [Struts2ExampleControlTags](http://cemicursoj2ee.googlecode.com/svn/trunk/Struts2Example10/)
  1. Struts 2 OGNL Expression Language Tutorial [Struts2ExampleOGNL](http://cemicursoj2ee.googlecode.com/svn/trunk/Struts2ExampleOGNL/)
    * _OGNL:_ http://www.opensymphony.com/ognl/
  1. Struts 2 Interceptors Tutorial [Struts2ExampleInterceptor1](http://cemicursoj2ee.googlecode.com/svn/trunk/Struts2ExampleInterceptor1/)
  1. Struts 2 Interceptors Tutorial [Struts2ExampleInterceptor2](http://cemicursoj2ee.googlecode.com/svn/trunk/Struts2ExampleInterceptor2/)
    * _XWork Default Interceptors:_ http://www.opensymphony.com/xwork/wikidocs/XWork%20Interceptors.html
    * http://struts.apache.org/2.1.8/docs/interceptors.html
  1. DispatchAction Functionality in Struts 2 Tutorial [Struts2ExampleDispatchAction1](http://cemicursoj2ee.googlecode.com/svn/trunk/Struts2ExampleDispatchAction1/)
  1. Dynamic Method Invocation Tutorial [Struts2ExampleDynamicMethodInvocation](http://cemicursoj2ee.googlecode.com/svn/trunk/Struts2ExampleDynamicMethodInvocation/)
  1. Struts 2 Validation Tutorial [Struts2ExampleValidation1](http://cemicursoj2ee.googlecode.com/svn/trunk/Struts2ExampleValidation1/)
  1. Struts 2 Validation Using XML File Tutorial [Struts2ExampleValidation2](http://cemicursoj2ee.googlecode.com/svn/trunk/Struts2ExampleValidation2/)
    * _XWork Validation Framework:_ http://www.opensymphony.com/xwork/wikidocs/Validation%20Framework.html
    * http://struts.apache.org/2.1.8/docs/validation.html
  1. Struts 2 Validation _client-side_ [Struts2ExampleValidation3](http://cemicursoj2ee.googlecode.com/svn/trunk/Struts2ExampleValidation3/)
    * http://struts.apache.org/2.1.8/docs/client-validation.html
  1. Struts 2 Multilanguage [Struts2ExampleMultilanguage](http://cemicursoj2ee.googlecode.com/svn/trunk/Struts2ExampleMultilanguage/)
  1. Domain Object as JavaBeans Property Tutorial [Struts2ExampleDomainObject](http://cemicursoj2ee.googlecode.com/svn/trunk/Struts2ExampleDomainObject/)
  1. Struts 2 ModelDriven Action Tutorial [Struts2ExampleModelDriven](http://cemicursoj2ee.googlecode.com/svn/trunk/Struts2ExampleModelDriven/)
    * http://struts.apache.org/2.1.8/docs/model-driven.html
  1. Struts 2 File Upload Tutorial [Struts2ExampleFileUpload](http://cemicursoj2ee.googlecode.com/svn/trunk/Struts2ExampleFileUpload/)
  1. Struts 2 Tiles Integration Tutorial [Struts2ExampleTiles](http://cemicursoj2ee.googlecode.com/svn/trunk/Struts2ExampleTiles/)

# Ejercicios #

http://cemicursoj2ee.googlecode.com/files/ejercicio.GIF **Ejercicio 1:**
A partir del ejemplo **Struts2ExampleFileUpload** crear un _action_ que permita efectuar la descarga de archivos almacenados en disco. Será invocado a través de una JSP: `solicitarFichero.jsp`:

http://cemicursoj2ee.googlecode.com/files/ejercicio1.JPG

Este action deberá denominarse `FileDownloadAction` y tendrás dos _properties_:
  * `String filename;` // nombre del fichero que queremos descargar
  * `String fileContentType;` // tipo-mime que nos servirá para establecer el _contentType_ de la _response_.. `response.setContentType(fileContentType);`
La ruta por defecto de estos ficheros en el servidor deberá ser la misma que la usada en el [FileUploadAction](http://cemicursoj2ee.googlecode.com/svn/trunk/Struts2ExampleFileUpload/src/vaannila/FileUploadAction.java) ..
```
private static final String  UPLOADS_DIRECTORY = "c:/uploads/";
```

Pistas:
  * http://code.google.com/p/cemicursoj2ee/wiki/StrutsXML#5._Tipos_de_resultados

**Solución (parche SVN)**: [solucion.diff](http://cemicursoj2ee.googlecode.com/svn/trunk/Struts2ExampleFileUpload/solucion.diff)


---


http://cemicursoj2ee.googlecode.com/files/ejercicio.GIF **Ejercicio 2:**
Crear un proyecto nuevo y que llamaremos **Struts2AppFinal**

Esta aplicación tendrá una página de _login_: **login.jsp**. Esta página constará de:
  * un formulario
  * dos campos de tipo texto: **email** y **password**. Ambos campos son obligatorios y el email debe estar _bien-formado_ (deberemos hacer tanto validaciones en el cliente como en el servidor).
  * un botón **Acceder**

Cuando pulsemos **Acceder**, nuestra aplicación deberá almacenar en sesión un parametro de nombre ´UsuarioLogado` de tipo `java.util.HashMap` con las siguientes claves:
  * **(KEY, VALUE)**
  * ("email", _valor del campo email introducido en `login.jsp`_)
  * ("password", _valor del campo password introducido en `login.jsp`_)
  * ("ultimoAcceso", _fecha y hora actual_)

_Por ejemplo:_ si se ha _logado_ un usuario de email "benito@gmail.com" y de **password** "perez", deberemos guardar en sesión lo siguiente:
  * `HashMap hashMapUsuarioLogado;`
  * Nombre de parámetro en sesión: "UsuarioLogado"
  * Valor de este parámetro de tipo `HashMap`:
    * ("email", "benito@gmail.com")
    * ("password", "perez")
    * ("ultimoAcceso", "20091029 20:30")

Una vez, el usuario se ha logado y el execute() de ese action ha almacenado en sesión toda esa información, deberemos acceder a un págin **menu.jsp** que mostrará los siguientes enlaces:
  * "Ir a google.com", me deberá redireccionar a http://www.google.es. Este enlace deberá tener un _tool-tip_ o _title_ "Buscar".
  * "FAQ", me debe redireccinar a una página **faq.jsp** que deberá mostrar:
    * Un texto "Preguntas frecuentes" multi-idioma ("en" y "es") en la cabecera y una encuesta.
    * La encuesta deberá una pregunta que nosotros elijamos utilizando un _radio button_ para las respuestas.
    * Un botón **enviar datos** que invocará a una página **resultado.jsp** en la que se mostrará la respuesta seleccionada.
  * "Cerrar sesión", deberá eliminar de sesión el parámetro de nombre **UsuarioLogado** y retornar a la página de _login_

  * `PISTAS:

**1.** La fecha y la hora actual, la podemos obtener a partir de este método:
```
import java.util.Calendar;
import java.util.Date;

/**
 * Método que calcula la fecha y hora actual
 * 
 * @return la fecha y hora actual
 */
public static Date getCurrentDate() {
  return Calendar.getInstance().getTime();
}
```

**2.** Para trabajar con el objeto `HttpSession` en Struts 2, utilizaremos la siguiente sentencia:
```
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;

HttpSession session = ServletActionContext.getRequest().getSession()

// 1. si queremos guardar un parámetro en sesión:
session.setAttribute("UsuarioLogado",hashMapUsuarioLogado);

// 2. si queremos obtener el valor de un parámetro
Object sessionObjUsuarioLogado = session.getAttribute("UsuarioLogado");

HashMap sessionUsuarioLogado = null;
if (sessionObjUsuarioLogado instanceof HashMap) {
  sessionUsuarioLogado = (HashMap) sessionObjUsuarioLogado;
}

// 3. si queremos eliminar un parámetro de sesión
session.remove("UsuarioLogado");
```

**3.** Para mostrar un texto multi-idioma en una página JSP:

http://struts.apache.org/2.0.9/docs/i18n.html

```
<s:i18n name="myCustomBundle">
   La palabra "casa" se dice en idioma: <s:text value="casa" />
</s:i18n>
```

Struts 2 por defecto buscaría la property 'casa' en los ficheros de properties:

```
myCustomBundle.properties // idioma por defecto
myCustomBundle_es.properties // esPAÑOL
myCustomBundle_en.properties // enGLISH
...
```

Si queremos cambiar el emplazamiento de nuestras properties multi-idioma _(por ejemplo: `messages.properties` en el raíz del classpath)_, deberemos configurar nuestro `struts.xml` de la siguiente forma:

```
<constant name="struts.custom.i18n.resources" value="messages"/>
```

y podremos mostrar los mensajes de la siguiente forma:

```
<s:text value="casa" />
```

Ya que estamos para evitar el problema típico del encoding de los acentos y asegurar la compatibilidad con cualquier Sist.Operativo, utilizaremos `UTF-8`:

```
<constant name="struts.i18n.encoding" value="UTF-8"/>
```

**4.** Utilización del validador de email que incluye Struts 2 por defecto:

```
<field name="myEmail">
   <field-validator type="email">
      <message>Must provide a valid email</message>
   </field-validator>
</field>
```

**5.** Etiquetas Struts 2 para URLs

http://struts.apache.org/2.0.9/docs/url.html

Una URL en Struts 2 se considera como un tipo de datos. Para generar un dato de tipo URL, utilizamos el tag: `<s:url />`

5.1 Si queremos ejecutar un action concreto
```
<s:url value="personList.action" />
```

5.2 Si queremos ejecutar un action y un método concreto
```
<s:url value="personList.action" method="list" />
```

5.3 Si necesitamos pasar un parámetro al action
```
<s:url value="personEdit.action" method="list">
  <s:param name="id" value="%{'22'}" />
</s:url>
```

5.4 Si queremos crear un enlace que apunte a una URL externa a la aplicación:
<a href='http://www.google.es' title='Buscar'>Ir a google.es</a>

**6.** Etiquetas Struts 2 para enlaces

Para construir un enlace en Struts 2 podemos usar el ancla estándar html: `<a href="url_enlace">texto_enlace</a>` como el ancla de Struts2:
`<s:a href="%{url_enlace}">texto_enlace</s:a>`

**Solución:** [Struts2AppFinal](http://cemicursoj2ee.googlecode.com/svn/trunk/Struts2AppFinal)


---


http://cemicursoj2ee.googlecode.com/files/ejercicio.GIF **Ejercicio 3:**
Crear un interceptor de control de acceso a las páginas de la aplicación creada en el ejercicio 2.

Este interceptor deberá obtener de sesión el parámetro "UsuarioLogado".
```
if (existe dicho parámetro) && (la fecha y hora del último acceso corresponde al día de hoy) {
  [el interceptor permitirá acceder a la página solicitada]
} else {
  [el interceptor nos redirigirá a la página de login]
}
```

**Solución (parche SVN)**: [solucion.diff](http://cemicursoj2ee.googlecode.com/svn/trunk/Struts2AppFinal/solucion.diff)


---


# Mecanismo para crear operaciones de tipo CRUD en el mismo Action #
struts.xml
```
<action name="*/*" method="{2}" class="es.cemi.sample.{1}Action">
  <result type="redirect">/{1}/view.action</result>
  <result name="view">/{1}/view.jsp</result>
  <result name="input">/{1}/edit.jsp</result>
  <result name="home">/{1}/home.jsp</result>
</action>
```

Para una entidad `User`, su _Action_ quedaría de la siguiente forma:

```
public class UserAction extends ActionSupport implements ModelDriven, Preparable {
  private User user;
  private int id;
  private UserService service; // user business service
  …
  
  public void setId(int id) {
    this.id = id;
  }
  
  /**
    create a new user if none exists, otherwise
    load the user with the specified id
   */
  public void prepare() throws Exception {
    if( id==0 ) {
      user = new User();
    } else {
      user = service.findUserById(id);
    }
  }
  
  public Object getModel() {
    return user;
  }
  
  /**
    create or update the user and then
    view the created user
   */
  public String update() {
    if( id==0 ) {
      service.create(user);
    } else {
      service.update(user);
    }
    return "redirect";
  }
  
  /**
    delete the user and go to a default home page
   */
  public String delete() {
    service.deleteById(id);
    return "home";
  }
  
  /**
    show the page allowing the user to
    view the existing data
   */
  public String view() {
    return "view";
  }
  
  /**
    show the page allowing the user to view
    the existing data and change the values
   */
  public String edit() {
    return "input";
  }
}
```