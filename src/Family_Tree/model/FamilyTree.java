package Family_Tree.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FamilyTree implements Serializable {
    private List<FamilyMember> members;

    public FamilyTree() {
        this.members = new ArrayList<>();
    }

    public void addMember(FamilyMember member) {
        members.add(member);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (FamilyMember member : members) {
            sb.append(member).append("\n");
        }
        return sb.toString();
    }
}
