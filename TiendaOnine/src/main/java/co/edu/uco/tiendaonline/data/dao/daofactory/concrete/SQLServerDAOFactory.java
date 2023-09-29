package co.edu.uco.tiendaonline.data.dao.daofactory.concrete;

import java.sql.Connection;

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
		// TODO obtener la conexion con la base de datos 
		conexion = null;
		
	}

	@Override
	public final void cerrarConexion() {
		// TODO cerrar conexion
		
	}

	@Override
	public void iniciarTransaccion() {
		// TODO iniciar transaccion  
		
	}

	@Override
	public void confirmarTransaccion() {
		// TODO confirmar transaccion 
		
	}

	@Override
	public void cancelarTransaccion() {
		// TODO rollback
		
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
