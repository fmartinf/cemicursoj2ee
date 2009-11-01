<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
   <%@taglib uri="/struts-tags" prefix="s" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>App Final: Acceso</title>
        <s:head />
    </head>
    <body>
    	<h1>PÁGINA DE ACCESO</h1>
    	
        <s:form action="LoginAction" method="post" validate="true">
            <s:textfield name="email" label="Correo Electrónico" required="true" />
            <s:password name="password" label="Contraseña" required="true" />
            <s:submit value="Acceder" />
        </s:form>
    </body>
</html>
