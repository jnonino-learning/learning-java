package jnonino.nestedlist;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jnonino on 30/01/2017.
 */
public class NestedListTest {

    @Test
    public void firstTest() {
        NestedList root = new NestedList(1);
        NestedList i2 = new NestedList(2);
        NestedList i3 = new NestedList(3);
        NestedList i4 = new NestedList(4);

        List<NestedList> rootChild = new ArrayList<NestedList>();
        rootChild.add(i2);
        root.setChildLists(rootChild);

        List<NestedList> i2Child = new ArrayList<NestedList>();
        i2Child.add(i3);
        i2Child.add(i4);
        i2.setChildLists(i2Child);

        int expected = 26;
        int actual = root.depthSum();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void secondTest() {
        NestedList root = new NestedList(1);
        NestedList i2 = new NestedList(2);
        NestedList i3 = new NestedList(3);

        List<NestedList> rootChild = new ArrayList<NestedList>();
        rootChild.add(i2);
        rootChild.add(i3);
        root.setChildLists(rootChild);

        int expected = 11;
        int actual = root.depthSum();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void thirdTest() {
        NestedList root = new NestedList(1);
        NestedList i2 = new NestedList(2);
        NestedList i3 = new NestedList(3);

        List<NestedList> rootChild = new ArrayList<NestedList>();
        rootChild.add(i2);
        root.setChildLists(rootChild);

        List<NestedList> i2Child = new ArrayList<NestedList>();
        i2Child.add(i3);
        i2.setChildLists(i2Child);

        int expected = 14;
        int actual = root.depthSum();
        Assert.assertEquals(expected, actual);
    }
}
