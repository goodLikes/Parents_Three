package Family_Tree.util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import Family_Tree.model.FamilyMember;
import Family_Tree.model.FamilyTree;
import Family_Tree.model.FileHandler;

public class FamilyTreeFileHandler<T extends FamilyMember> implements FileHandler<T> {
    @Override
    public void writeToFile(FamilyTree<T> familyTree, String filename) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(familyTree);
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public FamilyTree<T> readFromFile(String filename) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            return (FamilyTree<T>) ois.readObject();
        }
    }
}
