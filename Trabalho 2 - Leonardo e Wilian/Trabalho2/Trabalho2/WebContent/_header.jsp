<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>

<c:choose>
	<c:when test="${sessionScope.username == null}">
		<% response.sendRedirect("login.jsp?action=login"); %>
	</c:when>
	<c:otherwise>
		<c:set var="USERNAME" value="${sessionScope.username}" scope="session" />
	</c:otherwise>
</c:choose>

<html>

<head>
	<link rel="stylesheet" href="/Trabalho2/include/estilo.css" />
	<script type="text/javascript" src="/Trabalho2/include/script.js"></script>
	<title>UNIRIO - Trabalho 2</title>
</head>

<body>
<div id="container">
	<img class="logo" src="/Trabalho2/include/common/unirioLogo.gif" /> <h1 id="title">Trabalho 2 - Disciplina: Programação Modular 2015.1</h1>
<div id="banner">
	<p align="right" id="unirio">Olá, <c:out value="${USERNAME}" /></p>
</div>

<div id="sidebar-a">
	<ul id="menu">
		<li>[<a href="/Trabalho2/index.jsp">Principal</a>]</li>
		<hr />
    		
      			 
				<li>[<a href="/Trabalho2/pages/pesquisador/pesquisador.jsp">Pesquisador</a>]</li> 
        			<li>Eventos</li> 
        			<li>[<a href="/Trabalho2/pages/publicacao/publicacao.jsp">Publicações</a>]</li>  
      			 
    		</li>
    		
		<hr />
		<li>[<a href="/Trabalho2/logout">Logout</a>]</li>
	</ul>
</div>

<div id="content">

<br />