package BBMS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class BloodCells {


	public static void addBloodCells(Connection con) throws Exception {
		Scanner input = new Scanner(System.in); 
		System.out.println("Enter a blood cells id:");
		String blood_cells_id = input.next();
		System.out.println("Enter a blood cells donor id:");
		String blood_cells_donor_id = input.next();
		System.out.println("Enter a blood cells patient id:");
		String blood_cells_patient_id = input.next();
		System.out.println("Enter a blood cells type:");
		String blood_cells_type = input.next();
		System.out.println("Enter a blood cells description:");
		String blood_cells_description = input.next();

		String addSQL="insert into bloodcells(blood_cells_id,blood_cells_donor_id,blood_cells_patient_id,blood_cells_type,"
				+ "blood_cells_description) VALUES(?,?,?,?,?)";

		PreparedStatement stat = con.prepareStatement(addSQL);

		stat.setString(1,blood_cells_id);
		stat.setString(2,blood_cells_donor_id);
		stat.setString(3,blood_cells_patient_id);
		stat.setString(4,blood_cells_type);
		stat.setString(5,blood_cells_description);

		stat.executeUpdate();

		try {
			System.out.println("Bloodcells added successfully.");
		} catch (Exception e) {
			System.out.println("Fail to add a bloodcells.");
			e.printStackTrace();
		} finally {
			con.close(); 
		}

		stat.close();

	}



	public static void editBloodCells(Connection con) throws Exception {
		Scanner input = new Scanner(System.in); 
		System.out.println("Enter the id of the blood cells you want to edit:");
		String blood_cells_id = input.next();
		System.out.println("Enter a blood cells donor id:");
		String blood_cells_donor_id = input.next();
		System.out.println("Enter a blood cells patient id:");
		String blood_cells_patient_id = input.next();
		System.out.println("Enter a blood cells type:");
		String blood_cells_type = input.next();
		System.out.println("Enter a blood cells description:");
		String blood_cells_description = input.next();

		try {
			String editSQL="update bloodcells set blood_cells_donor_id=?,blood_cells_patient_id=?,blood_cells_type=?,"
					+ "blood_cells_description=? where blood_cells_id=?";
			PreparedStatement stat = con.prepareStatement(editSQL);

			stat.setString(1,blood_cells_donor_id);
			stat.setString(2,blood_cells_patient_id);
			stat.setString(3,blood_cells_type);
			stat.setString(4,blood_cells_description);
			stat.setString(5,blood_cells_id);

			stat.executeUpdate();
			System.out.println("Bloodcells edited successfully.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Fail to edit the bloodcells.");
			e.printStackTrace();
		}finally {
			con.close(); 
		}
	}




	public static void deleteBloodCells(Connection con) throws Exception {
		Scanner input = new Scanner(System.in); 
		System.out.println("Enter the donor id:");
		String id = input.next();

		String deleteSQL = "delete from bloodcells where blood_cells_id="+id;

		Statement stat = con.createStatement();
		stat.executeUpdate(deleteSQL);

		try {
			System.out.println("Bloodcells deleted successfully.");
		} catch (Exception e) {
			System.out.println("Fail to delete a bloodcells.");
			e.printStackTrace();
		} finally {
			con.close(); 
		}
		stat.close();
	}




	public static void updateBloodCells() {

		System.out.println("Blood cells updated succssfully.");
	}


	public static void saveBloodCells() {

		System.out.println("Blood cells saved succssfully.");
	}



	public static void searchBloodCells(Connection con) throws Exception {
		Scanner input = new Scanner(System.in); 

		System.out.println("Choose the way to search");
		System.out.println("1.blood cells id");
		System.out.println("2.blood cells donor id");
		System.out.println("3.blood cells patient id");
		System.out.println("4.blood cells type");
		System.out.println("5.blood cells description");
		System.out.println("Enter your choice (1-5): ");
		int choice = input.nextInt();
		input.nextLine();

		String searchSQL="";
		String i;

		switch (choice) {
		case 1:
			System.out.println("Enter the blood_cells_id:");
			i = input.next();
			searchSQL = " select blood_cells_id, blood_cells_donor_id, blood_cells_patient_id, blood_cells_type, blood_cells_description"
					+ " from bloodcells where blood_cells_id = '"
					+ i + "'";
			break;

		case 2:
			System.out.println("Enter the blood_cells_donor_id:");
			i = input.next();
			searchSQL = " select blood_cells_id, blood_cells_donor_id, blood_cells_patient_id, blood_cells_type, blood_cells_description"
					+ " from bloodcells where blood_cells_donor_id = '"
					+ i + "'";
			break;

		case 3:
			System.out.println("Enter the blood_cells_patient_id:");
			i = input.next();
			searchSQL = " select blood_cells_id, blood_cells_donor_id, blood_cells_patient_id, blood_cells_type, blood_cells_description"
					+ " from bloodcells where blood_cells_patient_id = '"
					+ i + "'";
			break;

		case 4:
			System.out.println("Enter the blood_cells_type:");
			i = input.next();
			searchSQL = " select blood_cells_id, blood_cells_donor_id, blood_cells_patient_id, blood_cells_type, blood_cells_description"
					+ " from bloodcells where blood_cells_type = '"
					+ i + "'";
			break;

		case 5:
			System.out.println("Enter the blood_cells_description:");
			i = input.next();
			searchSQL = " select blood_cells_id, blood_cells_donor_id, blood_cells_patient_id, blood_cells_type, blood_cells_description"
					+ " from bloodcells where blood_cells_description = '"
					+ i + "'";
			break;


		default:
			System.out.println("Invalid choice. Please try again.");
		}

		try {
			PreparedStatement stat = con.prepareStatement(searchSQL);
			ResultSet rs = stat.executeQuery();

			while (rs.next()) {
				System.out.println("blood_cells_id: "+ rs.getString("blood_cells_id"));
				System.out.println("blood_cells_donor_id: "+ rs.getString("blood_cells_donor_id"));
				System.out.println("blood_cells_patient_id: "+ rs.getString("blood_cells_patient_id"));
				System.out.println("blood_cells_type: "+ rs.getString("blood_cells_type"));
				System.out.println("blood_cells_description: "+ rs.getString("blood_cells_description"));
				System.out.println("");
			}

		}catch (Exception e) {
			System.out.println("Fail to search the bloodcells.");
			e.printStackTrace();
		} finally {
			con.close();
		}

	}


}
