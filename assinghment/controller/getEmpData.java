package assinghment.controller;

import java.sql.*;
import assinghment.model.DBLogic;

public class getEmpData {    

    // get Project Id by giving EmpID
    public int getprojID(int EmpID)
            throws ClassNotFoundException, SQLException
    {
        DBLogic DB = new DBLogic();
        ResultSet RS = DB.getEmpProjID(EmpID);
        int ProjID = 0; 
        if(RS.next())
        {    
            ProjID= RS.getInt(1);  
        }

        return ProjID;    
    }

    // get Employee City by giving EmpID
    public String getEmplCity(int EmpID)
            throws ClassNotFoundException, SQLException
    {
        DBLogic DB = new DBLogic();
        ResultSet RS = DB.getEmpCity(EmpID);
        String EmplCity = null;
        if(RS.next())
        {
            EmplCity= RS.getString(1);        
        }

        return EmplCity;
    }
    
    // get Employee Name by giving Project ID.
    public String getEmplName(int ProjID)
            throws ClassNotFoundException, SQLException
    {
        DBLogic DB = new DBLogic();
        ResultSet RS = DB.getEmpName(ProjID);
        String EmplName = null;
        if(RS.next())
        {
            EmplName= RS.getString(1)+" "+RS.getString(2);   
            // 1 column is for FName & 2nd is for Lname             
        }

        return EmplName;
    }
}
    