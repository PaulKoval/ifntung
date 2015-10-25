package net.codejava.springmvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import net.codejava.springmvc.dao.UserDAO;
import net.codejava.springmvc.model.User;

public class JdbcUserDAO implements UserDAO
{
	private JdbcTemplate jdbcTemplate;
	private DataSource dataSource;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public void insert(User user){
		
		String sql = "INSERT INTO CUSTOMER " +
				"(Name, Password, Email) VALUES (?, ?, ?)";
		Connection conn = null;
		
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, user.getName());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getEmail());
			ps.executeUpdate();
			ps.close();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
			
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {}
			}
		}
	}
	
public User findByCustomerId(String Email){
		
		String sql = "SELECT * FROM user WHERE Email = ?";
		
		Connection conn = null;
		
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, Email);
			User user = null;
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				user = new User(
						rs.getInt("ID"),
						rs.getString("Name"), 
						rs.getString("Password"),
						rs.getString("Email"),
						rs.getString("Access")
				);
			}
			rs.close();
			ps.close();
			return user;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (conn != null) {
				try {
				conn.close();
				} catch (SQLException e) {}
			}
		}
	}

public List<User> findCustomers(int custId){
	String sql = "SELECT * FROM user";
	Connection conn = null;
	List<User> goods = new ArrayList<User>();
	try {
		conn = dataSource.getConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		//ps.setInt(1, custId);
		User user = null;
		ResultSet rs = ps.executeQuery();
		
		while (rs.next()) { 
			user = new User(
					rs.getInt("ID"),
					rs.getString("Name"), 
					rs.getString("Password"),
					rs.getString("Email"),
					rs.getString("Access")
			);
			User g = new User();
			g.setID(user.getID());
	        g.setName(user.getName());
	        g.setPassword(user.getPassword());
	        g.setEmail(user.getEmail());
	        g.setAccess(user.getAccess());
	        goods.add(g);
		}
		rs.close();
		ps.close();
		return goods;
	} catch (SQLException e) {
		throw new RuntimeException(e);
	} finally {
		if (conn != null) {
			try {
			conn.close();
			} catch (SQLException e) {}
		}
	}
}

public List<User> findUserByEmail(String Email){

	String sql = "SELECT * FROM user WHERE Email = ?";
	Connection conn = null;
	List<User> goods = new ArrayList<User>();
	try {
		conn = dataSource.getConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, Email);
		User user = null;
		ResultSet rs = ps.executeQuery();
		while (rs.next()) { 
			user = new User(
					rs.getInt("ID"),
					rs.getString("Name"), 
					rs.getString("Password"),
					rs.getString("Email"),
					rs.getString("Access")
			);
			User g = new User();
			g.setID(user.getID());
	        g.setName(user.getName());
	        g.setPassword(user.getPassword());
	        g.setEmail(user.getEmail());
	        g.setAccess(user.getAccess());
	        goods.add(g);
		}
		rs.close();
		ps.close();
		return goods;
	} catch (SQLException e) {
		throw new RuntimeException(e);
	} finally {
		if (conn != null) {
			try {
			conn.close();
			} catch (SQLException e) {}
		}
	}
}

}