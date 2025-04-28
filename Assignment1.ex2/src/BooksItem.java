class BooksItem extends ShoppingItem {
    protected String isbn;
    protected String edition;

    public BooksItem(String itemId, String itemName, String itemDescription, double price, int stockAvailable, String isbn, String edition) {
        super(itemId, itemName, itemDescription, price, stockAvailable);
        this.isbn = isbn;
        this.edition = edition;
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
            System.out.println("Item not available in selected edition.");
        }
    }

    @Override
    public void generateInvoice(Customer customer) {
        System.out.println("Invoice for: " + customer.getCustomerName());
        System.out.println("Book: " + itemName);
        System.out.println("Edition: " + edition);
        System.out.println("ISBN: " + isbn);
        System.out.println("Price: $" + price);
    }

    @Override
    public boolean validateItem() {
        return stockAvailable > 0;
    }
}