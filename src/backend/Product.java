// fourth class
package backend;

import java.time.LocalDate;

public class Product implements Alldata {
    
    public String productID, productName, manufacturerName, supplierName;
    public int quantity;
    public float price;

    public Product(String productID, String productName, String manufacturerName, String supplierName, int quantity, float price) {
        this.productID = productID;
        this.productName = productName;
        this.manufacturerName = manufacturerName;
        this.supplierName = supplierName;
        this.quantity = quantity;
        this.price = price;
    }

    public float getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    @Override
    public String lineRepresentation(){
        return productID + "," + productName + "," + manufacturerName + "," + supplierName + "," + quantity + "," + price;
    }
    
    @Override
    public String getSearchKey(){
        return productID;
    }
    
}
