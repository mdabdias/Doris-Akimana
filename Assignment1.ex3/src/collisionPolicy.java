import java.time.LocalDate;

class CollisionPolicy extends InsurancePolicy {
    protected double discount;

    public CollisionPolicy(String policyId, vehicles vehicles, Person policyHolder,
                           double coverageAmount, LocalDate policyStartDate, LocalDate policyEndDate,
                           double discount) {
        super(policyId, vehicles, policyHolder, coverageAmount, policyStartDate, policyEndDate);
        this.discount = Math.min(discount, 30);
        calculatePremium();
    }

    @Override
    public void calculatePremium() {
        premiumAmount = coverageAmount * 0.04;
        premiumAmount *= (1 - discount/100);
    }

    @Override
    public boolean processClaim(double claimAmount) {
        if (claimAmount <= coverageAmount) {
            System.out.println("Collision claim processed for Rwf" + claimAmount);
            return true;
        }
        System.out.println("Claim amount exceeds coverage");
        return false;
    }

    @Override
    public void generatePolicyReport() {
        System.out.println("\n=== COLLISION POLICY REPORT ===");
        System.out.println("Policy ID: " + policyId);
        System.out.println("vehicles: " + vehicles.getMake() + " " + vehicles.getModel());
        System.out.println("Policy Holder: " + policyHolder.getName());
        System.out.printf("Coverage Amount: Rwf%.2f\n", coverageAmount);
        System.out.printf("Premium Amount: Rwf%.2f\n", premiumAmount);
        System.out.printf("Safe Driver Discount: %.1f%%\n", discount);
        System.out.println("Policy Period: " + policyStartDate + " to " + policyEndDate);
    }

    @Override
    public boolean validatePolicy() {
        return vehicles.getType().equals("Car") || vehicles.getType().equals("SUV");
    }
}
