package com.gestionusuariosfp.funciones;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.gestionusuariosfp.model.TrabajadoresDto;
import com.gestionusuariosfp.service.SolicitudService;

public class FuncionesController {
	
	private static SolicitudService service;
	
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
				break;
			case 4:
				estadoFinal="FINALIZADO";
				break;
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
	
	public String desencriptar(String s) throws UnsupportedEncodingException{
        byte[] decode = Base64.getDecoder().decode(s.getBytes());
        return new String(decode, "utf-8");
    }
	
	public void setService(SolicitudService solicitudService){
		service=solicitudService;
	}
	
	public SolicitudService getService(){
		return this.service;
		
	}
	
}
