package co.edu.uco.tiendaonline.service.facade.concrete.cliente;

import co.edu.uco.tiendaonline.crosscutting.exception.TiendaOnlineException;
import co.edu.uco.tiendaonline.crosscutting.exception.concrete.ServiceTiendaOnlineException;
import co.edu.uco.tiendaonline.data.dao.daofactory.DAOFactory;
import co.edu.uco.tiendaonline.data.dao.daofactory.TipoDAOFactory;
import co.edu.uco.tiendaonline.service.businesslogic.concrete.cliente.RegistrarClienteUseCase;
import co.edu.uco.tiendaonline.service.businesslogic.validator.concrete.cliente.RegistrarClienteValidator;
import co.edu.uco.tiendaonline.service.domain.cliente.ClienteDomain;
import co.edu.uco.tiendaonline.service.dto.ClienteDTO;
import co.edu.uco.tiendaonline.service.facade.Facade;
import co.edu.uco.tiendaonline.service.mapper.dto.concrete.ClienteDTOMapper;

public final class RegistrarClienteFacade implements Facade<ClienteDTO>{

	@Override
	public final void execute(ClienteDTO dto) {
		final ClienteDomain domain = ClienteDTOMapper.convertirToDomain(dto);
		RegistrarClienteValidator.ejecutar(domain);
		
		final DAOFactory daoFactory =DAOFactory.obtenerDAOFactory(TipoDAOFactory.SQLSERVER);
		
		try {
			daoFactory.iniciarTransaccion();
			
			var useCase = new RegistrarClienteUseCase(daoFactory);
			useCase.execute(domain);
			
			daoFactory.confirmarTransaccion();
			
		}catch (final TiendaOnlineException excepcion) {
			daoFactory.cancelarTransaccion();
			throw excepcion;
		}catch (Exception exception) {
			daoFactory.cancelarTransaccion();
			var mensajeUsuario ="Se ha presentado un error inesperado tratando de registrar un nuevo cliente";
			var mensajeTecnico = "Se ha presentado un error inesperado tratando de registrar un nuevo cliente. verigue la trasa completa ";
			throw ServiceTiendaOnlineException.crear(exception,mensajeUsuario,mensajeTecnico);
		}
		finally {
			daoFactory.cerrarConexion();
		}
	}
	
}
