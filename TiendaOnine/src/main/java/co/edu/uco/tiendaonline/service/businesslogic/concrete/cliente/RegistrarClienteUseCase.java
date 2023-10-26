package co.edu.uco.tiendaonline.service.businesslogic.concrete.cliente;

import java.util.Optional;
import java.util.UUID;

import co.edu.uco.tiendaonline.crosscutting.exception.concrete.ServiceTiendaOnlineException;
import co.edu.uco.tiendaonline.crosscutting.util.UtilObjeto;
import co.edu.uco.tiendaonline.crosscutting.util.UtilTexto;
import co.edu.uco.tiendaonline.data.dao.TipoIdentificacionDAO;
import co.edu.uco.tiendaonline.data.dao.daofactory.DAOFactory;
import co.edu.uco.tiendaonline.data.entity.ClienteEntity;
import co.edu.uco.tiendaonline.data.entity.TipoIdentificacionEntity;
import co.edu.uco.tiendaonline.service.businesslogic.UseCase;
import co.edu.uco.tiendaonline.service.businesslogic.validator.concrete.tipoidentificacion.RegistrarTipoIdentificacionValidator;
import co.edu.uco.tiendaonline.service.domain.cliente.ClienteDomain;
import co.edu.uco.tiendaonline.service.domain.tipoidentificacion.TipoIdentificacionDomain;
import co.edu.uco.tiendaonline.service.mapper.entity.concrete.ClienteEntityMapper;
import co.edu.uco.tiendaonline.service.mapper.entity.concrete.TipoIdentificacionEntityMapper;

public final class RegistrarClienteUseCase implements UseCase<TipoIdentificacionDomain>{

	private DAOFactory factoria;
	

	public RegistrarClienteUseCase(final DAOFactory factoria) {
		setFatoria(factoria);
	}
	
	

	@Override
	public final void execute(ClienteDomain domain) {
		RegistrarTipoIdentificacionValidator.ejecutar(domain);

		//3.No debe existir otro tipo de identificacion con el mismo nombre 
		validarNoExistenciaClienteConMismoIdTipoDocumento(domain.getTipoidentificacion(),domain.getIdentificacion());
		
		//4.No debe existir otro tipo de identificacion con el mismo identificador
				domain = obtenerIdentificadorCliente(domain);
		registrarNuevoTipoIdentificacion(domain);
	}

	private void registrarNuevoTipoIdentificacion(final TipoIdentificacionDomain domain) {
		var entity = TipoIdentificacionEntityMapper.convertToEntity(domain);
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
		return ClienteDomain.crear(uuid, domain.getCodigo(), domain.getNombre(), domain.isEstado());
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

	private final TipoIdentificacionDAO getClienteDAO() {
		return getFactoria().obtenerClienteDAO();
	}




	

}
