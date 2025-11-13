import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Lista004<String> fila = new Lista004<>();
        while(true) {
            String key = sc.nextLine();
            if(key.equals("-1")) break;
            String value = sc.nextLine();
            if(key.equals("-1")) break;
            fila.enqueue(new Node<>(key+" = "+value));
        }
		fila.printList();
        sc.close();
    }
}
