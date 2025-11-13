import java.util.Scanner;
@SuppressWarnings("unchecked")
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Fila de entrada (obrigatório pelo enunciado)
        Lista004<Integer> entrada = new Lista004<>();

        // lê até -1
        while (true) {
            if (!sc.hasNextInt()) break;
            int n = sc.nextInt();
            if (n == -1) break;
            entrada.enqueue(new Node<>(n));
        }

        // cria 10 buckets: 0-10, 11-20, ..., 91-100
        Lista004<Integer>[] buckets = new Lista004[10];
        for (int i = 0; i < buckets.length; i++) buckets[i] = new Lista004<>();

        // distribui valores da fila de entrada para os buckets
        Node<Integer> cur = entrada.getHead();
        while (cur != null) {
            int valor = cur.getData();

            // ignora negativos (além do -1 que já para a leitura)
            if (valor >= 0) {
                int index;
                if (valor == 0) index = 0;
                else index = (valor - 1) / 10; // 1..10 -> 0 ; 11..20 ->1 ; 100 -> 9

                if (index < 0) index = 0;
                if (index > 9) index = 9;

                buckets[index].enqueueSorted(valor);
            }

            cur = cur.getNext();
        }

        // imprime buckets na ordem e monta a fila ordenada final
        Lista004<Integer> ordenada = new Lista004<>();

        for (int i = 0; i < buckets.length; i++) {
            // limites do bucket
            int inicio = (i == 0) ? 0 : (i * 10) + 1;
            int fim = (i + 1) * 10;

            // se vazio, pula
            if (buckets[i].getHead() == null) continue;

            System.out.print("Bucket(" + inicio + "-" + fim + ") ");
            buckets[i].printList();
            System.out.println();

            // juntando na fila ordenada (cria novos nós)
            Node<Integer> n = buckets[i].getHead();
            while (n != null) {
                ordenada.enqueue(new Node<>(n.getData()));
                n = n.getNext();
            }
        }

        // imprime lista ordenada final
        ordenada.printList();
        System.out.println();
    }
}
