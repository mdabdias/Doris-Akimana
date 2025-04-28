class ElectronicsItem extends ShoppingItem {
    protected int warrantyMonths;
    private boolean isRegistered;

    public ElectronicsItem(String itemId, String itemName, String itemDescription, double price, int stockAvailable, int warrantyMonths) {
        super(itemId, itemName, itemDescription, price, stockAvailable);
        this.warrantyMonths = warrantyMonths;
        this.isRegistered = false;
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
        System.out.println("Electronic Item: " + itemName);
        System.out.println("Description: " + itemDescription);
        System.out.println("Price: $" + price);
        System.out.println("Warranty: " + warrantyMonths + " months");
    }

    @Override
    public boolean validateItem() {
        return stockAvailable > 0;
    }

    public void registerProduct() {
        isRegistered = true;
        System.out.println("Product registered for warranty.");
    }
}