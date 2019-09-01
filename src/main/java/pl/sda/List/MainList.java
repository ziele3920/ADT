package pl.sda.List;

import java.util.ArrayList;
import java.util.List;

public class MainList {

    public static void main(String[] args) {
        QuickSort ss = new QuickSort();
        IList list = new LinkedList();
        list.add(5);
        list.add(1);
        list.add(2);
        list.add(5);
        list.add(7);
        list.add(0);
        list.add(4);
        list = ss.sort(list, 0, list.size() - 1);
        Object[] holder = list.getHolderView();
        for (Object val : holder)
            System.out.print(val + " ");
        System.out.println();
    }
}
