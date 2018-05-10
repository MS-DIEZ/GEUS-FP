<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <style><%@include file="/WEB-INF/css/analista.css"%></style>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>GEUS-FP</title>
</head>
<body>
	<header>
		<div id="logo"></div>
		<div id="titulo">GEUS-FP</div>
	</header>
	<h3>${message}</h3> 
	<p>Vista para analistas</p>
	
	<div id="botonera-analista">
			<form action="perfilUsuario.html">
				<button id="perfil" type="submit">Perfil Personal </button>
			</form>
			
			<form action="crearTareaAnalista.html">
				<button id="crear-tarea" type="submit">Creacion de tarea</button>
			</form>
			
			<form action="listadoTareasAnalista.html">
				<button id="listar-tareas" type="submit">Listado de tareas</button>
			</form>
	</div>
</body>
</html>