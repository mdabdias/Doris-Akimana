class GroceriesItem extends ShoppingItem {
    protected String expirationDate;
    protected boolean isBulk;

    public GroceriesItem(String itemId, String itemName, String itemDescription, double price, int stockAvailable, String expirationDate, boolean isBulk) {
        super(itemId, itemName, itemDescription, price, stockAvailable);
        this.expirationDate = expirationDate;
        this.isBulk = isBulk;
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
            System.out.println("Item expired or not available.");
        }
    }

    @Override
    public void generateInvoice(Customer customer) {
        System.out.println("Invoice for: " + customer.getCustomerName());
        System.out.println("Grocery Item: " + itemName);
        System.out.println("Price: $" + price);
        System.out.println("Expiration Date: " + expirationDate);
        if (isBulk) {
            System.out.println("(Bulk purchase discount applied)");
        }
    }

    @Override
    public boolean validateItem() {
        // Simple validation - in real app would compare with current date
        return stockAvailable > 0 && !expirationDate.equals("expired");
    }
}