package app.model;

import java.io.Serializable;

public class Relationship implements Serializable {
    private FamilyMember member1;
    private FamilyMember member2;
    private Type type;

    public Relationship(FamilyMember member1, FamilyMember member2, Type type) {
        this.member1 = member1;
        this.member2 = member2;
        this.type = type;
    }

    public enum Type {
        PARENT,
        CHILD,
        SPOUSE,
        SIBLING
    }

    @Override
    public String toString() {
        return member1.getName() + " is " + type.toString().toLowerCase() + " of " + member2.getName();
    }
}
