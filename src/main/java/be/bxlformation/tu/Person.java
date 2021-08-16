package be.bxlformation.tu;

import lombok.Data;

@Data
public class Person {

    private String lastName;
    private String firstName;

    public Person(String lastName, String firstName) {
        this.lastName = lastName;
        this.firstName = firstName;
    }

    public Person() {
    }
}
