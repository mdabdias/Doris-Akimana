import java.time.LocalDate;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== MOTOR vehicles INSURANCE SYSTEM ===");

        
        vehicles car1 = new vehicles("V100", "Toyota", "Corolla", 2018, "Car");
        vehicles suv1 = new vehicles("V200", "Ford", "Explorer", 2020, "SUV");
        vehicles truck1 = new vehicles("V300", "Chevrolet", "Silverado", 2015, "Truck");

     
        Person person1 = new Person("P100", "John Doe", LocalDate.of(1985, 5, 15), "john@example.com", "1234567890");
        Person person2 = new Person("P200", "Jane Smith", LocalDate.of(1990, 8, 22), "jane@example.com", "9876543210");

       
        InsurancePolicy[] policies = {
                new ComprehensivePolicy("POL100", car1, person1, 20000, LocalDate.now(), LocalDate.now().plusYears(1), true),
                new ThirdPartyPolicy("POL200", suv1, person2, 15000, LocalDate.now(), LocalDate.now().plusYears(1), 1.5),
                new CollisionPolicy("POL300", car1, person1, 18000, LocalDate.now(), LocalDate.now().plusYears(1), 15),
                new LiabilityPolicy("POL400", truck1, person2, 25000, LocalDate.now(), LocalDate.now().plusYears(1), true, false),
                new RoadsideAssistancePolicy("POL500", suv1, person1, 5000, LocalDate.now(), LocalDate.now().plusYears(1), false, true)
        };

        // Main menu
        boolean running = true;
        while (running) {
            System.out.println("\n=== MAIN MENU ===");
            System.out.println("1. View All Policies");
            System.out.println("2. Process a Claim");
            System.out.println("3. Generate Policy Report");
            System.out.println("4. Validate a Policy");
            System.out.println("5. Exit");
            System.out.print("Select an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.println("\n=== ALL POLICIES ===");
                    for (InsurancePolicy policy : policies) {
                        System.out.println(policy.getPolicyId() + " - " + policy.getVehicles().getMake() +
                                " " + policy.getVehicles().getModel() +
                                " (" + policy.getPolicyHolder().getName() + ")");
                    }
                    break;

                case 2:
                    System.out.print("Enter policy ID to claim against: ");
                    String policyId = scanner.nextLine();
                    System.out.print("Enter claim amount: ");
                    double claimAmount = scanner.nextDouble();
                    scanner.nextLine(); // consume newline

                    InsurancePolicy selectedPolicy = null;
                    for (InsurancePolicy policy : policies) {
                        if (policy.getPolicyId().equals(policyId)) {
                            selectedPolicy = policy;
                            break;
                        }
                    }

                    if (selectedPolicy != null) {
                        Claim claim = new Claim("CLM" + System.currentTimeMillis(), claimAmount, LocalDate.now());
                        if (claim.processClaim(selectedPolicy)) {
                            System.out.println("Claim " + claim.getClaimId() + " approved!");
                        } else {
                            System.out.println("Claim " + claim.getClaimId() + " rejected.");
                        }
                    } else {
                        System.out.println("Policy not found.");
                    }
                    break;

                case 3:
                    System.out.print("Enter policy ID to generate report: ");
                    String reportPolicyId = scanner.nextLine();

                    for (InsurancePolicy policy : policies) {
                        if (policy.getPolicyId().equals(reportPolicyId)) {
                            policy.generatePolicyReport();
                            break;
                        }
                    }
                    break;

                case 4:
                    System.out.print("Enter policy ID to validate: ");
                    String validatePolicyId = scanner.nextLine();

                    for (InsurancePolicy policy : policies) {
                        if (policy.getPolicyId().equals(validatePolicyId)) {
                            boolean isValid = policy.validatePolicy();
                            System.out.println("Policy " + policyId + " is " + (isValid ? "valid" : "invalid"));
                            break;
                        }
                    }
                    break;

                case 5:
                    running = false;
                    System.out.println("Exiting system. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }
}