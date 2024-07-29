package Family_Tree.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import Family_Tree.util.DateOfBirthComparator;
import Family_Tree.util.NameComparator;

public class FamilyTree<T extends FamilyMember> implements Serializable, Iterable<T> {
    private static final long serialVersionUID = 1L;
    private List<T> members;

    // Конструктор
    public FamilyTree() {
        this.members = new ArrayList<>();
    }

    // Метод для добавления члена семьи
    public void addMember(T member) {
        this.members.add(member);
    }

    // Метод для получения детей данного человека
    @SuppressWarnings("unchecked")
    public List<T> getChildren(T parent) {
        return (List<T>) parent.getChildren();
    }

    // Метод для поиска члена семьи по имени
    public T findMemberByName(String name) {
        for (T member : members) {
            if (member.getName().equals(name)) {
                return member;
            }
        }
        return null; // Член не найден
    }

    // Метод для сортировки по имени
    public void sortByName() {
        Collections.sort(members, new NameComparator<>());
    }

    // Метод для сортировки по дате рождения
    public void sortByDateOfBirth() {
        Collections.sort(members, new DateOfBirthComparator<>());
    }

    // Реализация интерфейса Iterable
    @Override
    public Iterator<T> iterator() {
        return members.iterator();
    }

    // Геттер для членов семьи
    public List<T> getMembers() {
        return members;
    }
}
