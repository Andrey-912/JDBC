package com.company.Query;

import com.company.Connection.JDBC;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//1)	Сделайте выборку по авторам, отсортировав по их Имени и Фамилии

public class Task1 {
    public static void main(String[] args) {
        Statement stmt = null;
        try {

            JDBC.connect();

            stmt = JDBC.connection.createStatement();
            String task1Author = "SELECT * FROM authors order by  firstName , lastName";
            System.out.println("Show all authors" + "\n" + "firstName:" + "\t\t\t\t" + "lastName:" );

            ResultSet rs1 = stmt.executeQuery(task1Author);
            while (rs1.next()) {
                String  firstName = rs1.getString("firstName");
                String lastName = rs1.getString("lastName");
                System.out.println(firstName + "\t\t\t\t" + lastName);
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
