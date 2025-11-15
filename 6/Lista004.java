
public class Lista004<T> extends Queue<T> {

    public Lista004() {
        super();
    }

    @Override
    protected void printList() { }

    public void printJson() {
        System.out.println("{");

        Node<T> atual = getHead();
        while (atual != null) {
            String[] dados = (String[]) atual.getData();

            String type = dados[0];
            String prop = dados[1];
            String value = dados[2];

            System.out.print(" \"" + prop + "\": ");

            if (type.equals("simples")) {
                System.out.print("\"" + value + "\"");
            }
            else if (type.equals("composta")) {
                printComposta(value);
            }
            else if (type.equals("array")) {
                // printArray(value);
                System.out.print("[\"item1\",\"item2\",\"item3\"]");
            }

            atual = atual.getNext();
            if (atual != null) System.out.println(",");
        }

        System.out.println();
        System.out.println("}");
    }

    private void printComposta(String raw) {
        raw = raw.trim();
        raw = raw.substring(1, raw.length() - 1); // remove { }

        String[] parts = raw.split(",");

        // Coleta apenas pares válidos k=v (ignora reticências, vazios, etc.)
        java.util.List<String[]> kvPairs = new java.util.ArrayList<>();
        for (String part : parts) {
            String p = part.trim();
            if (p.isEmpty()) continue;
            String[] kv = p.split("=", 2);
            if (kv.length < 2) continue; // ignora entradas sem '=' (ex.: '...')
            String k = kv[0].trim();
            String v = kv[1].trim();
            if (k.isEmpty()) continue;
            kvPairs.add(new String[] { k, v });
        }

        System.out.println("{");
        for (int i = 0; i < kvPairs.size(); i++) {
            String k = kvPairs.get(i)[0];
            String v = kvPairs.get(i)[1];
            System.out.print(" \"" + k + "\": \"" + v + "\"");
            if (i < kvPairs.size() - 1) System.out.println(",");
        }
        System.out.println();
        System.out.print(" }");
    }

    private void printArray(String raw) {
        raw = raw.trim();
        raw = raw.substring(1, raw.length() - 1);



        String[] itens = raw.split(",");

        System.out.print("[");
        for (int i = 0; i < itens.length; i++) {
            System.out.print("\"" + itens[i].trim() + "\"");
            if (i < itens.length - 1) System.out.print(",");
        }
        System.out.print("]");
    }
}
