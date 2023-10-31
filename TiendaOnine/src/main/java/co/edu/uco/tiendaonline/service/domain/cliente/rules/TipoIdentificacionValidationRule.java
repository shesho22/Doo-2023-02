package co.edu.uco.tiendaonline.service.domain.cliente.rules;

import co.edu.uco.tiendaonline.crosscutting.exception.concrete.ServiceTiendaOnlineException;
import co.edu.uco.tiendaonline.crosscutting.util.UtilObjeto;
import co.edu.uco.tiendaonline.service.domain.ValidatorRule;
import co.edu.uco.tiendaonline.service.domain.tipoidentificacion.TipoIdentificacionDomain;

public final class TipoIdentificacionValidationRule implements ValidatorRule<TipoIdentificacionDomain>{

	private static final ValidatorRule<TipoIdentificacionDomain> instancia = new TipoIdentificacionValidationRule();
	
	  private TipoIdentificacionValidationRule() {
		  super();
	  }
	  
	  public static final void ejecutarValidacion(final TipoIdentificacionDomain dato) {
		  instancia.validar(dato);
	  }
	
	
	@Override
	public final void validar(final TipoIdentificacionDomain dato) {
		if(UtilObjeto.esNulo(dato)) {
			var mensajeUsuario = "No es posible llevar a cabo la operacion deseada con el Tipo de Identificacion, debido a que no existe datos para llevar a cabo...";
			throw ServiceTiendaOnlineException.crear(mensajeUsuario);
		}
	}
}
