package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;

import model.Doctor;
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
			connection = MySQLConnector.connectDatabase("primafacie.cidse.dhcp.asu.edu", "IPIMS", "dbuser", "temp4now");
			
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
		String sql = "select * from Doctor where "+where;
		PreparedStatement statement = connection.prepareStatement(sql);
		
		ResultSet resultSet = statement.executeQuery();
		ArrayList<Doctor> doctors = new ArrayList<Doctor>();
		while(resultSet.next()){
			String speciality = "Physician";
			Doctor doctor = new Doctor();
			
			sql = "select Specialty from SpecializesIn where Gkey="+resultSet.getInt("Gkey")+" limit 1";
			PreparedStatement specialityStmt = connection.prepareStatement(sql);
			ResultSet specialtyRS = specialityStmt.executeQuery();
			if(specialtyRS.next()){
				speciality = specialtyRS.getString("Specialty");
			}
			
			doctor.setDoctor(resultSet.getString("FirstName"), resultSet.getString("LastName"), speciality, resultSet.getInt("Gkey"));
			
			
			
			sql = "select * from BusinessHours where Gkey="+resultSet.getInt("Gkey");
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			ResultSet hours = stmt.executeQuery();
			//String weekday ="";
			while(hours.next()){
				/*String [] weekDays = {"Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"};
				for(int i=0; i < weekDays.length; i++){
					if(hours.getString(weekDays[i]).equals("Available")){
						weekday = weekday+weekDays[i]+";";
					}
					
				}*/
				doctor.setHours(hours.getString("Weekday"), hours.getString("Start"), hours.getString("End"));
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
		p.patientId = GKey;
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

public void getLabRecords() throws SQLException {
	
	ArrayList<ArrayList<String>> result = new ArrayList<>();
	Connection connection = this.connectDatabase();
	if(connection == null) {
		// You can use other approaches for the connection issue.
		// As the connection error generally comes from network errors or 
		// user permissions, it should be taken care of individually
		throw new SQLException("cannot connect database");
	}
	String sql;
	sql = "select Result from LabTests where Gkey=" + activePatient.patientId;
	PreparedStatement statement = connection.prepareStatement(sql);
	ResultSet resultset = statement.executeQuery();
	while(resultset.next()) {
		ArrayList<String> record = new ArrayList<>();
		for (int i = 1; i <= resultset.getMetaData().getColumnCount(); i++)
			record.add(resultset.getString(i));		
		result.add(record);
	}
	String LabResults = result.get(0).get(0);
	activePatient.labTestResults = LabResults;
	
	resultset.close();
	statement.close();
	
	// NEVER FORGET TO RELEASE THE CONNECTION!
	connection.close();
	return;
}

public void getPrescriptionHistory() throws SQLException {
	
	ArrayList<ArrayList<String>> result = new ArrayList<>();
	Connection connection = this.connectDatabase();
	if(connection == null) {
		// You can use other approaches for the connection issue.
		// As the connection error generally comes from network errors or 
		// user permissions, it should be taken care of individually
		throw new SQLException("cannot connect database");
	}
	String sql;
	sql = "select Medication from Script where Gkey=" + activePatient.patientId;
	PreparedStatement statement = connection.prepareStatement(sql);
	ResultSet resultset = statement.executeQuery();
	while(resultset.next()) {
		ArrayList<String> record = new ArrayList<>();
		for (int i = 1; i <= resultset.getMetaData().getColumnCount(); i++)
			record.add(resultset.getString(i));		
		result.add(record);
	}
	String presHist = "";
	for(int j = 0; j < result.size(); j++)
	{
		presHist += result.get(j).get(0) + "\n";
	}
	activePatient.ePrescription = presHist;
	
	resultset.close();
	statement.close();
	
	// NEVER FORGET TO RELEASE THE CONNECTION!
	connection.close();
	return;
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
	
	sql = "INSERT INTO `Patient`(`row_create`, `DateOfBirth`, `FirstName`, `Gkey`, `LastName`, `Sex`, `Ethnicity`, `SSN`, `Username`) VALUES (now(),'"+p.birthdate+"','"+p.firstName+"',"+Gkey+",'"+p.lastName+"','"+p.sex+"','"+p.ethnicity+"','"+p.ssn+"','"+"temp"+Gkey+"')";
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
	
	Gkey = result.get(0).get(0);
	
	sql = "select HCID, Severity from HealthConditions where HealthCondition = '" + p.healthCondition + "'";
	statement = connection.prepareStatement(sql);
	resultset = statement.executeQuery();
	result = new ArrayList<>();
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
	String HCID = result.get(0).get(0);
	String severityStr = result.get(0).get(1);
	int severity = Integer.parseInt(result.get(0).get(1));
	
	sql = "DELETE FROM `HasCondition` WHERE Gkey=" + Gkey;
	statement = connection.prepareStatement(sql);
	statement.executeUpdate();
	
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

public void ePrescribe(Patient p) throws SQLException {
	
	Connection connection = this.connectDatabase();
	if(connection == null) {
		// You can use other approaches for the connection issue.
		// As the connection error generally comes from network errors or 
		// user permissions, it should be taken care of individually
		throw new SQLException("cannot connect database");
	}
	
	String sql;
	String Gkey;
	//ResultSet resultset;
	PreparedStatement statement;
	
	Gkey = p.patientId;
		
	sql = "INSERT INTO `Script`(`Gkey`, `Medication`) VALUES ("+Gkey+",'"+p.ePrescription+"')";
	statement = connection.prepareStatement(sql);
	statement.executeUpdate();
	
	
	//resultset.close();
	statement.close();
	
	// NEVER FORGET TO RELEASE THE CONNECTION!
	connection.close();
	return;
}


public void set(String tableName, HashMap attributes, String where, String operation) throws SQLException {
	
	ArrayList result = new ArrayList();
	
	Connection connection = this.connectDatabase();
	if(connection == null) {
		// You can use other approaches for the connection issue.
		// As the connection error generally comes from network errors or 
		// user permissions, it should be taken care of individually
		throw new SQLException("cannot connect database");
	}
	
	if(tableName == null){
		throw new SQLException("Table name can't be empty");
	}
	String sql = "";
	
	Iterator it = attributes.entrySet().iterator();
	
	if(operation.equals("insert")){
		String columns = "";
		String values = "";
		
	    while (it.hasNext()) {
	        Map.Entry pair = (Map.Entry)it.next();
	        columns = columns + pair.getKey() + ",";
	        values = values + "'" + pair.getValue() + "',";
	        it.remove(); // avoids a ConcurrentModificationException
	    }
	    columns = columns.substring(0, columns.length()-1);
	    values = values.substring(0, values.length()-1);
	    sql = "insert into " + tableName + "("+columns+")" + " values (" + values +")";
	}else{
		String updateStr = "";
		while (it.hasNext()) {
	        Map.Entry pair = (Map.Entry)it.next();
	        updateStr = updateStr + pair.getKey() + "='"+pair.getValue()+"',";
	        it.remove(); // avoids a ConcurrentModificationException
	    }
		updateStr = updateStr.substring(0, updateStr.length()-1);
		sql = "update "+tableName+" set " + updateStr + " where "+where;
	}
	
	if(where == null){
		where = "1=1";
	}
System.out.println("sql:"+sql);
	PreparedStatement statement = connection.prepareStatement(sql);
	statement.executeUpdate();
	statement.close();
	
	// NEVER FORGET TO RELEASE THE CONNECTION!
	connection.close();

}

public ArrayList get(String tableName, String[] attributes, String where) throws SQLException {
	
	ArrayList result = new ArrayList();
	
	Connection connection = this.connectDatabase();
	if(connection == null) {
		// You can use other approaches for the connection issue.
		// As the connection error generally comes from network errors or 
		// user permissions, it should be taken care of individually
		throw new SQLException("cannot connect database");
	}
	
	if(tableName == null){
		throw new SQLException("Table name can't be empty");
	}
	
	String selected_cols = "";
	if(attributes != null && attributes.length != 0){
		for(int i=0; i < attributes.length; i++){
			selected_cols = selected_cols + attributes[i]+",";
		}
		selected_cols = selected_cols.substring(0, selected_cols.length()-1);
	}else{
		selected_cols = "*";
	}
	
	if(where == null){
		where = "1=1";
	}
	
	String sql = "select " + selected_cols + " from " + tableName + " where "+ where;

	PreparedStatement statement = connection.prepareStatement(sql);
	ResultSet resultset = statement.executeQuery();
	while(resultset.next()) {
		for (int i = 1; i <= resultset.getMetaData().getColumnCount(); i++){
			String columnName = resultset.getMetaData().getColumnName(i);
			result.add(resultset.getString(columnName));
		}
	}
	resultset.close();
	statement.close();
	
	// NEVER FORGET TO RELEASE THE CONNECTION!
	connection.close();
	return result;
}

}