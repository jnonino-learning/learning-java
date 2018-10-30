package jnonino.nestedlist;

import jnonino.movies.MoviesAnalyzer;

import java.util.*;

/**
 * Created by jnonino on 30/01/2017.
 */
public class NestedList {

    private int value;
    private List<NestedList> childLists;

    public NestedList(int val) {
        this.childLists = new ArrayList<NestedList>();
        this.value = val;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public List<NestedList> getChildLists() {
        return childLists;
    }

    public void setChildLists(List<NestedList> childLists) {
        this.childLists = childLists;
    }

    public int depthSum() {
        return calculateSum(this, 1);
    }

    private int calculateSum(NestedList nestedList, int depth) {
        int result = nestedList.getValue() * depth;
        for (NestedList nested : nestedList.getChildLists()) {
            int newDepth = depth + 1;
            result += calculateSum(nested, newDepth);
        }
        return result;
    }
}
