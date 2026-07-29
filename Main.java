package BBMS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

public class Main{

	public static Connection Connect() throws Exception{
		String url="jdbc:mysql://localhost:3306/bloodbankmanagementsystem"; 
		String usename="root";  
		String psw="";     
		Connection con = DriverManager.getConnection(url,usename,psw);
		return con;
	}

	public static void main(String[] args) throws Exception {
		System.out.println("Blood Bank Management System");
		System.out.println("---------------------------");
		System.out.println("Choose your identity");
		System.out.println("1. User");
		System.out.println("2. Admin");

		System.out.println("Enter your choice (1-2): ");
		Scanner input = new Scanner(System.in); 
		int choice = input.nextInt();


		if (choice==1) {
			System.out.println("Choose the table you want to search");
			System.out.println("1. Blood");
			System.out.println("2. Blood Group");
			System.out.println("3. Blood Cells");
			System.out.println("4. Donor");
			System.out.println("5. Stock");
			System.out.println("6. Order");

			System.out.println("Enter your choice (1-6): ");

			int cho1 = input.nextInt();

			Connection con = Connect();
			switch (cho1) {
			case 1:

				Blood.searchBlood(con);	
				break;

			case 2:
				BloodGroup.searchBloodGroup(con);	
				break;

			case 3:
				BloodCells.searchBloodCells(con);	
				break;

			case 4:

				Donor.searchDonor(con);	
				break;

			case 5:
				Stock.searchStock(con);	
				break;

			case 6:

				Order.searchOrder(con);	
				break;

			}
		}

		else if (choice==2) {
			System.out.println("Choose a table");
			System.out.println("1. Blood");
			System.out.println("2. Blood Group");
			System.out.println("3. Blood Cells");
			System.out.println("4. Donor");
			System.out.println("5. Stock");
			System.out.println("6. Order");

			System.out.println("Enter your choice (1-6): ");

			int cho2 = input.nextInt();

			switch (cho2) {
			case 1:
				Connection con1 = Connect();
				System.out.println("Blood Management System");
				System.out.println("---------------------------");
				System.out.println("1. Add new blood");
				System.out.println("2. Edit blood information");
				System.out.println("3. Delete a blood");
				System.out.println("4. Undate blood information");
				System.out.println("5. Save blood");
				System.out.println("6. Search for a blood");

				System.out.println("Enter your choice (1-6): ");
				int choice1 = input.nextInt();
				input.nextLine();

				switch (choice1) {
				case 1:
					Blood.addBlood(con1);
					break;

				case 2:
					Blood.editBlood(con1);
					break;

				case 3:
					Blood.deleteBlood(con1);
					break;

				case 4:
					Blood.updateBlood();
					break;

				case 5:
					Blood.saveBlood();
					break;

				case 6:
					Blood.searchBlood(con1);
					break;

				default:
					System.out.println("Invalid choice. Please try again.");
				}	
				System.out.println();

				break;


			case 2:
	
					Connection con2 = Connect();

					System.out.println("Blood Group Management System");
					System.out.println("---------------------------");
					System.out.println("1. Add new blood group");
					System.out.println("2. Edit blood group information");
					System.out.println("3. Delete a blood group");
					System.out.println("4. Undate blood group information");
					System.out.println("5. Save blood group");
					System.out.println("6. Search for a blood group");

					System.out.println("Enter your choice (1-6): ");
					int choice2 = input.nextInt();

					switch (choice2) {
					case 1:
						BloodGroup.addBloodGroup(con2);
						break;

					case 2:
						BloodGroup.editBloodGroup(con2);
						break;

					case 3:
						BloodGroup.deleteBloodGroup(con2);
						break;

					case 4:
						BloodGroup.updateBloodGroup();
						break;

					case 5:
						BloodGroup.saveBloodGroup();
						break;

					case 6:
						BloodGroup.searchBloodGroup(con2);
						break;

					default:
						System.out.println("Invalid choice. Please try again.");
					}
					System.out.println();
				
				break;



			case 3:
				Connection con3 = Connect();
				System.out.println("Blood Cells Management System");
				System.out.println("---------------------------");
				System.out.println("1. Add new blood cells");
				System.out.println("2. Edit blood cells information");
				System.out.println("3. Delete a blood cells");
				System.out.println("4. Undate blood cells information");
				System.out.println("5. Save blood cells");
				System.out.println("6. Search for a blood cells");

				System.out.println("Enter your choice (1-6): ");
				int choice3 = input.nextInt();

				switch (choice3) {
				case 1:
					BloodCells.addBloodCells(con3);
					break;

				case 2:
					BloodCells.editBloodCells(con3);
					break;

				case 3:
					BloodCells.deleteBloodCells(con3);
					break;

				case 4:
					BloodCells.updateBloodCells();
					break;

				case 5:
					BloodCells.saveBloodCells();
					break;

				case 6:
					BloodCells.searchBloodCells(con3);
					break;


				default:
					System.out.println("Invalid choice. Please try again.");
				}
				System.out.println();

				break;



			case 4:

				Connection con4 = Connect();

				System.out.println("Donor Management System");
				System.out.println("---------------------------");
				System.out.println("1. Add new donor");
				System.out.println("2. Edit donor information");
				System.out.println("3. Delete a donor");
				System.out.println("4. Undate donor information");
				System.out.println("5. Save donor");
				System.out.println("6. Search for a donor");

				System.out.println("Enter your choice (1-6): ");
				int choice4 = input.nextInt();

				switch (choice4) {
				case 1:
					Donor.addDonor(con4);
					break;

				case 2:
					Donor.editDonor(con4);
					break;

				case 3:
					Donor.deleteDonor(con4);
					break;

				case 4:
					Donor.updateDonor();
					break;

				case 5:
					Donor.saveDonor();
					break;

				case 6:
					Donor.searchDonor(con4);
					break;

				case 7:
					System.exit(0);

				default:
					System.out.println("Invalid choice. Please try again.");
				}
				System.out.println();
				break;


			case 5:

				Connection con5 = Connect();
				System.out.println("Stock Management System");
				System.out.println("---------------------------");
				System.out.println("1. Add new stock");
				System.out.println("2. Edit stock information");
				System.out.println("3. Delete a stock");
				System.out.println("4. Undate stock information");
				System.out.println("5. Save stock");
				System.out.println("6. Search for a stock");


				System.out.println("Enter your choice (1-6): ");
				int choice5 = input.nextInt();
				input.nextLine();

				switch (choice5) {
				case 1:
					Stock.addStock(con5);
					break;

				case 2:
					Stock.editStock(con5);
					break;

				case 3:
					Stock.deleteStock(con5);
					break;

				case 4:
					Stock.updateStock();
					break;

				case 5:
					Stock.saveStock();
					break;

				case 6:
					Stock.searchStock(con5);
					break;

				default:
					System.out.println("Invalid choice. Please try again.");
				}
				System.out.println();
				break;

			case 6:

				Connection con6 = Connect();
				System.out.println("Order Management System");
				System.out.println("---------------------------");
				System.out.println("1. Add new order");
				System.out.println("2. Edit order information");
				System.out.println("3. Delete an order");
				System.out.println("4. Undate order information");
				System.out.println("5. Save order");
				System.out.println("6. Search for an order");

				System.out.println("Enter your choice (1-6): ");
				int choice6 = input.nextInt();
				input.nextLine();

				switch (choice6) {
				case 1:
					Order.addOrder(con6);
					break;

				case 2:
					Order.editOrder(con6);
					break;

				case 3:
					Order.deleteOrder(con6);
					break;

				case 4:
					Order.updateOrder();
					break;

				case 5:
					Order.saveOrder();
					break;

				case 6:
					Order.searchOrder(con6);
					break;

				default:
					System.out.println("Invalid choice. Please try again.");
				}
				System.out.println();
				break;
			}
		}		


		else {
			System.out.println("Invalid choice. Please try again.");
		}



	}
}
