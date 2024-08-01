package Family_Tree.util;

import java.util.Comparator;

import Family_Tree.model.FamilyMember;

public class NameComparator implements Comparator<FamilyMember> {
    @Override
    public int compare(FamilyMember o1, FamilyMember o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
