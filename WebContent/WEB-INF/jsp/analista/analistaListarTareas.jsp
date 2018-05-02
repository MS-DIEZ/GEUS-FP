<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" 
       uri="http://java.sun.com/jsp/jstl/core" %>
       
<%@ page import="com.gestionusuariosfp.model.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>GEUS-FP</title>
</head>
<body>
<p>Listado de tareas</p>
<p>Nombre | Descripcion</p>

<form action=listadoTareasAnalista.html method="POST">
<c:forEach items="${listaTareasDto}" var="tarea">
   
   <p>${tarea.getIdTarea()} - ${tarea.getNombreTarea()} -  ${tarea.getDescripcionTarea()}</p><BR>
  	<br>
</c:forEach>


</body>
</html>