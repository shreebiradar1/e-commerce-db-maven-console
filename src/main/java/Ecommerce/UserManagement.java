package Ecommerce;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class UserManagement extends SQL_Data {
	public static void userManagement() throws SQLException {
		// Connection of the DataBase
		// For safety purposes the data is kept Hidden
		// The data is accessed by inheriting the class

		// Connection and for writing MySql code in eclipse we write statement
		Connection connection = DriverManager.getConnection(url, username, password);
		Statement statement = connection.createStatement();
		// UserManagement Started
		Scanner scan = new Scanner(System.in);

		System.out.println("\t\t Welcome to User-Management \n");

		while (true) {
			System.out.println("1.Add User");
			System.out.println("2.Search User");
			System.out.println("3.Remove User");
			System.out.println("4.Display User");
			System.out.println("5.Exit");

			int check = scan.nextInt();

			if (check == 1) {
				System.out.println("\t Adding User \n");

				System.out.println("Enter User id : ");
				int userid = scan.nextInt();

				System.out.println("Enter Username : ");
				String name = scan.next();

				System.out.println("Enter Email : ");
				String mail = scan.next();

				System.out.println("Enter Mobile number : ");
				String mobile = scan.next();

				// SQL Query
				String query = "INSERT INTO user_management.user (id,user_name,email,mobile)" + "VALUES(" + userid
						+ ", '" + name + "', '" + mail + "', '" + mobile + "');";

				statement.execute(query);
				System.out.println("\t New User Added \n");

			}

			else if (check == 2) {
				System.out.println("\t Searching User \n");

				System.out.println("Enter Username : ");
				String search = scan.next();

				String query = "SELECT * FROM user_management.user where user_name = '" + search + "';";

				ResultSet result = statement.executeQuery(query);
				while (result.next()) {
					for (int i = 1; i < 5; i++) {
						System.out.println(result.getString(i));
					}
				}
			} else if (check == 3) {
				System.out.println("\t Removing User \n");

				System.out.println("Enter Username : ");
				String remove = scan.next();

				String query = "DELETE from user_management.user WHERE user_name = '" + remove + "';";
				statement.execute(query);

				System.out.println("\t User Removed Successfully \n");

			} else if (check == 4) {
				System.out.println("\t Displaying User \n");

				String query = "SELECT * from user_management.user";

				ResultSet result = statement.executeQuery(query);

				while (result.next()) {
					for (int i = 1; i < 5; i++) {
						System.out.println(result.getString(i));
					}
				}
				System.out.println("--------------------");

			} else if (check == 5) {
				connection.close();
				System.out.println("\t Existing User Management \n");
				return;
			} else {
				System.out.println("\t Invail option \n try again");
			}
		}

	}
}
