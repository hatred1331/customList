
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        CustomList<String> list = new CustomList<>();
        CustomList<String> newList = new CustomList<>();


        list.add("One");
        list.add("Two");
        list.add("Three");
        list.add("Four");
        list.add("Five");

        newList.add("el1");
        newList.add("el2");
        newList.add("el3");
        newList.add("el4");


        System.out.println(list);
        System.out.println(list.get(3));
        list.set(3, "new elem");
        System.out.println(list);
        System.out.println(list.get(3));
        System.out.println(list.size());
        list.remove(3);
        System.out.println(list);
        System.out.println(list.size());
        list.clear();
        System.out.println(list);
        System.out.println(list.size());
        System.out.println(list.isEmpty());

        list.addAll(newList);
        System.out.println(list);
        list.addAll(newList);
        System.out.println(list);
        list.sort();
        System.out.println(list);

    }
}