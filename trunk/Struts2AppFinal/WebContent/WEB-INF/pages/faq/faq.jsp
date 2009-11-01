<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>App Final: FAQ</title>
</head>
<body>
	<h1>
		<s:text name="faq.title" />
	</h1>
		
	<s:form action="faqAction" method="registrarEncuesta">
		<h3><s:property value="question" /></h3>
		
		<s:radio name="answer" label="Respuestas" list="answersValues" onchange="continuar();" />
		
		<s:submit value="Registrar" align="left"/>
	</s:form>
	
	<script type="text/javascript">	
		 function continuar() {
			var continuar = confirm('¿Está seguro de su elección?');
			if (!continuar) {
				var answer = document.forms[0].answer;
				deselectRadioGroup(answer);				
			}
		 }

		 function deselectRadioGroup(radioGroup) {
			// Más info. en: http://krook.org/jsdom/NodeList.html
			if (radioGroup != null && radioGroup instanceof NodeList) {
				for (i=0; radioGroup != null && i < radioGroup.length; ++i) {
					var item = radioGroup.item(i);
					deselectRadio(item);				
				}
			}
		 }

		 function deselectRadio(radioItem) {
			// Más info. en: http://krook.org/jsdom/HTMLInputElement.html
			if (radioItem != null && radioItem instanceof HTMLInputElement) {
				if (radioItem.checked) {
					radioItem.checked = false;
				}
			}
		 }
	</script>
	
</body>
</html>