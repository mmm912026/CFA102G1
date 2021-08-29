package com.staff.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class StaffJDBCDAO implements I_StaffDAO{
	public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	public static final String URL = "jdbc:mysql://localhost:3306/CFA102G1?serverTimezone=Asia/Taipei";
	public static final String USER = "David";
	public static final String PASSWORD = "123456";
	
	private static final String INSERT_SQL = 
			"INSERT INTO CFA102G1.STAFF (STAFF_NAME,STAFF_GENDER,STAFF_PHONE,STAFF_EMAIL,STAFF_ADDRESS,STAFF_ACCOUNT,STAFF_PASSWORD,STAFF_STA)VALUES(?,?,?,?,?,?,?,?)"; 
	private static final String UPDATE_SQL = 
			"UPDATE CFA102G1.STAFF SET  STAFF_NAME = ?, STAFF_GENDER = ?, STAFF_PHONE = ?, STAFF_EMAIL = ?, STAFF_ADDRESS = ?, STAFF_ACCOUNT = ?, STAFF_PASSWORD = ?,STAFF_STA = ? WHERE STAFF_NO = ?";
	private static final String DELETE_SQL = 
			"DELETE FROM CFA102G1.STAFF where STAFF_NO = ?";
	private static final String FIND_BY_STAFF_NO_SQL = 
			"SELECT * FROM CFA102G1.STAFF WHERE STAFF_NO = ?";
	private static final String FIND_BY_STAFF_NAME_SQL =
			"SELECT STAFF_NO,STAFF_NAME,STAFF_GENDER,STAFF_PHONE,STAFF_EMAIL,STAFF_ADDRESS,STAFF_ACCOUNT,STAFF_PASSWORD,STAFF_STA FROM CFA102G1.STAFF WHERE UPPER(STAFF_NAME) LIKE UPPER(?)";
	private static final String FIND_BY_STAFF_PHONE_SQL =
			"SELECT STAFF_NO,STAFF_NAME,STAFF_GENDER,STAFF_PHONE,STAFF_EMAIL,STAFF_ADDRESS,STAFF_ACCOUNT,STAFF_PASSWORD,STAFF_STA FROM CFA102G1.STAFF WHERE UPPER(STAFF_PHONE) LIKE UPPER(?)";
	private static final String GET_ALL =
			"SELECT STAFF_NO,STAFF_NAME,STAFF_GENDER,STAFF_PHONE,STAFF_EMAIL,STAFF_ADDRESS,STAFF_ACCOUNT,STAFF_PASSWORD,STAFF_STA FROM CFA102G1.STAFF";
	
	static {
		try {
			Class.forName(DRIVER);
		}catch (ClassNotFoundException ce) {
			ce.printStackTrace();
		}
	}
	
	@Override
	public StaffVO insert(StaffVO staff) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		
		try {
			
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = con.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS);
			
			pstmt.setString(1,staff.getStaff_name());
			pstmt.setString(2, staff.getStaff_gender());
			pstmt.setInt(3, staff.getStaff_phone());
			pstmt.setString(4, staff.getStaff_email());
			pstmt.setString(5, staff.getStaff_address());
			pstmt.setString(6, staff.getStaff_account());
			pstmt.setString(7, staff.getStaff_password());
			pstmt.setString(8, staff.getStaff_sta());
			
			pstmt.executeUpdate();
			
					}catch (SQLException se) {
			se.printStackTrace();
		}finally {
			if(con !=null) {
				try {
					con.close();
				}catch (SQLException se) {
					se.printStackTrace();
				}
			}
		}
		return staff;
	}
	@Override
	public void update(StaffVO staff) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		
		try {
			
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = con.prepareStatement(UPDATE_SQL);
			
			
			pstmt.setString(1,staff.getStaff_name());
			pstmt.setString(2, staff.getStaff_gender());
			pstmt.setInt(3, staff.getStaff_phone());
			pstmt.setString(4, staff.getStaff_email());
			pstmt.setString(5, staff.getStaff_address());
			pstmt.setString(6, staff.getStaff_account());
			pstmt.setString(7, staff.getStaff_password());
			pstmt.setString(8, staff.getStaff_sta());
			pstmt.setInt(9, staff.getStaff_no());
			
			pstmt.executeUpdate();
			
					}catch (SQLException se) {
			se.printStackTrace();
		}finally {
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
	public void delete(Integer staff_no) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = con.prepareStatement(DELETE_SQL);

			pstmt.setInt(1, staff_no);			
			
			pstmt.executeUpdate();
		}catch (SQLException se) {
			se.printStackTrace();
		}finally {
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
	public StaffVO findByStaff_no(Integer staff_no) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		StaffVO staff = null;
		
		try {
			con = DriverManager.getConnection(URL,USER,PASSWORD);
			pstmt = con.prepareStatement(FIND_BY_STAFF_NO_SQL);
			pstmt.setInt(1,staff_no );
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				staff = new StaffVO();
				staff.setStaff_no(staff_no);
				staff.setStaff_name(rs.getString("STAFF_NAME"));
				staff.setStaff_gender(rs.getString("STAFF_GENDER"));
				staff.setStaff_phone(rs.getInt("STAFF_PHONE"));
				staff.setStaff_email(rs.getString("STAFF_EMAIL"));
				staff.setStaff_address(rs.getString("STAFF_ADDRESS"));
				staff.setStaff_account(rs.getString("STAFF_ACCOUNT"));
				staff.setStaff_password(rs.getString("STAFF_PASSWORD"));
				staff.setStaff_sta(rs.getString("STAFF_STA"));
				
			}
			
		}catch (SQLException se) {
			se.printStackTrace();
		}finally {
			if(con != null) {
				try {
					con.close();
				}catch (SQLException se) {
					se.printStackTrace();
				}
			}
		}
		
		return staff;
	}	
	
	
	@Override
	public List<StaffVO> findByStaff_name(String staff_name) {
		List<StaffVO> list = new ArrayList<StaffVO>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		StaffVO staff = null;
		
		try {
			con = DriverManager.getConnection(URL,USER,PASSWORD);
			pstmt = con.prepareStatement(FIND_BY_STAFF_NAME_SQL);
			pstmt.setString(1,staff_name);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				staff = new StaffVO();
				staff.setStaff_no(rs.getInt("STAFF_NO"));
				staff.setStaff_name(rs.getString("STAFF_NAME"));
				staff.setStaff_gender(rs.getString("STAFF_GENDER"));
				staff.setStaff_phone(rs.getInt("STAFF_PHONE"));
				staff.setStaff_email(rs.getString("STAFF_EMAIL"));
				staff.setStaff_address(rs.getString("STAFF_ADDRESS"));
				staff.setStaff_account(rs.getString("STAFF_ACCOUNT"));
				staff.setStaff_password(rs.getString("STAFF_PASSWORD"));
				staff.setStaff_sta(rs.getString("STAFF_STA"));
				list.add(staff);
				
			}
		}catch (SQLException se) {
			se.printStackTrace();
		}finally {
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
	@Override
	public List<StaffVO> findByStaff_phone(Integer staff_phone) {
		List<StaffVO> list = new ArrayList<StaffVO>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		StaffVO staff = null;
		
		try {
			con = DriverManager.getConnection(URL,USER,PASSWORD);
			pstmt = con.prepareStatement(FIND_BY_STAFF_PHONE_SQL);
			pstmt.setInt(1,staff_phone);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				staff = new StaffVO();
				staff.setStaff_no(rs.getInt("STAFF_NO"));
				staff.setStaff_name(rs.getString("STAFF_NAME"));
				staff.setStaff_gender(rs.getString("STAFF_GENDER"));
				staff.setStaff_phone(rs.getInt("STAFF_PHONE"));
				staff.setStaff_email(rs.getString("STAFF_EMAIL"));
				staff.setStaff_address(rs.getString("STAFF_ADDRESS"));
				staff.setStaff_account(rs.getString("STAFF_ACCOUNT"));
				staff.setStaff_password(rs.getString("STAFF_PASSWORD"));
				staff.setStaff_sta(rs.getString("STAFF_STA"));
				list.add(staff);
				
			}
		}catch (SQLException se) {
			se.printStackTrace();
		}finally {
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
	@Override
	public List<StaffVO> getAll() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<StaffVO> list = new ArrayList<StaffVO>();
		StaffVO staffVO = null;
		try {
			con = DriverManager.getConnection(URL,USER,PASSWORD);
			pstmt = con.prepareStatement(GET_ALL);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				staffVO = new StaffVO();
				
				staffVO.setStaff_no(rs.getInt("STAFF_NO"));
				staffVO.setStaff_name(rs.getString("STAFF_NAME"));
				staffVO.setStaff_gender(rs.getString("STAFF_GENDER"));
				staffVO.setStaff_phone(rs.getInt("STAFF_PHONE"));
				staffVO.setStaff_email(rs.getString("STAFF_EMAIL"));
				staffVO.setStaff_address(rs.getString("STAFF_ADDRESS"));
				staffVO.setStaff_account(rs.getString("STAFF_ACCOUNT"));
				staffVO.setStaff_password(rs.getString("STAFF_PASSWORD"));
				staffVO.setStaff_sta(rs.getString("STAFF_STA"));
				
				list.add(staffVO);
				
			}
			
		}catch (SQLException se) {
			se.printStackTrace();
		}finally {
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
//		public static void main(String[] args) {
			
			//新增員工資料
//			StaffJDBCDAO dao = new StaffJDBCDAO();
//			StaffVO staff = new StaffVO();
//
//			staff.setSTAFF_NAME("TOYA");
//			staff.setSTAFF_GENDER("男");
//			staff.setSTAFF_PHONE(959991255);
//			staff.setSTAFF_EMAIL("dasfe22@gmail.com");
//			staff.setSTAFF_ADDRESS("桃園市中壢區央中路2段110號");
//			staff.setSTAFF_ACCOUNT("sadf6");
//			staff.setSTAFF_PASSWORD("vbdfge55");
//			staff.setSTAFF_STA("正常");
//			dao.insert(staff);
//			
//			
			//System.out.println("---------------------------------------------------");
			//用員工編號查詢
//			StaffJDBCDAO dao = new StaffJDBCDAO();
//			StaffVO list1 = dao.findByStaff_no(2);
//			    System.out.print(list1.getSTAFF_NO()+"\t");
//			    System.out.print(list1.getSTAFF_NAME()+"\t");
//			    System.out.print(list1.getSTAFF_GENDER()+"\t");
//			    System.out.print(list1.getSTAFF_PHONE()+"\t");
//			    System.out.print(list1.getSTAFF_EMAIL()+"\t");
//			    System.out.print(list1.getSTAFF_ADDRESS()+"\t");
//			    System.out.print(list1.getSTAFF_ACCOUNT()+"\t");
//			    System.out.print(list1.getSTAFF_PASSWORD()+"\t");
//			    System.out.print(list1.getSTAFF_STA()+"\t");
//			    System.out.println();
			
			//System.out.println("---------------------------------------------------");
			//用名字查詢
//			StaffJDBCDAO dao = new StaffJDBCDAO();
//			List<StaffVO> nameList = dao.findByStaff_name("nami");
//			for (StaffVO staffVOName : nameList) {
//				
//				System.out.print(staffVOName.getSTAFF_NO()+"\t");
//				System.out.print(staffVOName.getSTAFF_NAME()+"\t");
//				System.out.print(staffVOName.getSTAFF_GENDER()+"\t");
//				System.out.print(staffVOName.getSTAFF_PHONE()+"\t");
//				System.out.print(staffVOName.getSTAFF_EMAIL()+"\t");
//				System.out.print(staffVOName.getSTAFF_ADDRESS()+"\t");
//				System.out.print(staffVOName.getSTAFF_ACCOUNT()+"\t");
//				System.out.print(staffVOName.getSTAFF_PASSWORD()+"\t");
//				System.out.print(staffVOName.getSTAFF_STA()+"\t");
//				System.out.println();
//			}
			//System.out.println("---------------------------------------------------");
			//搜尋全部
//			StaffJDBCDAO dao = new StaffJDBCDAO();
//			List<StaffVO> list = dao.getAll();
//			for (StaffVO staffVO : list ) {
//				
//			    System.out.print(staffVO.getSTAFF_NO()+"\t");
//			    System.out.print(staffVO.getSTAFF_NAME()+"\t");
//			    System.out.print(staffVO.getSTAFF_GENDER()+"\t");
//			    System.out.print(staffVO.getSTAFF_PHONE()+"\t");
//			    System.out.print(staffVO.getSTAFF_EMAIL()+"\t");
//			    System.out.print(staffVO.getSTAFF_ADDRESS()+"\t");
//			    System.out.print(staffVO.getSTAFF_ACCOUNT()+"\t");
//			    System.out.print(staffVO.getSTAFF_PASSWORD()+"\t");
//			    System.out.print(staffVO.getSTAFF_STA()+"\t");
//			    System.out.println();
//			}
//			System.out.println("-------------------------------------------");
			
			//用手機號麻搜尋
//			StaffJDBCDAO dao = new StaffJDBCDAO();
//			List<StaffVO> list = dao.findByStaff_phone(988648216);
//			for (StaffVO staffphone : list) {
//				
//				System.out.print(staffphone.getSTAFF_NO()+"\t");
//				System.out.print(staffphone.getSTAFF_NAME()+"\t");
//				System.out.print(staffphone.getSTAFF_GENDER()+"\t");
//				System.out.print(staffphone.getSTAFF_PHONE()+"\t");
//				System.out.print(staffphone.getSTAFF_EMAIL()+"\t");
//				System.out.print(staffphone.getSTAFF_ADDRESS()+"\t");
//				System.out.print(staffphone.getSTAFF_ACCOUNT()+"\t");
//				System.out.print(staffphone.getSTAFF_PASSWORD()+"\t");
//				System.out.print(staffphone.getSTAFF_STA()+"\t");
//				System.out.println();
//			}
			//System.out.println("---------------------------------------------------");
			
			//修改
//			StaffJDBCDAO dao = new StaffJDBCDAO();
//			StaffVO staff = new StaffVO();
//			
//			staff.setSTAFF_NAME("minako");
//			staff.setSTAFF_GENDER("女");
//			staff.setSTAFF_PHONE(974455553);	
//			staff.setSTAFF_EMAIL("msdfw223@gmail.com");
//			staff.setSTAFF_ADDRESS("桃園市新屋區中正路777號");
//			staff.setSTAFF_ACCOUNT("t05sdf");
//			staff.setSTAFF_PASSWORD("rass35");
//			staff.setSTAFF_STA("正常");
//			staff.setSTAFF_NO(3);
//			
//			dao.update(staff);
//			
//		}
		//System.out.println("---------------------------------------------------");
			//刪除
//			StaffJDBCDAO dao = new StaffJDBCDAO();
//			dao.delete(3);
//			    System.out.println("已刪除");
//			System.out.println("-------------------------------------------");
//		
//		
//		}
	}