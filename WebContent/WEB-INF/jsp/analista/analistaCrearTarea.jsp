<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" 
       uri="http://java.sun.com/jsp/jstl/core" %>
       
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>GEUS-FP</title>
</head>
<body>
<p>Creacion de tarea</p>

<form action="insertarTarea.html" method="POST">
      <p> Nombre: <input type="text" name="nombreTarea"></p>
      <p> Descripcion: <input type="text" name="descripcionTarea"></p>
      <c:forEach items="${listaUsuariosDto}" var="listaUsuariosDto">
   		<input type="checkbox" name="id" value="${listaUsuariosDto.getId()}">- 
   		${listaUsuariosDto.getId()} - ${listaUsuariosDto.getNombre()} - ${listaUsuariosDto.getApellido()}
  		<br>
	 </c:forEach>
      <p><input type="submit" value="Crear"></p>
</form>

</body>
</html>