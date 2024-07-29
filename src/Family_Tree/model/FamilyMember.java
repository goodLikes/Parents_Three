package Family_Tree.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class FamilyMember implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private Date dateOfBirth;
    private List<FamilyMember> children;

    // Конструктор
    public FamilyMember(String name, Date dateOfBirth) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.children = new ArrayList<>();
    }

    // Геттеры
    public String getName() {
        return name;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public List<FamilyMember> getChildren() {
        return children;
    }

    // Метод для добавления ребенка
    public void addChild(FamilyMember child) {
        this.children.add(child);
    }

    // Переопределение метода toString
    @Override
    public String toString() {
        return getClass().getSimpleName() + "{name='" + name + "', dateOfBirth=" + dateOfBirth + '}';
    }
}
