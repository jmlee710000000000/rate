package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class rateDB {
	public void insert( String ID, String PW) {
	      Connection conn= null;
	      PreparedStatement pstmt = null;
	      ResultSet rs= null;
	      
	      String dbURL = "jdbc:mysql://127.0.0.1:3306/rate?useSSL=false";
	      String dbID = "root";
	      String dbPW = "rootroot";
	      
	      try {
	         Class.forName("com.mysql.cj.jdbc.Driver");
	         conn = DriverManager.getConnection(dbURL, dbID, dbPW);
	         
	         String sql = "insert into rateTBL(ID,PW)" +"values (?,?);" ;
	         pstmt = conn.prepareStatement(sql);
	        
	         pstmt.setString(1, ID);
	         pstmt.setString(2, PW);
	         pstmt.executeUpdate();
	         
	         System.out.println("rateTBL insert() 메서드 실행 완료");
	         
	      } catch (ClassNotFoundException e) {
	         e.printStackTrace();
	      } catch (SQLException e) {
	         e.printStackTrace();
	      } finally {
	         if(pstmt != null) {
	            try {
	               pstmt.close();
	            } catch (SQLException e) {
	               e.printStackTrace();
	            }
	         }
	         
	         if(conn != null) {
	            try {
	               conn.close();
	            } catch (SQLException e) {
	               e.printStackTrace();
	            }
	         }
	      }
	   }
	public int login(String loginID,String loginPW) {
		  Connection conn= null;
	      PreparedStatement pstmt = null;
	      ResultSet rs = null;
	      
	      String dbURL = "jdbc:mysql://127.0.0.1:3306/rate?useSSL=false";
	      String dbID = "root";
	      String dbPW = "rootroot";
	      
	      try {
	         Class.forName("com.mysql.cj.jdbc.Driver");
	         conn = DriverManager.getConnection(dbURL, dbID, dbPW);
	         
	         String sql = "SELECT  ID ,PW from rateTBL where ID = ? and PW =?";
	         pstmt = conn.prepareStatement(sql);
	         pstmt.setString(1,loginID);
	         pstmt.setString(2,loginPW);
	         rs = pstmt.executeQuery();
	         
	         if(rs.next()) {
System.out.println("로긴성공");
return 1000;
	         }else {
	        System.out.println("로긴실패");
	        	 }
	        
	         } catch (ClassNotFoundException e) {
		         e.printStackTrace();
		      } catch (SQLException e) {
		         e.printStackTrace();
		      } finally {
		         if(pstmt != null) {
		            try {
		               pstmt.close();
		            } catch (SQLException e) {
		               e.printStackTrace();
		            }
		         }
		         
		         if(rs != null) {
		            try {
		               rs.close();
		            } catch (SQLException e) {
		               e.printStackTrace();
		            }
		         }
		         
		         if(conn != null) {
		            try {
		               conn.close();
		            } catch (SQLException e) {
		               e.printStackTrace();
		            }
		         }
		      }
		return 0;
	      }

	   public void delete(int mNum) {
	      Connection conn= null;
	      PreparedStatement pstmt = null;
	      
	      String dbURL = "jdbc:mysql://127.0.0.1:3306/rate?useSSL=false";
	      String dbID = "root";
	      String dbPW = "rootroot";
	      
	      try {
	         Class.forName("com.mysql.cj.jdbc.Driver");
	         conn = DriverManager.getConnection(dbURL, dbID, dbPW);
	         
	         String sql = "delete from rateTBL where mNum = ?";
	         pstmt = conn.prepareStatement(sql);
	         pstmt.setInt(1, mNum);
	         pstmt.executeUpdate();
	         
	         System.out.println("MemberDTO delete() 메서드 실행 완료");
	         
	      } catch (ClassNotFoundException e) {
	         e.printStackTrace();
	      } catch (SQLException e) {

	         e.printStackTrace();
	      } finally {
	         if(pstmt != null) {
	            try {
	               pstmt.close();
	            } catch (SQLException e) {
	               e.printStackTrace();
	            }
	         }
	         
	         if(conn != null) {
	            try {
	               conn.close();
	            } catch (SQLException e) {
	               e.printStackTrace();
	            }
	         }
	      }
	   }
	   
	   
	   public void update(int mNum, String mAddress) {
	      Connection conn= null;
	      PreparedStatement pstmt = null;
	      
	      String dbURL = "jdbc:mysql://127.0.0.1:3306/rate?useSSL=false";
	      String dbID = "root";
	      String dbPW = "rootroot";
	      
	      try {
	         Class.forName("com.mysql.cj.jdbc.Driver");
	         conn = DriverManager.getConnection(dbURL, dbID, dbPW);
	         
	         String sql = "update rateTBL set mAddress = ? where mNum = ?";
	         pstmt = conn.prepareStatement(sql);
	         pstmt.setString(1, mAddress);
	         pstmt.setInt(2, mNum);
	         pstmt.executeUpdate();
	         
	         System.out.println("MemberDTO update() 메서드 실행 완료");
	         
	      } catch (ClassNotFoundException e) {
	         e.printStackTrace();
	      } catch (SQLException e) {
	         e.printStackTrace();
	      } finally {
	         if(pstmt != null) {
	            try {
	               pstmt.close();
	            } catch (SQLException e) {
	               e.printStackTrace();
	            }
	         }
	         
	         if(conn != null) {
	            try {
	               conn.close();
	            } catch (SQLException e) {
	               e.printStackTrace();
	            }
	         }
	      }
	   }
	   
	   
	   public boolean selectOne(String onlyEng) {
	      Connection conn= null;
	      PreparedStatement pstmt = null;
	      ResultSet rs = null;
	      
	      String dbURL = "jdbc:mysql://127.0.0.1:3306/rate?useSSL=false";
	      String dbID = "root";
	      String dbPW = "rootroot";
	      
	      try {
	         Class.forName("com.mysql.cj.jdbc.Driver");
	         conn = DriverManager.getConnection(dbURL, dbID, dbPW);
	         
	         String sql = "SELECT  ID from rateTBL WHERE ID = ? ";
	         pstmt = conn.prepareStatement(sql);
	         pstmt.setString(1,onlyEng);
	         rs = pstmt.executeQuery();
	         
	         if(rs.next()) {
	        	 	return true;
	            
	         }else {
	        	 return false;
	         }
	         
	         
	      } catch (ClassNotFoundException e) {
	         e.printStackTrace();
	      } catch (SQLException e) {
	         e.printStackTrace();
	      } finally {
	         if(pstmt != null) {
	            try {
	               pstmt.close();
	            } catch (SQLException e) {
	               e.printStackTrace();
	            }
	         }
	         
	         if(rs != null) {
	            try {
	               rs.close();
	            } catch (SQLException e) {
	               e.printStackTrace();
	            }
	         }
	         
	         if(conn != null) {
	            try {
	               conn.close();
	            } catch (SQLException e) {
	               e.printStackTrace();
	            }
	         }
	      }
	   return false;
	   }
}
