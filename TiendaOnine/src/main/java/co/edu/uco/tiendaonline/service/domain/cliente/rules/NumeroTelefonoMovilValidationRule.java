package co.edu.uco.tiendaonline.service.domain.cliente.rules;

import co.edu.uco.tiendaonline.crosscutting.exception.concrete.ServiceTiendaOnlineException;
import co.edu.uco.tiendaonline.crosscutting.util.UtilObjeto;
import co.edu.uco.tiendaonline.service.domain.ValidatorRule;
import co.edu.uco.tiendaonline.service.domain.cliente.support.NumeroTelefonoMovilClienteDomain;

public class NumeroTelefonoMovilValidationRule implements ValidatorRule<NumeroTelefonoMovilClienteDomain>{

	   private static final ValidatorRule<NumeroTelefonoMovilClienteDomain> instancia = new NumeroTelefonoMovilValidationRule();

	    private NumeroTelefonoMovilValidationRule() {
	        super();
	    }

	    public static void ejecutarValidacion(NumeroTelefonoMovilClienteDomain nombreCompleto) {
	        instancia.validar(nombreCompleto);
	    }

	    @Override
	    public void validar(NumeroTelefonoMovilClienteDomain dato) {
	    	if(UtilObjeto.esNulo(dato)) {
				var mensajeUsuario = "No es posible llevar a cabo la operacion deseada con el numero telefono, debido a que no existe datos para llevar a cabo...";
				throw ServiceTiendaOnlineException.crear(mensajeUsuario);
			}
	    }
}
