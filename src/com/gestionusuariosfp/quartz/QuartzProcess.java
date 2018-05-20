package com.gestionusuariosfp.quartz;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;

import com.gestionusuariosfp.funciones.FuncionesController;
import com.gestionusuariosfp.model.TareaDto;
import com.gestionusuariosfp.service.SolicitudService;

public class QuartzProcess implements Job{
	FuncionesController funcionesController = new FuncionesController();
	
	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		// TODO Auto-generated method stub
		
		
		Timestamp timeStamp;
		String[] spliter;
		String fecha;
		String actual;
		
		Calendar cal= Calendar.getInstance();
		int anno= cal.get(Calendar.YEAR);
		actual=""+anno;
		
		List<TareaDto> tareas = new ArrayList<TareaDto>();
		tareas=funcionesController.getService().obtenerTodasTareas();
		
		
		for(int i=0; i<tareas.size(); i++){
			timeStamp = tareas.get(i).getFecha();
			fecha=""+timeStamp;
			
			spliter=fecha.split("-");
			
			if(!spliter[0].equals(actual)){
				funcionesController.getService().eliminarTarea(tareas.get(i).getIdTarea());
				funcionesController.getService().eliminarTareaTrabajador(tareas.get(i).getIdTarea());
				funcionesController.getService().eliminarTareaWorkflow(tareas.get(i).getIdTarea());
				funcionesController.getService().eliminarTareaDirectivo(tareas.get(i).getIdTarea());
			}
			
		}
		
		
		
		
	}

}
