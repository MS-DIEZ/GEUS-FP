<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" 
       uri="http://java.sun.com/jsp/jstl/core" %>
       <style><%@include file="/WEB-INF/css/creacionTarea.css"%></style>
       
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Creación de tarea</title>
<link rel="shortcut icon" href="https://image.ibb.co/nhNhgT/title.png"></head>
<body>

<header>
		<div id="logo"></div>
		<a href="http://geus-fp.j.layershift.co.uk/principal.html">
			<div id="titulo"> GEUS-FP </div>
		</a>
</header>
<div id="info">
	<p>Creacion de tarea</p>
</div>

<div id="capaDerecha"></div>
<div id="creacionTarea">
<div id="contenido">
<form action="insertarTarea.html" method="POST">
	  <div id="nombre" class="datos">
	  	<p>Nombre de la tarea a realizar</p>
	  </div>
      <p> Nombre tarea:</br> 
      	<input type="text" id="textfieldTarea"name="nombreTarea"></p>
      	</br>
      <div id="descripcion" class="datos">
	  	<p>Descripción de la tarea a realizar</p>
	  	
	  </div>
       <span>Descripcion tarea:</span>
	  	</br> 
	  	<textarea id="descripcionArea" type="text" name="descripcionTarea"></textarea>
       </br>
       </br>
       <div id="participantes" class="datos">
	  	<p>Seleccione los participantes en la tarea</p>
	  </div>
	  
	  <table id="participantesTarea">
	  	<tr>
	  		<th>Seleccion</th>
	  		<th>Identificador</th>
	  		<th>Nombre</th>
	  		<th>Apellido</th>
	  	</tr>
      <c:forEach items="${listaUsuariosDto}" var="listaUsuariosDto">
      	<tr>
   		<th><input type="checkbox" name="id" value="${listaUsuariosDto.getId()}"></th>
   		<th>${listaUsuariosDto.getId()}</th>  
   		<th>${listaUsuariosDto.getNombre()}</th> 
   		<th>${listaUsuariosDto.getApellido()}</th>
  		<br>
  		</tr>
	 </c:forEach>
	 </table>
      <p><button type="submit" value="Crear">Crear</button></p>
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