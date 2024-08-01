package Family_Tree.mvp;

import Family_Tree.model.FamilyMember;
import Family_Tree.model.FamilyTree;

public interface IModel {
    void addMember(FamilyMember member);
    FamilyTree getFamilyTree();
    void saveFamilyTree(String fileName);
    FamilyTree loadFamilyTree(String fileName);
}
