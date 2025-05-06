// third class
package backend;

import java.util.ArrayList;

public class AdminRole {
    private EmployeeUserDatabase database = new EmployeeUserDatabase("Employee.txt");

    public AdminRole(){
        database.readFromFile();
    }
    
    public void addEmployee(String employeeId, String name, String email, String address, String phoneNumber){
        EmployeeUser e = new EmployeeUser(employeeId, name, email, address, phoneNumber);
        database.insertRecord(e);
    }
    
    public EmployeeUser[] getListOfEmployees(){
        ArrayList<Alldata> data = database.returnAllRecords();
        return data.toArray(new EmployeeUser[data.size()]);
    }

    public void removeEmployee(String key){
        database.deleteRecord(key);
    }
    
    public void logout(){
        database.saveToFile();
    }
    
}
