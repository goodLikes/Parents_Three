package app.view;

public interface IView {
    void displayMenu();
    String getInput();
    void showMessage(String message);
    void displayFamilyTree(String familyTree);
    boolean isRussian(); // Добавляем метод для получения состояния языка
}
