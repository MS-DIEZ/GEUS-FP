package com.gestionusuariosfp.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Response;

import org.springframework.beans.factory.annotation.Autowired;
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
	private InformacionConstantes informacionConstantes = new InformacionConstantes();
	
	@RequestMapping(value="/login")
	public ModelAndView String(Model model){
		List<UsuarioDto> usuarioDto = solicitudService.listarUsuarios();

		return new ModelAndView("login","message",""+usuarioDto.get(0).getNombre());
	}
	
	@RequestMapping(value="/principal", method=RequestMethod.POST)
	public ModelAndView entrar(@ModelAttribute("usuario") UsuarioDto usuario, Model model){
		List<UsuarioDto> listaUsuariosDto = new ArrayList<UsuarioDto>();
		listaUsuariosDto = solicitudService.listarUsuarioLogin();
		
		for(int i=0; i<listaUsuariosDto.size(); i++){
			
			if((listaUsuariosDto.get(i).getEmail()).equals(usuario.getEmail()) &&
			   (listaUsuariosDto.get(i).getPassword()).equals(usuario.getPassword()))
			{
				sesionActiva.setIdUsuario(listaUsuariosDto.get(i).getId());
				
				if(listaUsuariosDto.get(i).getPuesto() == informacionConstantes.ID_CARGO_TECNICO){
					return new ModelAndView("tecnicoPrincipal","message","Bienvenido "+listaUsuariosDto.get(i).getNombre());
				}else if(listaUsuariosDto.get(i).getPuesto() == informacionConstantes.ID_CARGO_ANALISTA){
					
					return new ModelAndView("/analista/analistaPrincipal","message","Bienvenido "+listaUsuariosDto.get(i).getNombre());
				}else{
					
					return new ModelAndView("directivoPrincipal","message","Bienvenido "+listaUsuariosDto.get(i).getNombre());
				}
			}
		}

		return new ModelAndView("error","message","Error en los credenciales");
	}
	
	/*Bloque de codigo dedicado a la creacion de tareas para el analista*/
	@RequestMapping(value="/crearTareaAnalista")
	public ModelAndView crearTareaAnalista(Model model){
		List<UsuarioDto> listaUsuariosDto = new ArrayList<UsuarioDto>();
		listaUsuariosDto = solicitudService.listarUsuarioTecnicos();

		return new ModelAndView("/analista/analistaCrearTarea","listaUsuariosDto",listaUsuariosDto);
	}
	
	/*Convertir consulta en transaccional*/
	@RequestMapping(value="/insertarTarea", method=RequestMethod.POST)
	public ModelAndView insertarTareaAnalista(HttpServletRequest request, HttpServletResponse response,@ModelAttribute("tarea") TareaDto tarea, Model model){
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
		    }
		}

		for(int i=0; i<listaTrabajadoresDto.size(); i++){
			solicitudService.insertarTrabajadoresAsignados(listaTrabajadoresDto.get(i));
		}
		
		solicitudService.insertarTareaWorkflow(workflowDto);

		return new ModelAndView("/analista/analistaPrincipal","message","Se ha insertado correctamente la tarea");
	}
	
	
	@RequestMapping(value="/listadoTareasAnalista")
	public ModelAndView listadoTareasAnalista(HttpServletRequest request, HttpServletResponse response){
		List<TareaDto> listaTareasDto = new ArrayList<TareaDto>();
		listaTareasDto = solicitudService.getTareasEmitidas(sesionActiva.getIdUsuario());
		
		return new ModelAndView("/analista/analistaListarTareas","listaTareasDto",listaTareasDto);
	}
	
	
	
	@RequestMapping(value="/perfilAnalista")
	public ModelAndView perfilAnalista(Model model){

		UsuarioDto usuarioDto = new UsuarioDto();
		usuarioDto = solicitudService.getUsuariosPerfil(sesionActiva.getIdUsuario());
		
		return new ModelAndView("/analista/analistaPerfil","usuarioDto", usuarioDto);
	}
	
	/*---------------------------------------------------------------*/
	
	/*Controller para el directivo*/
	@RequestMapping(value="/listadoTareasAprobar")
	public ModelAndView listadoTareasAprobar(Model model){
		List<TareaDto> listaTareasPendientes = new ArrayList<TareaDto>();
		listaTareasPendientes = solicitudService.getTareasPendientes();

		return new ModelAndView("analistaListarTareas","listaTareasDto",listaTareasPendientes);
	}
	/*------------------------------------------------*/
}
