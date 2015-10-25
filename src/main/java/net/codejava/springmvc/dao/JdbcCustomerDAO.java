package net.codejava.springmvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.mysql.jdbc.ResultSetMetaData;

import net.codejava.springmvc.dao.CustomerDAO;
import net.codejava.springmvc.model.Customer;

public class JdbcCustomerDAO implements CustomerDAO
{
	private JdbcTemplate jdbcTemplate;
	private DataSource dataSource;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public void insert(Map<String, String> HashMap){
		
		String sql = "INSERT INTO CUSTOMER " +
				"(NAME, AGE, Industry, LastName, Gender, Phone, Email, Country, City, Experience, Education) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		Connection conn = null;
		
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, HashMap.get("Name"));
			ps.setInt(2,  Integer.parseInt(HashMap.get("Age")));
			ps.setString(3,  HashMap.get("Industry"));
			ps.setString(4, HashMap.get("LastName"));
			ps.setString(5, HashMap.get("Gender"));
			ps.setString(6, HashMap.get("Phone"));
			ps.setString(7, HashMap.get("Email"));
			ps.setString(8, HashMap.get("Country"));
			ps.setString(9, HashMap.get("City"));
			ps.setString(10, HashMap.get("Experience"));
			ps.setString(11, HashMap.get("Education"));
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
	
	public void update(HashMap<String,String> HashMap){
		//UPDATE MyGuests SET lastname='Doe' WHERE id=2
		/*String sql = "INSERT INTO CUSTOMER " +
				"(NAME, AGE, Industry) VALUES (?, ?)";*/
		
		String sql = "UPDATE CUSTOMER SET " +
				"NAME = ?, "
				+ "AGE = ?, "
				+ "Industry = ?, "
				+ "LastName = ?, "
				+ "Gender = ?, "
				+ "Phone = ?, "
				+ "Email = ?, "
				+ "Country = ?, "
				+ "City = ?, "
				+ "Experience = ?, "
				+ "Education = ? "
				+ "WHERE CUST_ID = ? ";
		Connection conn = null;
		
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, HashMap.get("Name"));
			ps.setInt(2,  Integer.parseInt(HashMap.get("Age")));
			ps.setString(3,  HashMap.get("Industry"));
			ps.setString(4, HashMap.get("LastName"));
			ps.setString(5, HashMap.get("Gender"));
			ps.setString(6, HashMap.get("Phone"));
			ps.setString(7, HashMap.get("Email"));
			ps.setString(8, HashMap.get("Country"));
			ps.setString(9, HashMap.get("City"));
			ps.setString(10, HashMap.get("Experience"));
			ps.setString(11, HashMap.get("Education"));
			ps.setInt(12,  Integer.parseInt(HashMap.get("ID")));
			System.out.println(HashMap);
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
	
public void delete(int ID){
	
		String sql = "DELETE FROM CUSTOMER WHERE CUST_ID = ? ";
		Connection conn = null;
		
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, ID);
			ps.execute();
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
	
public void unjoinCustomer(String sql){
	
	Connection conn = null;
	
	try {
		conn = dataSource.getConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
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

public Map<String,String> findCurrentCustomerById(int custId){
	
	String sql = "SELECT * FROM CUSTOMER WHERE CUST_ID = ?";
	
	Connection conn = null;
	
	try {
		conn = dataSource.getConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, custId);
		
		Map<String,String> user = new HashMap<String,String>();
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			user.put("ID",rs.getString("CUST_ID"));
			user.put("Name",rs.getString("NAME"));
			user.put("Age",rs.getString("AGE"));
			user.put("Industry", rs.getString("Industry"));
			user.put("LastName", rs.getString("LastName"));
			user.put("Gender", rs.getString("Gender"));
			user.put("Phone", rs.getString("Phone"));
			user.put("Email", rs.getString("Email"));
			user.put("Country", rs.getString("Country"));
			user.put("City", rs.getString("City"));
			user.put("Experience", rs.getString("Experience"));
			user.put("Education", rs.getString("Education"));
			user.put("Email", rs.getString("Email"));
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

public int countCustomers(){
	
	String sql = "SELECT COUNT(*) AS total FROM customer";
	Connection conn = null;
	List<Customer> goods = new ArrayList<Customer>();
	try {
		conn = dataSource.getConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		int count = 0;
		if (rs.next()) {
			count = rs.getInt("total");
		}
		rs.close();
		ps.close();
		return count;
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

public List<Customer> findCustomers(int limit, int offset){
	
	//String sql = "SELECT * FROM CUSTOMER WHERE CUST_ID = ?";
	String sql = "SELECT * FROM CUSTOMER LIMIT ? OFFSET ?";
	Connection conn = null;
	List<Customer> goods = new ArrayList<Customer>();
	try {
		conn = dataSource.getConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, limit);
		ps.setInt(2, offset);
		ResultSet rs = ps.executeQuery();
		
		while (rs.next()) { 
			Customer g = new Customer();
	        g.setName(rs.getString("NAME"));
	        g.setCustId(rs.getInt("CUST_ID"));
	        g.setLastName(rs.getString("LastName"));
	        g.setGender(rs.getString("Gender"));
	        g.setPhone(rs.getString("Phone"));
	        g.setEmail(rs.getString("Email"));
	        g.setCountry(rs.getString("Country"));
	        g.setCity(rs.getString("City"));
	        g.setIndustry(rs.getString("Industry"));
	        g.setExperience(rs.getString("Experience"));
	        g.setEducation(rs.getString("Education"));
	        g.setAge(rs.getInt("Age"));
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


public List<Customer> searchCustomers(String sql){
	
	Connection conn = null;
	List<Customer> goods = new ArrayList<Customer>();
	try {
		conn = dataSource.getConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		while (rs.next()) { 
			Customer g = new Customer();
	        g.setName(rs.getString("NAME"));
	        g.setCustId(rs.getInt("CUST_ID"));
	        g.setAge(rs.getInt("Age"));
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