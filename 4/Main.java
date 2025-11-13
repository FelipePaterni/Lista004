import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Lista004<Integer> fila = new Lista004<>();

        while (true) {
            int valor = sc.nextInt();
            if (valor == -1) break;
            fila.enqueue(new Node<>(valor));
        }

        fila.printList();
        sc.close();
    }
}
