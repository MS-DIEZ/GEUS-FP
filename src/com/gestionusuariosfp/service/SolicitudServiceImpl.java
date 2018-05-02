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


	
}
