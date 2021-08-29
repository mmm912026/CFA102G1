package com.rentalOrder.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RentalOrderJDBCDAO implements I_RentalOrderDAO{

	String DRIVER = "com.mysql.cj.jdbc.Driver";
	String URL = "jdbc:mysql://localhost:3306/CFA102G1?" 
			+ "rewriteBatchedStatements=true&serverTimezone=Asia/Taipei";
	String USER = "David";
	String PASSWORD = "123456";
	
	private static final String INSERT_STMT = 
			"INSERT INTO RENTAL_ORDER (mem_no,rpl_no,ro_pay_status,ro_pay_method,ro_ship_method,ro_ship_status,ro_ship_addrs,ro_starttime,ro_endtime,ro_oncerentendtime,ro_return_date,ro_day,ro_price,ro_totalprice,ro_deposit,ro_deposit_status,ro_return_status,ro_return_method,ro_product_status,ro_repaircost,ro_delay_days,ro_return_deposit) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	private static final String UPDATE_STMT = 
			"UPDATE RENTAL_ORDER set mem_no=?,rpl_no=?,ro_status=?,ro_pay_status=?,ro_pay_method=?,ro_ship_method=?,ro_ship_status=?,ro_ship_addrs=?,ro_starttime=?,ro_endtime=?,ro_oncerentendtime=?,ro_return_date=?,ro_day=?,ro_price=?,ro_totalprice=?,ro_deposit=?,ro_deposit_status=?,ro_return_status=?,ro_return_method=?,ro_product_status=?,ro_repaircost=?,ro_delay_days=?,ro_return_deposit=? where ro_no = ?";
	private static final String DELETE_STMT = 
			"DELETE FROM RENTAL_ORDER where ro_no = ?";
	private static final String FIND_BY_PK = 
			"SELECT * FROM RENTAL_ORDER WHERE ro_no = ?";
	private static final String GET_ALL = 
			"SELECT * FROM RENTAL_ORDER";
	
	public RentalOrderVO insert(RentalOrderVO rentalOrderVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {

			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = con.prepareStatement(INSERT_STMT,Statement.RETURN_GENERATED_KEYS);

			pstmt.setInt(1, rentalOrderVO.getMem_no());
			pstmt.setInt(2, rentalOrderVO.getRpl_no());
			pstmt.setString(3, rentalOrderVO.getRo_pay_status());
			pstmt.setString(4, rentalOrderVO.getRo_pay_method());
			pstmt.setString(5, rentalOrderVO.getRo_ship_method());
			pstmt.setString(6, rentalOrderVO.getRo_ship_status());
			pstmt.setString(7, rentalOrderVO.getRo_ship_addrs());
			pstmt.setTimestamp(8, rentalOrderVO.getRo_starttime());
			pstmt.setTimestamp(9, rentalOrderVO.getRo_endtime());
			pstmt.setTimestamp(10, rentalOrderVO.getRo_oncerentendtime());
			pstmt.setTimestamp(11, rentalOrderVO.getRo_return_date());
			pstmt.setInt(12, rentalOrderVO.getRo_day());
			pstmt.setInt(13, rentalOrderVO.getRo_price());
			pstmt.setInt(14, rentalOrderVO.getRo_totalprice());
			pstmt.setInt(15, rentalOrderVO.getRo_deposit());
			pstmt.setString(16, rentalOrderVO.getRo_deposit_status());
			pstmt.setString(17, rentalOrderVO.getRo_return_status());
			pstmt.setString(18, rentalOrderVO.getRo_return_method());
			pstmt.setString(19, rentalOrderVO.getRo_product_status());
			pstmt.setInt(20, rentalOrderVO.getRo_repaircost());
			pstmt.setInt(21, rentalOrderVO.getRo_delay_days());
			pstmt.setInt(22, rentalOrderVO.getRo_return_deposit());
			
			pstmt.executeUpdate();

			rs = pstmt.getGeneratedKeys();
			if(rs.next()) {
				rentalOrderVO.setRo_no(rs.getInt(1));
			}
			
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
		return rentalOrderVO;
	}

	public void update(RentalOrderVO rentalOrderVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {

			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = con.prepareStatement(UPDATE_STMT);
			
			pstmt.setInt(1, rentalOrderVO.getMem_no());
			pstmt.setInt(2, rentalOrderVO.getRpl_no());
			pstmt.setString(3, rentalOrderVO.getRo_status());
			pstmt.setString(4, rentalOrderVO.getRo_pay_status());
			pstmt.setString(5, rentalOrderVO.getRo_pay_method());
			pstmt.setString(6, rentalOrderVO.getRo_ship_method());
			pstmt.setString(7, rentalOrderVO.getRo_ship_status());
			pstmt.setString(8, rentalOrderVO.getRo_ship_addrs());
			pstmt.setTimestamp(9, rentalOrderVO.getRo_starttime());
			pstmt.setTimestamp(10, rentalOrderVO.getRo_endtime());
			pstmt.setTimestamp(11, rentalOrderVO.getRo_oncerentendtime());
			pstmt.setTimestamp(12, rentalOrderVO.getRo_return_date());
			pstmt.setInt(13, rentalOrderVO.getRo_day());
			pstmt.setInt(14, rentalOrderVO.getRo_price());
			pstmt.setInt(15, rentalOrderVO.getRo_totalprice());
			pstmt.setInt(16, rentalOrderVO.getRo_deposit());
			pstmt.setString(17, rentalOrderVO.getRo_deposit_status());
			pstmt.setString(18, rentalOrderVO.getRo_return_status());
			pstmt.setString(19, rentalOrderVO.getRo_return_method());
			pstmt.setString(20, rentalOrderVO.getRo_product_status());
			pstmt.setInt(21, rentalOrderVO.getRo_repaircost());
			pstmt.setInt(22, rentalOrderVO.getRo_delay_days());
			pstmt.setInt(23, rentalOrderVO.getRo_return_deposit());
			pstmt.setInt(24, rentalOrderVO.getRo_no());
			
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
		RentalOrderVO rentalOrderVO = null;
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
				rentalOrderVO = new RentalOrderVO();		
				rentalOrderVO.setRo_no(rs.getInt("ro_no"));
				rentalOrderVO.setMem_no(rs.getInt("mem_no"));
				rentalOrderVO.setRpl_no(rs.getInt("rpl_no"));
				rentalOrderVO.setRo_status(rs.getString("ro_status"));
				rentalOrderVO.setRo_pay_status(rs.getString("ro_pay_status"));
				rentalOrderVO.setRo_pay_method(rs.getString("ro_pay_method"));
				rentalOrderVO.setRo_ship_method(rs.getString("ro_ship_method"));
				rentalOrderVO.setRo_ship_status(rs.getString("ro_ship_status"));
				rentalOrderVO.setRo_ship_addrs(rs.getString("ro_ship_addrs"));
				rentalOrderVO.setRo_starttime(rs.getTimestamp("ro_starttime"));
				rentalOrderVO.setRo_endtime(rs.getTimestamp("ro_endtime"));				
				rentalOrderVO.setRo_oncerentendtime(rs.getTimestamp("ro_oncerentendtime"));				
				rentalOrderVO.setRo_return_date(rs.getTimestamp("ro_return_date"));				
				rentalOrderVO.setRo_day(rs.getInt("ro_day"));				
				rentalOrderVO.setRo_price(rs.getInt("ro_price"));				
				rentalOrderVO.setRo_totalprice(rs.getInt("ro_totalprice"));				
				rentalOrderVO.setRo_deposit(rs.getInt("ro_deposit"));				
				rentalOrderVO.setRo_deposit_status(rs.getString("ro_deposit_status"));				
				rentalOrderVO.setRo_return_status(rs.getString("ro_return_status"));				
				rentalOrderVO.setRo_return_method(rs.getString("ro_return_method"));				
				rentalOrderVO.setRo_product_status(rs.getString("ro_product_status"));				
				rentalOrderVO.setRo_repaircost(rs.getInt("ro_repaircost"));				
				rentalOrderVO.setRo_delay_days(rs.getInt("ro_delay_days"));				
				rentalOrderVO.setRo_return_deposit(rs.getInt("ro_return_deposit"));						
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
		return rentalOrderVO;
	}

	public List<RentalOrderVO> getAll() {
		// TODO Auto-generated method stub
		List<RentalOrderVO> list = new ArrayList<RentalOrderVO>();
		RentalOrderVO rentalOrderVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {

			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = con.prepareStatement(GET_ALL);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				rentalOrderVO = new RentalOrderVO();		
				rentalOrderVO.setRo_no(rs.getInt("ro_no"));
				rentalOrderVO.setMem_no(rs.getInt("mem_no"));
				rentalOrderVO.setRpl_no(rs.getInt("rpl_no"));
				rentalOrderVO.setRo_status(rs.getString("ro_status"));
				rentalOrderVO.setRo_pay_status(rs.getString("ro_pay_status"));
				rentalOrderVO.setRo_pay_method(rs.getString("ro_pay_method"));
				rentalOrderVO.setRo_ship_method(rs.getString("ro_ship_method"));
				rentalOrderVO.setRo_ship_status(rs.getString("ro_ship_status"));
				rentalOrderVO.setRo_ship_addrs(rs.getString("ro_ship_addrs"));
				rentalOrderVO.setRo_starttime(rs.getTimestamp("ro_starttime"));
				rentalOrderVO.setRo_endtime(rs.getTimestamp("ro_endtime"));				
				rentalOrderVO.setRo_oncerentendtime(rs.getTimestamp("ro_oncerentendtime"));				
				rentalOrderVO.setRo_return_date(rs.getTimestamp("ro_return_date"));				
				rentalOrderVO.setRo_day(rs.getInt("ro_day"));				
				rentalOrderVO.setRo_price(rs.getInt("ro_price"));				
				rentalOrderVO.setRo_totalprice(rs.getInt("ro_totalprice"));				
				rentalOrderVO.setRo_deposit(rs.getInt("ro_deposit"));				
				rentalOrderVO.setRo_deposit_status(rs.getString("ro_deposit_status"));				
				rentalOrderVO.setRo_return_status(rs.getString("ro_return_status"));				
				rentalOrderVO.setRo_return_method(rs.getString("ro_return_method"));				
				rentalOrderVO.setRo_product_status(rs.getString("ro_product_status"));				
				rentalOrderVO.setRo_repaircost(rs.getInt("ro_repaircost"));				
				rentalOrderVO.setRo_delay_days(rs.getInt("ro_delay_days"));				
				rentalOrderVO.setRo_return_deposit(rs.getInt("ro_return_deposit"));
				list.add(rentalOrderVO);
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
