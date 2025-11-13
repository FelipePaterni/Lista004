import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Lista004<String> fila = new Lista004<>();

        while(true) {
            String line = sc.nextLine();
            if(line.equals("-1")) break;
            fila.enqueue(new Node<>(line));

        }
        int[] prio = new int[5];
        while(true) {


            Node<String> n = fila.dequeue();
            if(n ==null) break;

            String s = n.getData();
            if(s.contains("10")) prio[0]++;
            else if(s.contains("10")) prio[0]++;
            else if(s.contains("20")) prio[1]++;
            else if(s.contains("30")) prio[2]++;
            else if(s.contains("40")) prio[3]++;
            else if(s.contains("50")) prio[4]++;
        }

		
        for( int i =1; i < 5; i++) {
            System.out.println((i*10) +" "+ prio[i-1]);
        }
		System.out.print((50) +" "+ prio[4]);
        sc.close();
    }
}
