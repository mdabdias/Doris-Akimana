import java.util.List;

class ClothingItem extends ShoppingItem {
    protected List<String> sizes;
    protected double discount;

    public ClothingItem(String itemId, String itemName, String itemDescription, double price, int stockAvailable, List<String> sizes, double discount) {
        super(itemId, itemName, itemDescription, price, stockAvailable);
        this.sizes = sizes;
        this.discount = Math.min(discount, 30); // Max 30% discount
    }

    @Override
    public void updateStock(int quantity) {
        stockAvailable += quantity;
    }

    @Override
    public void addToCart(Customer customer) {
        if (validateItem()) {
            customer.getCart().addItem(this);
            System.out.println(itemName + " added to cart.");
        } else {
            System.out.println("Item not available in selected size.");
        }
    }

    @Override
    public void generateInvoice(Customer customer) {
        double finalPrice = price * (1 - discount/100);
        System.out.println("Invoice for: " + customer.getCustomerName());
        System.out.println("Clothing Item: " + itemName);
        System.out.println("Available Sizes: " + String.join(", ", sizes));
        System.out.printf("Original Price: $%.2f\n", price);
        System.out.printf("Discount: %.2f%%\n", discount);
        System.out.printf("Final Price: $%.2f\n", finalPrice);
    }

    @Override
    public boolean validateItem() {
        return stockAvailable > 0;
    }
}