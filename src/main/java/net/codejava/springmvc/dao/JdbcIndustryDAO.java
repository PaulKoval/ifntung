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

import net.codejava.springmvc.dao.IndustryDAO;
import net.codejava.springmvc.model.Industry;

public class JdbcIndustryDAO implements IndustryDAO
{
	private JdbcTemplate jdbcTemplate;
	private DataSource dataSource;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	

	public List<Industry> getIndustriesList(){
		
		String sql = "SELECT * FROM industry";
		Connection conn = null;
		List<Industry> goods = new ArrayList<Industry>();
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) { 
						Industry g = new Industry();
				        g.setName(rs.getString("NameIndustry"));
				        g.setID(rs.getInt("ID"));
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