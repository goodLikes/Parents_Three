package util.operations;

import app.model.FamilyMember;
import app.model.FamilyTree;
import app.model.Gender;
import app.view.IView;
import util.IFamilyTreeStorage;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class EditMemberOperation implements FamilyTreeOperation {
    @Override
    public void execute(FamilyTree familyTree, IView view, IFamilyTreeStorage storage) {
        List<FamilyMember> members = familyTree.getMembers();
        if (members.isEmpty()) {
            view.showMessage(view.isRussian() ? "Нет членов семьи для редактирования." : "No family members to edit.");
            return;
        }

        view.showMessage(view.isRussian() ? "Выберите члена семьи для редактирования:" : "Select family member to edit:");
        FamilyMember member = selectMember(members, view);

        view.showMessage(view.isRussian() ? "Введите новое имя:" : "Enter new name:");
        String name = view.getInput();

        view.showMessage(view.isRussian() ? "Введите новый пол (MALE/FEMALE/OTHER):" : "Enter new gender (MALE/FEMALE/OTHER):");
        Gender gender = Gender.valueOf(view.getInput().toUpperCase());

        view.showMessage(view.isRussian() ? "Введите новую дату рождения (yyyy-MM-dd):" : "Enter new date of birth (yyyy-MM-dd):");
        LocalDate dateOfBirth = LocalDate.parse(view.getInput(), DateTimeFormatter.ISO_LOCAL_DATE);

        // Запрашиваем новое образование
        view.showMessage(view.isRussian() ? "Введите новое образование:" : "Enter new education:");
        String education = view.getInput();

        // Запрашиваем новую профессию
        view.showMessage(view.isRussian() ? "Введите новую профессию:" : "Enter new profession:");
        String profession = view.getInput();

        member.setName(name);
        member.setGender(gender);
        member.setDateOfBirth(dateOfBirth);
        member.setEducation(education);
        member.setProfession(profession);

        view.showMessage(view.isRussian() ? "Данные члена семьи успешно обновлены." : "Family member details updated successfully.");
    }

    private FamilyMember selectMember(List<FamilyMember> members, IView view) {
        for (int i = 0; i < members.size(); i++) {
            view.showMessage(i + ": " + members.get(i));
        }
        int index = Integer.parseInt(view.getInput());
        return members.get(index);
    }
}
