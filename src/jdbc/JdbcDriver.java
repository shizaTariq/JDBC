package jdbc;


import java.sql.*;
import java.util.Properties;
import java.util.logging.Logger;

import sun.jdbc.odbc.JdbcOdbcDriver;




public class JdbcDriver implements  Driver{


	static {

		try {
			JdbcOdbcDriver OdbcDriver = new JdbcOdbcDriver();
			DriverManager.registerDriver(OdbcDriver);
			System.out.println("Driver Registered");
		} catch (SQLException e) {
			System.err.println("Driver Problem");
			e.printStackTrace();
		}
	}

	@Override
	public Connection connect(String url, Properties info) throws SQLException {

		JdbcConnection conn = new JdbcConnection(DriverManager.getConnection(url,info));
		System.out.println("Connected!");
		return conn;

	}

	@Override
	public boolean acceptsURL(String url) throws SQLException {
		// TODO Auto-generated method stub
		JdbcOdbcDriver tmp = new JdbcOdbcDriver();
		return tmp.acceptsURL(url);
	}

	@Override
	public DriverPropertyInfo[] getPropertyInfo(String url, Properties info)
			throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getMajorVersion() {
		// TODO Auto-generated method stub
		return 3;
	}

	@Override
	public int getMinorVersion() {
		// TODO Auto-generated method stub
		return 2;
	}

	@Override
	public boolean jdbcCompliant() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Logger getParentLogger() throws SQLFeatureNotSupportedException {
		// TODO Auto-generated method stub
		return null;
	}

}
