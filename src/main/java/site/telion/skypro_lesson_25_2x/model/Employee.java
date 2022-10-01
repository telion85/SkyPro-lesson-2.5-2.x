package site.telion.skypro_lesson_25_2x.model;

import lombok.Data;

@Data
public class Employee {
    private final String firstName;
    private final String lastName;
    private final String fullName;

    public Employee(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.fullName = firstName + " " + lastName;
    }
}
