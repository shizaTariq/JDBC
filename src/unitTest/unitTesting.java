package unitTest;

import static org.junit.Assert.*;

import java.sql.*;

import jdbc.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class unitTesting {

	Driver driver = null;
	Connection conn = null;
	Statement st = null;
	ResultSet rs = null;


	@Test
	public void ResultSettest() {
		try {
			driver = new JdbcDriver();
			DriverManager.registerDriver(driver);
			conn = DriverManager.getConnection("jdbc:odbc:xmp","root","");
			st = conn.createStatement();
			rs = st.executeQuery("SELECT * FROM PERSONS");
			while(rs.next()){

				int id  = rs.getInt("PersonID");
			}

		} catch (Exception e) {
			fail("Statement Failed");
		}
	}

	@After
	public void tearDown(){
		try {
			rs.close();
		
			st.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


}
