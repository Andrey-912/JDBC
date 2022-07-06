package com.company.Query;

//7)	Добавить нового Publisher
//        Добавить новую Titles (При передачи VALUES publisherID – нужно сделать подзапросом select*from publisher where publisherName =””)
//        Добавить authorISBN (при передачи VALUES необходимо параметр autorID так же сделать подзапросом с указанием имени и фамилии)


import com.company.Connection.JDBC;

import java.sql.SQLException;
import java.sql.Statement;

public class Task7 {
    public static void main(String[] args) {

        try {
            JDBC.connect();
            Statement stmt = JDBC.connection.createStatement();
            String newPublisher = "INSERT INTO publishers (publisherName)" + "VALUES ('HELLO WORD!')";
            String newTitle = "INSERT INTO titles (ISBN, TITLE, EDITIONNUMBER, YEAR, PUBLISHERID, PRICE)" + "VALUES ('123456789', 'new book', 8, 2000,(select publishers.publisherID from publishers where publisherName ='Broadway'),10.01)";
            String newAuthorISBN = "INSERT INTO  authorISBN (authorID, isbn)" + "VALUES ((SELECT authorID FROM authors  WHERE firstname ='Jane' AND lastName = 'Austen'), 123456789)";
            stmt.executeUpdate(newPublisher);
            stmt.executeUpdate(newTitle);
            stmt.executeUpdate(newAuthorISBN);


        } catch (SQLException e) {
            System.out.println("Connection Failed!");
            e.printStackTrace();
            return;
        }
        JDBC.close();
    }

}
