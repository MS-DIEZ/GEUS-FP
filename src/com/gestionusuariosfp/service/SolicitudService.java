package com.gestionusuariosfp.service;

import java.util.List;

import com.gestionusuariosfp.model.TareaDto;
import com.gestionusuariosfp.model.TrabajadoresDto;
import com.gestionusuariosfp.model.UsuarioDto;
import com.gestionusuariosfp.model.WorkflowDto;

public interface SolicitudService {
	
	void insertarUsuario(UsuarioDto usuarioDto);
	void insertarTarea(TareaDto tareaDto);
	void insertarTrabajadoresAsignados(TrabajadoresDto trabajadoresDto);
	void insertarTareaWorkflow(WorkflowDto workflowDto);
	List<UsuarioDto> listarUsuarios();
	List<UsuarioDto> listarUsuarioLogin();
	List<UsuarioDto> listarUsuarioTecnicos();
	List<TareaDto> getTareasEmitidas(int idEmisor);
	UsuarioDto getUsuariosPerfil(int idUsuario);
	List<TareaDto> getTareasPendientes();
	int getUltimaTarea();
	void actualizarTareaWorkflowAprobada(int idTarea);
	void actualizarTareaWorkflowRechazada(int idTarea);
	void insertarAprobadorTarea(TrabajadoresDto trabajadoresDto);
	
	List<TrabajadoresDto> getUsuarioTarea(int idTarea);
	UsuarioDto getUsuarioCorreo(int idUsuario);
	TareaDto getTareasDatosMail(int idTarea);
	
	List<TareaDto> getTareasTramitadasDirectivo(int idDirectivo);
	WorkflowDto getTareasTramitadasDirectivoEstado(int idTarea);
	
}
