package dataAccess;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import pkg.User;

public class UserManager {
	// Let the name of the JNDI be "jdbc/movies"
	DataSource ds;

	public UserManager() {
		try {
			Context jndi = new InitialContext();
			ds = (DataSource) jndi.lookup("java:comp/env/jdbc/movies");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	Connection connection = null;
	PreparedStatement statement = null;
	ResultSet results = null;

	// Assumption: Id is auto incremented

	public void createUser(User newUser) {
		String createUserSql = "INSERT INTO USER (id,USERNAME, PASSWORD,FIRSTNAME,LASTNAME,EMAIL,DATEOFBIRTH) VALUES (?,?, ?, ?, ?, ?, ?);";
		try {
			connection = ds.getConnection();
			statement = connection.prepareStatement(createUserSql);
			statement.setString(1, UUID.randomUUID().toString());
			statement.setString(2, newUser.getUsername());
			statement.setString(3, newUser.getPassword());
			statement.setString(4, newUser.getFirstName());
			statement.setString(5, newUser.getLastName());
			statement.setString(6, newUser.getEmail());
			Date date = new Date(newUser.getDateOfBirth().getTime());
			statement.setDate(7, date);
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public List<User> readAllUsers() {
		String readAllUsersSql = "SELECT * FROM USER;";
		List<User> users = new ArrayList<User>();
		try {
			connection = ds.getConnection();
			statement = connection.prepareStatement(readAllUsersSql);
			results = statement.executeQuery();
			while (results.next()) {
				User user = new User();
				user.setId(results.getString("id"));
				user.setUsername(results.getString("username"));
				user.setPassword(results.getString("password"));
				user.setFirstName(results.getString("firstname"));
				user.setLastName(results.getString("lastname"));
				user.setEmail(results.getString("email"));
				user.setDateOfBirth(results.getDate("dateofbirth"));
				users.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return users;
	}

	public User readUser(String username) {
		String readUser = "SELECT * FROM USER WHERE USERNAME=?;";
		try {
			connection = ds.getConnection();
			statement = connection.prepareStatement(readUser);
			statement.setString(1, username);
			results = statement.executeQuery();
			if (results.next()) {
				User user = new User();
				user.setId(results.getString("id"));
				user.setUsername(results.getString("username"));
				user.setPassword(results.getString("password"));
				user.setFirstName(results.getString("firstname"));
				user.setLastName(results.getString("lastname"));
				user.setEmail(results.getString("email"));
				user.setDateOfBirth(results.getDate("dateofbirth"));
				return user;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

	public void updateUser(String username, User user) {
		String updateUserSql = "UPDATE USER SET PASSWORD=?,FIRSTNAME=?,LASTNAME=?,EMAIL=?,DATEOFBIRTH=? WHERE USERNAME=?;";
		try {
			connection = ds.getConnection();
			statement = connection.prepareStatement(updateUserSql);
			statement.setString(1, user.getPassword());
			statement.setString(2, user.getFirstName());
			statement.setString(3, user.getLastName());
			statement.setString(4, user.getEmail());
			Date date = new Date(user.getDateOfBirth().getTime());
			statement.setDate(5, date);
			statement.setString(6, username);
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void deleteUser(String username) {
		String deleteUserSql = "DELETE FROM USER WHERE USERNAME=?";
		try {
			connection = ds.getConnection();
			statement = connection.prepareStatement(deleteUserSql);
			statement.setString(1, username);
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}