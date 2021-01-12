package report;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MyDB {
	public static Connection getCon() {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/macaron?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false";
			String username = "root";
			String pwd = "yuhan1234";
			con = DriverManager.getConnection(url, username, pwd);
		}
		catch(ClassNotFoundException e) {
			System.out.println("JDBC Driver 연결되지않았습니다.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	
	public static void main(String[] args) {
		Connection con = getCon();
		System.out.println("연결.");
		String sql = "SELECT user_num, user_id, user_jumsu" + 
				" FROM macaron.macaron_user;";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				System.out.print(rs.getInt(1)+" ");
				System.out.print(rs.getString(2)+" ");
				System.out.print(rs.getInt(3)+" ");
				System.out.println();
			}
			if(con!=null)
				con.close();
			} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
