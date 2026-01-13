package entity.person;

/**
 * Klasse voor de driver.
 */
public class Driver extends Staff {

    public Driver(String firstName, String lastName, String birthDate, String nationalRegisterNumber) {
        super(firstName, lastName, nationalRegisterNumber, birthDate);
    }
}

