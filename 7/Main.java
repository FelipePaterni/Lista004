import java.util.LinkedHashMap;
import java.util.Map;

class Fila<T> {
    private java.util.LinkedList<T> itens = new java.util.LinkedList<>();

    public void enfileirar(T item) {
        itens.addLast(item);
    }

    public T desenfileirar() {
        if (!vazia()) return itens.removeFirst();
        return null;
    }

    public boolean vazia() {
        return itens.isEmpty();
    }
}

public class Main {
    public static void main(String[] args) {
        String frase = "Teste do tesla para toda vez que ocorrer um erro";

        Fila<String> filaPalavras = new Fila<>();
        for (String palavra : frase.split(" ")) filaPalavras.enfileirar(palavra);

        Map<Character, Integer> contagem = new LinkedHashMap<>();

        while (!filaPalavras.vazia()) {
            String palavra = filaPalavras.desenfileirar();
            char inicial = palavra.charAt(0);
            contagem.put(inicial, contagem.getOrDefault(inicial, 0) + 1);
        }

        Fila<String> filaResultado = new Fila<>();
        for (Map.Entry<Character, Integer> e : contagem.entrySet())
            filaResultado.enfileirar(e.getValue() + " " + e.getKey());

        while (!filaResultado.vazia())
            System.out.println(filaResultado.desenfileirar());
    }
}