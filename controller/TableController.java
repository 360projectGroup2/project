package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;

import model.Patient;
import model.Doctor;


public class TableController implements DBQuery{
	/**
	 * @return a table
	 * @throws SQLException
	 */
	
	public static Patient activePatient = null;
	
	public Connection connectDatabase() {
		Connection connection = null;
		try {
		//	connection = MySQLConnector.connectDatabase("primafacie.cidse.dhcp.asu.edu", "IPIMS", "dbuser", "temp4now");
			connection = MySQLConnector.connectDatabase("localhost", "ipims", "root", "kks@asu");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}
	
	public ArrayList<Doctor> getDoctor(int patientId, String where) throws SQLException{
		Connection connection = this.connectDatabase();
		if(connection == null){
			throw new SQLException("Cannot connect database");
		}
		if(patientId > 0){
			if(where == null){
				where = "patientId=" + patientId;
			}else{
				where = "patientId=" + patientId + " and "+ where;
			}
		}else{
			if(where == null){
				where = "1=1";
			}
		}
		String sql = "select * from doctor where "+where;
		PreparedStatement statement = connection.prepareStatement(sql);
		
		ResultSet resultSet = statement.executeQuery();
		ArrayList<Doctor> doctors = new ArrayList<Doctor>();
		while(resultSet.next()){
			Doctor doctor = new Doctor();
			doctor.setDoctor(resultSet.getString("first_name"), resultSet.getString("last_name"), resultSet.getString("speciality"), resultSet.getInt("doctorId"));
			
			sql = "select * from business_hours where doctorId="+resultSet.getInt("doctorId");
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			ResultSet hours = stmt.executeQuery();
			String weekday ="";
			while(hours.next()){
				String [] weekDays = {"Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"};
				for(int i=0; i < weekDays.length; i++){
					if(hours.getString(weekDays[i]) == "Available"){
						weekday = weekday+weekDays[i]+";";
					}
					
				}
				doctor.setHours(weekday, hours.getString("start"), hours.getString("end"));
			}
			
			doctors.add(doctor);
		} 
		return doctors;
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
		sql = "select GKey from patient where FirstName=" + p.firstName + " and LastName=" + p.lastName;
		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet resultset = statement.executeQuery();
		while(resultset.next()) {
			ArrayList<String> record = new ArrayList<>();
			for (int i = 1; i <= resultset.getMetaData().getColumnCount(); i++)
				record.add(resultset.getString(i));		
			result.add(record);
		}
		String GKey = result.get(0).get(0);
		sql = "select HCID from HasCondition where GKey=" +GKey;
		statement = connection.prepareStatement(sql);
		resultset = statement.executeQuery();
		while(resultset.next()) {
			ArrayList<String> record = new ArrayList<>();
			for (int i = 1; i <= resultset.getMetaData().getColumnCount(); i++)
				record.add(resultset.getString(i));		
			result.add(record);
		}
		String HCID = result.get(0).get(0);
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

}
