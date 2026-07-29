package BBMS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Stock {


	public static void addStock(Connection con) throws Exception{

		Scanner input = new Scanner(System.in); 
		System.out.println("Enter a stock id:");
		String stock_id = input.next();
		System.out.println("Enter a stock blood:");
		String stock_blood = input.next();
		System.out.println("Enter a stock number:");
		String stock_number = input.next();
		System.out.println("Enter a stock type:");
		String stock_type = input.next();
		System.out.println("Enter a stock description:");
		String stock_description = input.next();

		String addSQL="insert into stock(stock_id,stock_blood,stock_number,stock_type,stock_description) VALUES(?,?,?,?,?)";

		PreparedStatement stat = con.prepareStatement(addSQL);

		stat.setString(1,stock_id);
		stat.setString(2,stock_blood);
		stat.setString(3,stock_number);
		stat.setString(4,stock_type);
		stat.setString(5,stock_description);

		stat.executeUpdate();

		try {
			System.out.println("Stock added successfully.");
		} catch (Exception e) {
			System.out.println("Fail to add a stock.");
			e.printStackTrace();
		} finally {
			con.close(); 
		}

		stat.close();

	}



	public static void editStock(Connection con) throws Exception{

		Scanner input = new Scanner(System.in); 
		System.out.println("Enter the id of the stock you want to edit:");
		String stock_id = input.next();
		System.out.println("Enter a stock blood:");
		String stock_blood = input.next();
		System.out.println("Enter a stock number:");
		String stock_number = input.next();
		System.out.println("Enter a stock type:");
		String stock_type = input.next();
		System.out.println("Enter a stock description:");
		String stock_description = input.next();
		try {
			String editSQL="update stock set stock_blood=?,stock_number=?,stock_type=?,stock_description=? where stock_id=?";
			PreparedStatement stat = con.prepareStatement(editSQL);

			stat.setString(1,stock_blood);
			stat.setString(2,stock_number);
			stat.setString(3,stock_type);
			stat.setString(4,stock_description);
			stat.setString(5,stock_id);

			stat.executeUpdate();
			System.out.println("Stock edited successfully.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Fail to edit the stock.");
			e.printStackTrace();
		}finally {
			con.close(); 
		}



	}



	public static void deleteStock(Connection con) throws Exception{
		Scanner input = new Scanner(System.in); 
		System.out.println("Enter the stock id:");
		String id = input.next();

		String deleteSQL = "delete from stock where stock_id="+id;

		Statement stat = con.createStatement();
		stat.executeUpdate(deleteSQL);

		try {
			System.out.println("Stock deleted successfully.");
		} catch (Exception e) {
			System.out.println("Fail to delete a stock.");
			e.printStackTrace();
		} finally {

			con.close(); 
		}
		stat.close();
	}



	public static void updateStock(){
		System.out.println("Stock updated succssfully.");
	}



	public static void saveStock(){
		System.out.println("Stock saved succssfully.");
	}



	public static void searchStock(Connection con) throws Exception{
		Scanner input = new Scanner(System.in); 

		System.out.println("Choose the way to search");
		System.out.println("1.stock id");
		System.out.println("2.stock blood");
		System.out.println("3.stock number");
		System.out.println("4.stock type");
		System.out.println("5.stock description");
		System.out.println("Enter your choice (1-5): ");
		int choice = input.nextInt();
		input.nextLine();

		String searchSQL="";
		String i;

		switch (choice) {
		case 1:
			System.out.println("Enter the stock_id:");
			i = input.next();
			searchSQL = " select stock_id, stock_blood, stock_number, stock_type, stock_description from stock where stock_id = '"
					+ i + "'";
			break;

		case 2:
			System.out.println("Enter the stock_blood:");
			i = input.next();
			searchSQL = " select stock_id, stock_blood, stock_number, stock_type, stock_description"
					+ " from stock where stock_blood = '"
					+ i + "'";
			break;

		case 3:
			System.out.println("Enter the stock_number:");
			i = input.next();
			searchSQL = " select stock_id, stock_blood, stock_number, stock_type, stock_description"
					+ " from stock where stock_number = '"
					+ i + "'";
			break;

		case 4:
			System.out.println("Enter the stock_type:");
			i = input.next();
			searchSQL = " select stock_id, stock_blood, stock_number, stock_type, stock_description"
					+ " from stock where stock_type = '"
					+ i + "'";
			break;

		case 5:
			System.out.println("Enter the stock_description:");
			i = input.next();
			searchSQL = " select stock_id, stock_blood, stock_number, stock_type, stock_description"
					+ " from stock where stock_description = '"
					+ i + "'";
			break;


		default:
			System.out.println("Invalid choice. Please try again.");
		}

		try {
			PreparedStatement stat = con.prepareStatement(searchSQL);
			ResultSet rs = stat.executeQuery();

			while (rs.next()) {
				System.out.println("stock_id: "+ rs.getString("stock_id"));
				System.out.println("stock_blood: "+ rs.getString("stock_blood"));
				System.out.println("stock_number: "+ rs.getString("stock_number"));
				System.out.println("stock_type: "+ rs.getString("stock_type"));
				System.out.println("stock_description: "+ rs.getString("stock_description"));
				System.out.println("");
			}

		}catch (Exception e) {
			System.out.println("Fail to search the stock.");
			e.printStackTrace();
		} finally {
			con.close();
		}

	}


}
