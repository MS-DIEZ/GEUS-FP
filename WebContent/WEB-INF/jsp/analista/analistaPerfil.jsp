<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>GEUS-FP</title>
</head>
<body>
	<p>Analista Perfil</p>
	
	<p>ID USUARIO: ${usuarioDto.getId()}</p>
	<p>NOMBRE: ${usuarioDto.getNombre()}</p>
	<p>APELLIDO: ${usuarioDto.getApellido()}</p>
	<p>SUELDO: ${usuarioDto.getSalario()}</p>
	<p>EMAIL: ${usuarioDto.getEmail()}</p>
	<p>FECHA INCORPORACION: ${usuarioDto.getFechaIncorporacion()}</p>
</body>
</html>