import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Lista004<String[][]> fila = new Lista004<>();

        while (true) {
            String nome = sc.nextLine().trim();
            if (nome.equals("-1")) break;

            Lista004<String> itens = new Lista004<>();

            while (true) {
                String linha = sc.nextLine().trim();
                if (linha.equals("-1")) break;
                itens.enqueue(new Node<>(linha));
            }

            List<String> lista = new ArrayList<>();
            Node<String> aux = itens.getHead();
            while (aux != null) {
                lista.add(aux.getData());
                aux = aux.getNext();
            }

            String[][] prop = new String[2][];
            prop[0] = new String[]{nome};
            prop[1] = lista.toArray(new String[0]);

            fila.enqueue(new Node<>(prop));
        }

        fila.printList();
    }
}
