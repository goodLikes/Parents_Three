package util.operations;

import app.model.FamilyTree;
import app.view.IView;
import util.IFamilyTreeStorage;

public interface FamilyTreeOperation {
    void execute(FamilyTree familyTree, IView view, IFamilyTreeStorage storage);
}
