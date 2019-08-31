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
    }
}
