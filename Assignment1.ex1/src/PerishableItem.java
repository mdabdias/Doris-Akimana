import java.time.LocalDate;

public class PerishableItem extends StockItem{

    protected LocalDate expirationDate;

    public PerishableItem(String itemID, String itemName, int quantityInStock, double pricePerUnit, String category, String supplier) {
        super(itemID, itemName, quantityInStock, pricePerUnit, category, supplier);
    }

    @Override
    public void updateStock(int quantity) {

        quantityInStock+=quantity;
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
        if (expirationDate.isBefore(LocalDate.now())) {
            System.out.println("Status           : Expired - Dispose Immediately!");
        } else if (expirationDate.isBefore(LocalDate.now().plusDays(3))) {
            System.out.println("Status           : Nearly Expired - Discount Recommended");
        } else {
            System.out.println("Status           : Good");
        }
    }


    @Override
    public boolean validateStock() {
        return expirationDate.isAfter(LocalDate.now());
    }
}
