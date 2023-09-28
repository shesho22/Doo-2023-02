package co.edu.uco.tiendaonline.data.entity;

import java.sql.Date;
import java.util.UUID;

import co.edu.uco.tiendaonline.data.entity.support.CorreoElectronicoClienteEntity;
import co.edu.uco.tiendaonline.data.entity.support.NombreCompletoClienteEntity;
import co.edu.uco.tiendaonline.data.entity.support.NumeroTelefonoMovilClienteEntity;


public final  class ClienteEntity {
	private UUID id; 
	private TipoIdentificacionEntity tipoidentificacion;
	private String identificacion;
	private NombreCompletoClienteEntity nombreCompleto;
	private CorreoElectronicoClienteEntity correoElectornico;
	private NumeroTelefonoMovilClienteEntity numeroTelefonoMovil;
	private Date fechaNacimiento;
	
	
	
	
	private ClienteEntity(final UUID id, final TipoIdentificacionEntity tipoidentificacion, final String identificacion, final NombreCompletoClienteEntity nombreCompleto, final CorreoElectronicoClienteEntity correoElectornico,
			final NumeroTelefonoMovilClienteEntity numeroTelefonoMovil,final Date fechaNacimiento) {
		setId(id);
		setTipoidentificacion(tipoidentificacion);
		setIdentificacion(identificacion);
		setNombreCompleto(nombreCompleto);
		setCorreoElectornico(correoElectornico);
		setNumeroTelefonoMovil(numeroTelefonoMovil);
		setFechaNacimiento(fechaNacimiento);
	}
	
	public static final ClienteEntity crear(final UUID id, final TipoIdentificacionEntity tipoidentificacion, final String identificacion, final NombreCompletoClienteEntity nombreCompleto, final CorreoElectronicoClienteEntity correoElectornico,
			final NumeroTelefonoMovilClienteEntity numeroTelefonoMovil,final Date fechaNacimiento) {
		return new ClienteEntity(id, tipoidentificacion, identificacion, nombreCompleto, correoElectornico, numeroTelefonoMovil,fechaNacimiento);
	}
	

	private final void setId(final UUID id) {
		this.id = id;
	}
	private final void setTipoidentificacion(final TipoIdentificacionEntity tipoidentificacion) {
		this.tipoidentificacion = tipoidentificacion;
	}
	private final void setIdentificacion(final String identificacion) {
		this.identificacion = identificacion;
	}
	private final void setNombreCompleto(final NombreCompletoClienteEntity nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}
	
	private final void setCorreoElectornico(final CorreoElectronicoClienteEntity correoElectornico) {
		this.correoElectornico = correoElectornico;
	}

	private final void setNumeroTelefonoMovil(final NumeroTelefonoMovilClienteEntity numeroTelefonoMovil) {
		this.numeroTelefonoMovil = numeroTelefonoMovil;
	}

	private final void setFechaNacimiento(final Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public final UUID getId() {
		return id;
	}
	public final TipoIdentificacionEntity getTipoidentificacion() {
		return tipoidentificacion;
	}
	public final String getIdentificacion() {
		return identificacion;
	}
	public final NombreCompletoClienteEntity getNombreCompleto() {
		return nombreCompleto;
	}

	public final CorreoElectronicoClienteEntity getCorreoElectornico() {
		return correoElectornico;
	}

	public final NumeroTelefonoMovilClienteEntity getNumeroTelefonoMovil() {
		return numeroTelefonoMovil;
	}

	public final Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	
	
	
}
