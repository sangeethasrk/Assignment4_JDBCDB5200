package dataAccess;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import pkg.Actor;
import pkg.User;

public class ActorManager {
	// Let the name of the JNDI be "jdbc/movies"
	DataSource ds;
	public ActorManager() {
		try {
			Context jndi = new InitialContext();
			ds = (DataSource) jndi.lookup("java:comp/env/jdbc/movies");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	Connection connection = null;
	PreparedStatement statement = null;
	ResultSet results = null;

	public void createActor(Actor newActor){
		String createActorSql = "INSERT INTO ACTOR (id,firstName, lastName,dateOfBirth) VALUES (?,?, ?, ?);";
		try {
			connection = ds.getConnection();
			statement = connection.prepareStatement(createActorSql);

			statement.setString(1, UUID.randomUUID().toString());
			statement.setString(2, newActor.getFirstName());
			statement.setString(3, newActor.getLastName());
			Date date = new Date(newActor.getDateOfBirth().getTime());
			statement.setDate(4, date);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	} 
	
	public List<Actor> readAllActors(){
		String readAllActorsSql = "SELECT * FROM ACTOR;";
		List<Actor> actors = new ArrayList<Actor>();
		try {
			connection = ds.getConnection();
			statement = connection.prepareStatement(readAllActorsSql);
			results = statement.executeQuery();
			while (results.next()) {
				Actor actor = new Actor();
				actor.setId(results.getString("id"));
				actor.setFirstName(results.getString("firstname"));
				actor.setLastName(results.getString("lastName"));
				actor.setDateOfBirth(results.getDate("dateOfBirth"));
				actors.add(actor);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return actors;
	}
	
	public Actor readActor(String actorId){
		String readUser = "SELECT * FROM ACTOR WHERE id=?;";
		try {
			connection = ds.getConnection();
			statement = connection.prepareStatement(readUser);
			statement.setString(1, actorId);
			results = statement.executeQuery();
			if (results.next()) {
				Actor actor = new Actor();
				actor.setId(results.getString("id"));
				actor.setFirstName(results.getString("firstname"));
				actor.setLastName(results.getString("lastName"));
				actor.setDateOfBirth(results.getDate("dateOfBirth"));
				return actor;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	public void updateActor(String actorId, Actor actor){
		String updateActorSql = "UPDATE ACTOR SET FIRSTNAME=?,LASTNAME=?,DATEOFBIRTH=? WHERE id=?;";
		try {
			connection = ds.getConnection();
			statement = connection.prepareStatement(updateActorSql);
			statement.setString(1, actor.getFirstName());
			statement.setString(2, actor.getLastName());
			Date date = new Date(actor.getDateOfBirth().getTime());
			statement.setDate(3, date);
			statement.setString(4, actorId);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void deleteActor(String actorId){
		String deleteUserSql = "DELETE FROM ACTOR WHERE id=?";
		try {
			connection = ds.getConnection();
			statement = connection.prepareStatement(deleteUserSql);
			statement.setString(1, actorId);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}	
}
