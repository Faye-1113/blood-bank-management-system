package BBMS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Order {

	public static void addOrder(Connection con) throws Exception{

		Scanner input = new Scanner(System.in); 
		System.out.println("Enter an order id:");
		String Order_id = input.next();
		System.out.println("Enter an order cutoner id:");
		String Order_customer_id = input.next();
		System.out.println("Enter an order type:");
		String Order_type = input.next();
		System.out.println("Enter an order number:");
		String Order_number = input.next();
		System.out.println("Enter an order description:");
		String Order_description = input.next();

		String addSQL="insert into orderr(order_id,order_customer_id,order_type,order_number,order_description) VALUES(?,?,?,?,?)";

		PreparedStatement stat = con.prepareStatement(addSQL);

		stat.setString(1,Order_id);
		stat.setString(2,Order_customer_id);
		stat.setString(3,Order_type);
		stat.setString(4,Order_number);
		stat.setString(5,Order_description);

		stat.executeUpdate();

		try {
			System.out.println("Order added successfully.");
		} catch (Exception e) {
			System.out.println("Fail to add an order.");
			e.printStackTrace();
		} finally {
			con.close(); 
		}

		stat.close();

	}



	public static void editOrder(Connection con) throws Exception{
		Scanner input = new Scanner(System.in); 
		System.out.println("Enter the id of the order you want to edit:");
		String Order_id = input.next();
		System.out.println("Enter an order cutoner id:");
		String Order_customer_id = input.next();
		System.out.println("Enter an order type:");
		String Order_type = input.next();
		System.out.println("Enter an order number:");
		String Order_number = input.next();
		System.out.println("Enter an order description:");
		String Order_description = input.next();

		try {
			String editSQL="update orderr set Order_customer_id=?,Order_type=?,Order_number=?,Order_description=? where Order_id=?";
			PreparedStatement stat = con.prepareStatement(editSQL);

			stat.setString(1,Order_customer_id);
			stat.setString(2,Order_type);
			stat.setString(3,Order_number);
			stat.setString(4,Order_description);
			stat.setString(5,Order_id);

			stat.executeUpdate();
			System.out.println("Order edited successfully.");
		} catch (SQLException e) {
			System.out.println("Fail to edit the order.");
			e.printStackTrace();
		}finally {
			con.close(); 
		}

	}



	public static void deleteOrder(Connection con) throws Exception{
		Scanner input = new Scanner(System.in); 
		System.out.println("Enter the order id:");
		String id = input.next();
		String deleteSQL = "delete from orderr where order_id='"+id+"'";

		Statement stat = con.createStatement();
		stat.executeUpdate(deleteSQL);

		try {
			System.out.println("Order deleted successfully.");
		} catch (Exception e) {
			System.out.println("Fail to delete an order.");
			e.printStackTrace();
		} finally {

			con.close(); 
		}
		stat.close();
	}





	public static void updateOrder(){
		System.out.println("Order updated succssfully.");
	}



	public static void saveOrder(){
		System.out.println("Order saved succssfully.");
	}



	public static void searchOrder(Connection con) throws Exception{

		Scanner input = new Scanner(System.in); 

		System.out.println("Choose the way to search");
		System.out.println("1.Order id");
		System.out.println("2.Order customer id");
		System.out.println("3.Order type");
		System.out.println("4.Order number");
		System.out.println("5.Order description");
		System.out.println("Enter your choice (1-5): ");
		int choice = input.nextInt();
		input.nextLine();

		String searchSQL="";
		String i;

		switch (choice) {
		case 1:
			System.out.println("Enter the Order_id:");
			i = input.next();
			searchSQL = " select order_id, Order_customer_id, Order_type, Order_number, Order_description"
					+ " from Orderr where order_id = '"
					+ i + "'";
			break;

		case 2:
			System.out.println("Enter the Order_customer_id:");
			i = input.next();
			searchSQL = " select Order_id, Order_customer_id, Order_type, Order_number, Order_description"
					+ " from orderr where Order_customer_id = '"
					+ i + "'";
			break;

		case 3:
			System.out.println("Enter the Order_type:");
			i = input.next();
			searchSQL = " select Order_id, Order_customer_id, Order_type, Order_number, Order_description "
					+ "from orderr where Order_type = '"
					+ i + "'";
			break;

		case 4:
			System.out.println("Enter the Order_number:");
			i = input.next();
			searchSQL = " select Order_id, Order_customer_id, Order_type, Order_number, Order_description "
					+ "from orderr where Order_number = '"
					+ i + "'";
			break;

		case 5:
			System.out.println("Enter the Order_description:");
			i = input.next();
			searchSQL = " select Order_id, Order_customer_id, Order_type, Order_number, Order_description"
					+ " from orderr where Order_description = '"
					+ i + "'";
			break;


		default:
			System.out.println("Invalid choice. Please try again.");
		}

		try {
			PreparedStatement stat = con.prepareStatement(searchSQL);
			ResultSet rs = stat.executeQuery();

			while (rs.next()) {
				System.out.println("Order_id: "+ rs.getString("Order_id"));
				System.out.println("Order_customer_id: "+ rs.getString("Order_customer_id"));
				System.out.println("Order_type: "+ rs.getString("Order_type"));
				System.out.println("Order_number: "+ rs.getString("Order_number"));
				System.out.println("Order_description: "+ rs.getString("Order_description"));
				System.out.println("");
			}

		}catch (Exception e) {
			System.out.println("Fail to search the order.");
			e.printStackTrace();
		} finally {
			con.close();
		}

	}

}
