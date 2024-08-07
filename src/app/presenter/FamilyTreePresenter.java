package app.presenter;

import app.model.FamilyTree;
import app.view.IView;
import util.IFamilyTreeStorage;
import util.operations.*;

public class FamilyTreePresenter implements IPresenter {
    private FamilyTree familyTree;
    private IView view;
    private IFamilyTreeStorage storage;

    public FamilyTreePresenter(FamilyTree familyTree, IView view, IFamilyTreeStorage storage) {
        this.familyTree = familyTree;
        this.view = view;
        this.storage = storage;
    }

    @Override
    public void run() {
        boolean exit = false;
        while (!exit) {
            view.displayMenu();
            String choice = view.getInput();

            switch (choice) {
                case "1":
                    new AddMemberOperation().execute(familyTree, view, storage);
                    break;
                case "2":
                    new AddRelationshipOperation().execute(familyTree, view, storage);
                    break;
                case "3":
                    new ViewTreeOperation().execute(familyTree, view, storage);
                    break;
                case "4":
                    new SaveTreeOperation().execute(familyTree, view, storage);
                    break;
                case "5":
                    new LoadTreeOperation().execute(familyTree, view, storage);
                    break;
                case "6":
                    new DeleteMemberOperation().execute(familyTree, view, storage);
                    break;
                case "7":
                    new EditMemberOperation().execute(familyTree, view, storage);
                    break;
                case "8":
                    new FindMemberByNameOperation().execute(familyTree, view, storage);
                    break;
                case "0":
                    exit = true;
                    break;
                default:
                    view.showMessage(view.isRussian() ? "Неверный выбор. Пожалуйста, попробуйте снова." : "Invalid choice. Please try again.");
            }
        }
    }
}
