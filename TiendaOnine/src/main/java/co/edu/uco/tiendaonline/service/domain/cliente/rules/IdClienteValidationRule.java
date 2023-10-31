package co.edu.uco.tiendaonline.service.domain.cliente.rules;

import java.util.UUID;

import co.edu.uco.tiendaonline.crosscutting.exception.concrete.ServiceTiendaOnlineException;
import co.edu.uco.tiendaonline.crosscutting.util.UtilObjeto;
import co.edu.uco.tiendaonline.crosscutting.util.UtilUUID;
import co.edu.uco.tiendaonline.service.domain.ValidatorRule;

public class IdClienteValidationRule implements ValidatorRule<UUID>{

	private static final ValidatorRule<UUID> instancia = new IdClienteValidationRule();
	
	private IdClienteValidationRule() {	
		super();
	}
	
	public static final void ejecutarValidacion(final UUID dato) {
		instancia.validar(dato);
	}
	
	@Override
	public final void validar(final UUID dato) {
		validarObligatoriedad(dato);
		validarIdPorDefecto(dato);
	}

	private void validarObligatoriedad(final UUID dato) {
		if(UtilObjeto.esNulo(dato)) {
			var mensajeUsuario = "El id del cliente es obligatorio...";
			throw ServiceTiendaOnlineException.crear(mensajeUsuario);
		}
	}

	private void validarIdPorDefecto(UUID dato) {
		if(UtilUUID.esUuidPorDefecto(dato)) {
			var mensajeUsuario = "El id del cliente no puede ser igual al id por defecto...";
			throw ServiceTiendaOnlineException.crear(mensajeUsuario);
		}
	}
}
