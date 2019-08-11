package pl.sda.List;

public class MainList {

    public static void main(String[] args) {
        IList<Long> list = new LinkedList<Long>();
        list.add(1L);
        list.add(2L);
        list.add(3L);

        Object[] tab = list.getHolderView();

        for (int i = 0; i < tab.length; ++i)
            System.out.print(tab[i] + " ");
    }
}
