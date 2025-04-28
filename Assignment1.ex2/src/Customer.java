class Customer {
    protected String customerId;
    protected String customerName;
    protected String email;
    protected String address;
    protected String phone;
    protected ShoppingCart cart;

    public Customer(String customerId, String customerName, String email, String address, String phone) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.cart = new ShoppingCart(this);
    }

    public boolean validateDetails() {
        return !customerName.isEmpty() && email.contains("@") && !address.isEmpty() && phone.length() >= 10;
    }

    public ShoppingCart getCart() {
        return cart;
    }

    // Getters and setters
    public String getCustomerId() { return customerId; }
    public String getCustomerName() { return customerName; }
    public String getEmail() { return email; }
    public String getAddress() { return address; }
    public String getPhone() { return phone; }
}
