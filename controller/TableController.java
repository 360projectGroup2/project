package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;

import model.Patient;


public class TableController implements DBQuery{
	/**
	 * @return a table
	 * @throws SQLException
	 */
	
	public static Patient activePatient = null;
	
	public Connection connectDatabase() {
		Connection connection = null;
		try {
			connection = MySQLConnector.connectDatabase("primafacie.cidse.dhcp.asu.edu", "IPIMS", "dbuser", "temp4now");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}
	public ArrayList<ArrayList<String>> get() throws SQLException {
		
		ArrayList<ArrayList<String>> result = new ArrayList<>();
		Connection connection = this.connectDatabase();
		if(connection == null) {
			// You can use other approaches for the connection issue.
			// As the connection error generally comes from network errors or 
			// user permissions, it should be taken care of individually
			throw new SQLException("cannot connect database");
		}
		String sql;
		sql = "select * from Syndromes";
		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet resultset = statement.executeQuery();
		while(resultset.next()) {
			ArrayList<String> record = new ArrayList<>();
			for (int i = 1; i <= resultset.getMetaData().getColumnCount(); i++)
				record.add(resultset.getString(i));		
			result.add(record);
		}
		resultset.close();
		statement.close();
		
		// NEVER FORGET TO RELEASE THE CONNECTION!
		connection.close();
		return result;
	}
	
public ArrayList<ArrayList<String>> searchUpdateHealthConditions(Patient p) throws SQLException {
		
		ArrayList<ArrayList<String>> result = new ArrayList<>();
		Connection connection = this.connectDatabase();
		if(connection == null) {
			// You can use other approaches for the connection issue.
			// As the connection error generally comes from network errors or 
			// user permissions, it should be taken care of individually
			throw new SQLException("cannot connect database");
		}
		String sql;
		sql = "select Gkey from Patient where FirstName='" + p.firstName + "' and LastName='" + p.lastName+"'";
		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet resultset = statement.executeQuery();
		while(resultset.next()) {
			ArrayList<String> record = new ArrayList<>();
			for (int i = 1; i <= resultset.getMetaData().getColumnCount(); i++)
				record.add(resultset.getString(i));		
			result.add(record);
		}
		String GKey = result.get(0).get(0);
		
		ArrayList<ArrayList<String>> result2 = new ArrayList<>();
		
		sql = "select HCID from HasCondition where GKey=" +GKey;
		statement = connection.prepareStatement(sql);
		resultset = statement.executeQuery();
		while(resultset.next()) {
			ArrayList<String> record = new ArrayList<>();
			for (int i = 1; i <= resultset.getMetaData().getColumnCount(); i++)
				record.add(resultset.getString(i));		
			result2.add(record);
		}
		String HCID = result2.get(0).get(0);
		
		result = new ArrayList<>();
		sql = "select HealthCondition, Allergies from HealthConditions where HCID=" +HCID;
		statement = connection.prepareStatement(sql);
		resultset = statement.executeQuery();
		while(resultset.next()) {
			ArrayList<String> record = new ArrayList<>();
			for (int i = 1; i <= resultset.getMetaData().getColumnCount(); i++)
				record.add(resultset.getString(i));		
			result.add(record);
		}
		p.healthCondition = result.get(0).get(0);
		p.allergies = result.get(0).get(1);
		activePatient = p;
		resultset.close();
		statement.close();
		
		// NEVER FORGET TO RELEASE THE CONNECTION!
		connection.close();
		return result;
	}



public ArrayList<ArrayList<String>> registerPatient(Patient p) throws SQLException {
	
	Random rand = new Random();
	
	ArrayList<ArrayList<String>> result = new ArrayList<>();
	Connection connection = this.connectDatabase();
	if(connection == null) {
		// You can use other approaches for the connection issue.
		// As the connection error generally comes from network errors or 
		// user permissions, it should be taken care of individually
		throw new SQLException("cannot connect database");
	}
	
	String sql;
	int Gkey;
	ResultSet resultset;
	PreparedStatement statement;
	
	do {
		Gkey = rand.nextInt(10000);
		sql = "select * from GlobalKey where Gkey = " + Gkey;
		statement = connection.prepareStatement(sql);
		resultset = statement.executeQuery();
		while(resultset.next()) {
			ArrayList<String> record = new ArrayList<>();
			for (int i = 1; i <= resultset.getMetaData().getColumnCount(); i++)
				record.add(resultset.getString(i));		
			result.add(record);
		}
	} while(result.size() != 0);
	
	sql = "INSERT INTO `GlobalKey`(`Gkey`) VALUES (" + Gkey + ")";
	statement = connection.prepareStatement(sql);
	statement.executeUpdate();
	
	sql = "INSERT INTO `Patient`(`DateOfBirth`, `FirstName`, `Gkey`, `LastName`, `Sex`, `SSN`, `Username`) VALUES ('"+p.birthdate+"','"+p.firstName+"',"+Gkey+",'"+p.lastName+"','"+p.sex+"','"+p.ssn+"','"+"temp"+Gkey+"')";
	statement = connection.prepareStatement(sql);
	statement.executeUpdate();
	
	resultset.close();
	statement.close();
	
	// NEVER FORGET TO RELEASE THE CONNECTION!
	connection.close();
	return result;
}

public String sendAlert(Patient p) throws SQLException {
	
	ArrayList<ArrayList<String>> result = new ArrayList<>();
	Connection connection = this.connectDatabase();
	if(connection == null) {
		// You can use other approaches for the connection issue.
		// As the connection error generally comes from network errors or 
		// user permissions, it should be taken care of individually
		throw new SQLException("cannot connect database");
	}
	
	String sql;
	String Gkey;
	ResultSet resultset;
	PreparedStatement statement;
	
	sql = "select Gkey from Patient where FirstName = '" + p.firstName + "' and LastName = '" + p.lastName + "'";
	statement = connection.prepareStatement(sql);
	resultset = statement.executeQuery();
	while(resultset.next()) {
		ArrayList<String> record = new ArrayList<>();
		for (int i = 1; i <= resultset.getMetaData().getColumnCount(); i++)
			record.add(resultset.getString(i));		
		result.add(record);
	}
	
	Gkey = result.get(1).get(0);
	
	sql = "select HCID, Severity from HealthConditions where HealthCondition = '" + p.healthCondition + "'";
	statement = connection.prepareStatement(sql);
	resultset = statement.executeQuery();
	while(resultset.next()) {
		ArrayList<String> record = new ArrayList<>();
		for (int i = 1; i <= resultset.getMetaData().getColumnCount(); i++)
			record.add(resultset.getString(i));		
		result.add(record);
	}
	if (result.size() == 0) {
		resultset.close();
		statement.close();
		
		// NEVER FORGET TO RELEASE THE CONNECTION!
		connection.close();
		return "Error: HealthCondition is not well-defined.";
	}
	String HCID = result.get(1).get(0);
	String severityStr = result.get(1).get(1);
	int severity = Integer.parseInt(result.get(1).get(1));
	
	sql = "INSERT INTO `HasCondition`(`HCID`, `Gkey`) VALUES ("+HCID+","+Gkey+")";
	statement = connection.prepareStatement(sql);
	statement.executeUpdate();
	
	activePatient = p;
	activePatient.severity = severity;
	
	resultset.close();
	statement.close();
	
	// NEVER FORGET TO RELEASE THE CONNECTION!
	connection.close();
	return "Success";
}

}
