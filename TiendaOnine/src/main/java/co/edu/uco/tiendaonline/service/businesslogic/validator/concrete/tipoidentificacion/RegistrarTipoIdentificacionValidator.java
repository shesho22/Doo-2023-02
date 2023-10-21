package co.edu.uco.tiendaonline.service.businesslogic.validator.concrete.tipoidentificacion;

import co.edu.uco.tiendaonline.data.dao.daofactory.DAOFactory;
import co.edu.uco.tiendaonline.service.businesslogic.concrete.tipoidentificacion.RegistrarTipoIdentificacionUseCase;
import co.edu.uco.tiendaonline.service.businesslogic.validator.Validator;
import co.edu.uco.tiendaonline.service.domain.tipoidentificacion.TipoIdentificacionDomain;
import co.edu.uco.tiendaonline.service.domain.tipoidentificacion.rules.CodigoTipoIdentificacionValidationRule;
import co.edu.uco.tiendaonline.service.mapper.entity.concrete.TipoIdentificacionEntityMapper;

public class RegistrarTipoIdentificacionValidator implements Validator<TipoIdentificacionDomain>{

	private DAOFactory facoriaDaoFactory;
	
	public RegistrarTipoIdentificacionUseCase(final DAOFactory facoria) {
		setFacoria(facoria);
	}
	
	@Override
	public void execute(TipoIdentificacionDomain domain) {
		RegistrarTipoIdentificacionValidator.ejecutar(domain);
		ValidarNoExistenciaTipoIdentificacionConMismoCodigo(domain.getCodigo());
		ValidarNoExistenciaTipoIdentificacionConMismoCodigo(domain.getNombre());
		domain = obtenerIdentificadorTipoIdentificacion(domain);
		registrarNuevoTipoIdentificacion(domain);
	}

	private void registrarNuevoTipoIdentificacion(TipoIdentificacionDomain domain) {
		var entity = TipoIdentificacionEntityMapper.convertToEntity(domain);
		getTipoIdentificacionDAO().crear(entity);
		
	}

	private TipoIdentificacionDomain obtenerIdentificadorTipoIdentificacion(TipoIdentificacionDomain domain) {
		// TODO Auto-generated method stub
		return null;
	}

	public static void ejecutar(TipoIdentificacionDomain domain) {
		// TODO Auto-generated method stub
		
	}

	private void ValidarNoExistenciaTipoIdentificacionConMismoCodigo(String codigo) {
		// TODO Auto-generated method stub
		
	}


}
