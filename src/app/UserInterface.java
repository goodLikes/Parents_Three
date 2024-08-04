package app;

import java.io.IOException;
import java.util.Scanner;

import app.model.FamilyMember;
import app.model.FamilyTree;
import app.model.Gender;
import util.FamilyTreeFileHandler;

public class UserInterface {
    private Scanner scanner;
    private FamilyTree familyTree;
    private FamilyTreeFileHandler fileHandler;

    public UserInterface(Scanner scanner, FamilyTree familyTree, FamilyTreeFileHandler fileHandler) {
        this.scanner = scanner;
        this.familyTree = familyTree;
        this.fileHandler = fileHandler;
    }

    public void start() {
        boolean exit = false;
        while (!exit) {
            printMenu();
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    addFamilyMember();
                    break;
                case 2:
                    viewFamilyTree();
                    break;
                case 3:
                    saveFamilyTree();
                    break;
                case 4:
                    loadFamilyTree();
                    break;
                case 0:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void printMenu() {
        System.out.println("1. Add Family Member");
        System.out.println("2. View Family Tree");
        System.out.println("3. Save Family Tree");
        System.out.println("4. Load Family Tree");
        System.out.println("0. Exit");
    }

    private void addFamilyMember() {
        try {
            System.out.println("Enter name:");
            String name = scanner.nextLine();
            System.out.println("Enter gender (MALE/FEMALE):");
            Gender gender = Gender.valueOf(scanner.nextLine().toUpperCase());
            System.out.println("Enter date of birth (yyyy-MM-dd):");
            String dob = scanner.nextLine();
            System.out.println("Enter ID:");
            int id = Integer.parseInt(scanner.nextLine());
            FamilyMember member = new FamilyMember(name, gender, dob, id);
            familyTree.addMember(member);
        } catch (Exception e) {
            System.out.println("Invalid input. Please try again.");
        }
    }

    private void viewFamilyTree() {
        System.out.println(familyTree);
    }

    private void saveFamilyTree() {
        System.out.println("Enter file name to save:");
        String fileName = scanner.nextLine();
        try {
            fileHandler.saveToFile(familyTree, fileName);
            System.out.println("Family tree saved successfully.");
        } catch (IOException e) {
            System.out.println("Error saving family tree: " + e.getMessage());
        }
    }

    private void loadFamilyTree() {
        System.out.println("Enter file name to load:");
        String fileName = scanner.nextLine();
        try {
            FamilyTree loadedTree = fileHandler.load(fileName);
            if (loadedTree != null) {
                this.familyTree = loadedTree;
                System.out.println("Family tree loaded successfully.");
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading family tree: " + e.getMessage());
        }
    }
}
