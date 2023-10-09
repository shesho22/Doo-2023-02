package co.edu.uco.tiendaonline.data.dao.daofactory.concrete;

import java.sql.Connection;
import java.sql.SQLException;

import co.edu.uco.tiendaonline.crosscutting.exception.concrete.DataTiendaOnlineException;
import co.edu.uco.tiendaonline.crosscutting.util.UtilSQL;
import co.edu.uco.tiendaonline.data.dao.ClienteDAO;
import co.edu.uco.tiendaonline.data.dao.TipoIdentificacionDAO;
import co.edu.uco.tiendaonline.data.dao.daofactory.DAOFactory;
import co.edu.uco.tiendaonline.data.dao.daofactory.concrete.sqlserver.ClienteSQLServerDAO;
import co.edu.uco.tiendaonline.data.dao.daofactory.concrete.sqlserver.TipoIdentificscionSQLServerDAO;

public final class SQLServerDAOFactory extends DAOFactory{

	private Connection conexion;
	
	public SQLServerDAOFactory() {
		abrirConecxion();
		
	}
	@Override
	protected final void abrirConecxion() {
		try {
			conexion = null;
		} catch (SQLException exception) {
			throw DataTiendaOnlineException.crear(exception, null, null);
		}catch (ClassNotFoundException exception) {
			throw DataTiendaOnlineException.crear(exception, null, null);
		}
		catch (Exception exception) {
			throw DataTiendaOnlineException.crear(exception, null, null);
		}
	}

	@Override
	public final void cerrarConexion() {
		UtilSQL.cerrarConexion(conexion);
		
	}

	@Override
	public void iniciarTransaccion() {
		UtilSQL.iniciarTransaccion(conexion);
		
	}

	@Override
	public void confirmarTransaccion() {
		UtilSQL.confirmarTransaccion(conexion);
		
	}

	@Override
	public void cancelarTransaccion() {
		UtilSQL.cancelarTransaccion(conexion);
		
	}

	@Override
	public ClienteDAO obtenerClienteDAO() {
		return new ClienteSQLServerDAO(conexion);
	}

	@Override
	public TipoIdentificacionDAO obtenerTipoIdentificacionDAO() {
		return new TipoIdentificscionSQLServerDAO(conexion);
	}
	
}
