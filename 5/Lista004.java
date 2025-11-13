/** Implementação concreta que herda da Queue */
public class Lista004<T> extends Queue<T> {

    public Lista004() { super(); }

    public void printList() {
        System.out.println("{");

        Node<T> bloco = getHead();
        while (bloco != null) {
            @SuppressWarnings("unchecked")
            String[][] prop = (String[][]) bloco.getData();

            System.out.print("  \"" + prop[0][0] + "\": [");

            String[] itens = prop[1];
            for (int i = 0; i < itens.length; i++) {
                System.out.print("\"" + itens[i] + "\"");
                if (i < itens.length - 1) System.out.print(",");
            }

            System.out.print("]");
            bloco = bloco.getNext();
            if (bloco != null)
                System.out.println(",");
        }

        System.out.println();
        System.out.print("}");
    }
}
