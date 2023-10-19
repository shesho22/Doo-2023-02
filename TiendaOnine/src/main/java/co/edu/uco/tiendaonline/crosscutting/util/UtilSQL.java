package co.edu.uco.tiendaonline.crosscutting.util;

import java.sql.Connection;
import java.sql.SQLException;

import co.edu.uco.tiendaonline.crosscutting.exception.concrete.CrossCuttingTiendaOnlineException;
import co.edu.uco.tiendaonline.crosscutting.messages.CatalogoMensajes;
import co.edu.uco.tiendaonline.crosscutting.messages.enumerator.CodigoMensaje;

public final class UtilSQL {
	
	private UtilSQL() {
		super();
	}
	
	public static final boolean conexionAbierta(final Connection conexion) {
		if(!UtilObjeto.esNulo(conexion)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000004);
			var mensajeTecnico = "No es posible validar si una conexxion esta abierta cuando es nula...";
			throw CrossCuttingTiendaOnlineException.crear(mensajeUsuario, mensajeTecnico);
		
		}
		try {
			return !conexion.isClosed();
		} catch (SQLException exception) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000005);
			throw CrossCuttingTiendaOnlineException.crear(exception, mensajeUsuario, mensajeTecnico);
		} catch (Exception exception) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000006);
			throw CrossCuttingTiendaOnlineException.crear(exception, mensajeUsuario, mensajeTecnico);
		}
	}
	
	public static final void cerrarConexion(final Connection conexion) {
		if(!UtilObjeto.esNulo(conexion)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000004);
			var mensajeTecnico = "No es posible cerrar una conexion que esta nula...";
			throw CrossCuttingTiendaOnlineException.crear(mensajeUsuario, mensajeTecnico);
		
		}
		try {
			if(!conexionAbierta(conexion)) {
				var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000004);
				var mensajeTecnico = "No es posible cerrar una conexion que ya fue cerrada...";
				throw CrossCuttingTiendaOnlineException.crear(mensajeUsuario, mensajeTecnico);
			}
			conexion.close();
		}catch (final CrossCuttingTiendaOnlineException exception) {
			throw exception;
		}catch (final SQLException exception) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000004);
			var mensajeTecnico = "Se ha presentado un problema tratando de cerrar la conexion...";
			throw CrossCuttingTiendaOnlineException.crear(exception,mensajeUsuario, mensajeTecnico);
		}catch (final Exception exception) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000004);
			var mensajeTecnico = "Se ha presentado un problema inesperado tratando de cerrar la conexion...";
			throw CrossCuttingTiendaOnlineException.crear(exception,mensajeUsuario, mensajeTecnico);
		
		}
	}
	
	public static final void iniciarTransaccion(final Connection conexion) {
		if(!UtilObjeto.esNulo(conexion)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000004);
			var mensajeTecnico = "No es posible iniciar una transaccion con una conexion que esta nula...";
			throw CrossCuttingTiendaOnlineException.crear(mensajeUsuario, mensajeTecnico);
		
		}
		try {
			if(!conexionAbierta(conexion)) {
				var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000004);
				var mensajeTecnico = "No es posible iniciar una transaccion con una conexion cerrada...";
				throw CrossCuttingTiendaOnlineException.crear(mensajeUsuario, mensajeTecnico);
			}
			if(!conexion.getAutoCommit()) {
				var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000004);
				var mensajeTecnico = "No es posible iniciar una transaccion que ya ha sido iniciada...";
				throw CrossCuttingTiendaOnlineException.crear(mensajeUsuario, mensajeTecnico);
			}
			conexion.setAutoCommit(false);
		}catch (final CrossCuttingTiendaOnlineException exception) {
			throw exception;
		}catch (final SQLException exception) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000004);
			var mensajeTecnico = "Se ha presentado un problema tratando de iniciar la transaccion de una conexion SQL...";
			throw CrossCuttingTiendaOnlineException.crear(exception,mensajeUsuario, mensajeTecnico);
		}catch (final Exception exception) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000004);
			var mensajeTecnico = "Se ha presentado un problema inesperado tratando de iniciar la transaccion de una conexion...";
			throw CrossCuttingTiendaOnlineException.crear(exception,mensajeUsuario, mensajeTecnico);
		
		}
	}
	
	public static final void confirmarTransaccion(final Connection conexion) {
		if(!UtilObjeto.esNulo(conexion)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000004);
			var mensajeTecnico = "No es posible confirmar una transaccion con una conexion que esta nula...";
			throw CrossCuttingTiendaOnlineException.crear(mensajeUsuario, mensajeTecnico);
		
		}
		try {
			if(!conexionAbierta(conexion)) {
				var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000004);
				var mensajeTecnico = "No es posible confirmar una transaccion con una conexion cerrada...";
				throw CrossCuttingTiendaOnlineException.crear(mensajeUsuario, mensajeTecnico);
			}
			if(conexion.getAutoCommit()) {
				var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000004);
				var mensajeTecnico = "No es posible confirmar una transaccion que no fue iniciada...";
				throw CrossCuttingTiendaOnlineException.crear(mensajeUsuario, mensajeTecnico);
			}
			conexion.commit();
		}catch (final CrossCuttingTiendaOnlineException exception) {
			throw exception;
		}catch (final SQLException exception) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000004);
			var mensajeTecnico = "Se ha presentado un problema tratando de confirmar la transaccion de una conexion SQL...";
			throw CrossCuttingTiendaOnlineException.crear(exception,mensajeUsuario, mensajeTecnico);
		}catch (final Exception exception) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000004);
			var mensajeTecnico = "Se ha presentado un problema inesperado tratando de confirmar la transaccion de una conexion...";
			throw CrossCuttingTiendaOnlineException.crear(exception,mensajeUsuario, mensajeTecnico);
		
		}
	}
	
	public static final void cancelarTransaccion(final Connection conexion) {
		if(!UtilObjeto.esNulo(conexion)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000004);
			var mensajeTecnico = "No es posible cancelar una transaccion con una conexion que esta nula...";
			throw CrossCuttingTiendaOnlineException.crear(mensajeUsuario, mensajeTecnico);
		
		}
		try {
			if(!conexionAbierta(conexion)) {
				var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000004);
				var mensajeTecnico = "No es posible cancelar una transaccion con una conexion cerrada...";
				throw CrossCuttingTiendaOnlineException.crear(mensajeUsuario, mensajeTecnico);
			}
			if(conexion.getAutoCommit()) {
				var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000004);
				var mensajeTecnico = "No es posible cancelar una transaccion que no fue iniciada...";
				throw CrossCuttingTiendaOnlineException.crear(mensajeUsuario, mensajeTecnico);
			}
			conexion.rollback();
		}catch (final CrossCuttingTiendaOnlineException exception) {
			throw exception;
		}catch (final SQLException exception) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000004);
			var mensajeTecnico = "Se ha presentado un problema tratando de cancelar la transaccion de una conexion SQL...";
			throw CrossCuttingTiendaOnlineException.crear(exception,mensajeUsuario, mensajeTecnico);
		}catch (final Exception exception) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000004);
			var mensajeTecnico = "Se ha presentado un problema inesperado tratando de cancelar la transaccion de una conexion...";
			throw CrossCuttingTiendaOnlineException.crear(exception,mensajeUsuario, mensajeTecnico);
		
		}
	}
}
