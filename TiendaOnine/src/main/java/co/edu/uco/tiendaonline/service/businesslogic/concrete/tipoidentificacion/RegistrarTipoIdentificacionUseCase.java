package co.edu.uco.tiendaonline.service.businesslogic.concrete.tipoidentificacion;

import java.util.Optional;
import java.util.UUID;

import co.edu.uco.tiendaonline.crosscutting.exception.concrete.ServiceTiendaOnlineException;
import co.edu.uco.tiendaonline.crosscutting.util.UtilObjeto;
import co.edu.uco.tiendaonline.data.dao.TipoIdentificacionDAO;
import co.edu.uco.tiendaonline.data.dao.daofactory.DAOFactory;
import co.edu.uco.tiendaonline.data.entity.TipoIdentificacionEntity;
import co.edu.uco.tiendaonline.service.businesslogic.UseCase;
import co.edu.uco.tiendaonline.service.domain.TipoIdentificacionDomain;
import co.edu.uco.tiendaonline.service.mapper.entity.concrete.TipoIdentificacionEntityMapper;

public final class RegistrarTipoIdentificacionUseCase implements UseCase<TipoIdentificacionDomain>{

	private DAOFactory factoria;
	

	public RegistrarTipoIdentificacionUseCase(final DAOFactory factoria) {
		setFatoria(factoria);
	}
	
	

	@Override
	public void execute(TipoIdentificacionDomain domain) {
		//1. validad integridad de datos (tipo,longitud,obligatoriedad, formato ,etc)
		//todo: como lograr el paso 1 
		//tipo identificacion casos de uso crud 
		//cliente casos casos de uso crud 
		
		
		
		//2.No debe existir otro tipo de identificacion con el mismo codigo
		validarNoExistenciaTipoIdentificacionConMismoCodigo(domain.getCodigo());
		
		//3.No debe existir otro tipo de identificacion con el mismo nombre 
		validarNoExistenciaTipoIdentificacionConMismoNombre(domain.getNombre());
		
		//4.No debe existir otro tipo de identificacion con el mismo identificador
				domain = obtenerIdentificadorTipoIdentificacion(domain);
		
		//5. registrar el nuevo tipo de identificacion 
		registrarNuevoTipoIdentificacion(domain);
	}

	private void registrarNuevoTipoIdentificacion(final TipoIdentificacionDomain domain) {
		var entity = TipoIdentificacionEntityMapper.convertToEntity(domain);
		getTipoIdentificacionDAO().crear(entity);
	}

	private final void validarNoExistenciaTipoIdentificacionConMismoNombre(final String nombre) {
		//todo: lograr que esto no quede tan feo 
		
		var domain = TipoIdentificacionDomain.crear(null, null, nombre, false);
		var entity=TipoIdentificacionEntityMapper.convertToEntity(domain);
		var resultados = getTipoIdentificacionDAO().consultar(entity);
		
		if(!resultados.isEmpty()) {
			var mensajeUsuario = "Ya existe un tipo de identificacion con el nombre "+nombre;
			throw ServiceTiendaOnlineException.crear(mensajeUsuario);
		}
	}
	
	private final void validarNoExistenciaTipoIdentificacionConMismoCodigo(final String codigo) {
		//todo: lograr que esto no quede tan feo 
		
		var domain = TipoIdentificacionDomain.crear(null, codigo, null, false);
		var entity=TipoIdentificacionEntityMapper.convertToEntity(domain);
		var resultados = getTipoIdentificacionDAO().consultar(entity);
		
		if(!resultados.isEmpty()) {
			var mensajeUsuario = "Ya existe un tipo de identificacion con el codigo "+codigo;
			throw ServiceTiendaOnlineException.crear(mensajeUsuario);
		}
	}
	
private final TipoIdentificacionDomain obtenerIdentificadorTipoIdentificacion(final TipoIdentificacionDomain domain) {
	Optional<TipoIdentificacionEntity> optional = Optional.empty();
	UUID uuid;
	do {
		uuid = UUID.randomUUID();
		optional = getTipoIdentificacionDAO().consultarPorId(uuid);
	}while(optional.isPresent());
	return TipoIdentificacionDomain.crear(uuid, domain.getCodigo(), domain.getNombre(), domain.isEstado());
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

	private final TipoIdentificacionDAO getTipoIdentificacionDAO() {
		return getFactoria().obtenerTipoIdentificacionDAO();
	}




	

}
