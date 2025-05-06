
package backend;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public abstract class Database {
    private ArrayList<Alldata> records = new ArrayList<Alldata>();
    private String filename;

    public Database(String filename) {
        this.filename = filename;
    }
    
    
    public void readFromFile(){
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                records.add(createRecordFrom(line));
            }
        } catch (IOException e) {
        }
    }
    
    public abstract Alldata createRecordFrom(String line);
    
    public  ArrayList<Alldata> returnAllRecords(){
        return  records;
    }
    
    public boolean contains(String key ){
        boolean flag = false;
        for(int i=0;i<records.size();i++){
            if(records.get(i).getSearchKey().equals(key))
                flag = true;   
        }
        return flag;
    }
    
    
     public Alldata getRecord(String key){
        for(int i=0;i<records.size();i++){
            if(records.get(i).getSearchKey().equals(key))
                return records.get(i);
        }
         System.out.println("record not found");
        return null;
    }    
    public void insertRecord(Alldata record){
        records.add(record);
        System.out.println("record of ID "+record.getSearchKey()+" added");
    }
    
    public void deleteRecord(String key){
        int flag =0;
        for(int i=0;i<records.size();i++){
            if(records.get(i).getSearchKey().equals(key)){
                records.remove(i);
                System.out.println("recordof ID "+key+ " deleted");
                flag=1;
                break;
            }}
            if(flag==0)
                System.out.println("record not found");
        
    }
    
    public void saveToFile() {
        try (BufferedWriter br = new BufferedWriter(new FileWriter(filename))) {
        for(int i=0;i<records.size();i++){
            br.write(records.get(i).lineRepresentation());
            br.newLine();
        }
        br.close();
        }catch (IOException e) {
        }
        
    }
        
        

    
    
    
}
