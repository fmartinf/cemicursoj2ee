<%@ page language="java" isErrorPage="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html>
<head>
    <title><fmt:message key="errorPage.title"/></title>
    <!-- link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["csstheme"]}/theme.css'/>" / -->
    <link href="/icefusion/styles/icefusion/page.css" rel="stylesheet" type="text/css" />
	<link rel="shortcut icon" href="/icefusion/styles/icefusion/images/page.ico"/> 
    <script type="text/javascript" src="/scripts/prototype.js"></script>
	<script type="text/javascript" src="/scripts/scriptaculous.js"></script>
	<script type="text/javascript" src="/scripts/global.js"></script>
</head>

<body id="error">
<table align="center" cellpadding="0" cellspacing="0" class="layout">
<tr><td class="header">
	<img alt="icefusion logo" src="/icefusion/styles/icefusion/images/logo.png" />
</td></tr>
<tr><td class="content">

    <div id="page">
        <div id="content" class="clearfix">
            <div id="main">
                <h1><fmt:message key="errorPage.heading"/></h1>
                <%@ include file="/common/messages.jsp" %>

                <% if (exception != null) { %>
                    <pre><% exception.printStackTrace(new java.io.PrintWriter(out)); %></pre>
                <% } else if (request.getAttribute("javax.servlet.error.exception") != null) { %>
                    <pre><% ((Exception)request.getAttribute("javax.servlet.error.exception"))
                                           .printStackTrace(new java.io.PrintWriter(out)); %></pre>
                <% } %>
            </div>
        </div>
     </div>

</td></tr>
<tr><td class="footer">
AppFuse &copy; 2004-2008 Matt Raible et al. | ICEfusion &copy; 2009 Rainer Eschen.
</td></tr></table>
</body>
</html>
