package entity.person;
import java.time.LocalDate;
public abstract class person {
    private String firstName;
    private String lastName;
    private String birthdate;
    private String nationalRegisterNumber;

public person(String firstName, String lastName, String birthdate, String nationalRegisterNumber) {
    this.firstName = firstName;
    this.lastName =  lastName;
    this.birthdate = birthdate;
    this.nationalRegisterNumber = nationalRegisterNumber;
}

}
