import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("\n========== ADVANCED STOCK MANAGEMENT SYSTEM ==========\n");

        System.out.print("Enter item type (Electronics / Clothing / Grocery / Furniture / Perishable): ");
        String itemType = input.nextLine().trim().toLowerCase();

        System.out.print("Enter Item ID: ");
        String itemID = input.nextLine();

        System.out.print("Enter Item Name: ");
        String itemName = input.nextLine();

        System.out.print("Enter Quantity in Stock: ");
        int quantityInStock = input.nextInt();

        System.out.print("Enter Price Per Unit: ");
        double pricePerUnit = input.nextDouble();

        input.nextLine();  // Clear buffer

        System.out.print("Enter Category: ");
        String category = input.nextLine();

        System.out.print("Enter Supplier: ");
        String supplier = input.nextLine();

        StockItem item = null;

        switch (itemType) {
            case "electronics":
                System.out.print("Enter Warranty Period (in months): ");
                int warranty = input.nextInt();
                input.nextLine(); // Clear buffer
                item = new ElectronicsItem(itemID, itemName, quantityInStock, pricePerUnit, category, supplier, warranty);

                System.out.print("Apply discount? (yes/no): ");
                String apply = input.nextLine();
                if (apply.equalsIgnoreCase("yes")) {
                    System.out.print("Enter discount percentage: ");
                    double discount = input.nextDouble();
                    ((ElectronicsItem) item).applyDiscount(discount);
                    input.nextLine(); // Clear buffer
                }
                break;

            case "clothing":
                input.nextLine(); // consume newline
                System.out.print("Enter sizes (comma-separated, e.g. S,M,L): ");
                String sizeInput = input.nextLine();
                List<String> sizes = Arrays.asList(sizeInput.split(","));

                System.out.print("Enter colors (comma-separated): ");
                String colorInput = input.nextLine();
                List<String> colors = Arrays.asList(colorInput.split(","));

                System.out.print("Enter discount percentage: ");
                double discount = input.nextDouble();
                input.nextLine(); // Clear buffer
                item = new ClothingItem(itemID, itemName, quantityInStock, pricePerUnit, category, supplier, sizes, colors, discount);
                break;

            case "grocery":
                item = new GroceryItem(itemID, itemName, quantityInStock, pricePerUnit, category, supplier);
                input.nextLine(); // Clear buffer
                System.out.print("Enter expiration date (YYYY-MM-DD): ");
                String expiryGrocery = input.nextLine();
                ((GroceryItem) item).expirationDate = LocalDate.parse(expiryGrocery);
                break;

            case "furniture":
                System.out.print("Enter weight of item (in kg): ");
                float weight = input.nextFloat();
                input.nextLine(); // Clear buffer
                System.out.print("Is item packed? (true/false): ");
                boolean isPacked = input.nextBoolean();
                input.nextLine(); // Clear buffer
                item = new FurnitureItem(itemID, itemName, quantityInStock, pricePerUnit, category, supplier, weight, isPacked);
                break;

            case "perishable":
                item = new PerishableItem(itemID, itemName, quantityInStock, pricePerUnit, category, supplier);
                input.nextLine(); // Clear buffer
                System.out.print("Enter expiration date (YYYY-MM-DD): ");
                String expiryPerishable = input.nextLine();
                ((PerishableItem) item).expirationDate = LocalDate.parse(expiryPerishable);
                break;

            default:
                System.out.println("Invalid item type.");
                System.exit(0);
        }

        // Update stock manually
        System.out.print("Enter stock to add: ");
        int stockToAdd = input.nextInt();
        input.nextLine(); // Clear buffer
        item.updateStock(stockToAdd);

        // Display the Report
        System.out.println("\n========== ITEM STOCK REPORT ==========");
        item.generateStockReport();

        System.out.println("---------------------------------------");
        System.out.println("Validation       : " + (item.validateStock() ? "✅ Stock is valid." : " Stock is invalid or needs attention."));
        System.out.printf("Stock Value (RWF): %.2f\n", item.calculateStockValue());
        System.out.println("=======================================\n");

        input.close();
    }
}
