package co.edu.uco.tiendaonline.controller.tipoidentificacion;

import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import co.edu.uco.tiendaonline.controller.support.response.Respuesta;
import co.edu.uco.tiendaonline.service.dto.TipoIdentificacionDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "TipoIdentificacionAPI", description = "Ofrece las api de consumo para todas las operaciones relacionadas con tipo identificacio")
public interface TipoIdentificacionController {

	@Operation(summary = "Obtener dummy", description = "Servicio encargado de obtener la estructura json")
	TipoIdentificacionDTO obtenerDummy();

	
	@Operation(summary = "Consultar", description = "Servicio encargado de obtener la informacion de todos los tipos de identificacion que cumplen los parametros")
	@ApiResponses(value = { 
			@ApiResponse(responseCode = "200", description = "Tipo de identificacion registrada exisotamente"),
			@ApiResponse(responseCode = "400", description = "Tipo identificacion no registrado exisotamente"),
			@ApiResponse(responseCode = "500", description = "Tipo identificacion no registrado exisotamente por un problema inesperado")})	
	ResponseEntity<Respuesta<TipoIdentificacionDTO>>  consultar(@RequestBody TipoIdentificacionDTO dto);
	
	@Operation(summary = "Consultarporid", description = "Servicio encargado de obtener la indormacion de tipo identificacion con el id ")
	ResponseEntity<Respuesta<TipoIdentificacionDTO>> consiltarPorId(@PathVariable("id")UUID id);
	
	@Operation(summary = "Registrar", description = "DescripciónOperación")
	ResponseEntity<Respuesta<TipoIdentificacionDTO>> registrar(@RequestBody TipoIdentificacionDTO dto);
	
	@Operation(summary = "Modificar", description = "DescripciónOperación")
	ResponseEntity<Respuesta<TipoIdentificacionDTO>> modificar(@PathVariable("id") UUID id,@RequestBody TipoIdentificacionDTO dto);

	@Operation(summary = "Eliminar", description = "DescripciónOperación")
	ResponseEntity<Respuesta<TipoIdentificacionDTO>> eliminar(@PathVariable("id")UUID id);
	
}
