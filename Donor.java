package BBMS;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Donor {

	public static void addDonor(Connection con) throws Exception{

		Scanner input = new Scanner(System.in); 
		System.out.println("Enter a donor id:");
		String id = input.next();
		System.out.println("Enter a donor name:");
		String name = input.next();
		System.out.println("Enter a donor mobile:");
		String mobile = input.next();
		System.out.println("Enter a donor email:");
		String email = input.next();;
		System.out.println("Enter a donor username:");
		String username = input.next();
		System.out.println("Enter a donor password:");
		String password = input.next();
		System.out.println("Enter a donor address:");
		String address = input.next();
		System.out.println("Enter a donor blood group:");
		String blood_group = input.next();

		String addSQL="insert into donor(Donor_id,Donor_name,Donor_mobile,Donor_email,Donor_username,Donor_password,Donor_address,Donor_blood_group) VALUES(?,?,?,?,?,?,?,?)";

		PreparedStatement stat = con.prepareStatement(addSQL);

		stat.setString(1,id);
		stat.setString(2,name);
		stat.setString(3,mobile);
		stat.setString(4,email);
		stat.setString(5,username);
		stat.setString(6,password);
		stat.setString(7,address);
		stat.setString(8,blood_group);

		stat.executeUpdate();

		try {
			System.out.println("Donor added successfully.");
		} catch (Exception e) {
			System.out.println("Fail to add a donor.");
			e.printStackTrace();
		} finally {
			con.close(); 
		}

		stat.close();

	}



	public static void editDonor(Connection con) throws Exception{
		Scanner input = new Scanner(System.in); 
		System.out.println("Enter the id of the donor you want to edit:");
		String id = input.next();
		System.out.println("Enter a donor name:");
		String name = input.next();
		System.out.println("Enter a donor mobile:");
		String mobile = input.next();
		System.out.println("Enter a donor email:");
		String email = input.next();;
		System.out.println("Enter a donor username:");
		String username = input.next();
		System.out.println("Enter a donor password:");
		String password = input.next();
		System.out.println("Enter a donor address:");
		String address = input.next();
		System.out.println("Enter a donor blood group:");
		String blood_group = input.next();

		try {
			String editSQL = "update donor set Donor_name=?,Donor_mobile=?,Donor_email=?,Donor_username=?,Donor_password=?,Donor_address=?,Donor_blood_group=? where Donor_id=?";
			PreparedStatement stat = con.prepareStatement(editSQL);


			stat.setString(1, name);
			stat.setString(2, mobile);
			stat.setString(3, email);
			stat.setString(4, username);
			stat.setString(5, password);
			stat.setString(6, address);
			stat.setString(7, blood_group);
			stat.setString(8, id);

			stat.executeUpdate();
			System.out.println("Donor edited successfully.");
		} catch (SQLException e) {
			System.out.println("Fail to edit the donor.");
			e.printStackTrace();
		} finally {
			con.close();
		}

	}


	public static void deleteDonor(Connection con) throws Exception{

		Scanner input = new Scanner(System.in); 
		System.out.println("Enter the donor id:");
		String id = input.next();

		String deleteSQL = "delete from donor where donor_id="+id;

		Statement stat = con.createStatement();
		stat.executeUpdate(deleteSQL);

		try {
			System.out.println("Donor deleted successfully.");
		} catch (Exception e) {
			System.out.println("Fail to delete a donor.");
			e.printStackTrace();
		} finally {
			con.close();
		}
		stat.close();
	}



	public static void updateDonor(){
		System.out.println("Donor updated succssfully.");
	}



	public static void saveDonor(){
		System.out.println("Donor saved succssfully.");
	}



	public static void searchDonor(Connection con) throws Exception{
		Scanner input = new Scanner(System.in); 

		System.out.println("Choose the way to search");
		System.out.println("1.id");
		System.out.println("2.name");
		System.out.println("3.mobile");
		System.out.println("4.email");
		System.out.println("5.username");
		System.out.println("6.password");
		System.out.println("7.address");
		System.out.println("8.blood group");
		System.out.println("Enter your choice (1-8): ");
		int choice = input.nextInt();
		input.nextLine();

		String searchSQL="";
		String i;

		switch (choice) {
		case 1:
			System.out.println("Enter the donor id:");
			i = input.next();
			searchSQL = " select Donor_id, Donor_name, Donor_mobile, Donor_email, Donor_username, Donor_password, Donor_address, Donor_blood_group from donor where Donor_id = '"
					+ i + "'";
			break;

		case 2:
			System.out.println("Enter the donor name:");
			i = input.next();
			searchSQL = " select Donor_id, Donor_name, Donor_mobile, Donor_email, Donor_username, Donor_password, Donor_address, Donor_blood_group from donor where Donor_name = '"
					+ i + "'";
			break;

		case 3:
			System.out.println("Enter the donor mobile:");
			i = input.next();
			searchSQL = " select Donor_id, Ddonor_name, Donor_mobile, Donor_email, Donor_username, Donor_password, Donor_address, Donor_blood_group from donor where Donor_mobile = '"
					+ i + "'";
			break;

		case 4:
			System.out.println("Enter the donor email:");
			i = input.next();
			searchSQL = " select Donor_id, Donor_name, Donor_mobile, Donor_email, Donor_username, Donor_password, Donor_address, Donor_blood_group from donor where Donor_email = '"
					+ i + "'";
			break;

		case 5:
			System.out.println("Enter the donor username:");
			i = input.next();
			searchSQL = " select Donor_id, Donor_name, Donor_mobile, Donor_email, Donor_username, Donor_password, Donor_address, Donor_blood_group from donor where Donor_username = '"
					+ i + "'";
			break;

		case 6:
			System.out.println("Enter the donor password:");
			i = input.next();
			searchSQL = " select Donor_id, Donor_name, Donor_mobile, Donor_email, Donor_username, Donor_password, Donor_address, Donor_blood_group from donor where Donor_password = '"
					+ i + "'";
			break;

		case 7:
			System.out.println("Enter the donor address:");
			i = input.next();
			searchSQL = " select Donor_id, Donor_name, Donor_mobile, Donor_email, Donor_username, Donor_password, Donor_address, Donor_blood_group from donor where Donor_address = '"
					+ i + "'";
			break;

		case 8:
			System.out.println("Enter the donor blood group:");
			i = input.next();
			searchSQL = " select Donor_id, Donor_name, Donor_mobile, Donor_email, Donor_username, Donor_password, Donor_address, Donor_blood_group from donor where Donor_blood_group = '"
					+ i + "'";
			break;

		default:
			System.out.println("Invalid choice. Please try again.");
		}

		try {
			PreparedStatement stat = con.prepareStatement(searchSQL);
			ResultSet rs = stat.executeQuery();

			while (rs.next()) {
				System.out.println("id: "+ rs.getString("donor_id"));
				System.out.println("name: "+ rs.getString("donor_name"));
				System.out.println("mobile: "+ rs.getString("donor_mobile"));
				System.out.println("email: "+ rs.getString("donor_email"));
				System.out.println("username: "+ rs.getString("donor_username"));
				System.out.println("password: "+ rs.getString("donor_password"));
				System.out.println("address: "+ rs.getString("donor_address"));
				System.out.println("blood group: "+ rs.getString("donor_blood_group"));
				System.out.println("");
			}

		}catch (Exception e) {
			System.out.println("Fail to search the donor.");
			e.printStackTrace();
		} finally {
			con.close();
		}

	}
}

