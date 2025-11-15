import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Lista004<String[]> fila = new Lista004<>();

        while (sc.hasNextLine()) {
            String line = sc.nextLine().trim();
            if (line.isEmpty()) continue;

            String type = extrairValor(line); // type = simples

            String prop = extrairValor(sc.nextLine().trim()); // prop = nome
            String value = extrairValor(sc.nextLine().trim()); // value = carlos

            fila.enqueue(new Node<>(new String[]{ type, prop, value }));
        }

        fila.printJson();
    }

    private static String extrairValor(String linha) {
        return linha.split("=", 2)[1].trim();
    }
}
