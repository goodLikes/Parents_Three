package Family_Tree.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import Family_Tree.util.DateOfBirthComparator;
import Family_Tree.util.NameComparator;

public class FamilyTree implements Serializable, Iterable<Human> {
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

    // Метод для сортировки по имени
    public void sortByName() {
        Collections.sort(members, new NameComparator());
    }

    // Метод для сортировки по дате рождения
    public void sortByDateOfBirth() {
        Collections.sort(members, new DateOfBirthComparator());
    }

    // Реализация интерфейса Iterable
    @Override
    public Iterator<Human> iterator() {
        return members.iterator();
    }

    // Геттер для членов семьи
    public List<Human> getMembers() {
        return members;
    }
}
