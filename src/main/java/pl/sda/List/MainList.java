package pl.sda.List;

public class MainList {

    public static void main(String[] args) {
        IList list = new LinkedList();
        list.add(1);
        list.add(2);
        list.add(3);

        long[] tab = list.getHolderView();
        list.remove(2);
        System.out.println(list.get(2));

        for (long val:tab)
            System.out.print(val + " ");
    }
}
