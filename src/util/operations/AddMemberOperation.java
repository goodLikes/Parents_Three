package util.operations;

import app.model.FamilyMember;
import app.model.FamilyTree;
import app.model.Gender;
import app.view.IView;
import util.IFamilyTreeStorage;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class AddMemberOperation implements FamilyTreeOperation {
    @Override
    public void execute(FamilyTree familyTree, IView view, IFamilyTreeStorage storage) {
        if (view.isRussian()) {
            view.showMessage("Введите имя:");
        } else {
            view.showMessage("Enter name:");
        }
        String name = view.getInput();

        if (view.isRussian()) {
            view.showMessage("Введите пол (MALE/FEMALE/OTHER):");
        } else {
            view.showMessage("Enter gender (MALE/FEMALE/OTHER):");
        }
        Gender gender = Gender.valueOf(view.getInput().toUpperCase());

        if (view.isRussian()) {
            view.showMessage("Введите дату рождения (yyyy-MM-dd):");
        } else {
            view.showMessage("Enter date of birth (yyyy-MM-dd):");
        }
        LocalDate dateOfBirth = LocalDate.parse(view.getInput(), DateTimeFormatter.ISO_LOCAL_DATE);

        // Запрашиваем образование
        if (view.isRussian()) {
            view.showMessage("Введите образование:");
        } else {
            view.showMessage("Enter education:");
        }
        String education = view.getInput();

        // Запрашиваем профессию
        if (view.isRussian()) {
            view.showMessage("Введите профессию:");
        } else {
            view.showMessage("Enter profession:");
        }
        String profession = view.getInput();

        FamilyMember member = new FamilyMember(name, gender, dateOfBirth, education, profession);
        familyTree.addMember(member);
        if (view.isRussian()) {
            view.showMessage("Член семьи успешно добавлен.");
        } else {
            view.showMessage("Family member added successfully.");
        }
    }
}
