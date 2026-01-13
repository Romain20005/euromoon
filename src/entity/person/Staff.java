package entity.person;
import java.util.ArrayList;
import java.util.List;
/**
 * Een class voor staff members.
 */
public abstract class Staff extends Person {
    private List<String> certifications = new ArrayList<>();
    public Staff(String firstName, String lastName, String birthDate, String nationalRegisterNumber) {
        super(firstName, lastName, birthDate, nationalRegisterNumber);
    }
    public void addCertification(String certification) {
        certifications.add(certification);
    }
    public List<String> getCertifications(){
        return certifications;
    }
}
