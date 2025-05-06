// seventh class
package backend;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class CustomerProductDatabase extends Database{
 
    public CustomerProductDatabase(String filename) {
        super(filename);
    }




    
    
//    public void readFromFile() throws IOException{
//        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
//            String line;
//            while ((line = br.readLine()) != null) {
//                records.add(createRecordFrom(line));
//            }
//        } catch (IOException e) {
//        }
//    }
    
    @Override
    public CustomerProduct createRecordFrom(String line){
        String []data=line.split(",");
        return new CustomerProduct(data[0],data[1],LocalDate.parse(data[2]));
    }
    
//    public ArrayList<CustomerProduct> returnAllRecords(){
//        return records;
//    }
//    public boolean contains(String key ){
//        boolean flag = false;
//        for(int i=0;i<records.size();i++){
//            if(records.get(i).getSearchKey().equals(key))
//                flag = true;   
//        }
//        return flag;
//    }
//    

//    
//    public void insertRecord(CustomerProduct record){
//        records.add(record);
//        System.out.println("record of ID "+record.getSearchKey()+" added");
//    }
//    
//    public void deleteRecord(String key){
//        for(int i=0;i<records.size();i++){
//            if(records.get(i).getSearchKey().equals(key)){
//                records.remove(i);
//                System.out.println("recordof ID "+key+ " deleted");
//                break;
//            }
//            else
//                System.out.println("record not found");
//        
//    }}
//    
//    public void saveToFile() throws IOException {
//        try (BufferedWriter br = new BufferedWriter(new FileWriter(filename))) {
//        for(int i=0;i<records.size();i++){
//            br.write(records.get(i).lineRepresentation());
//            br.newLine();
//        }
//        br.close();
//        }catch (IOException e) {
//        }
//        
//    }
}
