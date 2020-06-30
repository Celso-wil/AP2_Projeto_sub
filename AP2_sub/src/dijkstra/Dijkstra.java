package dijkstra;
import java.util.*;

public class Dijkstra {


    private static final int UNDEFINED = -1;
    private int vertices[][];

    public Dijkstra(int nV) {
        vertices = new int[nV][nV];
    }

    public void distancia(int vertex1, int vertex2, int distancia) {
        vertices[vertex1][vertex2] = distancia;
        vertices[vertex2][vertex1] = distancia;
    }

    public int custo(int vertex1, int vertex2) {
        return vertices[vertex1][vertex2];
    }

    public List<Integer> vizinho(int vertex) {
        List<Integer> vizinha = new ArrayList<>();
        for (int i = 0; i < vertices[vertex].length; i++)
            if (vertices[vertex][i] > 0) {
                vizinha.add(i);
            }
        return vizinha;
    }

    public List<Integer> caminho(int inicio, int destino) {
        int cust[] = new int[vertices.length];
        int prev[] = new int[vertices.length];
        Set<Integer> Nvisitado = new HashSet<>();
        cust[inicio] = 0;
        for (int v = 0; v < vertices.length; v++) {
            if (v != inicio) {
                cust[v] = Integer.MAX_VALUE;
            }
            prev[v] = UNDEFINED;
            Nvisitado.add(v);
        }
        while (!Nvisitado.isEmpty()) {
            int perto = Mperto(cust, Nvisitado);
            Nvisitado.remove(perto);
            for (Integer vizinha : vizinho(perto)) {
                int totalCust = cust[perto] + custo(perto, vizinha);
                if (totalCust < cust[vizinha]) {
                    cust[vizinha] = totalCust;
                    prev[vizinha] = perto;
                }
            }
            if (perto == destino) {
                return FazerCaminho(prev, perto);
            }
        }
        return Collections.emptyList();
    }

    private int Mperto(int[] dist, Set<Integer> Nvisitado) {
        double minDist = Integer.MAX_VALUE;
        int minIndex = 0;
        for (Integer i : Nvisitado) {
            if (dist[i] < minDist) {
                minDist = dist[i];
                minIndex = i;
            }
        }
        return minIndex;
    }

    private List<Integer> FazerCaminho(int[] prev, int u) {
        List<Integer> caminho = new ArrayList<>();
        caminho.add(u);
        while (prev[u] != UNDEFINED) {
            caminho.add(prev[u]);
            u = prev[u];
        }
        Collections.reverse(caminho);
        return caminho;
    }
}