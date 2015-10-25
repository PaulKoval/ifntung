package net.codejava.springmvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import net.codejava.springmvc.dao.CompanyDAO;
import net.codejava.springmvc.model.Company;

public class JdbcCompanyDAO implements CompanyDAO
{
	private JdbcTemplate jdbcTemplate;
	private DataSource dataSource;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public void insert(Company company){
		
		String sql = "INSERT INTO companies " +
				"(Name, Industry, Country) VALUES (?, ?, ?)";
		Connection conn = null;
		
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, company.getName());
			ps.setString(2, company.getIndustry());
			ps.setString(3, company.getCountry());
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
	
	public void insertUser(String sql){
		
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
	
	public void update(String updateSQL){
		
		Connection conn = null;
		
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(updateSQL);
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
	
		String sql = "DELETE FROM companies WHERE ID = ? ";
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

public void deleteManual(String sql){
	
	Connection conn = null;
	
	try {
		conn = dataSource.getConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
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
	
public Company findByCompanyId(int custId){
		
		String sql = "SELECT * FROM companies WHERE ID = ?";
		
		Connection conn = null;
		
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, custId);
			Company company = null;
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				company = new Company(
						rs.getInt("ID"),
						rs.getString("Name"), 
						rs.getString("Industry"),
						rs.getString("Company")
				);
			}
			rs.close();
			ps.close();
			return company;
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

public Map<String,String> findCurrentCompanyById(int custId){
	
	String sql = "SELECT * FROM companies WHERE ID = ?";
	
	Connection conn = null;
	
	try {
		conn = dataSource.getConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, custId);
		
		Map<String,String> company = new HashMap<String,String>();
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			company.put("ID",rs.getString("ID"));
			company.put("Name",rs.getString("Name"));
			company.put("Industry",rs.getString("Industry"));
			company.put("Country",rs.getString("Country"));
		}
		rs.close();
		ps.close();
		return company;
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

public int countCompany(){
	
	String sql = "SELECT COUNT(*) AS total FROM companies";
	Connection conn = null;
	List<Company> goods = new ArrayList<Company>();
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

public List<Company> findCompany(int limit, int offset){
	
	//String sql = "SELECT * FROM Companies WHERE CUST_ID = ?";
	String sql = "SELECT companies.ID, companies.Name, industry.NameIndustry As Industry, companies.Country FROM companies LEFT JOIN industry"
				+ " ON companies.Industry = industry.ID "
				+ "LIMIT ? OFFSET ?";
	Connection conn = null;
	List<Company> goods = new ArrayList<Company>();
	try {
		conn = dataSource.getConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, limit);
		ps.setInt(2, offset);
		Company company = null;
		ResultSet rs = ps.executeQuery();
		
		while (rs.next()) { 
					Company g = new Company();
			        g.setName(rs.getString("Name"));
			        g.setID(rs.getInt("ID"));
			        g.setIndustry(rs.getString("Industry"));
			        g.setCountry(rs.getString("Country"));
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

public List<Company> searchCompany(String sql){
	
	Connection conn = null;
	List<Company> goods = new ArrayList<Company>();
	try {
		conn = dataSource.getConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) { 
			Company g = new Company();
			g.setName(rs.getString("Name"));
	        g.setID(rs.getInt("ID"));
	        g.setIndustry(rs.getString("Industry"));
	        g.setCountry(rs.getString("Country"));
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