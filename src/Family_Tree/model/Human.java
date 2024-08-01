package Family_Tree.model;

import java.io.Serializable;

public class Human implements Serializable {
    private String name;
    private Gender gender;
    private String dateOfBirth;

    public Human(String name, Gender gender, String dateOfBirth) {
        this.name = name;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
    }

    public String getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Gender: " + gender + ", Date of Birth: " + dateOfBirth;
    }
}
