package Family_Tree.util;

import java.util.Comparator;

import Family_Tree.model.FamilyMember;

public class NameComparator<T extends FamilyMember> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
