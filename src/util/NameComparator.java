package util;

import java.util.Comparator;

import app.model.FamilyMember;

public class NameComparator implements Comparator<FamilyMember> {
    @Override
    public int compare(FamilyMember o1, FamilyMember o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
