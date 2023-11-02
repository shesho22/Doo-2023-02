package co.edu.uco.tiendaonline.service.mapper.dto.concrete.support;

import co.edu.uco.tiendaonline.crosscutting.exception.concrete.ServiceTiendaOnlineException;
import co.edu.uco.tiendaonline.crosscutting.messages.CatalogoMensajes;
import co.edu.uco.tiendaonline.crosscutting.messages.enumerator.CodigoMensaje;
import co.edu.uco.tiendaonline.crosscutting.util.UtilObjeto;
import co.edu.uco.tiendaonline.service.domain.cliente.support.NombreCompletoClienteDomain;
import co.edu.uco.tiendaonline.service.dto.support.NombreCompletoClienteDTO;
import co.edu.uco.tiendaonline.service.mapper.dto.DTOMapper;

public class NombreCompletoClienteDTOMapper implements DTOMapper<NombreCompletoClienteDTO, NombreCompletoClienteDomain >{

private static final DTOMapper<NombreCompletoClienteDTO, NombreCompletoClienteDomain> instancia = new NombreCompletoClienteDTOMapper();
	
	private NombreCompletoClienteDTOMapper() {
		super();
	}
	
	@Override
	public NombreCompletoClienteDomain toDomain(NombreCompletoClienteDTO dto) {
		if(UtilObjeto.esNulo(dto)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000004);
			var mensajeTecnico = "Se ha presentado un problena en el metodo toDomain .No es posible mapear un tipo de identificacion diminio a partir de un tipo de identificacion dto nula";
			throw ServiceTiendaOnlineException.crear(mensajeUsuario,mensajeTecnico);
		}
		return NombreCompletoClienteDomain.crear(dto.getPrimerNombre(),dto.getSegundoNombre(),dto.getPrimerApellido(),dto.getSegundoApellido());
	}

	@Override
	public NombreCompletoClienteDTO toDTO(NombreCompletoClienteDomain domain) {
		if(UtilObjeto.esNulo(domain)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000004);
			var mensajeTecnico = "Se ha presentado un problena en el metodo toDomain .No es posible mapear un tipo de identificacion diminio a partir de un tipo de identificacion domain nula";
			throw ServiceTiendaOnlineException.crear(mensajeUsuario,mensajeTecnico);
		}
		return NombreCompletoClienteDTO.crear(domain.getPrimerNombre(),domain.getSegundoNombre(),domain.getPrimerApellido(),domain.getSegundoApellido());
	}
	
	public static final NombreCompletoClienteDomain convertirToDomain(final NombreCompletoClienteDTO dto) {
		return instancia.toDomain(dto);
	}
	
	public static final NombreCompletoClienteDTO convertirToDTO(final NombreCompletoClienteDomain domain) {
		return instancia.toDTO(domain);
	}

}
