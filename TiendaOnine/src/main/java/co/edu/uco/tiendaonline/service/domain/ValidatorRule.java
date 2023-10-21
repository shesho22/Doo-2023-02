package co.edu.uco.tiendaonline.service.domain;

public interface ValidatorRule<T> {
	void validar(T dato);
}
