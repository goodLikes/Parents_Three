package Family_Tree.util;

import java.util.Comparator;

import Family_Tree.model.FamilyMember;

public class DateOfBirthComparator implements Comparator<FamilyMember> {
    @Override
    public int compare(FamilyMember o1, FamilyMember o2) {
        return o1.getDateOfBirth().compareTo(o2.getDateOfBirth());
    }
}
