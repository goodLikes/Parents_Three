package util.operations;

import app.model.FamilyMember;
import app.model.FamilyTree;
import app.model.Relationship;
import app.view.IView;
import util.IFamilyTreeStorage;

import java.util.List;

public class AddRelationshipOperation implements FamilyTreeOperation {
    @Override
    public void execute(FamilyTree familyTree, IView view, IFamilyTreeStorage storage) {
        List<FamilyMember> members = familyTree.getMembers();
        if (members.size() < 2) {
            if (view.isRussian()) {
                view.showMessage("Необходимо как минимум два члена семьи для добавления отношения.");
            } else {
                view.showMessage("You need at least two family members to add a relationship.");
            }
            return;
        }

        if (view.isRussian()) {
            view.showMessage("Выберите первого члена семьи:");
        } else {
            view.showMessage("Select first family member:");
        }
        FamilyMember member1 = selectMember(members, view);

        if (view.isRussian()) {
            view.showMessage("Выберите второго члена семьи:");
        } else {
            view.showMessage("Select second family member:");
        }
        FamilyMember member2 = selectMember(members, view);

        if (view.isRussian()) {
            view.showMessage("Выберите тип отношения (PARENT, CHILD, SPOUSE, SIBLING):");
        } else {
            view.showMessage("Select relationship type (PARENT, CHILD, SPOUSE, SIBLING):");
        }
        Relationship.Type type = Relationship.Type.valueOf(view.getInput().toUpperCase());

        familyTree.addRelationship(member1, member2, type);
        if (view.isRussian()) {
            view.showMessage("Отношение успешно добавлено.");
        } else {
            view.showMessage("Relationship added successfully.");
        }
    }

    private FamilyMember selectMember(List<FamilyMember> members, IView view) {
        for (int i = 0; i < members.size(); i++) {
            view.showMessage(i + ": " + members.get(i));
        }
        int index = Integer.parseInt(view.getInput());
        return members.get(index);
    }
}
