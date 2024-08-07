package app.view;

import java.util.Scanner;

public class ConsoleView implements IView {
    private final Scanner scanner;
    private boolean isRussian; // Поле для хранения состояния языка

    public ConsoleView() {
        this.scanner = new Scanner(System.in);
        this.isRussian = false; // По умолчанию язык английский
    }

    public void setLanguage(boolean isRussian) {
        this.isRussian = isRussian;
    }

    public boolean isRussian() {
        return isRussian;
    }

    @Override
    public void displayMenu() {
        if (isRussian) {
            System.out.println("1. Добавить члена семьи");
            System.out.println("2. Добавить отношение");
            System.out.println("3. Просмотреть семейное дерево");
            System.out.println("4. Сохранить семейное дерево");
            System.out.println("5. Загрузить семейное дерево");
            System.out.println("6. Удалить члена семьи");
            System.out.println("7. Изменить данные члена семьи");
            System.out.println("8. Найти члена семьи по имени");
            System.out.println("0. Выход");
        } else {
            System.out.println("1. Add Family Member");
            System.out.println("2. Add Relationship");
            System.out.println("3. View Family Tree");
            System.out.println("4. Save Family Tree");
            System.out.println("5. Load Family Tree");
            System.out.println("6. Delete Family Member");
            System.out.println("7. Edit Family Member");
            System.out.println("8. Find Family Member by Name");
            System.out.println("0. Exit");
        }
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
