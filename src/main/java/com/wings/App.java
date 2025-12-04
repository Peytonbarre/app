package com.wings;

import java.sql.SQLException;

import com.wings.controller.ConsoleMenu;
import com.wings.database.DatabaseInitializer;

//mvn clean package
//mvn test
//mvn exec:java

public class App 
{
    public static void main( String[] args )
    {
        try{
            DatabaseInitializer.initialize();
            
        } catch(SQLException e){
            System.out.println("Database Error: " + e);
        }
        ConsoleMenu menu = new ConsoleMenu();
        menu.run();
    }
}
