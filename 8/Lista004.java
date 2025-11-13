public class Lista004<T extends Comparable<T>> extends Queue<T> {

    public Lista004() {
        super();
    }

    @Override
    public void printList() {
        Node<T> aux = getHead();
        boolean first = true;
        while (aux != null) {
            if (!first) System.out.print(" ");
            System.out.print(aux.getData());
            first = false;
            aux = aux.getNext();
        }
    }

    /**
     * Enfileira mantendo a ordem ascendente dentro da fila.
     * Não usa dequeue() (problemático na implementação base).
     */
    public void enqueueSorted(T value) {
        Node<T> novo = new Node<>(value);

        // lista vazia -> append (enqueue)
        if (getHead() == null) {
            enqueue(novo);
            return;
        }

        Node<T> atual = getHead();

        // inserir no início se for menor ou igual ao head
        if (value.compareTo(atual.getData()) <= 0) {
            insert(novo); // método protegido da LinearList
            return;
        }

        // percorre para encontrar o local de inserção
        while (atual.getNext() != null && value.compareTo(atual.getNext().getData()) > 0) {
            atual = atual.getNext();
        }

        // se chegou ao final -> append
        if (atual.getNext() == null) {
            append(novo);
            return;
        }

        // insere entre 'atual' e 'atual.getNext()'
        Node<T> proximo = atual.getNext();
        atual.setNext(novo);
        novo.setPrev(atual);
        novo.setNext(proximo);
        proximo.setPrev(novo);
    }
}
