package co.edu.uco.tiendaonline.service.mapper.entity.concrete.support;

import co.edu.uco.tiendaonline.crosscutting.exception.concrete.ServiceTiendaOnlineException;
import co.edu.uco.tiendaonline.crosscutting.messages.CatalogoMensajes;
import co.edu.uco.tiendaonline.crosscutting.messages.enumerator.CodigoMensaje;
import co.edu.uco.tiendaonline.crosscutting.util.UtilObjeto;
import co.edu.uco.tiendaonline.service.domain.cliente.support.NombreCompletoClienteDomain;
import co.edu.uco.tiendaonline.service.mapper.entity.EntityMapper;
import co.edu.uco.tiendaonline.data.entity.support.NombreCompletoClienteEntity;

public final class NombreCompletoClienteEntityMapper implements EntityMapper<NombreCompletoClienteEntity, NombreCompletoClienteDomain>{
	private static final EntityMapper<NombreCompletoClienteEntity, NombreCompletoClienteDomain> instancia = new NombreCompletoClienteEntityMapper();
	
	private NombreCompletoClienteEntityMapper() {
		super();
	}
	
	@Override
	public final NombreCompletoClienteDomain toDomain(final NombreCompletoClienteEntity entity) {
		if(UtilObjeto.esNulo(entity)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000004);
			var mensajeTecnico = "Se ha presentado un problena en el metodo toDomain .No es posible mapear un tipo de identificacion diminio a partir de un tipo de identificacion entity nula";
			throw ServiceTiendaOnlineException.crear(mensajeUsuario,mensajeTecnico);
		}
		return NombreCompletoClienteDomain.crear(entity.getPrimerNombre(),entity.getSegundoNombre(),entity.getPrimerApellido(),entity.getSegundoApellido());
	}
	
	@Override
	public final NombreCompletoClienteEntity toEntity(final NombreCompletoClienteDomain domain) {
		if(UtilObjeto.esNulo(domain)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000004);
			var mensajeTecnico = "Se ha presentado un problena en el metodo toEntity .No es posible mapear un tipo de identificacion diminio a partir de un tipo de identificacion entity nula";
			throw ServiceTiendaOnlineException.crear(mensajeUsuario,mensajeTecnico);
		}
		return NombreCompletoClienteEntity.crear(domain.getPrimerNombre(),domain.getSegundoNombre(),domain.getPrimerApellido(),domain.getSegundoApellido());
	
	}
	
	public static final NombreCompletoClienteDomain convertToDomain(final NombreCompletoClienteEntity entity) {
		return instancia.toDomain(entity);
	}
	
	public static final NombreCompletoClienteEntity convertToEntity(final NombreCompletoClienteDomain domain) {
		return instancia.toEntity(domain);
	}
}
