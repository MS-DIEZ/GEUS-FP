package com.gestionusuariosfp.controller;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Response;

import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.gestionusuariosfp.constantes.InformacionConstantes;
import com.gestionusuariosfp.funciones.EmailSender;
import com.gestionusuariosfp.funciones.FuncionesController;
import com.gestionusuariosfp.funciones.QuartzJob;
import com.gestionusuariosfp.model.ResponseDto;
import com.gestionusuariosfp.model.TareaDto;
import com.gestionusuariosfp.model.TrabajadoresDto;
import com.gestionusuariosfp.model.UsuarioDto;
import com.gestionusuariosfp.model.WorkflowDto;
import com.gestionusuariosfp.service.SolicitudService;
import com.gestionusuariosfp.sesion.SesionActiva;

@Controller
public class SolicitudController extends HttpServlet{

	private static final long serialVersionUID = -3552457740097962466L;
	@Autowired  
	private SolicitudService solicitudService;
	private SesionActiva sesionActiva = new SesionActiva();
	private ResponseDto responseDto = new ResponseDto();
	private FuncionesController funcionesController = new FuncionesController();
	private InformacionConstantes informacionConstantes = new InformacionConstantes();
	private QuartzJob quartzJob = new QuartzJob();
	
	private String password;
	
	@RequestMapping(value="/login")
	public ModelAndView String(Model model){
		List<UsuarioDto> usuarioDto = solicitudService.listarUsuarios();

		return new ModelAndView("login","message",""+usuarioDto.get(0).getNombre());
	}
	
	@RequestMapping(value="/principal", method=RequestMethod.POST)
	public ModelAndView entrar(@ModelAttribute("usuario") UsuarioDto usuario, Model model){
		List<UsuarioDto> listaUsuariosDto = new ArrayList<UsuarioDto>();
		listaUsuariosDto = solicitudService.listarUsuarioLogin();
		
		//TODO Proceso quartz llamado en el arranque, reubicar
		try {
			funcionesController.setService(solicitudService);
			quartzJob.executeQuartz();
		} catch (SchedulerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
				
		for(int i=0; i<listaUsuariosDto.size(); i++){
			
			try {
				password = funcionesController.desencriptar(listaUsuariosDto.get(i).getPassword());
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if((listaUsuariosDto.get(i).getEmail()).equals(usuario.getEmail()) &&
			   (password.equals(usuario.getPassword())))
			{

				sesionActiva.setIdUsuario(listaUsuariosDto.get(i).getId());
				
				if(listaUsuariosDto.get(i).getPuesto() == informacionConstantes.ID_CARGO_TECNICO){
					sesionActiva.setCategoriaUsuario(1);
					return new ModelAndView("/tecnico/tecnicoPrincipal","message","Bienvenido "+listaUsuariosDto.get(i).getNombre());
				}else if(listaUsuariosDto.get(i).getPuesto() == informacionConstantes.ID_CARGO_ANALISTA){
					sesionActiva.setCategoriaUsuario(2);
					return new ModelAndView("/analista/analistaPrincipal","message","Bienvenido "+listaUsuariosDto.get(i).getNombre());
				}else{
					sesionActiva.setCategoriaUsuario(3);
					return new ModelAndView("/directivo/directivoPrincipal","message","Bienvenido "+listaUsuariosDto.get(i).getNombre());
				}
			}
		}

		return new ModelAndView("error","message","Error en los credenciales");
	}
	
	@RequestMapping(value="/principal")
	public ModelAndView principal(Model model){
		
		if(sesionActiva.getCategoriaUsuario()==1){
			return new ModelAndView("/tecnico/tecnicoPrincipal");
		}
		
		if(sesionActiva.getCategoriaUsuario()==2){
			return new ModelAndView("/analista/analistaPrincipal");
		}
		
		if(sesionActiva.getCategoriaUsuario()==3){
			return new ModelAndView("/directivo/directivoPrincipal");
		}
		
		return new ModelAndView("denied");
	}
	
	
	/*Bloque de codigo dedicado a la creacion de tareas para el analista*/
	
	@RequestMapping(value="/crearTareaAnalista")
	public ModelAndView crearTareaAnalista(Model model){

		if(!funcionesController.comprobarAnalista(sesionActiva.getIdUsuario(), sesionActiva.getCategoriaUsuario())){
			return new ModelAndView("denied");
		}
		else{
			List<UsuarioDto> listaUsuariosDto = new ArrayList<UsuarioDto>();
			listaUsuariosDto = solicitudService.listarUsuarioTecnicos();

			return new ModelAndView("/analista/analistaCrearTarea","listaUsuariosDto",listaUsuariosDto);
		}
		
	}
	
	/*Convertir consulta en transaccional*/
	@RequestMapping(value="/insertarTarea", method=RequestMethod.POST)
	public ModelAndView insertarTareaAnalista(HttpServletRequest request, HttpServletResponse response,@ModelAttribute("tarea") TareaDto tarea, Model model){
		
		if(funcionesController.comprobarAnalista(sesionActiva.getIdUsuario(), sesionActiva.getCategoriaUsuario())){
			WorkflowDto workflowDto = new WorkflowDto();
			TareaDto tareaDto = new TareaDto();
			List<TrabajadoresDto> listaTrabajadoresDto = new ArrayList<TrabajadoresDto>();
			int idUltimaTarea;
			
			tareaDto.setNombreTarea(tarea.getNombreTarea());
			tareaDto.setDescripcionTarea(tarea.getDescripcionTarea());
			tareaDto.setEmisorTarea(sesionActiva.getIdUsuario());
			
			solicitudService.insertarTarea(tareaDto);
			idUltimaTarea=solicitudService.getUltimaTarea();
			
			workflowDto.setIdEstado(1);
			workflowDto.setIdTarea(idUltimaTarea);
			
			if(request.getParameter("id")!=null)
			{
			    String[] idTrabajador=request.getParameterValues("id");
		
			    for(String id:idTrabajador){
			     	TrabajadoresDto trabajador = new TrabajadoresDto();
			     	trabajador.setIdTarea(idUltimaTarea);
			     	trabajador.setIdTrabajador(Integer.parseInt(id));
			     	listaTrabajadoresDto.add(trabajador);
			    }
			}
	
			for(int i=0; i<listaTrabajadoresDto.size(); i++){
				solicitudService.insertarTrabajadoresAsignados(listaTrabajadoresDto.get(i));
			}
			
			solicitudService.insertarTareaWorkflow(workflowDto);
	
			return new ModelAndView("/analista/analistaPrincipal","message","Se ha insertado correctamente la tarea");
		}
		else{
			return new ModelAndView("denied");

		}
	}
	
	
	@RequestMapping(value="/listadoTareasAnalista")
	public ModelAndView listadoTareasAnalista(HttpServletRequest request, HttpServletResponse response){
			if(funcionesController.comprobarAnalista(sesionActiva.getIdUsuario(), sesionActiva.getCategoriaUsuario())){
			List<TareaDto> listaTareasDto = new ArrayList<TareaDto>();
			listaTareasDto = solicitudService.getTareasEmitidas(sesionActiva.getIdUsuario());
			
			return new ModelAndView("/analista/analistaListarTareas","listaTareasDto",listaTareasDto);
		}else{
			return new ModelAndView("denied");
		}
	}
	
	
	@RequestMapping(value="/perfilUsuario")
	public ModelAndView perfilUsuario(Model model){
		if(funcionesController.comprobarGenerico(sesionActiva.getIdUsuario(), sesionActiva.getCategoriaUsuario())){
			UsuarioDto usuarioDto = new UsuarioDto();
			usuarioDto = solicitudService.getUsuariosPerfil(sesionActiva.getIdUsuario());
			
			return new ModelAndView("perfilUsuario","usuarioDto", usuarioDto);
		}else{
			return new ModelAndView("denied");
		}
	}
	
	/*---------------------------------------------------------------*/
	
	/*Bloque de codigo dedicado a la creacion de tareas para el directivo*/
	@RequestMapping(value="/listadoTareasAprobar")
	public ModelAndView listadoTareasAprobar(Model model){
		if(funcionesController.comprobarDirectivo(sesionActiva.getIdUsuario(), sesionActiva.getCategoriaUsuario())){
			List<TareaDto> listaTareasPendientes = new ArrayList<TareaDto>();
			listaTareasPendientes = solicitudService.getTareasPendientes();
	
			return new ModelAndView("/directivo/directivoAprobarTareas","listaTareasDto",listaTareasPendientes);
		}else{
			return new ModelAndView("denied");
		}
	}
	
	
	@RequestMapping(value="/actualizarTareaDirectivo", method=RequestMethod.POST)
	public ModelAndView actualizarTareaDirectivo(HttpServletRequest request, HttpServletResponse response,@ModelAttribute("tarea") TareaDto tarea, Model model){
		if(funcionesController.comprobarDirectivo(sesionActiva.getIdUsuario(), sesionActiva.getCategoriaUsuario())){
			List<Integer> listaAprobadas  = new ArrayList<Integer>();
			List<Integer> listaRechazadas = new ArrayList<Integer>();
			List<TrabajadoresDto> trabajadoresAsignados;
			TareaDto tareaDatos;
			UsuarioDto usuarioCorreo;
			UsuarioDto usuarioEmisor;
			
			if(request.getParameter("aprobar") != null){
				
				String[] idTareaAprobar = request.getParameterValues("aprobar");
				
				for(String id:idTareaAprobar){
					listaAprobadas.add(Integer.parseInt(id));
					
					trabajadoresAsignados = new ArrayList<TrabajadoresDto>();
					trabajadoresAsignados = solicitudService.getUsuarioTarea(Integer.parseInt(id));
					
					for(int i=0; i<trabajadoresAsignados.size(); i++){
						usuarioCorreo = new UsuarioDto();
						usuarioEmisor = new UsuarioDto();
						tareaDatos = new TareaDto();
						
						tareaDatos = solicitudService.getTareasDatosMail(Integer.parseInt(id));
						usuarioEmisor = solicitudService.getUsuariosPerfil(tareaDatos.getEmisorTarea());
						usuarioCorreo = solicitudService.getUsuarioCorreo(trabajadoresAsignados.get(i).getIdTrabajador());
						//Enviar el correo a la clasa EmailSender
						funcionesController.enviarEmail(usuarioCorreo.getEmail(), usuarioEmisor.getNombre(), tareaDatos.getNombreTarea(), tareaDatos.getDescripcionTarea());
					}
	
				}
			}
			
			if(request.getParameter("rechazar") != null){
				String[] idTareaRechazar = request.getParameterValues("rechazar");
				
				for(String id:idTareaRechazar){
					listaRechazadas.add(Integer.parseInt(id));
				}
			}
			
			if(!listaAprobadas.isEmpty()){
				for(int i=0; i<listaAprobadas.size(); i++){
					solicitudService.actualizarTareaWorkflowAprobada(listaAprobadas.get(i));
					solicitudService.insertarAprobadorTarea(funcionesController.setTareaDirectivo(listaAprobadas.get(i), sesionActiva.getIdUsuario()));
				}
			}
			
			if(!listaRechazadas.isEmpty()){
				for(int i=0; i<listaRechazadas.size(); i++){
					solicitudService.actualizarTareaWorkflowRechazada(listaRechazadas.get(i));
					solicitudService.insertarAprobadorTarea(funcionesController.setTareaDirectivo(listaRechazadas.get(i), sesionActiva.getIdUsuario()));
				}
			}
		
			return new ModelAndView("/directivo/directivoPrincipal","message","FASE DE PRUEBAS");
		}else{
			return new ModelAndView("denied");
		}
	}
	
	
	@RequestMapping(value="/listadoTareasTramitadas")
	public ModelAndView listadoTareasTramitadas(Model model){
		if(funcionesController.comprobarDirectivo(sesionActiva.getIdUsuario(), sesionActiva.getCategoriaUsuario())){
			List<TareaDto> listaTareasTramitadas = new ArrayList<TareaDto>();
			List<WorkflowDto> listaEstadoTareas = new ArrayList<WorkflowDto>();
			List<TareaDto> datosTareasTramitadas = new ArrayList<TareaDto>();
			List<String> datosConcatenados = new ArrayList<String>();
			
			listaTareasTramitadas = solicitudService.getTareasTramitadasDirectivo(sesionActiva.getIdUsuario());
			
			for(int i=0; i<listaTareasTramitadas.size(); i++){
				WorkflowDto estado = new WorkflowDto();
				TareaDto tarea = new TareaDto();
				estado=solicitudService.getTareasTramitadasDirectivoEstado(listaTareasTramitadas.get(i).getIdTarea());
				tarea=solicitudService.getTareasDatosMail(listaTareasTramitadas.get(i).getIdTarea());
				listaEstadoTareas.add(estado);
				datosTareasTramitadas.add(tarea);
				
				datosConcatenados.add("La tarea "+tarea.getNombreTarea()+" con ID: "+listaTareasTramitadas.get(i).getIdTarea()+" "
									+ "se encuentra en estado "+funcionesController.obtenerEstado(estado.getIdEstado()));
				
			}
	
			return new ModelAndView("/directivo/directivoTareasTramitadas","datosConcatenados",datosConcatenados);
		}else{
			return new ModelAndView("denied");
		}
	}
	
	/*------------------------------------------------*/
	
	/*Bloque de codigo dedicado a las tareas asignadas a técnicos*/
	@RequestMapping(value="/listadoTareasAsignadas")
	public ModelAndView listadoTareasAsignadas(Model model){
		
		List<TareaDto> datosTareasAsignadas = new ArrayList<TareaDto>();
		datosTareasAsignadas=solicitudService.getTareasAprobadasTecnico(sesionActiva.getIdUsuario());
		return new ModelAndView("/tecnico/tecnicoTareasAsignadas", "datosTareasAsignadas",datosTareasAsignadas);
	}
	/*------------------------------------------------*/
}
