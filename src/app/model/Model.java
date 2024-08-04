package app.model;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import util.FamilyTreeFileHandler;

public class Model implements IModel, Serializable {
    private FamilyTree familyTree;
    private final FamilyTreeFileHandler fileHandler;

    public Model(FamilyTreeFileHandler fileHandler) {
        this.familyTree = new FamilyTree();
        this.fileHandler = fileHandler;
    }

    @Override
    public void addMember(FamilyMember member) {
        familyTree.addMember(member);
    }

    @Override
    public List<FamilyMember> getFamilyTree() {
        return new ArrayList<>(familyTree.getMembers());
    }

    public void saveFamilyTree(String fileName) throws IOException {
        fileHandler.saveToFile(familyTree, fileName);
    }

    public void loadFamilyTree(String fileName) throws IOException, ClassNotFoundException {
        this.familyTree = fileHandler.load(fileName);
    }
}
