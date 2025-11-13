import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Lista004<T> extends Queue<T> {

    public Lista004() {
        super();
    }

    public void printList() {
        Map<Integer, Integer> frequencias = new HashMap<>();

        // Desenfileira todos os elementos e calcula as faixas
        while (!isEmpty()) {
            int valor = (Integer) dequeue().getData();
            int faixaInicio = (valor / 10) * 10;
            int faixaFim = faixaInicio + 10;
            int chave = faixaInicio; // chave = início da faixa

            frequencias.put(chave, frequencias.getOrDefault(chave, 0) + 1);
        }

        // Ordena por faixa inicial
        Map<Integer, Integer> ordenado = new TreeMap<>(frequencias);

        int count = 0;
        int total = ordenado.size();
        for (Map.Entry<Integer, Integer> entry : ordenado.entrySet()) {
            int inicio = entry.getKey();
            int fim = inicio + 10;
            int exibInicio = (inicio ==0 )? 0 : inicio + 1;
            System.out.print(exibInicio + "-" + fim + " " + entry.getValue());
            count++;
            if (count < total) System.out.println();
        }
    }
}
