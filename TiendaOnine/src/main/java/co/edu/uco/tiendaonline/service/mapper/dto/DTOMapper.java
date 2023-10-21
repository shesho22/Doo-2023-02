package co.edu.uco.tiendaonline.service.mapper.dto;

public interface DTOMapper <T,D>{
	D toDomain(T dto);
	T toDTO(D domain);
}
