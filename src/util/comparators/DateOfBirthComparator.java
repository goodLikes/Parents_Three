package util.comparators;

import app.model.FamilyMember;
import java.util.Comparator;

public class DateOfBirthComparator implements Comparator<FamilyMember> {
    @Override
    public int compare(FamilyMember o1, FamilyMember o2) {
        return o1.getDateOfBirth().compareTo(o2.getDateOfBirth());
    }
}
