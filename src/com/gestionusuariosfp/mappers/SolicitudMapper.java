package com.gestionusuariosfp.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;

import com.gestionusuariosfp.model.*;
import com.gestionusuariosfp.constantes.SentenciasConstantes;

public interface SolicitudMapper {
	
	@Select("SELECT GEUS001_USUARIOS_NOMBRE AS nombre, GEUS001_USUARIOS_EMAIL AS email FROM GEUS001_USUARIOS")
	public List<UsuarioDto> getUsuarios();
	
	@Select("SELECT  GEUS001_USUARIOS_ID AS id, "
		  + "GEUS001_USUARIOS_NOMBRE AS nombre, "
		  + "GEUS001_USUARIOS_EMAIL AS email, "
		  + "GEUS001_USUARIOS_PASSWORD AS password, "
		  + "GEUS001_USUARIOS_CARGO AS puesto "
		  + "FROM GEUS001_USUARIOS")
	public List<UsuarioDto> getUsuariosLogin();
	
	@Insert("INSERT INTO GEUS002_TAREAS(GEUS002_TAREAS_NOMBRE, GEUS002_TAREAS_DESCRIPCION, GEUS002_TAREAS_EMISOR)"
		  + "VALUES (#{nombreTarea}, #{descripcionTarea}, #{emisorTarea})")
	@Options(useGeneratedKeys=true, keyProperty="id", flushCache=true, keyColumn="id")
	public void insertarTarea(TareaDto tarea);
	
	@Select("SELECT  GEUS001_USUARIOS_ID AS id, "
			  + "GEUS001_USUARIOS_NOMBRE AS nombre, "
			  + "GEUS001_USUARIOS_APELLIDO AS apellido,"
			  + "GEUS001_USUARIOS_EMAIL AS email, "
			  + "GEUS001_USUARIOS_PASSWORD AS password, "
			  + "GEUS001_USUARIOS_CARGO AS puesto "
			  + "FROM GEUS001_USUARIOS WHERE GEUS001_USUARIOS_CARGO=1")
	public List<UsuarioDto> getUsuariosTecnicos();
	
	@Insert("INSERT INTO GEUS003_TRABAJADORES_ASIGNADOS(GEUS003_TRABAJADORES_ID_TAREA, GEUS003_TRABAJADORES_ID_EMPLEADO) "
			  + "VALUES (#{idTarea}, #{idTrabajador})")
	@Options(useGeneratedKeys=true, keyProperty="id", flushCache=true, keyColumn="id")
	public void insertarTrabajadoresAsignados(TrabajadoresDto trabajadoresDto);
	
	@Select("SELECT GEUS002_TAREAS_ID "
		  + "FROM GEUS002_TAREAS ORDER BY GEUS002_TAREAS_ID DESC LIMIT 1")
	public int getUltimaTarea();
	
	
	@Insert("INSERT INTO GEUS004_WORKFLOW(GEUS004_WORKFLOW_ID_TAREA, GEUS004_WORKFLOW_ID_ESTADO) "
			  + "VALUES (#{idTarea}, #{idEstado})")
	@Options(useGeneratedKeys=true, keyProperty="id", flushCache=true, keyColumn="id")
	public void insertarTareaWorkflow(WorkflowDto workflowDto);
	
	
	@Select("SELECT  GEUS002_TAREAS_ID AS idTarea, "
			  + "GEUS002_TAREAS_NOMBRE AS nombreTarea, "
			  + "GEUS002_TAREAS_DESCRIPCION AS descripcionTarea, "
			  + "GEUS002_FECHA_TAREA AS fecha "
			  + "FROM GEUS002_TAREAS WHERE GEUS002_TAREAS_EMISOR=#{idUsuario}")
	public List<TareaDto> getTareasEmitidas(int idUsuario);
	
	@Select("SELECT  GEUS001_USUARIOS_ID AS id, "
			  + "GEUS001_USUARIOS_NOMBRE AS nombre, "
			  + "GEUS001_USUARIOS_APELLIDO AS apellido,"
			  + "GEUS001_USUARIOS_EMAIL AS email, "
			  + "GEUS001_USUARIOS_PASSWORD AS password, "
			  + "GEUS001_USUARIOS_SUELDO AS salario, "
			  + "GEUS001_USUARIOS_FECHAINC AS fechaIncorporacion,"
			  + "GEUS001_USUARIOS_CARGO AS puesto "
			  + "FROM GEUS001_USUARIOS WHERE GEUS001_USUARIOS_ID = #{idUsuario}")
	public UsuarioDto getUsuarioPerfil(int idUsuario);

	@Select("SELECT GEUS002_TAREAS_ID AS idTarea, "
			  + "GEUS002_TAREAS_NOMBRE AS nombreTarea, "
			  + "GEUS002_TAREAS_EMISOR AS emisorTarea, "
			  + "GEUS002_TAREAS_DESCRIPCION AS descripcionTarea "
			  + "FROM GEUS002_TAREAS INNER JOIN GEUS004_WORKFLOW ON "
			  + "GEUS004_WORKFLOW.GEUS004_WORKFLOW_ID_TAREA = GEUS002_TAREAS.GEUS002_TAREAS_ID "
			  + "WHERE GEUS004_WORKFLOW_ID_ESTADO = 1")
	public List<TareaDto> getTareasPendientes();
	
	@Update("UPDATE GEUS004_WORKFLOW "
		  + "SET GEUS004_WORKFLOW_ID_ESTADO = 2 "
		  + "WHERE GEUS004_WORKFLOW_ID_TAREA = #{idTarea}")
	public void actualizarTareaWorkflowAprobada(int idTarea);
	
	@Update("UPDATE GEUS004_WORKFLOW "
			  + "SET GEUS004_WORKFLOW_ID_ESTADO = 3 "
			  + "WHERE GEUS004_WORKFLOW_ID_TAREA = #{idTarea}")
	public void actualizarTareaWorkflowRechazada(int idTarea);
	
	@Insert("INSERT INTO GEUS005_TAREAS_DIRECTIVO(GEUS005_TAREAS_DIRECTIVO_ID_TAREA, GEUS005_TAREAS_DIRECTIVO_ID_DIRECTIVO) "
			  + "VALUES (#{idTarea}, #{idTrabajador})")
	@Options(useGeneratedKeys=true, keyProperty="id", flushCache=true, keyColumn="id")
	public void insertarAprobadorTarea(TrabajadoresDto trabajadoresDto);
	
	@Select("SELECT GEUS003_TRABAJADORES_ID_EMPLEADO AS idTrabajador "
			  + "FROM GEUS003_TRABAJADORES_ASIGNADOS WHERE GEUS003_TRABAJADORES_ID_TAREA = #{idTarea}")
	public List<TrabajadoresDto> getUsuarioTarea(int idTarea);
	
	@Select("SELECT GEUS001_USUARIOS_EMAIL AS email "
			  + "FROM GEUS001_USUARIOS WHERE GEUS001_USUARIOS_ID = #{idUsuario}")
	public UsuarioDto getUsuarioCorreo(int idUsuario);
	
	@Select("SELECT GEUS002_TAREAS_NOMBRE AS nombreTarea, "
		  + "GEUS002_TAREAS_EMISOR AS emisorTarea, "
		  + "GEUS002_TAREAS_DESCRIPCION AS descripcionTarea "
		  + "FROM GEUS002_TAREAS WHERE GEUS002_TAREAS_ID=#{idTarea}")
	public TareaDto getTareasDatosMail(int idTarea);
	
	@Select("SELECT GEUS005_TAREAS_DIRECTIVO_ID_TAREA AS idTarea "
			  + "FROM GEUS005_TAREAS_DIRECTIVO WHERE GEUS005_TAREAS_DIRECTIVO_ID_DIRECTIVO=#{idDirectivo}")
	public List<TareaDto> getTareasTramitadasDirectivo(int idDirectivo);
	
	@Select("SELECT GEUS004_WORKFLOW_ID_ESTADO AS idEstado "
			  + "FROM GEUS004_WORKFLOW WHERE GEUS004_WORKFLOW_ID_TAREA=#{idTarea}")
	public WorkflowDto getTareasTramitadasDirectivoEstado(int idTarea);
	
	
	@Select("SELECT GEUS002_TAREAS_ID AS idTarea, "
			  + "GEUS002_TAREAS_NOMBRE AS nombreTarea, "
			  + "GEUS002_TAREAS_EMISOR AS emisorTarea, "
			  + "GEUS002_TAREAS_DESCRIPCION AS descripcionTarea "
			  + "FROM GEUS002_TAREAS, GEUS004_WORKFLOW, GEUS003_TRABAJADORES_ASIGNADOS "
			  + "WHERE GEUS002_TAREAS.GEUS002_TAREAS_ID = GEUS004_WORKFLOW.GEUS004_WORKFLOW_ID_TAREA "
			  + "AND GEUS004_WORKFLOW.GEUS004_WORKFLOW_ID_ESTADO=2 "
			  + "AND GEUS003_TRABAJADORES_ASIGNADOS.GEUS003_TRABAJADORES_ID_TAREA=GEUS004_WORKFLOW.GEUS004_WORKFLOW_ID_TAREA "
			  + "AND GEUS003_TRABAJADORES_ASIGNADOS.GEUS003_TRABAJADORES_ID_EMPLEADO =#{idUsuario}")	 
	public List<TareaDto> getTareasAprobadasTecnico(int idUsuario);
	
	
	@Select("SELECT  GEUS002_TAREAS_ID AS idTarea, "
			  + "GEUS002_TAREAS_NOMBRE AS nombreTarea, "
			  + "GEUS002_TAREAS_DESCRIPCION AS descripcionTarea, "
			  + "GEUS002_FECHA_TAREA AS fecha "
			  + "FROM GEUS002_TAREAS")
	public List<TareaDto> obtenerTodasTareas();
	
	@Delete("DELETE FROM GEUS002_TAREAS "
		  + "WHERE GEUS002_TAREAS_ID = #{idTarea}")
	public void eliminarTarea(int idTarea);
	
	@Delete("DELETE FROM GEUS003_TRABAJADORES_ASIGNADOS "
		  + "WHERE GEUS003_TRABAJADORES_ID_TAREA = #{idTarea}")
	public void eliminarTareaTrabajador(int idTarea);
	
	@Delete("DELETE FROM GEUS004_WORKFLOW "
		  + "WHERE GEUS004_WORKFLOW_ID_TAREA = #{idTarea}")
	public void eliminarTareaWorkflow(int idTarea);
	
	@Delete("DELETE FROM GEUS005_TAREAS_DIRECTIVO "
		  + "WHERE GEUS004_TAREAS_DIRECTIVO_ID_TAREA = #{idTarea}")
	public void eliminarTareaDirectivo(int idTarea);
}
