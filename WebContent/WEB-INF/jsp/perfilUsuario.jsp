<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <style><%@include file="/WEB-INF/css/perfilPersonal.css"%></style>
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
	<div id="perfil">
		<p>Perfil de Usuario</p>
	</div>

	<section id="informacionUno">
		<div id="idUsuario">
			<p>ID USUARIO: </p>
			
		</div>
		<div id="info">
			<p>INFORMACIÓN BASICA</p>
		</div>
		<div id="nombre">
			<p>NOMBRE: </p>

		</div>
		<div id="apellido">
			<p>APELLIDO: </p>

		</div>
		<div id="sueldo">
			<p>SUELDO: </p>

		</div>
		<div id="email">
			<p>EMAIL: </p>

		</div>
		<div id="fechaInc">
			<p>FECHA INCORPORACION: </p>
	
		</div>
	</section>
	<section id="informacionDos">
		<div id="idUsuario">
			<p>${usuarioDto.getId()}</p>
		</div>
		<div id="nombre">
			<p>${usuarioDto.getNombre()}</p>
		</div>
		<div id="apellido">
	
			<p>${usuarioDto.getApellido()}</p>
		</div>
		<div id="sueldo">
		
			<p>${usuarioDto.getSalario()}</p>
		</div>
		<div id="email">
		
			<p>${usuarioDto.getEmail()}</p>
		</div>
		<div id="fechaInc">
		
			<p>${usuarioDto.getFechaIncorporacion()}</p>
		</div>
	</section>

	
	<footer>
	</footer>
	
	
</body>
</html>