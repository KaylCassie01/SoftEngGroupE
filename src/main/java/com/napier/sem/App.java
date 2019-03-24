package com.napier.sem;

import java.util.ArrayList;
import java.sql.*;

public class App
{
    private static Connection con = null;

    public static void main(String[] args) {    // Create new Application
        App a = new App();

        // Connect to database
        if (args.length < 1) {
            a.connect("localhost:33060");
        } else {
            a.connect(args[0]);
        }

        Department dept = a.getDepartment("Sales");
        ArrayList<Employee> employees = a.getSalariesByDepartment(dept);

        // Print salary report
        a.printSalaries(employees);

//        void printCountries(ArrayList<Country> countries) {
//            // Check countries is not null
//            if (countries == null) {
//                System.out.println("No countries");
//                return;
//            }
//            // Print header
//            System.out.println(String.format("%-10s %-15s %-20s %-8s", "ID", "Name", "CountryCode", "District", "Population"));
//
//            for (Country emp : countries) {
//                String emp_string =
//                        String.format("%-10s %-15s %-20s %-8s",
//                                emp.id, emp.name, emp.country_code, emp.district, emp.population);
//                System.out.println(emp_string);
//            }
//        }

        /**
         * Prints countries.
         *
         * @param countries countries to print.
         */
        void printCountries(ArrayList<Country> countries) {
            if (countries != null) {
                System.out.println(String.format("%-10s %-15s %-20s", "Name", "Continent", "Population"));
                for (Country country : countries) {
                    if (country == null) {
                        continue;
                    }
                    String formatted_string =
                            String.format("%-10s %-15s %-20s",
                                    country.Name, country.Continent, country.Population);
                    System.out.println(formatted_string);
                }
            } else {
                System.out.println("No countries");
            }
        }



        // Disconnect from database
        a.disconnect();
    }
    public void connect(String location)
    {
        try
        {
            // Load Database driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("Could not load SQL driver");
            System.exit(-1);
        }

        int retries = 10;
        for (int i = 0; i < retries; ++i)
        {
            System.out.println("Connecting to database...");
            try
            {
                // Wait a bit for db to start
                Thread.sleep(30000);
                // Connect to database
                con = DriverManager.getConnection("jdbc:mysql://" + location + "/world?allowPublicKeyRetrieval=true&useSSL=false", "root", "example");
                System.out.println("Successfully connected");
                break;
            }
            catch (SQLException sqle)
            {
                System.out.println("Failed to connect to database attempt " + i);
                System.out.println(sqle.getMessage());
            }
            catch (InterruptedException ie)
            {
                System.out.println("Thread interrupted? Should not happen.");
            }
        }
    }

    public void disconnect()
    {
        if (con != null)
        {
            try
            {
                // Close connection
                con.close();
            }
            catch (Exception e)
            {
                System.out.println("Error closing connection to database");
            }
        }
    }

}