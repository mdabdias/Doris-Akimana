import java.time.LocalDate;

public class ThirdPartyPolicy extends InsurancePolicy {
    protected double engCapacity;

    public ThirdPartyPolicy(String policyId, vehicles vehicles, Person policyHolder,
                            double coverageAmount, LocalDate policyStartDate, LocalDate policyEndDate,
                            double engCapacity) {
        super(policyId, vehicles, policyHolder, coverageAmount, policyStartDate, policyEndDate);
        this.engCapacity = engCapacity;
        calculatePremium();
    }

    @Override
    public void calculatePremium() {
        // Premium based on engine capacity
        // 3% adjusted by engine factor
        premiumAmount = coverageAmount * 0.03 * engCapacity; 
    }

    @Override
    public boolean processClaim(double claimAmount) {
        if (claimAmount <= coverageAmount) {
            System.out.println("Third party claim processed for Rwf" + claimAmount);
            return true;
        }
        System.out.println("Claim amount exceeds coverage");
        return false;
    }

    @Override
    public void generatePolicyReport() {
        System.out.println("\n=== THIRD PARTY POLICY REPORT ===");
        System.out.println("Policy ID: " + policyId);
        System.out.println("vehicles: " + vehicles.getMake() + " " + vehicles.getModel());
        System.out.println("Policy Holder: " + policyHolder.getName());
        System.out.printf("Coverage Amount: Rwf%.2f\n", coverageAmount);
        System.out.printf("Premium Amount: Rwf%.2f\n", premiumAmount);
        System.out.println("Engine Capacity Factor: " + engCapacity);
        System.out.println("Policy Period: " + policyStartDate + " to " + policyEndDate);
    }

    @Override
    public boolean validatePolicy() {
        return engCapacity > 0 && coverageAmount > 0;
    }
}
