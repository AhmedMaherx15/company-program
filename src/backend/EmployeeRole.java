package backend;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class EmployeeRole {

    private ProductDatabase ProductsDatabase = new ProductDatabase("Products.txt");
    private CustomerProductDatabase CustomerProductsDatabase = new CustomerProductDatabase("CustomersProducts.txt");

    public EmployeeRole() {
        ProductsDatabase.readFromFile();
        CustomerProductsDatabase.readFromFile();

    }

    public void addProduct(String productID, String productName, String manufacturerName, String supplierName, int quantity, float price) {
        Product p = new Product(productID, productName, manufacturerName, supplierName, quantity, price);
        ProductsDatabase.insertRecord(p);
    }

    public Product[] getListOfProducts() {
        Product p[] = new Product[ProductsDatabase.returnAllRecords().size()];
        for (int i = 0; i < ProductsDatabase.returnAllRecords().size(); i++) {
            p[i] = (Product) ProductsDatabase.returnAllRecords().get(i);
        }
        return p;
    }

    public CustomerProduct[] getListOfPurchasingOperations() {
        CustomerProduct p[] = new CustomerProduct[CustomerProductsDatabase.returnAllRecords().size()];
        for (int i = 0; i < CustomerProductsDatabase.returnAllRecords().size(); i++) {
            p[i] = (CustomerProduct) CustomerProductsDatabase.returnAllRecords().get(i);
        }
        return p;
    }

    public boolean purchaseProduct(String customerSSN, String productID, LocalDate purchaseDate) {
        Product p = (Product) ProductsDatabase.getRecord(productID);
//        if (p == null) {
//        System.out.println("Product with ID " + productID + " not found.");
//        return false;}
        if (p.getQuantity() == 0) {
            System.out.println("product is out of stock");
            return false;
        } else {
            p.setQuantity(p.getQuantity() - 1);
            CustomerProduct cp = new CustomerProduct(customerSSN, productID, purchaseDate);
            CustomerProductsDatabase.insertRecord(cp);
            System.out.println("product purchased");
            return true;
        }

    }
    public boolean contain(String productID){
        Product p = (Product) ProductsDatabase.getRecord(productID);
        if (p == null) {
        System.out.println("Product with ID " + productID + " not found.");
        return false;}
        else
            return true;
    }
    
    public boolean containc(String customerSSN, String productID, LocalDate purchaseDate, LocalDate returnDate){
        CustomerProduct customerProduct = (CustomerProduct) CustomerProductsDatabase.getRecord(customerSSN + "," + productID + "," + purchaseDate.format(java.time.format.DateTimeFormatter.ofPattern("dd-MM-yyyy")));
        if (customerProduct == null) {
        System.out.println("customer Product with ID " + customerSSN + " not found.");
        return false;}
        else
            return true;
    }
    

    public double returnProduct(String customerSSN, String productID, LocalDate purchaseDate, LocalDate returnDate) {
        Product product = (Product) ProductsDatabase.getRecord(productID);
        CustomerProduct customerProduct = (CustomerProduct) CustomerProductsDatabase.getRecord(customerSSN + "," + productID + "," + purchaseDate.format(java.time.format.DateTimeFormatter.ofPattern("dd-MM-yyyy")));

        if (product != null && customerProduct != null) {

            long daysDifference = ChronoUnit.DAYS.between(purchaseDate, returnDate);
            if (daysDifference < 0 || daysDifference > 14) {
                return -1;
            }

            product.setQuantity(product.getQuantity() + 1);

            CustomerProductsDatabase.deleteRecord(customerProduct.getSearchKey());

            return product.getPrice();
        } else {

            return -1;
        }
    }

    public void logout() {
        ProductsDatabase.saveToFile();
        CustomerProductsDatabase.saveToFile();
    }

}
