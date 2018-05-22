<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" 
       uri="http://java.sun.com/jsp/jstl/core" %>
       
<%@ page import="com.gestionusuariosfp.model.*" %>
 	<style><%@include file="/WEB-INF/css/listarTareaTecnico.css"%></style>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Listado de tareas</title>
<link rel="shortcut icon" href="//localhost/Prueba/Imagenes/title.png"></head>
<body>
<header>
		<div id="logo"></div>
		<a href="http://localhost:8080/GestionUsuariosFP/principal.html">
			<div id="titulo"> GEUS-FP </div>
		</a>
</header>

<div id="info">
	<p>Listado de tareas asignadas</p>
</div>

<div id="capaDerecha"></div>

<div id="listarTarea">
	<div id="contenido">
		<table id="listadoTareas">
		<caption>Tareas asignadas</caption>

		<tr>
			<th id="tituloTabla">ID TAREA  </th>
			<th id="tituloTabla">NOMBRE  </th>
			<th id="tituloTabla">DESCRIPCION  </th>
		</tr>
		<c:forEach items="${datosTareasAsignadas}" var="tarea">
		   <tr>
		   <th>${tarea.getIdTarea()}</th>
		   <th>${tarea.getNombreTarea()}</th>
		   <th>${tarea.getDescripcionTarea()}</th>

		   </tr>
		   <tr id="separador">
		   	<th colspan="3"></th>
		   </tr>
		</c:forEach>
		</table>
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