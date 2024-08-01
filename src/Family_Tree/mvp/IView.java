package Family_Tree.mvp;

public interface IView {
    void displayMenu();
    void displayFamilyTree(String familyTree);
    void showMessage(String message);
    String getInput();
}
