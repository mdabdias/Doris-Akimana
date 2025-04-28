public class FurnitureItem extends StockItem{

    protected float weight;
    protected boolean isPacked;
    public FurnitureItem(String itemID, String itemName, int quantityInStock, double pricePerUnit, String category, String supplier, float weight,boolean isPacked) {
        super(itemID, itemName, quantityInStock, pricePerUnit, category, supplier);
        this.weight = weight;
        this.isPacked = isPacked;
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
        System.out.printf("Weight           : %.2f kg\n", weight);
        System.out.println("Packed           : " + (isPacked ? "Yes" : "No"));
    }

    @Override
    public boolean validateStock() {

        return quantityInStock>0 && isPacked;
    }
}
