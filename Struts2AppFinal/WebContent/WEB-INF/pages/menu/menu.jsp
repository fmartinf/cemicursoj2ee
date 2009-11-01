<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
   <%@taglib uri="/struts-tags" prefix="s" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>App Final: Menu</title>
    </head>
    <body>
        <h1>MENÚ PRINCIPAL</h1>
        
        <ul>
        	<li>
        		<s:a href="http://www.google.es" title="Buscar">Ir a google.com</s:a>
        	</li>
        	<li>
        		<s:form action="faqAction" method="init">
        			<s:submit title="Usando un s:form">Preguntas frecuentes</s:submit>
        		</s:form>
        	</li>
        	<li>
        		<s:url id="urlFaq" action="faqAction" method="init" />
        		<s:a href="%{urlFaq}" title="Usando un enlace">Preguntas frecuentes</s:a>
        	</li>
        	<li>
        		<s:url id="urlFaq" action="faqAction" method="init">
   					<s:param name="request_locale">en</s:param>
    			</s:url>
				<s:a href="%{urlFaq}" title="Usando un enlace (en)">Frequently Asked Questions (EN)</s:a>
        	</li>
        	<li>
        		<s:include value="./linkFaq.jsp">
    				<s:param name="language">fr</s:param>
    				<s:param name="text">Des questions fréquentes (FR)</s:param>
 				</s:include>
        	</li>
        	<li>
        		<s:include value="./linkFaq.jsp">
    				<s:param name="language">ita</s:param>
    				<s:param name="text">Domande frequenti (IT)</s:param>
 				</s:include>
        	</li>
        	<li>
        		<s:url id="urlLogout" action="executelogoutAction" />
        		<s:a href="%{urlLogout}" title="Cerrar sesión">Cerrar sesión</s:a>
        	</li>
        </ul>
    </body>
</html>
