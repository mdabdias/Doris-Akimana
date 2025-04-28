class Payment {
    protected String paymentId;
    protected String paymentMethod;
    protected double amountPaid;
    protected String transactionDate;

    public Payment(String paymentId, String paymentMethod, double amountPaid) {
        this.paymentId = paymentId;
        this.paymentMethod = paymentMethod;
        this.amountPaid = amountPaid;
        this.transactionDate = java.time.LocalDate.now().toString();
    }

    public boolean processPayment() {
        if (validatePaymentMethod()) {
            System.out.println("Processing " + paymentMethod + " payment of $" + amountPaid);
            return true;
        }
        return false;
    }

    private boolean validatePaymentMethod() {
        return paymentMethod.equals("Credit Card") || paymentMethod.equals("PayPal") || paymentMethod.equals("Debit Card");
    }

    // Getters
    public String getPaymentId() { return paymentId; }
    public String getPaymentMethod() { return paymentMethod; }
    public double getAmountPaid() { return amountPaid; }
    public String getTransactionDate() { return transactionDate; }
}
