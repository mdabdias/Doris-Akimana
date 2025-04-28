import java.time.LocalDate;

public class Person {
    protected String personId;
    protected String name;
    protected LocalDate dob;
    protected String email;
    protected String phone;

    public Person(String personId, String name, LocalDate dob, String email, String phone) {
        this.personId = personId;
        this.name = name;
        this.dob = dob;
        this.email = email;
        this.phone = phone;
    }

    public boolean validateDetails() {
        return !name.isEmpty() && email.contains("@") && phone.length() >= 10;
    }

    public int getAge() {
        return LocalDate.now().getYear() - dob.getYear();
    }


    public String getPersonId() {
        return personId;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDob() {
        return dob;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }
}
