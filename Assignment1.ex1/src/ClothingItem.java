import java.util.List;

public class ClothingItem extends StockItem{
    protected List<String> sizes;
    protected List<String> colors;
    protected double discount;


    public ClothingItem(String itemID, String itemName, int quantityInStock, double pricePerUnit, String category, String supplier,List<String> sizes, List<String> colors, double discount) {
        super(itemID, itemName, quantityInStock, pricePerUnit, category, supplier);
        this.sizes = sizes;
        this.colors = colors;
        this.discount = Math.min(discount, 50);
    }

    @Override
    public void updateStock(int quantity) {
        quantityInStock +=quantity;

    }

    @Override
    public double calculateStockValue() {
        double lastPrice = pricePerUnit -(pricePerUnit *discount/100);
        return quantityInStock * lastPrice;
    }

    @Override
    public void generateStockReport() {
        System.out.println("Item Name        : " + itemName);
        System.out.println("Category         : " + category);
        System.out.println("Quantity in Stock: " + quantityInStock);
        System.out.printf("Price per Unit   : %.2f\n", pricePerUnit);
        System.out.printf("Stock Value      : %.2f\n", calculateStockValue());
        System.out.println("Sizes Available  : " + String.join(", ", sizes));
        System.out.println("Colors Available : " + String.join(", ", colors));
        System.out.printf("Discount Applied : %.2f%%\n", discount);
    }


    @Override
    public boolean validateStock() {
        return quantityInStock > 0;
    }


}
