import java.time.LocalDate;

public class LiabilityPolicy extends InsurancePolicy {
    protected boolean medicalCheckupDone;
    protected boolean extendedCoverage;

    public LiabilityPolicy(String policyId, vehicles vehicles, Person policyHolder,
                           double coverageAmount, LocalDate policyStartDate, LocalDate policyEndDate,
                           boolean medicalCheckupDone, boolean extendedCoverage) {
        super(policyId, vehicles, policyHolder, coverageAmount, policyStartDate, policyEndDate);
        this.medicalCheckupDone = medicalCheckupDone;
        this.extendedCoverage = extendedCoverage;
        calculatePremium();
    }

    @Override
    public void calculatePremium() {
        premiumAmount = coverageAmount * 0.025; // Base 2.5% of coverage
        if (extendedCoverage) {
            premiumAmount *= 1.5; // 50% more for extended coverage
        }
    }

    @Override
    public boolean processClaim(double claimAmount) {
        if (claimAmount <= coverageAmount && medicalCheckupDone) {
            System.out.println("Liability claim processed for $" + claimAmount);
            return true;
        }
        System.out.println("Claim requires medical checkup or exceeds coverage");
        return false;
    }

    @Override
    public void generatePolicyReport() {
        System.out.println("\n=== LIABILITY POLICY REPORT ===");
        System.out.println("Policy ID: " + policyId);
        System.out.println("vehicles: " + vehicles.getMake() + " " + vehicles.getModel());
        System.out.println("Policy Holder: " + policyHolder.getName());
        System.out.printf("Coverage Amount: $%.2f\n", coverageAmount);
        System.out.printf("Premium Amount: $%.2f\n", premiumAmount);
        System.out.println("Medical Checkup Done: " + (medicalCheckupDone ? "Yes" : "No"));
        System.out.println("Extended Coverage: " + (extendedCoverage ? "Yes" : "No"));
        System.out.println("Policy Period: " + policyStartDate + " to " + policyEndDate);
    }

    @Override
    public boolean validatePolicy() {
        return medicalCheckupDone && policyHolder.getAge() >= 18;
    }
}
