import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create sample products
        ElectronicsItem laptop = new ElectronicsItem("E100", "Laptop", "High performance laptop", 999.99, 10, 12);
        ClothingItem shirt = new ClothingItem("C200", "T-Shirt", "Cotton t-shirt", 29.99, 50, Collections.singletonList("S"), 10);
        GroceriesItem apple = new GroceriesItem("G300", "Apple", "Fresh red apples", 0.99, 200, "2023-12-31", true);
        BooksItem novel = new BooksItem("B400", "Novel", "Bestseller novel", 14.99, 30, "123-4567890123", "1st Edition");
        AccessoriesItem watch = new AccessoriesItem("A500", "Watch", "Smart watch", 199.99, 15, 4.5, 120);

        // Customer registration
        System.out.println("=== WELCOME TO OUR ONLINE STORE ===");
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        System.out.print("Enter your email: ");
        String email = scanner.nextLine();
        System.out.print("Enter your address: ");
        String address = scanner.nextLine();
        System.out.print("Enter your phone: ");
        String phone = scanner.nextLine();

        Customer customer = new Customer("CUST-" + System.currentTimeMillis(), name, email, address, phone);

        if (!customer.validateDaketails()) {
            System.out.println("Invalid customer details. Please try again.");
            return;
        }

        // Shopping loop
        boolean shopping = true;
        while (shopping) {
            System.out.println("\n=== AVAILABLE PRODUCTS ===");
            System.out.println("1. Laptop - $999.99");
            System.out.println("2. T-Shirt - $29.99 (10% off)");
            System.out.println("3. Apples - $0.99 each");
            System.out.println("4. Novel - $14.99");
            System.out.println("5. Smart Watch - $199.99");
            System.out.println("6. View Cart");
            System.out.println("7. Checkout");
            System.out.println("8. Exit");
            System.out.print("Select an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    laptop.addToCart(customer);
                    break;
                case 2:
                    shirt.addToCart(customer);
                    break;
                case 3:
                    apple.addToCart(customer);
                    break;
                case 4:
                    novel.addToCart(customer);
                    break;
                case 5:
                    watch.addToCart(customer);
                    break;
                case 6:
                    customer.getCart().generateOrderReport();
                    break;
                case 7:
                    customer.getCart().checkout();
                    shopping = false;
                    break;
                case 8:
                    shopping = false;
                    System.out.println("Thank you for visiting!");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }

        scanner.close();
    }
}