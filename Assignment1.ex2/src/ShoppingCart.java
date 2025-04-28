import java.util.ArrayList;
import java.util.List;

class ShoppingCart {
    protected String cartId;
    protected List<ShoppingItem> items;
    protected double totalPrice;
    protected Customer customer;

    public ShoppingCart(Customer customer) {
        this.cartId = "CART-" + System.currentTimeMillis();
        this.items = new ArrayList<>();
        this.customer = customer;
    }

    public void addItem(ShoppingItem item) {
        if (item.getStockAvailable() > 0) {
            items.add(item);
            totalPrice += item.getPrice();
            item.updateStock(-1); // Reduce stock by 1
        } else {
            System.out.println("Item out of stock.");
        }
    }

    public void removeItem(ShoppingItem item) {
        if (items.remove(item)) {
            totalPrice -= item.getPrice();
            item.updateStock(1); // Increase stock by 1
        }
    }

    public void checkout() {
        System.out.println("\n=== CHECKOUT ===");
        System.out.println("Items in cart: " + items.size());

        // Add these lines to generate invoice for each item
        System.out.println("\n=== ITEM INVOICES ===");
        for (ShoppingItem item : items) {
            item.generateInvoice(customer);
            System.out.println("-------------------");
        }

        System.out.printf("\nTotal Price: $%.2f\n", totalPrice);

        if (customer.validateDetails()) {
            Payment payment = new Payment("PAY-" + System.currentTimeMillis(), "Credit Card", totalPrice);
            if (payment.processPayment()) {
                System.out.println("Order placed successfully!");
                generateOrderReport();
            }
        } else {
            System.out.println("Please complete your customer details.");
        }
    }

    public void generateOrderReport() {
        System.out.println("\n=== ORDER REPORT ===");
        System.out.println("Customer: " + customer.getCustomerName());
        System.out.println("Items purchased:");
        for (ShoppingItem item : items) {
            System.out.println("- " + item.getItemName() + ": $" + item.getPrice());
        }
        System.out.printf("Total: $%.2f\n", totalPrice);
    }

    // Getters
    public String getCartId() { return cartId; }
    public double getTotalPrice() { return totalPrice; }
    public List<ShoppingItem> getItems() { return items; }
}