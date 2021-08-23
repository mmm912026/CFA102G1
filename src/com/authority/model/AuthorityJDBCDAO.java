package com.authority.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class AuthorityJDBCDAO implements I_AuthorityDAO {
	
	public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	public static final String URL = "jdbc:mysql://localhost:3306/CFA102G1?serverTimezone=Asia/Taipei";
	public static final String USER = "David";
	public static final String PASSWORD = "123456";
	
	private static final String INSERT_SQL = 
			"insert into AUTHORITY values (?,?)";
	private static final String UPDATE_SQL = 
			"UPDATE AUTHORITY SET AUTHORITY_NAME = ? WHERE AUTHORITY_NO = ?";
	private static final String DELETE_SQL = 
			"DELETE FROM AUTHORITY where AUTHORITY_NO = ?";
	private static final String FIND_BY_AUTHORITY_NO_SQL = 
			"SELECT * FROM AUTHORITY WHERE AUTHORITY_NO = ?";
	private static final String GET_ALL =
			"SELECT AUTHORITY_NO,AUTHORITY_NAME FROM AUTHORITY";
	
	static {
		try {
			Class.forName(DRIVER);
		}catch (ClassNotFoundException ce) {
			ce.printStackTrace();
		}
	}
	

	@Override
	public void insert(AuthorityVO authouity) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = con.prepareStatement(INSERT_SQL);
			
			pstmt.setInt(1, authouity.getAUTHORITY_NO());
			pstmt.setString(2,authouity.getAUTHORITY_NAME());
			
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
	public void delete(int AUTHORITY_NO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = con.prepareStatement(DELETE_SQL);

			pstmt.setInt(1, AUTHORITY_NO);			
			
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
	public void update(AuthorityVO authouity) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = con.prepareStatement(UPDATE_SQL);
			
			
			pstmt.setString(1,authouity.getAUTHORITY_NAME());
			pstmt.setInt(2, authouity.getAUTHORITY_NO());
			
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
	public AuthorityVO findByAuthority_no(int AUTHORITY_NO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		AuthorityVO authouity = null;
		
		try {
			con = DriverManager.getConnection(URL,USER,PASSWORD);
			pstmt = con.prepareStatement(FIND_BY_AUTHORITY_NO_SQL);
			pstmt.setInt(1,AUTHORITY_NO );
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				authouity = new AuthorityVO();
				authouity.setAUTHORITY_NO(AUTHORITY_NO);
				authouity.setAUTHORITY_NAME(rs.getString("AUTHORITY_NAME"));
				
				
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
		
		return authouity;
	}	

	@Override
	public List<AuthorityVO> getAll() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<AuthorityVO> list = new ArrayList<AuthorityVO>();
		AuthorityVO authouityVO = null;
		try {
			con = DriverManager.getConnection(URL,USER,PASSWORD);
			pstmt = con.prepareStatement(GET_ALL);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				authouityVO = new AuthorityVO();
				
				authouityVO.setAUTHORITY_NO(rs.getInt("AUTHORITY_NO"));
				authouityVO.setAUTHORITY_NAME(rs.getString("AUTHORITY_NAME"));
				
				
				list.add(authouityVO);
				
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
//			AuthorityJDBCDAO dao = new AuthorityJDBCDAO();
//			AuthorityVO authouity = new AuthorityVO();
//			authouity.setAUTHORITY_NO(997765);
//			authouity.setAUTHORITY_NAME("封鎖");
//
//				dao.insert(authouity);
//				

   
//	}
			//System.out.println("---------------------------------------------------");
			//用功能編號查詢
//			AuthorityJDBCDAO dao = new AuthorityJDBCDAO();
//			AuthorityVO list1 = dao.findByAuthority_no(998874);
//			    System.out.print(list1.getAUTHORITY_NO()+"\t");
//			    System.out.print(list1.getAUTHORITY_NAME()+"\t"); 
//		
//		         System.out.println();
			
			//System.out.println("---------------------------------------------------");
		    
		  //修改
//			AuthorityJDBCDAO dao = new AuthorityJDBCDAO();
//			AuthorityVO authouity = new AuthorityVO();
//			
//			authouity.setAUTHORITY_NAME("刪除");
//			authouity.setAUTHORITY_NO(995584);
//			
//			dao.update(authouity);
//			
//		}
		//System.out.println("---------------------------------------------------");
			
			//搜尋全部
//			AuthorityJDBCDAO dao = new AuthorityJDBCDAO();
//			List<AuthorityVO> list = dao.getAll();
//			for (AuthorityVO authouityVO : list ) {
//				
//			    System.out.print(authouityVO.getAUTHORITY_NO()+"\t");
//			    System.out.print(authouityVO.getAUTHORITY_NAME()+"\t");
//		
//			    System.out.println();
//			}
//			System.out.println("-------------------------------------------");
			//刪除
//			AuthorityJDBCDAO dao = new AuthorityJDBCDAO();
//			dao.delete(998874);
//			    System.out.println("已刪除");
//			System.out.println("-------------------------------------------");
//		
  }
}
