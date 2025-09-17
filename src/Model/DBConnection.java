package Model;

import java.sql.*;

public class DBConnection 
{
    private static Connection con;

    public static Connection createDBConnection()
    {
        try 
        {
            String url = "jdbc:mysql://localhost/hardware";
            con = DriverManager.getConnection(url, "root", "");
        } 
        catch (SQLException ex)
        {
            System.out.println("DB Connection ERROR!");
        }
        return con;
    }
}