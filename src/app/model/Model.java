package app.model;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import util.FamilyTreeFileHandler;

public class Model implements IModel, Serializable {
    private FamilyTree familyTree;

    public Model() {
        this.familyTree = new FamilyTree();
    }

    @Override
    public void addMember(FamilyMember member) {
        familyTree.addMember(member);
    }

    @Override
    public List<FamilyMember> getFamilyTree() {
        return new ArrayList<>(familyTree.getMembers()); 
    }

    @Override
    public void saveFamilyTree(String fileName) {
        try {
            new FamilyTreeFileHandler().saveToFile(familyTree, fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void loadFamilyTree(String fileName) {
        try {
            familyTree = new FamilyTreeFileHandler().load(fileName);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
