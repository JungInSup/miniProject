package com.uni.stay.model.dao;

import static com.uni.common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import com.uni.stay.model.dto.Stay;

public class StayDao {
	
//	private Properties prop = null;
//
//	public StayDao() {
//		
//		prop = new Properties();
//		try {
//			prop.load(new FileReader("resources/query.properties"));
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//	}
	
	public List<Stay> selectByNameList(Connection con, String stayArea, int stayCode) {
		ArrayList<Stay> list = null;
		PreparedStatement pstmt = null;// ������ ����
	    ResultSet rset = null;// Select ���� ����� �޾ƿ� ��ü
		
		String sql = "SELECT * FROM stay WHERE stay_area LIKE ? AND stay_code = ?";
		
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "%"+stayArea+"%");
			pstmt.setInt(2, stayCode);
			rset = pstmt.executeQuery();
			
			list = new ArrayList<Stay>();
			
			while (rset.next()) {

	            Stay s = new Stay();
	            
	            s.setStayNo(rset.getInt("stay_no"));
	            s.setStayCode(rset.getInt("stay_code"));
	            s.setStayArea(rset.getString("stay_area"));
	            s.setStayName(rset.getString("stay_name"));
	            s.setStayDay(rset.getDate("stay_day"));
	            s.setPrice(rset.getInt("price"));
	            
	            list.add(s);
	         }
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
			close(rset);
			close(pstmt);
			
		}
		
		return list;
	}

	public List<String> selectByStayInfo(Connection con, String stayName) {
		ArrayList<String> list = null;
		PreparedStatement pstmt = null;// ������ ����
	    ResultSet rset = null;// Select ���� ����� �޾ƿ� ��ü
		
		String sql = "SELECT * FROM stay WHERE stay_name LIKE ?";
		
		
		Stay s = new Stay();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, stayName);
			rset = pstmt.executeQuery();
			
			list = new ArrayList<String>();
			
			while (rset.next()) {

	            
//	            s.setStayNo(rset.getInt("stay_no"));
//	            s.setStayCode(rset.getInt("stay_code"));
//	            s.setStayArea(rset.getString("stay_area"));
//	            s.setStayName(rset.getString("stay_name"));
//	            s.setStayDay(rset.getDate("stay_day"));
//	            s.setPrice(rset.getInt("price"));
	            
	            String name = rset.getString("stay_name");
	            list.add(name);
	            String area = rset.getString("stay_area");
	            list.add(area);		
	            int price = rset.getInt("price");
	            String temp = Integer.toString(price);
	            list.add(temp);
	         
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
			close(rset);
			close(pstmt);
			
		}
		
		return list;
	}

}
