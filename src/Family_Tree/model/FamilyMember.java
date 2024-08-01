package Family_Tree.model;

public class FamilyMember extends Human {
    private int id;

    public FamilyMember(String name, Gender gender, String dateOfBirth, int id) {
        super(name, gender, dateOfBirth);
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public String getDateOfBirth() {
        return super.getDateOfBirth();
    }

    @Override
    public String toString() {
        return super.toString() + ", ID: " + id;
    }
}
