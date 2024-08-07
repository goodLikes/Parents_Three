package util.operations;

import app.model.FamilyMember;
import app.model.FamilyTree;
import app.view.IView;
import util.IFamilyTreeStorage;

import java.util.List;

public class FindMemberByNameOperation implements FamilyTreeOperation {
    @Override
    public void execute(FamilyTree familyTree, IView view, IFamilyTreeStorage storage) {
        view.showMessage(view.isRussian() ? "Введите имя для поиска:" : "Enter name to search:");
        String name = view.getInput();

        List<FamilyMember> foundMembers = familyTree.findMembersByName(name);

        if (foundMembers.isEmpty()) {
            view.showMessage(view.isRussian() ? "Члены семьи не найдены." : "No family members found.");
        } else {
            for (FamilyMember member : foundMembers) {
                view.showMessage(member.toString());
            }
        }
    }
}
