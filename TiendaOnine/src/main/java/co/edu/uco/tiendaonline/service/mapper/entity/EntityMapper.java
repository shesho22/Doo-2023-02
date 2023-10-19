package co.edu.uco.tiendaonline.service.mapper.entity;

import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitterReturnValueHandler;

import co.edu.uco.tiendaonline.data.entity.TipoIdentificacionEntity;

public interface EntityMapper<E,D> {
	D toDomain(E entity);
	E toEntity(D domain);
}
