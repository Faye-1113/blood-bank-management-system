package BBMS;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class BloodGroup{

	public static void addBloodGroup(Connection con) throws Exception{

		Scanner input = new Scanner(System.in); 
		System.out.println("Enter a blood group id:");
		String blood_group_id = input.next();
		System.out.println("Enter a blood group donor id:");
		String blood_group_donor_id = input.next();
		System.out.println("Enter a blood group patient id:");
		String blood_group_patient_id = input.next();
		System.out.println("Enter a blood group type:");
		String blood_group_type = input.next();
		System.out.println("Enter a blood group description:");
		String blood_group_description = input.next();

		String addSQL="insert into bloodgroup(blood_group_id,blood_group_donor_id,blood_group_patient_id,blood_group_type,"
				+ "blood_group_description) VALUES(?,?,?,?,?)";

		PreparedStatement stat = con.prepareStatement(addSQL);

		stat.setString(1,blood_group_id);
		stat.setString(2,blood_group_donor_id);
		stat.setString(3,blood_group_patient_id);
		stat.setString(4,blood_group_type);
		stat.setString(5,blood_group_description);

		stat.executeUpdate();

		try {
			System.out.println("Blood group added successfully.");
		} catch (Exception e) {
			System.out.println("Fail to add a blood group.");
			e.printStackTrace();
		} finally {
			con.close(); 
		}

		stat.close();
	}



	public static void editBloodGroup(Connection con) throws Exception{
		Scanner input = new Scanner(System.in); 
		System.out.println("Enter the id of the blood group you want to edit:");
		String blood_group_id = input.next();
		System.out.println("Enter a blood group donor id:");
		String blood_group_donor_id = input.next();
		System.out.println("Enter a blood group patient id:");
		String blood_group_patient_id = input.next();
		System.out.println("Enter a blood group type:");
		String blood_group_type = input.next();
		System.out.println("Enter a blood group description:");
		String blood_group_description = input.next();

		try {
			String editSQL="update bloodgroup set blood_group_donor_id=?,blood_group_patient_id=?,blood_group_type=?,"
					+ "blood_group_description=? where blood_group_id=?";
			PreparedStatement stat = con.prepareStatement(editSQL);

			stat.setString(1,blood_group_donor_id);
			stat.setString(2,blood_group_patient_id);
			stat.setString(3,blood_group_type);
			stat.setString(4,blood_group_description);
			stat.setString(5,blood_group_id);

			stat.executeUpdate();
			System.out.println("Bloodgroup edited successfully.");
		} catch (SQLException e) {
			System.out.println("Fail to edit the bloodgroup.");
			e.printStackTrace();
		}finally {
			con.close(); 
		}

	}



	public static void deleteBloodGroup(Connection con) throws Exception{

		Scanner input = new Scanner(System.in); 
		System.out.println("Enter the blood group id:");
		String id = input.next();

		String deleteSQL = "delete from bloodgroup where blood_group_id="+id;

		Statement stat = con.createStatement();
		stat.executeUpdate(deleteSQL);

		try {
			System.out.println("Bloodgroup deleted successfully.");
		} catch (Exception e) {
			System.out.println("Fail to delete a bloodgroup.");
			e.printStackTrace();
		} finally {
			con.close(); 
		}

		stat.close();
	}



	public static void updateBloodGroup(){
		System.out.println("Blood group updated succssfully.");
	}



	public static void saveBloodGroup(){
		System.out.println("Blood group saved succssfully.");
	}



	public static void searchBloodGroup(Connection con)throws Exception{

		Scanner input = new Scanner(System.in); 

		System.out.println("Choose the way to search");
		System.out.println("1.blood group id");
		System.out.println("2.blood group donor id");
		System.out.println("3.blood group patient id");
		System.out.println("4.blood group type");
		System.out.println("5.blood group description");
		System.out.println("Enter your choice (1-5): ");
		int choice = input.nextInt();
		input.nextLine();

		String searchSQL="";
		String i;

		switch (choice) {
		case 1:
			System.out.println("Enter the blood_group_id:");
			i = input.next();
			searchSQL = " select blood_group_id, blood_group_donor_id, blood_group_patient_id, blood_group_type, blood_group_description"
					+ " from bloodgroup where blood_group_id = '"
					+ i + "'";
			break;

		case 2:
			System.out.println("Enter the blood_group_donor_id:");
			i = input.next();
			searchSQL = " select blood_group_id, blood_group_donor_id, blood_group_patient_id, blood_group_type, blood_group_description"
					+ " from bloodgroup where blood_group_donor_id = '"
					+ i + "'";
			break;

		case 3:
			System.out.println("Enter the blood_group_patient_id:");
			i = input.next();
			searchSQL = " select blood_group_id, blood_group_donor_id, blood_group_patient_id, blood_group_type, blood_group_description"
					+ " from bloodgroup where blood_group_patient_id = '"
					+ i + "'";
			break;

		case 4:
			System.out.println("Enter the blood_group_type:");
			i = input.next();
			searchSQL = " select blood_group_id, blood_group_donor_id, blood_group_patient_id, blood_group_type, blood_group_description"
					+ " from bloodgroup where blood_group_type = '"
					+ i + "'";
			break;

		case 5:
			System.out.println("Enter the blood_group_description:");
			i = input.next();
			searchSQL = " select blood_group_id, blood_group_donor_id, blood_group_patient_id, blood_group_type, blood_group_description"
					+ " from bloodgroup where blood_group_description = '"
					+ i + "'";
			break;


		default:
			System.out.println("Invalid choice. Please try again.");
		}

		try {
			PreparedStatement stat = con.prepareStatement(searchSQL);
			ResultSet rs = stat.executeQuery();

			while (rs.next()) {
				System.out.println("blood_group_id: "+ rs.getString("blood_group_id"));
				System.out.println("blood_group_donor_id: "+ rs.getString("blood_group_donor_id"));
				System.out.println("blood_group_patient_id: "+ rs.getString("blood_group_patient_id"));
				System.out.println("blood_group_type: "+ rs.getString("blood_group_type"));
				System.out.println("blood_group_description: "+ rs.getString("blood_group_description"));
				System.out.println("");
			}

		}catch (Exception e) {
			System.out.println("Fail to search the bloodgroup.");
			e.printStackTrace();
		} finally {
			con.close();
		}

	}


}




