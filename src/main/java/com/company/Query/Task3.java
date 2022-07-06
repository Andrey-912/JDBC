package com.company.Query;

import com.company.Connection.JDBC;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Task3 {
        public static void main(String[] args) {
            Statement stmt = null;
            try {

                JDBC.connect();

                stmt = JDBC.connection.createStatement();
                String query2Author = "SELECT * FROM Publishers order by  publisherName desc";
                System.out.println("Show all Publishers" );

                ResultSet rs1 = stmt.executeQuery(query2Author);
                while (rs1.next()) {
                    int  publisherID = rs1.getInt("publisherID");
                    String publisherName = rs1.getString("publisherName");
                    System.out.println(publisherID + "\t" + publisherName);
                }
                System.out.println("\n");
                System.out.println("Would you like to change the name of a certain publisher? (y/n) ");
                Scanner scanner = new Scanner(System.in);
                String input = scanner.nextLine();
                if (input.equals("Y") || input.equals("y")) {

                    System.out.println("Enter the new publisher's name:");
                    String publisherName =  scanner.nextLine();
                    System.out.println("Choose the ID of the Publisher:");
                    int  publisherID = scanner.nextInt();
                    String updatePublisher = "update  publishers set publisherName = ' " + publisherName +" '  where  publisherID =" + publisherID ;

//                    String updatePublisher = "update  publishers set publisherName = 'WWW'  where  publisherID = '12' ";
                    stmt.executeUpdate(updatePublisher);
                    System.out.println("Publisher name changed");
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


