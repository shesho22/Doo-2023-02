package co.edu.uco.tiendaonline.crosscutting.exception.concrete;

import co.edu.uco.tiendaonline.crosscutting.exception.TiendaOnlineException;
import co.edu.uco.tiendaonline.crosscutting.exception.enumerator.LugarException;

public final class DataTiendaOnlineException extends TiendaOnlineException{

	private static final long serialVersionUID = -9177484194126685659L;
	
	protected DataTiendaOnlineException(Throwable excepcionRaiz, String mensajeUsuario,
			String mensajeTecnico) {
		super(LugarException.DATA, excepcionRaiz, mensajeUsuario, mensajeTecnico);
	}

	public static final TiendaOnlineException crear(final String mensajeUsuario) {
		return new DataTiendaOnlineException(null,mensajeUsuario,mensajeUsuario);
	}
	
	public static final TiendaOnlineException crear(final String mensajeUsuario,final String mensajeTecnico) {
		return new DataTiendaOnlineException(null,mensajeUsuario,mensajeTecnico);
	}
	
	public static final TiendaOnlineException crear(final Throwable exepcionRaiz ,final String mensajeUsuario,final String mensajeTecnico) {
		return new DataTiendaOnlineException(exepcionRaiz,mensajeUsuario,mensajeTecnico);
	}

}
