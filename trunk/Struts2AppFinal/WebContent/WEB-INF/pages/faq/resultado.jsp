<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="/struts-tags"  prefix="s"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>App Final: Resultado</title>
</head>
<body>
	<h1>RESULTADO DE LA ENCUESTA</h1>
	
	<ul>
		<li>
			<label>Pregunta:</label>
			<strong><s:property value="question" /></strong>
		</li>
		<li>			
			<label>Respuesta:</label>
			<strong><s:property value="answer" /></strong>
		</li>
		
		<li>
			<s:include value="../common/linkVolver.jsp" />
		</li>
	</ul>

</body>
</html>