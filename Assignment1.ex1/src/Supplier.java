public class Supplier {

    private int supplierId;
    private String companyName;
    private int contractPerson;
    private int phone;
    private String email;

    public Supplier(int supplierId,String companyName, int contractPerson, int phone, String email){
        this.supplierId = supplierId;
        this.companyName = companyName;
        this.contractPerson = contractPerson;
        this.phone = phone;
        this.email = email;
    }

    public int getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public int getContractPerson() {
        return contractPerson;
    }

    public void setContractPerson(int contractPerson) {
        this.contractPerson = contractPerson;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
