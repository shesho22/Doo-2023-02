package co.edu.uco.tiendaonline.service.businesslogic.concrete.cliente;

import java.util.Optional;
import java.util.UUID;

import co.edu.uco.tiendaonline.crosscutting.exception.concrete.ServiceTiendaOnlineException;
import co.edu.uco.tiendaonline.crosscutting.util.UtilObjeto;
import co.edu.uco.tiendaonline.data.dao.ClienteDAO;
import co.edu.uco.tiendaonline.data.dao.daofactory.DAOFactory;
import co.edu.uco.tiendaonline.data.entity.ClienteEntity;
import co.edu.uco.tiendaonline.service.businesslogic.UseCase;
import co.edu.uco.tiendaonline.service.businesslogic.validator.concrete.cliente.RegistrarClienteValidator;
import co.edu.uco.tiendaonline.service.domain.cliente.ClienteDomain;
import co.edu.uco.tiendaonline.service.domain.tipoidentificacion.TipoIdentificacionDomain;
import co.edu.uco.tiendaonline.service.mapper.entity.concrete.ClienteEntityMapper;

public final class RegistrarClienteUseCase implements UseCase<ClienteDomain>{

	private DAOFactory factoria;
	

	public RegistrarClienteUseCase(final DAOFactory factoria) {
		setFatoria(factoria);
	}
	
	

	@Override
	public final void execute(ClienteDomain domain) {
		RegistrarClienteValidator.ejecutar(domain);
		validarNoExistenciaClienteConMismoIdTipoDocumento(domain.getTipoidentificacion(),domain.getIdentificacion());
		domain = obtenerIdentificadorCliente(domain);
		registrarNuevoCliente(domain);
	}

	private void registrarNuevoCliente(final ClienteDomain domain) {
		var entity = ClienteEntityMapper.convertToEntity(domain);
		getClienteDAO().crear(entity);
	}

	
	private void validarNoExistenciaClienteConMismoIdTipoDocumento(TipoIdentificacionDomain tipoidentificacion,
			String identificacion) {
		var domain = ClienteDomain.crear(null, tipoidentificacion, identificacion, null, null, null, null);
		var entity= ClienteEntityMapper.convertToEntity(domain);
		var resultados = getClienteDAO().consultar(entity);
		if(!resultados.isEmpty()) {
			var mensajeUsuario = "Ya existe un Cliente con este tipo de documento y el codigo "+identificacion;
			throw ServiceTiendaOnlineException.crear(mensajeUsuario);
		}
		
	}
	
	
	private final ClienteDomain obtenerIdentificadorCliente(final ClienteDomain domain) {
		Optional<ClienteEntity> optional = Optional.empty();
		UUID uuid;
		do {
			uuid = UUID.randomUUID();
			optional = getClienteDAO().consultarPorId(uuid);
		}while(optional.isPresent());
		return ClienteDomain.crear(uuid, domain.getTipoidentificacion(), domain.getIdentificacion(), domain.getNombreCompleto(),domain.getCorreoElectornico(),domain.getNumeroTelefonoMovil(),domain.getFechaNacimiento());
	}
	

	private final DAOFactory getFactoria() {
		return factoria;
	}

	private final void setFatoria(final DAOFactory factoria) {
		if(UtilObjeto.esNulo(factoria)) {
		var mensajeUsuario= "Se ha presentado un problema tratando de llevar a cabo el resultado";
		var mensajeTecnico = "Se ha presentado un problema en setFactoria";
		throw ServiceTiendaOnlineException.crear(mensajeUsuario,mensajeTecnico);
		}
		this.factoria = factoria;
	}

	private final ClienteDAO getClienteDAO() {
		return getFactoria().obtenerClienteDAO();
	}



	




	

}
