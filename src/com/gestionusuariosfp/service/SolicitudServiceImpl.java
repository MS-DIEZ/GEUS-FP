package com.gestionusuariosfp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestionusuariosfp.model.TareaDto;
import com.gestionusuariosfp.model.TrabajadoresDto;
import com.gestionusuariosfp.model.UsuarioDto;
import com.gestionusuariosfp.model.WorkflowDto;
import com.gestionusuariosfp.mappers.SolicitudMapper;;

@Service("solicitudService")
public class SolicitudServiceImpl implements SolicitudService{
	
	@Autowired
	private SolicitudMapper solicitudMapper;
	
	@Override
	public void insertarUsuario(UsuarioDto usuarioDto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<UsuarioDto> listarUsuarios() {
		// TODO Auto-generated method stub
		
		List<UsuarioDto> usuarios = new ArrayList<UsuarioDto>();
		usuarios = solicitudMapper.getUsuarios();

		return usuarios;
	}

	@Override
	public List<UsuarioDto> listarUsuarioLogin() {
		// TODO Auto-generated method stub
		
		List<UsuarioDto> usuariosLogin = new ArrayList<UsuarioDto>();
		usuariosLogin = solicitudMapper.getUsuariosLogin();
		
		return usuariosLogin;
	}

	@Override
	public void insertarTarea(TareaDto tareaDto) {
		// TODO Auto-generated method stub
		solicitudMapper.insertarTarea(tareaDto);
	}

	@Override
	public List<UsuarioDto> listarUsuarioTecnicos() {
		// TODO Auto-generated method stub
		List<UsuarioDto> usuariosTecnicos = new ArrayList<UsuarioDto>();
		usuariosTecnicos = solicitudMapper.getUsuariosTecnicos();

		return usuariosTecnicos;
	}

	@Override
	public void insertarTrabajadoresAsignados(TrabajadoresDto trabajadoresDto) {
		// TODO Auto-generated method stub
		
		solicitudMapper.insertarTrabajadoresAsignados(trabajadoresDto);
		
	}

	@Override
	public int getUltimaTarea() {
		// TODO Auto-generated method stub
		int idUltimaTarea;
		idUltimaTarea=solicitudMapper.getUltimaTarea();
		
		return idUltimaTarea;
	}

	@Override
	public void insertarTareaWorkflow(WorkflowDto workflowDto) {
		// TODO Auto-generated method stub
		
		solicitudMapper.insertarTareaWorkflow(workflowDto);
	}

	@Override
	public List<TareaDto> getTareasEmitidas(int idEmisor) {
		// TODO Auto-generated method stub
		List<TareaDto> listaTareas = new ArrayList<TareaDto>();
		listaTareas=solicitudMapper.getTareasEmitidas(idEmisor);
		return listaTareas;
	}

	@Override
	public UsuarioDto getUsuariosPerfil(int idUsuario) {
		// TODO Auto-generated method stub
		UsuarioDto usuarioPerfil = new 	UsuarioDto();
		usuarioPerfil = solicitudMapper.getUsuarioPerfil(idUsuario);
		return usuarioPerfil;
	}

	@Override
	public List<TareaDto> getTareasPendientes() {
		// TODO Auto-generated method stub
		
		List<TareaDto> listaTareasPendientes = new ArrayList<TareaDto>();
		listaTareasPendientes = solicitudMapper.getTareasPendientes();
		return listaTareasPendientes;
	}

	@Override
	public void actualizarTareaWorkflowAprobada(int idTarea) {
		// TODO Auto-generated method stub
		
		solicitudMapper.actualizarTareaWorkflowAprobada(idTarea);
		
	}

	@Override
	public void actualizarTareaWorkflowRechazada(int idTarea) {
		// TODO Auto-generated method stub
		solicitudMapper.actualizarTareaWorkflowRechazada(idTarea);
		
		
	}

	@Override
	public void insertarAprobadorTarea(TrabajadoresDto trabajadoresDto) {
		// TODO Auto-generated method stub
		
		solicitudMapper.insertarAprobadorTarea(trabajadoresDto);
		
	}

	@Override
	public List<TrabajadoresDto> getUsuarioTarea(int idTarea) {
		// TODO Auto-generated method stub
		
		List<TrabajadoresDto> trabajadores = new ArrayList<TrabajadoresDto>();
		trabajadores = solicitudMapper.getUsuarioTarea(idTarea);
		
		return trabajadores;
	}

	@Override
	public UsuarioDto getUsuarioCorreo(int idUsuario) {
		// TODO Auto-generated method stub
		
		UsuarioDto usuario = new UsuarioDto();
		usuario = solicitudMapper.getUsuarioCorreo(idUsuario);
		
		return usuario;
	}

	@Override
	public TareaDto getTareasDatosMail(int idTarea) {
		// TODO Auto-generated method stub
		
		TareaDto tareaMail = new TareaDto();
		tareaMail = solicitudMapper.getTareasDatosMail(idTarea);
		return tareaMail;
	}

	@Override
	public List<TareaDto> getTareasTramitadasDirectivo(int idDirectivo) {
		// TODO Auto-generated method stub
		
		List<TareaDto> tareasTramitadas = new ArrayList<TareaDto>();
		tareasTramitadas = solicitudMapper.getTareasTramitadasDirectivo(idDirectivo);
		return tareasTramitadas;
	}

	@Override
	public WorkflowDto getTareasTramitadasDirectivoEstado(int idTarea) {
		// TODO Auto-generated method stub
		WorkflowDto estadoWorkflow = new WorkflowDto();
		estadoWorkflow = solicitudMapper.getTareasTramitadasDirectivoEstado(idTarea);
		return estadoWorkflow;
	}

	@Override
	public List<TareaDto> getTareasAprobadasTecnico(int idUsuario) {
		// TODO Auto-generated method stub
		
		List<TareaDto> tareasTecnico = new ArrayList<TareaDto>();
		tareasTecnico= solicitudMapper.getTareasAprobadasTecnico(idUsuario);
		return tareasTecnico;
	}

	@Override
	public List<TareaDto> obtenerTodasTareas() {
		// TODO Auto-generated method stub
		
		List<TareaDto> tareas = new ArrayList<TareaDto>();
		tareas= solicitudMapper.obtenerTodasTareas();
		return tareas;
	}

	@Override
	public void eliminarTarea(int idTarea) {
		// TODO Auto-generated method stub
		solicitudMapper.eliminarTarea(idTarea);
	}

	@Override
	public void eliminarTareaTrabajador(int idTarea) {
		// TODO Auto-generated method stub
		solicitudMapper.eliminarTareaTrabajador(idTarea);
	}

	@Override
	public void eliminarTareaWorkflow(int idTarea) {
		// TODO Auto-generated method stub
		solicitudMapper.eliminarTareaWorkflow(idTarea);
	}

	@Override
	public void eliminarTareaDirectivo(int idTarea) {
		// TODO Auto-generated method stub
		solicitudMapper.eliminarTareaDirectivo(idTarea);
	}


	
}
