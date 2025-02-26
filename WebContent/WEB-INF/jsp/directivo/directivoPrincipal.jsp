<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <style><%@include file="/WEB-INF/css/directivo.css"%></style>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>GEUS-FP Directivo</title>
<link rel="shortcut icon" href="https://image.ibb.co/nhNhgT/title.png"></head>
<body>
	<header>
		<div id="logo"></div>
		<a href="http://geus-fp.j.layershift.co.uk/principal.html">
			<div id="titulo"> GEUS-FP </div>
		</a>
		<a href="http://geus-fp.j.layershift.co.uk">
			<button id="cerrarSesion" type="submit">Cerrar sesion</button>
		</a>
	</header>
	
	<div id="mensaje">
		<h3>${message}</h3> 
		<p>Ventana para directivo</p>
	</div>
	<div id="botonera-directivo">
			<form action="perfilUsuario.html">
				<button id="perfil" type="submit">Perfil Personal </button>
			</form>
			
			<form action="listadoTareasAprobar.html">
				<button id="crear-tarea" type="submit">Aprobar tareas</button>
			</form>
			
			<form action="listadoTareasTramitadas.html">
				<button id="listar-tareas" type="submit">Listado de tareas tramitadas</button>
			</form>
	</div>
	
	<footer>
		<div id="infoFooter">
			<p>Todos los derechos reservados, Daniel D�ez Arias</p>
		</div>
	</footer>
</body>
</html>