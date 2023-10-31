package co.edu.uco.tiendaonline.service.domain.cliente.rules;

import co.edu.uco.tiendaonline.crosscutting.exception.concrete.ServiceTiendaOnlineException;
import co.edu.uco.tiendaonline.crosscutting.util.UtilTexto;
import co.edu.uco.tiendaonline.service.domain.ValidatorRule;

public class IdentificacionValidationRule implements ValidatorRule<String>{

	private static final ValidatorRule<String> instancia = new IdentificacionValidationRule();
	
	  private IdentificacionValidationRule() {
		  super();
	  }
	  
	  public static final void ejecutarValidacion(final String dato) {
		  instancia.validar(dato);
	  }
	
	
	@Override
	public final void validar(final String dato) {
		validarLongitud(dato);
		validarObligatoriedad(dato);
		validarFormato(dato);
	}
	
	private final void validarLongitud(final String dato) {
		if(!UtilTexto.longitudMaximaValida(dato, 15)) {
			var mensajeUsuario="La longitud del nombre del tipo identificacion no es valida. la longitud maxim son 50 caracteres";
			throw ServiceTiendaOnlineException.crear(mensajeUsuario);
		}
	}
	
	private final void validarObligatoriedad(final String dato) {
		if(UtilTexto.estaVacio(dato)) {
			var mensajeUsuario="La identificacion es un dato que es obligatorio";
			throw ServiceTiendaOnlineException.crear(mensajeUsuario);
		}
	}

	private final void validarFormato(final String dato) {
		if(!UtilTexto.contieneSoloNumeros(dato)) {
			var mensajeUsuario="La identificacion solo pude contener numeros";
			throw ServiceTiendaOnlineException.crear(mensajeUsuario);
		}
	}

}
