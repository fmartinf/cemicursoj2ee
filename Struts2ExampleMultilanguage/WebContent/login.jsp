<%-- 
    Document   : index
    Created on : Feb 28, 2009, 9:45:01 AM
    Author     : Meyyappan Muthuraman
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
   <%@taglib uri="/struts-tags" prefix="s" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
        <s:head />
    </head>
    <body>
    	<s:text name="texto.multidioma" />
    
        <s:form action="LoginAction" method="post" validate="true">
            <s:textfield name="userName" label="User Name" />
            <s:password name="password" label="Password" />
            <s:submit value="Login" />
        </s:form>
        
<h3>Languages</h3>
<ul>
    <li>
        <s:url id="url" action="LoginAction">
            <s:param name="request_locale">en</s:param>
        </s:url>
        <s:a href="%{url}">English</s:a>
    </li>
    <li>
        <s:url id="url" action="LoginAction">
            <s:param name="request_locale">es</s:param>
        </s:url>
        <s:a href="%{url}">Espanol</s:a>
    </li>
</ul>
        
    </body>
</html>
