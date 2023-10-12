package co.edu.uco.tiendaonline.crosscutting.exception.concrete;

import co.edu.uco.tiendaonline.crosscutting.exception.TiendaOnlineException;
import co.edu.uco.tiendaonline.crosscutting.exception.enumerator.LugarException;

public final class CrossCuttingTiendaOnlineException extends TiendaOnlineException{

	private static final long serialVersionUID = -9177484194126685659L;
	
	protected CrossCuttingTiendaOnlineException(Throwable excepcionRaiz, String mensajeUsuario,
			String mensajeTecnico) {
		super(LugarException.CROSSCUTING, excepcionRaiz, mensajeUsuario, mensajeTecnico);
	}

	public static final TiendaOnlineException crear(final String mensajeUsuario) {
		return new CrossCuttingTiendaOnlineException(null,mensajeUsuario,mensajeUsuario);
	}
	
	public static final TiendaOnlineException crear(final String mensajeUsuario,final String mensajeTecnico) {
		return new CrossCuttingTiendaOnlineException(null,mensajeUsuario,mensajeTecnico);
	}
	
	public static final TiendaOnlineException crear(final Throwable exepcionRaiz ,final String mensajeUsuario,final String mensajeTecnico) {
		return new CrossCuttingTiendaOnlineException(exepcionRaiz,mensajeUsuario,mensajeTecnico);
	}
}
