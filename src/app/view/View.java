package app.view;

import java.util.Scanner;

public class View implements IView {
    private Scanner scanner;

    public View() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void displayMenu() {
        System.out.println("1. Add Family Member");
        System.out.println("2. View Family Tree");
        System.out.println("3. Save Family Tree");
        System.out.println("4. Load Family Tree");
        System.out.println("0. Exit");
    }

    @Override
    public String getInput() {
        return scanner.nextLine();
    }

    @Override
    public void showMessage(String message) {
        System.out.println(message);
    }

    @Override
    public void displayFamilyTree(String familyTree) {
        System.out.println(familyTree);
    }
}
