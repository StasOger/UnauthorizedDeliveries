package A1.Task3;

import A1.Task3.model.Posting;
import A1.Task3.model.User;
import A1.Task3.service.ApplicationService;
import A1.Task3.service.LoginsCsvReader;
import A1.Task3.service.PostingsCsvReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class Task3Application {

//	private static final String url = "jdbc:mysql://localhost:3306/userdb?useTimezone=true&serverTimezone=UTC";
//	private static final String user = "root";
//	private static final String password = "root";
//
//	private static Connection con;
//	private static Statement stmt;
//	private static ResultSet rs;

	public static void main(String[] args) throws ParseException {
		SpringApplication.run(Task3Application.class, args);

//		String pstngDateString = "21.01.2000";
//		Date pstngDate=new SimpleDateFormat("dd.MM.yyyy").parse(pstngDateString);
//
//		System.out.println(pstngDate);

//		String query = "select * from logins";
//
//		try {
//			con = DriverManager.getConnection(url, user, password);
//			stmt = con.createStatement();
//			rs = stmt.executeQuery(query);
//			while (rs.next()) {
//				int id = rs.getInt(1);
//				String appAccountName = rs.getString(2);
//				String application = rs.getString(3);
//				System.out.println("user : " + id + " " + appAccountName + " " + application);
//			}
//
//		} catch (SQLException sqlEx) {
//			sqlEx.printStackTrace();
//		} finally {
//
//			try { con.close(); } catch(SQLException se) { }
//			try { stmt.close(); } catch(SQLException se) { }
//			try { rs.close(); } catch(SQLException se) {  }
//		}
	}
}
