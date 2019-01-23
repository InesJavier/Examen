package es.salesianos.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import es.salesianos.connection.AbstractConnection;
import es.salesianos.connection.H2Connection;
import es.salesianos.model.FilmActor;

public class FilmActorRepository {
	
	private static final String jdbcUrl = "jdbc:h2:file:./src/main/resources/test";
	AbstractConnection manager = new H2Connection();

	public void insert(FilmActor filmActor) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn
					.prepareStatement("INSERT INTO FILMACTOR (cache, role, codActor, codFilm)" + "VALUES (?, ?, ?, ?)");
			preparedStatement.setInt(1, filmActor.getCache());
			preparedStatement.setString(2, filmActor.getRole());
			preparedStatement.setInt(3, filmActor.getCodActor());
			preparedStatement.setInt(4, filmActor.getCodFilm());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			manager.close(preparedStatement);
			manager.close(conn);
		}
	}

}
