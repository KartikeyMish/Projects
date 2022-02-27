package assinghment.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DBLogic
{
    /*--------GLOBAL VARIABLES------------ */
    Connection CONN;
    Statement ST;
    ResultSet RS;
    DriverManager DM;
    PreparedStatement PSTMT;

    String LOAD_DRIVER = "com.mysql.cj.jdbc.Driver";
    String CONNECTION_STRING = "jdbc:mysql://localhost:3306/test";
    String DB_USER = "root";
    String DB_PWD = "";
    String QUERY ;
    int COUNTER;
     /*--------GLOBAL VARIABLES END------------ */

    // function to create connection to the MySQL server
    public Connection CheckConnectionValue()
    throws ClassNotFoundException, SQLException
    {
        // Step 1 : Register Driver
        Class.forName(LOAD_DRIVER);
        // Step 2 : Create Connection
        CONN = DriverManager.getConnection(CONNECTION_STRING, DB_USER, DB_PWD);
        return CONN;
    }

    // Function to Create/ Insert Data
    public int insertDataEmp(int EmpID, String FName,String LName, String City, int ProjID)
                throws SQLException, ClassNotFoundException
    {
        DBLogic logic = new DBLogic();
        CONN = logic.CheckConnectionValue();
        if (CONN != null)
        {
            // MAKING A TEMPLATE TO INSERT THE DATA TO TABLE             
            QUERY = "INSERT INTO employee VALUE(?,?,?,?,?)" ;
            PSTMT = CONN.prepareStatement(QUERY);

            // SETTING THE PARAMETER 
            PSTMT.setInt(1,EmpID); // VALUE FOR 1ST COLUMN 
            PSTMT.setString(2,FName); // VALUE FOR 2ND COLUMN 
            PSTMT.setString(3,LName); // VALUE FOR 3RD COLUMN 
            PSTMT.setString(4, City); // VALUE FOR 4TH COLUMN
            PSTMT.setInt(5, ProjID); // VALUE FOR 5TH COLUMN
            COUNTER = PSTMT.executeUpdate(); // RETURNS THE BOOLEAN VALEUE WHEATEHER THE QUERRY IS EXECUTED OR NOT!
            if(COUNTER != 0)
            {
                System.out.println("Creating data to the database...........");
            }
        }
        return COUNTER;    
    } 

    // Function to Update exhisting data
    public int updateDataEmp(int EmpID, String FName,String LName, String City, int ProjID)
                throws SQLException, ClassNotFoundException
    {
        DBLogic logic = new DBLogic();
        CONN = logic.CheckConnectionValue();
        if (CONN != null)
        {
            /*QUERY = "UPDATE employee SET "+
            "FName = '"+FName+"', LName = '"+LName+"',City = '"+City+"',ProjID = "+ProjID+
            " WHERE EmpID = "+EmpID ;
            // Step 3 : Create Statment
            ST = CONN.createStatement();
            RS = ST.executeQuery(QUERY);*/


            // MAKING A TEMPLATE TO UPDATE THE DATA TO TABLE             
            QUERY = "UPDATE employee SET "+
            "FName = ?, LName = ?,City = ?,ProjID = ? "+
            "WHERE EmpID = ? " ;
            PSTMT = CONN.prepareStatement(QUERY);

            // SETTING THE PARAMETER 
            PSTMT.setString(1,FName);  
            PSTMT.setString(2,LName);  
            PSTMT.setString(3, City); 
            PSTMT.setInt(4, ProjID); 
            PSTMT.setInt(5,EmpID); 
            COUNTER = PSTMT.executeUpdate(); // RETURNS THE BOOLEAN VALEUE WHEATEHER THE QUERRY IS EXECUTED OR NOT!
            if(COUNTER != 0)
            {
                System.out.println("Updating data to the database..........");
            }
        }
        return COUNTER;    
    } 
    
    /*This method will execute querry in  Mysql Server and return 
        Resultset value object. */
    
    // read all data 
    public ResultSet readDataEmp()
        throws SQLException, ClassNotFoundException
    {
        
        DBLogic logic = new DBLogic();
        CONN = logic.CheckConnectionValue();
        if (CONN != null)
        {   
            QUERY = "SELECT * FROM employee";
            // Step 3 : Create Statment
            ST = CONN.createStatement();
            RS = ST.executeQuery(QUERY);
        }
        return RS;
    }

    // Read Specfic Emp data
    public ResultSet readDataEmp(int EmpID)
        throws SQLException, ClassNotFoundException
    {        
        DBLogic logic = new DBLogic();
        CONN = logic.CheckConnectionValue();
        if (CONN != null)
        {   
            QUERY = "SELECT * FROM employee WHERE EmpID = "+EmpID;
            // Step 3 : Create Statment
            ST = CONN.createStatement();
            RS = ST.executeQuery(QUERY);
        }
        return RS;
    }

    public int DeleteDataEmp(int EmpID)
                throws SQLException, ClassNotFoundException
    {
        DBLogic logic = new DBLogic();
        CONN = logic.CheckConnectionValue();
        if (CONN != null)
        {
            // MAKING A TEMPLATE TO UPDATE THE DATA TO TABLE             
            QUERY = "DELETE FROM employee "+
                "WHERE EmpID = ?" ;
            PSTMT = CONN.prepareStatement(QUERY);

            // SETTING THE PARAMETER 
            PSTMT.setInt(1,EmpID); 
            COUNTER = PSTMT.executeUpdate(); // RETURNS THE BOOLEAN VALEUE WHEATEHER THE QUERRY IS EXECUTED OR NOT!
            if(COUNTER != 0)
            {
                System.out.println("Deleting data from the database...........");
            }
        }
        return COUNTER;    
    } 

    public ResultSet getEmpProjID(int EmpID) 
        throws SQLException, ClassNotFoundException
    {
        DBLogic logic = new DBLogic();
        CONN = logic.CheckConnectionValue();
        if (CONN != null)
        {
            QUERY = "SELECT ProjID FROM employee WHERE EmpID = "+EmpID;
            // Step 3 : Create Statment
            ST = CONN.createStatement();
            RS = ST.executeQuery(QUERY);
        }
        return RS;    
    }

    public ResultSet getEmpCity(int EmpID) 
        throws SQLException, ClassNotFoundException
    {
        DBLogic logic = new DBLogic();
        CONN = logic.CheckConnectionValue();
        if (CONN != null)
        {
            QUERY = "SELECT City FROM employee WHERE EmpID = "+EmpID;
            // Step 3 : Create Statment
            ST = CONN.createStatement();
            RS = ST.executeQuery(QUERY);
        }
        return RS;    
    }

    public ResultSet getEmpName(int ProjID) 
        throws SQLException, ClassNotFoundException
    {
        DBLogic logic = new DBLogic();
        CONN = logic.CheckConnectionValue();
        if (CONN != null)
        {
            QUERY = "SELECT FName,LName FROM employee "+
            "WHERE ProjID = "+ProjID;
            // Step 3 : Create Statment
            ST = CONN.createStatement();
            RS = ST.executeQuery(QUERY);
        }
        return RS;    
    }
}
    