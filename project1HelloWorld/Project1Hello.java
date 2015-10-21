package project1HelloWorld;

import controller.TableController;

import java.sql.SQLException;
import java.util.ArrayList;
import model.Patient;

public class Project1Hello {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			System.out.println("Hello world");
			TableController table = new TableController();
			ArrayList<ArrayList<String>> result = null;
			Patient sample = new Patient();
			sample.firstName = "Hedwig";
			sample.lastName = "Owl";
			sample.birthdate = "04/18/1992";
			sample.sex = "M";
			sample.ssn = "223123333";
			try {
				result = table.registerPatient(sample);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("HELlo");
			/*
			for (String field : result.get(0)) {
				System.out.println(field);
			}
			*/
	}

}
