package util.operations;

import app.model.FamilyMember;
import app.model.FamilyTree;
import app.view.IView;
import util.IFamilyTreeStorage;

import java.util.List;

public class DeleteMemberOperation implements FamilyTreeOperation {
    @Override
    public void execute(FamilyTree familyTree, IView view, IFamilyTreeStorage storage) {
        List<FamilyMember> members = familyTree.getMembers();
        if (members.isEmpty()) {
            view.showMessage(view.isRussian() ? "Нет членов семьи для удаления." : "No family members to delete.");
            return;
        }

        view.showMessage(view.isRussian() ? "Выберите члена семьи для удаления:" : "Select family member to delete:");
        FamilyMember member = selectMember(members, view);

        familyTree.getMembers().remove(member);
        view.showMessage(view.isRussian() ? "Член семьи успешно удален." : "Family member deleted successfully.");
    }

    private FamilyMember selectMember(List<FamilyMember> members, IView view) {
        for (int i = 0; i < members.size(); i++) {
            view.showMessage(i + ": " + members.get(i));
        }
        int index = Integer.parseInt(view.getInput());
        return members.get(index);
    }
}
