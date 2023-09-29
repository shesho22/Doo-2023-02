package co.edu.uco.tiendaonline.data.dao.daofactory;

import co.edu.uco.tiendaonline.data.dao.ClienteDAO;
import co.edu.uco.tiendaonline.data.dao.TipoIdentificacionDAO;
import co.edu.uco.tiendaonline.data.dao.daofactory.concrete.SQLServerDAOFactory;

public abstract class DAOFactory {
	
	public static final DAOFactory obtenerDAOFactory(final TipoDAOFactory factory) {
		switch (factory) {
		case SQLSERVER: {
			return new SQLServerDAOFactory();
		}
		case POSTGRESQL: {
			throw new RuntimeException("Factoria no sportade");
		}
		case MYSQL: {
			throw new RuntimeException("Factoria no sportade");
		}
		case ORACLE: {
			throw new RuntimeException("Factoria no sportade");
		}
		default:
			throw new RuntimeException("Factoria no sportade");
		}
	}
	
	protected abstract void abrirConecxion();
	public abstract void cerrarConexion();
	public abstract void iniciarTransaccion();
	public abstract void confirmarTransaccion();
	public abstract void cancelarTransaccion();
	
	public abstract ClienteDAO obtenerClienteDAO();
	public abstract TipoIdentificacionDAO obtenerTipoIdentificacionDAO();
}
