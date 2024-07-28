package Family_Tree.model;

import java.io.IOException;

public interface FileHandler {
    void writeToFile(FamilyTree familyTree, String filename) throws IOException;
    FamilyTree readFromFile(String filename) throws IOException, ClassNotFoundException;
}
