import java.time.LocalDate;

public class vehicles {
    
    protected String vId;
    protected String Make;
    protected String model;
    protected int year;
    protected String type;

    public vehicles(String vId, String Make, String model,
                   int year, String type) {
        this.vId = vId;
        this.Make = Make;
        this.model = model;
        this.year = year;
        this.type = type;
    }

    public boolean validateVehicles() {
        return year >= 1900 && year <= LocalDate.now().getYear() + 1 &&
                !Make.isEmpty() && !model.isEmpty();
    }

    public String getVId() {
        return vId;
    }

    public String getMake() {
        return Make;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public String getType() {
        return type;
    }
}


