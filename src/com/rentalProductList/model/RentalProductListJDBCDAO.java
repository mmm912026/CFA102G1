package com.rentalProductList.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RentalProductListJDBCDAO implements I_RentalProductListDAO{
	
	String DRIVER = "com.mysql.cj.jdbc.Driver";
	String URL = "jdbc:mysql://localhost:3306/CFA102G1?" 
			+ "rewriteBatchedStatements=true&serverTimezone=Asia/Taipei";
	String USER = "David";
	String PASSWORD = "123456";
	
	

	
	private static final String INSERT_STMT = 
			"INSERT INTO RENTAL_PRODUCT_LIST (rc_no,rpl_serialnum,rpl_note,rpl_status) VALUES(?,?,?,?)";
	private static final String UPDATE_STMT = 
			"UPDATE RENTAL_PRODUCT_LIST set rc_no=?,rpl_serialnum=?,rpl_note=?,rpl_status=?,rpl_rentcount=?,rpl_jointtime=? where rpl_no = ?";
	private static final String DELETE_STMT = 
			"DELETE FROM RENTAL_PRODUCT_LIST where rpl_no = ?";
	private static final String FIND_BY_PK = 
			"SELECT * FROM RENTAL_PRODUCT_LIST WHERE rpl_no = ?";
	private static final String GET_ALL = 
			"SELECT * FROM RENTAL_PRODUCT_LIST";
	
	@Override
	public void insert(RentalProductListVO RentalProductListVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {

			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setInt(1, RentalProductListVO.getRc_no());
			pstmt.setString(2, RentalProductListVO.getRpl_serialnum());
			pstmt.setString(3, RentalProductListVO.getRpl_note());
			pstmt.setString(4, RentalProductListVO.getRpl_status());
			
			pstmt.executeUpdate();

		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
	}
	
	public void update(RentalProductListVO RentalProductListVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {

			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = con.prepareStatement(UPDATE_STMT);
			
			pstmt.setInt(1, RentalProductListVO.getRc_no());
			pstmt.setString(2, RentalProductListVO.getRpl_serialnum());
			pstmt.setString(3, RentalProductListVO.getRpl_note());
			pstmt.setString(4, RentalProductListVO.getRpl_status());
			pstmt.setInt(5, RentalProductListVO.getRpl_rentcount());
			pstmt.setTimestamp(6, RentalProductListVO.getRpl_jointtime());
			pstmt.setInt(7, RentalProductListVO.getRpl_no());
			
			pstmt.executeUpdate();

		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
	}
	
	public void delete(Integer rpl_no) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {

			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = con.prepareStatement(DELETE_STMT);
			
			pstmt.setInt(1, rpl_no);
			
			pstmt.executeUpdate();

		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}	
	}

	public RentalProductListVO findByPK(Integer rpl_no) {
		RentalProductListVO RentalProductListVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {

			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = con.prepareStatement(FIND_BY_PK);
			
			pstmt.setInt(1, rpl_no);
			
			rs = pstmt.executeQuery();
		
			while (rs.next()) {
				RentalProductListVO = new RentalProductListVO();		
				RentalProductListVO.setRpl_no(rs.getInt("rpl_no"));
				RentalProductListVO.setRc_no(rs.getInt("rc_no"));
				RentalProductListVO.setRpl_serialnum(rs.getString("rpl_serialnum"));
				RentalProductListVO.setRpl_note(rs.getString("rpl_note"));
				RentalProductListVO.setRpl_status(rs.getString("rpl_status"));
				RentalProductListVO.setRpl_rentcount(rs.getInt("rpl_rentcount"));
				RentalProductListVO.setRpl_jointtime(rs.getTimestamp("rpl_jointtime"));			
			}

		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		return RentalProductListVO;
	}

	public List<RentalProductListVO> getAll() {
		List<RentalProductListVO> list = new ArrayList<RentalProductListVO>();
		RentalProductListVO RentalProductListVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {

			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = con.prepareStatement(GET_ALL);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				RentalProductListVO = new RentalProductListVO();		
				RentalProductListVO.setRpl_no(rs.getInt("rpl_no"));
				RentalProductListVO.setRc_no(rs.getInt("rc_no"));
				RentalProductListVO.setRpl_serialnum(rs.getString("rpl_serialnum"));
				RentalProductListVO.setRpl_note(rs.getString("rpl_note"));
				RentalProductListVO.setRpl_status(rs.getString("rpl_status"));
				RentalProductListVO.setRpl_rentcount(rs.getInt("rpl_rentcount"));
				RentalProductListVO.setRpl_jointtime(rs.getTimestamp("rpl_jointtime"));	
				
				list.add(RentalProductListVO); // Store the row in the vector
			}

		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		return list;
	}
}
