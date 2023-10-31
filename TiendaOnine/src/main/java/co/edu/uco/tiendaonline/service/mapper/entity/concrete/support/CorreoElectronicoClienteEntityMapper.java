package co.edu.uco.tiendaonline.service.mapper.entity.concrete.support;

import co.edu.uco.tiendaonline.crosscutting.exception.concrete.ServiceTiendaOnlineException;
import co.edu.uco.tiendaonline.crosscutting.messages.CatalogoMensajes;
import co.edu.uco.tiendaonline.crosscutting.messages.enumerator.CodigoMensaje;
import co.edu.uco.tiendaonline.crosscutting.util.UtilObjeto;
import co.edu.uco.tiendaonline.service.domain.cliente.support.CorreoElectronicoClienteDomain;
import co.edu.uco.tiendaonline.service.mapper.entity.EntityMapper;
import co.edu.uco.tiendaonline.data.entity.support.CorreoElectronicoClienteEntity;

public class CorreoElectronicoClienteEntityMapper implements EntityMapper<CorreoElectronicoClienteEntity, CorreoElectronicoClienteDomain>{
	private static final EntityMapper<CorreoElectronicoClienteEntity, CorreoElectronicoClienteDomain> instancia = new CorreoElectronicoClienteEntityMapper();
	
	private CorreoElectronicoClienteEntityMapper() {
		super();
	}
	
	@Override
	public final CorreoElectronicoClienteDomain toDomain(final CorreoElectronicoClienteEntity entity) {
		if(UtilObjeto.esNulo(entity)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000004);
			var mensajeTecnico = "Se ha presentado un problena en el metodo toDomain .No es posible mapear un tipo de identificacion diminio a partir de un tipo de identificacion entity nula";
			throw ServiceTiendaOnlineException.crear(mensajeUsuario,mensajeTecnico);
		}
		return CorreoElectronicoClienteDomain.crear(entity.getCorreoElectronico(),entity.isCorreoElectronicoConfirmado());
	}
	
	@Override
	public final CorreoElectronicoClienteEntity toEntity(final CorreoElectronicoClienteDomain domain) {
		if(UtilObjeto.esNulo(domain)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000004);
			var mensajeTecnico = "Se ha presentado un problena en el metodo toEntity .No es posible mapear un tipo de identificacion diminio a partir de un tipo de identificacion entity nula";
			throw ServiceTiendaOnlineException.crear(mensajeUsuario,mensajeTecnico);
		}
		return CorreoElectronicoClienteEntity.crear(domain.getCorreoElectronico(),domain.isCorreoElectronicoConfirmado());
	
	}
	
	public static final CorreoElectronicoClienteDomain convertToDomain(final CorreoElectronicoClienteEntity entity) {
		return instancia.toDomain(entity);
	}
	
	public static final CorreoElectronicoClienteEntity convertToEntity(final CorreoElectronicoClienteDomain domain) {
		return instancia.toEntity(domain);
	}
	
}
