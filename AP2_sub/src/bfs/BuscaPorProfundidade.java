package bfs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BuscaPorProfundidade {
    int cont;
    private final int V;
    private boolean adj[][];

    public BuscaPorProfundidade(int V) {
        this.V = V;
        this.adj = new boolean[V][V];
    }

    public void adicionaAresta(int u, int v) {
        if(!adj[u][v]) {
            adj[u][v] = adj[v][u] = true;
        }
    }

    public List<Integer> getMenorCaminho(int s, int t) {
        int ant[] = new int[V];
        for(int w = 0; w < V; w++) {
            ant[w] = -1;
        }
        ant[s] = s;
        buscaEmLargura(s, ant);
        if(ant[t] == -1) return new ArrayList<>();
        List<Integer> caminho = new ArrayList<>();
        int w = t;
        while(w != ant[w]) {
            caminho.add(w);
            w = ant[w];
        }
        caminho.add(s);
        Collections.reverse(caminho);
        return caminho;
    }

    private void buscaEmLargura(int s, int[] ant) {
        Queue<Integer> fila = new LinkedList<>();
        fila.add(s);
        ant[s] = s;
        while(!fila.isEmpty()) {
            int u = fila.remove();
            for(int v = 0; v < V; v++) {
                if(adj[u][v] && ant[v] == -1) {
                    fila.add(v);
                    ant[v] = u;
                    cont++;
                }
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ligações feitas-->\n");
        for(int u = 0; u < V; u++) {
            stringBuilder.append(u + ":");
            for(int v = 0; v < V; v++) {
                if(adj[u][v]) {
                    stringBuilder.append(" " + v);
                }
            }
            stringBuilder.append('\n');
        }
        return stringBuilder.toString();
    }

    public int cont(){
        return  cont;
    }
    public void resetcont(){
        cont=0;
    }
}