package co.edu.uco.tiendaonline.data.dao.daofactory.concrete;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import co.edu.uco.tiendaonline.crosscutting.exception.concrete.CrossCuttingTiendaOnlineException;
import co.edu.uco.tiendaonline.crosscutting.exception.concrete.DataTiendaOnlineException;
import co.edu.uco.tiendaonline.crosscutting.messages.CatalogoMensajes;
import co.edu.uco.tiendaonline.crosscutting.messages.enumerator.CodigoMensaje;
import co.edu.uco.tiendaonline.crosscutting.util.UtilSQL;
import co.edu.uco.tiendaonline.data.dao.ClienteDAO;
import co.edu.uco.tiendaonline.data.dao.TipoIdentificacionDAO;
import co.edu.uco.tiendaonline.data.dao.concrete.sqlserver.TipoIdentificacionSQLServerDAO;
import co.edu.uco.tiendaonline.data.dao.daofactory.DAOFactory;
import co.edu.uco.tiendaonline.data.dao.daofactory.concrete.sqlserver.ClienteSQLServerDAO;
import co.edu.uco.tiendaonline.data.dao.daofactory.concrete.sqlserver.TipoIdentificscionSQLServerDAO;

public final class SQLServerDAOFactory extends DAOFactory {

	private Connection conexion;

	public SQLServerDAOFactory() {
		abrirConexion();
	}

	@Override
	protected final void abrirConexion() {
		try {
			var cadenaConexion = "jdbc:sqlserver://<server>:<port>;encrypt=false;databaseName=<database>;user=<user>;password=<password>";
			conexion = DriverManager.getConnection(cadenaConexion);
		} catch (final SQLException excepcion) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000027);
			throw DataTiendaOnlineException.crear(excepcion, mensajeUsuario, mensajeTecnico);
		} catch (final Exception excepcion) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000028);
			throw DataTiendaOnlineException.crear(excepcion, mensajeUsuario, mensajeTecnico);
		}
	}

	@Override
	public final void cerrarConexion() {
		UtilSQL.cerrarConexion(conexion);
	}

	@Override
	public final void iniciarTransaccion() {
		UtilSQL.iniciarTransaccion(conexion);
	}

	@Override
	public final void confirmarTransaccion() {
		UtilSQL.confirmarTransaccion(conexion);
	}

	@Override
	public final void cancelarTransaccion() {
		UtilSQL.cancelarTransaccion(conexion);
	}

	@Override
	public final ClienteDAO obtenerClienteDAO() {

		if (!UtilSQL.conexionAbierta(conexion)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000033);
			throw CrossCuttingTiendaOnlineException.crear(mensajeUsuario, mensajeTecnico);
		}

		return new ClienteSQLServerDAO(conexion);
	}

	@Override
	public final TipoIdentificacionDAO obtenerTipoIdentificacionDAO() {

		if (!UtilSQL.conexionAbierta(conexion)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000034);
			throw CrossCuttingTiendaOnlineException.crear(mensajeUsuario, mensajeTecnico);
		}

		return new TipoIdentificacionSQLServerDAO(conexion);
	}
}
