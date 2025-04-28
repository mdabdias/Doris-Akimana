public class ElectronicsItem extends StockItem{

    protected int warrantyPeriod;
    protected double discount;

    public ElectronicsItem(String itemID, String itemName, int quantityInStock, double pricePerUnit, String category, String supplier, int warrantyPeriod) {
        super(itemID, itemName, quantityInStock, pricePerUnit, category, supplier);
        this.warrantyPeriod = warrantyPeriod;
    }

    @Override
    public void updateStock(int quantity) {
            quantityInStock += quantity;
    }

    @Override
    public double calculateStockValue() {
        return quantityInStock * pricePerUnit;
    }

    @Override
    public void generateStockReport() {
        System.out.println("Item Name        : " + itemName);
        System.out.println("Category         : " + category);
        System.out.println("Quantity in Stock: " + quantityInStock);
        System.out.printf("Price per Unit   : %.2f\n", pricePerUnit);
        System.out.printf("Stock Value      : %.2f\n", calculateStockValue());
        System.out.println("Warranty Period  : " + warrantyPeriod + " months");
        System.out.printf("Discount Applied : %.2f%%\n", discount);
    }

    @Override
    public boolean validateStock() {
        return quantityInStock > 0;
    }

    public void applyDiscount(double discount){
        if (discount <= 50) {
            this.discount = discount;
        }
    }

    public int getWarrantyPeriod() {
        return warrantyPeriod;
    }

    public void setWarrantyPeriod(int warrantyPeriod) {
        if (warrantyPeriod <0 || warrantyPeriod >12){
            System.out.println("Warranty period is 12 months only.");
        }
        else{
        this.warrantyPeriod = warrantyPeriod;
        }
    }
}

