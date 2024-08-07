package util;

import app.model.FamilyTree;

import java.io.*;

public class FileStorage implements IFamilyTreeStorage {
    @Override
    public void save(FamilyTree tree, String fileName) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(tree);
        }
    }

    @Override
    public FamilyTree load(String fileName) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            return (FamilyTree) ois.readObject();
        }
    }
}
