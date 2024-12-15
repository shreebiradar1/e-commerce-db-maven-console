package Ecommerce;

import java.sql.SQLException;
import java.util.Scanner;

public class Emain {
	public static void main(String[] args) throws SQLException {
		Scanner sc = new Scanner(System.in);

		System.out.println("\t\tWelcome to E-Commerce\n");

		System.out.println("What you want to do today\n");
		while (true) {
			System.out.println("1.User Management");
			System.out.println("2.Product Management");
			System.out.println("3.Exit");
			int check = sc.nextInt();

			if (check == 1) {
				UserManagement.userManagement();

			} else if (check == 2) {
				ProductManagement.productManagement();

			} else if (check == 3) {
				System.out.println("\nExiting Program");
				return;
			} else {
				System.out.println("Invaild choice ");
			}
		}
	}
}
