package com.rentalClass.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RentalClassJDBCDAO implements I_RentalClassDAO{

	String DRIVER = "com.mysql.cj.jdbc.Driver";
	String URL = "jdbc:mysql://localhost:3306/CFA102G1?" 
			+ "rewriteBatchedStatements=true&serverTimezone=Asia/Taipei";
	String USER = "David";
	String PASSWORD = "123456";
	
	private static final String INSERT_STMT = 
			"INSERT INTO RENTAL_CLASS (rc_name,rc_item,rc_detail,rc_deposit,rc_price,rc_storage,rc_status) VALUES(?,?,?,?,?,?,?)";
	private static final String UPDATE_STMT = 
			"UPDATE RENTAL_CLASS set rc_name=?,rc_item=?,rc_detail=?,rc_deposit=?,rc_price=?,rc_total_count=?,rc_total_score=?,rc_storage=?,rc_status=? where rc_no = ?";
	private static final String DELETE_STMT = 
			"DELETE FROM RENTAL_CLASS where rc_no = ?";
	private static final String FIND_BY_PK = 
			"SELECT * FROM RENTAL_CLASS WHERE rc_no = ?";
	private static final String GET_ALL = 
			"SELECT * FROM RENTAL_CLASS";
	
	public void insert(RentalClassVO RentalClassVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {

			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setString(1, RentalClassVO.getRc_name());
			pstmt.setString(2, RentalClassVO.getRc_item());
			pstmt.setString(3, RentalClassVO.getRc_detail());
			pstmt.setInt(4, RentalClassVO.getRc_deposit());
			pstmt.setInt(5, RentalClassVO.getRc_price());
			pstmt.setInt(6, RentalClassVO.getRc_storage());
			pstmt.setString(7, RentalClassVO.getRc_status());
			
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
	
	public void update(RentalClassVO RentalClassVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {

			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = con.prepareStatement(UPDATE_STMT);
			
			pstmt.setString(1, RentalClassVO.getRc_name());
			pstmt.setString(2, RentalClassVO.getRc_item());
			pstmt.setString(3, RentalClassVO.getRc_detail());
			pstmt.setInt(4, RentalClassVO.getRc_deposit());
			pstmt.setInt(5, RentalClassVO.getRc_price());
			pstmt.setInt(6, RentalClassVO.getRc_total_count());
			pstmt.setInt(7, RentalClassVO.getRc_total_score());
			pstmt.setInt(8, RentalClassVO.getRc_storage());
			pstmt.setString(9, RentalClassVO.getRc_status());
			pstmt.setInt(10, RentalClassVO.getRc_no());
			
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

	public void delete(Integer rc_no) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {

			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = con.prepareStatement(DELETE_STMT);
			
			pstmt.setInt(1, rc_no);
			
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

	public RentalClassVO findByPK(Integer rc_no) {
		
		RentalClassVO RentalClassVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {

			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = con.prepareStatement(FIND_BY_PK);
			
			pstmt.setInt(1, rc_no);
			
			rs = pstmt.executeQuery();

			while (rs.next()) {
				RentalClassVO = new RentalClassVO();		
				RentalClassVO.setRc_no(rs.getInt("rc_no"));
				RentalClassVO.setRc_name(rs.getString("rc_name"));
				RentalClassVO.setRc_item(rs.getString("rc_item"));
				RentalClassVO.setRc_detail(rs.getString("rc_detail"));
				RentalClassVO.setRc_deposit(rs.getInt("rc_deposit"));
				RentalClassVO.setRc_price(rs.getInt("rc_price"));
				RentalClassVO.setRc_total_count(rs.getInt("rc_total_count"));
				RentalClassVO.setRc_total_score(rs.getInt("rc_total_score"));
				RentalClassVO.setRc_storage(rs.getInt("rc_storage"));
				RentalClassVO.setRc_status(rs.getString("rc_status"));				
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
		return RentalClassVO;
	}

	public List<RentalClassVO> getAll() {
		List<RentalClassVO> list = new ArrayList<RentalClassVO>();
		RentalClassVO RentalClassVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {

			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = con.prepareStatement(GET_ALL);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				RentalClassVO = new RentalClassVO();		
				RentalClassVO.setRc_no(rs.getInt("rc_no"));
				RentalClassVO.setRc_name(rs.getString("rc_name"));
				RentalClassVO.setRc_item(rs.getString("rc_item"));
				RentalClassVO.setRc_detail(rs.getString("rc_detail"));
				RentalClassVO.setRc_deposit(rs.getInt("rc_deposit"));
				RentalClassVO.setRc_price(rs.getInt("rc_price"));
				RentalClassVO.setRc_total_count(rs.getInt("rc_total_count"));
				RentalClassVO.setRc_total_score(rs.getInt("rc_total_score"));
				RentalClassVO.setRc_storage(rs.getInt("rc_storage"));
				RentalClassVO.setRc_status(rs.getString("rc_status"));	
				list.add(RentalClassVO); 
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
