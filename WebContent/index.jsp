<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" 
       uri="http://java.sun.com/jsp/jstl/core" %>
  <style><%@include file="/WEB-INF/css/index.css"%></style>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Iniciar sesion</title>
        <link rel="shortcut icon" href="//localhost/Prueba/Imagenes/title.png">
    </head>
    <body>
		<section id="informacion">
			<div id="contenedorInformacion">
				<div id="informacionUno">
					<p>Consulta tus tareas pendientes<p>
				</div>
				<div id="informacionDos">
					<p>Realiza peticiones de trabajo</p>
				</div>
				<div id="informacionTres">
					<p>Accede a tu información</p>
				</div>
			</div>

		</section>
		
		
    	<section id="login">
    	
    	<form id="formulario" action="principal.html" method="POST">
	    	<div id="email">
	            <input type="text" name="email" placeholder="Email del usuario">
	        </div>
	        <div id="password">
	            <input type="password" name="password" placeholder="Contraseña">
	        </div>
	        <div id="entrar">
	            <button type="submit">Iniciar Sesion</button>
	        </div>
        </form>

        <div id="contenido">
        	<p id="titulo"><span>GEUS-FP</span></p>
        	<p>Aplicacion para la gestion</p>
        	<p>y asignacion de tareas a usuarios</p>
        </div>
    	
		</section>
		

        
		<!--  <p id="cosa"><a href="register.jsp">Registrarse</a></p> -->
        <!--  <a href="login.html">Inicio</a> -->
        
        
        
        <footer>
        	<div class="infoF" id="info-1"><p>Todos los derechos reservados</p></div>
        	<div class="infoF" id="info-2"><p>Sobre nosotros</p></div>
        	<div class="infoF" id="info-3"><p>Politica de privacidad</p></div>
        	<div class="infoF" id="info-4"><p>Contacto</p></div>
        </footer>
    </body>
</html>