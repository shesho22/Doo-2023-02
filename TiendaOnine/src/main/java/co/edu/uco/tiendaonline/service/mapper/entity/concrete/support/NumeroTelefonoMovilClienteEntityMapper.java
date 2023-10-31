package co.edu.uco.tiendaonline.service.mapper.entity.concrete.support;

import co.edu.uco.tiendaonline.crosscutting.exception.concrete.ServiceTiendaOnlineException;
import co.edu.uco.tiendaonline.crosscutting.messages.CatalogoMensajes;
import co.edu.uco.tiendaonline.crosscutting.messages.enumerator.CodigoMensaje;
import co.edu.uco.tiendaonline.crosscutting.util.UtilObjeto;
import co.edu.uco.tiendaonline.data.entity.support.NumeroTelefonoMovilClienteEntity;
import co.edu.uco.tiendaonline.service.domain.cliente.support.NumeroTelefonoMovilClienteDomain;
import co.edu.uco.tiendaonline.service.mapper.entity.EntityMapper;

public class NumeroTelefonoMovilClienteEntityMapper implements EntityMapper<NumeroTelefonoMovilClienteEntity, NumeroTelefonoMovilClienteDomain>{
	private static final EntityMapper<NumeroTelefonoMovilClienteEntity, NumeroTelefonoMovilClienteDomain> instancia = new NumeroTelefonoMovilClienteEntityMapper();
	
	private NumeroTelefonoMovilClienteEntityMapper() {
		super();
	}
	
	@Override
	public final NumeroTelefonoMovilClienteDomain toDomain(final NumeroTelefonoMovilClienteEntity entity) {
		if(UtilObjeto.esNulo(entity)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000004);
			var mensajeTecnico = "Se ha presentado un problena en el metodo toDomain .No es posible mapear un tipo de identificacion diminio a partir de un tipo de identificacion entity nula";
			throw ServiceTiendaOnlineException.crear(mensajeUsuario,mensajeTecnico);
		}
		return NumeroTelefonoMovilClienteDomain.crear(entity.getNumeroTelefonoMovil(),entity.isNumeroTelefonoMovilConfirmado());
	}
	
	@Override
	public final NumeroTelefonoMovilClienteEntity toEntity(final NumeroTelefonoMovilClienteDomain domain) {
		if(UtilObjeto.esNulo(domain)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000004);
			var mensajeTecnico = "Se ha presentado un problena en el metodo toEntity .No es posible mapear un tipo de identificacion diminio a partir de un tipo de identificacion entity nula";
			throw ServiceTiendaOnlineException.crear(mensajeUsuario,mensajeTecnico);
		}
		return NumeroTelefonoMovilClienteEntity.crear(domain.getNumeroTelefonoMovil(),domain.isNumeroTelefonoMovilConfirmado());
	
	}
	
	public static final NumeroTelefonoMovilClienteDomain convertToDomain(final NumeroTelefonoMovilClienteEntity entity) {
		return instancia.toDomain(entity);
	}
	
	public static final NumeroTelefonoMovilClienteEntity convertToEntity(final NumeroTelefonoMovilClienteDomain domain) {
		return instancia.toEntity(domain);
	}
	
}
