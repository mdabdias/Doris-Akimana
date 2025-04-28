import java.time.LocalDate;

class Claim {
    protected String claimId;
    protected double claimAmount;
    protected LocalDate claimDate;
    protected String claimStatus;

    public Claim(String claimId, double claimAmount, LocalDate claimDate) {
        this.claimId = claimId;
        this.claimAmount = claimAmount;
        this.claimDate = claimDate;
        this.claimStatus = "Pending";
    }

    public boolean processClaim(InsurancePolicy policy) {
        if (policy.processClaim(claimAmount)) {
            claimStatus = "Approved";
            return true;
        }
        claimStatus = "Rejected";
        return false;
    }


    public String getClaimId() { return claimId; }
    public double getClaimAmount() { return claimAmount; }
    public LocalDate getClaimDate() { return claimDate; }
    public String getClaimStatus() { return claimStatus; }
}
