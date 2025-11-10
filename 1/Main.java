import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Lista004<Integer> fila= new Lista004<>();
        while(true) {
            int v =sc.nextInt();
            if(v == -1) break;
            fila.enqueue(new Node<>(v));
        }
        fila.printList();
        int v =sc.nextInt();
        for(int i =0; i<v; i++) {
            fila.remove();
        }
        fila.printList();
        sc.close();
    }
}
