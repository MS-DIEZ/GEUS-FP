<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <style><%@include file="/WEB-INF/css/tecnico.css"%></style>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>GEUS-FP</title>
</head>
<body>
	<header>
		<div id="logo"></div>
		<a href="http://localhost:8080/GestionUsuariosFP/principal.html">
			<div id="titulo"> GEUS-FP </div>
		</a>
		
		<a href="http://localhost:8080/GestionUsuariosFP">
			<button id="cerrarSesion" type="submit">Cerrar sesion</button>
		</a>
	</header>
	
	
	
	<div id="mensaje">
		<h3>${message}</h3> 
		<p>Vista para técnico</p>
	</div>
	
	<div id="botonera-analista">
			<form action="perfilUsuario.html">
				<button id="perfil" type="submit">Perfil Personal</button>
			</form>
			
			<form action="listadoTareasAsignadas.html">
				<button id="listar-tareas" type="submit">Tareas asignadas</button>
			</form>
	</div>
	<footer>
		<div id="infoFooter">
			<p>Todos los derechos reservados, Daniel Díez Arias</p>
		</div>
	</footer>
</body>
</html>