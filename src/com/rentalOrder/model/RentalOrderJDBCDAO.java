package com.rentalOrder.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RentalOrderJDBCDAO implements I_RentalOrderDAO{

	String DRIVER = "com.mysql.cj.jdbc.Driver";
	String URL = "jdbc:mysql://localhost:3306/CFA102G1?" 
			+ "rewriteBatchedStatements=true&serverTimezone=Asia/Taipei";
	String USER = "David";
	String PASSWORD = "123456";
	
	private static final String INSERT_STMT = 
			"INSERT INTO RENTAL_ORDER (mem_no,rpl_no,ro_status,ro_pay_status,ro_pay_method,ro_ship_method,ro_ship_status,ro_ship_addrs,ro_starttime,ro_endtime,ro_oncerentendtime,ro_return_date,ro_day,ro_price,ro_totalprice,ro_deposit,ro_deposit_status,ro_return_status,ro_return_method,ro_product_status,ro_repaircost,ro_delay_days,ro_return_deposit) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	private static final String UPDATE_STMT = 
			"UPDATE RENTAL_ORDER set mem_no=?,rpl_no=?,ro_status=?,ro_pay_status=?,ro_pay_method=?,ro_ship_method=?,ro_ship_status=?,ro_ship_addrs=?,ro_starttime=?,ro_endtime=?,ro_oncerentendtime=?,ro_return_date=?,ro_day=?,ro_price=?,ro_totalprice=?,ro_deposit=?,ro_deposit_status=?,ro_return_status=?,ro_return_method=?,ro_product_status=?,ro_repaircost=?,ro_delay_days=?,ro_return_deposit=? where ro_no = ?";
	private static final String DELETE_STMT = 
			"DELETE FROM RENTAL_ORDER where ro_no = ?";
	private static final String FIND_BY_PK = 
			"SELECT * FROM RENTAL_ORDER WHERE ro_no = ?";
	private static final String GET_ALL = 
			"SELECT * FROM RENTAL_ORDER";
	
	public void insert(RentalOrderVO RentalOrderVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {

			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setInt(1, RentalOrderVO.getMem_no());
			pstmt.setInt(2, RentalOrderVO.getRpl_no());
			pstmt.setString(3, RentalOrderVO.getRo_status());
			pstmt.setString(4, RentalOrderVO.getRo_pay_status());
			pstmt.setString(5, RentalOrderVO.getRo_pay_method());
			pstmt.setString(6, RentalOrderVO.getRo_ship_method());
			pstmt.setString(7, RentalOrderVO.getRo_ship_status());
			pstmt.setString(8, RentalOrderVO.getRo_ship_addrs());
			pstmt.setTimestamp(9, RentalOrderVO.getRo_starttime());
			pstmt.setTimestamp(10, RentalOrderVO.getRo_endtime());
			pstmt.setTimestamp(11, RentalOrderVO.getRo_oncerentendtime());
			pstmt.setTimestamp(12, RentalOrderVO.getRo_return_date());
			pstmt.setInt(13, RentalOrderVO.getRo_day());
			pstmt.setInt(14, RentalOrderVO.getRo_price());
			pstmt.setInt(15, RentalOrderVO.getRo_totalprice());
			pstmt.setInt(16, RentalOrderVO.getRo_deposit());
			pstmt.setString(17, RentalOrderVO.getRo_deposit_status());
			pstmt.setString(18, RentalOrderVO.getRo_return_status());
			pstmt.setString(19, RentalOrderVO.getRo_return_method());
			pstmt.setString(20, RentalOrderVO.getRo_product_status());
			pstmt.setInt(21, RentalOrderVO.getRo_repaircost());
			pstmt.setInt(22, RentalOrderVO.getRo_delay_days());
			pstmt.setInt(23, RentalOrderVO.getRo_return_deposit());
			
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

	public void update(RentalOrderVO RentalOrderVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {

			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = con.prepareStatement(UPDATE_STMT);
			
			pstmt.setInt(1, RentalOrderVO.getMem_no());
			pstmt.setInt(2, RentalOrderVO.getRpl_no());
			pstmt.setString(3, RentalOrderVO.getRo_status());
			pstmt.setString(4, RentalOrderVO.getRo_pay_status());
			pstmt.setString(5, RentalOrderVO.getRo_pay_method());
			pstmt.setString(6, RentalOrderVO.getRo_ship_method());
			pstmt.setString(7, RentalOrderVO.getRo_ship_status());
			pstmt.setString(8, RentalOrderVO.getRo_ship_addrs());
			pstmt.setTimestamp(9, RentalOrderVO.getRo_starttime());
			pstmt.setTimestamp(10, RentalOrderVO.getRo_endtime());
			pstmt.setTimestamp(11, RentalOrderVO.getRo_oncerentendtime());
			pstmt.setTimestamp(12, RentalOrderVO.getRo_return_date());
			pstmt.setInt(13, RentalOrderVO.getRo_day());
			pstmt.setInt(14, RentalOrderVO.getRo_price());
			pstmt.setInt(15, RentalOrderVO.getRo_totalprice());
			pstmt.setInt(16, RentalOrderVO.getRo_deposit());
			pstmt.setString(17, RentalOrderVO.getRo_deposit_status());
			pstmt.setString(18, RentalOrderVO.getRo_return_status());
			pstmt.setString(19, RentalOrderVO.getRo_return_method());
			pstmt.setString(20, RentalOrderVO.getRo_product_status());
			pstmt.setInt(21, RentalOrderVO.getRo_repaircost());
			pstmt.setInt(22, RentalOrderVO.getRo_delay_days());
			pstmt.setInt(23, RentalOrderVO.getRo_return_deposit());
			pstmt.setInt(24, RentalOrderVO.getRo_no());
			
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

	public void delete(Integer ro_no) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {

			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = con.prepareStatement(DELETE_STMT);
			
			pstmt.setInt(1, ro_no);
			
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

	public RentalOrderVO findByPK(Integer ro_no) {
		RentalOrderVO RentalOrderVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {

			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = con.prepareStatement(FIND_BY_PK);
			
			pstmt.setInt(1, ro_no);
			
			rs = pstmt.executeQuery();

			while (rs.next()) {
				RentalOrderVO = new RentalOrderVO();		
				RentalOrderVO.setRo_no(rs.getInt("ro_no"));
				RentalOrderVO.setMem_no(rs.getInt("mem_no"));
				RentalOrderVO.setRpl_no(rs.getInt("rpl_no"));
				RentalOrderVO.setRo_status(rs.getString("ro_status"));
				RentalOrderVO.setRo_pay_status(rs.getString("ro_pay_status"));
				RentalOrderVO.setRo_pay_method(rs.getString("ro_pay_method"));
				RentalOrderVO.setRo_ship_method(rs.getString("ro_ship_method"));
				RentalOrderVO.setRo_ship_status(rs.getString("ro_ship_status"));
				RentalOrderVO.setRo_ship_addrs(rs.getString("ro_ship_addrs"));
				RentalOrderVO.setRo_starttime(rs.getTimestamp("ro_starttime"));
				RentalOrderVO.setRo_endtime(rs.getTimestamp("ro_endtime"));				
				RentalOrderVO.setRo_oncerentendtime(rs.getTimestamp("ro_oncerentendtime"));				
				RentalOrderVO.setRo_return_date(rs.getTimestamp("ro_return_date"));				
				RentalOrderVO.setRo_day(rs.getInt("ro_day"));				
				RentalOrderVO.setRo_price(rs.getInt("ro_price"));				
				RentalOrderVO.setRo_totalprice(rs.getInt("ro_totalprice"));				
				RentalOrderVO.setRo_deposit(rs.getInt("ro_deposit"));				
				RentalOrderVO.setRo_deposit_status(rs.getString("ro_deposit_status"));				
				RentalOrderVO.setRo_return_status(rs.getString("ro_return_status"));				
				RentalOrderVO.setRo_return_method(rs.getString("ro_return_method"));				
				RentalOrderVO.setRo_product_status(rs.getString("ro_product_status"));				
				RentalOrderVO.setRo_repaircost(rs.getInt("ro_repaircost"));				
				RentalOrderVO.setRo_delay_days(rs.getInt("ro_delay_days"));				
				RentalOrderVO.setRo_return_deposit(rs.getInt("ro_return_deposit"));						
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
		return RentalOrderVO;
	}

	public List<RentalOrderVO> getAll() {
		// TODO Auto-generated method stub
		List<RentalOrderVO> list = new ArrayList<RentalOrderVO>();
		RentalOrderVO RentalOrderVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {

			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = con.prepareStatement(GET_ALL);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				RentalOrderVO = new RentalOrderVO();		
				RentalOrderVO.setRo_no(rs.getInt("ro_no"));
				RentalOrderVO.setMem_no(rs.getInt("mem_no"));
				RentalOrderVO.setRpl_no(rs.getInt("rpl_no"));
				RentalOrderVO.setRo_status(rs.getString("ro_status"));
				RentalOrderVO.setRo_pay_status(rs.getString("ro_pay_status"));
				RentalOrderVO.setRo_pay_method(rs.getString("ro_pay_method"));
				RentalOrderVO.setRo_ship_method(rs.getString("ro_ship_method"));
				RentalOrderVO.setRo_ship_status(rs.getString("ro_ship_status"));
				RentalOrderVO.setRo_ship_addrs(rs.getString("ro_ship_addrs"));
				RentalOrderVO.setRo_starttime(rs.getTimestamp("ro_starttime"));
				RentalOrderVO.setRo_endtime(rs.getTimestamp("ro_endtime"));				
				RentalOrderVO.setRo_oncerentendtime(rs.getTimestamp("ro_oncerentendtime"));				
				RentalOrderVO.setRo_return_date(rs.getTimestamp("ro_return_date"));				
				RentalOrderVO.setRo_day(rs.getInt("ro_day"));				
				RentalOrderVO.setRo_price(rs.getInt("ro_price"));				
				RentalOrderVO.setRo_totalprice(rs.getInt("ro_totalprice"));				
				RentalOrderVO.setRo_deposit(rs.getInt("ro_deposit"));				
				RentalOrderVO.setRo_deposit_status(rs.getString("ro_deposit_status"));				
				RentalOrderVO.setRo_return_status(rs.getString("ro_return_status"));				
				RentalOrderVO.setRo_return_method(rs.getString("ro_return_method"));				
				RentalOrderVO.setRo_product_status(rs.getString("ro_product_status"));				
				RentalOrderVO.setRo_repaircost(rs.getInt("ro_repaircost"));				
				RentalOrderVO.setRo_delay_days(rs.getInt("ro_delay_days"));				
				RentalOrderVO.setRo_return_deposit(rs.getInt("ro_return_deposit"));
				list.add(RentalOrderVO);
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
