package assinghment.controller;

import java.sql.ResultSet;
import java.sql.SQLException;

import assinghment.model.DBLogic;

public class CURD_EmpData {
    
    // Create Employee data 
    
    public int createEmp(int EmpID, String FName,String LName, String City, int ProjID)
            throws ClassNotFoundException, SQLException
    {
        int COUNTER = 0;
        DBLogic DB = new DBLogic();
        COUNTER = DB.insertDataEmp(EmpID, FName, LName, City, ProjID);
        if(COUNTER != 0)
        {
            System.out.println("Data Inserted! ");
        }

        return COUNTER;
    }

    // Update Employee Data
    public int updateEmp(int EmpID, String FName,String LName, String City, int ProjID)
            throws ClassNotFoundException, SQLException
    {
        int COUNTER = 0;
        DBLogic DB = new DBLogic();
        COUNTER = DB.updateDataEmp(EmpID, FName, LName, City, ProjID);
        if(COUNTER != 0)
        {
            System.out.println("Data Updated!");
        }
        

        return COUNTER;
    }

    // Read Emp Data
    public void readEmp()
    throws ClassNotFoundException, SQLException
    {
        DBLogic obj = new DBLogic();
        ResultSet rs = obj.readDataEmp();
        while (rs.next()) {

            System.out.println("\n-------------------------\n");

            System.out.println("EmpID = "+rs.getInt(1));
            System.out.println("FName = "+rs.getString(2));
            System.out.println("LName = "+rs.getString(3));
            System.out.println("City = "+rs.getString(4));
            System.out.println("ProjID = "+rs.getInt(5));  

        }
    }

    public void readEmp(int EmpID)
    throws ClassNotFoundException, SQLException
    {
        DBLogic obj = new DBLogic();
        ResultSet rs = obj.readDataEmp(EmpID);
        while (rs.next()) {

            System.out.println("\n----- Employee Data -----\n");

            System.out.println("EmpID = "+rs.getInt(1));
            System.out.println("FName = "+rs.getString(2));
            System.out.println("LName = "+rs.getString(3));
            System.out.println("City = "+rs.getString(4));
            System.out.println("ProjID = "+rs.getInt(5));  

        }
    }



    // Delete Employee Data
    public void deleteEmp(int EmpID)
            throws ClassNotFoundException, SQLException
    {
        int COUNTER = 0;
        DBLogic DB = new DBLogic();
        COUNTER = DB.DeleteDataEmp(EmpID);
        if(COUNTER != 0)
        {
            System.out.println("Data Deleted! ");
        }
        

        
    }  
}
