package com.company.Query;

//5)	Выполните добавление Нового автора в БД

import com.company.Connection.JDBC;

import java.io.OptionalDataException;
import java.sql.SQLException;
import java.sql.Statement;

public class Task5 {
    public static void main(String[] argv) {
        updateTables();
    }

    public static void updateTables() {
        try {
            JDBC.connect();
            Statement stmt = JDBC.connection.createStatement();
            updateAuthorsTable(stmt);
        } catch (SQLException e) {
            System.out.println("Connection Failed!");
            e.printStackTrace();
            return;
        }
        JDBC.close();
    }

    private static void updateAuthorsTable(Statement stmt) {
        String authorFirstNames[] = {"Rachel"};
        String authorLastNames[] = {"Wells"};
        // reset the auto increment
        String updateAuthorsTable = "ALTER TABLE authors AUTO_INCREMENT = 1";
        try {
            stmt.executeUpdate(updateAuthorsTable);
        } catch (SQLException e) {
            System.out.println("Execute Update Failed!");
            e.printStackTrace();
            return;
        }
        for (int i = 1; i <= authorFirstNames.length; i++) {
            updateAuthorsTable = "INSERT INTO Authors (firstName, lastName)" + "VALUES ('" + authorFirstNames[i - 1]
                    + "', '" + authorLastNames[i - 1] + "');";
            try {
                stmt.executeUpdate(updateAuthorsTable);
            } catch (SQLException e) {
                System.out.println("Execute Update Failed!");
                e.printStackTrace();
                return;
            }
        }
    }
}