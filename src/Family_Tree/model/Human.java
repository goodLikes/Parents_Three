package Family_Tree.model;

import java.util.Date;

public class Human extends FamilyMember {
    private Gender gender;

    // Конструктор
    public Human(String name, Gender gender, Date dateOfBirth) {
        super(name, dateOfBirth);
        this.gender = gender;
    }

    // Геттер для пола
    public Gender getGender() {
        return gender;
    }

    // Переопределение метода toString
    @Override
    public String toString() {
        return "Human{name='" + getName() + "', gender=" + gender + "', dateOfBirth=" + getDateOfBirth() + '}';
    }
}
