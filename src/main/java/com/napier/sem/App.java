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

        //Department dept = a.getDepartment("Sales");
        //ArrayList<Employee> employees = a.getSalariesByDepartment(dept);

        // Print Countries report
        //a.printCountries(name);

        // Disconnect from database
        a.disconnect();
    }

    Country getCountry (String ID) {

        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT country.Code, country.Name "
                            + "FROM country "
                            + "WHERE country.Code = '" + ID + "'";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Return new employee if valid.
            // Check one is returned
            if (rset.next())
            {
                Country myCountry = new Country();
                myCountry.code = rset.getString("Code");
                myCountry.name = rset.getString("Name");
                return myCountry;
            }
            else
                return null;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get employee details");
            return null;
        }
    }

    /**
     * Prints countries.
     *
     * @param countries countries to print.
     */
    void printCountries(ArrayList<Country> countries){
        if (countries != null) {
            System.out.println(String.format("%-10s %-15s %-20s", "Name", "Continent", "Population"));
            for (Country country : countries) {
                if (country == null) {
                    continue;
                }
                String formatted_string =
                        String.format("%-10s %-15s %-20s",
                                country.name, country.continent, country.population);
                System.out.println(formatted_string);
            }
        } else {
            System.out.println("No countries");
        }
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


    /** The population of the world. */
    public ArrayList<Country> worldPopulation() {
        return null;
    }

    /** The population of a continent. */
    public ArrayList<Country> continentPopulation(String continent) {
        return null;
    }

    /** The population of a region. */

    public ArrayList<Country> regionPopulation(String region) {
        return null;
    }

    /** The population of a country. */

    public ArrayList<Country> countryPopulation(String country) {
        return null;
    }

    /** The population of a district. */

    private ArrayList<Country> districtPopulation(String district) {
        return null;
    }

    /** The population of a city */

    public ArrayList<Country> cityPopulation(String city) {
        return null;
    }

}