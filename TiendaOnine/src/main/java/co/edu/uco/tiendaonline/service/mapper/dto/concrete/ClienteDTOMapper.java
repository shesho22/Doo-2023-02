package co.edu.uco.tiendaonline.service.mapper.dto.concrete;

import co.edu.uco.tiendaonline.service.domain.cliente.ClienteDomain;
import co.edu.uco.tiendaonline.service.dto.ClienteDTO;
import co.edu.uco.tiendaonline.service.mapper.dto.DTOMapper;

public final class ClienteDTOMapper implements DTOMapper<ClienteDTO, ClienteDomain>{

private static final DTOMapper<ClienteDTO, ClienteDomain> instancia = new ClienteDTOMapper();
	
	private ClienteDTOMapper() {
		super();
	}
	
	@Override
	public ClienteDomain toDomain(ClienteDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ClienteDTO toDTO(ClienteDomain domain) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public static final ClienteDomain convertirToDomain(final ClienteDTO dto) {
		return instancia.toDomain(dto);
	}
	
	public static final ClienteDTO convertirToDTO(final ClienteDomain domain) {
		return instancia.toDTO(domain);
	}

}
