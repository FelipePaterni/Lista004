/** Implementação concreta que herda da Queue */
public class Lista004<T> extends Queue<T> {

    public Lista004() {
        super();
    }

    public void printList() {
        Node node = super.getHead();
        while(node != null) {
            System.out.print(node.getData());
            node = node.getNext();
            System.out.print("->");
        }
        System.out.println("/");
    }
}