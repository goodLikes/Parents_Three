package app.model;

import java.util.List;

public interface IModel {
    void addMember(FamilyMember member);
    List<FamilyMember> getFamilyTree();
    void saveFamilyTree(String fileName);
    void loadFamilyTree(String fileName);
}
