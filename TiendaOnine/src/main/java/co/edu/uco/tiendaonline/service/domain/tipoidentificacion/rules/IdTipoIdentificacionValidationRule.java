package co.edu.uco.tiendaonline.service.domain.tipoidentificacion.rules;

import java.util.UUID;

import co.edu.uco.tiendaonline.crosscutting.exception.concrete.ServiceTiendaOnlineException;
import co.edu.uco.tiendaonline.crosscutting.util.UtilObjeto;
import co.edu.uco.tiendaonline.crosscutting.util.UtilTexto;
import co.edu.uco.tiendaonline.crosscutting.util.UtilUUID;
import co.edu.uco.tiendaonline.service.domain.ValidatorRule;

public final class IdTipoIdentificacionValidationRule implements ValidatorRule<uuid>{

	private static final ValidatorRule<String> instancia = new IdTipoIdentificacionValidationRule();
	
	  private IdTipoIdentificacionValidationRule() {
		  super();
	  }
	  
	  public static final void ejecutarValidacion(final UUID dato) {
		  instancia.validar(dato);
	  }
	
	@Override
	public final void validar(final UUID dato) {

		validarObligatoriedad(dato);
		validarIdFormato(dato);
	}

	private final void validarObligatoriedad(final UUID dato) {
		if(UtilObjeto.esNulo(dato)) {
			var mensajeUsuario="El id del tipo identificacion es un dato que es obligatorio.";
			throw ServiceTiendaOnlineException.crear(mensajeUsuario);
		}
	}

	private final void validarIdFormato(final UUID dato) {
		if(!UtilUUID.esUuidPorDefecto(dato)) {
			var mensajeUsuario="El id del tipo identificacion solo pude ser igual al id por defecto.";
			throw ServiceTiendaOnlineException.crear(mensajeUsuario);
		}
	}

}
