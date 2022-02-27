package assinghment.view;

import java.sql.*;
import assinghment.controller.CURD_EmpData;
import assinghment.controller.getEmpData;

import java.util.Scanner;

public class UserCli {
    
    int EmpID, ProjID;
    String FName, LName, City;
    private int operation;

    Scanner input = new Scanner(System.in);
    CURD_EmpData ce = new CURD_EmpData();
    getEmpData gd = new getEmpData();
 
    // Create employee data
    public void CreateEmpData() 
        throws ClassNotFoundException, SQLException
    {
        System.out.println("Enter EmpID = ");
        EmpID = input.nextInt();
        System.out.println("Enter Emp FName = ");
        FName = input.next();
        System.out.println("Enter Emp LName = ");
        LName = input.next();
        System.out.println("Enter Emp City = ");
        City = input.next();
        System.out.println("Enter Emp ProjID = ");
        ProjID = input.nextInt();

        ce.createEmp(EmpID, FName, LName, City, ProjID);

    }

    //Update Employee Data
    public void UpdateEmpData() 
        throws ClassNotFoundException, SQLException
    {

        System.out.println("Enter EmpID where you want to update  = ");
        EmpID = input.nextInt();
        System.out.println("\nEnter the details to update ");
        System.out.println("Enter Emp FName = ");
        FName = input.next();
        System.out.println("Enter Emp LName = ");
        LName = input.next();
        System.out.println("Enter Emp City = ");
        City = input.next();
        System.out.println("Enter Emp ProjID = ");
        ProjID = input.nextInt();
        System.out.println("\n");

        ce.updateEmp(EmpID, FName, LName, City, ProjID);
    }

    // Read all of the Employee data.
    public void ReadEmpData()
        throws ClassNotFoundException, SQLException {

        System.out.println("To get Specific Emp Data Enter 1 else enter 0 for all emp data");
        int c=input.nextInt();
        if(c==1){
            System.err.println("Enter EmpID to read his/her data :");
            EmpID = input.nextInt();
            ce.readEmp(EmpID);
        }else if (c==0){
            System.out.println("----- Employee Data------");
            ce.readEmp();
            System.out.println("\n-----End of the Data -----\n");
        }        
    }

    // Delete Employee data.
    public void DeleteEmpData()
        throws ClassNotFoundException, SQLException {

        System.out.println("Enter the EmpID to delete his/her data : ");
        EmpID = input.nextInt();
        ce.deleteEmp(EmpID);
    }

    // get ProjID by giving EmpID
    public void GetProjID()
        throws ClassNotFoundException, SQLException
    {
        System.out.println("Enter the EmpID to get the ProjID : ");
        EmpID = input.nextInt();
        ProjID = gd.getprojID(EmpID);
        System.out.println("Employee Project ID : "+ProjID);
    }

    // get City by giving EmpID
    public void GetEmpCity()
        throws ClassNotFoundException, SQLException
    {
        System.out.println("Enter the EmpID to get the City : ");
        EmpID = input.nextInt();
        City = gd.getEmplCity(EmpID);
        System.out.println("Employee City : "+City);
    }

    // get City by giving ProjID
    public void GetEmpName()
        throws ClassNotFoundException, SQLException
    {
        System.out.println("Enter the ProjID to get the Employee Name : ");
        ProjID = input.nextInt();
        String name = gd.getEmplName(ProjID);
        System.out.println("Employee Name : "+name);
    }

    // user interface to do all the operation
    public void interact() 
    throws ClassNotFoundException, SQLException {

        boolean cont = false;
        System.out.println("--------------Welcome to Employee Database----------------\n");
        UserCli op = new UserCli();
        while(cont != true){   

            System.out.println("\n  Operations you can perform :\n\n"+
            "   1 --> Create Employee Data. \n "+
            "  2 --> Update Employee Data. \n "+
            "  3 --> Read Employee Data. \n "+
            "  4 --> Delete Employee Data. \n "+
            "  5 --> Get Employee ProjID by EmpID. \n "+
            "  6 --> Get Employee City by EmpID. \n "+
            "  7 --> Get Employee Name by EmpProj. \n "+
            "---------------------------------------------\n\n"+
            "Enter the given int key to perform the respective Operation");

            operation = input.nextInt();
            
            switch (operation) {
                case 1:
                    op.CreateEmpData();
                    break;
                case 2:
                    op.UpdateEmpData();
                    break;
                case 3:
                    op.ReadEmpData();
                    break;
                case 4:
                    op.DeleteEmpData();
                    break;            
                case 5:
                    GetProjID();
                    break;
                case 6:
                    GetEmpCity();
                    break;
                case 7:
                    GetEmpName();
                    break;
                default:
                    System.out.println("Enter Valid Key to Perform Operation.");;
            }
            
            System.out.println("Do you want to continue : y/n");
            String next = input.next();
            if(next.equalsIgnoreCase("n")){ 
            System.out.println("Thank you for using.\nHope you had a good time.");
                break;
            }     
        }
        
    }

    public static void main(String[] args) 
        throws ClassNotFoundException, SQLException{
        
        UserCli user = new UserCli();
        user.interact();
   }
}
