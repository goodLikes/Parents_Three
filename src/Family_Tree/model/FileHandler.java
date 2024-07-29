package Family_Tree.model;

import java.io.IOException;

public interface FileHandler<T extends FamilyMember> {
    void writeToFile(FamilyTree<T> familyTree, String filename) throws IOException;
    FamilyTree<T> readFromFile(String filename) throws IOException, ClassNotFoundException;
}
