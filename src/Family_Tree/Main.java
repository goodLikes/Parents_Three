package Family_Tree;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        FamilyTree familyTree = new FamilyTree();

        // Создание людей
        Human father = new Human("Иван", Gender.MALE);
        Human mother = new Human("Анна", Gender.FEMALE);
        Human child1 = new Human("Алиса", Gender.FEMALE);
        Human child2 = new Human("Борис", Gender.MALE);

        // Добавление детей к родителям
        father.addChild(child1);
        father.addChild(child2);
        mother.addChild(child1);
        mother.addChild(child2);

        // Добавление людей в дерево
        familyTree.addMember(father);
        familyTree.addMember(mother);
        familyTree.addMember(child1);
        familyTree.addMember(child2);

        // Путь к файлу
        String filename = "resources/familyTree.dat";

        // Запись в файл
        FileHandler fileHandler = new FamilyTreeFileHandler();
        try {
            fileHandler.writeToFile(familyTree, filename);
            System.out.println("Family tree saved to file.");
        } catch (IOException e) {
            System.out.println("Error saving family tree: " + e.getMessage());
        }

        // Чтение из файла
        try {
            FamilyTree loadedFamilyTree = fileHandler.readFromFile(filename);
            System.out.println("Family tree loaded from file.");

            // Исследование дерева
            Human searchParent = loadedFamilyTree.findMemberByName("Иван");
            if (searchParent != null) {
                List<Human> children = loadedFamilyTree.getChildren(searchParent);
                System.out.println("Children of " + searchParent.getName() + ":");
                for (Human child : children) {
                    System.out.println(child);
                }
            } else {
                System.out.println("Parent not found in the family tree.");
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading family tree: " + e.getMessage());
        }
    }
}
