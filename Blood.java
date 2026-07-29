package BBMS;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class Blood {

	public static void addBlood(Connection con) throws Exception{
		Scanner input = new Scanner(System.in); 
		System.out.println("Enter a blood id:");
		String blood_id = input.next();
		System.out.println("Enter a blood donor id:");
		String blood_donor_id = input.next();
		System.out.println("Enter a blood patient id:");
		String blood_patient_id = input.next();
		System.out.println("Enter a blood group (A/B/AB/O):");
		String blood_group = input.next();
		System.out.println("Enter a blood bank:");
		String blood_bank = input.next();
		System.out.println("Enter blood cells (WB/RBC/WBC/PLT/PL):");
		String blood_cells = input.next();
		System.out.println("Enter a blood type (Rh+/Rh-):");
		String blood_type = input.next();
		System.out.println("Enter a blood description:");
		String blood_description = input.next();

		String addSQL="insert into blood(blood_id,blood_donor_id,"
				+ "blood_patient_id,blood_group,blood_bank,blood_cells,blood_type,"
				+ "blood_description) VALUES(?,?,?,?,?,?,?,?)";

		PreparedStatement stat = con.prepareStatement(addSQL);

		stat.setString(1,blood_id);
		stat.setString(2,blood_donor_id);
		stat.setString(3,blood_patient_id);
		stat.setString(4,blood_group);
		stat.setString(5,blood_bank);
		stat.setString(6,blood_cells);
		stat.setString(7,blood_type);
		stat.setString(8,blood_description);

		stat.executeUpdate();

		try {
			System.out.println("Blood added successfully.");
		} catch (Exception e) {
			System.out.println("Fail to add a blood.");
			e.printStackTrace();
		} finally {
			con.close(); 
		}

		stat.close();
	}



	public static void editBlood(Connection con) throws Exception{
		Scanner input = new Scanner(System.in); 
		System.out.println("Enter the id of the blood you want to edit:");
		String blood_id = input.next();
		System.out.println("Enter a blood donor id:");
		String blood_donor_id = input.next();
		System.out.println("Enter a blood patient id:");
		String blood_patient_id = input.next();
		System.out.println("Enter a blood group (A/B/AB/O):");
		String blood_group = input.next();
		System.out.println("Enter a blood bank:");
		String blood_bank = input.next();
		System.out.println("Enter blood cells (WB/RBC/WBC/PLT/PL):");
		String blood_cells = input.next();
		System.out.println("Enter a blood type (Rh+/Rh-):");
		String blood_type = input.next();
		System.out.println("Enter a blood description:");
		String blood_description = input.next();

		try {
			String editSQL="update blood set blood_donor_id=?,blood_patient_id=?,"
					+ "blood_group=?,blood_bank=?,blood_cells=?,blood_type=?,"
					+ "blood_description=? where blood_id=?";
			PreparedStatement stat = con.prepareStatement(editSQL);

			stat.setString(1,blood_donor_id);
			stat.setString(2,blood_patient_id);
			stat.setString(3,blood_group);
			stat.setString(4,blood_bank);
			stat.setString(5,blood_cells);
			stat.setString(6,blood_type);
			stat.setString(7,blood_description);
			stat.setString(8,blood_id);

			stat.executeUpdate();
			System.out.println("Blood edited successfully.");
		} catch (SQLException e) {
			System.out.println("Fail to edit the blood.");
			e.printStackTrace();
		}finally {
			con.close(); 
		}
	}



	public static void deleteBlood(Connection con) throws Exception{

		Scanner input = new Scanner(System.in); 
		System.out.println("Enter the blood id:");
		String id = input.next();

		String deleteSQL = "delete from blood where blood_id="+id;

		Statement stat = con.createStatement();
		stat.executeUpdate(deleteSQL);

		try {
			System.out.println("Blood deleted successfully.");
		} catch (Exception e) {
			System.out.println("Fail to delete a blood.");
			e.printStackTrace();
		} finally {
			con.close(); 
		}
		stat.close();
	}



	public static void updateBlood(){
		System.out.println("Blood updated succssfully.");
	}



	public static void saveBlood(){
		System.out.println("Blood saved succssfully.");
	}



	public static void searchBlood(Connection con) throws Exception{
		Scanner input = new Scanner(System.in); 

		System.out.println("Choose the way to search");
		System.out.println("1.id");
		System.out.println("2.blood donor id");
		System.out.println("3.blood patient id");
		System.out.println("4.blood group");
		System.out.println("5.blood bank");
		System.out.println("6.blood cells");
		System.out.println("7.blood type");
		System.out.println("8.blood description");
		System.out.println("Enter your choice (1-8): ");
		int choice = input.nextInt();
		input.nextLine();

		String searchSQL="";
		String i;

		switch (choice) {
		case 1:
			System.out.println("Enter the blood id:");
			i = input.next();
			searchSQL = " select blood_id, blood_donor_id, blood_patient_id, blood_group, blood_bank, blood_cells, blood_type, "
					+ "blood_description from blood where blood_id = '"
					+ i + "'";
			break;

		case 2:
			System.out.println("Enter the blood donor id:");
			i = input.next();
			searchSQL = " select blood_id, blood_donor_id, blood_patient_id, blood_group, blood_bank, blood_cells, blood_type, "
					+ "blood_description from blood where blood_donor_id = '"
					+ i + "'";
			break;

		case 3:
			System.out.println("Enter the blood patient id:");
			i = input.next();
			searchSQL = " select blood_id, blood_donor_id, blood_patient_id, blood_group, blood_bank, blood_cells, blood_type, "
					+ "blood_description from blood where blood_patient_id = '"
					+ i + "'";
			break;

		case 4:
			System.out.println("Enter the blood group:");
			i = input.next();
			searchSQL = " select blood_id, blood_donor_id, blood_patient_id, blood_group, blood_bank, blood_cells, blood_type, "
					+ "blood_description from blood where blood_group = '"
					+ i + "'";
			break;

		case 5:
			System.out.println("Enter the blood bank:");
			i = input.next();
			searchSQL = " select blood_id, blood_donor_id, blood_patient_id, blood_group, blood_bank, blood_cells, blood_type, "
					+ "blood_description from blood where blood_bank = '"
					+ i + "'";
			break;

		case 6:
			System.out.println("Enter the blood cells:");
			i = input.next();
			searchSQL = " select blood_id, blood_donor_id, blood_patient_id, blood_group, blood_bank, blood_cells, blood_type, "
					+ "blood_description from blood where blood_cells = '"
					+ i + "'";
			break;

		case 7:
			System.out.println("Enter the blood type:");
			i = input.next();
			searchSQL = " select blood_id, blood_donor_id, blood_patient_id, blood_group, blood_bank, blood_cells, blood_type, "
					+ "blood_description from blood where blood_type = '"
					+ i + "'";
			break;

		case 8:
			System.out.println("Enter the blood description:");
			i = input.next();
			searchSQL = " select blood_id, blood_donor_id, blood_patient_id, blood_group, blood_bank, blood_cells, blood_type, "
					+ "blood_description from blood where blood_description = '"
					+ i + "'";
			break;

		default:
			System.out.println("Invalid choice. Please try again.");
		}

		try {
			PreparedStatement stat = con.prepareStatement(searchSQL);
			ResultSet rs = stat.executeQuery();

			while (rs.next()) {
				System.out.println("blood_id: "+ rs.getString("blood_id"));
				System.out.println("blood_donor_id: "+ rs.getString("blood_donor_id"));
				System.out.println("blood_patient_id: "+ rs.getString("blood_patient_id"));
				System.out.println("blood_group: "+ rs.getString("blood_group"));
				System.out.println("blood_bank: "+ rs.getString("blood_bank"));
				System.out.println("blood_cells: "+ rs.getString("blood_cells"));
				System.out.println("blood_type: "+ rs.getString("blood_type"));
				System.out.println("blood_description: "+ rs.getString("blood_description"));
				System.out.println("");
			}

		}catch (Exception e) {
			System.out.println("Fail to search the blood.");
			e.printStackTrace();
		} finally {
			con.close();
		}

	}

}
