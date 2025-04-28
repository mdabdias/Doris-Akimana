class AccessoriesItem extends ShoppingItem {
    protected double rating;
    protected int reviewCount;

    public AccessoriesItem(String itemId, String itemName, String itemDescription, double price, int stockAvailable, double rating, int reviewCount) {
        super(itemId, itemName, itemDescription, price, stockAvailable);
        this.rating = rating;
        this.reviewCount = reviewCount;
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
            System.out.println("Item not available.");
        }
    }

    @Override
    public void generateInvoice(Customer customer) {
        System.out.println("Invoice for: " + customer.getCustomerName());
        System.out.println("Accessory: " + itemName);
        System.out.println("Price: $" + price);
        System.out.printf("Customer Rating: %.1f (%d reviews)\n", rating, reviewCount);
    }

    @Override
    public boolean validateItem() {
        return stockAvailable > 0;
    }
}