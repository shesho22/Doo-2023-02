package co.edu.uco.tiendaonline.service.domain.cliente.rules;

import co.edu.uco.tiendaonline.crosscutting.exception.concrete.ServiceTiendaOnlineException;
import co.edu.uco.tiendaonline.crosscutting.util.UtilObjeto;
import co.edu.uco.tiendaonline.service.domain.ValidatorRule;
import co.edu.uco.tiendaonline.service.domain.cliente.support.NombreCompletoClienteDomain;

public class NombreCompletoValidationRule implements ValidatorRule<NombreCompletoClienteDomain> {

    private static final ValidatorRule<NombreCompletoClienteDomain> instancia = new NombreCompletoValidationRule();

    private NombreCompletoValidationRule() {
        super();
    }

    public static void ejecutarValidacion(NombreCompletoClienteDomain nombreCompleto) {
        instancia.validar(nombreCompleto);
    }

    @Override
    public void validar(NombreCompletoClienteDomain dato) {
    	if(UtilObjeto.esNulo(dato)) {
			var mensajeUsuario = "No es posible llevar a cabo la operacion deseada con el Nombre completo, debido a que no existe datos para llevar a cabo...";
			throw ServiceTiendaOnlineException.crear(mensajeUsuario);
		}
    }

}


