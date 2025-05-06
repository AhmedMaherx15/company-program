 // sixth class
package backend;

import java.time.LocalDate;
import java.util.regex.Pattern;

/**
 *
 * @author Ahmed Maher
 */
public class CustomerProduct implements Alldata {
    
    public String customerSSN, productID;
    public LocalDate purchaseDate;

    public CustomerProduct(String customerSSN, String productID, LocalDate purchaseDate) {
        this.customerSSN = customerSSN;
        this.productID = productID;
        this.purchaseDate = purchaseDate;
    }
    
    

    public String getCustomerSSN() {
        return customerSSN;
    }

    public String getProductID() {
        return productID;
    }

    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }
    
    @Override
    public String lineRepresentation(){
        return customerSSN + "," + productID + "," + purchaseDate;
    }
    
    @Override
    public String getSearchKey(){
        return (customerSSN + "," + productID + "," + purchaseDate.format(java.time.format.DateTimeFormatter.ofPattern("dd-MM-yyyy")));
    }
    
}
