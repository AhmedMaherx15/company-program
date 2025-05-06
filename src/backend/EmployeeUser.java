// first class
package backend;


import java.io.FileWriter;
import java.io.IOException;

public class EmployeeUser implements Alldata {
    public String employeeId;
    public String name;
    public String email;
    public String address;
    public String phoneNumber;

    public EmployeeUser(String employeeId, String name, String email, String address, String phoneNumber)  {
        this.employeeId = employeeId;
        this.name = name;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
//      try   (FileWriter fw = new FileWriter("Employees",true)){
//                fw.write(lineRepresentation()+"\n");    }
    }
    

    @Override
    public String lineRepresentation(){
        return employeeId + "," + name + "," + email + "," + address + "," + phoneNumber;
    }
    
    @Override
    public String getSearchKey(){
        return employeeId;
    }

    public String getemployeeId() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public String getName() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public String email() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
