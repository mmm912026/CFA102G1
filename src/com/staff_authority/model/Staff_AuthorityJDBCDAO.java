package com.staff_authority.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;




public class Staff_AuthorityJDBCDAO implements I_Staff_AuthorityDAO{
	
	public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	public static final String URL = "jdbc:mysql://localhost:3306/CFA102G1?serverTimezone=Asia/Taipei";
	public static final String USER = "David";
	public static final String PASSWORD = "123456";
	
	private static final String INSERT_SQL = 
			"insert into STAFF_AUTHORITY values (?,?)";
	private static final String FIND_BY_STAFF_NO_SQL = 
			"SELECT * FROM STAFF_AUTHORITY WHERE STAFF_NO = ?";
	private static final String GET_ALL =
			"SELECT * FROM STAFF_AUTHORITY";

	@Override
	public void insert(Staff_AuthorityVO staff_authouity) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = con.prepareStatement(INSERT_SQL);
			
			pstmt.setInt(1, staff_authouity.getSTAFF_NO());
			pstmt.setInt(2,staff_authouity.getAUTHORITY_NO());
			
			pstmt.executeUpdate();
			
			}catch (SQLException se) {
			se.printStackTrace();
		}finally {
			if(pstmt != null) {
				try {
					pstmt.close();
				}catch (SQLException se) {
					 se.printStackTrace();
				}
			}
			if(con !=null) {
				try {
					con.close();
				}catch (SQLException se) {
					se.printStackTrace();
				}
			}
		}
	}


	@Override
	public Staff_AuthorityVO findByStaff_no(int STAFF_NO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Staff_AuthorityVO staff_authouity = null;
		
		try {
			con = DriverManager.getConnection(URL,USER,PASSWORD);
			pstmt = con.prepareStatement(FIND_BY_STAFF_NO_SQL);
			pstmt.setInt(1,STAFF_NO );
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				staff_authouity = new Staff_AuthorityVO();
				staff_authouity.setSTAFF_NO(STAFF_NO);
				staff_authouity.setAUTHORITY_NO(rs.getInt("AUTHORITY_NO"));
				
				
			}
			
		}catch (SQLException se) {
			se.printStackTrace();
		}finally {
			if(rs != null) {
				try {
					rs.close();
				}catch (SQLException se) {
					se.printStackTrace();
				}
			}
			
			if(pstmt != null) {
				try {
					pstmt.close();
				}catch (SQLException se) {
					se.printStackTrace();
				}
			}
			
			if(con != null) {
				try {
					con.close();
				}catch (SQLException se) {
					se.printStackTrace();
				}
			}
		}
		
		return staff_authouity;
	}	

	@Override
	public List<Staff_AuthorityVO> getAll() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Staff_AuthorityVO> list = new ArrayList<Staff_AuthorityVO>();
		Staff_AuthorityVO staff_authouity = null;
		try {
			con = DriverManager.getConnection(URL,USER,PASSWORD);
			pstmt = con.prepareStatement(GET_ALL);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				staff_authouity = new Staff_AuthorityVO();
				
				staff_authouity.setSTAFF_NO(rs.getInt("STAFF_NO"));
				staff_authouity.setAUTHORITY_NO(rs.getInt("AUTHORITY_NO"));
				
				
				list.add(staff_authouity);
				
			}
			
		}catch (SQLException se) {
			se.printStackTrace();
		}finally {
			if(rs != null) {
				try {
					rs.close();
				}catch (SQLException se) {
					se.printStackTrace();
				}
			}
			
			if(pstmt != null) {
				try {
					pstmt.close();
				}catch (SQLException se) {
					se.printStackTrace();
				}
			}
			
			if(con != null) {
				try {
					con.close();
				}catch (SQLException se) {
					se.printStackTrace();
				}
			}
		}
		
		return list;
	}
	//測試開始
	public static void main(String[] args) {
		
		//新增功能
//		Staff_AuthorityJDBCDAO dao = new Staff_AuthorityJDBCDAO();
//		Staff_AuthorityVO staff_authouity = new Staff_AuthorityVO();
//		staff_authouity.setSTAFF_NO(997765);
//		staff_authouity.setAUTHORITY_NO(953421);
//
//		dao.insert(staff_authouity);
////		
		//System.out.println("---------------------------------------------------");
		//用功能編號查詢
//		Staff_AuthorityJDBCDAO dao = new Staff_AuthorityJDBCDAO();
//		Staff_AuthorityVO list1 = dao.findByStaff_no(997765);
//		   System.out.print(list1.getSTAFF_NO()+"\t");
//		   System.out.print(list1.getAUTHORITY_NO()+"\t"); 
//	
//	    System.out.println();
		
		//System.out.println("---------------------------------------------------");
		//搜尋全部
//		Staff_AuthorityJDBCDAO dao = new Staff_AuthorityJDBCDAO();
//		List<Staff_AuthorityVO> list = dao.getAll();
//		for (Staff_AuthorityVO authouityVO : list ) {
//			
//		   System.out.print(authouityVO.getSTAFF_NO()+"\t");
//		   System.out.print(authouityVO.getAUTHORITY_NO()+"\t");
//	
//		   System.out.println();
		
//		}
//		System.out.println("-------------------------------------------");
		
   }
}