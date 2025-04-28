import java.time.LocalDate;

public class RoadsideAssistancePolicy  extends InsurancePolicy {
    private boolean commercialVehicles;
    protected boolean registrationVerified;

    public RoadsideAssistancePolicy(String policyId, vehicles vehicles, Person policyHolder,double coverageAmount, LocalDate policyStartDate, LocalDate policyEndDate, boolean commercialVehicless, boolean registrationVerified) {
        super(policyId, vehicles, policyHolder, coverageAmount, policyStartDate, policyEndDate);
        this.commercialVehicles = commercialVehicless;
        this.registrationVerified = registrationVerified;
        calculatePremium();
    }

    @Override
    public void calculatePremium() {
        premiumAmount = 50;
        if (commercialVehicles) {
            premiumAmount *= 2; // Double for commercial vehicles
        }
    }

    @Override
    public boolean processClaim(double claimAmount) {
        if (claimAmount <= coverageAmount && registrationVerified) {
            System.out.println("Roadside assistance claim processed for $" + claimAmount);
            return true;
        }
        System.out.println("Claim requires registration verification or exceeds coverage");
        return false;
    }

    @Override
    public void generatePolicyReport() {
        System.out.println("\n=== ROADSIDE ASSISTANCE POLICY REPORT ===");
        System.out.println("Policy ID: " + policyId);
        System.out.println("vehicles: " + vehicles.getMake() + " " + vehicles.getModel());
        System.out.println("Policy Holder: " + policyHolder.getName());
        System.out.printf("Coverage Amount: $%.2f\n", coverageAmount);
        System.out.printf("Premium Amount: $%.2f\n", premiumAmount);
        System.out.println("Covers Commercial vehicles: " + (commercialVehicles ? "Yes" : "No"));
        System.out.println("Registration Verified: " + (registrationVerified ? "Yes" : "No"));
        System.out.println("Policy Period: " + policyStartDate + " to " + policyEndDate);
    }

    @Override
    public boolean validatePolicy() {
        return registrationVerified;
    }
}
