package unitTest;


import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.sql.*;

import jdbc.*;

public class jdbcTest {

	Connection connection = null;
	Statement statement = null;
	@Test
	public void test() {

		
		try{
			DriverManager.registerDriver( new JdbcDriver());
			connection = DriverManager.getConnection("jdbc:odbc:mysql","root","");
			statement = connection.createStatement();

			String sql = "SELECT * FROM Persons";
			ResultSet rs = statement.executeQuery(sql);
	
			while(rs.next()){
	
				int id  = rs.getInt("PersonID");
				String first = rs.getString("FirstName");
				String last = rs.getString("LastName");
	
			}
			rs.close();
			statement.close();
			connection.close();
		}catch(Exception e){

			fail("Test Failed!");
		}

	}

}
