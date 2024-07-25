package Family_Tree;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FamilyTree implements Serializable {
    private static final long serialVersionUID = 1L;
    private List<Human> members;

    // Конструктор
    public FamilyTree() {
        this.members = new ArrayList<>();
    }

    // Метод для добавления члена семьи
    public void addMember(Human human) {
        this.members.add(human);
    }

    // Метод для получения детей данного человека
    public List<Human> getChildren(Human parent) {
        return parent.getChildren();
    }

    // Метод для поиска члена семьи по имени
    public Human findMemberByName(String name) {
        for (Human member : members) {
            if (member.getName().equals(name)) {
                return member;
            }
        }
        return null; // Член не найден
    }

    // Геттер для членов семьи
    public List<Human> getMembers() {
        return members;
    }
}
