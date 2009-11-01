<%@ include file="/common/taglibs.jsp"%>

<page:applyDecorator name="default">

<head>
    <title><fmt:message key="403.title"/></title>
    <meta name="heading" content="<fmt:message key='403.title'/>"/>
    <link href="/icefusion/styles/icefusion/page.css" rel="stylesheet" type="text/css" />
	<link rel="shortcut icon" href="/icefusion/styles/icefusion/images/page.ico"/> 
    <script type="text/javascript" src="/scripts/prototype.js"></script>
	<script type="text/javascript" src="/scripts/scriptaculous.js"></script>
	<script type="text/javascript" src="/scripts/global.js"></script>
</head>

<table align="center" cellpadding="0" cellspacing="0" class="layout">
<tr><td class="header">
	<img alt="icefusion logo" src="/icefusion/styles/icefusion/images/logo.png" />
</td></tr>
<tr><td class="content">

<p>
    <fmt:message key="403.message">
        <fmt:param><c:url value="/"/></fmt:param>
    </fmt:message>
</p>
<p style="text-align: center; margin-top: 20px">
    <a href="http://community.webshots.com/photo/56793801/56801692jkyHaR"
        title="Hawaii, click to Zoom In">
    <img src="<c:url value="/images/403.jpg"/>" alt="Hawaii" /></a>
</p>
</page:applyDecorator>

</td></tr>
<tr><td class="footer">
AppFuse &copy; 2004-2008 Matt Raible et al. | ICEfusion &copy; 2009 Rainer Eschen.
</td></tr></table>