package co.edu.uco.tiendaonline.service.domain.tipoidentificacion.rules;

import co.edu.uco.tiendaonline.crosscutting.exception.concrete.DataTiendaOnlineException;
import co.edu.uco.tiendaonline.crosscutting.exception.concrete.ServiceTiendaOnlineException;
import co.edu.uco.tiendaonline.crosscutting.util.UtilTexto;
import co.edu.uco.tiendaonline.service.domain.ValidatorRule;

public final class NombreTipoIdentificacionValidationRule implements ValidatorRule<String>{

	private static final ValidatorRule<String> instancia = new NombreTipoIdentificacionValidationRule();
	
	  private NombreTipoIdentificacionValidationRule() {
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
		if(!UtilTexto.longitudMaximaValida(dato, 50)) {
			var mensajeUsuario="La longitud del nombre del tipo identificacion no es valida. la longitud maxim son 50 caracteres";
			throw ServiceTiendaOnlineException.crear(mensajeUsuario);
		}
	}
	
	private final void validarObligatoriedad(final String dato) {
		if(UtilTexto.estaVacio(dato)) {
			var mensajeUsuario="El nombre del tipo identificacion es un dato que es obligatorio";
			throw ServiceTiendaOnlineException.crear(mensajeUsuario);
		}
	}

	private final void validarFormato(final String dato) {
		if(!UtilTexto.contieneSoloLetrasDigitosEspacios(dato)) {
			var mensajeUsuario="El nombre del tipo identificacion solo pude contener letras y numeros";
			throw ServiceTiendaOnlineException.crear(mensajeUsuario);
		}
	}

}
