package com.rentalOrder.model;


import java.sql.*;
import java.util.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class RentalOrderDAO implements I_RentalOrderDAO{

	private static DataSource ds = null;
	static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/David");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	private static final String INSERT_STMT = 
			"INSERT INTO RENTAL_ORDER (mem_no,rpl_no,ro_ship_method,ro_ship_addrs,ro_starttime,ro_endtime,ro_day,ro_price,ro_totalprice,ro_deposit) VALUES(?,?,?,?,?,?,?,?,?,?)";
	private static final String UPDATE_STMT = 
			"UPDATE RENTAL_ORDER set mem_no=?,rpl_no=?,ro_status=?,ro_ship_method=?,ro_ship_addrs=?,ro_starttime=?,ro_endtime=?,ro_oncerentendtime=?,ro_return_date=?,ro_day=?,ro_price=?,ro_totalprice=?,ro_deposit=?,ro_deposit_status=?,ro_return_status=?,ro_product_status=?,ro_repaircost=?,ro_delay_days=?,ro_return_deposit=? where ro_no = ?";
	private static final String DELETE_STMT = 
			"DELETE FROM RENTAL_ORDER where ro_no = ?";
	private static final String FIND_BY_PK = 
			"SELECT * FROM RENTAL_ORDER WHERE ro_no = ?";
	private static final String GET_ALL = 
			"SELECT * FROM RENTAL_ORDER order by ro_no desc";
	private static final String FindOneRplForRent = 
			"SELECT * FROM RENTAL_PRODUCT_LIST where RC_NO=? and RPL_status='待租' order by RPL_RENTCOUNT asc";
	private static final String ChangeOneRplStatusToReserved = 
			"Update RENTAL_PRODUCT_LIST set rpl_status='預約' where rpl_no=? and rpl_status='待租'";
	private static final String ChangeOneRoStatusToWaitDeliver = 
			"Update RENTAL_ORDER set ro_status='已付款,待出貨',ro_deposit_status='已收取' where ro_no=? and ro_status='未付款'";
	private static final String ChangeOneRoStatusToOnRent = 
			"Update RENTAL_ORDER set ro_status='租賃中' where ro_no=? and ro_status='已付款,待出貨'";	
	private static final String ChangeOneRplStatusToOnRent = 
			"Update RENTAL_PRODUCT_LIST set rpl_status='租賃中' where rpl_no=? and rpl_status='預約'";	
	private static final String FindByRoStatus = 
			"SELECT * FROM RENTAL_ORDER where ro_status= ?";	
	
	public RentalOrderVO insert(RentalOrderVO rentalOrderVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(INSERT_STMT,Statement.RETURN_GENERATED_KEYS);

			pstmt.setInt(1, rentalOrderVO.getMem_no());
			pstmt.setInt(2, rentalOrderVO.getRpl_no());
			pstmt.setString(3, rentalOrderVO.getRo_ship_method());
			pstmt.setString(4, rentalOrderVO.getRo_ship_addrs());
			pstmt.setDate(5, rentalOrderVO.getRo_starttime());
			pstmt.setDate(6, rentalOrderVO.getRo_endtime());
			pstmt.setInt(7, rentalOrderVO.getRo_day());
			pstmt.setInt(8, rentalOrderVO.getRo_price());
			pstmt.setInt(9, rentalOrderVO.getRo_totalprice());
			pstmt.setInt(10, rentalOrderVO.getRo_deposit());
			
			pstmt.executeUpdate();

			rs = pstmt.getGeneratedKeys();
			if(rs.next()) {
				rentalOrderVO.setRo_no(rs.getInt(1));
			}
			
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
		} finally {
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

			con = ds.getConnection();
			pstmt = con.prepareStatement(UPDATE_STMT);
			
			pstmt.setInt(1, rentalOrderVO.getMem_no());
			pstmt.setInt(2, rentalOrderVO.getRpl_no());
			pstmt.setString(3, rentalOrderVO.getRo_status());	
			pstmt.setString(4, rentalOrderVO.getRo_ship_method());
			pstmt.setString(5, rentalOrderVO.getRo_ship_addrs());
			pstmt.setDate(6, rentalOrderVO.getRo_starttime());
			pstmt.setDate(7, rentalOrderVO.getRo_endtime());
			pstmt.setDate(8, rentalOrderVO.getRo_oncerentendtime());
			pstmt.setDate(9, rentalOrderVO.getRo_return_date());
			pstmt.setInt(10, rentalOrderVO.getRo_day());
			pstmt.setInt(11, rentalOrderVO.getRo_price());
			pstmt.setInt(12, rentalOrderVO.getRo_totalprice());
			pstmt.setInt(13, rentalOrderVO.getRo_deposit());
			pstmt.setString(14, rentalOrderVO.getRo_deposit_status());
			pstmt.setString(15, rentalOrderVO.getRo_return_status());
			pstmt.setString(16, rentalOrderVO.getRo_product_status());
			pstmt.setInt(17, rentalOrderVO.getRo_repaircost());
			pstmt.setInt(18, rentalOrderVO.getRo_delay_days());
			pstmt.setInt(19, rentalOrderVO.getRo_return_deposit());
			pstmt.setInt(20, rentalOrderVO.getRo_no());
			
			pstmt.executeUpdate();

		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
		} finally {
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

			con = ds.getConnection();
			pstmt = con.prepareStatement(DELETE_STMT);
			
			pstmt.setInt(1, ro_no);
			
			pstmt.executeUpdate();

		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
		} finally {
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

			con = ds.getConnection();
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
				rentalOrderVO.setRo_starttime(rs.getDate("ro_starttime"));
				rentalOrderVO.setRo_endtime(rs.getDate("ro_endtime"));				
				rentalOrderVO.setRo_oncerentendtime(rs.getDate("ro_oncerentendtime"));				
				rentalOrderVO.setRo_return_date(rs.getDate("ro_return_date"));				
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

		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
		} finally {
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
		List<RentalOrderVO> list = new ArrayList<RentalOrderVO>();
		RentalOrderVO rentalOrderVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {

			con = ds.getConnection();
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
				rentalOrderVO.setRo_starttime(rs.getDate("ro_starttime"));
				rentalOrderVO.setRo_endtime(rs.getDate("ro_endtime"));				
				rentalOrderVO.setRo_oncerentendtime(rs.getDate("ro_oncerentendtime"));				
				rentalOrderVO.setRo_return_date(rs.getDate("ro_return_date"));				
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

		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
		} finally {
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

	public Integer findOneForRent(Integer rc_no) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Integer rpl_no = null;
		
		try {

			con = ds.getConnection();
			
			con.setAutoCommit(false);
			
			pstmt = con.prepareStatement(FindOneRplForRent);
			pstmt.setInt(1, rc_no);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				rpl_no = rs.getInt("rpl_no");
				break;
			}
			
			pstmt = con.prepareStatement(ChangeOneRplStatusToReserved);
			pstmt.setInt(1, rpl_no);
			pstmt.executeUpdate();
			
			con.commit();
			con.setAutoCommit(true);

		}catch (NullPointerException e) {
			throw new RuntimeException("此商品目前已無庫存"
					);
		}catch (SQLException se) {
			if (con != null) {
				try {
					// 3●設定於當有exception發生時之catch區塊內
					con.rollback();
				} catch (SQLException excep) {
					throw new RuntimeException("rollback error occured. "
							+ excep.getMessage());
				}
			}
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		return rpl_no;
	}

	public void changeROToWaitDeliver(Integer ro_no) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(ChangeOneRoStatusToWaitDeliver);
			
			pstmt.setInt(1, ro_no);
			
			pstmt.executeUpdate();
			
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		
	}

	public void changeROToOnRent(Integer ro_no,Integer rpl_no) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {

			con = ds.getConnection();
			
			con.setAutoCommit(false);
			
			pstmt = con.prepareStatement(ChangeOneRoStatusToOnRent);
			pstmt.setInt(1, ro_no);
			pstmt.executeUpdate();
			
			pstmt = con.prepareStatement(ChangeOneRplStatusToOnRent);
			pstmt.setInt(1, rpl_no);
			pstmt.executeUpdate();
			
			con.commit();
			con.setAutoCommit(true);
			
		} catch (SQLException se) {
			if (con != null) {
				try {
					// 3●設定於當有exception發生時之catch區塊內
					con.rollback();
				} catch (SQLException excep) {
					throw new RuntimeException("rollback error occured. "
							+ excep.getMessage());
				}
			}
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}	
	}

	public List<RentalOrderVO> findByRoStatus(String ro_status) {
		List<RentalOrderVO> list = new ArrayList<RentalOrderVO>();
		RentalOrderVO rentalOrderVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(FindByRoStatus);
			pstmt.setString(1, ro_status);	
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
				rentalOrderVO.setRo_starttime(rs.getDate("ro_starttime"));
				rentalOrderVO.setRo_endtime(rs.getDate("ro_endtime"));				
				rentalOrderVO.setRo_oncerentendtime(rs.getDate("ro_oncerentendtime"));				
				rentalOrderVO.setRo_return_date(rs.getDate("ro_return_date"));				
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

		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
		} finally {
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
