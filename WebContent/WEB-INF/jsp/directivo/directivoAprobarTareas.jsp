<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" 
       uri="http://java.sun.com/jsp/jstl/core" %>
       
<%@ page import="com.gestionusuariosfp.model.*" %>
<style><%@include file="/WEB-INF/css/aprobarTarea.css"%></style>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Aprobación de tareas</title>
<link rel="shortcut icon" href="//localhost/Prueba/Imagenes/title.png"></head>
<body>

<header>
		<div id="logo"></div>
		<a href="http://localhost:8080/GestionUsuariosFP/principal.html">
			<div id="titulo"> GEUS-FP </div>
		</a>
</header>

<div id="info">
	<p>Listado de tareas</p>
</div>

<div id="capaDerecha"></div>
<div id="aprobacionTarea">
	<div id="contenido">
		
		<form action="actualizarTareaDirectivo.html" method="POST">
		
		<table>
			<tr>
				<th>Aprobar</th>
				<th>Rechazar</th>
				<th>ID Tarea</th>
				<th>Nombre</th>
				<th>Descripcion</th>
				<th>ID Emisor</th>
			</tr>
		<c:forEach items="${listaTareasDto}" var="listaTareasDto">
			<tr>
		   		<th><input type="checkbox" name="aprobar" value="${listaTareasDto.getIdTarea()}"></th>
		   		<th><input type="checkbox" name="rechazar" value="${listaTareasDto.getIdTarea()}"></th>
		   		<th>${listaTareasDto.getIdTarea()}</th> 
		   		<th>${listaTareasDto.getNombreTarea()}</th>
		   		<th>${listaTareasDto.getDescripcionTarea()}</th> 
		   		<th>${listaTareasDto.getEmisorTarea()}</th>
		   	</tr>
		  		
			 </c:forEach>
		</table>	 
			 <button type="submit" value="Tramitar">Tramitar</button>
		</form>
		
	</div>
</div>
<div id="capaIzquierda"></div>
<footer>
		<div id="infoFooter">
			<p>Todos los derechos reservados, Daniel Díez Arias</p>
		</div>
</footer>
</body>
</html>