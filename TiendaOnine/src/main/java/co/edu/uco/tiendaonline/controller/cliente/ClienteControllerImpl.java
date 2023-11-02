package co.edu.uco.tiendaonline.controller.cliente;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uco.tiendaonline.controller.support.response.Respuesta;
import co.edu.uco.tiendaonline.crosscutting.exception.TiendaOnlineException;
import co.edu.uco.tiendaonline.data.dao.ClienteDAO;
import co.edu.uco.tiendaonline.service.dto.ClienteDTO;
import co.edu.uco.tiendaonline.service.dto.TipoIdentificacionDTO;
import co.edu.uco.tiendaonline.service.facade.concrete.cliente.RegistrarClienteFacade;

@RestController
@RequestMapping("/api/v1/cliente")
public final class ClienteControllerImpl {
	
	
	@GetMapping("/dummy")
	public final ClienteDTO obtenerDummy() {
		return ClienteDTO.crear();
	}
	
	@GetMapping
	public final ClienteDAO consultar(@RequestBody ClienteDTO dto) {
		return (ClienteDAO) dto;
	}
	@GetMapping("/{id}")
	public final UUID consiltarPorId(@PathVariable("id")UUID id) {
		return id;
	}
	
	
	@PostMapping
	public final ClienteDTO registrar(@RequestBody ClienteDTO dto) {
		Respuesta<TipoIdentificacionDTO> respuesta =new Respuesta<>();
		HttpStatus codigoHttp = HttpStatus.BAD_REQUEST;
		try {
			RegistrarClienteFacade facade = new RegistrarClienteFacade();
			facade.execute(dto);
			codigoHttp = HttpStatus.OK;
			respuesta.getMensajes().add("El cliente fue registrado existosamente...");
		} catch (final TiendaOnlineException exception) {
			respuesta.getMensajes().add(exception.getMensajeUsuario());
			System.err.println(exception.getMensajeTecnico());
			System.err.println(exception.getLugar());
			exception.getExcepcionRaiz().printStackTrace();
			// TODO: handle exception
		}catch (final Exception exception) {
			respuesta.getMensajes().add("Se ha presentado un problema inesperado tratando de tegistrar el tipo identificacion");
			exception.printStackTrace();
			// TODO: handle exception
		}
		
		return dto;
	}
	
	@PutMapping
	public final ClienteDTO modificar(@PathVariable("id") UUID id,@RequestBody ClienteDTO dto) {
		dto.setId(id);
		return dto;
	}
	

	@DeleteMapping ("/{id}")
	public final UUID eliminar(@PathVariable("id")UUID id) {
		return id;
	}
	
}
