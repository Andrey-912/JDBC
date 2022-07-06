package com.company.Query;


//4)	Предоставьте отсортированный список книг определенного издателя (при этом id требуемого издателя можно менять в sql запросе)

import com.company.Connection.JDBC;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        Statement stmt = null;
        try {
            JDBC.connect();
            stmt = JDBC.connection.createStatement();
            Scanner scanner = new Scanner(System.in);
            System.out.println("Choose ID of the Publisher:");
            int publisherID = scanner.nextInt();
            String publisher = "SELECT * FROM titles where publisherID ="+ publisherID + " order by  publisherID =" + publisherID;
            ResultSet rs1 = stmt.executeQuery(publisher);

            while (rs1.next()) {
                int ID = rs1.getInt("publisherID");
                String title = rs1.getString("title");
                System.out.println(ID + "\t" + title);
            }
            System.out.println("\n");
        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } finally {
            //finally block used to close resources
            JDBC.close();
        }
    }
}

