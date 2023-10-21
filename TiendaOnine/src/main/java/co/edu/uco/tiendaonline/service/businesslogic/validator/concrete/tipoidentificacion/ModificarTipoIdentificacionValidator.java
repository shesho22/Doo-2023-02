package co.edu.uco.tiendaonline.service.businesslogic.validator.concrete.tipoidentificacion;

import co.edu.uco.tiendaonline.crosscutting.util.UtilObjeto;
import co.edu.uco.tiendaonline.service.businesslogic.validator.Validator;
import co.edu.uco.tiendaonline.service.domain.tipoidentificacion.TipoIdentificacionDomain;
import co.edu.uco.tiendaonline.service.domain.tipoidentificacion.rules.CodigoTipoIdentificacionValidationRule;
import co.edu.uco.tiendaonline.service.domain.tipoidentificacion.rules.IdTipoIdentificacionValidationRule;
import co.edu.uco.tiendaonline.service.domain.tipoidentificacion.rules.NombreTipoIdentificacionValidationRule;

public class ModificarTipoIdentificacionValidator implements Validator<TipoIdentificacionDomain>{
	private static final Validator<TipoIdentificacionDomain> instancia = new ModificarTipoIdentificacionValidator();
	
	private ModificarTipoIdentificacionValidator() {
		super();
	}
	
	public static final void ejecutarValidacion(final TipoIdentificacionDomain dato) {
		instancia.execute(dato);
	}

	@Override
	public void execute(TipoIdentificacionDomain dato) {
		
		IdTipoIdentificacionValidationRule.ejecutarValidacion(dato.getId());
		CodigoTipoIdentificacionValidationRule.ejecutarValidacion(dato.getCodigo());
		NombreTipoIdentificacionValidationRule.ejecutarValidacion(dato.getNombre());
	}
	
}
