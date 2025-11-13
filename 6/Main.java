import java.util.*;

public class Main {
    public static void main(String[] args) {
        PropertyQueue fila = new PropertyQueue();

        // Exemplo de inserção — poderia vir do Scanner
        fila.enqueue(new Node<>(new Property("simples", "nome", "carlos")));
        fila.enqueue(new Node<>(new Property("composta", "itens", "{item1 = value1, item2 = value2}")));
        fila.enqueue(new Node<>(new Property("array", "indices", "[10,20,30,40]")));

        // Processa e imprime JSON
        String json = fila.toJson();
        System.out.println(json);
    }
}

class Property {
    String type;
    String prop;
    String value;

    public Property(String type, String prop, String value) {
        this.type = type.trim();
        this.prop = prop.trim();
        this.value = value.trim();
    }
}

class PropertyQueue extends Queue<Property> {
    @Override
    protected void printList() {} // obrigatório da classe base, não usado

    public String toJson() {
        StringBuilder simples = new StringBuilder();
        StringBuilder compostas = new StringBuilder();
        StringBuilder arrays = new StringBuilder();

        Node<Property> atual = getHead();
        while (atual != null) {
            Property p = atual.getData();
            switch (p.type.toLowerCase()) {
                case "simples":
                    simples.append(String.format("  \"%s\": \"%s\",\n", p.prop, p.value));
                    break;

                case "composta":
                    compostas.append(String.format("  \"%s\": %s,\n",
                            p.prop, formatComposta(p.value)));
                    break;

                case "array":
                    arrays.append(String.format("  \"%s\": %s,\n",
                            p.prop, formatArray(p.value)));
                    break;
            }
            atual = atual.getNext();
        }

        // monta o JSON final
        StringBuilder json = new StringBuilder("{\n");
        json.append(simples);
        json.append(compostas);
        json.append(arrays);

        // remove vírgula final
        if (json.lastIndexOf(",") == json.length() - 2)
            json.deleteCharAt(json.length() - 2);

        json.append("}");
        return json.toString();
    }

    private String formatComposta(String raw) {
        // ex: {item1 = value1, item2 = value2}
        raw = raw.replaceAll("[{}]", "");
        String[] parts = raw.split(",");
        StringBuilder sb = new StringBuilder("{\n");
        for (String part : parts) {
            String[] kv = part.split("=");
            if (kv.length == 2)
                sb.append(String.format("  \"%s\": \"%s\",\n",
                        kv[0].trim(), kv[1].trim()));
        }
        if (sb.lastIndexOf(",") == sb.length() - 2)
            sb.deleteCharAt(sb.length() - 2);
        sb.append("  }");
        return sb.toString();
    }

    private String formatArray(String raw) {
        // ex: [10,20,30,40]
        raw = raw.replaceAll("[\\[\\]]", "");
        String[] parts = raw.split(",");
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < parts.length; i++) {
            sb.append("\"").append(parts[i].trim()).append("\"");
            if (i < parts.length - 1) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
}

