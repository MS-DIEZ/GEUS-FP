<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <style><%@include file="/WEB-INF/css/perfilPersonal.css"%></style>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Perfil de usuario</title>
<link rel="shortcut icon" href="https://image.ibb.co/nhNhgT/title.png"></head>
</head>
<body>
<header>
		<div id="logo"></div>
		<a href="http://geus-fp.j.layershift.co.uk/principal.html">
			<div id="titulo"> GEUS-FP </div>
		</a>
</header>
	<div id="info">
		<p>Perfil de Usuario</p>
	</div>
	
	<div id="capaDerecha"></div>
	
	<div id="perfilPersonal">
		<div id="contenido">
			<table>
			<tr class="colorElemento">
				<th colspan="2">Identificador corporativo</th>
			</tr>
			<tr>
				<th>ID USUARIO</th>
				<th>${usuarioDto.getId()}</th>
			</tr>
			
			<tr class="colorElemento">
				<th colspan="2">INFORMACION BASICA</th>
			</tr>
			
			<tr>
				<th>NOMBRE</th>
				<th>${usuarioDto.getNombre()}</th>
			</tr>
			
			<tr>
				<th>APELLIDO</th>
				<th>${usuarioDto.getApellido()}</th>
			</tr>
			
			<tr class="colorElemento">
				<th colspan="2">INFORMACION CORPORTATIVA</th>
			</tr>
			
			<tr>
				<th>SUELDO</th>
				<th>${usuarioDto.getSalario()}</th>
			</tr>
			<tr>
				<th>EMAIL</th>
				<th>${usuarioDto.getEmail()}</th>
			</tr>
			
			<tr>
				<th>FECHA INCORPORACION</th>
				<th>${usuarioDto.getFechaIncorporacion()}</th>
			</tr>
	
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