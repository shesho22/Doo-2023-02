package co.edu.uco.tiendaonline.crosscutting.messages;

import java.util.HashMap;
import java.util.Map;

import co.edu.uco.tiendaonline.crosscutting.exception.concrete.CrossCuttingTiendaOnlineException;
import co.edu.uco.tiendaonline.crosscutting.messages.enumerator.CategoriaMensaje;
import co.edu.uco.tiendaonline.crosscutting.messages.enumerator.CodigoMensaje;
import co.edu.uco.tiendaonline.crosscutting.messages.enumerator.TipoMensaje;
import co.edu.uco.tiendaonline.crosscutting.util.UtilObjeto;

public final class CatalogoMensajes {
	private static final Map<CodigoMensaje, Mensaje> MENSAJES = new HashMap<>();
	
	static {
		cargarMensajes();
	}
	
	private CatalogoMensajes() {
		super();
	}
	
	private static final void cargarMensajes() {
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000001, TipoMensaje.TECNICO, CategoriaMensaje.FATAL,"No se recibio el codigo del mensaje que se queria crear. No es posible continuar con el proceso"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000002, TipoMensaje.TECNICO, CategoriaMensaje.FATAL,"No se existe un mensaje con el codigo indicado. No es posible continuar con el proceso"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000003, TipoMensaje.TECNICO, CategoriaMensaje.FATAL,"No es posible obtener un mensaje con un codigo vacio o nulo. No es posible continuar con el proceso"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000004, TipoMensaje.USUARIO, CategoriaMensaje.FATAL,"Se ha presentado un problema inesperado tratando de llevar a cabo la operacion deseada. Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicacion"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000005, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,"Se ha presentado un problrma tratando de validar si la conexion sql estaba abierta. Se presento una excepcion de tipo sqlexception."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000006, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,"Se ha presentado un problema inesperado tratando de validar si la xonexion sql estaba abierta. se presento una excepcion completa del error presentado, por favor verifique la traza completa del error presentado."));

	}
	
	private static final void agregarMensaje(final Mensaje mensaje) {
		MENSAJES.put(mensaje.getCodigo(), mensaje);
	}
	
	public static final Mensaje obtenerMensaje(final CodigoMensaje codigo) {
		if(UtilObjeto.esNulo(codigo)) {
			var mensajeUsuario= obtenerMensaje(CodigoMensaje.M0000000004).getContenido();
			var mensajeTecnico= obtenerMensaje(CodigoMensaje.M0000000003).getContenido();
			throw CrossCuttingTiendaOnlineException.crear(mensajeUsuario,mensajeTecnico);
		}
		if(!MENSAJES.containsKey(codigo)) {
			var mensajeUsuario= obtenerMensaje(CodigoMensaje.M0000000004).getContenido();
			var mensajeTecnico= obtenerMensaje(CodigoMensaje.M0000000002).getContenido();
			throw CrossCuttingTiendaOnlineException.crear(mensajeUsuario,mensajeTecnico);
		}
		return MENSAJES.get(codigo);
	}
	
	public static final String obtenerContenidoMensaje(final CodigoMensaje codigo) {
		return obtenerMensaje(codigo).getContenido();
	}
}
