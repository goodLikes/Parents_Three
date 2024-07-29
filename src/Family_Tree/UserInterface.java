package Family_Tree;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

import Family_Tree.model.FamilyTree;
import Family_Tree.model.FileHandler;
import Family_Tree.model.Gender;
import Family_Tree.model.Human;
import Family_Tree.util.FamilyTreeFileHandler;

public class UserInterface {
    private FamilyTree<Human> familyTree;
    private FileHandler<Human> fileHandler;
    private Scanner scanner;

    public UserInterface() {
        this.familyTree = new FamilyTree<>();
        this.fileHandler = new FamilyTreeFileHandler<>();
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        boolean running = true;

        while (running) {
            System.out.println("1. Add member");
            System.out.println("2. Save family tree");
            System.out.println("3. Load family tree");
            System.out.println("4. Find member by name");
            System.out.println("5. Get children of member");
            System.out.println("6. Sort by name");
            System.out.println("7. Sort by date of birth");
            System.out.println("8. Exit");

            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume the newline

            switch (choice) {
                case 1:
                    addMember();
                    break;
                case 2:
                    saveFamilyTree();
                    break;
                case 3:
                    loadFamilyTree();
                    break;
                case 4:
                    findMemberByName();
                    break;
                case 5:
                    getChildrenOfMember();
                    break;
                case 6:
                    sortByName();
                    break;
                case 7:
                    sortByDateOfBirth();
                    break;
                case 8:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void addMember() {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter gender (MALE/FEMALE): ");
        Gender gender = Gender.valueOf(scanner.nextLine().toUpperCase());
        System.out.print("Enter date of birth (dd-MM-yyyy HH:mm:ss): ");
        String dobString = scanner.nextLine();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

        try {
            Human newMember = new Human(name, gender, sdf.parse(dobString));
            familyTree.addMember(newMember);
            System.out.println("Member added.");
        } catch (ParseException e) {
            System.out.println("Invalid date format. Member not added.");
        }
    }

    private void saveFamilyTree() {
        System.out.print("Enter filename to save: ");
        String filename = scanner.nextLine();

        try {
            fileHandler.writeToFile(familyTree, filename);
            System.out.println("Family tree saved.");
        } catch (IOException e) {
            System.out.println("Error saving family tree: " + e.getMessage());
        }
    }

    private void loadFamilyTree() {
        System.out.print("Enter filename to load: ");
        String filename = scanner.nextLine();

        try {
            familyTree = fileHandler.readFromFile(filename);
            System.out.println("Family tree loaded.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading family tree: " + e.getMessage());
        }
    }

    private void findMemberByName() {
        System.out.print("Enter name to find: ");
        String name = scanner.nextLine();

        Human member = familyTree.findMemberByName(name);
        if (member != null) {
            System.out.println("Member found: " + member);
        } else {
            System.out.println("Member not found.");
        }
    }

    private void getChildrenOfMember() {
        System.out.print("Enter name of the parent: ");
        String name = scanner.nextLine();

        Human parent = familyTree.findMemberByName(name);
        if (parent != null) {
            List<Human> children = familyTree.getChildren(parent);
            System.out.println("Children of " + parent.getName() + ":");
            for (Human child : children) {
                System.out.println(child);
            }
        } else {
            System.out.println("Parent not found.");
        }
    }

    private void sortByName() {
        familyTree.sortByName();
        System.out.println("Family tree sorted by name:");
        for (Human member : familyTree) {
            System.out.println(member);
        }
    }

    private void sortByDateOfBirth() {
        familyTree.sortByDateOfBirth();
        System.out.println("Family tree sorted by date of birth:");
        for (Human member : familyTree) {
            System.out.println(member);
        }
    }

    public static void main(String[] args) {
        UserInterface ui = new UserInterface();
        ui.start();
    }
}
