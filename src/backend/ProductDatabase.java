// fifth class
package backend;

import java.util.ArrayList;

public class ProductDatabase extends Database{
    public ProductDatabase(String filename) {
        super(filename);
       // readFromFile();
    }
    
    public Product createRecordFrom(String line){
        String []data=line.split(",");
        return new Product(data[0],data[1],data[2],data[3],Integer.parseInt(data[4]),Float.parseFloat(data[5])); 
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
    
    
//    public ArrayList<Product> returnAllRecords(){
//        return records;
//    }
//    
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
//     public void insertRecord(Product record){
//        records.add(record);
//        System.out.println("record of ID "+record.getSearchKey()+" added");
//    }
//     
//     public void deleteRecord(String key){
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
//     public void saveToFile() throws IOException {
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
