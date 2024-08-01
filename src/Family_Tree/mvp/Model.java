package Family_Tree.mvp;

import Family_Tree.model.FamilyMember;
import Family_Tree.model.FamilyTree;
import Family_Tree.util.FamilyTreeFileHandler;

public class Model implements IModel {
    private FamilyTree familyTree;
    private FamilyTreeFileHandler fileHandler;

    public Model() {
        this.familyTree = new FamilyTree();
        this.fileHandler = new FamilyTreeFileHandler();
    }

    @Override
    public void addMember(FamilyMember member) {
        familyTree.addMember(member);
    }

    @Override
    public FamilyTree getFamilyTree() {
        return familyTree;
    }

    @Override
    public void saveFamilyTree(String fileName) {
        fileHandler.saveToFile(familyTree, fileName);
    }

    @Override
    public FamilyTree loadFamilyTree(String fileName) {
        FamilyTree loadedTree = fileHandler.loadFromFile(fileName);
        if (loadedTree != null) {
            this.familyTree = loadedTree;
        }
        return familyTree;
    }
}
