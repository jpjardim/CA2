package l00161844;

public class Main {
    public static void main(String[] args) {
//        GenericArrayList<String> g = new GenericArrayList<>();
//        g.add("a");
//        g.add("b");
//        g.add("c");
//        System.out.println(g.set(0, "b"));
//        System.out.println(g.toString());


//        GenericLinkedList<String> g = new GenericLinkedList<>();
//        g.add("a");
//        g.add("b");
//        g.add("c");
//        System.out.println(g.set(1,"1"));
//        g.printList();

//        GenericStack<String> g = new GenericStack<>();
//        g.push("1");
//        g.push("2");
//        g.push("3");
//        //System.out.println(g.toString());
//
//        //System.out.println(g.peek());
//        //System.out.println(g.pop());
//        g.pop();
//        System.out.println(g.toString());

        GenericQueue<String> g = new GenericQueue<>();
        g.enque("first");
        g.enque("second");
        g.enque("third");
        System.out.println(g.toString());
        System.out.println(g.dequeue());
        System.out.println(g.toString());
        System.out.println(g.dequeue());
        System.out.println(g.toString());
    }

}
