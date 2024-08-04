package app.presenter;

import app.model.FamilyMember;
import app.model.Gender;
import app.model.IModel;
import app.view.IView;

public class Presenter implements IPresenter {
    private IModel model;
    private IView view;

    public Presenter(IModel model, IView view) {
        this.model = model;
        this.view = view;
    }

    @Override
    public void start() {
        boolean exit = false;
        while (!exit) {
            view.displayMenu();
            int choice = Integer.parseInt(view.getInput());
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
                    view.showMessage("Invalid choice. Please try again.");
            }
        }
    }

    @Override
    public void addFamilyMember() {
        try {
            view.showMessage("Enter name:");
            String name = view.getInput();
            view.showMessage("Enter gender (MALE/FEMALE):");
            Gender gender = Gender.valueOf(view.getInput().toUpperCase());
            view.showMessage("Enter date of birth (yyyy-MM-dd):");
            String dob = view.getInput();
            view.showMessage("Enter ID:");
            int id = Integer.parseInt(view.getInput());
            FamilyMember member = new FamilyMember(name, gender, dob, id);
            model.addMember(member);
        } catch (Exception e) {
            view.showMessage("Invalid input. Please try again.");
        }
    }

    @Override
    public void viewFamilyTree() {
        view.displayFamilyTree(model.getFamilyTree().toString());
    }

    @Override
    public void saveFamilyTree() {
        view.showMessage("Enter file name to save:");
        String fileName = view.getInput();
        model.saveFamilyTree(fileName);
    }

    @Override
    public void loadFamilyTree() {
        view.showMessage("Enter file name to load:");
        String fileName = view.getInput();
        model.loadFamilyTree(fileName);
    }
}
