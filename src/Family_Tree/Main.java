package Family_Tree;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import Family_Tree.model.FamilyTree;
import Family_Tree.model.FileHandler;
import Family_Tree.model.Gender;
import Family_Tree.model.Human;
import Family_Tree.util.FamilyTreeFileHandler;

public class Main {
    public static void main(String[] args) {
        FamilyTree familyTree = new FamilyTree();

        // Создание людей
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        try {
            Human father = new Human("Иван", Gender.MALE, sdf.parse("01-01-1980"));
            Human mother = new Human("Анна", Gender.FEMALE, sdf.parse("02-02-1982"));
            Human child1 = new Human("Алиса", Gender.FEMALE, sdf.parse("03-03-2010"));
            Human child2 = new Human("Борис", Gender.MALE, sdf.parse("04-04-2012"));

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

                // Сортировка по имени
                loadedFamilyTree.sortByName();
                System.out.println("\nFamily tree sorted by name:");
                for (Human member : loadedFamilyTree) {
                    System.out.println(member);
                }

                // Сортировка по дате рождения
                loadedFamilyTree.sortByDateOfBirth();
                System.out.println("\nFamily tree sorted by date of birth:");
                for (Human member : loadedFamilyTree) {
                    System.out.println(member);
                }
            } catch (IOException | ClassNotFoundException e) {
                System.out.println("Error loading family tree: " + e.getMessage());
            }
        } catch (ParseException e) {
            System.out.println("Date parsing error: " + e.getMessage());
        }
    }
}
