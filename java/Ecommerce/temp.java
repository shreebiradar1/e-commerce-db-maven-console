package Ecommerce;

import java.sql.*;
import java.util.Scanner;

public class temp extends SQL_Data {
	{// public static void main(String[] args) throws SQLException {

//
//	//Database connection
//	String url = "jdbc:mysql://127.0.0.1:3306/product_management";
//	String username = "root";
//	String password = "Shree@123";
//	
//	Connection connect = DriverManager.getConnection(url, username, password);
//	
//	Statement statement = connect.createStatement();
//	Scanner scan = new Scanner(System.in);
//
////			search(connect);
////			delete(connect);
////			display(connect);
//			insert(connect);
//	
//	}
//	static Scanner sc = new Scanner(System.in);
//	
//	public static void insert(Connection connect) throws SQLException {
//		System.out.println("Enter id : ");
//		int id = sc.nextInt();
//		
//		System.out.println("Enter Product name : ");
//		String name = sc.next();
//		
//		System.out.println("Enter Price : ");
//		int price = sc.nextInt();
//		
//		System.out.println("Enter Quantity : ");
//		int quantity = sc.nextInt();
//		
//		Statement st = connect.createStatement();
//		
//		String query ="INSERT INTO product_management.product (productid,name,price,quantity)"+
//		"VALUES("+id+", '"+name+"', "+price +", "+ quantity+");" ;
//		
//		st.execute(query);
//	
//	}
//	
//	public static void search(Connection connect) throws SQLException {
//		
//		Statement statement = connect.createStatement();
//		
//		System.out.println("Enter name to Search : ");
//		String search = sc.next();
//		String query = "SELECT * FROM product WHERE name = ?";
//		
//		PreparedStatement preparedStatement = connect.prepareStatement(query);
//        preparedStatement.setString(1, search);
//				
//		
//		ResultSet result = preparedStatement.executeQuery();
//		
//		while(result.next()) {
//			for(int i = 1;i<5;i++) {
//			System.out.println(result.getString(i));
//			}
//		}
//	}
//	
//	public static void delete(Connection connect) throws SQLException {
//		System.out.println("Enter Product name to delete : ");
//		String remove = sc.next();
//		
//		String query1 = "SELECT * FROM product WHERE name = ?";
//		
//		String query2 = "Delete from product where name = "+ remove;
//		PreparedStatement prestatement = connect.prepareStatement(query2);
//		prestatement.setString(1, remove);
////		ResultSet result = prestatement.executeQuery();
//
//		prestatement.execute();
//		
//		System.out.println("Product Removed successfully\n");
//		
//	}
//	
//	public static void display(Connection connect) throws SQLException {
//		String display = "Select * from product";
//		Statement statement = connect.createStatement();
//		
//		ResultSet result = statement.executeQuery(display);
//		
//		while(result.next()) {
//			for(int i = 1;i<5;i++) {
//				System.out.println(result.getString(i));
//			}
//		}
//		
//		
//	}
	}
	// Ignore this above code

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
				String query = "INSERT INTO user_management.user (id,user_name,email,mobile)" + "VALUES (?,?,?,?)";

				// While using scanner class we have to use PreparedStatement to insert data
				// into database
				// Instead of creating string variable we can directly pass the query here
				PreparedStatement preStatement = connection.prepareStatement(query);

				// Setting values which we taking from the user
				// we can set by using preStatement which is object_name for PerparedStatement
				preStatement.setInt(1, userid);
				preStatement.setString(2, name);
				preStatement.setString(3, mail);
				preStatement.setString(4, mobile);

				// Most important DONT FORGET TO EXCUTE THE QUERY
				preStatement.execute();

				// After all that stuff we can say that new user is added into database
				System.out.println("\t New User Added \n");

			}

			else if (check == 2) {
				System.out.println("\t Searching User \n");

				System.out.println("Enter Username : ");
				String search = scan.next();

				// For every block i guess we have to create PreparedStatement before that we
				// have to write the SQL query
				String query = "SELECT * FROM user_management.user where user_name = ?";
				PreparedStatement preStatement = connection.prepareStatement(query);

				// For search ---------------------------------------------------

				preStatement.setString(1, search);

				// Just printing particular row
				// For that we use ResultSet is a class which collect all the result after
				// executing the query and store it in a variable
				ResultSet result = preStatement.executeQuery();

				// result.next -> It moves the cursor one row forward, A cursor is initially
				// positioned before the first row.
				// For that reason we need to push the cursor for that we use this method
				while (result.next()) {
					for (int i = 1; i < 5; i++) {
						System.out.println(result.getString(i));
					}
				}
				// After all that the search operation is also completed

			} else if (check == 3) {
				System.out.println("\t Removing User \n");

				System.out.println("Enter Username : ");
				String remove = scan.next();

				String query = "DELETE from user_management.user WHERE user_name = ?";
				PreparedStatement preStatement = connection.prepareStatement(query);

				preStatement.setString(1, remove);
				System.out.println("\t User Removed Successfully \n");

				// Without this it can't be Removed
				preStatement.execute();
				// Completed Remove operation
			} else if (check == 4) {
				System.out.println("/t Displaying User \n");

				String query = "SELECT * from user_management.user";

				ResultSet result = statement.executeQuery(query);

				// Just created a simple loop for Displaying
				while (result.next()) {
					for (int i = 1; i < 5; i++) {
						System.out.println(result.getString(i));
					}
				}
				System.out.println("--------------------");

			} else if (check == 5) {
				// After all that remember to close the connection from the server
				connection.close();
				System.out.println("\t Existing User Management \n");
				return;
			} else {
				System.out.println("\t Invail option \n try again");
			}
		}

	}

}