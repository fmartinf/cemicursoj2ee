<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
   <%@taglib uri="/struts-tags" prefix="s" %>
   
	<s:url id="urlFaq" action="faqAction" method="init">
   		<s:param name="request_locale"><%=request.getParameter("language")%></s:param>
    </s:url>
    
	<s:a href="%{urlFaq}"><%=request.getParameter("text")%></s:a>
	
	
