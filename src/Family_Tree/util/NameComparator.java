package Family_Tree.util;

import java.util.Comparator;

import Family_Tree.model.Human;

public class NameComparator implements Comparator<Human> {
    @Override
    public int compare(Human o1, Human o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
