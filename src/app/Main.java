package app;

import app.model.FamilyTree;
import app.presenter.FamilyTreePresenter;
import app.view.ConsoleView;
import app.view.IView;
import util.FileStorage;
import util.IFamilyTreeStorage;

public class Main {
    public static void main(String[] args) {
        IView view = new ConsoleView();
        IFamilyTreeStorage storage = new FileStorage();
        FamilyTree familyTree = new FamilyTree();
        FamilyTreePresenter presenter = new FamilyTreePresenter(familyTree, view, storage);
        
        // Set the language to Russian (true) or English (false)
        ((ConsoleView) view).setLanguage(true); // Установите true для русского языка, false для английского

        presenter.run();
    }
}
