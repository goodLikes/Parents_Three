package Family_Tree;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Human implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private Gender gender;
    private List<Human> children;
    private List<Human> parents;

    // Конструктор
    public Human(String name, Gender gender) {
        this.name = name;
        this.gender = gender;
        this.children = new ArrayList<>();
        this.parents = new ArrayList<>();
    }

    // Геттеры
    public String getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }

    public List<Human> getChildren() {
        return children;
    }

    public List<Human> getParents() {
        return parents;
    }

    // Метод для добавления ребенка
    public void addChild(Human child) {
        this.children.add(child);
        child.addParent(this);
    }

    // Метод для добавления родителя
    public void addParent(Human parent) {
        this.parents.add(parent);
    }

    // Переопределение метода toString
    @Override
    public String toString() {
        return "Human{name='" + name + "', gender=" + gender + '}';
    }
}
