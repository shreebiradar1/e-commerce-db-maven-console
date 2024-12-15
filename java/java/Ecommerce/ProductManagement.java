package Ecommerce;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class ProductManagement extends SQL_Data {
	public static void productManagement() throws SQLException {

		// Database connection

		Connection connection = DriverManager.getConnection(url, username, password);
		Statement statement = connection.createStatement();

		Scanner sc = new Scanner(System.in);
		System.out.println("\t\tWelcome to Product Managment\n");
		while (true) {
			System.out.println("1.Add Product");
			System.out.println("2.Search Product");
			System.out.println("3.Remove Product");
			System.out.println("4.Display Product");
			System.out.println("5.Exit");

			int choice = sc.nextInt();

			if (choice == 1) {
				// Adding Product
				System.out.println("\t Adding Product \n");

				System.out.println("Enter Product Id : ");
				int id = sc.nextInt();

				System.out.println("Enter Product Name : ");
				String name = sc.next();

				System.out.println("Enter Product Price : ");
				int price = sc.nextInt();

				System.out.println("Enter Product Quantity : ");
				int quantity = sc.nextInt();

				String query = "INSERT INTO product\n(productid, name, price, quantity) \n " + "VALUES (" + id + ", '"
						+ name + "', " + price + ", " + quantity + ");";

				statement.execute(query);
				System.out.println("\n New Product Added \n");
			} else if (choice == 2) {
				// Searching Product
				System.out.println("\tSearching Product\n");

				System.out.println("Enter name : ");
				String search = sc.next();

				String query = "Select * From product where name = '" + search + "';";

				ResultSet result = statement.executeQuery(query);
				while (result.next()) {
					for (int i = 1; i < 5; i++) {
						System.out.println(result.getString(i));
					}
				}
			} else if (choice == 3) {
				// Removing Product
				System.out.println("\tRemoving Product\n");
				System.out.println("Enter name : ");
				String remove = sc.next();

				String query = "Delete from product where name = '" + remove + "';";
				statement.execute(query);
				System.out.println("\tProduct Removed Successfull\n");

			} else if (choice == 4) {
				// Displaying Product
				System.out.println("\t Displaying Product \n");
				String display = "Select * from product";

				ResultSet result = statement.executeQuery(display);

				while (result.next()) {
					for (int i = 1; i < 5; i++) {
						System.out.println(result.getString(i));
					}
					System.out.println();
				}
			} else if (choice == 5) {
				// Exiting product Management
				System.out.println("\tExisting Product Management\n");
				connection.close();
				return;
			} else {
				System.out.println("Invalid choice\n");

			}
		}
	}
}
