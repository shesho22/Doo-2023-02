package co.edu.uco.tiendaonline.service.businesslogic.validator.concrete.cliente;


import co.edu.uco.tiendaonline.service.businesslogic.validator.Validator;
import co.edu.uco.tiendaonline.service.domain.cliente.ClienteDomain;
import co.edu.uco.tiendaonline.service.domain.cliente.rules.CorreoElectronicoValidationRule;
import co.edu.uco.tiendaonline.service.domain.cliente.rules.FechaNacimientoValidationRule;
import co.edu.uco.tiendaonline.service.domain.cliente.rules.IdClienteValidationRule;
import co.edu.uco.tiendaonline.service.domain.cliente.rules.IdentificacionValidationRule;
import co.edu.uco.tiendaonline.service.domain.cliente.rules.NombreCompletoValidationRule;
import co.edu.uco.tiendaonline.service.domain.cliente.rules.NumeroTelefonoMovilValidationRule;
import co.edu.uco.tiendaonline.service.domain.tipoidentificacion.rules.TipoIdentificacionValidationRule;


public final class RegistrarClienteValidator implements Validator<ClienteDomain>{


	private static final Validator<ClienteDomain> instancia = new RegistrarClienteValidator();
	
	private RegistrarClienteValidator() {
		super();
	}
	
	public static final void ejecutar(final ClienteDomain data) {
		instancia.execute(data);
	}
	
	
	@Override
	public void execute(ClienteDomain data) {
	    // Ejecutar las validaciones para el objeto OtroObjeto
		IdClienteValidationRule.ejecutarValidacion(data.getId());
	    TipoIdentificacionValidationRule.ejecutarValidacion(data.getTipoidentificacion());
	    IdentificacionValidationRule.ejecutarValidacion(data.getIdentificacion());
	    NombreCompletoValidationRule.ejecutarValidacion(data.getNombreCompleto());
	    CorreoElectronicoValidationRule.ejecutarValidacion(data.getCorreoElectornico());
	    NumeroTelefonoMovilValidationRule.ejecutarValidacion(data.getNumeroTelefonoMovil());
	    FechaNacimientoValidationRule.ejecutarValidacion(data.getFechaNacimiento());
	}
	

}
