import java.time.LocalDate;

public class GroceryItem extends StockItem{

    protected LocalDate expirationDate;
    public GroceryItem(String itemID, String itemName, int quantityInStock, double pricePerUnit, String category, String supplier) {
        super(itemID, itemName, quantityInStock, pricePerUnit, category, supplier);
    }

    @Override
    public void updateStock(int quantity) {

        quantityInStock +=quantity;
    }

    @Override
    public double calculateStockValue() {
        return quantityInStock*pricePerUnit;
    }

    @Override
    public void generateStockReport() {
        System.out.println("Item Name        : " + itemName);
        System.out.println("Category         : " + category);
        System.out.println("Quantity in Stock: " + quantityInStock);
        System.out.printf("Price per Unit   : %.2f\n", pricePerUnit);
        System.out.printf("Stock Value      : %.2f\n", calculateStockValue());
        System.out.println("Expiration Date  : " + expirationDate);
        if (expirationDate.isBefore(LocalDate.now().plusDays(5))) {
            System.out.println("Status           : Nearly Expired - Apply Discount!");
        } else {
            System.out.println("Status           : Fresh");
        }
    }


    @Override
    public boolean validateStock() {
        return quantityInStock>0;
    }
}
