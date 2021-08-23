package com.member.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MemberJDBCDAO implements I_MemberDAO{
	public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	public static final String URL = "jdbc:mysql://localhost:3306/CFA102G1?serverTimezone=Asia/Taipei";
	public static final String USER = "David";
	public static final String PASSWORD = "123456";
	
	private static final String INSERT_SQL = 
			"INSERT INTO CFA102G1.MEMBER (MEM_NAME,MEM_GENDER,MEM_PHONE,MEM_EMAIL,MEM_ADDRESS,MEM_ACCOUNT,MEM_PASSWORD,MEM_BIRTH,MEM_STA)VALUES(?,?,?,?,?,?,?,?,?)";    
	private static final String UPDATE_SQL = 
			"UPDATE CFA102G1.MEMBER SET  MEM_NAME = ?, MEM_GENDER = ?, MEM_PHONE = ?, MEM_EMAIL = ?, MEM_ADDRESS = ?, MEM_ACCOUNT = ?, MEM_PASSWORD = ?, MEM_BIRTH = ?,MEM_STA = ? WHERE MEM_NO = ?";
	private static final String DELETE_SQL = 
			"DELETE FROM CFA102G1.MEMBER where MEM_NO = ?";
	private static final String FIND_BY_MEM_NO_SQL = 
			"SELECT * FROM CFA102G1.MEMBER WHERE MEM_NO = ?";
	private static final String FIND_BY_MEM_NAME_SQL =
			"SELECT MEM_NO,MEM_NAME,MEM_GENDER,MEM_PHONE,MEM_EMAIL,MEM_ADDRESS,MEM_ACCOUNT,MEM_PASSWORD,MEM_BIRTH,MEM_STA FROM CFA102G1.MEMBER WHERE UPPER(MEM_NAME) LIKE UPPER(?)";
	private static final String FIND_BY_MEM_PHONE_SQL =
			"SELECT MEM_NO,MEM_NAME,MEM_GENDER,MEM_PHONE,MEM_EMAIL,MEM_ADDRESS,MEM_ACCOUNT,MEM_PASSWORD,MEM_BIRTH,MEM_STA FROM CFA102G1.MEMBER WHERE UPPER(MEM_PHONE) LIKE UPPER(?)";
	private static final String GET_ALL =
			"SELECT MEM_NO,MEM_NAME,MEM_GENDER,MEM_PHONE,MEM_EMAIL,MEM_ADDRESS,MEM_ACCOUNT,MEM_PASSWORD,MEM_BIRTH,MEM_STA FROM CFA102G1.MEMBER";
	
	static {
		try {
			Class.forName(DRIVER);
		}catch (ClassNotFoundException ce) {
			ce.printStackTrace();
		}
	}

	@Override
	public void insert(MemberVO member) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = con.prepareStatement(INSERT_SQL);
			
			pstmt.setString(1,member.getMEM_NAME());
			pstmt.setString(2, member.getMEM_GENDER());
			pstmt.setInt(3, member.getMEM_PHONE());
			pstmt.setString(4, member.getMEM_EMAIL());
			pstmt.setString(5, member.getMEM_ADDRESS());
			pstmt.setString(6, member.getMEM_ACCOUNT());
			pstmt.setString(7, member.getMEM_PASSWORD());
			pstmt.setString(8, member.getMEM_BIRTH());
			pstmt.setString(9, member.getMEM_STA());
			
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
	public void update(MemberVO member) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = con.prepareStatement(UPDATE_SQL);
			
			
			pstmt.setString(1,member.getMEM_NAME());
			pstmt.setString(2, member.getMEM_GENDER());
			pstmt.setInt(3, member.getMEM_PHONE());
			pstmt.setString(4, member.getMEM_EMAIL());
			pstmt.setString(5, member.getMEM_ADDRESS());
			pstmt.setString(6, member.getMEM_ACCOUNT());
			pstmt.setString(7, member.getMEM_PASSWORD());
			pstmt.setString(8, member.getMEM_BIRTH());
			pstmt.setString(9, member.getMEM_STA());
			pstmt.setInt(10, member.getMEM_NO());
			
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
	public void delete(Integer MEM_NO) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = con.prepareStatement(DELETE_SQL);

			pstmt.setInt(1, MEM_NO);			
			
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
	public MemberVO findByMem_no(Integer MEM_NO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MemberVO member = null;
		
		try {
			con = DriverManager.getConnection(URL,USER,PASSWORD);
			pstmt = con.prepareStatement(FIND_BY_MEM_NO_SQL);
			pstmt.setInt(1,MEM_NO );
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				member = new MemberVO();
				member.setMEM_NO(MEM_NO);
				member.setMEM_NAME(rs.getString("MEM_NAME"));
				member.setMEM_GENDER(rs.getString("MEM_GENDER"));
				member.setMEM_PHONE(rs.getInt("MEM_PHONE"));
				member.setMEM_EMAIL(rs.getString("MEM_EMAIL"));
				member.setMEM_ADDRESS(rs.getString("MEM_ADDRESS"));
				member.setMEM_ACCOUNT(rs.getString("MEM_ACCOUNT"));
				member.setMEM_PASSWORD(rs.getString("MEM_PASSWORD"));
				member.setMEM_BIRTH(rs.getString("MEM_BIRTH"));
				member.setMEM_STA(rs.getString("MEM_STA"));
				
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
		
		return member;
	}	
	
		

	@Override
	public List<MemberVO> findByMem_name(String MEM_NAME) {
		List<MemberVO> list = new ArrayList<MemberVO>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MemberVO member = null;
		
		try {
			con = DriverManager.getConnection(URL,USER,PASSWORD);
			pstmt = con.prepareStatement(FIND_BY_MEM_NAME_SQL);
			pstmt.setString(1,MEM_NAME);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				member = new MemberVO();
				member.setMEM_NO(rs.getInt("MEM_NO"));
				member.setMEM_NAME(rs.getString("MEM_NAME"));
				member.setMEM_GENDER(rs.getString("MEM_GENDER"));
				member.setMEM_PHONE(rs.getInt("MEM_PHONE"));
				member.setMEM_EMAIL(rs.getString("MEM_EMAIL"));
				member.setMEM_ADDRESS(rs.getString("MEM_ADDRESS"));
				member.setMEM_ACCOUNT(rs.getString("MEM_ACCOUNT"));
				member.setMEM_PASSWORD(rs.getString("MEM_PASSWORD"));
				member.setMEM_BIRTH(rs.getString("MEM_BIRTH"));
				member.setMEM_STA(rs.getString("MEM_STA"));
				list.add(member);
				
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

	@Override
	public List<MemberVO> findByMem_phone(Integer MEM_PHONE) {
		List<MemberVO> list = new ArrayList<MemberVO>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MemberVO member = null;
		
		try {
			con = DriverManager.getConnection(URL,USER,PASSWORD);
			pstmt = con.prepareStatement(FIND_BY_MEM_PHONE_SQL);
			pstmt.setInt(1,MEM_PHONE);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				member = new MemberVO();
				member.setMEM_NO(rs.getInt("MEM_NO"));
				member.setMEM_NAME(rs.getString("MEM_NAME"));
				member.setMEM_GENDER(rs.getString("MEM_GENDER"));
				member.setMEM_PHONE(rs.getInt("MEM_PHONE"));
				member.setMEM_EMAIL(rs.getString("MEM_EMAIL"));
				member.setMEM_ADDRESS(rs.getString("MEM_ADDRESS"));
				member.setMEM_ACCOUNT(rs.getString("MEM_ACCOUNT"));
				member.setMEM_PASSWORD(rs.getString("MEM_PASSWORD"));
				member.setMEM_BIRTH(rs.getString("MEM_BIRTH"));
				member.setMEM_STA(rs.getString("MEM_STA"));
				list.add(member);
				
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

	@Override
	public List<MemberVO> getAll() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<MemberVO> list = new ArrayList<MemberVO>();
		MemberVO memberVO = null;
		try {
			con = DriverManager.getConnection(URL,USER,PASSWORD);
			pstmt = con.prepareStatement(GET_ALL);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				memberVO = new MemberVO();
				
				memberVO.setMEM_NO(rs.getInt("MEM_NO"));
				memberVO.setMEM_NAME(rs.getString("MEM_NAME"));
				memberVO.setMEM_GENDER(rs.getString("MEM_GENDER"));
				memberVO.setMEM_PHONE(rs.getInt("MEM_PHONE"));
				memberVO.setMEM_EMAIL(rs.getString("MEM_EMAIL"));
				memberVO.setMEM_ADDRESS(rs.getString("MEM_ADDRESS"));
				memberVO.setMEM_ACCOUNT(rs.getString("MEM_ACCOUNT"));
				memberVO.setMEM_PASSWORD(rs.getString("MEM_PASSWORD"));
				memberVO.setMEM_BIRTH(rs.getString("MEM_BIRTH"));
				memberVO.setMEM_STA(rs.getString("MEM_STA"));
				
				list.add(memberVO);
				
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
		
		//新增會員資料
//		MemberJDBCDAO dao = new MemberJDBCDAO();
//		MemberVO member = new MemberVO();
//		member.setMEM_NAME("kano");
//		member.setMEM_GENDER("男");
//		member.setMEM_PHONE(933669205);
//		member.setMEM_EMAIL("hi99051sdf1122@gmail.com");
//		member.setMEM_ADDRESS("桃園市中壢區民權路一段77號");
//		member.setMEM_ACCOUNT("tt99662yy5566");
//		member.setMEM_PASSWORD("rasdfe665");
//		member.setMEM_BIRTH("1999.02.02");
//		member.setMEM_STA("正常");
//		dao.insert(member);
//		
		
		//System.out.println("---------------------------------------------------");
		//用會員編號查詢
//		MemberJDBCDAO dao = new MemberJDBCDAO();
//		MemberVO list1 = dao.findByMem_no(3);
//		    System.out.print(list1.getMEM_NO()+"\t");
//		    System.out.print(list1.getMEM_NAME()+"\t");
//		    System.out.print(list1.getMEM_GENDER()+"\t");
//		    System.out.print(list1.getMEM_PHONE()+"\t");
//		    System.out.print(list1.getMEM_EMAIL()+"\t");
//		    System.out.print(list1.getMEM_ADDRESS()+"\t");
//		    System.out.print(list1.getMEM_ACCOUNT()+"\t");
//		    System.out.print(list1.getMEM_PASSWORD()+"\t");
//		  	System.out.print(list1.getMEM_BIRTH()+"\t");
//		  	System.out.print(list1.getMEM_STA()+"\t");
//		  	System.out.println();
//	
		//System.out.println("---------------------------------------------------");
		//用名字查詢
//		MemberJDBCDAO dao = new MemberJDBCDAO();
//		List<MemberVO> nameList = dao.findByMem_name("Akito");
//		for (MemberVO memberVOName : nameList) {
//			
//			System.out.print(memberVOName.getMEM_NO()+"\t");
//			System.out.print(memberVOName.getMEM_NAME()+"\t");
//			System.out.print(memberVOName.getMEM_GENDER()+"\t");
//			System.out.print(memberVOName.getMEM_PHONE()+"\t");
//			System.out.print(memberVOName.getMEM_EMAIL()+"\t");
//			System.out.print(memberVOName.getMEM_ADDRESS()+"\t");
//			System.out.print(memberVOName.getMEM_ACCOUNT()+"\t");
//			System.out.print(memberVOName.getMEM_PASSWORD()+"\t");
//			System.out.print(memberVOName.getMEM_BIRTH()+"\t");
//			System.out.print(memberVOName.getMEM_STA()+"\t");
//			System.out.println();
//		}
		//System.out.println("---------------------------------------------------");
		//搜尋全部
//		MemberJDBCDAO dao = new MemberJDBCDAO();
//		List<MemberVO> list = dao.getAll();
//		for (MemberVO memberVO : list ) {			
//		    System.out.print(memberVO.getMEM_NO()+"\t");
//	     	System.out.print(memberVO.getMEM_NAME()+"\t");
//		    System.out.print(memberVO.getMEM_GENDER()+"\t");
//		    System.out.print(memberVO.getMEM_PHONE()+"\t");
//		    System.out.print(memberVO.getMEM_EMAIL()+"\t");
//		    System.out.print(memberVO.getMEM_ADDRESS()+"\t");
//		    System.out.print(memberVO.getMEM_ACCOUNT()+"\t");
//		    System.out.print(memberVO.getMEM_PASSWORD()+"\t");
//		    System.out.print(memberVO.getMEM_BIRTH()+"\t");
//		    System.out.print(memberVO.getMEM_STA()+"\t");
//		    System.out.println();
//		}
//		System.out.println("-------------------------------------------");
		
		//用手機號麻搜尋
//		MemberJDBCDAO dao = new MemberJDBCDAO();
//		List<MemberVO> list = dao.findByMem_phone(988648216);
//		for (MemberVO memberphone : list) {
//			System.out.print(memberphone.getMEM_NO()+"\t");
//			System.out.print(memberphone.getMEM_NAME()+"\t");
//			System.out.print(memberphone.getMEM_GENDER()+"\t");
//			System.out.print(memberphone.getMEM_PHONE()+"\t");
//			System.out.print(memberphone.getMEM_EMAIL()+"\t");
//			System.out.print(memberphone.getMEM_ADDRESS()+"\t");
//			System.out.print(memberphone.getMEM_ACCOUNT()+"\t");
//			System.out.print(memberphone.getMEM_PASSWORD()+"\t");
//			System.out.print(memberphone.getMEM_BIRTH()+"\t");
//			System.out.print(memberphone.getMEM_STA()+"\t");
//			System.out.println();
//		}
		//System.out.println("---------------------------------------------------");
		
		//修改
//		MemberVO member = new MemberVO();
//		
//		member.setMEM_NAME("kaido");
//		member.setMEM_GENDER("男");
//		member.setMEM_PHONE(978991553);	
//		member.setMEM_EMAIL("mmmbb223@gmail.com");
//		member.setMEM_ADDRESS("桃園市新屋區中正路一段87號");
//		member.setMEM_ACCOUNT("t05sdf5566");
//		member.setMEM_PASSWORD("rasdfs38165");
//		member.setMEM_BIRTH("1999.04.29");
//		member.setMEM_STA("停權");
//		member.setMEM_NO(4);
//		
//		dao.update(member);
//		
//	}
	//System.out.println("---------------------------------------------------");
//		dao.delete(4);
//		   System.out.println("已刪除");
//		   System.out.println("-------------------------------------------");
//	
//	
	}
}