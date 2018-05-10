package com.gestionusuariosfp.funciones;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.gestionusuariosfp.model.TrabajadoresDto;

public class FuncionesController {
	
	public String[] splitEstadoId(String cadena){
		String spliter[];
		spliter = cadena.split(".");
		
		return spliter;
	}
	
	public TrabajadoresDto setTareaDirectivo(int idTarea, int idTrabajador){
		TrabajadoresDto directivo = new TrabajadoresDto();
		directivo.setIdTarea(idTarea);
		directivo.setIdTrabajador(idTrabajador);
		
		return directivo;
	}
	
	public void enviarEmail(String receptor, String emisorTarea, String nombre, String descripcion){
		
		ConfigurableApplicationContext applicationContext = new ClassPathXmlApplicationContext("Config/springConfig.xml");
		EmailSender springMail = (EmailSender) applicationContext.getBean("EmailSender");
		springMail.sendMail(receptor, emisorTarea, nombre, descripcion);
		applicationContext.close();
	}
	
	public String obtenerEstado(int estado){
		
		String estadoFinal="";
		
		switch(estado){
			case 1:
				estadoFinal="PENDIENTE";
				break;
			case 2:
				estadoFinal="APROBADO";
				break;
			case 3:
				estadoFinal="RECHAZADO";
			case 4:
				estadoFinal="COMPLETADO";
		}
		
		return(estadoFinal);
	}
	
	public boolean comprobarTecnico(int idUsuario, int categoriaUsuario){
		
		if(idUsuario == 0 || categoriaUsuario == 0 || categoriaUsuario != 1){
			return false;
		}
		else{
			return true;
		}		
	}
	
	public boolean comprobarAnalista(int idUsuario, int categoriaUsuario){
		if(idUsuario == 0 || categoriaUsuario == 0 || categoriaUsuario != 2){
			return false;
		}
		else{
			return true;
		}	
	}

	public boolean comprobarDirectivo(int idUsuario, int categoriaUsuario){
		if(idUsuario == 0 || categoriaUsuario == 0 || categoriaUsuario != 3){
			return false;
		}
		else{
			return true;
		}	
	}
	
	public boolean comprobarGenerico(int idUsuario, int categoriaUsuario){
		if(idUsuario == 0 || categoriaUsuario == 0 ){
			return false;
		}
		else{
			return true;
		}	
	}
	
}
