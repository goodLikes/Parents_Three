package util;

import app.model.FamilyTree;
import java.io.IOException;

public interface IFamilyTreeStorage {
    void save(FamilyTree tree, String fileName) throws IOException;
    FamilyTree load(String fileName) throws IOException, ClassNotFoundException;
}
