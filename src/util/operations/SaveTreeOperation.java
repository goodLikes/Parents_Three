package util.operations;

import app.model.FamilyTree;
import app.view.IView;
import util.IFamilyTreeStorage;

import java.io.IOException;

public class SaveTreeOperation implements FamilyTreeOperation {
    @Override
    public void execute(FamilyTree familyTree, IView view, IFamilyTreeStorage storage) {
        view.showMessage(view.isRussian() ? "Введите имя файла для сохранения:" : "Enter file name to save:");
        String fileName = view.getInput();

        try {
            storage.save(familyTree, fileName);
            view.showMessage(view.isRussian() ? "Семейное дерево успешно сохранено." : "Family tree saved successfully.");
        } catch (IOException e) {
            view.showMessage(view.isRussian() ? "Ошибка при сохранении семейного дерева: " + e.getMessage() : "Error saving family tree: " + e.getMessage());
        }
    }
}
