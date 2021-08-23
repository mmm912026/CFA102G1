package com.reportProductReviews.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReportProductReviewsJDBCDAO implements I_ReportProductReviews{

	String DRIVER = "com.mysql.cj.jdbc.Driver";
	String URL = "jdbc:mysql://localhost:3306/CFA102G1?" 
			+ "rewriteBatchedStatements=true&serverTimezone=Asia/Taipei";
	String USER = "David";
	String PASSWORD = "123456";
	
	private static final String INSERT_STMT = 
			"INSERT INTO REPORT_PRODUCT_REVIEWS (pr_no,mem_no,report_content,rep_status) VALUES(?,?,?,?)";
	private static final String UPDATE_STMT = 
			"UPDATE REPORT_PRODUCT_REVIEWS set pr_no=?,mem_no=?,report_content=?,rep_status=?,rep_date=? where rep_no = ?";
	private static final String DELETE_STMT = 
			"DELETE FROM REPORT_PRODUCT_REVIEWS where rep_no = ?";
	private static final String FIND_BY_PK = 
			"SELECT * FROM REPORT_PRODUCT_REVIEWS WHERE rep_no = ?";
	private static final String GET_ALL = 
			"SELECT * FROM REPORT_PRODUCT_REVIEWS";
	
	public void insert(ReportProductReviewsVO ReportProductReviewsVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {

			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setInt(1, ReportProductReviewsVO.getPr_no());
			pstmt.setInt(2, ReportProductReviewsVO.getMem_no());
			pstmt.setString(3, ReportProductReviewsVO.getReport_content());
			pstmt.setString(4, ReportProductReviewsVO.getRep_status());
				
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

	public void update(ReportProductReviewsVO ReportProductReviewsVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {

			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = con.prepareStatement(UPDATE_STMT);
			
			pstmt.setInt(1, ReportProductReviewsVO.getPr_no());
			pstmt.setInt(2, ReportProductReviewsVO.getMem_no());
			pstmt.setString(3, ReportProductReviewsVO.getReport_content());
			pstmt.setString(4, ReportProductReviewsVO.getRep_status());
			pstmt.setTimestamp(5, ReportProductReviewsVO.getRep_date());
			pstmt.setInt(6, ReportProductReviewsVO.getRep_no());
			
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

	public void delete(Integer rep_no) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {

			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = con.prepareStatement(DELETE_STMT);
			
			pstmt.setInt(1, rep_no);
			
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

	public ReportProductReviewsVO findByPK(Integer rep_no) {
		ReportProductReviewsVO ReportProductReviewsVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {

			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = con.prepareStatement(FIND_BY_PK);
			
			pstmt.setInt(1, rep_no);
			
			rs = pstmt.executeQuery();

			while (rs.next()) {
				ReportProductReviewsVO = new ReportProductReviewsVO();		
				ReportProductReviewsVO.setRep_no(rs.getInt("rep_no"));
				ReportProductReviewsVO.setPr_no(rs.getInt("pr_no"));
				ReportProductReviewsVO.setMem_no(rs.getInt("mem_no"));
				ReportProductReviewsVO.setReport_content(rs.getString("report_content"));
				ReportProductReviewsVO.setRep_status(rs.getString("rep_status"));
				ReportProductReviewsVO.setRep_date(rs.getTimestamp("rep_date"));			
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
		return ReportProductReviewsVO;
	}

	public List<ReportProductReviewsVO> getAll() {
		List<ReportProductReviewsVO> list = new ArrayList<ReportProductReviewsVO>();
		ReportProductReviewsVO ReportProductReviewsVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {

			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = con.prepareStatement(GET_ALL);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				ReportProductReviewsVO = new ReportProductReviewsVO();		
				ReportProductReviewsVO.setRep_no(rs.getInt("rep_no"));
				ReportProductReviewsVO.setPr_no(rs.getInt("pr_no"));
				ReportProductReviewsVO.setMem_no(rs.getInt("mem_no"));
				ReportProductReviewsVO.setReport_content(rs.getString("report_content"));
				ReportProductReviewsVO.setRep_status(rs.getString("rep_status"));
				ReportProductReviewsVO.setRep_date(rs.getTimestamp("rep_date"));			
				list.add(ReportProductReviewsVO); 
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
