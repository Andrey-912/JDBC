package com.company.Query;

//6)	Обновите Имя автора по определенному id

import com.company.Connection.JDBC;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Task6 {
    public static void main(String[] args) {
        Statement stmt = null;
        try {

            JDBC.connect();

            stmt = JDBC.connection.createStatement();


            System.out.println("\n");
            System.out.println("Would you like to update the author's names? (y/n) ");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            if (input.equals("Y") || input.equals("y")) {
                System.out.println("Enter the new firstname of the author:");
                String firstName =  scanner.nextLine();
                System.out.println("Enter the new lastname of the author:");
                String lastName =  scanner.nextLine();
                System.out.println("Specify the ID of the author, who  you would like to change:");
                int   authorID = scanner.nextInt();

                String updateAuthors = "UPDATE  authors SET firstName = ' "+ firstName +" ' , lastName = ' "+ lastName +" '  WHERE authorID =" + authorID ;

                stmt.executeUpdate(updateAuthors);
                System.out.println("Author's names changed");
            }
        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } finally {
            //finally block used to close resources
            JDBC.close();
        }
    }
}
