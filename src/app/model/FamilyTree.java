package app.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FamilyTree implements Serializable {
    private List<FamilyMember> members;
    private List<Relationship> relationships;

    public FamilyTree() {
        this.members = new ArrayList<>();
        this.relationships = new ArrayList<>();
    }

    public void addMember(FamilyMember member) {
        members.add(member);
    }

    public void addRelationship(FamilyMember member1, FamilyMember member2, Relationship.Type type) {
        relationships.add(new Relationship(member1, member2, type));
    }

    public List<FamilyMember> getMembers() {
        return members;
    }

    public List<Relationship> getRelationships() {
        return relationships;
    }

    public List<FamilyMember> findMembersByName(String name) {
        List<FamilyMember> foundMembers = new ArrayList<>();
        for (FamilyMember member : members) {
            if (member.getName().equalsIgnoreCase(name)) {
                foundMembers.add(member);
            }
        }
        return foundMembers;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (FamilyMember member : members) {
            builder.append(member).append("\n");
        }
        for (Relationship relationship : relationships) {
            builder.append(relationship).append("\n");
        }
        return builder.toString();
    }
}
