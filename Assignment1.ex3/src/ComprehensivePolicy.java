import java.time.LocalDate;

public class ComprehensivePolicy extends InsurancePolicy{
    protected boolean coverage;

    public ComprehensivePolicy(String policyId, vehicles vehicles, Person policyHolder, double coverageAmount, LocalDate policyStartDate, LocalDate policyEndDate, boolean coverage) {
        
        super(policyId, vehicles, policyHolder, coverageAmount, policyStartDate, policyEndDate);
        this.coverage = coverage;
        calculatePremium();
    }

    @Override
    public void calculatePremium() {
        
        int vehiclesAge = LocalDate.now().getYear() - vehicles.getYear();
        premiumAmount = coverageAmount * 0.05; // Coverage of 5%
        premiumAmount += vehiclesAge * 10; // Older vehicles cost more
        if (coverage) {
            premiumAmount *= 1.2; // 20% more for theft coverage
        }
    }

    @Override
    public boolean processClaim(double claimAmount) {
        if (claimAmount <= coverageAmount) {
            System.out.println("Comprehensive claim processed for Rwf" + claimAmount);
            return true;
        }
        System.out.println("Claim amount exceeds coverage");
        return false;
    }

    @Override
    public void generatePolicyReport() {
        System.out.println("\n=== COMPREHENSIVE POLICY REPORT ===");
        System.out.println("Policy ID: " + policyId);
        System.out.println("vehicles: " + vehicles.getMake() + " " + vehicles.getModel());
        System.out.println("Policy Holder: " + policyHolder.getName());
        System.out.printf("Coverage Amount: Rwf%.2f\n", coverageAmount);
        System.out.printf("Premium Amount: Rwf%.2f\n", premiumAmount);
        System.out.println("Includes Theft Coverage: " + (coverage ? "Yes" : "No"));
        System.out.println("Policy Period: " + policyStartDate + " to " + policyEndDate);
    }

    @Override
    public boolean validatePolicy() {
        return vehicles.getYear() >= 2000 && coverageAmount > 0;
    }
}


