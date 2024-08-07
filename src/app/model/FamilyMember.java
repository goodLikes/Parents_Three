package app.model;

import java.time.LocalDate;

public class FamilyMember {
    private String name;
    private Gender gender;
    private LocalDate dateOfBirth;
    private String education;
    private String profession;

    public FamilyMember(String name, Gender gender, LocalDate dateOfBirth, String education, String profession) {
        this.name = name;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.education = education;
        this.profession = profession;
    }

    // Геттеры и сеттеры

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    @Override
    public String toString() {
        return "FamilyMember{" +
                "name='" + name + '\'' +
                ", gender=" + gender +
                ", dateOfBirth=" + dateOfBirth +
                ", education='" + education + '\'' +
                ", profession='" + profession + '\'' +
                '}';
    }
}
