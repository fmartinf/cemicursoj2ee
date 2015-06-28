# El fichero `struts.xml` en profundidad #

El fichero "struts.xml" contiene toda la información de configuración de nuestra aplicación Struts2. Entre ella se incluyen las definiciones de:
  1. _includes_
  1. _packages_
  1. _actions_
  1. _interceptors_
  1. _results types_
  1. _beans_
  1. _constants_

Si queremos ser estrictos, la "biblia" de este fichero se encuentra en su DTD:

http://struts.apache.org/dtds/struts-2.0.dtd
```
<?xml version="1.0" encoding="UTF-8"?>

<!ELEMENT struts (package|include|bean|constant)*>

<!ELEMENT package (result-types?, interceptors?, default-interceptor-ref?, default-action-ref?, default-class-ref?, global-results?, global-exception-mappings?, action*)>
<!ATTLIST package
    name CDATA #REQUIRED
    extends CDATA #IMPLIED
    namespace CDATA #IMPLIED
    abstract CDATA #IMPLIED
    externalReferenceResolver NMTOKEN #IMPLIED
>

<!ELEMENT result-types (result-type+)>

<!ELEMENT result-type (param*)>
<!ATTLIST result-type
    name CDATA #REQUIRED
    class CDATA #REQUIRED
    default (true|false) "false"
>

<!ELEMENT interceptors (interceptor|interceptor-stack)+>

<!ELEMENT interceptor (param*)>
<!ATTLIST interceptor
    name CDATA #REQUIRED
    class CDATA #REQUIRED
>

<!ELEMENT interceptor-stack (interceptor-ref*)>
<!ATTLIST interceptor-stack
    name CDATA #REQUIRED
>

<!ELEMENT interceptor-ref (param*)>
<!ATTLIST interceptor-ref
    name CDATA #REQUIRED
>

<!ELEMENT default-interceptor-ref (#PCDATA)>
<!ATTLIST default-interceptor-ref
    name CDATA #REQUIRED
>

<!ELEMENT default-action-ref (#PCDATA)>
<!ATTLIST default-action-ref
    name CDATA #REQUIRED
>

<!ELEMENT default-class-ref (#PCDATA)>
<!ATTLIST default-class-ref
    class CDATA #REQUIRED
>

<!ELEMENT global-results (result+)>

<!ELEMENT global-exception-mappings (exception-mapping+)>

<!ELEMENT action (param|result|interceptor-ref|exception-mapping)*>
<!ATTLIST action
    name CDATA #REQUIRED
    class CDATA #IMPLIED
    method CDATA #IMPLIED
    converter CDATA #IMPLIED
>

<!ELEMENT param (#PCDATA)>
<!ATTLIST param
    name CDATA #REQUIRED
>

<!ELEMENT result (#PCDATA|param)*>
<!ATTLIST result
    name CDATA #IMPLIED
    type CDATA #IMPLIED
>

<!ELEMENT exception-mapping (#PCDATA|param)*>
<!ATTLIST exception-mapping
    name CDATA #IMPLIED
    exception CDATA #REQUIRED
    result CDATA #REQUIRED
>

<!ELEMENT include (#PCDATA)>
<!ATTLIST include
    file CDATA #REQUIRED
>

<!ELEMENT bean (#PCDATA)>
<!ATTLIST bean
    type CDATA #IMPLIED
    name CDATA #IMPLIED
    class CDATA #REQUIRED
    scope CDATA #IMPLIED
    static CDATA #IMPLIED
    optional CDATA #IMPLIED
>

<!ELEMENT constant (#PCDATA)>
<!ATTLIST constant
    name CDATA #REQUIRED
    value CDATA #REQUIRED    
>
```

No obstante, lo iremos viendo paso a paso.

## 1. Etiqueta `<struts>` ##

### 1.1 Etiqueta `<struts>`: Particionado en distintos ficheros mediante `<include />` ###

Para evitar contar con un `struts.xml` muy grande, podemos particionar dicho fichero mediante la utilización de _includes_:

```
<struts>
  <include file="billing-config.xml" />
  <include file="admin-config.xml" />
  <include file="reports-config.xml" />
  ...
</struts>
```

  * El orden de los includes importa, ya que si en `admin-config.xml` usamos un tag definido en
`billing-config.xml` y cambiamos el orden de los includes, subiendo `admin-config.xml`, dicho tag ya no será resuelto correctamente.

  * Del mismo modo que nosotros podemos incluir nuevos _Struts XMLs_, automaticamente, ya se estan incluyendo los siguientes ficheros:
    * `struts-default.xml` _ofrece la configuración del corazón de Struts2_
    * `struts-plugin.xml` _ofrece la configuración necesaria para un plugin particular_
> > Cada _plugin_ en forma de JAR deberá contener un fichero `struts-plugin.xml` que será cargado durante el arranque del servidor.


### 1.2 Etiqueta `<struts>`: Definición de paquetes `<package />` ###

```
<struts>
  <package name="struts2" extends="struts-default" namespace="/struts2">
  …
  </package>
</struts>
```

  * La etiqueta `<package … />` es usada para agrupar atributos comunes de configuración tales como pilas de interceptores o URLs de espacios de nombres _(namespaces)_.
  * Esto puede ser útil para organizar de forma separada funcionalidades que puedan ser separadas en distintos ficheros de configuración.
  * Los atributos de esta etiqueta pueden ser:
    * _name_ nombre identificativo que deberemos indicarle. Debe ser único.
    * _extends_ nombre del paquete que estamos heredando (todos sus parámetros de configuración, incluyendo los _actions_).
    * _namespace_ el _espacio de nombres_ proporciona una relación _[URL, package]_.
Por ejemplo, si tenemos dos paquetes _(packages)_ diferentes con _namespaces_ "paquete1" y "paquete2", respectivamente, las URLs deberán ser algo parecido a `/miApp/paquete1/mi.action` y `/miApp/paquete2/mi.action`.
    * _abstract_ si es `true` entonces los _actions_ que se definan bajo este, sólo serán accesibles a través de paquetes que hereden de este.
Un ejemplo de paquete abstracto, lo tenemos en `struts-default` (paquete del fichero de configuración `struts-default.xml`)

### 1.3 Etiqueta `<struts>`: Definición de _beans_  y de _constantes_ ###

  * `<bean … />`
  * `<constant … />`

Ambas etiquetas permiten redefinir parámetros del framework. Veámos algunos ejemplos:

## 2. Actions ##

### 2.1 Actions de un único resultado ###

```
class MyAction {
  public void String execute() throws Exception {
    return "success";
  }
}
```

La forma más sencilla de definirlo sería:
```
<action name="my" class="com.fdar.infoq.MyAction" >
  <result>view.jsp</result>
</action>
```

### 2.2 Actions de múltiples resultados ###

```
class MyAction {
  public void String execute() throws Exception {
    if( myLogicWorked() ) {
      return "success";
    } else {
      return "error";
    }
  }
}
```

```
<action name="my" class="com.fdar.infoq.MyAction" >
  <result>view.jsp</result>
  <result name="error">error.jsp</result>
</action>
```

### 2.3 Actions: Tipos de resultados ###

El tipo de un resultado se define mediante el atributo `type` en el nodo `<result />`:
  * `dispatcher` es el valor por defecto
  * `stream`
  * etc.

Más info: http://struts.apache.org/2.0.6/docs/result-types.html

### 2.4 Actions. Request y Form Data ###

In order to make decisions about how the action should work,
and to provide data for database persistent objects, the action
may need to access values from the request string as well as the
form data.


Struts2 follows the JavaBean paradigm – if you want access to
data, you provide a getter and/or setter for the field. Providing
access to the request string and form values is no different. Each
request string or form value is a simple name value pair, so to
assign the value for a particular name, a setter is created on the
action. For example, if a JSP makes a call
“/home.action?framework=struts&version=2” the action would
need to provide a setter “setFramework( String frameworkName
)” as well as a setter “setVersion( int version )”.


Notice in this example that the setter does not always need to be
a String value. By default, Struts2 will convert from a String to
the type on the action. This is done for all primitive types and
basic object types, and can be configured for your own custom
classes. Struts2 will also handle the navigation of the value into
more complex object graphs, i.e. for a name on a form element
name of “person.address.home.postcode” and a value of “2”,
Struts2 will make the equivalent call
“getPerson().getAddress().getHome().setPostcode(2)”.


### 2.5 Actions. Accediendo a servicios de la lógica de negocio desde el _action_ ###

Up until now we have been concerned with the actions
configuration, and how to control the rendering of a result back
to the user for different result codes. This is an important part of
what actions do but, before they return a result, some processing
needs to be performed. For this, they need access to a variety of
different objects – business objects, data access objects or other
resources.

To provide a loosely coupled system, Struts2 uses a technique
called dependency injection, or inversion of controlv.
Dependency injection can be implemented by constructor
injection, interface injection and setter injection. Struts2 uses
setter injection. This means that to have objects available to the
action, you need only to provide a setter. The preferred
dependency injection framework is the Spring Framework,
which is configured via a plugin. Another option is Plexus, or if
you prefer you can supply your own implementation.

There are also objects that are not managed by the spring
framework, such as the HttpServletRequest. These are
handled by using a combination of setter injection and interface
injection. For each of the non-business objects there is a
corresponding interface (known as an “aware” interface) that the
action is required to implement.

With the necessary interfaces and setters in place, interceptors
will manage the injection of the necessary objects.

### 2.6 Actions. Accediendo a datos desde el _action_ ###

At some point there will be a need to view objects that have been
modified by the action. There are several techniques that can be
used.

A familiar technique for most web developers is to place the
object that needs to be accessed in the HttpServletRequest or
the HttpSession. This can be achieved by implementing the
“aware” interface (letting the dependency injection to do its
work) and then setting the object to be accessed under the
required name.

If you intend to use the built-in tag libraries or the included
JSTL support, accessing the data is much easier. Both of these
are able to directly access the action via the Value Stack. The
only additional work for developers is to provide getters on the
action that allows access to the objects that need to be accessed.
We will talk more about the Value Stack in a later section.

=== 2.7 Action. Utilizando _wildcards_ (**) para definir _actions_ dinámicos**

_Ejemplo 1:_
```
<action name="*Register" method="{1}" class="vaannila.RegisterAction">
  <result name="populate">/register.jsp</result>
  <result name="success">/success.jsp</result>
</action>
```

Este action comtempla todas referencias a actions que acaben en "Register". De este modo, las siguientes invocaciones casarían con esta definición de action:
`populateRegister`
`Register`

Los parámetros `{1}`, `{2}`, `{3}`, etc corresponden a la cadena del `*`, de izqda a dcha.

De este modo cuando se trata de "casar" el _action_ `populateRegister`, este casaría con `*Register`, siendo `{1}` igual a `populate`.
Este _action_ populateRegister, tendría como resultado la ejecución del método `populate()` en la clase `vaannila.RegisterAction`.

Para el caso del _action_ `Register`, también correspondería a `*Register`, pero en este caso `{1}` sería la cadena vacía, con lo que el método que
se ejecutaría sería `execute()`.

_Ejemplo 2:_ Supongamos un CRUD de entidades, en el que realizamos la siguiente estructura de _actions_:

  * `/admin/User/list.action`
  * `/admin/User/add.action`
  * `/admin/User/edit.action`

Una posible definición de _action_ sería:
```
<action name="*/*/*" method="{3}" class="com.infoq.actions.{1}.{2}Action">
  <result name="view">/{1}/update{2}.jsp</result>
  <result name="list">/{1}/list.jsp</result>
</action>
```

Para los tres actions del CRUD de User, equivaldría a definir el siguiente conjunto de _actions_:
```
<action name="/admin/User/list" method="list" class="com.infoq.actions.admin.UserAction">
  <result name="view">/admin/updateUser.jsp</result>
  <result name="list">/admin/list.jsp</result>
</action>

<action name="/admin/User/add" method="add" class="com.infoq.actions.admin.UserAction">
  <result name="view">/admin/updateUser.jsp</result>
  <result name="list">/admin/list.jsp</result>
</action>

<action name="/admin/User/edit" method="edit" class="com.infoq.actions.admin.UserAction">
  <result name="view">/admin/updateUser.jsp</result>
  <result name="list">/admin/list.jsp</result>
</action>
```

## 3. Interceptores ##

Many of the features provided in the Struts2 framework are
implemented using interceptors; examples include exception
handling, file uploading, lifecycle callbacks and validation.
Interceptors are conceptually the same as servlet filters or the
JDKs Proxy class. They provide a way to supply pre-processing
and post-processing around the action. Similar to servlet filters,
interceptors can be layered and ordered. They have access to the
action being executed, as well as all environmental variables and
execution properties.

Let’s start our discussion of interceptors with dependency
injection. Injecting dependencies into the action, as we have
already seen, can happen in a couple of different ways. Here are
the implementing interceptors for those we have already
mentioned:

  * Spring Framework – the ActionAutowiringInterceptor interceptor.
  * Request String and Form Values – the ParametersInterceptor interceptor.
  * Servlet-based objects – the ServletConfigInterceptor interceptor.

The first two interceptors work independently, with no
requirements from the action, but the last interceptor is different.
It works with the assistance of the following interfaces:
  * SessionAware – to provide access to all the session
attributes via a Map
  * ServletRequestAware – to provide access to the
HttpServletRequest object
  * RequestAware – to provide access to all the request
attributes via a Map
  * ApplicationAware – to provide access to all the
application attributes via a Map
  * ServletResponseAware – to provide access to the
HttpServletResponse object
  * ParameterAware – to provide access to all the request
string and form values attributes via a Map
  * PrincipalAware – to provide access to the
PrincipleProxy object; this object implements the
principle and role methods of the HttpServletRequest
object in implementation, but by providing a proxy,
allows for implementation independence in the action
  * ServletContextAware – to provide access to the ServletContext object

For the correct data to be injected into an action, it will need to
implement the necessary interface.

### 3.1 Interceptores. Configuración ###

If we want to enable dependency injection (or any other type of
functionality provided by an interceptor) on our action we need
to provide configuration. Like other elements, many
interceptors have been preconfigured for you. Just make sure
that the package your actions are in extends the “struts-default”
package.

To configure a new interceptor, we first need to define the
interceptor. The <interceptors … /> and <interceptor …/> tags
are placed directly under the 

&lt;package&gt;

 tag. For the
above mentioned Spring Framework interceptor, the
configuration is as follows:

```
<interceptors>
  …
  <interceptor name="autowiring" class="interceptor.ActionAutowiringInterceptor"/>
</interceptors>
```

We also need to ensure that the interceptor is applied to the
action that requires it. This can be achieved in two ways. The
first is to assign the interceptor to each action individually:

```
<action name="my" class="com.fdar.infoq.MyAction" >
  <result>view.jsp</result>
  <interceptor-ref name="autowiring"/>
</action>
```

Using this configuration there is no limitation on the number of
interceptors you can apply to an action. What is required, is that
the interceptors are listed in the order that they are to be
executed.
The second way is to assign a default interceptor for the current
package:

```
<default-interceptor-ref name="autowiring"/>
```

This declaration is made directly under the <package … /> tag,
and only one interceptor can be assigned as the default.
Now that the interceptor has been configured for a particular
action mapping, it will be executed on each and every request to
the mapped URL. But this is very limiting, as most of the time
we require more than one interceptor to be assigned to an action.

In fact, as Struts2 bases much of its functionality on interceptors,
it is not unlikely to have 7 or 8 interceptors assigned per action.
As you can imagine, having to configure every interceptor for
each action would quickly become extremely unmanageable.
For this reason, interceptors are managed with interceptor stacks.
Here is an example, directly from the struts-default.xml file:

```
<interceptor-stack name="basicStack">
  <interceptor-ref name="exception"/>
  <interceptor-ref name="servlet-config"/>
  <interceptor-ref name="prepare"/>
  <interceptor-ref name="checkbox"/>
  <interceptor-ref name="params"/>
  <interceptor-ref name="conversionError"/>
</interceptor-stack>
```

This configuration node is placed under the <package … />
node. Each <interceptor-ref … /> tag references either an
interceptor or an interceptor stack that has been configured
before the current interceptor stack.
We have already seen how to apply interceptor to the action,
applying interceptor stacks is no different. In fact, we use
exactly the same tag:

```
<action name="my" class="com.fdar.infoq.MyAction" >
  <result>view.jsp</result>
  <interceptor-ref name="basicStack"/>
</action>
```

The same holds true for the configuration of the default
interceptor – simply use an interceptor stack configuration name
rather than an individual interceptor name.


&lt;default-interceptor-ref name="basicStack"/&gt;


It is therefore very important to ensure that the name is unique
across all interceptor and interceptor stack configurations when
configuring the initial interceptors and interceptor stacks.

### 3.2 Interceptores. Implementando nuevos interceptores ###

Using custom interceptors in your application is an elegant way
to provide cross-cutting application features. The interface that
needs implementing is simple, and comes from the XWork
framework. It has only 3 methods:

```
public interface Interceptor extends Serializable {
  void destroy();
  void init();
  String intercept(ActionInvocation invocation) throws Exception;
}
```

In fact, if there is no initialization or cleanup required, there is an
AbstractInterceptor class that can be extended instead. This
class provides a default no-op implementation of both the
“destroy” and “init” methods.

The ActionInvocation object provides access to the runtime
environment. It allows access to the action itself; the context
(which for a web application includes the request parameters,
session parameters, the users locale, etc.); the result of the
actions execution; and methods to invoke the action and
determine whether the action has already been invoked.
We have already seen how to configure interceptors, and
configuring custom interceptors is exactly the same. If you do
create your own interceptors, you will also want to consider
creating custom interceptor stacks. In this manner you will
ensure consistent application of the new interceptor across all
actions that require it.

## 4. Value Stack / OGNL ##

This section covers two ideas that are closely related. The value
stack is exactly what it says it is – a stack of objects. OGNL
stands for Object Graph Navigational Language, and provides
the unified way to access objects within the value stack.

The value stack consists of the following objects in the provided
order:
1. Temporary Objects – during execution temporary objects
are created and placed onto the value stack; an example
of this would be the current iteration value for a
collection being looped over in a JSP tag
2. The Model Object – if model objects are being used, the
current model object is placed before the action on the
value stack
3. The Action Object – the action being executed
4. Named Objects – these objects include #application,
#session, #request, #attr and #parameters and refer
to the corresponding servlet scopes

Accessing the value stack can be achieved in many different
ways. The most common way is via the tags provided for JSP,
Velocity and Freemarker. HTML tags are commonly used to
access properties of objects from the value stack; control tags
(such as if, elseif and iterator) are used with expressions; and
data tags are available to manipulate the stack itself (via set and
push).

When using the value stack there is no need to keep track of
which scope the target object is in. If you want the attribute
“name”, then you query the value stack for this attribute. Each
stack element, in the provided order, is asked whether it has the
property. If it does, then the value is returned and we are done.
If not, then the next element down is queried. This continues
until the end of the stack is reached. This is a great feature, as
you don’t care where the value is – the action, the model, or the
HTTP request – you just know that if the value exists it will be
returned.

There is a downside. If the property is common (for example
“id”) and you want the value from a specific object (say the
action) that is not the first object encountered with this property
on the value stack, the value returned may not be what you
expect. What will be returned is an “id” value, but it may be
from a JSP tag, interim object, or a value from the model object.
OGNL is more than just a means to access the properties of
objects, and we can use this to our advantage here. If we know
the depth in the stack of the action, we could use “[2](2.md).id” instead
of an expression of “id”.

In fact, OGNL is a fully featured expression language. As well
as using dot notation to navigate object graphs (i.e. using
“person.address” instead of “getPerson().getAddress()” as the
expression), OGNL supports features such as type conversion,
calling methods, collection manipulation and generation,
projection across collections, expression evaluation and lambda
expressions . The complete language guide can be found at
http://www.ognl.org/2.6.9/Documentation/html/LanguageGuide/index.html.

## 5. Tipos de resultados ##

So far we have shown action configurations that result in a JSP
being rendered to the user. This is one case, but not the only
one. In fact, Struts2 supports many types of results. These can
be visual, or they can be interactions with the environment.
To configure an action to execute a result of a specific type, the
“type” attribute is used. If the attribute is not supplied, the
default type “dispatcher” is used – this will render a JSP result.
Here’s what the action configuration looks like:

```
<action name="my" class="com.fdar.infoq.MyAction" >
  <result type="dispatcher">view.jsp</result>
</action>
```

Tipos de resultados de `struts-default`:

**chain** Chains from the execution of one action to another configured action.
Copies all property values with getter methods from
the initial action to corresponding setter
methods on the target action.

Por ejemplo:

```

// solicitud.jsp tiene un <s:form action="solicitud" />

<action name="solicitud" class="com.fdar.infoq.MyAction" >
  <result name="success" type="chain">resultado.action</result>
</action>

// si la instancia `solicitudAction` de MyAction al ejecutar `execute()` devuelve "success",
// se devolverá el control a `resultadoAction` transifieriendo todas las propertiees de `get*()` a `set*()`

// resultado.jsp muestra los mismos campos, pero sólo a nivel informativo

<action name="resultado" class="com.fdar.infoq.MyAction" >
  <result name="salir" type="redirect">http://www.google.es</result>
</action>
```

Más info: http://struts.apache.org/2.0.14/docs/chain-result.html


**dispatcher** Renders Java server pages. This is the
default result type, and is used if no result
type is configured in the action
configuration.

**freemarker** Renders Freemarker templates.

**httpheader** Returns HTTP headers with user defined values.

**redirect** Redirects to any arbitrary URL.

**redirect-action** Redirect to a configured action. Can be
used to provide redirect after post
functionality.

/*** Este action se parece a chain, en que no realiza la transferencia de properties de un action a otro.
  ***

**stream** Streams data back to the browser. Used to
stream PDF, Microsoft Word, images, or
other data.

**velocity** Renders Velocity templates.

**xslt** Uses an XSLT to format the properties
from the action that has been previously
executed.

### 5.1 Tipos de resultados: Configuración ###

Result types are configured within the <package … /> tag. The
configuration is similar to interceptor configuration. A “name”
attribute provides a unique identifier for the result type, and the
“class” attribute provides the implementation class. There is a
third attribute “default” – this allows the default result type to be
modified. If a web application was to be based on Velocity
rather than JSP, modifying the default would save time when
entering configuration information.

```
<result-types>
  <result-type name="dispatcher" default="true" class="….dispatcher.ServletDispatcherResult"/>
  <result-type name="redirect" class="….dispatcher.ServletRedirectResult"/>
  …
</result-types>
```

### 5.2 Tipos de resultados: Implementación ###

Similar to interceptors, it is possible to create your own result
types and configure them in your web application. Many
common result types already exist so, before creating your own,
you should check to see if the type you want already exists.
To create a new result type, implement the Result interface.

```
public interface Result extends Serializable {
  public void execute(ActionInvocation invocation) throws Exception;
}
```

The ActionInvocation object provides access to the runtime
environment, allowing the new result type to access information
from the action that was just executed, as well as the context in
which the action was executed. The context includes the
HttpServletRequest object, which provides access to the
output stream for the current request.