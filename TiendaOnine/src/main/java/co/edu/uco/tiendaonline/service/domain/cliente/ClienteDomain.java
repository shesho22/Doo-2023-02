package co.edu.uco.tiendaonline.service.domain.cliente;

import java.time.LocalDate;
import java.util.UUID;


import co.edu.uco.tiendaonline.service.domain.cliente.support.CorreoElectronicoClienteDomain;
import co.edu.uco.tiendaonline.service.domain.cliente.support.NombreCompletoClienteDomain;
import co.edu.uco.tiendaonline.service.domain.cliente.support.NumeroTelefonoMovilClienteDomain;
import co.edu.uco.tiendaonline.service.domain.tipoidentificacion.TipoIdentificacionDomain;

public class ClienteDomain {
	
	private UUID id; 
	private TipoIdentificacionDomain tipoidentificacion;
	private String identificacion;
	private NombreCompletoClienteDomain nombreCompleto;
	private CorreoElectronicoClienteDomain correoElectornico;
	private NumeroTelefonoMovilClienteDomain numeroTelefonoMovil;
	private LocalDate fechaNacimiento;
	
	
	public ClienteDomain(final UUID id,final TipoIdentificacionDomain tipoIdentificacion,final String identificacion,final NombreCompletoClienteDomain nombreCompleto,final CorreoElectronicoClienteDomain correoElectronico,final NumeroTelefonoMovilClienteDomain numeroTelefonoMovil,final LocalDate fechaNacimiento) {
		setId(id);
		setTipoidentificacion(tipoIdentificacion);
		setIdentificacion(identificacion);
		setNombreCompleto(nombreCompleto);
		setCorreoElectornico(correoElectronico);
		setNumeroTelefonoMovil(numeroTelefonoMovil);
		setFechaNacimiento(fechaNacimiento);
	}
	
	public static final ClienteDomain crear(final UUID id,final TipoIdentificacionDomain tipoIdentificacion,final String identificacion,final NombreCompletoClienteDomain nombreCompleto,final CorreoElectronicoClienteDomain correoElectronico,final NumeroTelefonoMovilClienteDomain numeroTelefonoMovil,final LocalDate fechaNacimiento) {
		return new ClienteDomain(id, tipoIdentificacion, identificacion, nombreCompleto, correoElectronico, numeroTelefonoMovil, fechaNacimiento);
	} 
	
	public final UUID getId() {
		return id;
	}
	public final ClienteDomain setId(final UUID id) {
		this.id = id;
		return this;
	}

	public final TipoIdentificacionDomain getTipoidentificacion() {
		return tipoidentificacion;
	}

	public final ClienteDomain setTipoidentificacion(final TipoIdentificacionDomain tipoidentificacion) {
		this.tipoidentificacion = tipoidentificacion;
		return this;
	}

	public final String getIdentificacion() {
		return identificacion;
	}

	public final ClienteDomain setIdentificacion(final String identificacion) {
		this.identificacion = identificacion;
		return this;
	}

	public final NombreCompletoClienteDomain getNombreCompleto() {
		return nombreCompleto;
	}

	public final ClienteDomain setNombreCompleto(final NombreCompletoClienteDomain nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
		return this;
	}

	public final CorreoElectronicoClienteDomain getCorreoElectornico() {
		return correoElectornico;
	}

	public final ClienteDomain setCorreoElectornico(final CorreoElectronicoClienteDomain correoElectornico) {
		this.correoElectornico = correoElectornico;
		return this;
	}

	public final NumeroTelefonoMovilClienteDomain getNumeroTelefonoMovil() {
		return numeroTelefonoMovil;
	}

	public final ClienteDomain setNumeroTelefonoMovil(final NumeroTelefonoMovilClienteDomain numeroTelefonoMovil) {
		this.numeroTelefonoMovil = numeroTelefonoMovil;
		return this;
	}

	public final LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public final ClienteDomain setFechaNacimiento(final LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
		return this;
	}

	

}
