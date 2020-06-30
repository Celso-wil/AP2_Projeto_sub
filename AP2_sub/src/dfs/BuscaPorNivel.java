package dfs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BuscaPorNivel {
        private final int V;
        int cont;
        private boolean adj[][];
        public BuscaPorNivel(int V) {
            this.V = V;
            this.adj = new boolean[V][V];
        }

        public void adicionaAresta(int u, int v) {
            if(!adj[u][v]) {
                adj[u][v] = adj[v][u] = true;
            }
        }

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

        public List<Integer> getCaminho(int s, int t) {
            int ant[] = new int[V];
            for(int w = 0; w < V; w++) {
                ant[w] = -1;
            }
            ant[s] = s;
            getCaminho(s, ant);
            if(ant[t] == -1) return new ArrayList<>();
            List<Integer> caminho = new ArrayList<>();
            int w = t;
            while(w != ant[w]) {
                caminho.add(w);
                w = ant[w];
                    cont++;
            }
            caminho.add(s);
            Collections.reverse(caminho);
            return caminho;
        }

        private void getCaminho(int u, int[] ant) {
            for(int v = 0; v < V; v++) {
                if(adj[u][v] && ant[v] == -1) {
                    ant[v] = u;
                    getCaminho(v, ant);
                }
            }
        }

        public int cont(){
                return cont;
        }
        public void resetcont(){
            cont=0;
        }
}

