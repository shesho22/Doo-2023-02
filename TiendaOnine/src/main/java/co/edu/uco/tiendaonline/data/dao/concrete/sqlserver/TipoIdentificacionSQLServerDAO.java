package co.edu.uco.tiendaonline.data.dao.concrete.sqlserver;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.naming.spi.DirStateFactory.Result;
import com.fasterxml.jackson.databind.introspect.TypeResolutionContext.Empty;

import co.edu.uco.tiendaonline.crosscutting.exception.concrete.DataTiendaOnlineException;
import co.edu.uco.tiendaonline.data.dao.ClienteDAO;
import co.edu.uco.tiendaonline.data.dao.TipoIdentificacionDAO;
import co.edu.uco.tiendaonline.data.dao.base.SQLDAO;
import co.edu.uco.tiendaonline.data.entity.ClienteEntity;
import co.edu.uco.tiendaonline.data.entity.TipoIdentificacionEntity;

public final class TipoIdentificacionSQLServerDAO extends SQLDAO implements TipoIdentificacionDAO {

	public TipoIdentificacionSQLServerDAO(final Connection conexion) {
		super(conexion);
	}

	@Override
	public final void crear(final TipoIdentificacionEntity entity) {
		final var sentencia = new StringBuilder();
		sentencia.append("INSERT INTO TipoIdentificacion (id,codigo,nombre,estado)");
		sentencia.append("VALUES (?, ?, ?, ?)");
		try (final var sentenciaPreparada =getConexion().prepareStatement(sentencia)){
			sentenciaPreparada.setObject(1,entity.getId());
			sentenciaPreparada.setObject(2,entity.getId());
			sentenciaPreparada.setObject(3,entity.getId());
			sentenciaPreparada.setObject(4,entity.getId());
			
			sentenciaPreparada.exexcuteUpdate();
		} catch (final SQLException exception) {
			var mensajeUsuario ="";
			var mensajeTecnico ="";
			throw DataTiendaOnlineException.crear(exception,mensajeUsuario,mensajeTecnico);
		}catch (final Exception exception) {
			var mensajeUsuario ="";
			var mensajeTecnico ="";
			throw DataTiendaOnlineException.crear(exception,mensajeUsuario,mensajeTecnico);
		}
	}

	@Override
	public final void modificar(final TipoIdentificacionEntity entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public final void eliminar(final UUID id) {
		// TODO Auto-generated method stub

	}

	@Override
	public final Optional<TipoIdentificacionEntity> consultarPorId(final UUID id) {
		
		final var sentencia = new StringBuilder();
		sentencia.append("SELECT id, codigo, nombre, estado ");
		sentencia.append("FROM TipoIdentificacion ");
		sentencia.append("WHERE id = ? ");
		
		getConexion();
		
		try (final var sentenciaPreparada = getConexion().prepareStatement(sentencia.toString())){
			
			sentenciaPreparada.setObject(1, id);
			
			try (final var resultados = sentenciaPreparada.executeQuery()){
				if (resultados.next()) {
					var tipoIdentificacionEntity = TipoIdentificacionEntity.crear(UUID.fromString(resultados.getObject("id").toString()), resultados.getString("codigo"), resultados.getString("nombre"), resultados.getBoolean("estado"));
					resultado = Optional.of(tipoIdentificacionEntity);
				}
			}catch (final SQLException excepcion){
				var mensajeUsuario ="Se ha presentado un problema tratando de consultar la informacion del tipo de identificacion por el identificador deceado...";
				var mensajeTecnico ="";
				throw DataTiendaOnlineException.crear(exception,mensajeUsuario,mensajeTecnico);
			}
			
		}catch (final DataTiendaOnlineException exception) {
			throw exception;
		}catch(final SQLException exception) {
			var mensajeUsuario ="Se ha presentado un problema tratando de consultar la informacion del tipo de identificacion por el identificador deceado...";
			var mensajeTecnico ="";
			throw DataTiendaOnlineException.crear(exception,mensajeUsuario,mensajeTecnico);
		}catch (final Exception exception) {
			var mensajeUsuario ="Se ha presentado un problema tratando de consultar la informacion del tipo de identificacion por el identificador deceado...";
			var mensajeTecnico ="";
			throw DataTiendaOnlineException.crear(exception,mensajeUsuario,mensajeTecnico);
		}
		return resultado;
	}

	@Override
	public final List<TipoIdentificacionEntity> consultar(final TipoIdentificacionEntity entity) {
		// TODO Auto-generated method stub
		return null;
	}

}

