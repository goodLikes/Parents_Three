package Family_Tree;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Human implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private Gender gender;
    private List<Human> children;

    // Конструктор
    public Human(String name, Gender gender) {
        this.name = name;
        this.gender = gender;
        this.children = new ArrayList<>();
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

    // Метод для добавления ребенка
    public void addChild(Human child) {
        this.children.add(child);
    }

    // Переопределение метода toString
    @Override
    public String toString() {
        return "Human{name='" + name + "', gender=" + gender + '}';
    }
}
