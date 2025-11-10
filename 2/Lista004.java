
/** Implementação concreta que herda da Queue */
public class Lista004<T> extends Queue<T> {

    public Lista004() {
        super();
    }
    public void printList() {
        Node<T> aux = getHead();
        while(aux != null) {
            System.out.println(aux.getData());
            aux = aux.getNext();
        }
    }
}
