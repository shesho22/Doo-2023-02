package co.edu.uco.tiendaonline.service.mapper.dto.concrete.support;

import co.edu.uco.tiendaonline.crosscutting.exception.concrete.ServiceTiendaOnlineException;
import co.edu.uco.tiendaonline.crosscutting.messages.CatalogoMensajes;
import co.edu.uco.tiendaonline.crosscutting.messages.enumerator.CodigoMensaje;
import co.edu.uco.tiendaonline.crosscutting.util.UtilObjeto;
import co.edu.uco.tiendaonline.service.domain.cliente.support.NumeroTelefonoMovilClienteDomain;
import co.edu.uco.tiendaonline.service.dto.support.NumeroTelefonoMovilClienteDTO;
import co.edu.uco.tiendaonline.service.mapper.dto.DTOMapper;

public class NumeroTelefonoMovilClienteDTOMapper implements DTOMapper<NumeroTelefonoMovilClienteDTO, NumeroTelefonoMovilClienteDomain>{

private static final DTOMapper<NumeroTelefonoMovilClienteDTO, NumeroTelefonoMovilClienteDomain> instancia = new NumeroTelefonoMovilClienteDTOMapper();
	
	private NumeroTelefonoMovilClienteDTOMapper() {
		super();
	}
	
	@Override
	public NumeroTelefonoMovilClienteDomain toDomain(NumeroTelefonoMovilClienteDTO dto) {
		if(UtilObjeto.esNulo(dto)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000004);
			var mensajeTecnico = "Se ha presentado un problena en el metodo toDomain .No es posible mapear un tipo de identificacion diminio a partir de un tipo de identificacion dto nula";
			throw ServiceTiendaOnlineException.crear(mensajeUsuario,mensajeTecnico);
		}
		return NumeroTelefonoMovilClienteDomain.crear(dto.getNumeroTelefonoMovil(),dto.isNumeroTelefonoMovilConfirmado());
	}

	@Override
	public NumeroTelefonoMovilClienteDTO toDTO(NumeroTelefonoMovilClienteDomain domain) {
		if(UtilObjeto.esNulo(domain)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000004);
			var mensajeTecnico = "Se ha presentado un problena en el metodo toDomain .No es posible mapear un tipo de identificacion diminio a partir de un tipo de identificacion domain nula";
			throw ServiceTiendaOnlineException.crear(mensajeUsuario,mensajeTecnico);
		}
		return NumeroTelefonoMovilClienteDTO.crear(domain.getNumeroTelefonoMovil(),domain.isNumeroTelefonoMovilConfirmado());
	}
	
	public static final NumeroTelefonoMovilClienteDomain convertirToDomain(final NumeroTelefonoMovilClienteDTO dto) {
		return instancia.toDomain(dto);
	}
	
	public static final NumeroTelefonoMovilClienteDTO convertirToDTO(final NumeroTelefonoMovilClienteDomain domain) {
		return instancia.toDTO(domain);
	}

}
