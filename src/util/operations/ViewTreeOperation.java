package util.operations;

import app.model.FamilyTree;
import app.view.IView;
import util.IFamilyTreeStorage;

public class ViewTreeOperation implements FamilyTreeOperation {
    @Override
    public void execute(FamilyTree familyTree, IView view, IFamilyTreeStorage storage) {
        view.displayFamilyTree(familyTree.toString());
    }
}
