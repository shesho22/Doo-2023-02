package co.edu.uco.tiendaonline.service.mapper.dto.concrete;

import co.edu.uco.tiendaonline.crosscutting.exception.concrete.ServiceTiendaOnlineException;
import co.edu.uco.tiendaonline.crosscutting.messages.CatalogoMensajes;
import co.edu.uco.tiendaonline.crosscutting.messages.enumerator.CodigoMensaje;
import co.edu.uco.tiendaonline.crosscutting.util.UtilObjeto;
import co.edu.uco.tiendaonline.service.domain.tipoidentificacion.TipoIdentificacionDomain;
import co.edu.uco.tiendaonline.service.dto.TipoIdentificacionDTO;
import co.edu.uco.tiendaonline.service.mapper.dto.DTOMapper;

public final class TipoIdentificacionDTOMapper implements DTOMapper<TipoIdentificacionDTO, TipoIdentificacionDomain>{

private static final DTOMapper<TipoIdentificacionDTO, TipoIdentificacionDomain> instancia = new TipoIdentificacionDTOMapper();
	
	private TipoIdentificacionDTOMapper() {
		super();
	}
	
	@Override
	public TipoIdentificacionDomain toDomain(TipoIdentificacionDTO dto) {
		if(UtilObjeto.esNulo(dto)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000004);
			var mensajeTecnico = "Se ha presentado un problena en el metodo toDomain .No es posible mapear un tipo de identificacion diminio a partir de un tipo de identificacion dto nula";
			throw ServiceTiendaOnlineException.crear(mensajeUsuario,mensajeTecnico);
		}
		return TipoIdentificacionDomain.crear(dto.getId(), dto.getCodigo(), dto.getNombre(), dto.isEstado());
	}

	@Override
	public TipoIdentificacionDTO toDTO(TipoIdentificacionDomain domain) {
		if(UtilObjeto.esNulo(domain)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000004);
			var mensajeTecnico = "Se ha presentado un problena en el metodo toDomain .No es posible mapear un tipo de identificacion diminio a partir de un tipo de identificacion domain nula";
			throw ServiceTiendaOnlineException.crear(mensajeUsuario,mensajeTecnico);
		}
		return TipoIdentificacionDTO.crear();
	}
	
	public static final TipoIdentificacionDomain convertirToDomain(final TipoIdentificacionDTO dto) {
		return instancia.toDomain(dto);
	}
	
	public static final TipoIdentificacionDTO convertirToDTO(final TipoIdentificacionDomain domain) {
		return instancia.toDTO(domain);
	}

}
