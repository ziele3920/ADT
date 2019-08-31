package pl.sda.List;

public class MainList {

    public static void main(String[] args) {
        IList list = new LinkedList();
        list.add(1);
        list.add(2);
        list.add(3);

        Object[] tab = list.getHolderView();

        for (Object val:tab)
            System.out.print(val + " ");
        System.out.println();

        int[] tabb =  {3, 1, 5, 11, 9};
        SelectionSort ss = new SelectionSort();
        int[] sorted = ss.sort(tabb);
        for(int v:sorted)
            System.out.print(v + ", ");
    }
}
