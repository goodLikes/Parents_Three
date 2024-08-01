package Family_Tree.model;

public interface FileHandler<T> {
    void saveToFile(T obj, String fileName);
    T loadFromFile(String fileName);
}
