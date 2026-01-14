package entity.person;

/**
 * Dit is is een abstarcte klasse om een persoon te representeren in mijn systeem
 */
public abstract class Person {
    private String firstName;
    private String lastName;
    private String birthDate;
    private String nationalRegisterNumber;

public Person(String firstName, String lastName, String birthdate, String nationalRegisterNumber) {
    this.firstName = firstName;
    this.lastName =  lastName;

    this.birthDate = birthdate;
    this.nationalRegisterNumber = nationalRegisterNumber;
}
public String getFirstName(){
    return firstName;
}
public String getLastName() {
    return lastName;
}
}
