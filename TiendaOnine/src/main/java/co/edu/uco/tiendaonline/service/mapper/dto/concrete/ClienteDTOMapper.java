package co.edu.uco.tiendaonline.service.mapper.dto.concrete;

import co.edu.uco.tiendaonline.crosscutting.exception.concrete.ServiceTiendaOnlineException;
import co.edu.uco.tiendaonline.crosscutting.messages.CatalogoMensajes;
import co.edu.uco.tiendaonline.crosscutting.messages.enumerator.CodigoMensaje;
import co.edu.uco.tiendaonline.crosscutting.util.UtilObjeto;
import co.edu.uco.tiendaonline.service.domain.cliente.ClienteDomain;
import co.edu.uco.tiendaonline.service.domain.tipoidentificacion.TipoIdentificacionDomain;
import co.edu.uco.tiendaonline.service.dto.ClienteDTO;
import co.edu.uco.tiendaonline.service.dto.TipoIdentificacionDTO;
import co.edu.uco.tiendaonline.service.mapper.dto.DTOMapper;
import co.edu.uco.tiendaonline.service.mapper.dto.concrete.support.CorreoElectronicoClienteDTOMapper;
import co.edu.uco.tiendaonline.service.mapper.dto.concrete.support.NombreCompletoClienteDTOMapper;
import co.edu.uco.tiendaonline.service.mapper.dto.concrete.support.NumeroTelefonoMovilClienteDTOMapper;
import co.edu.uco.tiendaonline.service.mapper.entity.concrete.TipoIdentificacionEntityMapper;
import co.edu.uco.tiendaonline.service.mapper.entity.concrete.support.CorreoElectronicoClienteEntityMapper;
import co.edu.uco.tiendaonline.service.mapper.entity.concrete.support.NombreCompletoClienteEntityMapper;
import co.edu.uco.tiendaonline.service.mapper.entity.concrete.support.NumeroTelefonoMovilClienteEntityMapper;

public final class ClienteDTOMapper implements DTOMapper<ClienteDTO, ClienteDomain>{

private static final DTOMapper<ClienteDTO, ClienteDomain> instancia = new ClienteDTOMapper();
	
	private ClienteDTOMapper() {
		super();
	}
	
	@Override
	public ClienteDomain toDomain(ClienteDTO dto) {
		if(UtilObjeto.esNulo(dto)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000004);
			var mensajeTecnico = "Se ha presentado un problena en el metodo toDomain .No es posible mapear un tipo de identificacion diminio a partir de un tipo de identificacion dto nula";
			throw ServiceTiendaOnlineException.crear(mensajeUsuario,mensajeTecnico);
		}
		return ClienteDomain.crear(dto.getId(),TipoIdentificacionDTOMapper.convertirToDomain(dto.getTipoidentificacion()),dto.getIdentificacion(),NombreCompletoClienteDTOMapper.convertirToDomain(dto.getNombreCompleto()),CorreoElectronicoClienteDTOMapper.convertirToDomain(dto.getCorreoElectornico()),NumeroTelefonoMovilClienteDTOMapper.convertirToDomain(dto.getNumeroTelefonoMovil()),dto.getFechaNacimiento());

	}

	@Override
	public ClienteDTO toDTO(ClienteDomain domain) {
		if(UtilObjeto.esNulo(domain)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000004);
			var mensajeTecnico = "Se ha presentado un problena en el metodo toDomain .No es posible mapear un tipo de identificacion diminio a partir de un tipo de identificacion domain nula";
			throw ServiceTiendaOnlineException.crear(mensajeUsuario,mensajeTecnico);
		}
		return ClienteDTO.crear();
	}
	
	public static final ClienteDomain convertirToDomain(final ClienteDTO dto) {
		return instancia.toDomain(dto);
	}
	
	public static final ClienteDTO convertirToDTO(final ClienteDomain domain) {
		return instancia.toDTO(domain);
	}

}
