package co.edu.uco.tiendaonline.service.mapper.entity.concrete;

import co.edu.uco.tiendaonline.crosscutting.exception.concrete.ServiceTiendaOnlineException;
import co.edu.uco.tiendaonline.crosscutting.messages.CatalogoMensajes;
import co.edu.uco.tiendaonline.crosscutting.messages.enumerator.CodigoMensaje;
import co.edu.uco.tiendaonline.crosscutting.util.UtilObjeto;
import co.edu.uco.tiendaonline.data.entity.ClienteEntity;
import co.edu.uco.tiendaonline.data.entity.TipoIdentificacionEntity;
import co.edu.uco.tiendaonline.data.entity.support.CorreoElectronicoClienteEntity;
import co.edu.uco.tiendaonline.data.entity.support.NombreCompletoClienteEntity;
import co.edu.uco.tiendaonline.service.domain.cliente.ClienteDomain;
import co.edu.uco.tiendaonline.service.domain.tipoidentificacion.TipoIdentificacionDomain;
import co.edu.uco.tiendaonline.service.mapper.entity.EntityMapper;
import co.edu.uco.tiendaonline.service.mapper.entity.concrete.support.CorreoElectronicoClienteEntityMapper;
import co.edu.uco.tiendaonline.service.mapper.entity.concrete.support.NombreCompletoClienteEntityMapper;
import co.edu.uco.tiendaonline.service.mapper.entity.concrete.support.NumeroTelefonoMovilClienteEntityMapper;

public final class ClienteEntityMapper implements EntityMapper<ClienteEntity, ClienteDomain>{

	private static final EntityMapper<ClienteEntity, ClienteDomain> instancia = new ClienteEntityMapper();
	
	private ClienteEntityMapper() {
		super();
	}
	
	@Override
	public final ClienteDomain toDomain(final ClienteEntity entity) {
		if(UtilObjeto.esNulo(entity)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000004);
			var mensajeTecnico = "Se ha presentado un problena en el metodo toDomain .No es posible mapear un cliente diminio a partir de un tipo de identificacion entity nula";
			throw ServiceTiendaOnlineException.crear(mensajeUsuario,mensajeTecnico);
		}
		return ClienteDomain.crear(entity.getId(),TipoIdentificacionEntityMapper.convertToDomain(entity.getTipoidentificacion()),entity.getIdentificacion(),NombreCompletoClienteEntityMapper.convertToDomain(entity.getNombreCompleto()),CorreoElectronicoClienteEntityMapper.convertToDomain(entity.getCorreoElectornico()),NumeroTelefonoMovilClienteEntityMapper.convertToDomain(entity.getNumeroTelefonoMovil()),entity.getFechaNacimiento());
	}
	
	@Override
	public final ClienteEntity toEntity(final ClienteDomain domain) {
		if(UtilObjeto.esNulo(domain)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000004);
			var mensajeTecnico = "Se ha presentado un problena en el metodo toEntity .No es posible mapear un cliente diminio a partir de un tipo de identificacion entity nula";
			throw ServiceTiendaOnlineException.crear(mensajeUsuario,mensajeTecnico);
		}
		return ClienteEntity.crear(domain.getId(),TipoIdentificacionEntityMapper.convertToEntity(domain.getTipoidentificacion()),domain.getIdentificacion(),NombreCompletoClienteEntityMapper.convertToEntity(domain.getNombreCompleto()),CorreoElectronicoClienteEntityMapper.convertToEntity(domain.getCorreoElectornico()),NumeroTelefonoMovilClienteEntityMapper.convertToEntity(domain.getNumeroTelefonoMovil()),domain.getFechaNacimiento());
	
	}
	
	public static final ClienteDomain convertToDomain(final ClienteEntity entity) {
		return instancia.toDomain(entity);
	}
	
	public static final ClienteEntity convertToEntity(final ClienteDomain domain) {
		return instancia.toEntity(domain);
	}

}
