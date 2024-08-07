package util.operations;

import app.model.FamilyTree;
import app.view.IView;
import util.IFamilyTreeStorage;

import java.io.IOException;

public class LoadTreeOperation implements FamilyTreeOperation {
    @Override
    public void execute(FamilyTree familyTree, IView view, IFamilyTreeStorage storage) {
        view.showMessage(view.isRussian() ? "Введите имя файла для загрузки:" : "Enter file name to load:");
        String fileName = view.getInput();

        try {
            FamilyTree loadedTree = storage.load(fileName);
            familyTree.getMembers().clear();
            familyTree.getMembers().addAll(loadedTree.getMembers());
            familyTree.getRelationships().clear();
            familyTree.getRelationships().addAll(loadedTree.getRelationships());
            view.showMessage(view.isRussian() ? "Семейное дерево успешно загружено." : "Family tree loaded successfully.");
        } catch (IOException | ClassNotFoundException e) {
            view.showMessage(view.isRussian() ? "Ошибка при загрузке семейного дерева: " + e.getMessage() : "Error loading family tree: " + e.getMessage());
        }
    }
}
