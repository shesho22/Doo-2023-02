package co.edu.uco.tiendaonline.service.dto;

import java.sql.Date;
import java.util.UUID;

import co.edu.uco.tiendaonline.crosscutting.util.UtilTexto;
import co.edu.uco.tiendaonline.data.entity.TipoIdentificacionEntity;
import co.edu.uco.tiendaonline.data.entity.support.CorreoElectronicoClienteEntity;
import co.edu.uco.tiendaonline.data.entity.support.NombreCompletoClienteEntity;
import co.edu.uco.tiendaonline.data.entity.support.NumeroTelefonoMovilClienteEntity;

public class ClienteDTO {
	private UUID id; 
	private TipoIdentificacionDTO tipoidentificacion;
	private String identificacion;
	private NombreCompletoClienteEntity nombreCompleto;
	private CorreoElectronicoClienteEntity correoElectornico;
	private NumeroTelefonoMovilClienteEntity numeroTelefonoMovil;
	private Date fechaNacimiento;
	
	
	public ClienteDTO() {
		setId(id); //todo 
		setTipoidentificacion(new TipoIdentificacionDTO());
		setIdentificacion(UtilTexto.VACIO);
		setNombreCompleto(new NombreCompletoClienteDTO());
		setCorreoElectornico(new CorreoElectronicoClienteDTO());
		setNumeroTelefonoMovil(new NumeroTelefonoMovilClienteDTO());
		setFechaNacimiento(fechaNacimiento);//todo: fecha por defecto que no es valida y facilmente identificable
	}
	
	public ClienteDTO(final UUID id,final TipoIdentificacionDTO tipoidentificacion,final String identificacion,
			final NombreCompletoClienteEntity nombreCompleto,final CorreoElectronicoClienteEntity correoElectornico,
			final NumeroTelefonoMovilClienteEntity numeroTelefonoMovil,final Date fechaNacimiento) {
		setId(id);
		setTipoidentificacion(tipoidentificacion);
		setIdentificacion(identificacion);
		setNombreCompleto(nombreCompleto);
		setCorreoElectornico(correoElectornico);
		setNumeroTelefonoMovil(numeroTelefonoMovil);
		setFechaNacimiento(fechaNacimiento);
	}
	
	
	public static final ClienteDTO crear() {
		return new ClienteDTO();
	}
	
	public final UUID getId() {
		return id;
	}
	public final ClienteDTO setId(final UUID id) {
		this.id = id;
		return this;
	}
	public final TipoIdentificacionDTO getTipoidentificacion() {
		return tipoidentificacion;
	}
	public final ClienteDTO setTipoidentificacion(final TipoIdentificacionDTO tipoidentificacion) {
		this.tipoidentificacion = tipoidentificacion;
		return this;
	}
	public final String getIdentificacion() {
		return identificacion;
	}
	public final ClienteDTO setIdentificacion(final String identificacion) {
		this.identificacion = identificacion;
		return this;
	}
	public final NombreCompletoClienteEntity getNombreCompleto() {
		return nombreCompleto;
	}
	public final ClienteDTO setNombreCompleto(final NombreCompletoClienteEntity nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
		return this;
	}
	public final CorreoElectronicoClienteEntity getCorreoElectornico() {
		return correoElectornico;
	}
	public final ClienteDTO setCorreoElectornico(final CorreoElectronicoClienteEntity correoElectornico) {
		this.correoElectornico = correoElectornico;
		return this;
	}
	public final NumeroTelefonoMovilClienteEntity getNumeroTelefonoMovil() {
		return numeroTelefonoMovil;
	}
	public final ClienteDTO setNumeroTelefonoMovil(final NumeroTelefonoMovilClienteEntity numeroTelefonoMovil) {
		this.numeroTelefonoMovil = numeroTelefonoMovil;
		return this;
	}
	public final Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public final ClienteDTO setFechaNacimiento(final Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
		return this;
	}
	
	
}
