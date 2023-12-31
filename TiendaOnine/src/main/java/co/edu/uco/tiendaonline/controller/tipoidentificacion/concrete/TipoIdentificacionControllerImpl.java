package co.edu.uco.tiendaonline.controller.tipoidentificacion.concrete;

import java.util.UUID;

import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ch.qos.logback.classic.Logger;
import co.edu.uco.tiendaonline.controller.support.response.Respuesta;
import co.edu.uco.tiendaonline.crosscutting.exception.TiendaOnlineException;
import co.edu.uco.tiendaonline.service.dto.TipoIdentificacionDTO;
import co.edu.uco.tiendaonline.service.facade.concrete.tipoidentificacion.RegistrarTipoIdentificacionFacade;

@RestController
@RequestMapping("/api/v1/tipoidentificacion")
public final class TipoIdentificacionControllerImpl {
	
	private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(TipoIdentificacionControllerImpl.class);
	
	
	@GetMapping("/dummy")
	public final TipoIdentificacionDTO obtenerDummy() {
		return TipoIdentificacionDTO.crear();
	}
	
	@GetMapping
	public final TipoIdentificacionDTO consultar(@RequestBody TipoIdentificacionDTO dto) {
		return dto;
	}
	
	@GetMapping("/{id}")
	public final UUID consiltarPorId(@PathVariable("id")UUID id) {
		return id;
	}
	
	
	@PostMapping
	public final TipoIdentificacionDTO registrar(@RequestBody TipoIdentificacionDTO dto) {
		Respuesta<TipoIdentificacionDTO> respuesta =new Respuesta<>();
		HttpStatus codigoHttp = HttpStatus.BAD_REQUEST;
		try {
			RegistrarTipoIdentificacionFacade facade = new RegistrarTipoIdentificacionFacade();
			facade.execute(dto);
			codigoHttp = HttpStatus.OK;
			respuesta.getMensajes().add("El tipo de identificacion fue registrado existosamente...");
			LOGGER.info("El tipo identificacion fue registrado exitosamente");
		} catch (final TiendaOnlineException exception) {
			respuesta.getMensajes().add(exception.getMensajeUsuario());
			LOGGER.error(exception.getMensajeTecnico(), exception.getExcepcionRaiz());
		}catch (final Exception exception) {
			codigoHttp = HttpStatus.INTERNAL_SERVER_ERROR;
			respuesta.getMensajes().add("Se ha presentado un problema inesperado tratando de tegistrar el tipo identificacion");
			LOGGER.error("Se ha presentado un problema inesperado tratando de tegistrar el tipo identificacion", exception);

		}
		
		return dto;
	}
	
	@PutMapping("/{id}")
	public final TipoIdentificacionDTO modificar(@PathVariable("id") UUID id,@RequestBody TipoIdentificacionDTO dto) {
		dto.setId(id);
		return dto;
	}
	

	@DeleteMapping ("/{id}")
	public final UUID eliminar(@PathVariable("id")UUID id) {
		return id;
	}
	
}
